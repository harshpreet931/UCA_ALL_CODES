import { createRoot } from "react-dom/client";
import App from "./app";
// Components are in PascalCase, and files are in camelCase.

// Bootstrapping a react application is to install the react and react-dom packages and to create the index.html file with the root div element.
// i.e initializing the react application
const reactProjectRoot = createRoot(document.getElementById("root"));

reactProjectRoot.render(<App />);
