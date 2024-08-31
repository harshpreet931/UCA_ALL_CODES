function promise(e) {
    let onResolve, onReject;
    let isFinished = false;
    let isRejected = false;
    let value;

    function resolve(val) {
        isFinished = true;
        value = val;
        if(onResolve) onResolve(val);
    }

    function reject(val) {
        isFinished = true;
        isRejected = true;
        value = val;
        if(onReject) onReject(val);
    }

    e(resolve, reject);

    this.then = function(callback) {
        if(isFinished && !isRejected) {
            callback(value);
        }
        else {
            onResolve = callback;
        }
        return this;
    }

    this.catch = function(callback) {
        if(isRejected) {
            callback(value);
        }
        else {
            onReject = callback;
        }
        return this;
    }
}

let p = new promise((resolve, reject) => {
    setTimeout(() => {
        let success = false;
        if(success) {
            resolve('Success');
        }
        else {
            reject('Failure');
        }
    }, 1000);
});

p.then((val) => {
    console.log(val);
}).catch((val) => {
    console.log(val);
});