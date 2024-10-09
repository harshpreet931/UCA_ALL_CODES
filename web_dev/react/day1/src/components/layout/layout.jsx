import Header from "../header";
import { Outlet } from "react-router-dom";

function Layout() {
    const outletStyle = {
        padding: '20px',
        backgroundColor: '#f0f0f0',
        borderRadius: '8px',
        boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
        margin: '20px auto',
        maxWidth: '1200px',
    };

    return (
        <>
            <header>
                <Header></Header>
            </header>
            <main>
                <div style={outletStyle}>
                    <Outlet></Outlet>
                </div>
            </main>
            <footer></footer>
        </>
    )
}

export default Layout;