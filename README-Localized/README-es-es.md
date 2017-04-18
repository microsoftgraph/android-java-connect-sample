# <a name="connect-sample-for-android-using-the-microsoft-graph-sdk"></a>Ejemplo de Connect para Android con SDK de Microsoft Graph


>**Nota**: Estamos actualizando este ejemplo para poder usarlo con la [biblioteca de autenticación recomendada](https://docs.microsoft.com/es-es/azure/active-directory/develop/active-directory-v2-libraries#compatible-client-libraries) para las aplicaciones de Android.


> **¿Desea compilar aplicaciones para clientes empresariales?** Es posible que la aplicación no funcione si su cliente empresarial activa características de seguridad de movilidad empresarial como el <a href="https://azure.microsoft.com/es-es/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">acceso condicional al dispositivo</a>. En casos así, es posible que no tenga constancia de esta activación y que sus clientes obtengan errores. 

> Para ser compatible con **todos los clientes empresariales** en **todos los escenarios de empresa**, tiene que usar el punto de conexión de AD de Azure y administrar las aplicaciones mediante el [Portal de administración de Azure](https://aka.ms/aadapplist). Para obtener más información, consulte [Decidir entre los puntos de conexión de Azure AD y Azure AD v2.0 ](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint).

[![Ejemplo de Connect para Microsoft Graph](/readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "Haga clic para ver el ejemplo en acción").

Conectarse a Microsoft Graph es el primer paso que tiene que realizar cada aplicación Android para empezar a trabajar con los datos y servicios de Office 365. Este ejemplo muestra cómo conectar y cómo llamar después a una API a través del SDK de Microsoft Graph.

## <a name="device-requirements"></a>Requisitos del dispositivo

Para ejecutar el ejemplo Connect, el dispositivo debe cumplir los siguientes requisitos:

* Una pantalla de tamaño de 800 x 480 o superior.
* Nivel de API de Android 16 o superior.
 
## <a name="prerequisites"></a>Requisitos previos

Para usar el ejemplo Connect de Android, necesita lo siguiente:

* Versión 1.0 de [Android Studio](http://developer.android.com/sdk/index.html) o superior.
* [Kit de desarrollo Java (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).

<a name="register"></a>
##<a name="register-and-configure-the-app"></a>Registrar y configurar la aplicación

1. Inicie sesión en el [Portal de registro de la aplicación](https://apps.dev.microsoft.com/) mediante su cuenta personal, profesional o educativa.
2. Seleccione **Agregar una aplicación**.
3. Escriba un nombre para la aplicación y seleccione **Crear aplicación**.
    
    Se muestra la página de registro, indicando las propiedades de la aplicación.
 
4. En **Plataformas**, seleccione **Agregar plataforma**.
5. Seleccione **Aplicación móvil**.
6. Copie el **identificador de la aplicación**, ya que lo necesitará en la sección siguiente.
7. Haga clic en **Guardar**.
  
## <a name="open-the-sample-using-android-studio"></a>Abrir el ejemplo con Android Studio

1. Instale [Android Studio](http://developer.android.com/sdk/index.html) y agregue los paquetes del SDK de Android según las [instrucciones](http://developer.android.com/sdk/installing/adding-packages.html) de developer.android.com.
2. Descargue o clone este ejemplo.
3. Inicie Android Studio.
    1. Cierre todos los proyectos que tenga abiertos y, después, elija **Abrir un proyecto existente de Android Studio**.
    2. Examine su repositorio local y elija el proyecto Android-Connect. Haga clic en **Aceptar**.
    
    > Nota: Android Studio muestra una notificación **Marcos de trabajo detectados** si no tiene instalado el **repositorio de soporte de Android**. Abra el administrador de SDK y agregue el repositorio de soporte de Android para evitar la notificación Marcos de trabajo detectados.
4. Abra el archivo Constants.java.
    * Reemplace *ENTER_YOUR_CLIENT_ID* con el identificador de la aplicación de la sección anterior.

Una vez creado el ejemplo Connect, puede ejecutarlo en un emulador o en un dispositivo. Elija un dispositivo con un nivel de API 16 o superior desde el cuadro de diálogo **Elegir dispositivo**.

Para obtener más información acerca del ejemplo, consulte [Llamar a Microsoft Graph en una aplicación Android](https://graph.microsoft.io/en-us/docs/platform/android).

<a name="contributing"></a>
## <a name="contributing"></a>Colaboradores ##

Si le gustaría contribuir a este ejemplo, consulte [CONTRIBUTING.MD](/CONTRIBUTING.md).

Este proyecto ha adoptado el [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/) (Código de conducta de código abierto de Microsoft). Para obtener más información, consulte las [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) (Preguntas más frecuentes del código de conducta) o póngase en contacto con [opencode@microsoft.com](mailto:opencode@microsoft.com) con otras preguntas o comentarios.

## <a name="questions-and-comments"></a>Preguntas y comentarios

Nos encantaría recibir sus comentarios acerca del ejemplo Connect. Puede enviarnos sus preguntas y sugerencias a través de la sección [Problemas](issues) de este repositorio.

Las preguntas generales sobre el desarrollo de Microsoft Graph deben publicarse en [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API). Asegúrese de que sus preguntas o comentarios se etiquetan con y [MicrosoftGraph] y [API].

## <a name="next-steps"></a>Pasos siguientes

Este ejemplo muestra solo los elementos esenciales que las aplicaciones necesitan para funcionar en Microsoft Graph. Sus aplicaciones pueden hacer muchas más cosas con las API de Office 365, como ayudar a sus usuarios a administrar su día de trabajo con el calendario, encontrar la información que necesitan en todos los archivos que almacenan en OneDrive o encontrar la persona exacta que necesitan de la lista de contactos. Disponemos de más información para compartir con usted en el [Ejemplo de fragmentos de código para Android](../../../android-java-snippets-sample). 
  
## <a name="additional-resources"></a>Recursos adicionales

* [Empiece a trabajar con la API de Office 365 con tecnología de Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Información general de Microsoft Graph](http://graph.microsoft.io)
* [SDK de Microsoft Graph para Android](../../../msgraph-sdk-android)
* [Ejemplo de fragmentos de código para Android](../../../android-java-snippets-sample)

## <a name="copyright"></a>Copyright
Copyright (c) 2016 Microsoft. Todos los derechos reservados.
