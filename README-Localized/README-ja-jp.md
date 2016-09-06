# Microsoft Graph SDK を使用した Android 用 Connect サンプル

![ビルドの状態](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "ビルドの状態")

[![Office 365 Connect のサンプル](../readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "稼働中のサンプルを確認するにはこちらをクリックしてください")

各 Android アプリで Office 365 のサービスとデータの操作を開始するため、最初に Office 365 に接続する必要があります。 このサンプルでは、Microsoft Graph SDK 経由で、1 つの API に接続して呼び出す方法を示します。

## デバイスの要件

Connect のサンプルを実行するには、デバイスが次の要件を満たしている必要があります。

* 画面のサイズが 800 x 480 以上である。
* Android の API レベルが 16 以上である。
 
## 前提条件

Android 用 Connect のサンプルを使用するには以下が必要です:

* [Android Studio](http://developer.android.com/sdk/index.html) バージョン 1.0 以上。
* [Java 開発キット (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。
* Microsoft Azure に登録されているアプリ。 [Office 365 アプリ登録ツール](http://dev.office.com/app-registration)を使用できます。 アプリの登録が簡単になります。 次のパラメーターを使用します:

|     パラメーター   |              値             |
|----------------:|:-------------------------------|
|        アプリの種類 | ネイティブ アプリ                     |
|    リダイレクト URI | http://localhost:8000          |
| アプリのアクセス許可 | Mail.Send                      |
  
  **クライアント ID** と **クライアント シークレット** の値をコピーして保存します。
  
## Android Studio を使用してサンプルを開く

1. developer.android.com の[指示](http://developer.android.com/sdk/index.html)に従って、[Android Studio](http://developer.android.com/sdk/installing/adding-packages.html) をインストールし、Android SDK パッケージを追加します。
2. このサンプルをダウンロードするか、クローンを作成します。
3. Android Studio を起動します。
    1. 開いているプロジェクトをすべて閉じ、**[既存のAndroid Studio プロジェクトを開く]** を選択します。
    2. ローカル リポジトリを参照し、Android-Connect プロジェクトを選択します。 **[OK]** をクリックします。
    
    > 注:**Android サポート リポジトリ**がインストールされていない場合、Android Studio は**フレームワーク検出**の通知を表示します。 フレームワーク検出の通知が表示されないようにするには、SDK マネージャーを開き、Android サポート リポジトリを追加してください。
4. Constants.java ファイルを開きます。
    1. CLIENT_ID 定数を検索して、その String 値を Azure Active Directory に登録されているクライアント ID と同じ値に設定します。
    2. REDIRECT_URI 定数を検索して、その String 値を Azure Active Directory に登録されているリダイレクト URI と同じ値に設定します。
    ![Office 365 Connect のサンプル](../readme-images/Android-Connect-Constants.png "定数ファイル内のクライアント ID とリダイレクト URI の値")

Connect のサンプルをビルドしたら、エミュレーターまたはデバイス上で実行できます。 **[デバイスの選択]** ダイアログから API レベル 16 以上のデバイスを選びます。

サンプルについて詳細については、「[Android アプリで Microsoft Graph を呼び出す](https://graph.microsoft.io/en-us/docs/platform/android)」を参照してください。

<a name="contributing"></a>
## 投稿 ##

このサンプルに投稿する場合は、[CONTRIBUTING.MD](/CONTRIBUTING.md) を参照してください。

このプロジェクトでは、[Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/) が採用されています。詳細については、「[規範に関する FAQ](https://opensource.microsoft.com/codeofconduct/faq/)」を参照してください。または、その他の質問やコメントがあれば、[opencode@microsoft.com](mailto:opencode@microsoft.com) までにお問い合わせください。

## 質問とコメント

Connect のサンプルに関するフィードバックをお寄せください。 質問や提案につきましては、このリポジトリの「[問題](issues)」セクションで送信できます。

Office 365 開発全般の質問につきましては、「[スタック オーバーフロー](http://stackoverflow.com/questions/tagged/Office365+API)」に投稿してください。質問またはコメントには、必ず [Office365] および [API] のタグを付けてください。

## 次の手順

このサンプルでは、アプリが Office 365 を使用して操作する必要がある重要項目のみを示しています。 Office 365 API を使って、アプリでできることはさらにあります。たとえば、ユーザーが予定表で作業日を管理できるようにする、ユーザーが OneDrive に保存したすべてのファイルで必要な情報を検索する、連絡先のリストからユーザーが必要とする人を正確に見つけるなどです。 「[Android 用 スニペットのサンプル](/OfficeDev/O365-Android-Microsoft-Graph-Snippets)」で、さらに説明しています。 
  
## その他のリソース

* [Microsoft Graph が提供する Office 365 API の使用を開始する](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph の概要](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [Office 365 Android Microsoft Graph のスニペット](../../../../OfficeDev/O365-Android-Microsoft-Graph-Snippets)

## 著作権
Copyright (c) 2016 Microsoft. All rights reserved.