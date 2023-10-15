import React, { Component } from 'react'

class EHeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div><center>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div>
                        <a href="https://google.co.in" className="navbar-brand">
                            Employee Management System
                        </a>
                    </div>
                    
                    </nav>
                </header>
                </center>
            </div>
        )
    }
}

export default EHeaderComponent
