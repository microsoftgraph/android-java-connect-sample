# <a name="connect-sample-for-android-using-the-microsoft-graph-sdk"></a>使用 Microsoft Graph SDK 的适用于 Android 的 Connect 示例

![生成状态](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "生成状态")

> **为企业客户构建应用？**如果企业客户启用企业移动性安全功能，如<a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">条件性设备访问</a>，应用可能无法运行。在这种情况下，你可能不知道，而且客户可能会遇到错误。 

> 若要在**所有企业方案**中支持**所有企业客户**，必须使用 Azure AD 终结点并使用 [Azure 管理门户](https://aka.ms/aadapplist)管理应用。有关详细信息，请参阅[在 Azure AD 和 Azure AD v2.0 终结点之间做选择](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint)。

[![Microsoft Graph Connect 示例](/readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "单击查看使用中的示例")

连接到 Microsoft Graph 是每个 Android 应用开始使用 Office 365 服务和数据必须执行的第一步。该示例演示如何通过 Microsoft Graph SDK 连接并调用一个 API。

## <a name="device-requirements"></a>设备要求

要运行该 Connect 示例，您的设备需要满足以下要求：

* 800 x 480 或更大的屏幕尺寸。
* Android API 级别为 16 级或更高。
 
## <a name="prerequisites"></a>先决条件

若要使用适于 Android 的 Connect 示例，你需要以下各项：

* [Android Studio](http://developer.android.com/sdk/index.html) 版本 1.0 或更高。
* [Java 开发工具包 (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。

<a name="register"></a>
##<a name="register-and-configure-the-app"></a>注册和配置应用

1. 使用个人或工作或学校帐户登录到 [应用注册门户](https://apps.dev.microsoft.com/)。
2. 选择“**添加应用**”。
3. 为应用输入名称，并选择“**创建应用程序**”。
    
    将显示注册页，其中列出应用的属性。
 
4. 在“**平台**”下，选择“**添加平台**”。
5. 选择“**移动应用程序**”。
6. 复制在下一节中需要使用的**应用程序 ID**。
7. 单击“**保存**”。
  
## <a name="open-the-sample-using-android-studio"></a>打开使用 Android Studio 的示例

1. 安装 [Android Studio](http://developer.android.com/sdk/index.html) 并根据 developer.android.com 上的[说明](http://developer.android.com/sdk/installing/adding-packages.html) 添加 Android SDK 包。
2. 下载或克隆该示例。
3. 启动 Android Studio。
    1. 关闭可能打开的任何项目，然后选择“**打开一个现有的 Android Studio 项目**”。
    2. 浏览你的本地存储库，然后选择 Android-Connect 项目。单击“**确定**”。
    
    > 注意：如果你没有安装 **Android 支持存储库**，则 Android Studio 显示“**已检测到框架**”通知。打开 SDK 管理器并添加 Android 支持存储库以避免已检测到框架的通知。
4. 打开 Constants.java 文件。
    * 将 *ENTER_YOUR_CLIENT_ID* 替换为上一节中的应用程序 ID。

生成 Connect 示例后，可以在仿真器或设备中运行。在“**选择设备**”对话中选择配备了 API 级别为 16 级或更高级别的设备。

要了解有关该示例的详细信息，请参阅[在 Android 应用中调用 Microsoft Graph](https://graph.microsoft.io/en-us/docs/platform/android)。

<a name="contributing"></a>
## <a name="contributing"></a>参与 ##

如果想要参与本示例，请参阅 [CONTRIBUTING.MD](/CONTRIBUTING.md)。

此项目采用 [Microsoft 开源行为准则](https://opensource.microsoft.com/codeofconduct/)。有关详细信息，请参阅 [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/)（行为准则常见问题解答），有任何其他问题或意见，也可联系 [opencode@microsoft.com](mailto:opencode@microsoft.com)。

## <a name="questions-and-comments"></a>问题和意见

我们乐意倾听你有关 Connect 示例的反馈。可以在该存储库中的[问题](issues)部分将问题和建议发送给我们。

与 Microsoft Graph 开发相关的一般问题应发布到 [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API)。请确保你的问题或意见标记有 [MicrosoftGraph] 和 [API]。

## <a name="next-steps"></a>后续步骤

该示例只显示应用要使用 Microsoft Graph 所需的必要条件。应用可以使用 Office 365 API 实现的功能非常之多，例如，帮助用户使用日历管理工作日，在存储于 OneDrive 中的所有文件中查找用户需要的信息，或在他们的联系人列表中找出他们需要的人员。在[适用于 Android 的代码段示例](../../../android-java-snippets-sample)方面，我们还想与你分享更多的信息。 
  
## <a name="additional-resources"></a>其他资源

* [由 Microsoft Graph 提供支持的 Office 365 API 入门](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph 概述](http://graph.microsoft.io)
* [适用于 Android 的 Microsoft Graph SDK](../../../msgraph-sdk-android)
* [适用于 Android 的代码段示例](../../../android-java-snippets-sample)

## <a name="copyright"></a>版权
版权所有 (c) 2016 Microsoft。保留所有权利。
