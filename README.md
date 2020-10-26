# creditapplication-backend
This is a backend project for a credit application system. It takes customer name, surname, salary, phone num, mernis information and returns if intended application is approved.

The design of the bacend project is as follows. Two MySQL tables are designed for storing data. Customer table holds the mernis, name, surname, salary and phoneNumText information.
A customer record is created when a user with a new mernis enters his information, customer record is updated when a user with known mernis enters the system again.
CreditRequest table holds the credit request results. It stores customerId, result (if the request is approved or not) and creditLimit.

CREATE SCHEMA 'credit_application_db' DEFAULT CHARACTER SET utf8 COLLATE utf8_turkish_ci ;

Customer Table:
CREATE TABLE Customer
(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 mernis CHAR(11),
 name VARCHAR(75),
 surname VARCHAR(75),
 salary DECIMAL(8,2),
 phoneNumText VARCHAR(10));
 
 CreditRequest Table:
 CREATE TABLE CreditRequest
(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 customerId INT NOT NULL,
 result CHAR(1),
 creditLimit DECIMAL(9,2));
 
 applyForCredit service is explained in the API Blueprint documentation. It basically takes customer input, creates customer if customer with the entered mernis
 does not exist or updates the customer record with given additional data such as salay, name, surname, phoneNumText. And then it applies the logic in the casestudy description
 and creates credit request record accordingly. For example, if application is disapproved by the criteria, a creditrequest record is created with related customer and result value
 is F (False). If approved, result field value will be T (True) and creditLimit value will be calculated as the casestudy criteria suggests.
 
 Credit score is implemented with random number generator.
 
 
