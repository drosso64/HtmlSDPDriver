import axios from 'axios';

const api = axios.create({
  baseURL: '/api',
  headers: {
    'Content-Type': 'application/json'
  }
});

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
    api.post('/auth/logout')
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
    api.get('/subscriptions'),
  
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
    api.get('/transactions/types'),
  
  getFields: (type) => 
    api.get(`/transactions/types/${type}/fields`),
  
  submit: (type, data) => 
    api.post('/transactions', { type, data })
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
