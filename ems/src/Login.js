import './common.css';
import {useEffect, useState} from 'react';
import './images/backgroundImg.jpg';

function Login(){

    useEffect(()=>{
        document.body.classList.add('background');
    },[]);

    return (<div>
        <p />
        <div className="box-form" >
	    <div className="left"  >
		    <div className="floating" >
		        <h1>Employee Management System</h1>
                <br/><br/>
		        <p >Ultimate solution for managing productivity and Information</p>
            </div>
	    </div>
	
	
		<div className="right">
		<h5>Login</h5>
		
		    <div className="inputs">
                
			    <input type="text" placeholder="Employee Id"/>
			    <br/>
                
			    <input type="assword" placeholder="Password"/>
		    </div>
			
			<br/><br/>
			
		    <div className="forgot-password">
			    <a href="/ForgotPass">Forgot Password?</a>
		    </div>	
			    <br/>
			    <button>Login</button>
	    </div>
	
        </div>
    </div>
    )
}

export default Login;