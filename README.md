# Connect Sample for Android Using the Microsoft Graph SDK

![Build Status](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "Build Status")

> **Building apps for enterprise customers?** Your app may not work if your enterprise customer turns on enterprise mobility security features like <a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">conditional device access</a>. In this case, you may not know and your customers may experience errors. 

> To support **all enterprise customers** across **all enterprise scenarios**, you must use the Azure AD endpoint and manage your apps using the [Azure Management Portal](https://aka.ms/aadapplist). For more information, see [Deciding between the Azure AD and Azure AD v2.0 endpoints](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint).

[![Microsoft Graph Connect sample](/readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "Click to see the sample in action")

Connecting to Microsoft Graph is the first step every Android app must take to start working with Office 365 services and data. This sample shows how to connect and then call one API through the Microsoft Graph SDK.

## Device requirements

To run the Connect sample, your device needs to meet the following requirements:

* A screen size of 800 x 480 or larger.
* Android API level 16 or higher.
 
## Prerequisites

To use the Connect sample for Android, you need the following:

* [Android Studio](http://developer.android.com/sdk/index.html) version 1.0 or later.
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).

<a name="register"></a>
##Register and configure the app

1. Sign into the [App Registration Portal](https://apps.dev.microsoft.com/) using either your personal or work or school account.
2. Select **Add an app**.
3. Enter a name for the app, and select **Create application**.
	
	The registration page displays, listing the properties of your app.
 
4. Under **Platforms**, select **Add platform**.
5. Select **Mobile application**.
6. Copy the **Application Id**, you'll need it in the next section.
7. Click **Save**.
  
## Open the sample using Android Studio

1. Install [Android Studio](http://developer.android.com/sdk/index.html) and add the Android SDK packages according to the [instructions](http://developer.android.com/sdk/installing/adding-packages.html) on developer.android.com.
2. Download or clone this sample.
3. Start Android Studio.
	1. Close any projects that you might have open, and then choose **Open an existing Android Studio project**.
	2. Browse to your local repository and choose the Android-Connect project. Click **OK**.
	
	> Note: Android Studio shows a **Frameworks detected** notification if you don't have the **Android Support Repository** installed. Open the SDK manager and add the Android Support Repository to avoid the Frameworks detected notification.
4. Open the Constants.java file.
	* Replace *ENTER_YOUR_CLIENT_ID* with the application id from the previous section.

Once you've built the Connect sample, you can run it on an emulator or device. Pick a device with API level 16 or higher from the **Choose device** dialog.

To learn more about the sample, see [Call Microsoft Graph in an Android app](https://graph.microsoft.io/en-us/docs/platform/android).

<a name="contributing"></a>
## Contributing ##

If you'd like to contribute to this sample, see [CONTRIBUTING.MD](/CONTRIBUTING.md).

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.

## Questions and comments

We'd love to get your feedback about the Connect sample. You can send your questions and suggestions to us in the [Issues](issues) section of this repository.

Questions about Microsoft Graph development in general should be posted to [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API). Make sure that your questions or comments are tagged with [MicrosoftGraph] and [API].

## Next steps

This sample just shows the essentials that your apps need to work with Microsoft Graph. There is so much more that your apps can do using the Office 365 APIs, like helping your users to manage their work day with calendar, find just the information they need in all the files they store in OneDrive, or find the exact person they need from their list of contacts. We have more to share with you in the [Snippets sample for Android](../../../android-java-snippets-sample). 
  
## Additional resources

* [Get started with Office 365 APIs powered by Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph overview](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [Snippets sample for Android](../../../android-java-snippets-sample)

## Copyright
Copyright (c) 2016 Microsoft. All rights reserved.
