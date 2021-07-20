# Augmented Reality
## About Project
This app renders and astronaut 3d model on overlapping with camera capture using Augmented reality.
## Features
There are some following steps 
- Api level should be Api 24 -Android 7 or above. Android Studio version Should be 3.1 or higher for Augmented Reality Apps.
- In build.gradle of App, add a sceneform UX library and Sceneform Assets library.
- Compile Option to support Java which is needed for Sceneform library.
- In Android Manifets.xml file add permission for AR features in app, Camera permission, Internet permission add meta data to make it available for "Google Play Services for AR".
- Add the fragment as shown which is provided by Sceneform ux library.
- Install google sceneform tools (beta) plugin from android studio only.
- Get Sample model from poly.google.com. 
- Upload the model to server and get the url.
- Write down the code in MainActivity as shown in the tutorial.
- Run the App.

## Output will be
You will see the astronaut model on the plain surface.

## Difficulties faced while working on project
Google senceform (beta) plugin was installing .

## Overcome the difficulties
Installed android differnt version

## Tried to do but not succeed
We were trying to do touchless with help of pinch gesture ontouch event but we are not able to do it.

## Future plan regarding the development of project
Our future planning  about this project is to move the 3d model with touchless just moving the fingers or hand from long without touching the screen.
