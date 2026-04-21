##Project Overview

The Food Delivery System is a Java console-based application that simulates a real-world food ordering platform.
It allows users to create an account, log in, browse a food menu, place orders, and view delivery status and transaction history.

This project demonstrates Object-Oriented Programming (OOP) concepts like classes, objects, encapsulation, and real-time system flow.

##Features:
👤 Customer Module
Create new account
Login authentication (ID & password validation)
🍽️ Food Menu Module
Displays list of food items
Categorized as Veg, Non-Veg, Beverage, Dessert
Availability check for each item
🛒 Order Module
Add multiple food items to cart
Calculate total bill automatically
Prevent ordering unavailable items
💰 Billing & Policy Module
Displays total order amount
If total > 5000 → requires approval (Manager / Chef)
Otherwise order is auto-approved
🚚 Delivery Module
Displays delivery status (Dispatched)
📜 History Module
Tracks all ordered items during session
Sample Output:
--- MAIN MENU ---
1. Create Account
2. Login
3. Exit

Login Successful!

--- MENU ---
1. Paneer (Veg) - 200
2. Chicken (Non-Veg) - 300
3. Juice (Beverage) - 100
4. IceCream (Dessert) - Not Available
5. Finish Order

Total Amount: 500
Order Approved!
Delivery Status: Dispatched
