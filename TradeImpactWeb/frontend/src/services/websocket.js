class WebSocketService {
  constructor() {
    this.ws = null;
    this.listeners = new Map();
    this.reconnectAttempts = 0;
    this.maxReconnectAttempts = 5;
    this.reconnectDelay = 3000;
    this.isConnecting = false;
  }

  connect() {
    if (this.ws?.readyState === WebSocket.OPEN || this.isConnecting) {
      return;
    }

    this.isConnecting = true;
    const protocol = window.location.protocol === 'https:' ? 'wss:' : 'ws:';
    const url = `${protocol}//${window.location.host}/ws/marketdata`;

    try {
      this.ws = new WebSocket(url);

      this.ws.onopen = () => {
        console.log('WebSocket connected');
        this.isConnecting = false;
        this.reconnectAttempts = 0;
        this.notifyListeners('connected', null);
      };

      this.ws.onmessage = (event) => {
        try {
          const message = JSON.parse(event.data);
          this.handleMessage(message);
        } catch (error) {
          console.error('Error parsing WebSocket message:', error);
        }
      };

      this.ws.onerror = (error) => {
        console.error('WebSocket error:', error);
        this.isConnecting = false;
        this.notifyListeners('error', error);
      };

      this.ws.onclose = () => {
        console.log('WebSocket disconnected');
        this.isConnecting = false;
        this.notifyListeners('disconnected', null);
        this.attemptReconnect();
      };
    } catch (error) {
      console.error('Error creating WebSocket:', error);
      this.isConnecting = false;
      this.attemptReconnect();
    }
  }

  disconnect() {
    if (this.ws) {
      this.ws.close();
      this.ws = null;
    }
    this.reconnectAttempts = this.maxReconnectAttempts; // Prevent auto-reconnect
  }

  attemptReconnect() {
    if (this.reconnectAttempts >= this.maxReconnectAttempts) {
      console.log('Max reconnect attempts reached');
      return;
    }

    this.reconnectAttempts++;
    console.log(`Reconnecting... attempt ${this.reconnectAttempts}/${this.maxReconnectAttempts}`);
    
    setTimeout(() => {
      this.connect();
    }, this.reconnectDelay);
  }

  handleMessage(message) {
    switch (message.type) {
      case 'schema':
        this.notifyListeners('schema', message);
        break;
      case 'data':
        this.notifyListeners('data', message);
        break;
      case 'snapshot':
        this.notifyListeners('snapshot', message);
        break;
      case 'error':
        this.notifyListeners('error', message);
        break;
      default:
        console.warn('Unknown message type:', message.type);
    }
  }

  send(message) {
    if (this.ws?.readyState === WebSocket.OPEN) {
      this.ws.send(JSON.stringify(message));
    } else {
      console.warn('WebSocket not connected');
    }
  }

  subscribe(type, callback) {
    if (!this.listeners.has(type)) {
      this.listeners.set(type, new Set());
    }
    this.listeners.get(type).add(callback);

    // Return unsubscribe function
    return () => {
      const callbacks = this.listeners.get(type);
      if (callbacks) {
        callbacks.delete(callback);
      }
    };
  }

  notifyListeners(type, data) {
    const callbacks = this.listeners.get(type);
    if (callbacks) {
      callbacks.forEach(callback => {
        try {
          callback(data);
        } catch (error) {
          console.error('Error in WebSocket listener:', error);
        }
      });
    }
  }

  isConnected() {
    return this.ws?.readyState === WebSocket.OPEN;
  }
}

// Singleton instance
const websocketService = new WebSocketService();

export default websocketService;
