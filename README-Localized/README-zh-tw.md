# <a name="connect-sample-for-android-using-the-microsoft-graph-sdk"></a>使用 Microsoft Graph SDK 的 Connect 範例 (適用於 Android)

![組建狀態](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "組建狀態")

> **為企業客戶建置應用程式？**如果您的企業客戶開啟企業行動安全性功能 (例如，<a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">條件式裝置存取</a>)，您的應用程式可能無法運作。在此情況中，您可能不會知道，而您的客戶可能會發生錯誤。 

> 若要支援包括**所有企業案例**的**所有企業客戶**，您必須使用 Azure AD 端點，並使用 [Azure 管理入口網站](https://aka.ms/aadapplist)來管理您的應用程式。如需詳細資訊，請參閱 [在 Azure AD 與 Azure AD v2.0 端點之間進行選擇](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint)。

[![Microsoft Graph Connect 範例](/readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "按一下以查看執行中的範例")

連接到 Microsoft Graph 是每個 Android 應用程式要開始使用 Office 365 服務和資料時，必須採取的第一個步驟。此範例示範如何透過 Microsoft Graph SDK 連接而後呼叫一個 API。

## <a name="device-requirements"></a>裝置需求

若要執行 Connect 範例，您的裝置必須符合下列需求：

* 800 x 480 或更大的螢幕大小。
* Android API 層級 16 或更高層級。
 
## <a name="prerequisites"></a>必要條件

若要使用 Android 適用的 Connect 範例，您需要下列各項：

* [Android Studio](http://developer.android.com/sdk/index.html) 1.0 版或更新版本。
* [Java 開發套件 (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。

<a name="register"></a>
##<a name="register-and-configure-the-app"></a>註冊和設定應用程式

1. 使用您的個人或工作或學校帳戶登入[應用程式註冊入口網站](https://apps.dev.microsoft.com/)。
2. 選取 [新增應用程式]****。
3. 為應用程式輸入名稱，然後選取 [建立應用程式]****。
    
    [註冊] 頁面隨即顯示，列出您的應用程式的屬性。
 
4. 在 [平台]**** 底下，選取 [新增平台]****。
5. 選取 [行動應用程式]****。
6. 複製**應用程式識別碼**，在下一節您將會需要它。
7. 按一下 [儲存]****。
  
## <a name="open-the-sample-using-android-studio"></a>使用 Android Studio 開啟範例

1. 根據 developer.android.com 上的[](http://developer.android.com/sdk/installing/adding-packages.html)，安裝 [Android Studio](http://developer.android.com/sdk/index.html) 及新增 Android SDK 套件。
2. 下載或複製這個範例。
3. 啟動 Android Studio。
    1. 關閉您可能已開啟的任何專案，然後選擇 [開啟現有的 Android Studio 專案]****。
    2. 瀏覽至您的本機存放庫，並且選擇 Android-Connect 專案。按一下 [確定]****。
    
    > 附註：如果您未安裝 **Android Support Repository**，Android Studio 會顯示 [已偵測到 Frameworks] ****開啟 SDK 管理員並加入 Android Support Repository，以避免偵測到Frameworks 的通知。
4. 開啟 Constants.java 檔案。
    * 將 *ENTER_YOUR_CLIENT_ID* 取代為前一節的應用程式識別碼。

一旦建置 Connect 範例，您可以在模擬器或裝置上執行它。從 [選擇裝置]**** 對話方塊挑選使用 API 層級 16 或更高層級的裝置。

若要深入了解此範例，請參閱[在 Android 應用程式中呼叫 Microsoft Graph](https://graph.microsoft.io/en-us/docs/platform/android)。

<a name="contributing"></a>
## <a name="contributing"></a>參與 ##

如果您想要參與這個範例，請參閱 [CONTRIBUTING.MD](/CONTRIBUTING.md)。

此專案已採用 [Microsoft 開放原始碼執行](https://opensource.microsoft.com/codeofconduct/)。如需詳細資訊，請參閱[程式碼執行常見問題集](https://opensource.microsoft.com/codeofconduct/faq/)，如果有其他問題或意見，請連絡 [opencode@microsoft.com](mailto:opencode@microsoft.com)。

## <a name="questions-and-comments"></a>問題和建議

我們很樂於收到您對於 Connect 範例的意見反應。您可以在此儲存機制的[問題](issues)區段中，將您的問題及建議傳送給我們。

請在 [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API) 提出有關 Microsoft Graph 開發的一般問題。務必以 [MicrosoftGraph] 和 [API] 標記您的問題或意見。

## <a name="next-steps"></a>後續步驟

這個範例只會顯示您的應用程式要使用 Microsoft Graph 所需的基本資訊。您的應用程式可以使用 Office 365 API 做很多事，像是利用行事曆幫助您的使用者管理其工作天、在他們儲存於 OneDrive 的所有檔案中只尋找他們所需的資訊，或從他們的連絡人清單中找到她們真正需要的人。我們在[適用於 Android 的程式碼片段範例](../../../android-java-snippets-sample)有更多資訊與您分享。 
  
## <a name="additional-resources"></a>其他資源

* [開始使用 Microsoft Graph 提供的 Office 365 API](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph 概觀](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [Android 的程式碼片段範例](../../../android-java-snippets-sample)

## <a name="copyright"></a>著作權
Copyright (c) 2016 Microsoft.著作權所有，並保留一切權利。
