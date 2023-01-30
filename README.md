# [OOPSocial-RealTimeChat]

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

## Screenshots

#### Home page
![Screenshot from 2023-01-29 20-49-43](https://user-images.githubusercontent.com/88512599/215363185-bf392551-8e53-41c2-b182-6007ce34a473.png)

#### Login
![Screenshot from 2023-01-29 20-53-30](https://user-images.githubusercontent.com/88512599/215363241-a7779666-ae43-425c-a57f-9d6754b66def.png)

#### Register
![Screenshot from 2023-01-29 20-50-01](https://user-images.githubusercontent.com/88512599/215363283-34d8a6c6-8a43-4e68-b71a-80c14e116d02.png)

#### Dashboard
![Screenshot from 2023-01-29 20-49-21](https://user-images.githubusercontent.com/88512599/215363397-4872fcf8-704d-4d49-bd1e-a8d273f82587.png)

#### Edit profile
![Screenshot from 2023-01-29 20-49-31](https://user-images.githubusercontent.com/88512599/215363413-2dc754fa-48f0-46bc-a57a-821c71198e14.png)


#### Show rooms
![Screenshot from 2023-01-29 20-49-03](https://user-images.githubusercontent.com/88512599/215363420-5521163d-a82d-4d2e-9f6c-ac7e584c9285.png)

#### Show users
![Screenshot from 2023-01-29 20-49-26](https://user-images.githubusercontent.com/88512599/215363453-46775253-badb-4591-a917-cf7a9920f191.png)

#### Chat
![Screenshot from 2023-01-29 20-47-05](https://user-images.githubusercontent.com/88512599/215363490-977374fc-2637-427b-ab6c-6439f719e24e.png)
#### Room chat

![Screenshot from 2023-01-29 21-01-46](https://user-images.githubusercontent.com/88512599/215363672-5894f15d-0532-4b2f-92d5-af7a774536ad.png)


![Screenshot from 2023-01-29 21-02-00](https://user-images.githubusercontent.com/88512599/215363678-e8cbe35a-2569-40c7-85d1-308e09c1c6e6.png)




## Database diagram

![Screenshot from 2023-01-29 20-12-14](https://user-images.githubusercontent.com/88512599/215363706-7af7d8fc-4746-4a7f-81a3-fa504fa128b8.png)




## Getting Started


to clone project :
```bash
    $ > git clone https://github.com/Nasc1mento/OOPSocial-RealTimeChat
```
- **Eclipse**

to install maven dependencies :

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

