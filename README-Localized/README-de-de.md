# Connect-Beispiel für Android unter Verwendung des Microsoft Graph-SDKs

![Buildstatus](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "Buildstatus")

[![Office 365 Connect-Beispiel](../readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "Klicken Sie, um das Beispiel in Aktion zu sehen.")

Für die Arbeit mit Office 365-Diensten und -Daten muss jede Android-App zunächst eine Verbindung zu Office 365 herstellen. In diesem Beispiel wird gezeigt, wie die Verbindung zu und dann der Aufruf einer API über das Microsoft Graph-SDK erfolgt.

## Geräteanforderungen

Zum Ausführen des Connect-Beispiels muss das Gerät die folgenden Anforderungen erfüllen:

* Eine Bildschirmgröße von mindestens 800 x 480 Pixel.
* Android-API-Ebene 16 oder höher.
 
## Anforderungen

Zum Verwenden des Connect-Beispiels für Android benötigen Sie Folgendes:

* [Android Studio](http://developer.android.com/sdk/index.html) Version 1.0 oder höher.
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* Eine in Microsoft Azure registrierte App. Sie können das [Office 365-Tool für die App-Registrierung](http://dev.office.com/app-registration) verwenden. Dadurch wird die App-Registrierung vereinfacht. Verwenden Sie die folgenden Parameter:

|     Parameter   |              Wert             |
|----------------:|:-------------------------------|
|        App-Typ | Systemeigene App                     |
|    Umleitungs-URI | http://localhost:8000          |
| Anwendungsberechtigungen | Mail.Send                      |
  
  Kopieren und speichern Sie die Werte für die **Client-ID** und den **geheimen Clientschlüssel**.
  
## Öffnen des Beispiels mithilfe von Android Studio

1. Installieren Sie [Android Studio](http://developer.android.com/sdk/index.html), und fügen Sie gemäß den [Anleitungen](http://developer.android.com/sdk/installing/adding-packages.html) auf „developer.android.com“ die Android SDK-Pakete hinzu.
2. Laden Sie dieses Beispiel herunter, oder klonen Sie es.
3. Starten Sie Android Studio.
    1. Schließen Sie alle möglicherweise geöffneten Projekte, und wählen Sie dann **Vorhandenes Android Studio-Projekt öffnen** aus.
    2. Navigieren Sie zum lokalen Repository, und wählen Sie das Projekt „Android-Connect“ aus. Klicken Sie auf **OK**.
    
    > Hinweis: In Android Studio wird die Benachrichtigung **Frameworks erkannt** angezeigt, wenn Sie das **Android-Support-Repository** nicht installiert haben. Öffnen Sie den SDK-Manager, und fügen Sie das Android-Support-Repository hinzu, um zu verhindern, dass die Benachrichtigung zu erkannten Frameworks angezeigt wird.
4. Öffnen Sie die Datei „Constants.java“.
    1. Suchen Sie nach der Konstante „CLIENT_ID“, und legen Sie ihren Wert „String“ entsprechend der Client-ID fest, die Sie in Azure Active Directory registriert haben.
    2. Suchen Sie nach der Konstante „REDIRECT_URI“, und legen Sie ihren Wert „String“ entsprechend dem Umleitungs-URI fest, den Sie in Azure Active Directory registriert haben.
    ![Office 365 Connect-Beispiel](../readme-images/Android-Connect-Constants.png "Client-ID- und Umleitungs-URI-Werte in Datei „Constants“")

Nach dem Einrichten des Connect-Beispiels können Sie es auf einem Emulator oder Gerät ausführen. Wählen Sie ein Gerät mit API-Ebene 16 oder höher aus dem Dialogfeld **Gerät auswählen** aus.

Weitere Informationen über das Beispiel finden Sie unter [Aufrufen von Microsoft Graph in einer Android-App](https://graph.microsoft.io/en-us/docs/platform/android).

<a name="contributing"></a>
## Mitwirkung ##

Wenn Sie einen Beitrag zu diesem Beispiel leisten möchten, finden Sie unter [CONTRIBUTING. MD](/CONTRIBUTING.md) weitere Informationen.

In diesem Projekt wurden die [Microsoft Open Source-Verhaltensregeln](https://opensource.microsoft.com/codeofconduct/) übernommen. Weitere Informationen finden Sie unter [Häufig gestellte Fragen zu Verhaltensregeln](https://opensource.microsoft.com/codeofconduct/faq/), oder richten Sie Ihre Fragen oder Kommentare an [opencode@microsoft.com](mailto:opencode@microsoft.com).

## Fragen und Kommentare

Wir schätzen Ihr Feedback hinsichtlich des Connect-Beispiels. Sie können uns Ihre Fragen und Vorschläge über den Abschnitt [Probleme](issues) dieses Repositorys senden.

Allgemeine Fragen zur Office 365-Entwicklung sollten in [Stack Overflow](http://stackoverflow.com/questions/tagged/Office365+API) gestellt werden. Stellen Sie sicher, dass Ihre Fragen oder Kommentare mit [Office365] und [API] markiert sind.

## Nächste Schritte

In diesem Beispiel werden die Grundlagen für das Funktionieren Ihrer Apps mit Office 365 gezeigt. Mithilfe von Office 365-APIs können Ihre Apps viele weitere Aktionen vornehmen, z. B. das Unterstützen Ihrer Benutzer bei der Verwaltung ihrer täglichen Arbeit mit dem Kalender, das Auffinden der benötigten Informationen in allen in OneDrive gespeicherten Dateien oder das Auffinden der gewünschten Person in ihrer Liste der Kontakte. Im [Codeausschnitt-Beispiel für Android](/OfficeDev/O365-Android-Microsoft-Graph-Snippets) warten wir noch weitere interessante Dinge für Sie. 
  
## Weitere Ressourcen

* [Erste Schritte mit Office 365-APIs, unterstützt von Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph-Übersicht](http://graph.microsoft.io)
* [Microsoft Graph-SDK für Android](../../../msgraph-sdk-android)
* [Office 365 Android Microsoft Graph-Ausschnitte](../../../../OfficeDev/O365-Android-Microsoft-Graph-Snippets)

## Copyright
Copyright (c) 2016 Microsoft. Alle Rechte vorbehalten.