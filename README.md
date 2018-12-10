# Coding Excercise

User registration app with Spring boot and Angular6


This will be the web application offers an HTTP endpoint (REST) to register a user. The definition of the endpoint is:

- **method name:** register
- **parameters:**
 	- **username:** alphanumerical, no spaces.
	- **password:** at least four characters, at least one upper case character, at least one number
	- **date of birth:**
	- **Social Security Number (SSN):**
- **checks:**	
	- parameter's are valid according to specification.
	- user hasn't been already registered
	- user is not blacklisted 
- returns ok response if user could be registered, for any failure throws an appropriate remote exception/ error

---

#### Steps to run the project :

Run the following command to start the project.

```
mvn clean install
cd AppWeb/target
java -jar AppWeb-1.0.0-SNAPSHOT.jar
```

#### Note :

** Exclusion Service is a Stubbed service to blacklist all user's with SSN greater than 555555555**




