#Firebase #RealtimeDatabase #FirebaseAuth #FirebaseDatabase

Firebase Realtime Datbase Example
===================

This sample project will guide you have to use `FirebaseAuth` and `FirebaseDatabase`
Provide an example of User SignIn & SignUp using email and password.

To archieve this, go to [Firebase Console](https://console.firebase.google.com/), then enable the **Email/Password** in SignIn Method

This project also provides an example of how to use Realtime Database as the configuration setting 
to change the background color of a view and set the text message.
You will see the data is changed once you made any change of the database in the server.

You also need to change your Rule of your database

    {
      "rules": {
        ".read": "auth != null",
        ".write": "auth != null"
      }
    }






