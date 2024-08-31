function customPromiseExecutor(resolve, reject) {
    setTimeout(() => {
        console.log("Inside customPromiseExecutor!");
        resolve("Success!");
    }, 1000);
}

function customPromise(executor) {
    // builing promise from stratch
    executor(
        (response) => {
            console.log("Inside resolve!", response);
            this.state = "fulfilled";
            result = response;
            SuccessCallBack(result);
        },
        (error) => {
            console.log("Inside err reject!", error);
            this.state = "rejected";
            result = error;
            ErrorCallBack(result);

        }
    )
    this.state = "pending";
    let result = undefined;
    let SuccessCallBack, ErrorCallBack;

    this.then = (arg1) => {
        if (this.state == "fulfilled") {
            arg1(result);
        }
        SuccessCallBack = arg1;
    }

    this.catch = (arg2) => {
        if (this.state == "rejected") {
            arg2(result);
        }
        ErrorCallBack = arg2;
    }
}

var promise1 = new customPromise(customPromiseExecutor);