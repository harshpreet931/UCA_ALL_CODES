import express from "express";
import fileSystem from "fs";

const router = express.Router();

router.get("/", (req, res) => {
  let fileData = fileSystem.readFileSync("./db.json", { encoding: "utf-8" });
  let obj = JSON.parse(fileData);

  if (obj) {
    res.status(200).send(obj.products);
  }
});

router.post("/", (req, res) => {
    const product = req.body;
    console.log(product);
  
    // logic to update the content in the file and send the respone
    let db;
    try {
      db = fileSystem.readFileSync("./db.json", { encoding: "utf-8" });
    } catch (error) {
      if (error.code === "ENOENT") {
        return res.status(404).send({ error: "File not found" });
      } else {
        return res.status(500).send({ error: error.message });
      }
    }
  
    let db_obj = JSON.parse(db);
    let products = db_obj.products;
    let newProductList = [...products, product];
    db_obj.products = newProductList;
  
    try {
      fileSystem.writeFileSync("./db.json", JSON.stringify(db_obj));
      res.status(201).send("Product added successfully");
    } catch (error) {
      res.status(500).send({ error: error });
    }
  });

export default router;
