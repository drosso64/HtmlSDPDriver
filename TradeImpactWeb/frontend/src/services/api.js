import axios from 'axios';

const api = axios.create({
  baseURL: '/api',
  headers: {
    'Content-Type': 'application/json'
  }
});

const getMarket = () => localStorage.getItem('market') || 'BV';

// Request interceptor per aggiungere token/session
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('authToken');
    if (token) {
      config.headers['Authorization'] = token;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Response interceptor per gestire errori globali
api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      localStorage.removeItem('authToken');
      localStorage.removeItem('user');
      window.location.href = '/login';
    }
    return Promise.reject(error);
  }
);

// Authentication
export const auth = {
  login: (username, password) => 
    api.post('/auth/login', { username, password }),
  
  logout: () => 
    api.post('/auth/logout'),
  
  validateSession: () =>
    api.get('/auth/session')
};

// Classes
export const classes = {
  getAll: () => 
    api.get('/classes'),
  
  getDetails: (className) => 
    api.get(`/classes/${className}`)
};

// Subscriptions
export const subscriptions = {
  getAll: () => 
    api.get(`/markets/${getMarket()}/subscriptions`),
  
  getUserSubscriptions: (username) =>
    api.get(`/markets/${getMarket()}/subscriptions/user/${username}`),
  
  getActiveSubscriptions: (username) =>
    api.get(`/markets/${getMarket()}/subscriptions/user/${username}/active`),
  
  create: (requestDto) =>
    api.post(`/markets/${getMarket()}/subscriptions`, requestDto),
  
  delete: (subscriptionId) =>
    api.delete(`/markets/${getMarket()}/subscriptions/${subscriptionId}`),
  
  deleteByClassId: (username, classId) =>
    api.delete(`/markets/${getMarket()}/subscriptions/${username}/${classId}`),
  
  // Legacy endpoints (kept for compatibility)
  subscribe: (className) => 
    api.post(`/subscriptions/${className}`),
  
  unsubscribe: (className) => 
    api.delete(`/subscriptions/${className}`)
};

// Market Data
export const marketData = {
  getLatest: (className) => 
    api.get(`/market-data/${className}`),
  
  getHistory: (className, params) => 
    api.get(`/market-data/${className}/history`, { params })
};

// Transactions
export const transactions = {
  getTypes: () => 
    api.get(`/markets/${getMarket()}/transactions/types`),
  
  getFields: (type) => 
    api.get(`/markets/${getMarket()}/transactions/types/${type}/fields`),
  
  submit: (type, data) => 
    api.post(`/markets/${getMarket()}/transactions`, { type, data }),

  /**
   * Invia una transazione monitored (SAPMonitoredActionReq)
   * @param {Object} params
   * @param {number} params.classId - ID numerico della classe SMP
   * @param {string} params.action - ADD | RWT | DEL | KILL
   * @param {Object} params.data - Campi del messaggio SMP
   * @param {string} params.username - Username dell'utente
   * @returns {Promise} TransactionResponse
   */
  submitMonitored: ({ classId, action, data, username }) =>
    api.post(`/markets/${getMarket()}/transactions`, { classId, action, data, username })
};

// Query
export const query = {
  execute: (className, filters) => 
    api.post('/query', { className, filters })
};

// Dashboard
export const dashboard = {
  getStats: () => 
    api.get('/dashboard/stats')
};

// Cleanup
export const cleanup = {
  getStats: () => 
    api.get('/cleanup/stats'),
  
  updateRetention: (days) => 
    api.put('/cleanup/retention', { days }),
  
  execute: () => 
    api.post('/cleanup/execute')
};

export default api;
