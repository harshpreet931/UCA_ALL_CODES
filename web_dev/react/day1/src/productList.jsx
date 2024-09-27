import { useState } from "react";

function productList() {

    // setTimeout(() => {
    //     var products = [{name: 'Product 4', price: 400}, {name: 'Product 5', price: 500}, {name: 'Product 6', price: 600}];
    // }, 2000);

    // the problem is that the products are not getting updated in the UI
    // this is because the products are not getting updated in the state
    // we need to use the state to update the products
    // never use open variables to store the data

    var [products, setProducts] = useState([]);

    // a function can return multiple elements through, array, objects, callbacks, etc
    
    setTimeout(() => {
        setProducts([{name: 'Product 1', price: 400}, {name: 'Product 2', price: 500}, {name: 'Product 3', price: 600}]);
    }, 1000);

    // 2 hooks useState and useRef are used to update the state and to refer to the DOM elements
    // useState is used to update the state of the component
    // useRef is used to refer to the DOM elements 

    return (
        <>
            <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
                <table style={{border: '2px solid black', borderCollapse: 'collapse', width: '85%'}}>
                    <thead>
                        <tr>
                            <th style={{border: '2px solid black'}}>Name</th>
                            <th style={{border: '2px solid black'}}>Price</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        {products.map((product, index) => {
                            return (
                                <tr key={index}>
                                    <td style={{border: '2px solid black'}}>{product.name}</td>
                                    <td style={{border: '2px solid black'}}>{product.price}</td>
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