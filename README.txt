# pizza-rest
Spring Boot - MVC + bootstrap + jquery + REST + Security with JWT authentication.
Use the address bellow to test Spring MVC
http://localhost:8080

http://localhost:8080/auth
{
	"username":"user",
	"password":"password"
}

{
	"username":"admin",
	"password":"admin"
}


To test the rest methods to get the list of pizza or any other, use the addresses below with the Bearer token in the header for authentication
http://localhost:8080/refresh
token:XPTO.XYZ.IJK

localhost:8080/pizza
token:XPTO.XYZ.IJK

localhost:8080/pizza/{name}
token:XPTO.XYZ.IJK

protected by admin role
http://localhost:8080/admin
