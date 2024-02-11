# How to manage DB with [Liquibase](https://www.liquibase.com/open-source)

## Configuration file
Can be found [here](config/liquibase-changelog.xml)  
Specifies the path where the db scripts are

## Scripts
Can be found [here](scripts)  
All scripts should start with a 3-digit sequence that determines order of execution  
Scripts must include one or more changesets, identified with the following pattern
*author*:*2-digit id*, such as *irecasens:01*

## DB dump
Before running liquibase it's a good idea to create a dump to avoid losing data in case something goes wrong
###### Creating a dump
Run the following command from a terminal  
```mysqldump -u user -p schemaName > filename```  
*filename* should have .sql extension

Enter password when prompted  
Dump will be created from the path of the terminal

###### Loading a dump
Run the following command from a terminal  
```mysql -u user -p schemaName < filename```

Again, enter password when prompted

## Updating DB
Use the following command from root folder to run liquibase  
*mvn liquibase:update*

You can also create run configuration