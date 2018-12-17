# LogWire Log Analyzer
A tool for parsing through weblogs. Both front-end and back-end are co-located in one repo for convenience.


#Back End Directions#

Requires at least Java 8

You can either use my hosted database or plug in your own.

If you want to use my hosted MySQL database, please email mplemberg@gmail.com with your IP address so that it can be granted access.
If you wish to use your own databse, please update the database properties in the application.properties file and set "spring.jpa.hibernate.ddl-auto" to "create"

To run the API you can either:

1. Import into a java IDE and select run
2. Use mvn to create an executable jar, "mvn install", and run the following command in the command line "java -jar logwire-api-BETA.jar"
3. Run the provided executable jar by running the following command in the command line "java -jar logwire-api-BETA.jar"

#Front End Directions#
1.npm install
2.Make sure API is running at http://localhost:8080, if otherwise update the API url in webpack.config.js
3.npm start
4."oooo ahhhh nice"


