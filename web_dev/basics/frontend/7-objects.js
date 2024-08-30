// Object literal
var objUsingLitral = {name : "Harsh", Married : false}
console.log(objUsingLitral);

// New object
var objUsingNew = new Object();

// Object.assign
var objUsingAssign = Object.assign({age : 19}, objUsingLitral);
console.log(objUsingAssign);

// Object.create here obj4 acts as a prototype
var obj4 = {name : "Harsh"};
var objUsingCreate = Object.create(obj4);
console.log(objUsingCreate);