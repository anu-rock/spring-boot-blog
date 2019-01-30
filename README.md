# tldr;
This is my first web project based on Spring Boot.  
It uses Hibernate for ORM, MySQL for database, and Flyway for db migrations.  
The 'funnest' part is the language it's coded in: **Kotlin** rather than plain old Java.  
Seriously, you should try out Kotlin if you haven't already. If you like Java and JavaScript, you will love Kotlin!

# Did I create this application all by myself?
Nope. I had help. I followed this beautiful tutorial (you should too):  
https://spring.io/guides/tutorials/spring-boot-kotlin/

Also check the following (Java-based) tutorials for additional useful tips:  
https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/  
https://www.callicoder.com/spring-boot-flyway-database-migration-example/  
(Hats off to Callicoder for the amazing tuts)

# How to open it?
1. Clone this repo.
2. Then, open the cloned directory in Intellij IDEA.
3. Let gradle sync complete to install all dependencies.
4. Poof, you're done.

# How to use it?
1. Run the app by right-clicking BlogApplication.kt and selecting 'Run...'. The app will be accessible at http://localhost:8080.
2. Run the tests by right-clicking 'test' folder and selecting 'Run All Tests'.
3. Use something like Postman to test the API endpoints.
