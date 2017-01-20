# <a name="connect-sample-for-android-using-the-microsoft-graph-sdk"></a>Exemplo de conexão para Android usando o SDK do Microsoft Graph

![Status da Compilação](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "Status da Compilação")

> **Criando aplicativos para clientes corporativos?** O aplicativo pode não funcionar caso o cliente corporativo habilite os recursos Enterprise Mobility + Security, como <a href="https://azure.microsoft.com/en-us/documentation/articles/active-directory-conditional-access-device-policies/" target="_newtab">acesso condicional ao dispositivo</a>. Nesse caso, pode ser que você não esteja ciente e seus clientes podem encontrar erros. 

> Para fornecer suporte a **todos os clientes corporativos**, em **todos os cenários corporativos**, use o ponto de extremidade do Microsoft Azure AD e gerencie os aplicativos usando o [Portal de Gerenciamento do Microsoft Azure](https://aka.ms/aadapplist). Para saber mais, confira o tópico [Decidindo entre os pontos de extremidade do Microsoft Azure AD e do Microsoft Azure AD versão 2.0](https://graph.microsoft.io/docs/authorization/auth_overview#deciding-between-azure-ad-and-the-v2-authentication-endpoint).

[![Exemplo de conexão usando o Microsoft Graph](/readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "Clique no exemplo para vê-lo em ação")

Conectar-se ao Microsoft Graph é a primeira etapa para que os aplicativos Android comecem a funcionar com dados e serviços do Office 365. Este exemplo mostra como conectar e chamar uma única API através do SDK do Microsoft Graph.

## <a name="device-requirements"></a>Requisitos do dispositivo

Para executar o exemplo de conexão, o dispositivo deve atender aos seguintes requisitos:

* Uma tela de tamanho 800 x 480 ou maior.
* API Android nível 16 ou superior.
 
## <a name="prerequisites"></a>Pré-requisitos

Para usar o exemplo de conexão para Android, é necessário o seguinte:

* [Android Studio](http://developer.android.com/sdk/index.html) versão 1.0 ou posterior.
* [JDK (Java Development Kit) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).

<a name="register"></a>
##<a name="register-and-configure-the-app"></a>Registrar e configurar o aplicativo

1. Entre no [Portal de Registro do Aplicativo](https://apps.dev.microsoft.com/) usando sua conta pessoal ou sua conta comercial ou escolar.
2. Selecione **Adicionar um aplicativo**.
3. Insira um nome para o aplicativo e selecione **Criar aplicativo**.
    
    A página de registro é exibida, listando as propriedades do seu aplicativo.
 
4. Em **Plataformas**, selecione **Adicionar plataforma**.
5. Escolha **Aplicativo móvel**.
6. Copie a **ID do Aplicativo**, pois você vai precisar dela na seção seguinte.
7. Clique em **Salvar**.
  
## <a name="open-the-sample-using-android-studio"></a>Abra o exemplo usando o Android Studio

1. Instale o [Android Studio](http://developer.android.com/sdk/index.html) e adicione os pacotes do SDK do Android de acordo com as [instruções](http://developer.android.com/sdk/installing/adding-packages.html) na página developer.android.com.
2. Baixe ou clone esse exemplo.
3. Inicie o Android Studio.
    1. Feche todos os projetos abertos e escolha **Abrir um projeto existente do Android Studio**.
    2. Navegue até o repositório local e escolha o projeto Android-Connect. Clique em **OK**.
    
    > Observação: O Android Studio mostra uma notificação de **Estruturas detectadas** se você não tiver o **Repositório de Suporte do Android** instalado. Abra o gerenciador de SDK e adicione o Repositório de Suporte do Android para evitar a notificação de estruturas detectadas.
4. Abra o arquivo Constants.java.
    * Substitua o texto *INSERIR_ID_DO_CLIENTE* pela ID do Aplicativo que você copiou na seção anterior.

Depois de criar o exemplo de conexão, você pode executá-lo em um emulador ou dispositivo. Escolha um dispositivo com API de nível 16 ou superior na caixa de diálogo **Escolher dispositivo**.

Para saber mais sobre o exemplo, confira o artigo [Chamar o Microsoft Graph em um aplicativo Android](https://graph.microsoft.io/en-us/docs/platform/android).

<a name="contributing"></a>
## <a name="contributing"></a>Colaboração ##

Se quiser contribuir para esse exemplo, confira [CONTRIBUTING.MD](/CONTRIBUTING.md).

Este projeto adotou o [Código de Conduta do Código Aberto da Microsoft](https://opensource.microsoft.com/codeofconduct/). Para saber mais, confira as [Perguntas frequentes do Código de Conduta](https://opensource.microsoft.com/codeofconduct/faq/) ou contate [opencode@microsoft.com](mailto:opencode@microsoft.com) se tiver outras dúvidas ou comentários.

## <a name="questions-and-comments"></a>Perguntas e comentários

Gostaríamos de saber sua opinião sobre o exemplo de conexão. Você pode nos enviar suas perguntas e sugestões por meio da seção [Issues](issues) deste repositório.

As perguntas sobre o desenvolvimento do Microsoft Graph em geral devem ser postadas no [Stack Overflow](http://stackoverflow.com/questions/tagged/MicrosoftGraph+API). Não deixe de marcar as perguntas ou comentários com [MicrosoftGraph] e [API].

## <a name="next-steps"></a>Próximas etapas

Este exemplo mostra apenas os conceitos básicos necessários para que os aplicativos funcionem com o Microsoft Graph. O aplicativo pode fazer muito mais usando as APIs do Office 365, como ajudar os usuários a gerenciar os dias úteis com o calendário, localizar apenas as informações necessárias em todos os arquivos armazenados no OneDrive ou localizar uma pessoa específica na lista de contatos. Temos mais recursos para compartilhar com você no [Exemplo de trechos de código para Android](../../../android-java-snippets-sample). 
  
## <a name="additional-resources"></a>Recursos adicionais

* [Começar a usar as APIs do Office 365 da plataforma Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Visão geral do Microsoft Graph](http://graph.microsoft.io)
* [SDK do Microsoft Graph para Android](../../../msgraph-sdk-android)
* [Exemplo de trechos de código para Android](../../../android-java-snippets-sample)

## <a name="copyright"></a>Direitos autorais
Copyright © 2016 Microsoft. Todos os direitos reservados.
