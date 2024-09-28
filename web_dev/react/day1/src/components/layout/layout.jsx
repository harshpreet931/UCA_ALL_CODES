import Header from "../header";

function Layout(props) {
    return (
        <>
            <header>
                <Header></Header>
            </header>
            {props.children}
            <footer></footer>
        </>
    )
}

export default Layout;