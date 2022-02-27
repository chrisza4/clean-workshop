## Excersise 1

Assuming you are database team: Implement repository

For the sake of tutorial, we will use in-mem database (simple ArrayList)

Generate uuid for new purchase request

What about testing?

Use Cross test the functionality (getById cross with Add)

## Excersise 2

Assuming you are in domain team: Implement domain object and repository with testing

- PurchaseRequest class
- PurchaseRequest class with create method
- Domain requirement:
  - > 100,000 THB must be approved by Senior Management
  - < 100,000 THB can be approved by both Senior and mid-level management
- Employee → Add Level method
  - Steve is mid-level management “steve@microapplesoft.com”
  - Mark is senior management “mark@microapplesoft.com”
  - Others are just employee
- Implement purchaseRequest use-case
  - Create a purchase request domain object, using previous methods
  - If success, save to repository

## Excersise 3

Implement controller, which consume previous use-case
