Below are  the end-points which is used in this Banking Application

1)Create Customer Account

Post Request : http://localhost:8085/add

2) Get Customer  by id

Get Request : http://localhost:8085/customer/{id}

If customer doesnt found it will say Customer Doesn't exists for customer  ID {id}

3)http://localhost:8085/getall

Get Request : It will fetch all Customer of  bank

4)http://localhost:8085/deleteall

this endpoint is used delete all the customers.

5)DELETE : http://localhost:8085/customer/{id}
 this endpoinT is used to delete customer by id.
 
6)PUT MAPPING : http://localhost:8085/updateCustomer  

this endpoint is used to update the customer infromation

7)GET MAPPPING : http://localhost:8085/custbyname/{customerName}

this endpoint is used to fetch the customer by name

8)http://localhost:8085/bycustadd/{customerAddress}

this endpoint is used to fetch the customer by address

9)http://localhost:8085/fundtransfer/{fromAccount}/{toAccount}/{fundAmount}

this endpoint is used to transfer the point from one customer account to other account

10)http://localhost:8085/allAccount

this endpoint is used to fetch all the account details.

11)http://localhost:8085//findAccount/{id}

this endpoint is used to find account by id. 