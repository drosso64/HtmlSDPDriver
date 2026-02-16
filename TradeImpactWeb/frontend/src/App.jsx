import { useState, useEffect } from 'react'
import { BrowserRouter as Router, Routes, Route, Navigate, useLocation } from 'react-router-dom'
import { WebSocketProvider } from './contexts/WebSocketContext'
import Login from './components/Login'
import ClassSubscription from './components/ClassSubscription'
import DataGrid from './components/DataGrid'
import StandaloneClassView from './components/StandaloneClassView'
import QueryInterface from './components/QueryInterface'
import DatabaseCleanup from './components/DatabaseCleanup'
import Header from './components/Header'

function AppContent({ isAuthenticated, user, onLogin, onLogout }) {
  const location = useLocation();
  const isStandaloneView = location.pathname.startsWith('/class-view');

  console.log('🔍 AppContent render - pathname:', location.pathname, 'isStandalone:', isStandaloneView);

  return (
    <>
      {isAuthenticated && !isStandaloneView && <Header user={user} onLogout={onLogout} />}
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
            <ClassSubscription /> : 
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
    if (savedUser) {
      setUser(JSON.parse(savedUser))
      setIsAuthenticated(true)
    }
  }, [])

  const handleLogin = (userData) => {
    setUser(userData)
    setIsAuthenticated(true)
    localStorage.setItem('user', JSON.stringify(userData))
  }

  const handleLogout = () => {
    setUser(null)
    setIsAuthenticated(false)
    localStorage.removeItem('user')
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
