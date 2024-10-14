import React, { useRef, useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

function ManageProduct() {
    const [isEditing, setIsEditing] = useState(false);
    const [productData, setProductData] = useState(null);
    const [isFormCreated, setIsFormCreated] = useState(false);
    const [isFormFailed, setIsFormFailed] = useState(false);
    const navigate = useNavigate();
    const formRefs = {
        productName: useRef(),
        productPrice: useRef(),
    };

    useEffect(() => {
        const storedIsEditing = sessionStorage.getItem('isEditing');
        setIsEditing(storedIsEditing === 'true');

        if (storedIsEditing === 'true') {
            const storedProduct = JSON.parse(sessionStorage.getItem('editingProduct'));
            setProductData(storedProduct);
            if (storedProduct) {
                formRefs.productName.current.value = storedProduct.name;
                formRefs.productPrice.current.value = storedProduct.price;
            }
        }
    }, []);

    console.log(productData);
    console.log(isEditing);

    useEffect(() => {
        if (isEditing && productData) {
            console.log(productData);
            formRefs.productName.current.value = productData.name;
            formRefs.productPrice.current.value = productData.price;
        }
    }, [isEditing, productData]);

    const handleSubmit = (event) => {
        event.preventDefault();
        const formData = {
            name: formRefs.productName.current.value,
            price: formRefs.productPrice.current.value,
        };

        if (formData.name === "" || formData.price === "") {
            alert("Please fill all the fields");
            return;
        }

        const url = isEditing ? `http://localhost:3000/products/${productData.id}` : 'http://localhost:3000/products';
        const method = isEditing ? 'PUT' : 'POST';

        fetch(url, {
            method: method,
            body: JSON.stringify(formData),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.status === 201 || response.status === 200) {
                setIsFormCreated(true);
                sessionStorage.removeItem('editingProduct');
                sessionStorage.removeItem('isEditing');
                setTimeout(() => navigate('/'), 1500);
            } else {
                setIsFormFailed(true);
            }
        });
    };

    return (
        <>
            {
                isFormCreated && <div className="alert alert-success" role="alert">
                    Product {isEditing ? 'Updated' : 'Added'} Successfully
                </div>
            }
            {
                isFormFailed && <div className="alert alert-danger" role="alert">
                    Product {isEditing ? 'Update' : 'Addition'} Failed
                </div>
            }

            <div className="container mt-5">
                <h2>{isEditing ? 'Edit Product' : 'Add New Product'}</h2>
                <form onSubmit={handleSubmit}>
                    <div className="mb-3 row">
                        <label htmlFor="inputProductName" className="col-sm-2 col-form-label">Product Name</label>
                        <div className="col-sm-10">
                            <input type="text" className="form-control" id="inputProductName" ref={formRefs.productName} />
                        </div>
                    </div>
                    <div className="mb-3 row">
                        <label htmlFor="inputProductPrice" className="col-sm-2 col-form-label">Product Price</label>
                        <div className="col-sm-10">
                            <input type="number" className="form-control" id="inputProductPrice" ref={formRefs.productPrice} />
                        </div>
                    </div>
                    <div className="mb-3 row">
                        <div className="col-sm-10 offset-sm-2">
                            <button type="submit" className="btn btn-primary">
                                {isEditing ? 'Update Product' : 'Add Product'}
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </>
    );
}

export default ManageProduct;