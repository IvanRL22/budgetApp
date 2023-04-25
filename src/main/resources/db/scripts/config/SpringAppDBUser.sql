CREATE USER 'SpringBootDBUser'@'localhost' IDENTIFIED BY 'SpringBootPassword';
-- This assumes the name of the DB is BudgetApp
GRANT ALL PRIVILEGES ON BudgetApp.* TO 'SpringBootDBUser'@'localhost';