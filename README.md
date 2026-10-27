# HospitalProject
Java JDBC Patient Management System
# Java JDBC Patient Management System

A simple Patient Management System built using **Java, JDBC, and MySQL**. The application stores patient information in a MySQL database and allows users to register patients, search for patients by ID, view appointments by doctor, and display all patient records.

## Features

- **Register Patient:** Store patient ID, name, age, contact details, doctor name, and appointment date.
- **Search Patient by ID:** Retrieve a patient's information using their unique patient ID.
- **Appointments by Doctor:** Display patients and appointment dates for a selected doctor.
- **Display All Patients:** View all patient records stored in the database.

## Technologies Used

- Java 26.0.2
- MySQL
- JDBC (Java Database Connectivity)
- MySQL Connector/J 26.10.0
- Visual Studio Code
- MySQL Workbench

## Prerequisites

Before running the project, install or configure the following:

1. Java Development Kit (JDK) 26.0.2 or a compatible JDK.
2. MySQL Server.
3. MySQL Workbench.
4. Visual Studio Code.
5. MySQL Connector/J JDBC driver.

## Database Setup

The project uses a database named `hospital2` and a table named `patients`.

Open MySQL Workbench, connect to your local MySQL server, open a new SQL query tab, and execute the following SQL:

```sql
CREATE DATABASE IF NOT EXISTS hospital2;

USE hospital2;

CREATE TABLE IF NOT EXISTS patients (
    patient_id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    contact VARCHAR(15),
    doctor VARCHAR(50),
    appointment_date DATE
);
```

The table stores the following information:

| Column | Description |
|---|---|
| `patient_id` | Unique patient ID and primary key |
| `name` | Patient's name |
| `age` | Patient's age |
| `contact` | Patient's contact number |
| `doctor` | Assigned doctor's name |
| `appointment_date` | Scheduled appointment date |

To verify the table, execute:

```sql
USE hospital2;
SELECT * FROM patients;
```

## How JDBC Connects Java to MySQL

JDBC stands for **Java Database Connectivity**. It is a Java API that allows Java applications to communicate with databases.

This project uses MySQL Connector/J, which is the JDBC driver for MySQL.

The connection process works as follows:

1. Java loads and uses the MySQL JDBC driver.
2. `DriverManager.getConnection()` establishes a connection to the local MySQL server.
3. The connection specifies the database URL, username, and password.
4. `PreparedStatement` executes parameterized SQL queries to insert or retrieve patient information.
5. `ResultSet` reads the records returned by SELECT queries.
6. The connection is closed after the application finishes.

The JDBC connection URL used by this project is:

```java
jdbc:mysql://localhost:3306/hospital2
```

Here:
- `localhost` refers to the local MySQL server.
- `3306` is the default MySQL port.
- `hospital2` is the database name.

The Java connection configuration follows this general structure:

```java
String url = "jdbc:mysql://localhost:3306/hospital2";
String user = "root";
String password = "YOUR_MYSQL_PASSWORD";

Connection con =
    DriverManager.getConnection(url, user, password);
```

Replace the password placeholder with your actual MySQL password locally. Never commit real credentials to GitHub.

## Project Setup on Windows

### 1. Download MySQL Connector/J

Download MySQL Connector/J from the official MySQL website:

https://dev.mysql.com/downloads/connector/j/

Extract the downloaded archive if necessary and locate the JAR file.

For this project, the JAR file is:

`mysql-connector-j-26.10.0.jar`

Place it in the same folder as `PatientManagement.java`.

Your project folder should look like this:

```text
HospitalProject/
├── PatientManagement.java
└── mysql-connector-j-26.10.0.jar
```

### 2. Open the Project in VS Code

Open the `HospitalProject` folder in Visual Studio Code.

Ensure that the Java source file and the MySQL Connector/J JAR file are present in the folder.

### 3. Configure Database Credentials

Open `PatientManagement.java` and configure the database connection with your local MySQL username and password.

Do not upload your actual password to a public repository.

### 4. Compile the Java Program

Open the VS Code terminal and navigate to the project directory.

Run:

```powershell
javac -cp ".;mysql-connector-j-26.10.0.jar" PatientManagement.java
```

If compilation succeeds, Java creates `PatientManagement.class`.

### 5. Run the Application

Execute:

```powershell
java -cp ".;mysql-connector-j-26.10.0.jar" PatientManagement
```

The application should display a menu similar to this:

```text
1. Register Patient
2. Search by Patient ID
3. Appointments by Doctor
4. Display All Patients
5. Exit

Enter choice:
```

## How to Use the Application

### Option 1: Register Patient

Enter the patient ID, name, age, contact number, doctor's name, and appointment date.

Use the date format `YYYY-MM-DD`, for example:

`2026-10-28`

The application inserts the patient information into the MySQL database.

### Option 2: Search by Patient ID

Enter an existing patient ID. The application retrieves and displays the matching patient's details.

If the ID does not exist, the application displays a patient-not-found message.

### Option 3: Display Appointments by Doctor

Enter the doctor's name exactly as it is stored in the database.

The application displays the matching patients and their appointment dates.

### Option 4: Display All Patients

Displays all patient records currently stored in the database.

### Option 5: Exit

Closes the application and database connection.

## Example SQL Queries

View all patients:

```sql
SELECT * FROM patients;
```

Search for a specific patient:

```sql
SELECT * FROM patients
WHERE patient_id = 101;
```

Display appointments for a doctor:

```sql
SELECT patient_id, name, appointment_date
FROM patients
WHERE doctor = 'Dr Kumar';
```

## Security Notes

- Never commit your real MySQL password, database credentials, or other secrets to GitHub.
- Do not upload database dumps containing real patient information.
- Use `PreparedStatement` for parameterized SQL queries to help prevent SQL injection.
- For a production application, use environment variables or a secure secrets manager instead of hardcoding database credentials.
- Use appropriate database permissions rather than granting unnecessary privileges to the application.

## Troubleshooting

**No suitable driver found**

Ensure that the MySQL Connector/J JAR file exists in the project folder and is included in the classpath when compiling and running the program.

**Access denied for user**

Verify your MySQL username and password and ensure that the account has permission to access the `hospital2` database.

**Unknown database**

Create the `hospital2` database in MySQL Workbench before running the Java program.

**Duplicate entry for primary key**

Every patient must have a unique patient ID. Use a new ID when registering a different patient.

**Connection refused**

Ensure that MySQL Server is running and that the connection URL and port are correct.

## Conclusion

This project demonstrates the use of Java JDBC to connect a Java application to a MySQL database. It implements basic patient record management and appointment lookup operations using SQL queries and Java database connectivity.

The project is intended for learning and academic demonstration purposes.
