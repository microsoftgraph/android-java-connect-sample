# Microsoft Graph SDK を使用した Android 用 Connect サンプル


>**注:** このサンプルは、Android アプリ向けに [Microsoft Authentication Library (MSAL)](https://github.com/AzureAD/microsoft-authentication-library-for-android) を使用するために更新されています。


> **エンタープライズのお客様向けにアプリを作成していますか?** エンタープライズのお客様が、<a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">条件付きのデバイスへのアクセス</a>のようなエンタープライズ モビリティ セキュリティの機能をオンにしている場合、アプリが動作しない可能性があります。その場合、気がつかないまま、お客様の側でエラーが発生してしまう可能性があります。 

> **すべてのエンタープライズのお客様**の**すべてのエンタープライズ シナリオ**をサポートするには、Azure AD エンドポイントを使用し、[Azure の管理ポータル](https://aka.ms/aadapplist)でアプリを管理する必要があります。詳細については、「[Azure AD エンドポイントか Azure AD v2.0 エンドポイントかを決定する](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint)」を参照してください。

[![Microsoft Graph Connect のサンプル](/readme-images/O365-Android-Connect-video_play_icon.png)![稼働中のサンプルを確認するにはこちらをクリックしてください](/readme-images/O365-Android-Connect-video_play_icon.png)

各 Android アプリで Office 365 のサービスとデータの操作を開始するため、最初に Microsoft Graph に接続する必要があります。このサンプルでは、Microsoft Graph SDK 経由で、1 つの API に接続して呼び出す方法を示します。

## デバイスの要件

Connect のサンプルを実行するには、デバイスが次の要件を満たしている必要があります。

* 画面のサイズが 800 x 480 以上である。
* Android の API レベルが 16 以上である。
 
## 前提条件

Android 用 Connect のサンプルを使用するには以下が必要です。

* [Android Studio](http://developer.android.com/sdk/index.html) バージョン 1.0 以降。
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。

<a name="register"></a>
## アプリを登録して構成する

1. ブラウザーを開き、[Azure Active Directory 管理センター](https://aad.portal.azure.com)へ移動します。**職場または学校アカウント**を使用してログインします。

1. 左側のナビゲーションで **\[Azure Active Directory]** を選択し、それから **\[管理]** で **\[アプリの登録 (プレビュー)]** を選択します。

    ![アプリの登録のスクリーンショット ](./readme-images/aad-portal-app-registrations.png)

1. **\[新規登録]** を選択します。**\[アプリケーションの登録]** ページで、次のように値を設定します。

    - `AndroidJavaConnect` のように、好みの **\[名前]** を設定します
    - **\[サポートされているアカウントの種類]** を **\[任意の組織のディレクトリ内のアカウント]** に設定します。

    ![\[アプリケーションの登録] ページのスクリーンショット](./readme-images/aad-register-an-app.PNG)

1. **\[登録]** を選択します。**AndroidJavaConnect** ページで、**\[概要]** を選択し、**アプリケーション (クライアント) ID** の値をコピーして保存し、次の手順に移ります。

    ![アプリケーション ID のスクリーンショット](./readme-images/aad-application-id.PNG)

1. 引き続きアプリ ページで、**\[認証]** を選択します。**\[リダイレクト URI]** セクションを見つけます。_\[パブリック クライアント (モバイル、デスクトップ) に推奨されるリダイレクト URI]_ で、アプリケーションで使用されている MSAL ライブラリをアプリが利用できるように、2 番目のボックスをオンにします。(ボックスには、_msal<YOUR\_CLIENT\_ID>://auth_ オプションが含まれているはずです)。**\[保存]** を選択します。

    ![パブリック クライアントに推奨されるリダイレクト URI のスクリーンショット](./readme-images/aad-redirect-uri-public-client.PNG)
  
Microsoft Graph を呼び出すための Android 用の MSAL を使用した認証については、「[Android アプリケーションからユーザーにサインインし、Microsoft Graph を呼び出す](https://docs.microsoft.com/en-us/azure/active-directory/develop/guidedsetups/active-directory-android)」を参照してください。

  
## Android Studio を使用してサンプルを開く

1. developer.android.com の[指示](http://developer.android.com/sdk/installing/adding-packages.html)に従って、[Android Studio](http://developer.android.com/sdk/index.html) をインストールし、Android SDK パッケージを追加します。
2. このサンプルをダウンロードするか、複製を作成します。
4. Android Studio を起動します。
	1. 開いているプロジェクトをすべて閉じ、**\[既存の Android Studio プロジェクトを開く]** を選択します。
	2. ローカル リポジトリを参照し、Android-Connect プロジェクトを選択します。**\[OK]** をクリックします。
	
	> 注:**Android サポート リポジトリ**がインストールされていない場合、Android Studio は**フレームワーク検出**の通知を表示します。フレームワーク検出の通知が表示されないようにするには、SDK マネージャーを開き、Android サポート リポジトリを追加してください。
5. AndroidManifest.xml を開きます。
	* *ENTER\_YOUR\_CLIENT\_ID* (2 か所) を前のセクションのアプリケーション ID と置き換えます。
6. アプリをビルドして、.APK をデバイスまたはエミュレーターにインストールします。
7. デバイスまたはエミュレーターにインストールしたサンプル アプリの**\[ストレージ]** アクセス許可を有効にします。
8. `android-java-connect-sample/app/src/main/res/drawable/test.jpg` にある test.jpg イメージを、デバイスの外部ストレージ ルート フォルダーにダウンロードします。



Connect のサンプルを作成したら、エミュレーターまたはデバイス上で実行できます。**\[デバイスの選択]** ダイアログから API レベル 16 以上のデバイスを選びます。

サンプルについて詳しくは、「[Android アプリで Microsoft Graph を呼び出す](https://developer.microsoft.com/en-us/graph/docs/concepts/android)」を参照してください。

<a name="contributing"></a>
## 投稿 ##

このサンプルに投稿する場合は、[CONTRIBUTING.MD](/CONTRIBUTING.md) を参照してください。

このプロジェクトでは、[Microsoft オープン ソース倫理規定](https://opensource.microsoft.com/codeofconduct/)が採用されています。詳細については、「[倫理規定の FAQ](https://opensource.microsoft.com/codeofconduct/faq/)」を参照してください。また、その他の質問やコメントがあれば、[opencode@microsoft.com](mailto:opencode@microsoft.com) までお問い合わせください。

## 質問とコメント

Connect のサンプルに関するフィードバックをお寄せください。質問や提案につきましては、このリポジトリの「[問題](issues)」セクションで送信できます。

Microsoft Graph 開発全般の質問につきましては、「[Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API)」に投稿してください。質問やコメントには、必ず \[MicrosoftGraph] と \[API] のタグを付けてください。

## 次の手順

このサンプルでは、アプリが Microsoft Graph を使用して操作する必要がある重要項目のみを示しています。Office 365 API を使って、アプリでできることはさらにあります。たとえば、ユーザーが予定表で作業日を管理できるようにする、ユーザーが OneDrive に保存したすべてのファイルから必要な情報を検索する、連絡先のリストからユーザーが必要とする人を正確に見つけるなどです。「[Android 用スニペットのサンプル](../../../android-java-snippets-sample)」で、さらに説明しています。 
  
## その他の技術情報

* [Microsoft Graph が提供する Office 365 API の使用を開始する](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph の概要](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [Android 用スニペット サンプル](../../../android-java-snippets-sample)

## 著作権
Copyright (c) 2019 Microsoft.All rights reserved.
