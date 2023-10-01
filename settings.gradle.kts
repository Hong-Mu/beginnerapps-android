pluginManagement {
    repositories {
        google()
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

rootProject.name = "beginnerapps"
include(":bts")
include(":twice")
include(":trot")
include(":dice")
include(":quote")
include(":diet")
include(":mangoplate")
