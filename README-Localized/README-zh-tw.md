# 使用 Microsoft Graph SDK 的 Connect 範例 (適用於 Android)

![組建狀態](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "組建狀態")

[![Office 365 Connect 範例](../readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "按一下以查看執行中的範例")

連接到 Office 365 是每個 Android 應用程式要開始使用 Office 365 服務和資料時必須採取的第一個步驟。 此範例示範如何透過 Microsoft Graph SDK 連接而後呼叫一個 API。

## 裝置需求

若要執行 Connect 範例，您的裝置必須符合下列需求：

* 800 x 480 或更大的螢幕大小。
* Android API 層級 16 或更高層級。
 
## 必要條件

若要使用 Android 適用的 Connect 範例，您需要下列各項：

* [Android Studio](http://developer.android.com/sdk/index.html) 1.0 版或更新版本。
* [JAVA 開發套件 (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。
* 在 Microsoft Azure 中註冊的應用程式。 您可以使用 [Office 365 應用程式註冊工具](http://dev.office.com/app-registration)。 應用程式註冊完成 使用下列參數：

|     參數   |              值             |
|----------------:|:-------------------------------|
|        應用程式類型 | 原生應用程式                     |
|    重新導向 URI | http://localhost:8000          |
| 應用程式權限 | Mail.Send                      |
  
  複製並儲存**用戶端識別碼**和**用戶端密碼**值。
  
## 使用 Android Studio 開啟範例

1. 根據 developer.android.com 上的[](http://developer.android.com/sdk/installing/adding-packages.html)，安裝 [Android Studio](http://developer.android.com/sdk/index.html) 及新增 Android SDK 套件。
2. 下載或複製這個範例。
3. 啟動 Android Studio。
    1. 關閉您可能已開啟的任何專案，然後選擇 [開啟現有的 Android Studio 專案]。
    2. 瀏覽至您的本機存放庫，並且選擇 Android-Connect 專案。 按一下 [確定]。
    
    > 附註：如果您未安裝 **Android Support Repository**，Android Studio 會顯示 [已偵測到 Frameworks]  開啟 SDK 管理員並加入 Android Support Repository，以避免偵測到Frameworks 的通知。
4. 開啟 Constants.java 檔案。
    1. 尋找 CLIENT_ID 常數並將其字串值設定為等於您在 Azure Active Directory 中註冊的用戶端識別碼。
    2. 尋找 REDIRECT_URI 常數並將其字串值設定為等於您在 Azure Active Directory 中註冊的重新導向 URI。
    ![Office 365 Connect 範例](../readme-images/Android-Connect-Constants.png "Constants 檔案中的用戶端識別碼和重新導向 URI 值")

一旦建置 Connect 範例，您可以在模擬器或裝置上執行它。 從 [選擇裝置] 對話方塊挑選使用 API 層級 16 或更高層級的裝置。

若要深入了解此範例，請參閱[在 Android 應用程式中呼叫 Microsoft Graph](https://graph.microsoft.io/en-us/docs/platform/android)。

<a name="contributing"></a>
## 參與 ##

如果您想要參與這個範例，請參閱 [CONTRIBUTING.MD](/CONTRIBUTING.md)。

此專案已採用 [Microsoft 開放原始碼執行](https://opensource.microsoft.com/codeofconduct/)。如需詳細資訊，請參閱[程式碼執行常見問題集](https://opensource.microsoft.com/codeofconduct/faq/)，如果有其他問題或意見，請連絡 [opencode@microsoft.com](mailto:opencode@microsoft.com)。

## 問題和建議

我們很樂於收到您對於 Connect 範例的意見反應。 您可以在此儲存機制的[問題](issues)區段中，將您的問題及建議傳送給我們。

請在 [Stack Overflow](http://stackoverflow.com/questions/tagged/Office365+API) 提出有關 Office 365 開發的一般問題。務必以 [Office365] 和 [API] 標記您的問題或意見。

## 後續步驟

這個範例只會顯示您的應用程式要使用 Office 365 所需的基本資訊。 您的應用程式可以使用 Office 365 API 做很多事，像是利用行事曆幫助您的使用者管理其工作天、在他們儲存於 OneDrive 的所有檔案中只尋找他們所需的資訊，或從他們的連絡人清單中找到她們真正需要的人。 我們在[適用於 Android 的程式碼片段範例](/OfficeDev/O365-Android-Microsoft-Graph-Snippets)有更多資訊與您分享。 
  
## 其他資源

* [開始使用 Microsoft Graph 提供的 Office 365 API](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph 概觀](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [Office 365 Android Microsoft Graph 程式碼片段](../../../../OfficeDev/O365-Android-Microsoft-Graph-Snippets)

## 著作權
Copyright (c) 2016 Microsoft.著作權所有，並保留一切權利。