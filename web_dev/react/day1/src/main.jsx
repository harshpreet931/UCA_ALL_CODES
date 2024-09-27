import { createRoot } from "react-dom/client";
import App from "./App";
// Components are in PascalCase, and files are in camelCase.

const reactProjectRoot = createRoot(document.getElementById("root"));

reactProjectRoot.render(<App />);
