// This is a normal function, it becomes a component when it is exported and used in the main file.

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Layout from "./components/layout/layout";
import routes from "./routes";

function App() {

    const router = createBrowserRouter(routes);

    return (
        <> 
            <Layout>
                {/* main will be passed as props to Layout */}
                {/* from child to parent a function in parent function called callback function is made to be called from the inner function */}
                <main>
                    <RouterProvider router={router}></RouterProvider>
                </main>
            </Layout>
        </>
    )
}

// we can return only one element from a component
// if we want to do multiple elements, we can use a div tag to wrap them up or <> </> which are called as fragments
export default App;