function SignUp() {

    let name = "name1";
    // useRef is used to preserve the value of the input field
    // it will create a memory reference to the input field
    // it will not re-render the component
    // usecase -> when we want to listen to the changes in the input field and more
    const inputRef = useRef();
    // it can create a reference of anything in React   

    return (
        <>
            <div class="mb-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="email@example.com" />
                </div>
            </div>
            <div class="mb-3 row">
                <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword" />
                </div>
            </div>
        </>
    )
}

export default SignUp;