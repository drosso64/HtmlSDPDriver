import { useState } from 'react'
import api from '../services/api'
import './Login.css'

function Login({ onLogin }) {
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [ipspHost, setIpspHost] = useState('')
  const [ipspPort, setIpspPort] = useState('8800')
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)

  const handleSubmit = async (e) => {
    e.preventDefault()
    setError('')
    setLoading(true)

    try {
      // Validazione campi
      if (!username || !password || !ipspHost || !ipspPort) {
        setError('Tutti i campi sono obbligatori')
        setLoading(false)
        return
      }

      // Chiama API di login
      const response = await api.post('/auth/login', {
        username,
        password,
        ipspHost,
        ipspPort: parseInt(ipspPort),
        useSsl: true
      })

      if (response.data.success) {
        // Salva token
        localStorage.setItem('authToken', response.data.token)
        
        onLogin({
          username: response.data.username,
          ipspHost: response.data.ipspHost,
          ipspPort: response.data.ipspPort,
          connected: response.data.connected,
          token: response.data.token,
          loginTime: new Date().toISOString()
        })
      } else {
        setError(response.data.message || 'Login fallito')
      }
    } catch (err) {
      console.error('Login error:', err)
      setError(err.response?.data?.message || 'Errore durante il login: ' + err.message)
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className="login-container">
      <div className="login-card">
        <h1>TradeImpact Web Gateway</h1>
        <p className="subtitle">Accedi al sistema SDP</p>
        
        {error && <div className="error">{error}</div>}
        
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="username">Username</label>
            <input
              id="username"
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              placeholder="Inserisci username"
              disabled={loading}
              autoFocus
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input
              id="password"
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Inserisci password"
              disabled={loading}
              required
            />
          </div>

          <div className="form-divider">
            <span>Configurazione IPSP</span>
          </div>

          <div className="form-group">
            <label htmlFor="ipspHost">IPSP Host</label>
            <input
              id="ipspHost"
              type="text"
              value={ipspHost}
              onChange={(e) => setIpspHost(e.target.value)}
              placeholder="es. ipsp.example.com"
              disabled={loading}
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="ipspPort">IPSP Port</label>
            <input
              id="ipspPort"
              type="number"
              value={ipspPort}
              onChange={(e) => setIpspPort(e.target.value)}
              placeholder="8800"
              disabled={loading}
              min="1"
              max="65535"
              required
            />
          </div>

          <button 
            type="submit" 
            className="btn btn-primary btn-block"
            disabled={loading}
          >
            {loading ? 'Connessione in corso...' : 'Connetti'}
          </button>
        </form>

        <div className="login-footer">
          <p>Demo credentials: qualsiasi username/password</p>
        </div>
      </div>
    </div>
  )
}

export default Login
