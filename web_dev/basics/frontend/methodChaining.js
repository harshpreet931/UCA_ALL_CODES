// Implementation of string concat using method chaining

var x = "Hello";

function InfiniteConcat(initialString) {
    this.initialString = initialString;
    this.res = initialString;

    this.concat = function(incomingValue) {
        this.res = this.res + " " + incomingValue;
        return this;
    }
}

var x = "Hello";
var concat1 = new InfiniteConcat(x);
console.log(concat1.concat("World").concat("How").concat("Are").concat("You").concat("Doing").concat("Today").res);4

// what is destructuring in jS
// Destructuring is a JavaScript expression that makes it possible to unpack values from arrays, or properties from objects, into distinct variables.

// example of destructuring
// Array destructuring

var arr = [1, 2, 3, 4, 5];
var [a, b, c, d, e] = arr;

// Object destructuring

var obj = { name: "John", age: 30, city: "New York" };
var { name, age, city } = obj;

// what is CDN
// A content delivery network (CDN) refers to a geographically distributed group of servers that work together to provide fast delivery of Internet content. A CDN allows for the quick transfer of assets needed for loading Internet content including HTML pages, javascript files, stylesheets, images, and videos. 