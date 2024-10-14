import ProductList from "./components/home/productList"
import SignUp from "./components/signup/signup"
import SignIn from "./components/signin/signin"
import Layout from "./components/layout/layout";
import ManageProduct from "./components/manageProduct/manageProduct";

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
            },
            {
                path: '/manageProduct',
                element: <ManageProduct></ManageProduct>
            }
        ]
    }
]

export default routes;