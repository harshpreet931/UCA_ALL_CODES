// Entries in js are in the form of key and value pairs

// Set
// A set is a collection of unique values. A set can be created using the Set() constructor.
// A set can have values of any type, including other objects.

var set1 = new Set([1, 2, 3, 4, 5]);
set1.add(1);
console.log(set1);

// Map
// A map is a collection of key-value pairs. A map can be created using the Map() constructor.

var map1 = new Map([
    ['key1', 'value1'],
    ['key2', 'value2']
]);

map1.set('key3', 'value3');

console.log(map1);