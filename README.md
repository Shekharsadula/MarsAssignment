# MarsAssignment

# List of Method names,Request and Responses respectively

# To add employee

Request Method : POST

Request Url: http://localhost:8080/rest/addemployee


content type:application/json

Request body:

{
  "firstname": "shekhar",
  "lastname": "sadula"
}

Response:
{
  "id": 1,
  "firstname": "shekhar",
  "lastname": "sadula"
}

*************************************************************

# To get all the Employee count

Request Method : GET

Request Url: http://localhost:8080/rest/countemployees 

Response: 

1 (Count of Employees)


*************************************************************

# To delete an Employee 

Request Method : DELETE
 
Request Url: http://localhost:8080/rest/deleteemployee/{employeeId}

Response Code: 200


*************************************************************

# To get single Employee data based on id

Request Method : GET 

Request Url: http://localhost:8080/rest/getemployee/{employeeId}

Response: 
{
  "id": 1,
  "firstname": "shekhar",
  "lastname": "sadula"
} 


*************************************************************

# To get all Employees  

Request Method : GET 

Request Url: http://localhost:8080/rest/listemployees

Response: 
[
  {
    "id": 1,
    "firstname": "shekhar",
    "lastname": "sadula"
  }
]

*************************************************************

# To update/edit Employee  

Request Method : PUT 
Request Url: http://localhost:8080/rest/updateemployee/{employeeId}

Request body:

{
  "firstname": "shekhar",
  "lastname": "sadula"
} 
Response: 
[
  {
    "id": 1,
    "firstname": "shekhar",
    "lastname": "sadula"
  }
]


*************************************************************

# Swagger URL for Html Documentation

http://localhost:8080/swagger-ui.html

#  Swagger URL For JSON  Documentation

http://localhost:8080/v2/api-docs


*************************************************************
# For Storing the data H2 database used.


##########################################
Added by Assignemnt
Hi
He