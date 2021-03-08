# OctoPrice Android App

This is a a simple Android app to display products and prices from the Octopus Energy API

**It uses the following public endpoints**

- https://api.octopus.energy/v1/products
- https://api.octopus.energy/v1/products/{code}
- https://api.octopus.energy/v1/industry/grid-supply-points

**The following functionality is provided**

- View a list of energy products
- View details of the product including prices (if available and limited to grid supply point group A / electricity)
- View if a product is green
- Check a Grid Supply Point group based on a post code

**Built using:**

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

**Possible future improvements / ToDos**

- Improve UI styling 
- Allow filtering by green energy / business only etc.
- Add further tariff mapping for gas etc.
- Add further tariff mapping for different grid supply point groups
- In memory mock http server for UI Tests 
- Add further error handling
- Add caching layer to repository
- Add settings 
- Use partner endpoints on Octopus Energy API given API key (e.g. show consumption for a meter)

**Screenshots**

![product_list](https://user-images.githubusercontent.com/2723637/110288061-5a0a6f80-7fdf-11eb-91c1-288b611aab65.png)

![product_detail](https://user-images.githubusercontent.com/2723637/110323445-87b9dd80-800c-11eb-8587-bf4169378fd3.png)

![industry](https://user-images.githubusercontent.com/2723637/110288107-6abae580-7fdf-11eb-8609-329533e54faa.png)




**When loading product details page**


![product_detail_loading](https://user-images.githubusercontent.com/2723637/110323422-812b6600-800c-11eb-860d-7e076787a2c1.png)




