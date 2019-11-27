# WILDLIFE TRACKER

Wildlife tracker is an application designed for a Forest Service. The application allows rangers of a Forest Service to track endangered and non-endangered animals for a wildlife study.

## Versioning

 Wildlife-Tracker-v.1.0

## Author

* **Mathew Gitata**

## Features

As a user of the program you will be able to:

1. Record an animal sighting
2. Add key details of age, health and animal location to determine how close to being endangered is an animal.



## Behaviour Driven Development (BDD)
|Behaviour 	           |    Input 	                 |      Output          |
|----------------------------------------------|:-----------------------------------:|-----------------------------:|       
|Web page renders     |User inputs their username |  User redirected to a homepage.
|User selects option to view animals or sightings | User shown respective details |  Web page refreshes updating requested page
|User adds form to add animal sighting | Web page redirect | User shown updated animal specific details


### Setup Instructions

* Step 1:
Clone this repo: git clone https://github.com/gitatam/wildlife-tracker.git
* Step 2:
Open your terminal and navigate to the repo: cd wildlife-tracker
* Step 3:
Create the development and test databases and tables in psql using command:-

 `$psql < create.sql`

 If you get any errors about the databases already existing, you may need to first clear them by running

 `$psql < drop.sql`
* Step 4:
You can now go ahead and use the project.

  `gradle run`
* Step 6:
Navigate to localhost:4567 in your browser


## Technologies Used

* Java
* Spark
* HTML5, CSS3 and Bootstrap
* JUnit



## License and Copyright information

This project is licensed under the MIT License.

The MIT License (MIT)

Copyright (c) 2019, Mathew Gitata.

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
