import React, { useRef } from 'react';
import { Link } from 'react-router-dom';

function SignIn() {
    const formRefs = {
        email: useRef(),
        password: useRef()
    };

    const handleClick = (event) => {
        event.preventDefault();
        const formData = {
            email: formRefs.email.current.value,
            password: formRefs.password.current.value,
        };
        console.log(formData);
    };

    return (
        <> 
        <div className="container mt-5">
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
                    <button type="submit" className="btn btn-primary" onClick={handleClick}>Sign In</button>
                </div>
            </div>
        </div>
        </>
    );
}

export default SignIn;
