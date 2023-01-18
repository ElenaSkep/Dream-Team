# Door2Door
> Keep your friends close and your neighbors closer

Door2Door is an app that gives the opportunity to its users to connect with their neighbors.You can communicate with them
through one to one messages or chatrooms of your neighborhood.These services give the users the chance to learn about their 
neighborhood,different activities that take place there such as volunteering.Door2Door is there to give you the motive to learn 
who lives next to you.


## Compile
In order to compile our program you should use the command mvn compile compile assembly:single

## Run Door2Door
Firstly our database called **mydb.db** should be put on the resources and target.
Our database can be found in our repository in github.

After that you can now run our programm using the command **java -cp target/Door2Door-0.0.1-SNAPSHOT-jar-with-dependencies.jar door2door.Main**

It is important that these and our jar file are in the same file.

## About Door2Door
If you don't have an account in our app you should create one with the option **sign up**, otherwise you can **login**.
After you enter our app successfully you will see our welcome page that presents you three options:**one to one messages**.
There you can search a person that you like and if that person is in our app you can send him/her a private message 
and get to know them.The second option is the **groupchat**.There you can join a groupchat where people that you share
the same postal code with can communicate through messages.You can even show what messages you like using the button like.
Our third option is **'your messages'** where you can see the messages
that other people have sent you.

## Github
Our github is organised as a maven project.When you enter our repository you will see two files 1)src and 2)target/classes/META-INF
The src file contains two sections the main and the test/java/door2door. Inside the main you can see our codes from the option 
java/door2door.Also you will see the option resources where you can find our database called mydb.db.In the file test/java/door2door(inside scr) you will see the tests that we have completed with maven. In the second file target/classes/META-INF you will see our pom.xml and pom.properties.

## UML
![UML diagramm](https://github.com/ElenaSkep/Dream-Team/blob/main/uml.png)

## Algorithms and Data Structure
In our app we use the search algorithm.This algorithm is used in the option one to one messages in order to search 
if the person you have chosen is a user in our app.

The data structure that we use is a database that was created with the help of SQLite.
Our database contains four tables the users,messages,groupmes and likes.


