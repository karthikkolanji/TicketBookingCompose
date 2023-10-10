# TicketBooking App
An simple app to deposit and with money.



<div align="center">
  <sub>Built with ❤︎ by
  <a href="https://twitter.com/kolanji_karthik">Karthik Kolanji</a>
</div>
<br/>



<br/>

## Features
* Load seating arrangement from server 
* Select minimum of 2 tickets

## Architecture
* Built with 100% compose (Screen + Navigation)
* Built with Modern Android Development practices (MVVM + Clean Architecture)
* Utilized UI (Fragment+ViewModel), Domain(Usecase) , Repository(Local datasource + Remote Data Source)
* Includes unit tests for Mapper [StatusDataToDomainMapperTest as sample to demonstrate testing is achieved because proper Architecture


## 📱 Download Demo on Android
Download the [APK file from here](https://test_link?raw=true) on your Android phone and enjoy the Demo App :)



https://github.com/karthikkolanji/TicketBookingCompose/assets/8638991/93a413de-b654-4eec-b611-43a6d4fb9ed3



## Built With 🛠
- [Version Catalogs](https://developer.android.com/build/migrate-to-catalogs) -  helps to main version across all modules feature modules in single place
- [MVVM Architecture](https://developer.android.com/topic/architecture) - Official architecture for Android development.
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
- [Dependency Injection](https://developer.android.com/training/dependency-injection)
  - [Hilt](https://dagger.dev/hilt) - Easier way to incorporate Dagger DI into Android apps.
- [Jetpack Compose](https://developer.android.com/jetpack/compose/documentation) - Jetpack Compose is the modern toolkit for building native Android UI. Here's where you'll find the latest information about using Compose.
- [Navigating with Compose](https://developer.android.com/jetpack/compose/navigation) - Navigation between screens in app.
- [MockK](https://mockk.io) - For Mocking and Unit Testing


## Assumptions made while developing code
- Setting arrangements is fetched from server
- Any new feature developed mush a new feature module. This helps isn separation of concern, increase build time and dynamic feature delivery


## Explanation of module structure
- DI (ContextModule, DispatcherProvider, GlideModule, GsonModule, OkHttpClientModule, RetrofitModule)
- Extensions
- Utils



## Further improvements planned 
- [Interface] - Add Interface for all the layers, so that communication between layers happens via Interface and not concrete class.
- [Test case] - Add test case for ViewModel & Usecase


## Explanation of code base
-  [bookseat module] - This take of feature relates to booking seat
    - This has multiple packages
      - ui
        - compose
        - mapper
        - model
        - state
        - theme
        - BookSeatFragment class
        - BookSeatViewModel class
      - domain
        - mapper
        - model
        - GetSeatAvailabilityUseCase class
      - data
        - datasource
          - remote
            - model
            - ApiService class
        - di
          - DataModule class
        - repository
          - mapper
          - model
          - SeatAvailabilityRepository class

-  [Core module] - This take of below which will be used by all the feature modules
  - This has multiple packages
    - di
      - ContextModule 
      - DispatcherProvider
      - GsonModule
      - OkHttpClientModule
      - RetrofitModule
      
    - extensions
      - ContextExtensions
      - FragmentExtensions
      - ViewBindingDelegate
      - ViewExtensions

    - mapper
      - DataToDomainMapper
      - DomainToUiMapper
      - ApiToDataMapper

     - utils
       - ApiError
       - NetworkError
       - NetworkErrorException
       - UiState


## 👨 Developed By

<a href="https://twitter.com/kolanji_karthik" target="_blank">
  <img src="https://avatars.githubusercontent.com/u/8638991?v=4" width="70" align="left">
</a>

**Karthik Kolanji**

[![Twitter](https://img.shields.io/badge/-twitter-grey?logo=twitter)](https://twitter.com/kolanji_karthik)
[![Medium](https://img.shields.io/badge/-medium-grey?logo=medium)](https://medium.com/@karthik_78204)
[![Linkedin](https://img.shields.io/badge/-linkedin-grey?logo=linkedin)](https://www.linkedin.com/in/karthik-kolanji-179122139/)
