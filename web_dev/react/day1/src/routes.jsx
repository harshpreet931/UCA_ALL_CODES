import ProductList from "./components/home/productList"
import SignUp from "./components/signup/signup"
import SignIn from "./components/signin/signin"
import Layout from "./components/layout/layout";

const routes = [
    {
        path: '/',
        element: <Layout></Layout>,
        children:
        [
            {
                path: '/',
                element: <ProductList></ProductList>
            },
            {
                path: '/signup',
                element: <SignUp></SignUp>
            },
            {
                path: '/signin',
                element: <SignIn></SignIn>
            }
        ]
    }
]

export default routes;