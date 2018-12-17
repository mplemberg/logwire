import config from 'config';

let handleResponse = (promise) => {
    return promise.then(response => {
        const data = response.json();
        if (!response.ok) {
            //const error = (data && data.message) || response.statusText;
            return data.then(Promise.reject.bind(Promise));
        }
        return data;
    }).catch((error) =>{
        //the error object will be different based on if its a validation or network error
        let errorMessage = error && error.message !== undefined ? error.message : error;
        return Promise.reject(errorMessage);
    });
}

const WebLogsService = {
    getAll() {
        const requestOptions = {
            method: 'GET',
        };
    
        return handleResponse(fetch(`${config.apiUrl}/log-entries`, requestOptions));
    },
    search(searchModel){
        const requestOptions = {
            method: 'GET'
        };
    
        let url = new URL(`${config.apiUrl}/log-entries`);
        //Stringify the searchModel as params
        Object.keys(searchModel).forEach((key) => {
            if(searchModel[key] !==null && searchModel[key] !== ""){
                url.searchParams.append(key, searchModel[key]);
            }
        });
        return handleResponse(fetch(url, requestOptions));
    }
    
};

export default WebLogsService