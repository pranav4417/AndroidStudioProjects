# SQLite App in Android Studio (Java)

This project is an Android application that demonstrates how to integrate and utilize SQLite for local data storage. The app is developed using **Java** in **Android Studio**.

## Features
- Add, update, delete, and retrieve data from an SQLite database.
- Simple and user-friendly interface.
- Demonstrates CRUD (Create, Read, Update, Delete) operations.

## Prerequisites
- **Android Studio** installed on your system.
- **Java Development Kit (JDK)**.
- Basic understanding of Android development and SQLite.

## Project Structure
### Main Components:
- **MainActivity.java**: The entry point of the app, handles UI interactions and invokes database operations.
- **DatabaseHelper.java**: Manages SQLite database creation, versioning, and CRUD methods.
- **activity_main.xml**: Defines the layout of the main screen.
- **AndroidManifest.xml**: Specifies app permissions and configurations.

## Installation
1. Clone this repository or download the source code.
2. Open the project in Android Studio.
3. Sync the project with Gradle by clicking on `File > Sync Project with Gradle Files`.
4. Build and run the app on an emulator or a physical device.

## Usage
1. Launch the app.
2. Use the input fields and buttons provided to perform database operations:
   - **Add Data**: Enter details and click the "Add" button.
   - **View Data**: Click "View All" to retrieve and display all records.
   - **Update Data**: Specify the record to update and modify the fields.
   - **Delete Data**: Provide the record ID and delete it.
