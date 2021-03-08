# OctoPrice App

This is a a simple app to display products and prices from the Octopus Energy API

- View a list of products
- View if products use green energy or not
- View details of the product including prices (if available)

Built using:

- Koin (Dependency Injection)
- MVVM / View Models
- Data binding
- Live Data 
- Coroutines
- Retrofit2 (API HTTP calls)
- Moshi (JSON serialisation)
- Navigation (Architecture Component)

Unit testing using:

- JUnit
- Mockk
- Live-data testing helpers

And a few UI tests using Espresso (note these are using live data and need MockWebServer or WireMock setup)

Possible future improvements / ToDos

- Improve UI styling 
- Add additional list showing industry grid supply points
- In memory mock http server for UI Tests 
- Add error handling
- Add caching layer to repository



