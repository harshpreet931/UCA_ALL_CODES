// function init(){
//     document.getElementById("jsworld").innerHTML = "Hello world from Javascript"
// }

function renderProducts() {
    var productsListFromServer = [];

    function getProductsList() {
        console.log("Getting the prpducts list.");
        productsListFromServer = productsList; // hiding from the user.
        initProductsListTable();
    }

    function initProductsListTable() {
        // we will use template literal, for multiline strings.
        if(!productsListFromServer || productsListFromServer?.length === 0) {
            document.getElementById("productMenu").innerHTML = `${getLoader()}`;
            return;
        }
        console.log("Initializing the Products HTML Table.");
        document.getElementById("productsMenu").innerHTML = `
            <div class="row center">
          <div class="col-6">
            <table>
              <thead>
                <tr>
                  <th>Sr. No. </th>
                  <th>Product Name</th>
                  <th>Description</th>
                  <th>Price</th>
                </tr>
              </thead>
              ${getProductListHTMLUsingMap()}
            </table>
          </div>
        </div>
        `;
    }

    var randomArray = [1, 2]; // prints 1, 2 -> , here is a default case 

    // function getProductListHTML() {
    //     var rows = "";
    //     for(let i = 0; i < productsList.length; i++) {
    //         rows = rows + `
    //             <tr>
    //                 <td>${i+1}</td>
    //                 <td>${productsList[i].name}</td>
    //                 <td>${productsList[i].details}</td>
    //                 <td>${productsList[i].price}</td>
    //              </tr>
    //         `
    //     }
    //     return rows;
    // }

    function getProductListHTMLUsingMap() {
        if(!productsListFromServer || productsListFromServer?.length === 0) {
            return `<h1>Loading Data</h1>`;
        }

        var rowsOfProducts = productsListFromServer.map((item, index) => {
            return `
                <tr>
                    <td>${index+1}</td>
                    <td>${item.name}</td>
                    <td>${item.details}</td>
                    <td>${item.price}</td>
                </tr>
            `
        }) 
        return `
            <tbody>
                ${rowsOfProducts?.join("")};
            </tbody>
        `;
    }

    function getLoader() {
        if(!productsListFromServer || productsListFromServer?.length === 0) {
            return `
                <div class="row">
                    <div class="col">
                     Loading Data
                    </div>
                </div>
            `;
        }
        else {
            return ``;
        }
    }


    // function gets into the stack and then executed any variables that are returend from the function are stored in Heap.
    // we do apis asycn and event listeners and all.
    // event queue or callback queue handles all the event listeners or async functions.
    // this is the event loop.
    // JS is only single threaded!!
    // All the APIs and Callback queue are handled by the browser.

    initProductsListTable();
    setTimeout(getProductsList, 500); // this goes to browser API and init runs in the meanhile... so the products aren't displayed.
    // getProductsList();
    // initProductsListTable();

    // what is event loop?
    // and why is javascript singlethreaded and then how do async operations happen.

}

renderProducts();