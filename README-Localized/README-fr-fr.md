# Exemple de connexion d’Android à l’aide du kit de développement Microsoft Graph

![État de création](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "État de création")

[![Exemple de connexion Office 365](../readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "Cliquez ici pour voir l’exemple en action")

La connexion à Office 365 est la première étape que chaque application Android doit suivre pour commencer à travailler avec les services et les données Office 365. Cet exemple explique comment connecter, puis appeler une API via le kit de développement Microsoft Graph.

## Configuration requise de l’appareil

Pour exécuter l’exemple de connexion, votre appareil doit respecter les exigences suivantes :

* Un écran de 800 x 480, ou plus.
* Une API Android de niveau 16, ou supérieur.
 
## Conditions préalables

Pour utiliser l’exemple de connexion d’Android, vous devez disposer des éléments suivants :

* [Android Studio](http://developer.android.com/sdk/index.html) version 1.0 ou ultérieure.
* [Kit de développement Java (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* Une application enregistrée dans Microsoft Azure. Vous pouvez utiliser l’[outil d’inscription de l’application Office 365](http://dev.office.com/app-registration). Il simplifie l’inscription de l’application. Utilisez les paramètres suivants :

|     Paramètre   |              Valeur             |
|----------------:|:-------------------------------|
|        Type d'application | Application native                     |
|    URI de redirection | http://localhost:8000          |
| Autorisations d’application | Mail.Send                      |
  
  Copiez et stockez les valeurs **ID client** et **Clé secrète client**.
  
## Ouverture de l’exemple à l’aide d’Android Studio

1. Installez [Android Studio](http://developer.android.com/sdk/index.html) et ajoutez le kit de développement logiciel Android conformément aux [instructions](http://developer.android.com/sdk/installing/adding-packages.html) indiquées sur developer.android.com.
2. Téléchargez ou clonez cet exemple.
3. Démarrez Android Studio.
    1. Fermez tous les projets ouverts, puis cliquez sur **Ouvrir un projet Android Studio existant**.
    2. Ouvrez votre référentiel local et sélectionnez le projet Android-Connect. Cliquez sur **OK**.
    
    > Remarque : Android Studio affiche une notification **Infrastructures détectées** si vous n’avez pas installé le **référentiel de support Android**. Ouvrez le Gestionnaire de kit de développement logiciel (SDK) et ajoutez le référentiel de support Android afin d’éviter la notification Infrastructures détectées.
4. Ouvrez le fichier Constants.java.
    1. Recherchez la constante CLIENT_ID et définissez sa valeur de chaîne sur l’ID client que vous avez inscrit auprès d’Azure Active Directory.
    2. Recherchez la constante REDIRECT_URI et définissez sa valeur de chaîne sur l’URI de redirection que vous avez inscrite auprès d’Azure Active Directory.
    ![Exemple de connexion à Office 365](../readme-images/Android-Connect-Constants.png "Valeurs ID client et URI de redirection dans le fichier Constantes")

Une fois l’exemple de connexion créé, vous pouvez l’exécuter sur un émulateur ou un appareil. Choisissez un appareil avec une API de niveau 16 ou supérieur dans la boîte de dialogue **Choisir un appareil**.

Pour en savoir plus sur cet exemple, consultez la rubrique relative à l’[appel de Microsoft Graph dans une application Android](https://graph.microsoft.io/en-us/docs/platform/android).

<a name="contributing"></a>
## Contribution ##

Si vous souhaitez contribuer à cet exemple, voir [CONTRIBUTING.MD](/CONTRIBUTING.md).

Ce projet a adopté le [code de conduite Microsoft Open Source](https://opensource.microsoft.com/codeofconduct/). Pour plus d’informations, reportez-vous à la [FAQ relative au code de conduite](https://opensource.microsoft.com/codeofconduct/faq/) ou contactez [opencode@microsoft.com](mailto:opencode@microsoft.com) pour toute question ou tout commentaire.

## Questions et commentaires

Nous serions ravis de connaître votre opinion sur l’exemple de connexion. Vous pouvez nous faire part de vos questions et suggestions dans la rubrique [Problèmes](issues) de ce référentiel.

Si vous avez des questions sur le développement d’Office 365, envoyez-les sur [Stack Overflow](http://stackoverflow.com/questions/tagged/Office365+API). Posez vos questions avec les balises [API] et [Office365].

## Étapes suivantes

Cet exemple montre uniquement les conditions minimales que vos applications doivent remplir pour fonctionner avec Office 365. Vos applications peuvent faire tellement de choses grâce aux API Office 365 : aider vos utilisateurs à organiser leur semaine avec le calendrier, rechercher les informations dont ils ont besoin dans tous les fichiers stockés dans OneDrive ou rechercher la bonne personne dans leur liste de contacts. Nous avons bien d’autres choses à vous proposer dans l’[exemple d’extraits de code pour Android](/OfficeDev/O365-Android-Microsoft-Graph-Snippets). 
  
## Ressources supplémentaires

* [Prise en main des API Office 365 fournies par Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Présentation de Microsoft Graph](http://graph.microsoft.io)
* [Kit de développement logiciel (SDK) Microsoft Graph pour Android](../../../msgraph-sdk-android)
* [Extraits de code Android Microsoft Graph Office 365](../../../../OfficeDev/O365-Android-Microsoft-Graph-Snippets)

## Copyright
Copyright (c) 2016 Microsoft. Tous droits réservés.