// we wrap everything in a function then it is not accesible in a window object. so that no variable and clashes occur.

// var -> only hoisting.
// hoisting -> top of the function.
// bad practice cause flow of execution gets disrupted.

// if var at bottom. it we try to use it before initialization then it will leave to a reference error. cannot access before initialization.

// blocking mode vs non blocking mode.
//                  async and defer.

function renderProducts() {
    var productsListFromServer = []; // instance variable.

    function getProductsList() {
        console.log("Getting the products list.");
        productsListFromServer = productsList; // hiding from the user.
        initProductsListTable();
    }

    function initProductsListTable() {
        // we will use template literal, for multiline strings.
        if (!productsListFromServer || productsListFromServer?.length === 0) {
            document.getElementById("productsMenu").innerHTML = `${getLoader()}`;
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

    function getProductListHTMLUsingMap() {
        if (!productsListFromServer || productsListFromServer?.length === 0) {
            return `<h1>Loading Data</h1>`;
        }

        var rowsOfProducts = productsListFromServer.map((item, index) => {
            return `
                <tr>
                    <td>${index + 1}</td>
                    <td>${item.name}</td>
                    <td>${item.details}</td>
                    <td>${item.price}</td>
                </tr>
            `;
        });
        return `
            <tbody>
                ${rowsOfProducts.join("")}
            </tbody>
        `;
    }

    function getLoader() {
        if (!productsListFromServer || productsListFromServer?.length === 0) {
            return `
                <div class="row">
                    <div class="col">
                        Loading Data
                    </div>
                </div>
            `;
        } else {
            return ``;
        }
    }

    initProductsListTable();
    setTimeout(getProductsList, 500); // this goes to browser API and init runs in the meanwhile... so the products aren't displayed.
}

renderProducts();
