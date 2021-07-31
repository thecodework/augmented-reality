# Augmented Reality (Using [ARcore Sceneform Library](https://developers.google.com/sceneform/develop))
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
[ARCore](https://developers.google.com/ar) is doing two things: tracking the position of the mobile device as it moves, and building its own understanding of the real world. ARCore's motion tracking technology uses the phone's camera to identify interesting points, called features, and tracks how those points move over time. With a combination of the movement of these points and readings from the phone's inertial sensors, [ARCore](https://developers.google.com/ar) determines both the position and orientation of the phone as it moves through space. In addition to identifying key points, ARCore can detect flat surfaces, like a table or the floor, and can also estimate the average lighting in the area around it. These capabilities combine to enable [ARCore](https://developers.google.com/ar) to build its own understanding of the world around it. ARCore's understanding of the real world lets you place objects, annotations, or other information in a way that integrates seamlessly with the real world. we can place astronaut on the plane. Motion tracking means that you can move around and view these objects from any angle, and even if you turn around and leave the room, when you come back, the 3D model or annotation will be right where you left it.

## Installation steps

There are some following steps
- Api level should be Api 24 -Android 7 or above. Android Studio version Should be 3.1 or higher for Augmented Reality Apps.
- Add [Sceneform tools](https://developers.google.com/sceneform/develop/getting-started) in Android Studio Under Plugin.
-  In build.gradle of App, add a [Sceneform ux library](https://developers.google.com/sceneform/reference/com/google/ar/sceneform/ux/package-summary).
- Add  [Sceneform plugin](https://developers.google.com/sceneform/develop/getting-started).  
 **Android** → **file**  → **setting** → **plugins**   → **Google sceneform tools (beta)**  
![image](https://user-images.githubusercontent.com/13745937/126976805-c469e414-941b-4862-8c11-9be7eb914e40.png)
- Compile Option to support Kotlin which is needed for [Sceneform library](https://developers.google.com/sceneform/reference/com/google/ar/sceneform/ux/package-summary).
- Steps to follow:  https://developers.google.com/scenefo...
   	- Import the Sceneform plugin
	- Convert the model
	- Configure your project's build.gradle files
	- Update your AndroidManifest.xml
	- Load Model
	- Create model renderables
	- Build the Augmented Scene 
- In project's build.gradle. Adds the [Sceneform plugin](https://developers.google.com/sceneform/develop/getting-started).
- In Android Manifets.xml file add permission for [AR features](https://developers.google.com/ar/develop/java/enable-arcore) in app, [Camera permission](https://developer.android.com/guide/topics/media/camera) add meta data to make it available for "Google Play Services for AR".
- Add the fragment as shown which is provided by [Sceneform ux library](https://developers.google.com/sceneform/reference/com/google/ar/sceneform/ux/package-summary).
- Get Sample model from [poly.google.com](https://support.google.com/poly/answer/10192635). 
- Under App folder create a folder sampledata and paste the downloaded object and .mtl file.
-![image](https://user-images.githubusercontent.com/13745937/127138436-238fda64-0e34-45a5-8576-d11f3f62bd7d.png)
- Under res folder-  create raw resources folder
- import sceneform asset (.sfb)  in raw folder
- ![image](https://user-images.githubusercontent.com/13745937/127138618-5d57603c-ed2e-405e-b554-155dc1f4009e.png)
- Write down the code in MainActivity as shown in the tutorial.
- So finally we can say we have initialized the fragment then loaded a model then attach the scene to the node.
- Run the App.

## Libraries/Dependencies with their versions :
- [Sceneform](https://developers.google.com/sceneform/develop)- Sceneform is a 3D framework that makes it easy for you to build ARCore apps without OpenGL. We are using 1.15.0 version of google.ar.sceneform.ux:sceneform-ux.
	
## Permissions :
- We are using [Camera permission](https://developer.android.com/guide/topics/media/camera), [Internet permission](https://developer.android.com/training/basics/network-ops/connecting) and [hardware.camera.ar permission](https://developers.google.com/ar/develop/java/enable-arcore).
 
## Output will be
You will see the astronaut model on the plain surface.
- ![ezgif com-gif-maker](https://user-images.githubusercontent.com/78479435/127455465-58fd042e-f7c8-4595-9293-8bf878706336.gif)
 
## Difficulties faced while working on project

- When I want to install Google Sceneform Tools plugin. But after installation and restart the IDE I see this notification:"Plugin Error: Plugin "Google Sceneform Tools (Beta)"   is incompatible (supported only in IntelliJ IDEA)."
- To move the model we tried motion event and pinch gestures. We took the the value getting from pinch gesture detection and pass it in the parameters of motion event to move the 3D model but we fail in it.

## Tried to do but not succeed
We were trying to do touchless with help of pinch gesture ontouch event but we are not able to do it.To move the model we tried motion event and pinch gestures. We took the the value getting from pinch gesture detection and pass it in the parameters of motion event to move the 3D model but we fail in it.

## Future plan regarding the development of project
Our future planning  about this project is to move the 3d model with touchless just moving the fingers or hand from long without touching the screen.

## Deprecation policy
Apps built with ARCore SDK 1.12.0 or higher are covered by the Cloud Anchor API deprecation policy.

Apps built with ARCore SDK 1.11.0 or lower will be unable to host or resolve Cloud Anchors beginning December 2020 due to the SDK's use of an older, deprecated ARCore Cloud Anchor service.
