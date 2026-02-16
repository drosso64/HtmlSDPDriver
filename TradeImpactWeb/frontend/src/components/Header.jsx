import { Link, useLocation } from 'react-router-dom'
import './Header.css'

function Header({ user, onLogout }) {
  const location = useLocation()

  const isActive = (path) => location.pathname === path

  return (
    <header className="header">
      <div className="header-container">
        <div className="header-brand">
          <h2>TradeImpact Web Gateway</h2>
        </div>
        
        <nav className="header-nav">
          <Link to="/subscriptions" className={isActive('/subscriptions') ? 'active' : ''}>
            Subscriptions
          </Link>
          <Link to="/data" className={isActive('/data') ? 'active' : ''}>
            Live Data
          </Link>
          <Link to="/query" className={isActive('/query') ? 'active' : ''}>
            Query
          </Link>
          <Link to="/cleanup" className={isActive('/cleanup') ? 'active' : ''}>
            Database
          </Link>
        </nav>

        <div className="header-user">
          <span className="user-name">{user?.username}</span>
          <button onClick={onLogout} className="btn btn-secondary">
            Logout
          </button>
        </div>
      </div>
    </header>
  )
}

export default Header
