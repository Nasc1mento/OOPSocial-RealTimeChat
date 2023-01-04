# [OOPSocial-RealTimeChat]

## Home Screen

![Screenshot from 2023-01-03 22-01-03](https://user-images.githubusercontent.com/88512599/210465822-a3d26984-b2ff-4d42-9a74-5480d93c8ba2.png)



## Introduction

OOP final project made with Java, it's a real time chat using Socket IO to comunicate and update, Guava Google to filter users/rooms, Node.js socket server and MySQL to save data.

## Project structure (Apache Maven)

    [OOPSocial]/
     |_ src
     |  |_ main 
     |  |  |_ java 
     |  |  |_ resources 
     |  |_ test 
     |  |  |_ java 
     |  |
     |_ database
     |_ lib
     |_ server
     |_ .gitignore
     |_ .classpath
     |_ .project
     |_ pom.xml
     |_ README.md
     |_ LICENSE

## Getting Started


to clone project :
```bash
    $ > git clone https://github.com/Nasc1mento/OOPSocial-RealTimeChat
```
- **Eclipse**

to install maven dependences :

1. Click on pom.xml
2. Run as
3. Maven install

to create database:
1. Copy script.sql
2. Execute in WorkBench, CLI or whatever you want

## Execute the program

to start socket :


```bash
    $ > cd OOPSocial-RealTimeChat
    $ > cd server
    $ > node index.js
```
- **Eclipse**

to execute :
1. Select the Main.java
2. Run as
3. Java Application


## Specifications

- Node 18.12.1
- Java 11
- MySQL Connector 8.0.30
- Maven Compiler Plugin 3.8.1
- Socket IO Client 2.1.0
- Google Guava 31.1-jre
- JUnit 4.13.2

## License

[MIT](https://github.com/Nasc1mento/OOPSocial-RealTimeChat/blob/main/license)

