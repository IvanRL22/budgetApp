# App Business
This document should explain the logic behind the entities and the business.

The idea is to keep expanding it as new logic is added or changes are made to the existing logic.

## App goal
The idea if this app is to create something similar to [YNAB](https://www.ynab.com/).
It should be able to create and manage a budget, including:
- Define categories of spending
- Manage monthly budgeting for some or all categories
- Store expenses
- Recalculate budget according to new (or past) expenses
- Recalculate budget according to changes in the current budget
  - (For now, modification of past monthly budgets should not be allowed)
- As this is a personal project, for now there it is not expected to manage several users

## Entities
### Budget
The overarching entity. Defines a particular budget.

### [Category](src/main/java/com/budgetApp/crud/category/AbstractCategory.java)
Represents a grouping of expenses.
They are user-defined.
They are subdivided in main categories and subcategories.
A category has 0..n subcategories, and its balance and budget are the aggregation of its subcategories balances and budgets.

### MonthlyBudget
Represents the budget of a particular month.
Represented by a list of [categories](#category)
For each category, defines a particular amount of money budgeted and the balance for that month. 

### Expense
Represents and expense (duh).
Each expense creation should modify:
- Its category's monthly budget and balance (main and subcategory)
