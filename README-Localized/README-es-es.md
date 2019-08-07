# Ejemplo de Connect para Android con SDK de Microsoft Graph


>**Nota:** Hemos actualizado este ejemplo para usar la [Biblioteca de autenticación de Microsoft (MSAL)](https://github.com/AzureAD/microsoft-authentication-library-for-android) para aplicaciones Android.


> **¿Quiere crear aplicaciones para clientes empresariales?** Es posible que la aplicación no funcione si su cliente empresarial activa características de seguridad de movilidad empresarial como el <a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">acceso condicional al dispositivo</a>. En este caso, es posible que no tenga constancia de esta activación y que sus clientes obtengan errores. 

> Para admitir **todos los clientes empresariales** en **todos los escenarios de empresa**, deberá usar el punto de conexión de Azure AD y administrar las aplicaciones mediante el [Portal de administración de Azure](https://aka.ms/aadapplist). Para obtener más información, vea [Decidir entre los puntos de conexión de Azure AD y Azure AD v2.0](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint).

[![Ejemplo de Connect de Microsoft Graph](/readme-images/O365-Android-Connect-video_play_icon.png)![Haga clic para ver el ejemplo en acción](/readme-images/O365-Android-Connect-video_play_icon.png)

Conectarse a Microsoft Graph es el primer paso que tiene que realizar cada aplicación Android para empezar a trabajar con los datos y servicios de Office 365. Este ejemplo muestra cómo conectar y cómo llamar después a una API a través del SDK de Microsoft Graph.

## Requisitos del dispositivo

Para ejecutar el ejemplo Connect, el dispositivo debe cumplir los siguientes requisitos:

* Una pantalla de tamaño de 800 x 480 o superior.
* Nivel de API de Android 16 o superior.
 
## Requisitos previos

Para usar el ejemplo Connect de Android, necesita lo siguiente:

* Versión 1.0 o posterior de [Android Studio](http://developer.android.com/sdk/index.html).
* [Kit de desarrollo Java (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).

<a name="register"></a>
## Registrar y configurar la aplicación

1. Abra un explorador y vaya al [Centro de administración de Azure Active Directory](https://aad.portal.azure.com). Inicie sesión con **una cuenta profesional o educativa**.

1. Seleccione **Azure Active Directory** en el panel de navegación izquierdo y, después, seleccione **Registros de aplicaciones (versión preliminar)** en **Administrar**.

    ![Una captura de pantalla de los registros de la aplicación ](./readme-images/aad-portal-app-registrations.png)

1. Seleccione **Nuevo registro**. En la página **Registrar una aplicación**, establezca los valores siguientes.

    - Establezca un **Nombre** preferido por ejemplo, ` AndroidJavaConnect`
    - Establezca **los tipos de cuenta compatibles** en **Cuentas en cualquier directorio de la organización**.

    ![Una captura de pantalla de la página Registrar una aplicación](./readme-images/aad-register-an-app.PNG)

1. Elija **Registrar**. En la página de la aplicación **AndroidJavaConnect**, seleccione **Información general**, copie el valor del **Id. de la aplicación (cliente)** y guárdelo. Lo necesitará en el siguiente paso.

    ![Una captura de pantalla del Id. de aplicación](./readme-images/aad-application-id.PNG)

1. En la página de la aplicación, seleccione **Autenticación**. Localice la sección **URI de redirección**. En los _URI de redirección sugeridos para clientes públicos (móvil, escritorio)_, marque el segundo cuadro para que la aplicación pueda funcionar con las bibliotecas de MSAL utilizadas en la aplicación. (El cuadro debe contener la opción _msal<ID\_DE\_CLIENTE>://auth_). Elija **Guardar**.

    ![Captura de pantalla de URI de redirección sugeridos para cliente público](./readme-images/aad-redirect-uri-public-client.PNG)
  
Para obtener información sobre cómo autenticarse con MSAL para Android para realizar llamadas a Microsoft Graph, vea [Llamar a la API de Microsoft Graph desde una aplicación de Android](https://docs.microsoft.com/en-us/azure/active-directory/develop/guidedsetups/active-directory-android).

  
## Abrir el ejemplo con Android Studio

1. Instale [Android Studio](http://developer.android.com/sdk/index.html) y agregue los paquetes del SDK de Android según las [instrucciones](http://developer.android.com/sdk/installing/adding-packages.html) de developer.android.com.
2. Descargue o clone este ejemplo.
4. Inicie Android Studio.
	1. Cierre todos los proyectos que tenga abiertos y, después, elija **Abrir un proyecto existente de Android Studio**.
	2. Examine su repositorio local y elija el proyecto Android-Connect. Haga clic en **Aceptar**.
	
	> Nota: Android Studio muestra una notificación de **Marcos de trabajo detectados** si no tiene instalado el **Repositorio de soporte de Android**. Abra el administrador de SDK y agregue el repositorio de soporte de Android para evitar la notificación Marcos de trabajo detectados.
5. Abra AndroidManifest.xml
	* Reemplace *ESCRIBIR\_ID \_CLIENTE* en dos lugares con el id. de la aplicación de la sección anterior.
6. Cree la aplicación e instale el .APK en su dispositivo o emulador.
7. Habilite el permiso de **almacenamiento** para la aplicación de ejemplo instalada en el dispositivo o en el emulador.
8. Descargue la imagen de test.jpg ubicada en: ` android-java-connect-sample/app/src/main/res/drawable/test.jpg` en la carpeta raíz de almacenamiento externo del dispositivo.



Una vez creado el ejemplo Connect, puede ejecutarlo en un emulador o en un dispositivo. Elija un dispositivo con un nivel de API 16 o superior desde el cuadro de diálogo **Elegir dispositivo**.

Para obtener más información sobre el ejemplo, vea [Llamar a Microsoft Graph en una aplicación Android](https://developer.microsoft.com/en-us/graph/docs/concepts/android).

<a name="contributing"></a>
## Colaboradores ##

Si le gustaría contribuir a este ejemplo, vea [CONTRIBUTING.MD](/CONTRIBUTING.md).

Este proyecto ha adoptado el [Código de conducta de código abierto de Microsoft](https://opensource.microsoft.com/codeofconduct/). Para obtener más información, vea [Preguntas frecuentes sobre el código de conducta](https://opensource.microsoft.com/codeofconduct/faq/) o póngase en contacto con [opencode@microsoft.com](mailto:opencode@microsoft.com) si tiene otras preguntas o comentarios.

## Preguntas y comentarios

Nos encantaría recibir sus comentarios sobre el ejemplo Connect. Puede enviarnos sus preguntas y sugerencias a través de la sección [Problemas](issues) de este repositorio.

Las preguntas generales sobre el desarrollo de Microsoft Graph deben publicarse en [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API). Asegúrese de que sus preguntas o comentarios se etiquetan con \[MicrosoftGraph] y \[API].

## Pasos siguientes

Este ejemplo muestra solo los elementos esenciales que las aplicaciones necesitan para funcionar en Microsoft Graph. Sus aplicaciones pueden hacer muchas más cosas con las API de Office 365, como ayudar a sus usuarios a administrar su día de trabajo con el calendario, encontrar la información que necesitan en todos los archivos que almacenan en OneDrive o encontrar la persona exacta que necesitan en la lista de contactos. Disponemos de más información para compartir con usted en el [Ejemplo de fragmentos de código para Android](../../../android-java-snippets-sample). 
  
## Recursos adicionales

* [Introducción a las API de Office 365 con tecnología de Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Información general de Microsoft Graph](http://graph.microsoft.io)
* [SDK de Microsoft Graph para Android](../../../msgraph-sdk-android)
* [Ejemplo de fragmentos de código para Android](../../../android-java-snippets-sample)

## Copyright
Copyright (c) 2019 Microsoft. Todos los derechos reservados.
