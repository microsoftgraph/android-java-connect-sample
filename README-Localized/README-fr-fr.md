# <a name="connect-sample-for-android-using-the-microsoft-graph-sdk"></a>Exemple de connexion d’Android à l’aide du kit de développement Microsoft Graph

![État de création](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "État de création")

> **Vous voulez créer des applications pour des entreprises ?** Il est possible que votre application ne fonctionne pas si l’entreprise a activé les fonctionnalités de sécurité pour la mobilité en entreprise comme l’<a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">accès conditionnel des appareils</a>. Dans ce cas, vos clients peuvent rencontrer des erreurs. 

> Pour prendre en charge **toutes les entreprises clientes** dans **tous les scénarios**, utilisez le point de terminaison Azure AD et gérez vos applications avec le [portail de gestion Azure](https://aka.ms/aadapplist). Pour plus d’informations, consultez les [fonctionnalités des points de terminaison Azure AD et Azure AD v2.0](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint).

[![Exemple de connexion Microsoft Graph](/readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "Cliquez ici pour voir l’exemple en action")

Chaque application Android commence par se connecter à Microsoft Graph pour travailler avec les services et les données Office 365. Cet exemple explique comment connecter, puis appeler une API via le kit de développement Microsoft Graph.

## <a name="device-requirements"></a>Configuration requise de l’appareil

Pour exécuter l’exemple de connexion, votre appareil doit respecter les exigences suivantes :

* Un écran de 800 x 480, ou plus.
* Une API Android de niveau 16, ou supérieur.
 
## <a name="prerequisites"></a>Conditions préalables

Pour utiliser l’exemple de connexion d’Android, vous devez disposer des éléments suivants :

* [Android Studio](http://developer.android.com/sdk/index.html) version 1.0 ou ultérieure.
* [Kit de développement Java (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).

<a name="register"></a>
##<a name="register-and-configure-the-app"></a>Enregistrement et configuration de l’application

1. Connectez-vous au [portail d’inscription des applications](https://apps.dev.microsoft.com/) en utilisant votre compte personnel, professionnel ou scolaire.
2. Sélectionnez **Ajouter une application**.
3. Entrez un nom pour l’application, puis sélectionnez **Créer une application**.
    
    La page d’inscription s’affiche, répertoriant les propriétés de votre application.
 
4. Sous **Plateformes**, sélectionnez **Ajouter une plateforme**.
5. Sélectionnez **Application mobile**.
6. Copiez l’**ID de l’application**. Vous en aurez besoin dans la section suivante.
7. Cliquez sur **Enregistrer**.
  
## <a name="open-the-sample-using-android-studio"></a>Ouverture de l’exemple à l’aide d’Android Studio

1. Installez [Android Studio](http://developer.android.com/sdk/index.html) et ajoutez le kit de développement logiciel Android conformément aux [instructions](http://developer.android.com/sdk/installing/adding-packages.html) indiquées sur developer.android.com.
2. Téléchargez ou clonez cet exemple.
3. Démarrez Android Studio.
    1. Fermez tous les projets ouverts, puis cliquez sur **Ouvrir un projet Android Studio existant**.
    2. Ouvrez votre référentiel local et sélectionnez le projet Android-Connect. Cliquez sur **OK**.
    
    > Remarque : Android Studio affiche une notification **Infrastructures détectées** si vous n’avez pas installé le **référentiel de support Android**. Ouvrez le Gestionnaire de kit de développement logiciel (SDK) et ajoutez le référentiel de support Android afin d’éviter la notification Infrastructures détectées.
4. Ouvrez le fichier Constants.java.
    * Remplacez *ENTER_YOUR_CLIENT_ID* par l’ID de l’application copiée précédemment.

Une fois l’exemple de connexion créé, vous pouvez l’exécuter sur un émulateur ou un appareil. Choisissez un appareil avec une API de niveau 16 ou supérieur dans la boîte de dialogue **Choisir un appareil**.

Pour en savoir plus sur cet exemple, consultez la rubrique relative à l’[appel de Microsoft Graph dans une application Android](https://graph.microsoft.io/en-us/docs/platform/android).

<a name="contributing"></a>
## <a name="contributing"></a>Contribution ##

Si vous souhaitez contribuer à cet exemple, voir [CONTRIBUTING.MD](/CONTRIBUTING.md).

Ce projet a adopté le [code de conduite Microsoft Open Source](https://opensource.microsoft.com/codeofconduct/). Pour plus d’informations, reportez-vous à la [FAQ relative au code de conduite](https://opensource.microsoft.com/codeofconduct/faq/) ou contactez [opencode@microsoft.com](mailto:opencode@microsoft.com) pour toute question ou tout commentaire.

## <a name="questions-and-comments"></a>Questions et commentaires

Nous serions ravis de connaître votre opinion sur l’exemple de connexion. Vous pouvez nous faire part de vos questions et suggestions dans la rubrique [Problèmes](issues) de ce référentiel.

Les questions générales sur le développement de Microsoft Graph doivent être publiées sur [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API). Veillez à poser vos questions ou à rédiger vos commentaires en utilisant les tags [MicrosoftGraph] et [API].

## <a name="next-steps"></a>Étapes suivantes

Cet exemple montre uniquement les conditions minimales que vos applications doivent remplir pour fonctionner avec Microsoft Graph. Vos applications peuvent faire tellement de choses grâce aux API Office 365 : aider vos utilisateurs à organiser leur semaine avec le calendrier, rechercher les informations dont ils ont besoin dans tous les fichiers stockés dans OneDrive ou rechercher la bonne personne dans leur liste de contacts. Nous avons bien d’autres choses à vous proposer dans l’[exemple d’extraits de code pour Android](../../../android-java-snippets-sample). 
  
## <a name="additional-resources"></a>Ressources supplémentaires

* [Prise en main des API Office 365 fournies par Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Présentation de Microsoft Graph](http://graph.microsoft.io)
* [Kit de développement logiciel (SDK) Microsoft Graph pour Android](../../../msgraph-sdk-android)
* [Exemple d’extraits de code pour Android](../../../android-java-snippets-sample)

## <a name="copyright"></a>Copyright
Copyright (c) 2016 Microsoft. Tous droits réservés.
