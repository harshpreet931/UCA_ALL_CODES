let promiseXml;

function customFetch(url, resolve, reject) {
    promiseXml = new Promise(executor);

    function executor(resolve, reject) {
        let xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function() {
            if (xhr.DONE === xhr.readyState) {
                if (xhr.status === 200) {
                    resolve(xhr.responseText);
                } else {
                    reject(xhr.statusText);
                }
            }
        }

        xhr.open('GET', url);
        xhr.send();
    }

    promiseXml.then(resolve).catch(reject);
    return promiseXml;
}

customFetch('https://jsonplaceholder.typicode.com/todos/1', console.log, console.error);