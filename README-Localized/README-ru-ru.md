# Приложение Connect для Android, использующее Microsoft Graph SDK

![Состояние сборки](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "Состояние сборки")

[![Пример Office 365 Connect](../readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "Щелкните, чтобы посмотреть пример в действии")

Чтобы начать работу со службами и данными Office 365, приложение для Android должно подключиться к Office 365. В этом примере показано, как подключиться, а затем вызвать один API через Microsoft Graph SDK.

## Требования к устройству

Для запуска приложения для подключения устройство должно соответствовать следующим требованиям:

* размер экрана должен составлять не менее 800 x 480;
* должен использоваться API Android 16 или более высокого уровня.
 
## Необходимые компоненты

Для работы с приложением Connect для Android необходимы следующие компоненты:

* [Android Studio](http://developer.android.com/sdk/index.html) 1.0 или более поздней версии.
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* Приложение, зарегистрированное в Microsoft Azure. Вы можете воспользоваться [специальным средством](http://dev.office.com/app-registration) для регистрации приложения Office 365. Используйте следующие параметры:

|     Параметр   |              Значение             |
|----------------:|:-------------------------------|
|        App type | Native App                     |
|    Redirect URI | http://localhost:8000          |
| App permissions | Mail.Send                      |
  
  Скопируйте и сохраните значения **Client ID** и **Client Secret**.
  
## Открытие примера с помощью Android Studio

1. Установите [Android Studio](http://developer.android.com/sdk/index.html) и добавьте пакеты SDK для Android в соответствии с [инструкциями](http://developer.android.com/sdk/installing/adding-packages.html) на сайте developer.android.com.
2. Скачайте или клонируйте этот пример.
3. Запустите Android Studio.
    1. Закройте все открытые проекты, а затем выберите команду **Open an existing Android Studio project** (Открыть существующий проект Android Studio).
    2. Откройте локальный репозиторий и выберите проект Android-Connect. Нажмите кнопку **ОК**.
    
    > Примечание. Если у вас не установлен пакет **Android Support Repository**Android Studio покажет уведомление **Frameworks detected**. Чтобы избежать этого, откройте диспетчер SDK и добавьте пакет Android Support Repository.
4. Откройте файл Constants.java.
    1. Найдите константу CLIENT_ID и задайте для нее значение String, равное идентификатору клиента, зарегистрированному в Azure Active Directory.
    2. Найдите константу REDIRECT_URI и задайте для нее значение String, равное URI перенаправления, зарегистрированному в Azure Active Directory.
    ![Пример Office 365 Connect](../readme-images/Android-Connect-Constants.png "Значения Client ID и Redirect URI в файле Constants")

После сборки приложение Connect можно запустить в эмуляторе или на устройстве. Выберите устройство с API 16 или более высокого уровня в диалоговом окне **Choose device** (Выбор устройства).

Дополнительные сведения о примере см. в статье [Вызов Microsoft Graph в приложении для Android](https://graph.microsoft.io/en-us/docs/platform/android).

<a name="contributing"></a>
## Добавление кода ##

Если вы хотите добавить код в этот пример, просмотрите статью [CONTRIBUTING.MD](/CONTRIBUTING.md).

Этот проект соответствует [правилам поведения Майкрософт, касающимся обращения с открытым кодом](https://opensource.microsoft.com/codeofconduct/). Читайте дополнительные сведения в [разделе вопросов и ответов по правилам поведения](https://opensource.microsoft.com/codeofconduct/faq/) или отправляйте новые вопросы и замечания по адресу [opencode@microsoft.com](mailto:opencode@microsoft.com).

## Вопросы и комментарии

Мы будем рады узнать ваше мнение о примере Connect. Вы можете отправлять нам вопросы и предложения на вкладке [Issues](issues) этого репозитория.

Общие вопросы о разработке решений для Office 365 следует публиковать на сайте [Stack Overflow](http://stackoverflow.com/questions/tagged/Office365+API). Обязательно помечайте свои вопросы и комментарии тегами [Office365] и [API].

## Дальнейшие действия

В этом примере показаны только основные компоненты, необходимые приложениям для работы с Office 365. Интерфейсы API Office 365 значительно расширяют возможности ваших приложений. Например, пользователи могут управлять расписанием своего рабочего дня с помощью календаря, находить во всех файлах из OneDrive только нужные сведения, а также искать необходимых пользователей в своих списках контактов. Узнать о них больше можно из [примера фрагментов кода для Android](/OfficeDev/O365-Android-Microsoft-Graph-Snippets). 
  
## Дополнительные ресурсы

* [Начало работы с API Office 365 на платформе Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Общие сведения о Microsoft Graph](http://graph.microsoft.io)
* [Microsoft Graph SDK для Android](../../../msgraph-sdk-android)
* [Фрагменты кода Microsoft Graph для доступа к Office 365 в Android](../../../../OfficeDev/O365-Android-Microsoft-Graph-Snippets)

## Авторское право
(c) Корпорация Майкрософт (Microsoft Corporation), 2016. Все права защищены.