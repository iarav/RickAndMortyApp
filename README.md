# RickAndMortyApp

![RickAndMortyApp Logo](https://github.com/iarav/RickAndMortyApp/blob/main/designsystem/src/main/res/drawable/rick_and_morty.png)

Bem-vindo ao **RickAndMortyApp**, um projeto Android modular criado para explorar e aplicar os conceitos de **Clean Architecture**, **MVVM**, **Kotlin Coroutines** e **Jetpack Compose**.

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
- **Injeção de dependência**: Koin
- **API**: Integração com a [Rick and Morty API](https://rickandmortyapi.com/)
- **Gerenciamento de dependências**: Gradle
- **Testes**: JUnit, MockK

## 🚀 Funcionalidades

- Listagem de personagens da série *Rick and Morty*.
- Tela de detalhes de cada personagem, exibindo informações detalhadas como nome, status, espécie e localização.
- Tratamento de loading e erros.
- Arquitetura modularizada para fácil manutenção e escalabilidade.

## 📂 Estrutura do Projeto

O projeto segue o padrão de **Clean Architecture** com três camadas principais:

```
features/
  home/           # Feature de listagem de personagens
  characterdetails/ # Feature de detalhes do personagem
  common/         # Modelos, mappers e componentes compartilhados
app/              # App principal (entrypoint)
designsystem/     # Componentes visuais reutilizáveis
modulegenerator/  # Utilitários de geração de módulos
```

- **Domain**: Regras de negócio, casos de uso e entidades.
- **Data**: Repositórios, fontes de dados (API, banco de dados) e mapeamento entre modelos.
- **Presentation**: Lógica de exibição e interação da interface usando MVVM e Compose.

## ⚙️ Pré-requisitos

- **Android Studio Flamingo** ou superior
- **JDK 17**
- Emulador Android ou dispositivo físico
- Acesso à internet para consumir a API

## 🖥️ Como Rodar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/iarav/RickAndMortyApp
   ```
2. Abra o projeto no Android Studio.
3. Sincronize as dependências (Gradle Sync).
4. Rode o aplicativo em um emulador ou dispositivo físico.

## 🧪 Testes

- Para rodar os testes unitários:
  ```bash
  ./gradlew test
  ```
- Os testes estão localizados em `features/*/impl/src/test` e cobrem casos de uso, viewmodels e mapeamentos.

## 📚 Referências

- [Documentação Oficial do Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Koin DI](https://insert-koin.io/)
- [Rick and Morty API](https://rickandmortyapi.com/)

---