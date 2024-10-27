    const outer = () => {
        let innerValues;
        let z = inner((...args) => {
            innerValues = args;
            console.log(innerValues);
        });
        console.log(z);
    }

    const inner = (callback) => {
        callback(1, 2, 3);
    }


    outer();