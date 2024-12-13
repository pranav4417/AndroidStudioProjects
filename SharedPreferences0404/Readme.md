# SharedPreferences App in Android Studio (Java)

This project is an Android application that demonstrates how to use **SharedPreferences** for storing and retrieving small amounts of data locally. The app is developed using **Java** in **Android Studio**.

## Features
- Save, update, and retrieve key-value pairs using SharedPreferences.
- Simple and efficient data storage mechanism.
- User-friendly interface.

## Prerequisites
- **Android Studio** installed on your system.
- **Java Development Kit (JDK)**.
- Basic understanding of Android development and SharedPreferences.

## Project Structure
### Main Components:
- **MainActivity.java**: The entry point of the app, handles UI interactions and SharedPreferences operations.
- **activity_main.xml**: Defines the layout of the main screen.
- **AndroidManifest.xml**: Specifies app configurations.

## Installation
1. Clone this repository or download the source code.
2. Open the project in Android Studio.
3. Sync the project with Gradle by clicking on `File > Sync Project with Gradle Files`.
4. Build and run the app on an emulator or a physical device.

## Usage
1. Launch the app.
2. Use the input fields and buttons provided to:
   - **Save Data**: Enter a key and value, then save it.
   - **Retrieve Data**: Enter a key to retrieve the corresponding value.
   - **Update Data**: Modify the value for an existing key.
   - **Delete Data**: Remove a key-value pair.

## Code Highlights
### Saving Data
```java
SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPreferences.edit();
editor.putString("key", "value");
editor.apply();
```

### Retrieving Data
```java
SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
String value = sharedPreferences.getString("key", "default_value");
```

### Deleting Data
```java
SharedPreferences.Editor editor = sharedPreferences.edit();
editor.remove("key");
editor.apply();
```

## Permissions
No special permissions are required for SharedPreferences.

## Screenshots
1. **Main Screen**
   - Save and retrieve key-value pairs.

2. **Data Operations**
   - Perform CRUD operations on SharedPreferences.

## License
This project is open-source and available under the [MIT License](LICENSE).

---
