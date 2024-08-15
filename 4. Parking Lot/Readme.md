# Parking Lot
Object-oriented design for a multi-entrance and exit parking lot system.

## Problem definition
In a parking lot, there are a fixed number of parking spots available for different types of vehicles. Each of these spots is charged according to the time the vehicle has been parked in the parking lot. The parking time is tracked with a parking ticket issued to the vehicle at the entrance of the parking lot. Once the vehicle is ready to exit, it can either pay at the automated exit panel or to the parking agent at the exit using a card or cash payment method.

## Expectations

### Payment flexibility
- How are customers able to pay at different exit points (i.e., either at the automated exit panel or to the parking agent) and by different methods (cash, credit, coupon)?
- If there are multiple floors in the parking lot, how will the system keep track of the customer having already paid on a particular floor rather than at the exit?

### Parking spot type
- How will the parking capacity of each lot be considered?
- What happens when a lot becomes full?
- How can one keep track of the free parking spots on each floor if there are multiple floors in the parking lot?
- How will the division of the parking spots be carried out among the four different parking spot types in the lot?

### Vehicle types
- How will capacity be allocated for different vehicle types?
- If the parking spot of any vehicle type is booked, can a vehicle of another type park in the designated parking spot?

### Pricing
- How will pricing be handled? Should we accommodate having different rates for each hour? For example, customers will have to pay $4 for the first hour, $3.5 for the second and third hours, and $2.5 for all the subsequent hours.
- Will the pricing be the same for the different vehicle types?

## Design approach
- Bottom Up 

## Requirements collection
- R1: The parking lot should have the capacity to park 40,000 vehicles.
- R2: The four different types of parking spots are handicapped, compact, large, and motorcycle.
- R3: The parking lot should have multiple entrance and exit points.
- R4: Four types of vehicles should be allowed to park in the parking lot, which are as follows:
    - Car
    - Truck
    - Van
    - Motorcycle

- R5: The parking lot should have a display board that shows free parking spots for each parking spot type.
- R6: The system should not allow more vehicles in the parking lot if the maximum capacity (40,000) is reached.
- R7: If the parking lot is completely occupied, the system should show a message on the entrance and on the parking lot display board.
- R8: Customers should be able to collect a parking ticket from the entrance and pay at the exit.
- R9: The customer can pay for the ticket either with an automated exit panel or pay the parking agent at the exit.
- R10: The payment should be calculated at an hourly rate.
- R11: Payment can be made using either a credit/debit card or cash.

## Use Case Diagram for the Parking Lot

### Actors

- Primary actors 
    - Customer: This actor can park the vehicle in the allocated parking space according to the vehicle type and pay for the parking before exit.
    - Parking agent: The parking agent will assist the customer and perform all the tasks that a customer can do, such as paying the parking ticket on behalf of the customer.
- Secondary actors
    - Admin: This can add, remove, or update a spot, agent, entry/exit panels, and view/update accounts.
    - System: This is responsible for giving details of parking spot availability and assigning a parking spot to a vehicle.

### Use Cases

- Admin
    - Add spot: To add a parking spot
    - Add agent: To add a new agent
    - Add/modify rate: To add/modify hourly rate
    - Add entry/exit panel: To add and update exit/entry panel at each entry/exit
    - Update account: To update account details and payment information
    - Login/Logout: To login/logout to/from agent or admin account
    - View account: To view account details like payment status or unpaid amount
- Customer
    - Take ticket: To take a ticket at the entrance, that contains information regarding the vehicle and its entrance time
    - Scan ticket: To scan the ticket at the exit and get the parking fee
    - Pay ticket: To pay the parking fee at the exit panel via cash or a credit card
    - Cash: To pay the parking fee via cash
    - Credit card: To pay the parking fee via credit card
    - Park vehicle: To park the vehicle at the assigned destination
- Parking agent
    - Update account: To update account details and payment information
    - Login/Logout: To log in/log out to/from the agent or admin account
    - View account: To view account details like payment status or unpaid amount
    - Take ticket: To take a ticket at the entrance, that contains information regarding the vehicle and its entrance time
    - Scan ticket: To scan the ticket at the exit and get the parking fee
    - Pay ticket: To pay the parking fee at the exit panel via cash or a credit card
    - Cash: To pay the parking fee via cash
    - Credit card: To pay the parking fee via credit card
    - Park vehicle: To park the vehicle at the assigned destination
- System
    - Assigning parking spots to vehicles: To check the vehicle type and associate a free spot according to it
    - Remove spot: To remove a parking spot if it is not available for parking
    - Show full: To display the status of the parking lot as full
    - Show available: To show the details of available parking spots



## Class Diagram for the Parking Lot
<img src="../Assets/images/parking-lot-class-diagram.png">
