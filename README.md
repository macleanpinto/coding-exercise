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

#### Download

PrimeNG is available at NPM, if you have an existing application run the following command to download it to your project.

```
npm install primeng --save
npm install primeicons --save
```

#### Angular CLI Integration


