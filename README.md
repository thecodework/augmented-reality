# Augmented Reality
## About Project
This app renders and astronaut 3d model on overlapping with camera capture using Augmented reality.

## Installation steps

There are some following steps 
- Api level should be Api 24 -Android 7 or above. Android Studio version Should be 3.1 or higher for Augmented Reality Apps.
- In build.gradle of App, add a sceneform UX library and Sceneform Assets library.
- Compile Option to support Java which is needed for Sceneform library.
- In Android Manifets.xml file add permission for AR features in app, Camera permission, Internet permission add meta data to make it available for "Google Play Services for AR".
- Add the fragment as shown which is provided by Sceneform ux library.
- Install google sceneform tools (beta) plugin from android studio only.
- Get Sample model from poly.google.com. 
- Upload the model to server and get the url.
- Make folder of sampledata in app.
- ![image](https://user-images.githubusercontent.com/13745937/126974901-ac0f63c5-bd7d-4be6-983d-149d4109b349.png)
- make raw folder.
- ![image](https://user-images.githubusercontent.com/13745937/126975456-5d2cabee-d5d2-4201-9b91-518770d07491.png)
- Write down the code in MainActivity as shown in the tutorial.
- ![image](https://user-images.githubusercontent.com/13745937/126975170-ced983b9-08d4-49d5-a37c-1f2d9e289838.png)

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
![1627296127078](https://user-images.githubusercontent.com/13745937/126976597-1291ba82-a906-451e-b92b-acdb3cba766c.jpg)
![Screenshot_2021-07-26-16-11-05-182_com example easylearn](https://user-images.githubusercontent.com/13745937/126976629-7b486f6f-66ad-43c3-9687-ac03ac0abdf3.jpg)

## Difficulties faced while working on project
Google senceform (beta) plugin was installing .
![image](https://user-images.githubusercontent.com/13745937/126976805-c469e414-941b-4862-8c11-9be7eb914e40.png)

## Overcome the difficulties
Installed android differnt version

## Tried to do but not succeed
We were trying to do touchless with help of pinch gesture ontouch event but we are not able to do it.

## Future plan regarding the development of project
Our future planning  about this project is to move the 3d model with touchless just moving the fingers or hand from long without touching the screen.
