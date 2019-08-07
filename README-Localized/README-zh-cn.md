# 使用 Microsoft Graph SDK 的适用于 Android 的 Connect 示例


>**注意：** 我们已更新了示例，以便为 Android 应用使用 [Microsoft 身份验证库 (MSAL)](https://github.com/AzureAD/microsoft-authentication-library-for-android)。


> **为企业客户生成应用？** 如果企业客户启用企业移动性安全功能，如<a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">条件性设备访问</a>.，应用可能无法运行。在这种情况下，你可能不知道，而且客户可能会遇到错误。 

> 若要在**所有企业方案**中支持**所有企业客户** ，必须使用 Azure AD 终结点并使用 [Azure 管理门户](https://aka.ms/aadapplist)管理应用。有关详细信息，请参阅[在 Azure AD 和 Azure AD v2.0 终结点之间做选择](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint)。

[![Microsoft Graph Connect 示例](/readme-images/O365-Android-Connect-video_play_icon.png)![单击查看使用中的示例](/readme-images/O365-Android-Connect-video_play_icon.png)

连接到 Microsoft Graph 是每个 Android 应用开始使用 Office 365 服务和数据必须执行的第一步。该示例演示如何通过 Microsoft Graph SDK 连接并调用一个 API。

## 设备要求

要运行该 Connect 示例，您的设备需要满足以下要求：

* 800 x 480 或更大的屏幕尺寸。
* Android API 级别为 16 级或更高。
 
## 先决条件

若要使用适于 Android 的 Connect 示例，你需要以下各项：

* [Android Studio](http://developer.android.com/sdk/index.html) 1.0 或更高版本。
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。

<a name="register"></a>
## 注册和配置应用

1. 打开浏览器，并转到 [Azure Active Directory 管理中心](https://aad.portal.azure.com)。使用**工作或学校帐户**登录。

1. 选择左侧导航栏中的**“Azure Active Directory”**，再选择**“管理”**下的**“应用注册(预览版)”**。

    ![“应用注册”的屏幕截图 ](./readme-images/aad-portal-app-registrations.png)

1. 选择**“新注册”**。在**“注册应用”** 页上，按如下方式设置值。

    - 设置首选**名称**，例如 `AndroidJavaConnect`
    - 将**“受支持的帐户类型”**设置为**“任何组织目录中的帐户”**。

    ![“注册应用程序”页的屏幕截图](./readme-images/aad-register-an-app.PNG)

1. 选择**“注册”**。在**“AndroidJavaConnect”**应用页面上，选择**“概览”**，并且复制并保存**“应用程序(客户端) ID”**的值，将在下一步中用到它。

    ![“应用程序 Id”的屏幕截图](./readme-images/aad-application-id.PNG)

1. 仍然在应用页面上，选择**“身份验证”**。找到**“重定向 URI”**部分。在_“适用于公用客户端的建议重定向 URI(移动、桌面)”_中，选中第二个框，以便应用可以使用应用程序中使用的 MSAL 库。（此框应包含选项 _msal<YOUR\_CLIENT\_ID>://auth_）。选择**“保存”**.。

    ![“适用于公用客户端的建议重定向 URI”的屏幕截图](./readme-images/aad-redirect-uri-public-client.PNG)
  
若要了解如何使用适用于 Android 的 MSAL 进行身份验证以调用 Microsoft Graph，请参阅[从 Android 应用中调用 Microsoft Graph API](https://docs.microsoft.com/en-us/azure/active-directory/develop/guidedsetups/active-directory-android)。

  
## 打开使用 Android Studio 的示例

1. 安装 [Android Studio](http://developer.android.com/sdk/index.html) 并根据 developer.android.com 上的[说明](http://developer.android.com/sdk/installing/adding-packages.html)添加 Android SDK 程序包。
2. 下载或克隆该示例。
4. 启动 Android Studio。
	1. 关闭可能打开的任何项目，然后选择**打开一个现有的 Android Studio 项目**。
	2. 浏览你的本地存储库，然后选择 Android-Connect 项目。单击**“确定”**。
	
	> 注意：如果你没有安装 **Android 支持存储库**，则 Android Studio 显示**“已检测到框架”**通知。打开 SDK 管理器并添加 Android 支持存储库以避免已检测到框架的通知。
5. 打开 AndroidManifest.xml
	* 将两个地方的 *ENTER\_YOUR\_CLIENT\_ID* 替换为上一节中的应用程序 ID。
6. 构建应用并在设备或仿真程序上安装 APK。
7. 为设备或仿真程序上安装的示例应用启用**“存储”**权限
8. 将位于 `android-java-connect-sample/app/src/main/res/drawable/test.jpg` 的 test.jpg 图像下载到设备的外部存储根文件夹。



生成 Connect 示例后，可以在仿真器或设备中运行。在**“选择设备”**对话框中选择配备了 API 级别为 16 级或更高级别的设备。

若要了解有关该示例的详细信息，请参阅[在 Android 应用中调用 Microsoft Graph](https://developer.microsoft.com/en-us/graph/docs/concepts/android)。

<a name="contributing"></a>
## 参与 ##

如果想要参与本示例，请参阅 [CONTRIBUTING.MD](/CONTRIBUTING.md)。

此项目已采用 [Microsoft 开放源代码行为准则](https://opensource.microsoft.com/codeofconduct/)。有关详细信息，请参阅[行为准则 FAQ](https://opensource.microsoft.com/codeofconduct/faq/)。如有其他任何问题或意见，也可联系 [opencode@microsoft.com](mailto:opencode@microsoft.com)。

## 问题和意见

我们乐意倾听你有关 Connect 示例的反馈。你可以在该存储库中的[问题](issues)部分将问题和建议发送给我们。

与 Microsoft Graph 开发相关的一般问题应发布到 [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API)。请确保你的问题或意见标记有 \[MicrosoftGraph] 和 \[API]。

## 后续步骤

该示例只显示应用要使用 Microsoft Graph 所需的必要条件。应用可以使用 Office 365 API 实现的功能非常之多，例如，帮助用户使用日历管理工作日，在存储于 OneDrive 中的所有文件中查找用户需要的信息，或在他们的联系人列表中找出他们需要的人员。在[适用于 Android 的代码段示例](../../../android-java-snippets-sample)方面，我们还想与你分享更多的信息。 
  
## 其他资源

* [由 Microsoft Graph 提供支持的 Office 365 API 入门](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph 概述](http://graph.microsoft.io)
* [适用于 Android 的 Microsoft Graph SDK](../../../msgraph-sdk-android)
* [适用于 Android 的代码段示例](../../../android-java-snippets-sample)

## 版权信息
版权所有 (c) 2019 Microsoft。保留所有权利。
