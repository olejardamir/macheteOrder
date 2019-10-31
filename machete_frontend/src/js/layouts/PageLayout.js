import React, { Component } from 'react'



// Layout
import Header from '../components/Header';

class PageLayout extends Component {
    render() {
        return (
            <div className="layoutRoot">
                <Header />
                <div className="pageContent">
                    {this.props.children}
                </div>
            </div>
        )
    }
}

export default PageLayout;