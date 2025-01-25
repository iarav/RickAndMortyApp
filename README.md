# RickAndMortyApp

Bem-vindo ao **RickAndMortyApp**, um projeto Android pessoal criado para explorar e aprender os conceitos de **Clean Architecture**, **MVVM**, **Kotlin Coroutines** e **Jetpack Compose**.

## 🎯 Objetivo do Projeto

Este projeto tem como propósito principal o aprendizado e a aplicação prática de boas práticas de arquitetura e desenvolvimento moderno para Android, com foco em:
- **Clean Architecture**: Estrutura modular e separação de responsabilidades.
- **MVVM (Model-View-ViewModel)**: Gerenciamento de estados e UI reativa.
- **Kotlin Coroutines**: Para lidar com tarefas assíncronas de forma eficiente.
- **Jetpack Compose**: Desenvolvimento de interfaces modernas e declarativas.

## 🛠️ Tecnologias e Ferramentas

- **Linguagem**: Kotlin
- **Arquitetura**: Clean Architecture + MVVM
- **UI**: Jetpack Compose
- **Async**: Kotlin Coroutines + Flow
- **Dependência**: Koin (injeção de dependência)
- **API**: Integração com a [Rick and Morty API](https://rickandmortyapi.com/)
- **Gerenciamento de dependências**: Gradle

## 🚀 Funcionalidades

- Listagem de personagens da série *Rick and Morty*.
- Tela de detalhes de cada personagem, exibindo informações detalhadas como nome, status, espécie e localização.

## 📂 Estrutura do Projeto

O projeto segue o padrão de **Clean Architecture** com três camadas principais:

1. **Domain**: Contém as regras de negócio, casos de uso e entidades.
2. **Data**: Gerencia os repositórios, fontes de dados (API, banco de dados) e mapeamento entre modelos de dados e de domínio.
3. **Presentation**: Implementa a lógica de exibição e interação da interface usando MVVM e Compose.

## 🖥️ Como Rodar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/iarav/RickAndMortyApp
   ```

2. Abra o projeto no Android Studio.

3. Sincronize as dependências:
    - Certifique-se de estar usando a versão mais recente do **Android Studio Flamingo** ou superior.
    - Compile e sincronize o projeto para baixar as dependências necessárias.

4. Configure a API:
    - Verifique se a [Rick and Morty API](https://rickandmortyapi.com/) está acessível.
    - O projeto já está configurado para consumir os endpoints sem necessidade de autenticação.

5. Rode o aplicativo no emulador ou dispositivo físico.