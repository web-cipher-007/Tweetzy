# Tweetzy: An Android Tweet Viewer 

[![Platform: Android](https://img.shields.io/badge/Platform-Android-green.svg)]()
[![Language: Kotlin](https://img.shields.io/badge/Language-Kotlin-blue.svg)]()
[![UI: Compose](https://img.shields.io/badge/UI-Jetpack_Compose-brightgreen.svg)]()

Tweetzy is a modern Android application meticulously engineered with Jetpack Compose for a declarative UI, utilizing MVVM architecture, Dagger-Hilt for Dependency Injection, and Kotlin Coroutines/Flows for a reactive data pipeline, all driven by a Retrofit service that performs server-side data filtering via a custom X-JSON-Path header.

## ✨ Key Features & Technology Stack

This project was built to showcase a complete implementation of the latest Android development practices, emphasizing clean architecture and reactive programming.

### 💻 Tech Stack

| Category | Technology | Purpose |
| :--- | :--- | :--- |
| **UI** | **Jetpack Compose** | Declarative, state-driven UI construction. |
| **Architecture** | **MVVM** | Clean separation of concerns (Model, View, ViewModel). |
| **Dependency Injection** | **Dagger-Hilt** | Robust, scalable injection of services and ViewModels. |
| **Networking** | **Retrofit & OkHttp** | REST API client for fetching tweet data. |
| **State Management** | **Kotlin Flows / StateFlow** | Managing reactive, thread-safe data flow from Repository to UI. |
| **Concurrency** | **Kotlin Coroutines** | Structured concurrency for non-blocking network operations. |
| **Navigation** | **Compose Navigation** | Type-safe handling of screen routing and passing arguments (e.g., category ID). |

###  Data & API

The application uses **Retrofit** to fetch data from an external JSON service: **JSONBin** ([https://jsonbin.io/](https://jsonbin.io/)).

It demonstrates advanced API interaction by utilizing the special **`X-JSON-Path` header** for server-side data filtering. This ensures that only the data required for the selected category is retrieved, optimizing data transfer.

---

##  Key Points

Developing the **Tweetzy** application provided practical experience and key insights into several complex areas of modern Android development:

* **Reactive Data Synchronization:** Mastering the use of **`MutableStateFlow`** within the `Repository` and correctly observing it with **`collectAsState()`** in the Composable UI. This was critical in resolving the initial blank screen issue.
* **Hilt and Coroutine Scopes:** Understanding how Hilt injects dependencies into ViewModels and managing the lifecycles of network calls using the **`viewModelScope`** to prevent memory leaks.
* **Compose Navigation with Arguments:** Correctly defining the navigation graph (`NavHost`), passing parameters between screens (e.g., passing the selected `category` string), and retrieving them safely within the target ViewModel via `SavedStateHandle`.
* **Advanced API Filtering:** Implementing and debugging the use of custom HTTP headers (`X-JSON-Path`) with Retrofit to perform complex data filtering directly on the backend, optimizing the data payload sent to the client.

This project represents a solid foundation in building maintainable, high-performance Android applications using the latest Jetpack libraries.
