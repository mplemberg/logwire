# LogWire Log Analyzer
A tool for parsing through weblogs. Both front-end and back-end are co-located in one repo for convenience.

# Back End Directions

Requires at least Java 8

You have the option of using the pre-configured MySQL database or your own.
If you wish to use the hosted MySQL database, please email mplemberg@gmail.com with your IP address so that you can be granted access.
If you wish to use your own databse, please update the database properties in the application.properties file and set the value of "spring.jpa.hibernate.ddl-auto" to "create".

To run the API you can either:

1. Import the "back-end/logwire-api" into a java IDE and select run
2. Use mvn to create an executable jar, "mvn install", and run the following command in the command line: "java -jar logwire-api-BETA.jar"
3. Run the provided executable jar by running the following command in the command line "java -jar logwire-api-BETA.jar"

If you are running an executable jar, please make sure a copy the "application.properties" file is in the same directory you are running from

# Front End Directions

1. run "npm install"
2. Make sure the API is running at http://localhost:8080, if otherwise be sure to update the API url in webpack.config.js
3. run "npm start"
4. say "oooo ahhhh nice"


