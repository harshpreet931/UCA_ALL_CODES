// Node.js -> is used for server side programming and building the backend of the application.
// provides the capability to run JavaScript on the server side, which makes it possible to build web applications using JavaScript.
// creates a service that listens for incoming requests and responds to them.

// Express -> is a web application framework for Node.js. It is designed for building web applications and APIs.

import express from "express";
import productsRouters from "./routes/products.js";

const app = express();
const PORT = "3000";

// because we are sending JSON data to the server, we need to use the body-parser middleware to parse the JSON data.
// JS is line by line execution, so we need to use the body-parser middleware before the routes.
app.use(express.json());
app.use("/products", productsRouters);

app.get("/", (req, res) => {
  res.send("hello world");
});

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
