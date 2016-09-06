# Ejemplo de Connect para Android con SDK de Microsoft Graph

![Estado de la compilación](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "Estado de la compilación")

[![Ejemplo de Office 365 Connect](../readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "Haga clic para ver el ejemplo en acción")

Conectarse a Office 365 es el primer paso que debe realizar cada aplicación Android para empezar a trabajar con los datos y servicios de Office 365. Este ejemplo muestra cómo conectar y cómo llamar después a una API a través del SDK de Microsoft Graph.

## Requisitos del dispositivo

Para ejecutar el ejemplo Connect, el dispositivo debe cumplir los siguientes requisitos:

* Una pantalla de tamaño de 800 x 480 o superior.
* Nivel de API de Android 16 o superior.
 
## Requisitos previos

Para usar el ejemplo Connect de Android, necesita lo siguiente:

* Versión 1.0 de [Android Studio](http://developer.android.com/sdk/index.html) o superior.
* [Kit de desarrollo Java (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* Una aplicación registrada en Microsoft Azure. Puede usar la [herramienta de registro de la aplicación Office 365](http://dev.office.com/app-registration). Simplifica el registro de la aplicación. Usa los siguientes parámetros:

|     Parámetro   |              Valor             |
|----------------:|:-------------------------------|
|        Tipo de aplicación | Aplicación nativa                     |
|    URI de redirección | http://localhost:8000          |
| Permisos de aplicación | Mail.Send                      |
  
  Copie y almacene los valores del **Id. de cliente** y **Cliente secreto**.
  
## Abrir el ejemplo con Android Studio

1. Instale [Android Studio](http://developer.android.com/sdk/index.html) y agregue los paquetes del SDK de Android según las [instrucciones](http://developer.android.com/sdk/installing/adding-packages.html) de developer.android.com.
2. Descargue o clone este ejemplo.
3. Inicie Android Studio.
    1. Cierre todos los proyectos que tenga abiertos y, después, elija **Abrir un proyecto existente de Android Studio**.
    2. Examine su repositorio local y elija el proyecto Android-Connect. Haga clic en **Aceptar**.
    
    > Nota: Android Studio muestra una notificación **Marcos de trabajo detectados** si no tiene instalado el **repositorio de soporte de Android**. Abra el administrador de SDK y agregue el repositorio de soporte de Android para evitar la notificación Marcos de trabajo detectados.
4. Abra el archivo Constants.java.
    1. Busque la constante CLIENT_ID y establezca el mismo valor de cadena que el valor del Id. de cliente que registró en Azure Active Directory.
    2. Busque la constante REDIRECT_URI y establezca el mismo valor de cadena que el valor del URI de redirección que registró en Azure Active Directory.
    ![Ejemplo de Connect de Office 365 ](../readme-images/Android-Connect-Constants.png "Valores de id. de cliente y de URI de redirección en el archivo Constants")

Una vez creado el ejemplo Connect, puede ejecutarlo en un emulador o en un dispositivo. Elija un dispositivo con un nivel de API 16 o superior desde el cuadro de diálogo **Elegir dispositivo**.

Para obtener más información acerca del ejemplo, consulte [Llamar a Microsoft Graph en una aplicación Android](https://graph.microsoft.io/en-us/docs/platform/android).

<a name="contributing"></a>
## Colaboradores ##

Si le gustaría contribuir a este ejemplo, consulte [CONTRIBUTING.MD](/CONTRIBUTING.md).

Este proyecto ha adoptado el [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/) (Código de conducta de código abierto de Microsoft). Para obtener más información, consulte las [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) (Preguntas más frecuentes del código de conducta) o póngase en contacto con [opencode@microsoft.com](mailto:opencode@microsoft.com) con otras preguntas o comentarios.

## Preguntas y comentarios

Nos encantaría recibir sus comentarios acerca del ejemplo Connect. Puede enviarnos sus preguntas y sugerencias a través de la sección [Problemas](issues) de este repositorio.

Las preguntas generales sobre desarrollo en Office 365 deben publicarse en [Stack Overflow](http://stackoverflow.com/questions/tagged/Office365+API). Asegúrese de que sus preguntas o comentarios se etiquetan con [Office365] y [API].

## Pasos siguientes

Este ejemplo muestra solo los elementos esenciales que las aplicaciones necesitan para funcionar en Office 365. Sus aplicaciones pueden hacer muchas más cosas con las API de Office 365, como ayudar a sus usuarios a administrar su día de trabajo con el calendario, encontrar la información que necesitan en todos los archivos que almacenan en OneDrive o encontrar la persona exacta que necesitan de la lista de contactos. Disponemos de más información para compartir con usted en el [Ejemplo de fragmentos de código para Android](/OfficeDev/O365-Android-Microsoft-Graph-Snippets). 
  
## Recursos adicionales

* [Comience con la API de Office 365 con tecnología de Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Información general de Microsoft Graph](http://graph.microsoft.io)
* [SDK de Microsoft Graph para Android](../../../msgraph-sdk-android)
* [Fragmentos de código de Microsoft Graph de Office 365 para Android](../../../../OfficeDev/O365-Android-Microsoft-Graph-Snippets)

## Copyright
Copyright (c) 2016 Microsoft. Todos los derechos reservados.