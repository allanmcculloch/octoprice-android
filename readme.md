# OctoPrice Android App

This is a a simple Android app to display products and prices from the Octopus Energy API

It uses the following public endpoints

- https://api.octopus.energy/v1/products
- https://api.octopus.energy/v1/products/{code}
- https://api.octopus.energy/v1/industry/grid-supply-points

The following functionality is provided

- View a list of products
- View if a product uses green energy
- View details of the product including prices (if available and limited to grid supply point group A / electricity)
- Check a Grid Supply Point group based on a post code

Built using:

- Koin (Dependency Injection)
- MVVM / View Models
- Data binding
- Live Data 
- Coroutines
- Retrofit2 (API HTTP calls)
- Moshi (JSON serialisation)
- Navigation (Architecture Component)
- Swipe Refresh layout and progress indicators 
- Unit testing with JUnit, Mockk, Live-data helpers
- Android (UI) tests using Espresso (TODO: Setup MockWebServer or WireMock as currently using prod data)

Possible future improvements / ToDos

- Improve UI styling 
- Allow filtering by green energy / business only etc.
- Add further tariff mapping for gas etc.
- Add further tariff mapping for different grid supply point groups
- In memory mock http server for UI Tests 
- Add further error handling
- Add caching layer to repository
- Add settings 
