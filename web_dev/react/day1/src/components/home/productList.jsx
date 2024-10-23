import { useState, useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./style.css";
import { Link, useNavigate } from "react-router-dom";
import Button from "../elements/button";

function ProductList() {
    const navigate = useNavigate();
    // const navigateToEdit = () => {
    //     console.log('Navigating to edit');
    // }
    // setTimeout(() => {
    //     var products = [{name: 'Product 4', price: 400}, {name: 'Product 5', price: 500}, {name: 'Product 6', price: 600}];
    // }, 2000);

    // the problem is that the products are not getting updated in the UI
    // this is because the products are not getting updated in the state
    // we need to use the state to update the products
    // never use open variables to store the data

    var [products, setProducts] = useState([]);


    // useEffect -> used to perform side effects in the component
    // side effects are the actions that are performed in the component
    // [] -> used to run the useEffect only once when the component is rendered (dependency array) (componentDidMount)
    // if we remove the [] then the useEffect will run on every render
    // [productList] -> used to run the useEffect only when the productList is updated (componentDidUpdate)

    useEffect(() => {
        console.log('Component is rendered');
        return () => { // cleanup function for teardown
            console.log('Component is unmounted');
        }
    }, []);


    // a function can return multiple elements through, array, objects, callbacks, etc
    
    // setTimeout(() => {
    //     setProducts([{name: 'Product 1', price: 400}, {name: 'Product 2', price: 500}, {name: 'Product 3', price: 600}]);
    // }, 1000);

    useEffect(() => {
        fetch('http://localhost:3000/products')
            .then(response => response.json())
            .then(data => setProducts(data));
    }, []);

    // 2 hooks useState and useRef are used to update the state and to refer to the DOM elements
    // useState is used to update the state of the component
    // useRef is used to refer to the DOM elements 

    // New function to handle editing a product
    const handleEdit = (product) => {
        sessionStorage.setItem('editingProduct', JSON.stringify(product));
        sessionStorage.setItem('isEditing', 'true');
        navigate('/manageProduct');
    };

    const handleDelete = (product) => {
        // confirm dialog box
        const toDel = window.confirm('Are you sure you want to delete this product?');
        if(toDel)
        {
            fetch(`http://localhost:3000/products/${product.id}`, {
                method: 'DELETE',
            }).then(response => {
                if (response.status === 200) {
                    setProducts(products.filter(p => p.id !== product.id));
                }
            }
            );
        }   
    }

    // event.preventDefault() -> used to prevent the default behavior of the event
    // we convert body to String using JSON.stringify() because the body should be a string cause the server only understands the string\
    // key props are used to uniquely identify the elements in the list plus they are used to Remount the component, if the key is changed the component will be remounted
    
    return (
        <>
            <div id="cont">
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        {products.map((product) => {
                            return (
                                <tr key={product.id}>
                                    <td>{product.name}</td>
                                    <td>{product.price}</td>
                                    <td>
                                        <button onClick={() => handleEdit(product)}>Edit</button>
                                        <button onClick={() => handleDelete(product)}>Delete</button>
                                    </td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>
            </div>
            <Link to="/manageProduct">
                <Button onClick={() => {
                    sessionStorage.removeItem('editingProduct');
                    sessionStorage.setItem('isEditing', 'false');
                }}>
                    Add New Product
                </Button>
            </Link>
        </>
    )
}

export default ProductList;

// Table explanation
// tr - table row
// th - table header
// td - table data
// thead - table header
// tbody - table body
// key - unique identifier for each element in the list
// map - used to iterate over the list
// index - index of the element in the list
// style - inline styling