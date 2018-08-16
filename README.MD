Hello, this is the SimpleSpringLogin, the simple project based on Java and Spring MVC with MySQL as its DBMS made from scratch with some tutorial for the script references

The MySQL dump is on the project folder for the sake of convenience. I run it on the workbench instead from IDE, after delete the exact schema from my laptop

It has domain for model, repository for the db query,
 service  for access the repository and do extra things,
 controller to access the service and provide the view

So, the first validation is to check if the username has the email form. If the pattern
is correct, then we can check the not-deleted user on the data given the username
then check the user given the username and password combination

The controller supposedly will catch the exception and its message should the input is wrong
and go to login with user model if the input is right. The login page will display te username name