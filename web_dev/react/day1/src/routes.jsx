import ProductList from "./components/home/productList"
import SignUp from "./components/signup/signup"

const routes = [
    {
        path: '/',
        element: <ProductList></ProductList>
    },
    {
        path: '/signup',
        element: <SignUp></SignUp>
    }
]

export default routes;