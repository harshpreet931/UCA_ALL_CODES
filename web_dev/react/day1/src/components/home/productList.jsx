import { useState, useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./style.css";
import { Link } from "react-router-dom";

function productList() {

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
        console.log('Componenet is rendered');
        return () => { // cleanup function for teardown
            console.log('Component is unmounted');
        }
    }, [productList]);


    // a function can return multiple elements through, array, objects, callbacks, etc
    
    setTimeout(() => {
        setProducts([{name: 'Product 1', price: 400}, {name: 'Product 2', price: 500}, {name: 'Product 3', price: 600}]);
    }, 1000);

    // 2 hooks useState and useRef are used to update the state and to refer to the DOM elements
    // useState is used to update the state of the component
    // useRef is used to refer to the DOM elements 

    return (
        <>
            <div id="cont">
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        {products.map((product, index) => {
                            return (
                                <tr key={index}>
                                    <td>{product.name}</td>
                                    <td>{product.price}</td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default productList;

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