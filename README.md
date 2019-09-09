---
page_type: sample
products:
- office-365 
- ms-graph
languages:
- java
extensions:
  contentType: samples
  technologies:
  - Microsoft Graph
  - Microsoft identity platform
  services:
  - Office 365
  - Microsoft identity platform
  - Users
  platforms:
  - Android
  createdDate: 5/11/2016 12:14:33 PM
---
# Connect Sample for Android Using the Microsoft Graph SDK


>**Note:** We've updated this sample to use the [Microsoft Authentication Library (MSAL)](https://github.com/AzureAD/microsoft-authentication-library-for-android) for Android apps.


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
## Register and configure the app

1. Open a browser and navigate to the [Azure Active Directory admin center](https://aad.portal.azure.com). Login using a **Work or School Account**.

1. Select **Azure Active Directory** in the left-hand navigation, then select **App registrations (Preview)** under **Manage**.

    ![A screenshot of the App registrations ](./readme-images/aad-portal-app-registrations.png)

1. Select **New registration**. On the **Register an application** page, set the values as follows.

    - Set a preferred **Name** e.g. `AndroidJavaConnect`
    - Set **Supported account types** to **Accounts in any organizational directory**.

    ![A screenshot of the Register an application page](./readme-images/aad-register-an-app.PNG)

1. Choose **Register**. On the **AndroidJavaConnect** app page, select **Overview** and copy the value of the **Application (client) ID** and save it, you will need it in the next step.

    ![A screenshot of Application Id](./readme-images/aad-application-id.PNG)

1. Still on the app page, select **Authentication**. Locate the section **Redirect URIs**. In the _Suggested Redirect URIs for public clients(mobile,desktop)_, check the second box so that the app can work with the MSAL libraries used in the application. (The box should contain the option _msal<YOUR_CLIENT_ID>://auth_). Choose **Save**.

    ![A screenshot of Suggested Redirect URIs for Public Client](./readme-images/aad-redirect-uri-public-client.PNG)
  
To learn about authenticating with MSAL for Android to make calls to Microsoft Graph, see [Call the Microsoft Graph API from an Android app](https://docs.microsoft.com/en-us/azure/active-directory/develop/guidedsetups/active-directory-android).

  
## Open the sample using Android Studio

1. Install [Android Studio](http://developer.android.com/sdk/index.html) and add the Android SDK packages according to the [instructions](http://developer.android.com/sdk/installing/adding-packages.html) on developer.android.com.
2. Download or clone this sample.
4. Start Android Studio.
	1. Close any projects that you might have open, and then choose **Open an existing Android Studio project**.
	2. Browse to your local repository and choose the Android-Connect project. Click **OK**.
	
	> Note: Android Studio shows a **Frameworks detected** notification if you don't have the **Android Support Repository** installed. Open the SDK manager and add the Android Support Repository to avoid the Frameworks detected notification.
5. Open AndroidManifest.xml
	* Replace *ENTER_YOUR_CLIENT_ID* in two places with the application id from the previous section.
6. Build the app and install the .APK on your device or emulator.
7. Enable the **Storage** permission for the installed sample app on your device or emulator
8. Download the test.jpg image located in:  `android-java-connect-sample/app/src/main/res/drawable/test.jpg` to your device's external storage root folder.



Once you've built the Connect sample, you can run it on an emulator or device. Pick a device with API level 16 or higher from the **Choose device** dialog.

To learn more about the sample, see [Call Microsoft Graph in an Android app](https://developer.microsoft.com/en-us/graph/docs/concepts/android).

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
Copyright (c) 2019 Microsoft. All rights reserved.
