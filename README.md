# JMS

1 Vendor Collection System Requirements
```
Collect the following:
Vendor name
Contact first and last name
vendor address (street, city, state, zipcode)
contact email
contact phone number

persist info to db
Request must be kept in case of any system failure

```


2 Tools
```
MongoDB / Mongo VUE

ActiveMQ server

Tomcat 7 and 8

Jenkins

Optionals: Log4j

```

3 SDLC Designing
```
* Component
1) Presentation Zone (Web Server Proxy)
2) Application Zone (Tomcat 7.0.40)
3) Queueing Zone (MQ server)
4) Model Zone (Tomcat 8)
5) Managerment Zone (Tomcat 7.0.22)

* Designing
SOA-service Oriented Architecture
jsp ->Spring controller -> JSON service ->Messaging Server->Consumer service listener
-> Adapter->MongoDB
```

4 Coding
```


```
