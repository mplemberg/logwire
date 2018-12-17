import React from 'react';
import { Header, Container} from 'semantic-ui-react';
import WebLogsService from '../services/WebLogsService';
import SearchControls from './SearchControls';
import SearchResults from './SearchResults';
import ErrorMessage from './ErrorMessage';

class WebLogsPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            webLogs:[],
            searchValue:"",
            startDate:"",
            endDate:"",
            isLoading:false,
            error:""
        };
      };

    componentDidMount() {
        this.setStartingSearchState();
        WebLogsService.getAll()
            .then(
                page => {
                    this.setState({webLogs: page.content});
                },
                error => {
                    this.setState({error: error});
                }
            ).catch(
                error => {
                    this.setState({error: error});
                }
            ).finally(
                () => {
                    this.setState({isLoading: false});
                }
            );
    };
    handleSearchChange = (e, {value}) => {
        this.setState({searchValue: value});
    };

    handleStartDateChange = (e) => {
        this.setState({startDate: e.target.value});
    };

    handleEndDateChange = (e) => {
        this.setState({endDate: e.target.value});
    };

    setStartingSearchState = () => {
        this.setState({
            isLoading: true, 
            webLogs:[],
            error:''
        });
    }
    handleSearchSelect = () => {
        this.setStartingSearchState();
        WebLogsService.search({
            searchValue: this.state.searchValue, 
            startDate: this.state.startDate, 
            endDate: this.state.endDate
        }).then(
            page => {
                this.setState({
                    webLogs: page.content
                });
            },
            error => {
                this.setState({error: error});
            }
        ).catch(
            error => {
                this.setState({error: error});
            }
        ).finally(
            () => {
                this.setState({isLoading: false});
            }
        );
    };

    render() {
        const { webLogs, isLoading, error} = this.state;
        return (
            <React.Fragment>
                <Header as='h1' block textAlign='center' color='teal'>LogWire</Header>
                <Container>
                    <SearchControls 
                        handleSearchChange={this.handleSearchChange} 
                        handleSearchSelect={this.handleSearchSelect}
                        handleStartDateChange={this.handleStartDateChange}
                        handleEndDateChange={this.handleEndDateChange}
                    />
                    <ErrorMessage message={error}/>
                    <SearchResults 
                        webLogs={webLogs}
                        isLoading={isLoading}
                    />
                </Container>
            </React.Fragment>
        );
    }
}

export default WebLogsPage;