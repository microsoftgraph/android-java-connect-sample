# Exemplo de conexão para Android usando o SDK do Microsoft Graph

![Status da Compilação](https://ricalo.visualstudio.com/_apis/public/build/definitions/06256fa7-d8e5-4ca0-8639-7c00eb6f1fe9/6/badge "Status da Compilação")

[![Exemplo de conexão com o Office 365](../readme-images/O365-Android-Connect-video_play_icon.png)](https://www.youtube.com/watch?v=3IQIDFrqhY4 "Clique no exemplo para vê-lo em ação")

Conectar-se ao Office 365 é a primeira etapa para que os aplicativos Android comecem a funcionar com dados e serviços do Office 365. Este exemplo mostra como conectar e chamar uma única API através do SDK do Microsoft Graph.

## Requisitos do dispositivo

Para executar o exemplo de conexão, o dispositivo deve atender aos seguintes requisitos:

* Uma tela de tamanho 800 x 480 ou maior.
* API Android nível 16 ou superior.
 
## Pré-requisitos

Para usar o exemplo de conexão para Android, é necessário o seguinte:

* [Android Studio](http://developer.android.com/sdk/index.html) versão 1.0 ou posterior.
* [JDK (Java Development Kit) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* Um aplicativo registrado no Microsoft Azure. Você pode usar a [Ferramenta de registro do aplicativo Office 365](http://dev.office.com/app-registration). Ela simplifica o registro do aplicativo. Use os seguintes parâmetros:

|     Parâmetro   |              Valor             |
|----------------:|:-------------------------------|
|        Tipo de aplicativo | Aplicativo Nativo                     |
|    URI de redirecionamento | http://localhost:8000          |
| Permissões de aplicativos | Mail.Send                      |
  
  Copie e armazene os valores da **ID do Cliente** e do **Segredo do Cliente**.
  
## Abra o exemplo usando o Android Studio

1. Instale o [Android Studio](http://developer.android.com/sdk/index.html) e adicione os pacotes do SDK do Android de acordo com as [instruções](http://developer.android.com/sdk/installing/adding-packages.html) na página developer.android.com.
2. Baixe ou clone esse exemplo.
3. Inicie o Android Studio.
    1. Feche todos os projetos abertos e escolha **Abrir um projeto existente do Android Studio**.
    2. Navegue até o repositório local e escolha o projeto Android-Connect. Clique em **OK**.
    
    > Observação: O Android Studio mostra uma notificação de **Estruturas detectadas** se você não tiver o **Repositório de Suporte do Android** instalado. Abra o gerenciador de SDK e adicione o Repositório de Suporte do Android para evitar a notificação de estruturas detectadas.
4. Abra o arquivo Constants.java.
    1. Localize a constante CLIENT_ID e defina o respectivo valor da cadeia de caracteres igual a ID do cliente registrada no Azure Active Directory.
    2. Localize a constante REDIRECT_URI e defina o respectivo valor da cadeia de caracteres igual à URI de redirecionamento registrada no Active Directory do Azure.
    ![Exemplo de conexão com o Office 365](../readme-images/Android-Connect-Constants.png "Valores de ID do Cliente e URI de Redirecionamento no arquivo Constantes")

Depois de criar o exemplo de conexão, você pode executá-lo em um emulador ou dispositivo. Escolha um dispositivo com API de nível 16 ou superior na caixa de diálogo **Escolher dispositivo**.

Para saber mais sobre o exemplo, confira o artigo [Chamar o Microsoft Graph em um aplicativo Android](https://graph.microsoft.io/en-us/docs/platform/android).

<a name="contributing"></a>
## Colaboração ##

Se quiser contribuir para esse exemplo, confira [CONTRIBUTING.MD](/CONTRIBUTING.md).

Este projeto adotou o [Código de Conduta do Código Aberto da Microsoft](https://opensource.microsoft.com/codeofconduct/). Para saber mais, confira as [Perguntas frequentes do Código de Conduta](https://opensource.microsoft.com/codeofconduct/faq/) ou contate [opencode@microsoft.com](mailto:opencode@microsoft.com) se tiver outras dúvidas ou comentários.

## Perguntas e comentários

Gostaríamos de saber sua opinião sobre o exemplo de conexão. Você pode nos enviar suas perguntas e sugestões por meio da seção [Issues](issues) deste repositório.

As perguntas sobre o desenvolvimento do Office 365 em geral devem ser postadas no [Stack Overflow](http://stackoverflow.com/questions/tagged/Office365+API). Não deixe de marcar as perguntas ou comentários com [Office365] e [API].

## Próximas etapas

Este exemplo mostra apenas os conceitos básicos necessários para que os aplicativos funcionem com o Office 365. O aplicativo pode fazer muito mais usando as APIs do Office 365, como ajudar os usuários a gerenciar os dias úteis com o calendário, localizar apenas as informações necessárias em todos os arquivos armazenados no OneDrive ou localizar uma pessoa específica na lista de contatos. Temos mais para compartilhar com você no [Exemplo de trechos de código para Android](/OfficeDev/O365-Android-Microsoft-Graph-Snippets). 
  
## Recursos adicionais

* [Introdução a APIs do Office 365 fornecidas pelo Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Visão geral do Microsoft Graph](http://graph.microsoft.io)
* [SDK do Microsoft Graph para Android](../../../msgraph-sdk-android)
* [Trechos de código do Microsoft Graph do Office 365 para Android](../../../../OfficeDev/O365-Android-Microsoft-Graph-Snippets)

## Direitos autorais
Copyright © 2016 Microsoft. Todos os direitos reservados.