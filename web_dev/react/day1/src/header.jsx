 // interpolation is done using {} in react
// props are passed as an object to the component
// props are immutable
// interpolation is used to pass the data dynamically to the component

function Header() {
    let title = "Product List";

    return (
        <header>
            {/* <h1>{props.title}</h1> */}
            {/* we do interpolation */}
            <h1 style={{fontFamily: 'sans-serif', textAlign: 'center', fontSize: '2rem'}}>{title}</h1>
        </header>
    )
}

export default Header;