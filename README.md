# OppgaveHub

OppgaveHub is a simple web application developed with Kotlin and Spring Boot.

The application allows users to view and create tasks. The tasks are stored in an H2 database and can also be accessed through a REST API.

## Technologies

- Kotlin
- Spring Boot
- Thymeleaf
- H2 Database
- JDBC / JdbcClient
- Gradle
- HTML
- CSS

## Features

- Home page
- Task overview page
- About page
- Reusable Thymeleaf fragments for navigation and footer
- Create task form using POST
- File-based H2 database
- Two related database tables: `brukere` and `oppgaver`
- Foreign key relationship between users and tasks
- SQL JOIN between the two tables
- REST API for retrieving and creating tasks
- Persistent data stored in the H2 database

## Project Structure

```text
src/
└── main/
    ├── kotlin/
    │   └── oppgavehub/
    │       ├── Oppgave.kt
    │       ├── OppgaveMedBruker.kt
    │       ├── OppgaveRepository.kt
    │       ├── OppgaveApiController.kt
    │       ├── PageController.kt
    │       └── OppgavehubApplication.kt
    │
    └── resources/
        ├── static/
        │   └── style.css
        ├── templates/
        │   ├── fragments/
        │   │   └── fragments.html
        │   ├── index.html
        │   ├── oppgaver.html
        │   └── om.html
        ├── application.properties
        └── schema.sql
Database

The application uses a file-based H2 database.

The database schema is defined in:

src/main/resources/schema.sql

The database contains two related tables:

brukere
oppgaver

The oppgaver table contains a foreign key to brukere.

The application also uses a SQL JOIN to retrieve task information together with user information.

Running the Application

Make sure Java 17 is installed.

From the project root, run:

.\gradlew.bat bootRun

The application will start on:

http://localhost:8080
Web Pages
Home
http://localhost:8080/
Tasks
http://localhost:8080/oppgaver
About
http://localhost:8080/om
REST API
Get all tasks
GET /api/oppgaver

Example:

http://localhost:8080/api/oppgaver
Create a task
POST /api/oppgaver

Example request body:

{
  "tittel": "API oppgave",
  "beskrivelse": "Opprettet med POST API"
}

The task is stored in the H2 database.

H2 Console

The H2 Console is available at:

http://localhost:8080/h2-console

Database URL:

jdbc:h2:file:./data/oppgaver

Username:

sa

Password:

Testing

The REST API has been tested using GET and POST requests.

The application has also been stopped and restarted to verify that tasks remain stored in the file-based H2 database.

Git

The project uses Git for version control.

The H2 database files in the data/ directory are excluded from Git using .gitignore.

The database schema in schema.sql is included in the repository.