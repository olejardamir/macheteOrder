# About

Please note, only those functions that have been assigned have been developed, otherwise, it would not be following the assigned task(s). The extra functions as well as the improvements to a code have been listed under the "Improvements for the future release" section. Furthermore, we were asked to list the characters, while instead, we had to list the actors (this error has been confirmed via e-mail).

This is a tutorial on how to run this repository, assuming a blank copy of Ubuntu 18.04.2 LTS.

The level of this document is intermediate for any Linux user.

Please choose the steps that you need, should you like to speed-up the setup process.

Technology stack is: MySQL (Maria fork) for database, Spring-Boot for the backend, and React.js for the front-end service.

Everything will be done with the Chrome browser given the CORS plugin that works out-of-box.

## Main Setup

$ sudo apt-get update && sudo apt-get upgrade

### Git and clone

$ sudo apt-get install git

$ git clone https://github.com/olejardamir/macheteOrder.git


### Lamp stack with phpmyadmin (admin/admin has all SQL privileges)


$ sudo apt install apache2

$ sudo apt install mariadb-server mariadb-client

$ sudo apt install php php-common php-mysql php-gd php-cli 

$ sudo apt install phpmyadmin

[select apache, format db, and enter your db password to use]

$ sudo systemctl restart apache2

$ sudo mysql -u root -p


MariaDB [(none)]> CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';

MariaDB [(none)]> GRANT ALL PRIVILEGES ON \*.\* TO 'admin'@'localhost' WITH GRANT OPTION;

MariaDB [(none)]> FLUSH PRIVILEGES;

MariaDB [(none)]> exit

### Database Setup

[You can do this from phpmyadmin, or follow the steps below to load the starwars.sql]

$ cd macheteOrder/

$ sudo mysql -u root -p

MariaDB [(none)]> CREATE DATABASE starwars;

MariaDB [dbname]> USE starwars;

MariaDB [(none)]> exit

$ mysql -u admin -p starwars < starwars.sql

### Java and Maven

$ sudo apt-get install maven

$ sudo apt install default-jdk

### React.js
$ sudo apt install curl

$ curl -sL https://deb.nodesource.com/setup_12.x | sudo -E bash -

$ sudo apt-get install -y nodejs

$ sudo npm install -g create-react-app

$ cd ~/macheteOrder/machete_frontend

$ sudo chown -R $USER:$(id -gn $USER) /home/YOUR_HOME_DIR/.config

$ npm install

$ npm run

[if it doesn't start: https://github.com/facebook/create-react-app/issues/3690]

$ sudo rm -R node_modules

$ npm install

$ npm start

### Backend project setup and run
[Open a new terminal window or tab while react is running]

$ cd ~/macheteOrder/machete/machete

[edit the target release from 1.11 to 1.8]

$ nano pom.xml

[locate <java.version>1.11</java.version> and change to <java.version>1.8</java.version>]

^x y

$ mvn clean install

$ mvn spring-boot:run

## React Setup and Run

### Chrome and CORS
[go to https://www.google.com/chrome/ and download and run/install the deb package]

[install CORS plugin in Chrome https://chrome.google.com/webstore/detail/allow-cors-access-control/lhobafahddgcelffkeicbaginigeejlf?hl=en]

# Final Application Run
Go to http://localhost:8080/ (in Chrome)

Press the CORS plugin button (upper right corner) to activate it

Reload

Result:

![The Webpage result](https://raw.githubusercontent.com/olejardamir/macheteOrder/master/screenshot.png)


# General Overview of the Spring Boot Functions
The SQL schemas are empty. The provided APIs are used to scrape the data into SQL for the further usage. Spring Boot has provided us with the function evoked as ... in order to run anything we want as soon as the Beans are established and before the application starts. This has several advantages and disadvantages. For example, advantage is that we need to call the APIs in only one session and never again. This is good if there is a usage limit, security, etc. The disadvantage is not being able to get any updated information as soon as the updates happen, while updating may be a costly procedure. Since the Films, Titles, and Actors as well as IMDB id-key will never change and remain static, having the scrape is proper in this case.

# General Overview of the Database Tables
No extra data or columns were entered. All tables are in NF1 given the simplicity of a task that we are performing. Furthermore, there is no need for any further normalization since it would simply complicate the queries and slow-down the processing as well as the production. Also, it is worth mentioning that all the id-s are autoincremented and timestamps generated by the SQL as UTC Linux Timestamp rather than having to pass this data from the front or the backend (and cause potential issues that can arise from the timezones, date-formats, etc).

There are 3 tables. One table (films) represents the scraped data, other (queries) represents the actions the user performed, and third table (favourites) represents the saved favourite films that user chose from the UI.

Instead of constantly connecting to an API and potentially abusing the calls, we are scraping all the data that we need, and if we need it; except the images that would have been kept in a BLOB (but weren't only to keep the production simpler). This way, we are calling the APIs only once. The cons of this approach is that having a dynamic database with an API would require a constant updating and/or a very frequent API use and a communication with our server(s). The reason for choosing to scrape and organize the database only once is because it reduces the complications easily caused by the improper language practices Javascript is known for.

Each time we sort/toggle the order of the films, the request is recored in the history. Furthermore, we also record user selecting their favourite film as an action as well as the favourite film to be entered in a database.

In order to get as much data as we can, we are not updating the favourite film, but keeping a track of the whole history. The last film can be always obtained by getting an ascending order of an IP address according to a table id, and limiting the result to 1. This, however, has not been implemented since the specifications did not ask us to do it.


# General Overview of the React.js Functions

# Improvements for the future release
