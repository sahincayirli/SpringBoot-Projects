import React, { Component } from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Category from './Category';
import Home from './Home';
import Expenses from './Expenses';

class App extends Component {
    state = {  }
    render() { 
        return ( 
            <Router>
                <Switch>
                    <Route path = '/' exact = {true} component = {Home}></Route>
                    <Route path = '/categories' exact = {true} component = {Category}></Route>
                    <Route path = '/expenses' exact = {true} component = {Expenses}></Route>
                    <Route path = '/home' exact = {true} component = {Home}></Route>
                </Switch>
            </Router>
         );
    }
}
 
export default App;