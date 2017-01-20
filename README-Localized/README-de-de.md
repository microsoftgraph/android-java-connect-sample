# <a name="connect-sample-for-android-using-the-microsoft-graph-sdk"></a>Connect-Beispiel für Android unter Verwendung des Microsoft Graph-SDKs

![Buildstatus](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "Buildstatus")

> **Sie erstellen Apps für Unternehmenskunden?** Ihre App funktioniert möglicherweise nicht, wenn Ihr Unternehmenskunde Enterprise Mobility-Sicherheitsfunktionen wie <a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">bedingten Gerätezugriff</a> aktiviert. In diesem Fall treten bei Ihren Kunden möglicherweise Fehler auf. 

> Zur Unterstützung **aller Unternehmenskunden** über **alle Unternehmensszenarien** hinweg müssen Sie den Azure AD-Endpunkt verwenden und Ihr Apps mithilfe des [Azure-Verwaltungsportals](https://aka.ms/aadapplist) verwalten. Weitere Informationen finden Sie unter [Entscheiden zwischen dem Azure AD- und dem Azure AD v2.0-Endpunkt](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint).

[![Microsoft Graph Connect-Beispiel](/readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "Klicken Sie, um das Beispiel in Aktion zu sehen.")

Für die Arbeit mit Office 365-Diensten und -Daten muss jede Android-App zunächst eine Verbindung zu Microsoft Graph herstellen. In diesem Beispiel wird gezeigt, wie die Verbindung zu und dann der Aufruf einer API über das Microsoft Graph-SDK erfolgt.

## <a name="device-requirements"></a>Geräteanforderungen

Zum Ausführen des Connect-Beispiels muss das Gerät die folgenden Anforderungen erfüllen:

* Eine Bildschirmgröße von mindestens 800 x 480 Pixel.
* Android-API-Ebene 16 oder höher.
 
## <a name="prerequisites"></a>Anforderungen

Zum Verwenden des Connect-Beispiels für Android benötigen Sie Folgendes:

* [Android Studio](http://developer.android.com/sdk/index.html) Version 1.0 oder höher.
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).

<a name="register"></a>
##<a name="register-and-configure-the-app"></a>Registrieren und Konfigurieren der App

1. Melden Sie sich beim [App-Registrierungsportal](https://apps.dev.microsoft.com/) entweder mit Ihrem persönlichen oder geschäftlichen Konto oder mit Ihrem Schulkonto an.
2. Klicken Sie auf **App hinzufügen**.
3. Geben Sie einen Namen für die App ein, und wählen Sie **Anwendung erstellen** aus.
    
    Die Registrierungsseite wird angezeigt, und die Eigenschaften der App werden aufgeführt.
 
4. Wählen Sie unter **Plattformen** die Option **Plattform hinzufügen** aus.
5. Wählen Sie **Mobile Anwendung** aus.
6. Kopieren Sie die **Anwendungs-ID**; Sie benötigen sie im nächsten Abschnitt.
7. Klicken Sie auf **Speichern**.
  
## <a name="open-the-sample-using-android-studio"></a>Öffnen des Beispiels mithilfe von Android Studio

1. Installieren Sie [Android Studio](http://developer.android.com/sdk/index.html), und fügen Sie gemäß den [Anleitungen](http://developer.android.com/sdk/installing/adding-packages.html) auf „developer.android.com“ die Android SDK-Pakete hinzu.
2. Laden Sie dieses Beispiel herunter, oder klonen Sie es.
3. Starten Sie Android Studio.
    1. Schließen Sie alle möglicherweise geöffneten Projekte, und wählen Sie dann **Vorhandenes Android Studio-Projekt öffnen** aus.
    2. Navigieren Sie zum lokalen Repository, und wählen Sie das Projekt „Android-Connect“ aus. Klicken Sie auf **OK**.
    
    > Hinweis: In Android Studio wird die Benachrichtigung **Frameworks erkannt** angezeigt, wenn Sie das **Android-Support-Repository** nicht installiert haben. Öffnen Sie den SDK-Manager, und fügen Sie das Android-Support-Repository hinzu, um zu verhindern, dass die Benachrichtigung zu erkannten Frameworks angezeigt wird.
4. Öffnen Sie die Datei „Constants.java“.
    * Ersetzen Sie *ENTER_YOUR_CLIENT_ID* durch die Anwendungs-ID aus dem vorherigen Abschnitt.

Nach dem Einrichten des Connect-Beispiels können Sie es auf einem Emulator oder Gerät ausführen. Wählen Sie ein Gerät mit API-Ebene 16 oder höher aus dem Dialogfeld **Gerät auswählen** aus.

Weitere Informationen über das Beispiel finden Sie unter [Aufrufen von Microsoft Graph in einer Android-App](https://graph.microsoft.io/en-us/docs/platform/android).

<a name="contributing"></a>
## <a name="contributing"></a>Mitwirkung ##

Wenn Sie einen Beitrag zu diesem Beispiel leisten möchten, finden Sie unter [CONTRIBUTING.MD](/CONTRIBUTING.md) weitere Informationen.

In diesem Projekt wurden die [Microsoft Open Source-Verhaltensregeln](https://opensource.microsoft.com/codeofconduct/) übernommen. Weitere Informationen finden Sie unter [Häufig gestellte Fragen zu Verhaltensregeln](https://opensource.microsoft.com/codeofconduct/faq/), oder richten Sie Ihre Fragen oder Kommentare an [opencode@microsoft.com](mailto:opencode@microsoft.com).

## <a name="questions-and-comments"></a>Fragen und Kommentare

Wir schätzen Ihr Feedback hinsichtlich des Connect-Beispiels. Sie können uns Ihre Fragen und Vorschläge über den Abschnitt [Probleme](issues) dieses Repositorys senden.

Allgemeine Fragen zur Microsoft Graph-Entwicklung sollten in [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API) gestellt werden. Stellen Sie sicher, dass Ihre Fragen oder Kommentare mit [MicrosoftGraph] und [API] markiert sind.

## <a name="next-steps"></a>Nächste Schritte

In diesem Beispiel werden die Grundlagen für das Funktionieren Ihrer Apps mit Microsoft Graph gezeigt. Mithilfe von Office 365-APIs können Ihre Apps viele weitere Aktionen vornehmen, z. B. das Unterstützen Ihrer Benutzer bei der Verwaltung ihrer täglichen Arbeit mit dem Kalender, das Auffinden der benötigten Informationen in allen in OneDrive gespeicherten Dateien oder das Auffinden der gewünschten Person in ihrer Liste der Kontakte. Im [Codeausschnitt-Beispiel für Android](../../../android-java-snippets-sample) warten wir noch weitere interessante Dinge für Sie. 
  
## <a name="additional-resources"></a>Zusätzliche Ressourcen

* [Erste Schritte mit Office 365-APIs, unterstützt von Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph-Übersicht](http://graph.microsoft.io)
* [Microsoft Graph-SDK für Android](../../../msgraph-sdk-android)
* [Codeausschnittbeispiel für Android](../../../android-java-snippets-sample)

## <a name="copyright"></a>Copyright
Copyright (c) 2016 Microsoft. Alle Rechte vorbehalten.
