import React from 'react';
import {Segment, Loader, Dimmer, Table} from 'semantic-ui-react';
import Moment from 'react-moment';

const SearchResults = ({webLogs, isLoading}) => {
  let isLogsFound = webLogs.length > 0 && !isLoading;
  let isNoLogsFound = webLogs.length == 0 && !isLoading;
  
  return (
    <Table celled padded>
      <Table.Header>
          <Table.Row>
              <Table.HeaderCell>Time</Table.HeaderCell>
              <Table.HeaderCell>IP</Table.HeaderCell>
              <Table.HeaderCell>Resource</Table.HeaderCell>
              <Table.HeaderCell>HTTP Method</Table.HeaderCell>
              <Table.HeaderCell>Duration</Table.HeaderCell>
              <Table.HeaderCell>Response Code</Table.HeaderCell>
              <Table.HeaderCell>Raw</Table.HeaderCell>
          </Table.Row>
      </Table.Header>
      <Table.Body>
          {isLogsFound &&
              webLogs.map((webLogEntry, index) =>
                  <Table.Row key={webLogEntry.id}>
                      <Table.Cell>
                          <Moment format="MM/DD/YYYY HH:mm:ss">
                              {webLogEntry.requestDateTime}
                          </Moment>
                      </Table.Cell>
                      <Table.Cell>
                          {webLogEntry.ipAddress}
                      </Table.Cell>
                      <Table.Cell>
                          {webLogEntry.resourcePath}
                      </Table.Cell>
                      <Table.Cell>
                          {webLogEntry.requestMethod}
                      </Table.Cell>
                      <Table.Cell>
                          {webLogEntry.requestDurationValue + webLogEntry.requestDurationUnit}
                      </Table.Cell>
                      <Table.Cell>
                          {webLogEntry.responseCode}
                      </Table.Cell>
                      <Table.Cell>
                          {webLogEntry.rawText}
                      </Table.Cell>
                  </Table.Row>
              )
          }

          {
              isNoLogsFound &&
              <Table.Row>
                <Table.Cell colSpan='7'>
                    No Results Found
                </Table.Cell>
              </Table.Row>
          }

          {   isLoading &&
              <Table.Row>
                  <Table.Cell colSpan='7'>
                      <Segment padded>
                      <Dimmer active inverted>
                          <Loader />
                      </Dimmer>
                      </Segment>
                  </Table.Cell>
              </Table.Row>
          }
      </Table.Body>
    </Table>
  );
};

export default SearchResults;