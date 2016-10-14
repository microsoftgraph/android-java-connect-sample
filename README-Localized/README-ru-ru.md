# <a name="connect-sample-for-android-using-the-microsoft-graph-sdk"></a>Приложение Connect для Android, использующее Microsoft Graph SDK

![Состояние сборки](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "Состояние сборки")

> **Создаете приложения для корпоративных клиентов?** Ваше приложение может не работать, если корпоративный клиент включит функции корпоративной безопасности для мобильных устройств, например <a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">условный доступ с устройств</a>. В этом случае у пользователей могут возникать ошибки, а вы об этом не будете знать. 

> Для поддержки **всех корпоративных клиентов** в **любых корпоративных сценариях** необходимо использовать конечную точку Azure AD и управлять приложениями с помощью [портала управления Azure](https://aka.ms/aadapplist). Дополнительные сведения см. в разделе [Выбор между конечными точками Azure AD и Azure AD версии 2.0](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint).

[![Пример Microsoft Graph Connect.](/readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "Щелкните, чтобы просмотреть пример в действии")

Чтобы начать работу со службами и данными Office 365, приложение для Android должно подключиться к Microsoft Graph. В этом примере показано, как подключиться, а затем вызвать один API через пакет SDK Microsoft Graph.

## <a name="device-requirements"></a>Требования к устройству

Для запуска приложения для подключения устройство должно соответствовать следующим требованиям:

* размер экрана должен составлять не менее 800 x 480;
* должен использоваться API Android 16 или более высокого уровня.
 
## <a name="prerequisites"></a>Необходимые компоненты

Для работы с приложением Connect для Android необходимы следующие компоненты:

* [Android Studio](http://developer.android.com/sdk/index.html) 1.0 или более поздней версии.
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).

<a name="register"></a>
##<a name="register-and-configure-the-app"></a>Регистрация и настройка приложения

1. Войдите на [портал регистрации приложений](https://apps.dev.microsoft.com/) с помощью личной, рабочей или учебной учетной записи.
2. Выберите пункт **Добавить приложение**.
3. Введите имя приложения и выберите пункт **Создать приложение**.
    
    Откроется страница регистрации со свойствами приложения.
 
4. В разделе **Платформы** выберите пункт **Добавление платформы**.
5. Выберите пункт **Мобильное приложение**.
6. Скопируйте **код приложения**, он понадобится вам при работе со следующим разделом.
7. Нажмите кнопку **Сохранить**.
  
## <a name="open-the-sample-using-android-studio"></a>Открытие примера с помощью Android Studio

1. Установите [Android Studio](http://developer.android.com/sdk/index.html) и добавьте пакеты SDK для Android в соответствии с [инструкциями](http://developer.android.com/sdk/installing/adding-packages.html) на сайте developer.android.com.
2. Скачайте или клонируйте этот пример.
3. Запустите Android Studio.
    1. Закройте все открытые проекты, а затем выберите команду **Open an existing Android Studio project** (Открыть существующий проект Android Studio).
    2. Откройте локальный репозиторий и выберите проект Android-Connect. Нажмите кнопку **ОК**.
    
    > Примечание. Если у вас не установлен пакет **Android Support Repository**Android Studio покажет уведомление **Frameworks detected**. Чтобы избежать этого, откройте диспетчер SDK и добавьте пакет Android Support Repository.
4. Откройте файл Constants.java.
    * Вместо фразы *ВВЕДИТЕ_ИДЕНТИФИКАТОР_КЛИЕНТА* вставьте код приложения, который вы сохранили в предыдущем разделе.

После сборки пример подключения можно запустить в эмуляторе или на устройстве. Выберите устройство с API 16 или более высокого уровня в диалоговом окне **Choose device** (Выбор устройства).

Дополнительные сведения о примере см. в статье [Вызов Microsoft Graph в приложении для Android](https://graph.microsoft.io/en-us/docs/platform/android).

<a name="contributing"></a>
## <a name="contributing"></a>Добавление кода ##

Если вы хотите добавить код в этот пример, просмотрите статью [CONTRIBUTING.MD](/CONTRIBUTING.md).

Этот проект соответствует [правилам поведения Майкрософт, касающимся обращения с открытым кодом](https://opensource.microsoft.com/codeofconduct/). Читайте дополнительные сведения в [разделе вопросов и ответов по правилам поведения](https://opensource.microsoft.com/codeofconduct/faq/) или отправляйте новые вопросы и замечания по адресу [opencode@microsoft.com](mailto:opencode@microsoft.com).

## <a name="questions-and-comments"></a>Вопросы и комментарии

Мы будем рады узнать ваше мнение о примере Connect. Перейдите на вкладку [Issues](issues) (Проблемы) этого репозитория, чтобы задать нам вопрос или отправить свои предложения.

Общие вопросы о разработке решений для Microsoft Graph следует задавать на сайте [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API). Обязательно помечайте свои вопросы и комментарии тегами [MicrosoftGraph] или [API].

## <a name="next-steps"></a>Дальнейшие действия

В этом примере показаны только основные компоненты, необходимые приложениям для работы с Microsoft Graph. Интерфейсы API Office 365 значительно расширяют возможности ваших приложений. Например, пользователи могут управлять расписанием своего рабочего дня с помощью календаря, находить во всех файлах из OneDrive только нужные сведения, а также искать необходимых пользователей в своих списках контактов. Узнать больше можно из [примера фрагментов кода для Android](../../../android-java-snippets-sample). 
  
## <a name="additional-resources"></a>Дополнительные ресурсы

* [Начало работы с интерфейсами API Office 365 на платформе Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Общие сведения о Microsoft Graph](http://graph.microsoft.io)
* [Пакет SDK Microsoft Graph для Android](../../../msgraph-sdk-android)
* [Примеры фрагментов кода для Android](../../../android-java-snippets-sample)

## <a name="copyright"></a>Авторское право
(c) Корпорация Майкрософт (Microsoft Corporation), 2016. Все права защищены.
