# Multi-module Kotlin Project with Gradle
This application demonstrates how to structure a multi-module kotlin project with gradle.

This is also a proof-of-concept to demonstrate an application's capability to load 
extensions (or plugins) at runtime.

## Module Dependency

![Module Dependency](docs/mm-kt-gdl.png?raw=true "Module Dependency")

## Directory Structure

[buildSrc/build.gradle.kts](buildSrc/build.gradle.kts) - Enables the precompiled script plugins.
See [Precompiled Plugins](https://docs.gradle.org/current/userguide/custom_plugins.html#sec:precompiled_plugins)

[buildSrc/src/main/kotlin/rt.gradle.kts](buildSrc/src/main/kotlin/rt.gradle.kts) - Contains the common project dependencies e.g. repositories
dependencies. ```rt``` is the id of the ```precompiled script plugin```

The ```rt``` plugin is consumed by other modules as:
```kotlin
plugins { 
    ...
    id("rt")
}
```

[shared](shared) - Contains the classes that are common to both [lib](lib) and [app](app)

[lib](lib) - The standalone jar that will be loaded by [app](app) at runtime.

[app](app) - The application's main interface.

## Declaring the multi-module gradle project
[settings.gradle.kts](settings.gradle.kts)
```kotlin
rootProject.name = "multi-module-kt-gradle"
include("app", "lib", "shared")
```