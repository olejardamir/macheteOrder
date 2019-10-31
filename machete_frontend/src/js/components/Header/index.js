import React, { Component } from 'react'
import { Link } from 'react-router-dom'


class Header extends Component {

    render() {
        return (
            <header>
                <h1 className="title">Star Wars, The Machete Order</h1>
                <h4>Sort the films in a machete order, by clicking the "Show machete view" button below.</h4>
                <h4>Click on checkbox and on a "Save my favourite film" button to save it in a database.</h4>
            </header>
        )
    }
}

export default Header;