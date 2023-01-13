# [OOPSocial-RealTimeChat]

## Screenshots

#### Home page
![Screenshot from 2023-01-03 22-01-03](https://user-images.githubusercontent.com/88512599/210465822-a3d26984-b2ff-4d42-9a74-5480d93c8ba2.png)

#### Login
![image](https://user-images.githubusercontent.com/88512599/212387277-29b6743b-7855-421f-84f3-9194c3870a2f.png)

#### Register
![Screenshot from 2023-01-13 14-28-57](https://user-images.githubusercontent.com/88512599/212387008-85ff193f-1711-46b2-9333-37b2d16ca3e2.png)

#### Others
![Screenshot from 2023-01-13 14-32-37](https://user-images.githubusercontent.com/88512599/212387477-a97393c3-19d9-4264-9507-0f4bc67a200e.png)

![Screenshot from 2023-01-13 14-32-41](https://user-images.githubusercontent.com/88512599/212387400-15d8a336-cffd-420d-b816-3ca5cdd1d1b7.png)

![Screenshot from 2023-01-13 14-32-56](https://user-images.githubusercontent.com/88512599/212387684-13b4878b-445b-4709-95b3-f660ca4af7a7.png)

![Screenshot from 2023-01-13 14-32-50](https://user-images.githubusercontent.com/88512599/212387707-b907e841-9c78-4436-aeb1-e6ca4a5c9d83.png)

![Screenshot from 2023-01-13 14-34-54](https://user-images.githubusercontent.com/88512599/212387738-920f5abc-478c-451b-888e-6c5f1d16fbf0.png)

![Screenshot from 2023-01-13 14-35-49](https://user-images.githubusercontent.com/88512599/212387768-fbaf2fba-8c2a-49fa-a338-5b7d9b8e3636.png)










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
- MySQL Connector 8.0.31
- Maven Compiler Plugin 3.8.1
- Socket IO Client 2.1.0
- Google Guava 31.1-jre
- JUnit 4.13.2

## License

[MIT](https://github.com/Nasc1mento/OOPSocial-RealTimeChat/blob/main/LICENSE)

