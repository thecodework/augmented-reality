# Augmented Reality (Using [ARcore sceneform Library](https://developers.google.com/sceneform/develop))
 [ARCore](https://developers.google.com/sceneform/develop) is Google’s platform for building augmented reality experiences. Using different APIs, [ARCore](https://developers.google.com/sceneform/develop) enables your phone to sense its environment, understand the world and  interact with information. Some of the APIs are available across Android and iOS to enable shared AR experiences.
 
## What you need
To use [Google Play Services](https://play.google.com/store/apps/details?id=com.google.ar.core&hl=en_IN&gl=US) for AR, you need an Android device with:

- [A Google Account](https://accounts.google.com/ServiceLogin/signinchooser?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin)
- ARCore-certification- It already exist in Android devices.
- At least 1 GB of free space
- At least one AR app installed
- [An unmetered mobile network](https://developers.google.com/ar/devices#google_play_devices)- Here you can find device list.

## How it works
[Google Play Services](https://play.google.com/store/apps/details?id=com.google.ar.core&hl=en_IN&gl=US) for AR lets your device provide AR experiences in apps that were created with Google’s AR platform in mind.

- Install [Google Play Services](https://play.google.com/store/apps/details?id=com.google.ar.core&hl=en_IN&gl=US) for AR
- On your Android device, open the Google Play Store app Google Play.
- Find the [Google Play Services](https://play.google.com/store/apps/details?id=com.google.ar.core&hl=en_IN&gl=US) for AR app.
- Tap Download.
 
## About Project
[ARCore](https://developers.google.com/sceneform/develop) is doing two things: tracking the position of the mobile device as it moves, and building its own understanding of the real world. ARCore's motion tracking technology uses the phone's camera to identify interesting points, called features, and tracks how those points move over time. With a combination of the movement of these points and readings from the phone's inertial sensors, ARCore determines both the position and orientation of the phone as it moves through space. In addition to identifying key points, ARCore can detect flat surfaces, like a table or the floor, and can also estimate the average lighting in the area around it. These capabilities combine to enable ARCore to build its own understanding of the world around it. ARCore's understanding of the real world lets you place objects, annotations, or other information in a way that integrates seamlessly with the real world. we can place astronaut on the plane. Motion tracking means that you can move around and view these objects from any angle, and even if you turn around and leave the room, when you come back, the 3D model or annotation will be right where you left it.

## Installation steps

There are some following steps
- Api level should be Api 24 -Android 7 or above. Android Studio version Should be 3.1 or higher for Augmented Reality Apps.
- Add sceneform toolsin Android Studio Under Plugin.
-  In build.gradle of App, add a sceneform UX library.
- Add  sceneform plugin.  
 **Android** → **file**  → **setting** → **plugins**   → **Google sceneform tools (beta)**  
![image](https://user-images.githubusercontent.com/13745937/126976805-c469e414-941b-4862-8c11-9be7eb914e40.png)
- Compile Option to support Kotlin which is needed for Sceneform library.
- Steps to follow:  https://developers.google.com/scenefo...
   	- Import the Sceneform plugin
	- Convert the model
	- Configure your project's build.gradle files
	- Update your AndroidManifest.xml
	- Load Model
	- Create model renderables
	- Build the Augmented Scene 
- In project's build.gradle. Adds the Sceneform plugin.
- In Android Manifets.xml file add permission for AR features in app, Camera permission add meta data to make it available for "Google Play Services for AR".
- Add the fragment as shown which is provided by Sceneform ux library.
- Get Sample model from poly.google.com. 
- Under App folder create a folder sampledata and paste the downloaded obj and .mtl file.
-![image](https://user-images.githubusercontent.com/13745937/127138436-238fda64-0e34-45a5-8576-d11f3f62bd7d.png)
- Under Res folder-  create raw resources folder
- import sceneform asset (.sfb)  in Raw folder
- ![image](https://user-images.githubusercontent.com/13745937/127138618-5d57603c-ed2e-405e-b554-155dc1f4009e.png)
- Write down the code in MainActivity as shown in the tutorial.
- ![image](https://user-images.githubusercontent.com/13745937/126975170-ced983b9-08d4-49d5-a37c-1f2d9e289838.png)
- So finally we can say we have initialized the fragment then loaded a model then attach the scene to the node.
- Run the App.

## Dependencies with their versions :
```sh
     implementation 'androidx.appcompat:appcompat:1.3.0'
     implementation 'com.google.android.material:material:1.3.0'
```
```sh
    //Sceneform
    implementation 'com.google.ar.sceneform.ux:sceneform-ux:1.4.0'
    implementation 'com.google.ar.sceneform.ux:sceneform-ux:1.15.0'
    implementation 'com.google.ar.sceneform:assets:1.15.0'
```
![image](https://user-images.githubusercontent.com/13745937/126975384-956ba0b1-7e2c-47c4-a0e4-c9312e84caed.png)
	
## Mainifest :
```sh
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-feature android:name="android.hardware.camera.ar" android:required="true" />
```
```sh
<meta-data android:name="com.google.ar.core" android:value="required" />
```
 ![image](https://user-images.githubusercontent.com/13745937/126975549-7d6c4a90-a097-4fad-9499-df3f318b2b35.png)
 ![image](https://user-images.githubusercontent.com/13745937/126975589-6406b531-5cea-4214-8c44-b50379bd136d.png)

## Output will be
You will see the astronaut model on the plain surface.
! [](![ezgif com-gif-maker](https://user-images.githubusercontent.com/78479435/127455465-58fd042e-f7c8-4595-9293-8bf878706336.gif). gif)
![1627296127078](https://user-images.githubusercontent.com/13745937/126976597-1291ba82-a906-451e-b92b-acdb3cba766c.jpg)
![Screenshot_2021-07-26-16-11-05-182_com example easylearn](https://user-images.githubusercontent.com/13745937/126976629-7b486f6f-66ad-43c3-9687-ac03ac0abdf3.jpg)

## Difficulties faced while working on project

- Google senceform (beta) plugin was installing .
- Making changes in pinch gesture .
- Making changes in motion event and onTouchListener.

## Overcome the difficulties
Installed android differnt version

## Tried to do but not succeed
We were trying to do touchless with help of pinch gesture ontouch event but we are not able to do it.

## Future plan regarding the development of project
Our future planning  about this project is to move the 3d model with touchless just moving the fingers or hand from long without touching the screen.

## Deprecation policy
Apps built with ARCore SDK 1.12.0 or higher are covered by the Cloud Anchor API deprecation policy.

Apps built with ARCore SDK 1.11.0 or lower will be unable to host or resolve Cloud Anchors beginning December 2020 due to the SDK's use of an older, deprecated ARCore Cloud Anchor service.
