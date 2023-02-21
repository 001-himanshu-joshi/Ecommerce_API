# E-commerce-API
## Framework And language used
- SpringBoot
- Java

## Data Flow 
 ### Controller
 1) UserController
 2) AddressController
 3) OrderController
 4) ProductController

 ### Service
 1) UserService
 2) AddressService
 3) OrderService
 4) ProductService

 ### Repository 
 - JpaRepository

 ### Database Design 
 - Here we are using the H2 DataBase and it is in a Tabular Form

 ## Data Structure used
 - NA

 ## Project Summary
 In this Project we are performing the CRUD operations by hitting an API and here we have the links :

 1) User
  - PostMapping -> localhost:8080/api/v1/addUser
  - GetMapping (by Id) -> http://localhost:8080/api/v1getUser/{userId}

  2) Product
 - PostMapping -> localhost:8080/api/v1/addProduct
 - GetMapping - > localhost:8080/api/v1/getProduct
 - GetMapping (by category) -> localhost:8080/api/v1/getProduct?category=Niche

  3) Order
 - PostMapping -> localhost:8080/api/v1/placeOrder
 - GetMapping (by Id) ->http://localhost:8080/Order/getOrder/oId/2

  4) Address
 - PostMapping -> localhost:8080/api/v1/addAddress
