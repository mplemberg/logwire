import React from 'react';
import {Form, Input, Button, Label} from 'semantic-ui-react';
import MaskedInput from 'react-text-mask';
const SearchControls = ({handleSearchChange, handleStartDateChange, handleEndDateChange, handleSearchSelect}) => {
  return (
    <Form size='large'>
      <Form.Group inline>
          <Form.Field>
              <Input  placeholder="Contains text" onChange={handleSearchChange} />
          </Form.Field>

          <Form.Field >
              <Label>From</Label>
              <MaskedInput
                  mask={[/[0-1]/, /[0-9]/, '/', /[0-3]/, /[0-9]/, '/', /[1-2]/, /[0-9]/, /[0-9]/, /[0-9]/, ' ', /[0-2]/, /[0-9]/, ':', /[0-5]/, /[0-9]/, ':', /[0-5]/, /[0-9]/]}
                  placeholder="MM/DD/YYYY HH:mm:ss"
                  size='25'
                  onChange={handleStartDateChange}
              />
          </Form.Field>
          <Form.Field >
              <Label>To</Label>
              <MaskedInput
                  mask={[/[0-1]/, /[0-9]/, '/', /[0-3]/, /[0-9]/, '/', /[1-2]/, /[0-9]/, /[0-9]/, /[0-9]/, ' ', /[0-2]/, /[0-9]/, ':', /[0-5]/, /[0-9]/, ':', /[0-5]/, /[0-9]/]}
                  placeholder="MM/DD/YYYY HH:mm:ss"
                  onChange={handleEndDateChange}
                  size='25'
              />
          </Form.Field>
          <Form.Field >
              <Button content='Search' onClick={handleSearchSelect} />
          </Form.Field>
      </Form.Group>
    </Form>
  );
};

export default SearchControls;