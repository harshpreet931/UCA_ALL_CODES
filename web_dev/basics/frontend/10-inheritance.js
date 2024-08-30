// Prototypical inheritance
// Inheritance is a way to create a new object from an existing object. The new object has all the properties and methods of the existing object, and it can have additional properties and methods.
// Prototypical is achieved through Prototype or its chain.

var arr = [1, 2, 3];
callBackFunction1 = (value, index) => {
    console.log(value, index);
}

console.log(arr.forEach(callBackFunction1));

// In the above code, forEach is a method of the array object. The forEach method takes a callback function as an argument. The callback function is called for each element in the array. The callback function is called with three arguments: the value of the element, the index of the element, and the array itself.

Array.prototype.forEachCustom = function(callback) {
    console.log(this);
    for(let i = 0; i < this.length; i++) {
        callback(this[i], i);
    }
}

multiplyBy2 = (value) => {
    return value * 2;
}

console.log(arr.map(multiplyBy2));


// custom map function

Array.prototype.mapCustom = function(callback) {
    let updatedArray = []
    for(let i = 0; i < this.length; i++) {
        updatedArray.push(callback(this[i]));
    }
    return updatedArray;
}

console.log(arr.mapCustom(multiplyBy2));