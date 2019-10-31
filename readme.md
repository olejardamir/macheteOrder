# About
This is a tutorial on how to run this repository, assuming a blank copy of Ubuntu 18.04.2 LTS.

The level of this document is intermediate for any Linux user.

Please choose the steps that you need, should you like to speed-up the setup process.

Technology stack is: MySQL (Maria fork) for database, Spring-Boot for the backend, and React.js for the front-end service.

Everything will be done with the Chrome browser given the CORS plugin that works out-of-box.

## Main Setup

## Database Setup
## Spring Boot Setup and Run
mvn clean install
mvn spring-boot:run

## React Setup and Run

## Additional tools
CORS plugin for Chrome

# General Overview of the Database Tables
No extra data or columns, other than what was necessary to complete the task was entered. All tables are in NF1 given the simplicity of a task that we are performing. Furthermore, there is no need for any further normalization since it would simply complicate the queries and slow-down the processing as well as the production.

There are 3 tables. One table represents the scraped data, other represents the actions the user performed, and third table represents the saved favourite films that user chose from the UI.

Instead of constantly connecting to an API and abusing the calls, we are scraping all the data that we need, and if we need it; except the images that would have been kept in a BLOB. This way, we are calling the APIs only once. The cons of this approach is that having a dynamic database with an API would require a constant updating and/or a very frequent API use and a communication with our server(s). The reason for choosing to scrape and organize the database only once is because it reduces the complications easily caused by the improper language practices Javascript is known for.


# General Overview of the Spring Boot Functions
# General Overview of the React.js Functions
