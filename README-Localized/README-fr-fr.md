# Exemple de connexion d’Android à l’aide du kit de développement logiciel (SDK) Microsoft Graph


>**Remarque :** Nous avons mis à jour cet exemple pour utiliser la [bibliothèque d’authentification Microsoft (MSAL)](https://github.com/AzureAD/microsoft-authentication-library-for-android) pour les applications Android.


> **Vous voulez créer des applications pour des entreprises ?** Il est possible que votre application ne fonctionne pas si l’entreprise a activé les fonctionnalités de sécurité pour la mobilité en entreprise comme l’<a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">accès conditionnel des appareils</a>. Dans ce cas, vos clients peuvent rencontrer des erreurs. 

> Pour prendre en charge **toutes les entreprises clientes** dans **tous les scénarios**, utilisez le point de terminaison Azure AD et gérez vos applications avec le [portail de gestion Azure](https://aka.ms/aadapplist). Pour plus d’informations, consultez la rubrique [Choix entre les points de terminaison Azure AD et Azure AD v2.0](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint).

[![Exemple de connexion Microsoft Graph](/readme-images/O365-Android-Connect-video_play_icon.png)![Cliquez ici pour voir l’exemple en action](/readme-images/O365-Android-Connect-video_play_icon.png)

Chaque application Android commence par se connecter à Microsoft Graph pour travailler avec les services et les données Office 365. Cet exemple explique comment connecter, puis appeler une API via le kit de développement Microsoft Graph.

## Configuration requise de l’appareil

Pour exécuter l’exemple de connexion, votre appareil doit respecter les exigences suivantes :

* Un écran de 800 x 480, ou plus.
* Une API Android de niveau 16, ou supérieur.
 
## Conditions préalables

Pour utiliser l’exemple de connexion d’Android, vous devez disposer des éléments suivants :

* [Android Studio](http://developer.android.com/sdk/index.html) version 1.0 ou ultérieure.
* [Kit de développement Java (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).

<a name="register"></a>
## Enregistrement et configuration de l’application

1. Ouvrez un navigateur et accédez au [Centre d’administration Azure Active Directory](https://aad.portal.azure.com). Connectez-vous en utilisant un **compte professionnel ou scolaire**.

1. Sélectionnez **Azure Active Directory** dans le volet de navigation gauche, puis sélectionnez **Inscriptions d’applications (préversion)** sous **Gérer**.

    ![Capture d’écran des inscriptions d’applications ](./readme-images/aad-portal-app-registrations.png)

1. Sélectionnez **Nouvelle inscription**. Sur la page **Inscrire une application**, définissez les valeurs comme suit.

    - Donnez un **nom** préféré, par exemple `AndroidJavaConnect`
    - Définissez **Types de comptes pris en charge** sur **Comptes figurant dans un annuaire organisationnel**.

    ![Capture d’écran de la page Inscrire une application](./readme-images/aad-register-an-app.PNG)

1. Choisissez **Inscrire**. Dans la page d’application **AndroidJavaConnect**, sélectionnez **Vue d’ensemble**, puis copiez la valeur de l’**ID d’application (client)** et enregistrez-la car vous en aurez besoin à l’étape suivante.

    ![Capture d’écran de l’ID d’application](./readme-images/aad-application-id.PNG)

1. Dans la page de l’application, sélectionnez **Authentification**. Recherchez la section **URI de redirection**. Dans la boîte de dialogue _URI de redirection suggérés pour les clients publics (mobile, bureau)_, cochez la deuxième zone pour que l’application puisse utiliser les bibliothèques MSAL utilisées dans l’application. (La zone doit contenir l’option _msal<YOUR\_CLIENT\_ID>://auth_). Choisissez **Enregistrer**.

    ![Capture d’URI de redirection suggérés pour un client public](./readme-images/aad-redirect-uri-public-client.PNG)
  
Pour en savoir plus sur l’authentification avec MSAL pour Android afin de passer des appels à Microsoft Graph, reportez-vous à la rubrique [Appel de l’API Microsoft Graph dans une application Android](https://docs.microsoft.com/en-us/azure/active-directory/develop/guidedsetups/active-directory-android).

  
## Ouverture de l’exemple avec Android Studio

1. Installez [Android Studio](http://developer.android.com/sdk/index.html) et ajoutez le kit de développement logiciel Android conformément aux [instructions](http://developer.android.com/sdk/installing/adding-packages.html) indiquées sur developer.android.com.
2. Téléchargez ou clonez cet exemple.
4. Démarrez Android Studio.
	1. Fermez tous les projets ouverts, puis cliquez sur **Ouvrir un projet Android Studio existant**.
	2. Ouvrez votre référentiel local et sélectionnez le projet Android-Connect. Cliquez sur **OK**.
	
	> Remarque : Android Studio affiche une notification **Infrastructures détectées** si vous n’avez pas installé le **référentiel de support Android**. Ouvrez le Gestionnaire de kit de développement logiciel (SDK) et ajoutez le référentiel de support Android afin d’éviter la notification Infrastructures détectées.
5. Ouverture d’AndroidManifest.xml
	* Remplacez *ENTER\_YOUR\_CLIENT\_ID* dans deux emplacements par l’ID de l’application copiée précédemment.
6. Créez l’application et installez .APK sur votre appareil ou votre émulateur.
7. Activation de l’autorisation **Stockage** pour l’exemple d’application installé sur votre appareil ou votre émulateur
8. Téléchargez l’image test.jpg située dans : `android-java-connect-sample/app/src/main/res/drawable/test.jpg` dans le dossier racine de stockage externe de votre appareil.



Une fois l’exemple de connexion créé, vous pouvez l’exécuter sur un émulateur ou un appareil. Choisissez un appareil avec une API de niveau 16 ou supérieur dans la boîte de dialogue **Choisir un appareil**.

Pour en savoir plus sur cet exemple, consultez la rubrique [Appel de Microsoft Graph dans une application Android](https://developer.microsoft.com/en-us/graph/docs/concepts/android).

<a name="contributing"></a>
## Contribution ##

Si vous souhaitez contribuer à cet exemple, voir [CONTRIBUTING.MD](/CONTRIBUTING.md).

Ce projet a adopté le [code de conduite Open Source de Microsoft](https://opensource.microsoft.com/codeofconduct/). Pour en savoir plus, reportez-vous à la [FAQ relative au code de conduite](https://opensource.microsoft.com/codeofconduct/faq/) ou contactez [opencode@microsoft.com](mailto:opencode@microsoft.com) pour toute question ou tout commentaire.

## Questions et commentaires

Nous serions ravis de connaître votre opinion sur l’exemple de connexion. Vous pouvez nous faire part de vos questions et suggestions dans la rubrique [Problèmes](issues) de ce référentiel.

Les questions générales sur le développement de Microsoft Graph doivent être publiées sur [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API). Veillez à poser vos questions ou à rédiger vos commentaires en utilisant les tags \[MicrosoftGraph] et \[API].

## Étapes suivantes

Cet exemple montre uniquement les conditions minimales que vos applications doivent remplir pour fonctionner avec Microsoft Graph. Vos applications peuvent faire tellement de choses grâce aux API Office 365 : aider vos utilisateurs à organiser leur semaine avec le calendrier, rechercher les informations dont ils ont besoin dans tous les fichiers stockés dans OneDrive ou rechercher la bonne personne dans leur liste de contacts. Nous avons bien d’autres choses à vous proposer dans l’[exemple d’extraits de code pour Android](../../../android-java-snippets-sample). 
  
## Ressources supplémentaires

* [Prise en main des API Office 365 fournies par Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Présentation de Microsoft Graph](http://graph.microsoft.io)
* [Kit de développement logiciel (SDK) Microsoft Graph pour Android](../../../msgraph-sdk-android)
* [Exemple d’extraits de code pour Android](../../../android-java-snippets-sample)

## Copyright
Copyright (c) 2019 Microsoft. Tous droits réservés.
