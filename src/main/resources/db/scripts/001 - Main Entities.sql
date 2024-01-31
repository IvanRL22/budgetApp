CREATE TABLE CATEGORIES (
	ID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(30) NOT NULL,
	PARENT_CATEGORY INT,
	TYPE VARCHAR(1) NOT NULL,
	CONSTRAINT PK_CATEGORIES PRIMARY KEY (ID),
	CONSTRAINT UC_CATEGORIES_NAME UNIQUE(NAME),
	CONSTRAINT FK_CATEGORIES_PARENT_CATEGORY FOREIGN KEY (PARENT_CATEGORY) REFERENCES CATEGORIES(ID)
);

CREATE TABLE MONTHLYBUDGET (
	ID INT NOT NULL AUTO_INCREMENT,
	MONTH INT NOT NULL,
	YEAR INT NOT NULL,
	CATEGORY_ID INT NOT NULL,
	INITIAL_BALANCE DECIMAL(8,2) NOT NULL DEFAULT 0,
	AMOUNT DECIMAL(8,2) UNSIGNED NOT NULL DEFAULT 0,
	CONSTRAINT PK_MONTHLYBUDGET PRIMARY KEY(ID),
	CONSTRAINT FK_CATEGORY FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORIES(ID)
);

CREATE TABLE SPENDINGS (
	ID INT NOT NULL AUTO_INCREMENT,
	MONTHLYBUDGET_ID INT NOT NULL,
	AMOUNT DECIMAL(8,2) UNSIGNED NOT NULL,
	PAYEE VARCHAR(50) NOT NULL,
	SPENDING_DATE DATE NOT NULL,
	CONSTRAINT SPENDING_PK PRIMARY KEY(ID),
	CONSTRAINT FK_SPENDING_MONTHLYBUDGET FOREIGN KEY (MONTHLYBUDGET_ID) REFERENCES MONTHLYBUDGET(ID)
);
