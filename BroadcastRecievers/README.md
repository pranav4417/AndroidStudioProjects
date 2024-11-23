# Broadcast Receiver in Android

This project demonstrates the implementation of a **Broadcast Receiver** in an Android application. It shows how to listen for system or custom events and execute code in response.

## Features
- **System Broadcast Receiver**: Responds to system-generated events like connectivity changes or battery levels.
- **Custom Broadcast Receiver**: Sends and receives custom intents between components of the app.
- **User-Friendly Example**: Displays received broadcast messages in the app.
- Supports Android 12 and above.

## Requirements
- **Android Studio**: Latest version recommended.
- **Android SDK**: API Level 31 (Android 12) or higher.
- **Java/Kotlin**: For programming the functionality.

## How It Works
1. **Broadcast Receiver**: Listens for specific broadcasts (system or custom).
2. **System Broadcast Example**: Monitors connectivity changes (e.g., Wi-Fi on/off).
3. **Custom Broadcast Example**: Sends a custom intent and listens for it within the app.

## Installation
1. Clone this repository or download the source code.
2. Open the project in Android Studio.
3. Sync Gradle files and ensure dependencies are installed.
4. Run the project on an emulator or a physical device running Android 12 or above.

## Usage
1. Register a broadcast receiver in the `AndroidManifest.xml` file or dynamically in the code.
2. Create a receiver class that extends `BroadcastReceiver` and override the `onReceive()` method.
3. Use the following code snippets:

### Registering a System Broadcast Receiver

Add the following to your `AndroidManifest.xml` file:
```xml
<receiver android:name=".MyBroadcastReceiver">
    <intent-filter>
        <action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
    </intent-filter>
</receiver>
```
### Creating a Custom Broadcast Receiver
```java
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Handle broadcast message
        String action = intent.getAction();
        if ("com.example.CUSTOM_INTENT".equals(action)) {
            String message = intent.getStringExtra("message");
            Toast.makeText(context, "Received: " + message, Toast.LENGTH_SHORT).show();
        }
    }
}
```
### Sending a Custom Broadcast
```java
Intent intent = new Intent("com.example.CUSTOM_INTENT");
intent.putExtra("message", "Hello from the sender!");
sendBroadcast(intent);
```
### Dynamically Registering a Receiver
```java
MyBroadcastReceiver receiver = new MyBroadcastReceiver();
IntentFilter filter = new IntentFilter("com.example.CUSTOM_INTENT");
registerReceiver(receiver, filter);
```

## Author
**Pranav Kandakurthi**  
*CSE Student at Presidency University, Bangalore*  

This file includes all the necessary details and properly formatted code snippets for better readability. Let me know if you'd like further customization!



