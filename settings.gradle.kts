pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "RickAndMortyApp"
include(":app")
include(":designsystem")
include(":modulegenerator")
include(":features:home:public")
include(":features:home:impl")
include(":features:characterdetails:impl")
include(":features:characterdetails:public")
include(":features:common:impl")
include(":features:common:public")
