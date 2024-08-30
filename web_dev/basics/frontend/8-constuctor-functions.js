// Constructor Functions
function student() {}

var maxMarks = 100;

var student = {
    fName: "fName1",
    obtainedMarks: 200,
    checkResults: function() {
        let percentage = (this.obtainedMarks / maxMarks) * 100;
        if(percentage > 50) {
            console.log("Pass");
        }
        else {
            console.log("Fail");
        }
    }
};

student.checkResults();

// --------------------------------------------------------------

function student2(fName, obtainedMarks) {
    return {
        fName: fName, 
        obtainedMarks: obtainedMarks,
        checkResults: function() {
            let percentage = (this.obtainedMarks / maxMarks) * 100;
            if(percentage > 50) {
                console.log("Pass");
            }
            else {
                console.log("Fail");
            }
        }
    }
}

var student2 = student2("fName2", 200);

// --------------------------------------------------------------

function student3(fName, obtainedMarks) {
    console.log(this); // window object
    return {
        fNameObj: fName,
        obtainedMarksObj: obtainedMarks,
        checkResults: function() {
            console.log(this); // student3 object
            let percentage = (this.obtainedMarksObj / maxMarks) * 100;
            if(percentage > 50) {
                console.log("Pass");
            }
            else {
                console.log("Fail");
            }
        }
    }
}

var student3 = student3("fName3", 200);

// --------------------------------------------------------------

// Constructor Functions
// New keyword to be used with a function

function student4(fName, obtainedMarks) {
    console.log(this);
    this.fNameObj = fName;
    this.obtainedMarksObj = obtainedMarks;
    this.checkResults = function() {
        console.log(this);
        let percentage = (this.obtainedMarksObj / maxMarks) * 100;
        if(percentage > 50) {
            console.log("Pass");
        }
        else {
            console.log("Fail");
        }
    }
}

var student4 = new student4("fName4", 200); 