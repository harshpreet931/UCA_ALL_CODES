// Promise
// Promise is an object created using constructor function Promise() and has 2 properties -> state and result(value).
// Promise has 3 states -> pending, fulfilled and rejected.
// Promise has 2 results(value) -> undefined, value or error.
// Promise has 2 methods -> then() and catch().
// then() is called when promise is fulfilled.
// catch() is called when promise is rejected.
// Promise is asynchronous.
// Promise is used to handle asynchronous operations.
// Promise is used to avoid callback hell.
// Promise is used to avoid pyramid of doom.

function promiseExecutor() {
    setTimeout(() => {
        console.log("Inside promiseExecutor!");
    }, 1000);
}

var promise1 = new Promise(promiseExecutor);
var promise2 = new Promise(promiseExecutor);

// ----------------------------------------------------------------------------------------------------------------------

function promiseExecutor(resolve, reject) {
    setTimeout(() => {
        console.log("Inside promiseExecutor!");
        resolve("Success!");
    },1000);
}

var promise1 = new Promise(promiseExecutor);
promise1.then((val) => {
    console.log(val);
})

// ----------------------------------------------------------------------------------------------------------------------

function promiseExecutor(resolve, reject) {
    setTimeout(() => {
        console.log("Inside promiseExecutor!");
        reject("Success!");
    },1000);
}

var promise1 = new Promise(promiseExecutor);
promise1.catch((val) => {
    console.log(val);
})

// ----------------------------------------------------------------------------------------------------------------------

// Fetch API is used to make network requests.
// Fetch API returns a promise.
