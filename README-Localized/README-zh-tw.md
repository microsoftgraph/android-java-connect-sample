# 使用 Microsoft Graph SDK 的 Connect 範例 (適用於 Android)


>**注意事項：** 我們已經將此範例更新為使用 Android 應用程式適用的 [Microsoft Authentication Library (MSAL)](https://github.com/AzureAD/microsoft-authentication-library-for-android)。


> **為企業客戶建置應用程式？** 如果您的企業客戶開啟企業行動安全性功能 (例如，<a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">條件式裝置存取</a>)，您的應用程式可能無法運作。在此情況下，您可能不會知道，而您的客戶可能會發生錯誤。 

> 若要支援包括**所有企業案例**的**所有企業客戶**，您必須使用 Azure AD 端點，並使用 [Azure 管理入口網站](https://aka.ms/aadapplist)管理您的應用程式。如需詳細資訊，請參閱[在 Azure AD 與 Azure AD v2.0 端點之間進行選擇](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint)。

[![Microsoft Graph Connect 範例](/readme-images/O365-Android-Connect-video_play_icon.png)![按一下以查看執行中的範例](/readme-images/O365-Android-Connect-video_play_icon.png)

連接到 Microsoft Graph 是每個 Android 應用程式要開始使用 Office 365 服務和資料時，必須採取的第一個步驟。此範例示範如何透過 Microsoft Graph SDK 連接而後呼叫一個 API。

## 裝置需求

若要執行 Connect 範例，您的裝置必須符合下列需求：

* 800 x 480 或更大的螢幕大小。
* Android API 層級 16 或更高層級。
 
## 必要條件

若要使用 Android 適用的 Connect 範例，您需要下列各項：

* [Android Studio](http://developer.android.com/sdk/index.html) 1.0 版或更新版本。
* [Java 開發套件 (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。

<a name="register"></a>
## 註冊和設定應用程式

1. 開啟瀏覽器並瀏覽至 [Azure Active Directory 管理中心](https://aad.portal.azure.com)。使用**公司或學校帳戶**登入。

1. 在左側導覽中選取 \[Azure Active Directory]****，然後在 \[管理]**** 下選取 \[應用程式註冊 (預覽)]****。

    ![應用程式註冊的螢幕擷取畫面](./readme-images/aad-portal-app-registrations.png)

1. 選取 \[新增註冊]****。在 \[註冊應用程式]**** 頁面上設定值，如下所示。

    - 設定慣用 \[名稱]****，如 `AndroidJavaConnect`
    - 將 \[支援的帳戶類型]**** 設定為 \[任何組織目錄中的帳戶]****。

    ![註冊應用程式頁面的螢幕擷取畫面](./readme-images/aad-register-an-app.PNG)

1. 選擇 \[註冊]****。在 \[AndroidJavaConnect]**** 應用程式頁面上，選取 \[概觀]**** 並複製 \[應用程式 (用戶端) 識別碼]**** 的值，然後儲存起來，您在下一個步驟將會需要它。

    ![應用程式識別碼的螢幕擷取畫面](./readme-images/aad-application-id.PNG)

1. 仍然在應用程式頁面上，選取 \[驗證]****。找出 \[重新導向 URI]**** 區段。在 \[建議的公用用戶端 (行動裝置、桌面) 重新導向 URI]__ 中，核取第二個方塊，讓應用程式可以使用應用程式中使用的 MSAL 程式庫 (此方塊中應該包含 _msal<YOUR\_CLIENT\_ID>://auth_ 選項)。選取 \[儲存]****。

    ![建議的公用用戶端重新導向 URI 的螢幕擷取畫面](./readme-images/aad-redirect-uri-public-client.PNG)
  
若要了解如何使用適用於 Android 的 MSAL 呼叫 Microsoft Graph 以進行驗證，請參閱[從 Android 應用程式呼叫 Microsoft Graph API](https://docs.microsoft.com/en-us/azure/active-directory/develop/guidedsetups/active-directory-android)。

  
## 使用 Android Studio 開啟範例

1. 根據 developer.android.com 上的[指示](http://developer.android.com/sdk/installing/adding-packages.html)，安裝 [Android Studio](http://developer.android.com/sdk/index.html) 及新增 Android SDK 套件。
2. 下載或複製這個範例。
4. 啟動 Android Studio。
	1. 關閉您可能已開啟的任何專案，然後選擇 \[開啟現有的 Android Studio 專案]****。
	2. 瀏覽至您的本機存放庫，並且選擇 Android-Connect 專案。按一下 \[確定]****。
	
	> 注意事項：如果您未安裝 **Android Support Repository**，Android Studio 會顯示 \[已偵測到 Frameworks]**** 通知。開啟 SDK 管理員並加入 Android Support Repository，以避免「已偵測到 Frameworks」的通知。
5. 開啟 AndroidManifest.xml
	* 將兩個地方的 *ENTER\_YOUR\_CLIENT\_ID* 取代為上一節的應用程式識別碼。
6. 建置應用程式並在您的裝置或模擬器上安裝 .APK。
7. 針對您裝置或模擬器已安裝的範例應用程式，啟用 \[儲存]**** 權限
8. 將位於下列位址的 test.jpg 影像下載到您裝置的外部儲存裝置根資料夾：`android-java-connect-sample/app/src/main/res/drawable/test.jpg`。



一旦建置 Connect 範例之後，您就可以在模擬器或裝置上執行它。從 \[選擇裝置]**** 對話方塊挑選使用 API 層級 16 或更高層級的裝置。

若要深入了解此範例，請參閱[在 Android 應用程式中呼叫 Microsoft Graph](https://developer.microsoft.com/en-us/graph/docs/concepts/android)。

<a name="contributing"></a>
## 參與 ##

如果您想要參與這個範例，請參閱 [CONTRIBUTING.MD](/CONTRIBUTING.md)。

此專案已採用 [Microsoft 開放原始碼管理辦法](https://opensource.microsoft.com/codeofconduct/)。如需詳細資訊，請參閱[管理辦法常見問題集](https://opensource.microsoft.com/codeofconduct/faq/)，如果有其他問題或意見，請連絡 [opencode@microsoft.com](mailto:opencode@microsoft.com)。

## 問題與意見

我們很樂於收到您對於 Connect 範例的意見反應。您可以在此儲存機制的 \[問題][](issues) 區段中，將您的問題及建議傳送給我們。

請在 [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API) 提出有關 Microsoft Graph 開發的一般問題。務必以 \[MicrosoftGraph] 和 \[API] 標記您的問題或意見。

## 後續步驟

這個範例只會顯示您的應用程式要使用 Microsoft Graph 所需的基本資訊。您的應用程式可以使用 Office 365 API 做很多事，像是利用行事曆幫助您的使用者管理其工作天、在他們儲存於 OneDrive 的所有檔案中只尋找他們所需的資訊，或從他們的連絡人清單中找到他們真正需要的人。我們在[適用於 Android 的程式碼片段範例](../../../android-java-snippets-sample)中有更多資訊與您分享。 
  
## 其他資源

* [開始使用 Microsoft Graph 提供的 Office 365 API](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph 概觀](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [Android 的程式碼片段範例](../../../android-java-snippets-sample)

## 著作權
Copyright (c) 2019 Microsoft.著作權所有，並保留一切權利。
