CREATE USER 'budgetBE'@'localhost' IDENTIFIED BY 'budgetBEPsw';
GRANT ALL PRIVILEGES ON budgetDB.* TO 'budgetBE'@'localhost';