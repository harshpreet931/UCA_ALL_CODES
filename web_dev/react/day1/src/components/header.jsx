 // interpolation is done using {} in react
// props are passed as an object to the component
// props are immutable
// interpolation is used to pass the data dynamically to the component

import { Link } from "react-router-dom";
import Button from "./elements/button";

function Header() {
    let title = "Product List";
        
    return (
        <header>
            {/* <h1>{props.title}</h1> */}
            {/* we do interpolation */}
            {/* <h1 style={{fontFamily: 'sans-serif', textAlign: 'center', fontSize: '2rem', margin: '20px'}}>{title}</h1> */}


            <nav className="navbar navbar-expand-lg bg-body-tertiary">
                <div className="container-fluid">
                    <Link className="navbar-brand" to={'/'}>Harsh's Dungeon</Link>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                        <a className="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link" href="#">Link</a>
                        </li>
                        <li className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>
                        <ul className="dropdown-menu">
                            <li><a className="dropdown-item" href="#">Action</a></li>
                            <li><a className="dropdown-item" href="#">Another action</a></li>
                            <li><hr className="dropdown-divider" /></li>
                            <li><a className="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link disabled" aria-disabled="true">Disabled</a>
                        </li>
                    </ul>
                    {/* <button className="btn btn-outline-success" type="submit">
                        <Link to={'/signup'} className="nav-link">SignUp</Link>
                    </button>
                    <button className="btn btn-outline-success" type="submit">
                        <Link to={'/signin'} className="nav-link">SignIn</Link>
                    </button> */}
                    <Button>
                        <Link to={'/manageProduct'} className="nav-link">Add Product</Link>
                    </Button>
                    <Button>
                        <Link to={'/signup'} className="nav-link">SignUp</Link>
                    </Button>
                    <Button>
                        <Link to={'/signin'} className="nav-link">SignIn</Link>
                    </Button>
                    </div>
                </div>
            </nav>

        </header>
    )
}

export default Header;