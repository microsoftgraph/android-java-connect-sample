# Connect-Beispiel für Android unter Verwendung des Microsoft Graph-SDK


>**Hinweis:** Dieses Beispiel wurde zur Verwendung der [Microsoft Authentication Library (MSAL)](https://github.com/AzureAD/microsoft-authentication-library-for-android) für Android-Apps aktualisiert.


> **Sie erstellen Apps für Unternehmenskunden?** Ihre App funktioniert möglicherweise nicht, wenn Ihr Unternehmenskunde Enterprise Mobility-Sicherheitsfunktionen wie den <a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">bedingten Gerätezugriff</a> aktiviert. In diesem Fall treten bei Ihren Kunden möglicherweise Fehler auf. 

> Zur Unterstützung **aller Unternehmenskunden** über **alle Unternehmensszenarien** hinweg müssen Sie den Azure AD-Endpunkt verwenden und Ihr Apps mithilfe des [Azure-Verwaltungsportals](https://aka.ms/aadapplist) verwalten. Weitere Informationen finden Sie unter [Entscheiden zwischen dem Azure AD- und dem Azure AD v2.0-Endpunkt](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint).

[![Microsoft Graph Connect-Beispiel](/readme-images/O365-Android-Connect-video_play_icon.png)![Klicken Sie, um das Beispiel in Aktion zu sehen](/readme-images/O365-Android-Connect-video_play_icon.png)

Für die Arbeit mit Office 365-Diensten und -Daten muss jede Android-App zunächst eine Verbindung zu Microsoft Graph herstellen. In diesem Beispiel wird gezeigt, wie die Verbindung zu und dann der Aufruf einer API über das Microsoft Graph-SDK erfolgt.

## Geräteanforderungen

Zum Ausführen des Connect-Beispiels muss das Gerät die folgenden Anforderungen erfüllen:

* Eine Bildschirmgröße von mindestens 800 x 480 Pixel.
* Android-API-Ebene 16 oder höher.
 
## Anforderungen

Zum Verwenden des Connect-Beispiels für Android benötigen Sie Folgendes:

* [Android Studio](http://developer.android.com/sdk/index.html) Version 1.0 oder höher.
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).

<a name="register"></a>
## Registrieren und Konfigurieren der App

1. Öffnen Sie einen Browser, und navigieren Sie zum [Azure Active Directory Admin Center](https://aad.portal.azure.com). Melden Sie sich unter Verwendung eines **Geschäfts-, Schul- oder Unikontos** an.

1. Wählen Sie in der linken Navigationsleiste **Azure Active Directory** aus, und wählen Sie dann **App-Registrierungen (Vorschau)** unter **Verwalten** aus.

    ![Screenshot der APP-Registrierungen](./readme-images/aad-portal-app-registrations.png)

1. Wählen Sie **Neue Registrierungen** aus. Legen Sie auf der Seite **Anwendung registrieren** die Werte wie folgt fest.

    - Legen Sie einen bevorzugten **Namen** fest, z. B. `AndroidJavaConnect`.
    - Legen Sie **Unterstützte Kontotypen** auf **Konten in allen Organisationsverzeichnissen** fest.

    ![Screenshot der Seite "Anwendung registrieren"](./readme-images/aad-register-an-app.PNG)

1. Wählen Sie **Registrieren** aus. Wählen Sie auf der Seite **AndroidJavaConnect** der App die Option **Übersicht** aus, und kopieren und speichern Sie den Wert der **Anwendungs-ID (Client-ID)**. Sie benötigen ihn im nächsten Schritt.

    ![Screenshot der Anwendungs-ID](./readme-images/aad-application-id.PNG)

1. Wählen Sie auf der App-Seite **Authentifizierung** aus. Suchen Sie den Abschnitt **Umleitungs-URI**. Aktivieren Sie im Feld _Vorgeschlagene Umleitungs-URIs für öffentliche Clients (mobil, Desktop)_ das zweite Feld, damit die App mit den in der Anwendung verwendeten MSAL-Bibliotheken arbeiten kann. (Das Feld sollte die Option _msal<YOUR\_CLIENT\_ID>://auth_ enthalten.) Wählen Sie **Speichern** aus.

    ![Screenshot des Feld "Vorgeschlagene Umleitungs-URIs für den öffentlichen Client](./readme-images/aad-redirect-uri-public-client.PNG)
  
Informationen zur Authentifizierung mit MSAL für Android zum Aufrufen von Microsoft Graph finden Sie unter [Aufrufen der Microsoft Graph-API aus einer Android-App](https://docs.microsoft.com/en-us/azure/active-directory/develop/guidedsetups/active-directory-android).

  
## Öffnen des Beispiels mithilfe von Android Studio

1. Installieren Sie [Android Studio](http://developer.android.com/sdk/index.html), und fügen Sie gemäß den [Anleitungen](http://developer.android.com/sdk/installing/adding-packages.html) auf „developer.android.com“ die Android SDK-Pakete hinzu.
2. Laden Sie dieses Beispiel herunter, oder klonen Sie es.
4. Starten Sie Android-Studio.
	1. Schließen Sie alle möglicherweise geöffneten Projekte, und wählen Sie dann **Vorhandenes Android Studio-Projekt öffnen** aus.
	2. Navigieren Sie zum lokalen Repository, und wählen Sie das Projekt "Android-Connect" aus. Klicken Sie anschließend auf **OK**.
	
	> Hinweis: In Android Studio wird die Benachrichtigung **Frameworks erkannt** angezeigt, wenn Sie das **Android-Support-Repository** nicht installiert haben. Öffnen Sie den SDK-Manager, und fügen Sie das Android-Support-Repository hinzu, um zu verhindern, dass die Benachrichtigung zu erkannten Frameworks angezeigt wird.
5. Öffnen Sie "AndroidManifest.xml".
	* Ersetzen Sie *ENTER\_YOUR\_CLIENT\_ID* an zwei Stellen durch die Anwendungs-ID aus dem vorherigen Abschnitt.
6. Erstellen Sie die App, und installieren Sie die .APK-Datei auf Ihrem Gerät oder Emulator.
7. Aktivieren Sie die **Speicher**-Berechtigung für die installierte Beispiel-App auf Ihrem Gerät oder Emulator.
8. Laden Sie das Image "test.jpg ", das sich in `android-java-connect-sample/app/src/main/res/drawable/test.jpg` befindet, in den Stammordner des externen Speichers Ihres Geräts herunter.



Nach dem Einrichten des Connect-Beispiels können Sie es auf einem Emulator oder Gerät ausführen. Wählen Sie ein Gerät mit API-Ebene 16 oder höher aus dem Dialogfeld **Gerät auswählen** aus.

Weitere Informationen über das Beispiel finden Sie unter [Aufrufen von Microsoft Graph in einer Android-App](https://developer.microsoft.com/en-us/graph/docs/concepts/android).

<a name="contributing"></a>
## Mitwirkung ##

Wenn Sie einen Beitrag zu diesem Beispiel leisten möchten, finden Sie unter [CONTRIBUTING.MD](/CONTRIBUTING.md) weitere Informationen.

In diesem Projekt wurden die [Microsoft Open Source-Verhaltensregeln](https://opensource.microsoft.com/codeofconduct/) übernommen. Weitere Informationen finden Sie unter [Häufig gestellte Fragen zu Verhaltensregeln](https://opensource.microsoft.com/codeofconduct/faq/), oder richten Sie Ihre Fragen oder Kommentare an [opencode@microsoft.com](mailto:opencode@microsoft.com).

## Fragen und Kommentare

Wir schätzen Ihr Feedback hinsichtlich des Connect-Beispiels. Sie können uns Ihre Fragen und Vorschläge über den Abschnitt [Probleme](issues) dieses Repositorys senden.

Allgemeine Fragen zur Microsoft Graph-Entwicklung sollten in [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API) gestellt werden. Stellen Sie sicher, dass Ihre Fragen oder Kommentare mit \[MicrosoftGraph] und \[API] markiert sind.

## Nächste Schritte

In diesem Beispiel werden die Grundlagen für das Funktionieren Ihrer Apps mit Microsoft Graph gezeigt. Mithilfe von Office 365-APIs können Ihre Apps viele weitere Aktionen vornehmen, z. B. das Unterstützen Ihrer Benutzer bei der Verwaltung ihrer täglichen Arbeit mit dem Kalender, das Auffinden der benötigten Informationen in allen in OneDrive gespeicherten Dateien oder das Auffinden der gewünschten Person in ihrer Liste der Kontakte. Im [Codeausschnitt-Beispiel für Android](../../../android-java-snippets-sample) warten wir noch weitere interessante Dinge für Sie. 
  
## Zusätzliche Ressourcen

* [Erste Schritte mit Office 365-APIs, unterstützt von Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph-Übersicht](http://graph.microsoft.io)
* [Microsoft Graph-SDK für Android](../../../msgraph-sdk-android)
* [Codeausschnittbeispiel für Android](../../../android-java-snippets-sample)

## Copyright
Copyright (c) 2019 Microsoft. Alle Rechte vorbehalten.
