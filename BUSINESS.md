This document should explain the logic behind the entities and the business  
The idea is to keep expanding it as new logic is added or changes are made to the existing logic

# App goal
The idea if this app is to create a simple budgeting app  
It should be able to create and manage a budget, including:
- Define categories of spending
- Manage monthly budgeting for some or all categories
- Store expenses
- Recalculate current monthly budget according to new expenses
- Recalculate current monthly budget according to changes in the budget itself
  - (For now, modification of past monthly budgets should not be allowed)
- As this is a personal project, for now there it is not expected to manage several users

# Entities
## [Category](src/main/java/com/budgetApp/crud/category/AbstractCategory.java)
Represents a grouping of expenses  
They are user-defined  
They are subdivided in main categories and subcategories  
A category has 0..n subcategories, and its balance and budget are the aggregation of its subcategories balances and budgets

## [Month](src/main/java/com/budgetApp/crud/month/Month.java)
Represents the time frame of a budget  
Used for easily accessing data without having to process dates

## [MonthlyBudget](src/main/java/com/budgetApp/crud/monthlyBudget/MonthlyBudget.java)
Represents the budget of a particular month  
Represented by a list of [categories](#category)  
For each category, defines a particular amount of money budgeted and the balance for that month   

## [Spending](src/main/java/com/budgetApp/crud/spending/Spending.java)
Represents an instance of a payment, or an amount of money spent on something
Essentially, it is an amount of money removed from our pockets  

## [Income](src/main/java/com/budgetApp/crud/income/Income.java)
Represents an influx of money  