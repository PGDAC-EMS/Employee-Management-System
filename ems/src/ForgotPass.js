import './common.css';
import {useEffect, useState} from 'react';
import './images/backgroundImg.jpg';

function ForgotPass(){

    useEffect(()=>{
        document.body.classList.add('background');
    },[]);

    
    
    return (<div >
        <p />
        <div className="box-form">
	    <div className="left">
		    <div className="floating">
		        <h1>Employee Management System</h1>
                <br/><br/>
		        <p >Ultimate solution for managing productivity and Information</p>
            </div>
	    </div>
	
	
		<div className="right">
		<h5>Reset Password</h5>
            <br/><br/><br/><br/>
            <div style = {{float:"left", fontFamily:"unset"}}>Enter the registered email Id *</div>
		    <div className="inputs" style = {{padding:"0"}}>
                
			    <input type="email" placeholder="example@gmail.com"/>
			
		    </div>
			
			<br/><br/>
			    <br/>
			    <button>Send OTP</button>
	    </div>
	
        </div>
    </div>
    )
}

export default ForgotPass;