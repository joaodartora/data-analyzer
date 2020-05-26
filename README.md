# Data Analyzer

[![Build Status](https://travis-ci.com/joaodartora/data-analyzer.svg?token=1pvp6sdrxupZsUX5ieHL&branch=master)](https://travis-ci.com/joaodartora/data-analyzer)

## Purpose 

This project is a data analysis system that must be able to import lots of flat files, read and analyse the data, and output a report

### Input

The system reads data from the a default directory, located at %HOMEPATH%/data/in. The
system only reads ```.dat``` files.

There are 3 kinds of data inside those files. For each kind of data there is a different layout.

**Salesman** data has the format ID 001 and the line will have the following format:
```001çCPFçNameçSalary```

**Customer** data has the format ID 002 and the line will have the following format:
```002çCNPJçNameçBusiness Area```

**Sales** data has the format ID 003. Inside the sales row, there is the list of items, which is
wrapped by square brackets []. The line will have the following format:
```003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name```

### Output

After processing all files inside the input default directory, the system will create a flat file inside
the default output directory, located at %HOMEPATH%/data/out. The filename must follow this
pattern:
```{flat_file_name}.done.dat```

The output file contents will summarize the following data:
- Amount of clients in the input file
- Amount of salesman in the input file
- ID of the most expensive sale
- Worst salesman ever

### Technology used

- Java 11
- Gradle 6.4.1
- JUnit 5.6.2

### Test, Build and Run

1. To run unit tests ```./gradlew clean test```
2. To build the project ```./gradlew clean build```
3. To run the jar ```java -jar build/libs/data-analyzer.jar```