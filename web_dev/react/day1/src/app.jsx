// This is a normal function, it becomes a component when it is exported and used in the main file.
import Header from "./header";
import ProductList from "./productList";

function App() {
    return (
        <>
            <header>
                <Header></Header>
            </header>
            
            <main>
                <ProductList></ProductList>
            </main> 
            
            <footer>
                
            </footer>       
        </>
    )
}

// we can return only one element from a component
// if we want to do multiple elements, we can use a div tag to wrap them up or <> </> which are called as fragments
export default App;