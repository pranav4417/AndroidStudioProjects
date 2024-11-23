# Fragments in Android

This project demonstrates the implementation of **Fragments** in an Android application. Fragments allow building dynamic and modular UI components that can be reused across different activities.

## Features
- **Static Fragments**: Predefined fragments defined in XML layouts.
- **Dynamic Fragments**: Added or replaced programmatically at runtime.
- **Communication**: Demonstrates communication between fragments and their parent activity.
- Supports Android 12 and above.

## Requirements
- **Android Studio**: Latest version recommended.
- **Android SDK**: API Level 31 (Android 12) or higher.
- **Java/Kotlin**: For programming the functionality.

## How It Works
1. **Static Fragments**: Added directly to the activity's XML layout.
2. **Dynamic Fragments**: Added, replaced, or removed programmatically using the FragmentManager.
3. **Communication**: Uses interfaces or ViewModel for passing data between fragments and their parent activity.

## Installation
1. Clone this repository or download the source code.
2. Open the project in Android Studio.
3. Sync Gradle files and ensure dependencies are installed.
4. Run the project on an emulator or a physical device running Android 12 or above.

## Usage

### Static Fragment
Add a fragment directly in your activity's XML layout:
```xml
<fragment
    android:id="@+id/fragment_static"
    android:name="com.example.myapp.StaticFragment"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```
### Dynamic Fragment
Add or replace a fragment programmatically:
```java
FragmentManager fragmentManager = getSupportFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
Fragment dynamicFragment = new DynamicFragment();
fragmentTransaction.replace(R.id.fragment_container, dynamicFragment);
fragmentTransaction.commit();

```

###Communication Between Activity and Fragment
Define an interface in the fragment and implement it in the parent activity:
```java
public class MyFragment extends Fragment {
    interface FragmentListener {
        void onDataSent(String data);
    }

    private FragmentListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            listener = (FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement FragmentListener");
        }
    }

    public void sendDataToActivity(String data) {
        if (listener != null) {
            listener.onDataSent(data);
        }
    }
}

```
## Author
**Kandakurthi Pranav**  
*CSE Student at Presidency University, Bangalore*  
Dedicated to creating intuitive and functional Android applications.



This README.md provides a structured guide for understanding and implementing fragments in an Android project. Let me know if you want additional details or examples included!
