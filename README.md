# [OOPSocial-RealTimeChat]

## Introduction

Oriented-object programming final project of the Federal Institute of Pernambuco - Campus Igarassu using Java and Node.js

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

## Funcionalities

#### User
- Create
- Edit
- Delete
- Update
- Login 
- Register

#### Room/Chat
- Realtime using Socket.io
- Room admin
- Create Room
- Delete Room (Only admin)
- Filter users/rooms list

#### Storage
- MySQL database
- PBKDF2 with HMAC SHA-1
- Each user has his salt

## Patterns
- DAO and Singleton

## Getting Started

** (**Considering you are in root folder of project**)

### Make sure you have installed:

- mysql
- nodejs
- open-jdk
- open-jre
- maven

#### Clone project

```bash
    git clone https://github.com/Nasc1mento/OOPSocial-RealTimeChat
```
#### Compile
``` bash
    cd OOPSocial-RealTimeChat
```

```bash
    mvn clean install
```
#### Create database**

```bash
    mysql -u<your_user> -p < database/script.sql
```
#### Start socket server**

```bash
    cd server && node index.js
```
#### 

## Execute**

```bash
    mvn exec:java
```

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


## Maven Dependencies
- MySQL Connector 8.0.31
- Maven Compiler Plugin 3.8.1
- Socket IO Client 2.1.0
- Google Guava 31.1-jre
- JUnit 4.13.2

## My Specifications
- Node 18.12.1
- Java 11
- Maven 3.8.7
- MySQL 8
- Arch Linux(Distrobox)

## License

[MIT](https://github.com/Nasc1mento/OOPSocial-RealTimeChat/blob/main/LICENSE)

