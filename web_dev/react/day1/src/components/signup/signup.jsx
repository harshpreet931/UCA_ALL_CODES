import React, { useRef, useState } from 'react';
import { Link } from 'react-router-dom';

function SignUp() {
    const [isFormCreated, setIsFormCreated] = useState(false);
    const [isFormFailed, setIsFormFailed] = useState(false);
    const formRefs = {
        firstName: useRef(),
        lastName: useRef(),
        email: useRef(),
        password: useRef()
    };

    const handleClick = () => {
        event.preventDefault();
        const formData = {
            firstName: formRefs.firstName.current.value,
            lastName: formRefs.lastName.current.value,
            email: formRefs.email.current.value,
            password: formRefs.password.current.value,
        };
        
        if(formData.firstName === "" || formData.lastName === "" || formData.email === "" || formData.password === "") {
            alert("Please fill all the fields");
            return;
        }

        var response = fetch('http://localhost:3000/users', {
            method: 'POST',
            body: JSON.stringify(formData),
        }).then(response => {
            if(response.status === 201) {
                setIsFormCreated(true);
            } else {
                setIsFormFailed(true);
            }
        });
    };

    return (
        <> 
        {
            isFormCreated && <div class="alert alert-success" role="alert">
                        Form Created Successfully
                    </div>
        }
        {
            isFormFailed && <div class="alert alert-danger" role="alert">
                                Form Creation Failed
                            </div>
        }
        
        <div className="container mt-5">
            <div className="mb-3 row">
                <label htmlFor="inputFirstName" className="col-sm-2 col-form-label">First Name</label>
                <div className="col-sm-10">
                    <input type="text" className="form-control" id="inputFirstName" ref={formRefs.firstName} />
                </div>
            </div>
            <div className="mb-3 row">
                <label htmlFor="inputLastName" className="col-sm-2 col-form-label">Last Name</label>
                <div className="col-sm-10">
                    <input type="text" className="form-control" id="inputLastName" ref={formRefs.lastName} />
                </div>
            </div>
            <div className="mb-3 row">
                <label htmlFor="inputEmail" className="col-sm-2 col-form-label">Email</label>
                <div className="col-sm-10">
                    <input type="email" className="form-control" id="inputEmail" ref={formRefs.email} />
                </div>
            </div>
            <div className="mb-3 row">
                <label htmlFor="inputPassword" className="col-sm-2 col-form-label">Password</label>
                <div className="col-sm-10">
                    <input type="password" className="form-control" id="inputPassword" ref={formRefs.password} />
                </div>
            </div>
            <div className="mb-3 row">
                <div className="col-sm-10 offset-sm-2">
                    <button type="submit" className="btn btn-primary" onClick={handleClick}>Sign Up</button>
                </div>
            </div>
        </div>
        </>
    );
}

export default SignUp;