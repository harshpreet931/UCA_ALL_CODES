class Student {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    // Method
    vote() {
        if(this.age > 18) {
            console.log("Can Vote");
        }
        else {
            console.log("Can't vote");
        }
        console.log(this.name);
    }
}

var student = new Student("Harsh", 19);
student.vote();