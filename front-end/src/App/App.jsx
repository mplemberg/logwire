import React from 'react';
import { Router, Route } from 'react-router-dom';
import history from '../helpers/history';
import WebLogsPage from '../WebLogsPage/WebLogsPage';


class App extends React.Component {
    render() {
        //Don't need routes right out the gate but putting this in place for convenience
        //TODO: Once another page needs to be added, introduce redux
        return (
            <Router history={history}>
                <div>
                    <Route path="/" component={WebLogsPage} />
                </div>
            </Router>
        );
    }
}

export default App; 