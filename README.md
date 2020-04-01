# Rewards

Problem Definition:

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase. 
 
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction 
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
 
Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total.

Solution:

We used the H2 database to store all the transactions and calculate the points via REST URL give below.

Context Page: http://localhost:8080/rewards

Page to check the in-memory database: http://localhost:8080/console

For this project, we are using three tables. 
  . Customer
  . Points
  . Transaction

The mock data is located in src/main/resources/data-h2.sql and this will be loaded when application starts

For processing the transactions [points calculation], we need to invoke the service via REST API, http://localhost:8080/rewards/runBatch

For checking the reports as how many points each customer earned per month: http://localhost:8080/rewards/runReportByMonth

For checking the reports as how much customer earned totally: http://localhost:8080/rewards/runReportByCustomer

Stack:

SpringBoot 2.2.6, Java 1.8, H2, Spring JPA
