import React from 'react';
import { Message } from 'semantic-ui-react'
const ErrorMessage = ({message}) => {
  return (
    <React.Fragment>
      {
        message && message.length > 0 &&
        <Message negative>
          <Message.Header>{message}</Message.Header>
        </Message>
      }
    </React.Fragment>
  );
};

export default ErrorMessage;