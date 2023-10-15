import './App.css';
import {Link,Route,Switch,BrowserRouter} from "react-router-dom";
import Login from "./Login";
import Tasks from "./Tasks";
import ForgotPass from "./ForgotPass";
import Otp from "./Otp";

import Signin from './pages/signin'
import Forgotpassword from './pages/forgotpassword';
import Signup from './pages/signup';
import Dashboard from './pages/dashboard';
import './App.css';
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import  HeaderComponent from './components/HeaderComponent'
import pageNotFound from './pages/pageNotFound';
import EDashboard from './epages/edashboard';
import Footer from './Footer';

function App() {

return (
  <div className="background">
    <HeaderComponent/>
    <br />
    <BrowserRouter>
      <div className="container">
        <Switch>
          <Route path="/" exact component={Signin} />
          <Route path="/signin" component={Signin} />
          <Route path="/forgetpassword" component={Forgotpassword} />
          <Route path="/signup" component={Signup} />
          <Route path="/dashboard" component={Dashboard} />
          
          <Route path="/edashboard" component={EDashboard} />
          
          <Route path="*" component={pageNotFound} />
          
          
          

        </Switch>
      </div>
      <br /><br />
    </BrowserRouter>
    <Footer/>
    {/* <ToastContainer theme="light"/> */}
    <ToastContainer
position="top-center"
autoClose={2000}
hideProgressBar={false}
newestOnTop={false}
closeOnClick
rtl={false}
pauseOnFocusLoss
draggable
pauseOnHover
/>
  </div>
)
}


export default App;
