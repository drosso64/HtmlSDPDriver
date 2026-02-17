import { useState, useEffect } from 'react'
import { BrowserRouter as Router, Routes, Route, Navigate, useLocation, useNavigate } from 'react-router-dom'
import { WebSocketProvider, useWebSocket } from './contexts/WebSocketContext'
import * as api from './services/api'
import Login from './components/Login'
import ClassSubscription from './components/ClassSubscription'
import DataGrid from './components/DataGrid'
import StandaloneClassView from './components/StandaloneClassView'
import QueryInterface from './components/QueryInterface'
import DatabaseCleanup from './components/DatabaseCleanup'
import Header from './components/Header'

function AppContent({ isAuthenticated, user, onLogin, onLogout }) {
  const location = useLocation();
  const navigate = useNavigate();
  const isStandaloneView = location.pathname.startsWith('/class-view');

  console.log('🔍 AppContent render - pathname:', location.pathname, 'isStandalone:', isStandaloneView);

  const handleLogoutWithRedirect = async () => {
    await onLogout();
    navigate('/login', { replace: true });
  };

  return (
    <>
      {isAuthenticated && !isStandaloneView && <Header user={user} onLogout={handleLogoutWithRedirect} />}
      <Routes>
        <Route 
          path="/login" 
          element={
            isAuthenticated ? 
            <Navigate to="/subscriptions" /> : 
            <Login onLogin={onLogin} />
          } 
        />
        <Route 
          path="/subscriptions" 
          element={
            isAuthenticated ? 
            <ClassSubscription user={user} /> : 
            <Navigate to="/login" />
          } 
        />
        <Route 
          path="/data" 
          element={
            isAuthenticated ? 
            <DataGrid /> : 
            <Navigate to="/login" />
          } 
        />
        <Route 
          path="/class-view/:classId" 
          element={
            isAuthenticated ? 
            <StandaloneClassView /> : 
            <Navigate to="/login" />
          } 
        />
        <Route 
          path="/query" 
          element={
            isAuthenticated ? 
            <QueryInterface /> : 
            <Navigate to="/login" />
          } 
        />
        <Route 
          path="/cleanup" 
          element={
            isAuthenticated ? 
            <DatabaseCleanup /> : 
            <Navigate to="/login" />
          } 
        />
        <Route index element={<Navigate to="/subscriptions" replace />} />
        <Route path="*" element={<Navigate to="/subscriptions" replace />} />
      </Routes>
    </>
  );
}

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false)
  const [user, setUser] = useState(null)

  useEffect(() => {
    // Check if user is already logged in (from local storage - shared across windows)
    const savedUser = localStorage.getItem('user')
    const savedToken = localStorage.getItem('authToken')
    
    if (savedUser && savedToken) {
      // Validate token with backend before considering user authenticated
      api.auth.validateSession()
        .then((response) => {
          // Token is valid
          setUser(JSON.parse(savedUser))
          setIsAuthenticated(true)
        })
        .catch((error) => {
          // Token is invalid or expired
          console.log('Token non valido, logout necessario')
          localStorage.removeItem('user')
          localStorage.removeItem('authToken')
          setUser(null)
          setIsAuthenticated(false)
        })
    } else {
      // Clear incomplete sessions
      localStorage.removeItem('user')
      localStorage.removeItem('authToken')
    }
  }, [])

  const handleLogin = (userData) => {
    setUser(userData)
    setIsAuthenticated(true)
    localStorage.setItem('user', JSON.stringify(userData))
    // Save authentication token
    if (userData.token) {
      localStorage.setItem('authToken', userData.token)
    }
  }

  const handleLogout = async () => {
    try {
      // Call logout API to close SDP connections
      await api.auth.logout()
      console.log('Logout API chiamata con successo')
    } catch (error) {
      console.error('Errore durante il logout:', error)
    } finally {
      // Clear local state regardless of API call result
      setUser(null)
      setIsAuthenticated(false)
      localStorage.removeItem('user')
      localStorage.removeItem('authToken')
    }
  }

  return (
    <WebSocketProvider>
      <Router>
        <AppContent 
          isAuthenticated={isAuthenticated} 
          user={user} 
          onLogin={handleLogin}
          onLogout={handleLogout} 
        />
      </Router>
    </WebSocketProvider>
  )
}

export default App
