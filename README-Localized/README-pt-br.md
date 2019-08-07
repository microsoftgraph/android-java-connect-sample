# Exemplo de conexão para Android usando o SDK do Microsoft Graph


>**Observação:** Nós atualizamos este exemplo para usar a [MSAL (Biblioteca de Autenticação da Microsoft)](https://github.com/AzureAD/microsoft-authentication-library-for-android) em aplicativos Android.


> **Criando aplicativos para clientes corporativos?** O aplicativo pode não funcionar caso o cliente corporativo habilite os recursos do Enterprise Mobility + Security, como <a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">acesso condicional ao dispositivo</a>. Nesse caso, pode ser que você não esteja ciente e seus clientes possam estar enfrentando erros. 

> Para fornecer suporte a **todos os clientes corporativos**, em **todos os cenários corporativos**, use o ponto de extremidade do Azure AD e gerencie os aplicativos usando o [Portal de Gerenciamento do Microsoft Azure](https://aka.ms/aadapplist). Saiba mais em [Decidindo entre os pontos de extremidade do Azure AD e do Azure AD v2.0](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint).

[![Exemplo de conexão usando o Microsoft Graph](/readme-images/O365-Android-Connect-video_play_icon.png)![Clique no exemplo para vê-lo em ação](/readme-images/O365-Android-Connect-video_play_icon.png)

Conectar-se ao Microsoft Graph é a primeira etapa para que os aplicativos Android comecem a funcionar com dados e serviços do Office 365. Este exemplo mostra como conectar e chamar uma única API através do SDK do Microsoft Graph.

## Requisitos do dispositivo

Para executar o exemplo de conexão, o dispositivo deve atender aos seguintes requisitos:

* Uma tela de tamanho 800 x 480 ou maior.
* API Android nível 16 ou superior.
 
## Pré-requisitos

Para usar o exemplo de conexão para Android, é necessário o seguinte:

* [Android Studio](http://developer.android.com/sdk/index.html) versão 1.0 ou posterior.
* [JDK (Java Development Kit) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).

<a name="register"></a>
## Registrar e configurar o aplicativo

1. Abra um navegador e navegue até o [centro de administração do Azure Active Directory](https://aad.portal.azure.com). Faça o login usando uma **Conta Corporativa ou de Estudante**.

1. Selecione **Azure Active Directory** na navegação à esquerda e, em seguida, selecione **Registros de aplicativo (Visualizar)** em **Gerenciar**.

    ![Captura de tela dos Registros de aplicativo](./readme-images/aad-portal-app-registrations.png)

1. Selecione **Novo registro**. Na página **Registrar um aplicativo**, defina os valores da seguinte forma.

    - Definir um **Nome** preferido, por exemplo, `AndroidJavaConnect`
    - Defina os **Tipos de conta com suporte** para **Contas em qualquer diretório organizacional**.

    ![Captura de tela da página Registrar um aplicativo](./readme-images/aad-register-an-app.PNG)

1. Escolha **Registrar**. Na página do aplicativo **AndroidJavaConnect**, selecione **Visão geral** e copie o valor da **ID do aplicativo (cliente)** e salve-a, pois precisará dela na próxima etapa.

    ![Captura de tela da ID do aplicativo](./readme-images/aad-application-id.PNG)

1. Ainda na página do aplicativo, selecione **Autenticação**. Localize a seção **URIs de redirecionamento**. Nos _URIs de redirecionamento sugeridos para clientes públicos (móvel, computador)_, marque a segunda caixa de seleção para que o aplicativo possa trabalhar com as bibliotecas MSAL usadas no aplicativo. (A caixa de seleção deve conter a opção _msal<YOUR\_CLIENT\_ID>://auth_). Escolha **Salvar**.

    ![Captura de tela dos URIs de redirecionamento sugeridos para clientes públicos](./readme-images/aad-redirect-uri-public-client.PNG)
  
Para saber mais sobre a autenticação com a MSAL do Android para fazer chamadas ao Microsoft Graph, confira [Chamada à API do Microsoft Graph em um aplicativo Android](https://docs.microsoft.com/en-us/azure/active-directory/develop/guidedsetups/active-directory-android).

  
## Abra o exemplo usando o Android Studio

1. Instale o [Android Studio](http://developer.android.com/sdk/index.html) e adicione os pacotes do SDK do Android de acordo com as [instruções](http://developer.android.com/sdk/installing/adding-packages.html) na página developer.android.com.
2. Baixe ou clone esse exemplo.
4. Inicie o Android Studio.
	1. Feche todos os projetos abertos e escolha **Abrir um projeto existente do Android Studio**.
	2. Navegue até o repositório local e escolha o projeto Android-Connect. Clique em **OK**.
	
	> Observação: O Android Studio mostra uma notificação de **Estruturas detectadas** se você não tiver o **Repositório de Suporte do Android** instalado. Abra o gerenciador de SDK e adicione o Repositório de Suporte do Android para evitar a notificação de Estruturas detectadas.
5. Abra AndroidManifest.xml
	* Substitua *INSERIR\_ID\_DO\_CLIENTE* em dois locais pela ID do aplicativo que você copiou na seção anterior.
6. Crie o aplicativo e instale o .APK no seu dispositivo ou emulador.
7. Ative a permissão de **Armazenamento** para o aplicativo de exemplo instalado no seu dispositivo ou emulador
8. Baixe a imagem test.jpg localizada em: `android-java-connect-sample/app/src/main/res/drawable/test.jpg` na pasta raiz de armazenamento externo do seu dispositivo.



Depois de criar o exemplo de conexão, você poderá executá-lo em um emulador ou dispositivo. Escolha um dispositivo com API de nível 16 ou superior na caixa de diálogo **Escolher dispositivo**.

Para saber mais sobre o exemplo, confira [Chamar o Microsoft Graph em um aplicativo Android](https://developer.microsoft.com/en-us/graph/docs/concepts/android).

<a name="contributing"></a>
## Colaboração ##

Se quiser contribuir para esse exemplo, confira [CONTRIBUTING.MD](/CONTRIBUTING.md).

Este projeto adotou o [Código de Conduta de Código Aberto da Microsoft](https://opensource.microsoft.com/codeofconduct/).  Para saber mais, confira as [Perguntas frequentes sobre o Código de Conduta](https://opensource.microsoft.com/codeofconduct/faq/) ou entre em contato pelo [opencode@microsoft.com](mailto:opencode@microsoft.com) para outras dúvidas ou comentários.

## Perguntas e comentários

Gostaríamos de saber a sua opinião sobre o exemplo de conexão. Você pode enviar perguntas e sugestões na seção [Problemas](issues) deste repositório.

As perguntas sobre o desenvolvimento do Microsoft Graph em geral devem ser postadas no [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API). Não deixe de marcar as perguntas ou comentários com \[MicrosoftGraph] e \[API].

## Próximas etapas

Este exemplo mostra apenas os conceitos básicos necessários para que os aplicativos funcionem com o Microsoft Graph. O aplicativo pode fazer muito mais usando as APIs do Office 365, como ajudar usuários a gerenciar os dias úteis com o calendário, localizar apenas as informações necessárias em todos os arquivos armazenados no OneDrive ou localizar uma pessoa específica na lista de contatos. Temos mais recursos para compartilhar com você no [Exemplo de trechos de código para Android](../../../android-java-snippets-sample). 
  
## Recursos adicionais

* [Introdução às APIs do Office 365 desenvolvidas pelo Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Visão geral do Microsoft Graph](http://graph.microsoft.io)
* [SDK do Microsoft Graph para Android](../../../msgraph-sdk-android)
* [Exemplo de trechos de código para Android](../../../android-java-snippets-sample)

## Direitos autorais
Copyright (c) 2019 Microsoft. Todos os direitos reservados.
