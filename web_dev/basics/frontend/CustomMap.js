Array.prototype.mapCustom = function(callback) {
    let result = [];
  
    for (let i = 0; i < this.length; i++) {
      result.push(callback(this[i], i));
    }
    return result;
};

numbers = [1, 2, 3, 4, 5];
var doubled = numbers.mapCustom((number) => number * 2);
console.log(doubled);

