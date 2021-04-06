# Glorious Warehouse
## Introduction
A simple warehouse management system developed using Java, SpringBoot, JPA, and Postgres SQL. 
## Project
### User Stories
- A user can add, remove, edit, and list categories in the system.
- A user can add, remove, edit, and list supplier records in the system.
- A user can add, remove, edit, and list items in the system, and link each item to one category and/or supplier.
   - A user can add to the quantity of an item in the system.
- A user can add and list orders in the system in such a way items are taken from the warehouse when a new order is placed.
   - An order can have one or more items.
   - The quantity of each ordered item must be less than the current quantity of the item.
   - The quantity of each ordered item must be greater than 0.
   - Each item in the order must exist in the database prior to ordering.
### Entities
This warehouse management system has the following entities:
- Item
- Category
- Supplier
- Order (application_order)
- Order Detail

Each item can optionally have one category and one supplier, and each category and/or supplier can have many items.
## Database
The DB Schema can be found below:

![DBSchema](https://raw.githubusercontent.com/glorious73/gloriouswarehousespring/master/resources/GloriousWarehouseDBSchema.png "Database Schema")
## How to run
To run the application locally, please follow the steps below:

1- Clone or download the repository.

2- Downlad, install, and configure PostgreSQL in your local machine.

3- Create the user `postgres` with the password `123456`.

4- Create the database `gloriouswarehousedb` in postgres.

5- Open the project in an IDE of your choice (I used Intellij IDEA CE 2020.3).

6- Open `pom.xml` and download the dependency sources from maven which are needed to run the application.

7- Hit the "Run" button to start the application.

8- Done. You can use it now.
## Usage
### Explanation
You can use the application with Swagger UI by navigating to `http://localhost:8080/swagger-ui.html#/` and executing the function of your choice.
### Example
Let us add an item using the POST request under the item controller.

![Item Controller POST.png](https://raw.githubusercontent.com/glorious73/gloriouswarehousespring/master/resources/item%20controller%20example.png "Item POST Request using Swagger")

As you can see in the snapshot above, you simply need to specify the values to be added in JSON and you can skip the fields `id` as it is auto-generated, and non-mandatory fields of both `supplier` and `category` as the field `id` is only needed to link the item to them.

## Improvement
This system has room for improvement, and the following features can be added to improve it:
1. Add accounts for customers and accounts for admin users.
   - Add authentication and authroization for those accounts. A simple yet secure way to do this would be by using [Json Web Tokens](https://jwt.io/).
2. Create a frontend for the application. Dashboard and authentication pages would make sense for such an application.
3. Add option for payment for each order, which includes currency and payment type.
4. Add filtering based on field matching and field containing text, and add search functionality for all entities in the system.