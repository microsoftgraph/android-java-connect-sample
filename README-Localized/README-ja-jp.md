# <a name="connect-sample-for-android-using-the-microsoft-graph-sdk"></a>Microsoft Graph SDK を使用した Android 用 Connect サンプル


>**注:**Android アプリ向けの[推奨される認証ライブラリ](https://docs.microsoft.com/ja-jp/azure/active-directory/develop/active-directory-v2-libraries#compatible-client-libraries)を使用するこのサンプルは、現在更新中です。


> **エンタープライズのお客様向けにアプリを作成していますか?**エンタープライズのお客様が、<a href="https://azure.microsoft.com/ja-jp/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">条件付きのデバイスへのアクセス</a>のようなエンタープライズ モビリティ セキュリティの機能をオンにしている場合、アプリが動作しない可能性があります。その場合、気がつかないまま、お客様の側でエラーが発生してしまう可能性があります。 

> **すべてのエンタープライズのお客様**の**すべてのエンタープライズ シナリオ**をサポートするには、Azure AD のエンドポイントを使用し、[Azure の管理ポータル](https://aka.ms/aadapplist)でアプリを管理する必要があります。詳細については、「[Azure AD か Azure AD v2.0 エンドポイントかを決定する](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint)」を参照してください。

[![Microsoft Graph Connect のサンプル](/readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "稼働中のサンプルを確認するにはこちらをクリックしてください")

各 Android アプリで Office 365 のサービスとデータの操作を開始するため、最初に Microsoft Graph に接続する必要があります。このサンプルでは、Microsoft Graph SDK 経由で、1 つの API に接続して呼び出す方法を示します。

## <a name="device-requirements"></a>デバイスの要件

Connect のサンプルを実行するには、デバイスが次の要件を満たしている必要があります。

* 画面のサイズが 800 x 480 以上である。
* Android の API レベルが 16 以上である。
 
## <a name="prerequisites"></a>前提条件

Android 用 Connect のサンプルを使用するには以下が必要です:

* [Android Studio](http://developer.android.com/sdk/index.html) バージョン 1.0 以上。
* [Java 開発キット (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。

<a name="register"></a>
##<a name="register-and-configure-the-app"></a>アプリを登録して構成する

1. 個人用アカウント、あるいは職場または学校アカウントのいずれかを使用して、[アプリ登録ポータル](https://apps.dev.microsoft.com/)にサインインします。
2. **[アプリの追加]** を選択します。
3. アプリの名前を入力して、**[アプリケーションの作成]** を選択します。
    
    登録ページが表示され、アプリのプロパティが一覧表示されます。
 
4. **[プラットフォーム]** で、**[プラットフォームの追加]** を選択します。
5. **[モバイル アプリケーション]** を選択します。
6. 次のセクションで必要になるので、**アプリケーション ID** をコピーしておきます。
7. **[保存]** をクリックします。
  
## <a name="open-the-sample-using-android-studio"></a>Android Studio を使用してサンプルを開く

1. developer.android.com の[指示](http://developer.android.com/sdk/index.html)に従って、[Android Studio](http://developer.android.com/sdk/installing/adding-packages.html) をインストールし、Android SDK パッケージを追加します。
2. このサンプルをダウンロードするか、クローンを作成します。
3. Android Studio を起動します。
    1. 開いているプロジェクトをすべて閉じ、**[既存のAndroid Studio プロジェクトを開く]** を選択します。
    2. ローカル リポジトリを参照し、Android-Connect プロジェクトを選択します。**[OK]** をクリックします。
    
    > 注:**Android サポート リポジトリ**がインストールされていない場合、Android Studio は**フレームワーク検出**の通知を表示します。フレームワーク検出の通知が表示されないようにするには、SDK マネージャーを開き、Android サポート リポジトリを追加してください。
4. Constants.java ファイルを開きます。
    * *ENTER_YOUR_CLIENT_ID* を前のセクションのアプリケーション ID と置き換えます。

Connect のサンプルをビルドしたら、エミュレーターまたはデバイス上で実行できます。**[デバイスの選択]** ダイアログから API レベル 16 以上のデバイスを選びます。

サンプルについて詳細については、「[Android アプリで Microsoft Graph を呼び出す](https://graph.microsoft.io/ja-jp/docs/platform/android)」を参照してください。

<a name="contributing"></a>
## <a name="contributing"></a>投稿 ##

このサンプルに投稿する場合は、[CONTRIBUTING.MD](/CONTRIBUTING.md) を参照してください。

このプロジェクトでは、[Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/) が採用されています。詳細については、「[規範に関する FAQ](https://opensource.microsoft.com/codeofconduct/faq/)」を参照してください。または、その他の質問やコメントがあれば、[opencode@microsoft.com](mailto:opencode@microsoft.com) までにお問い合わせください。

## <a name="questions-and-comments"></a>質問とコメント

Connect のサンプルに関するフィードバックをお寄せください。質問や提案につきましては、このリポジトリの「[問題](issues)」セクションで送信できます。

Microsoft Graph 開発全般の質問につきましては、「[Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API)」に投稿してください。質問やコメントには、必ず [MicrosoftGraph] と [API] のタグを付けてください。

## <a name="next-steps"></a>次の手順

このサンプルでは、アプリが Microsoft Graph を使用して操作する必要がある重要項目のみを示しています。Office 365 API を使って、アプリでできることはさらにあります。たとえば、ユーザーが予定表で作業日を管理できるようにする、ユーザーが OneDrive に保存したすべてのファイルから必要な情報を検索する、連絡先のリストからユーザーが必要とする人を正確に見つけるなどです。「[Android 用スニペットのサンプル](../../../android-java-snippets-sample)」で、さらに説明しています。 
  
## <a name="additional-resources"></a>追加リソース

* [Microsoft Graph が提供する Office 365 API の使用を開始する](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph の概要](http://graph.microsoft.io)
* [Android 用Microsoft Graph SDK](../../../msgraph-sdk-android)
* [Android 用スニペット サンプル](../../../android-java-snippets-sample)

## <a name="copyright"></a>著作権
Copyright (c) 2016 Microsoft. All rights reserved.
