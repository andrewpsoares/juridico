import { ReactComponent as LogoIcon } from 'assets/img/lopas.svg';
import './style.css';

function Navbar(){
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">                    
                    <h1>Lopas</h1>                       
                    <LogoIcon />
                </div>
            </nav>
        </header>
    );
}

export default Navbar;