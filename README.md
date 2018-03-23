**Assumptions**

*If a transaction is high priority it will not be added to intraday transaction.
* All the normal transactions are treated independently.

**ExternalDependencies**
 org.apache.commons
 
 **TechStack**
 Java, Spring-boot, MongoDB
 
 **Installation**
 mvn clean install
 
 **Running** mvn spring-boot:run
 
 
 **TODO**
 * Write junits
 * Split class responsibility a bit more
 * Can create a new class to create different Transaction Readers based on file type
 
