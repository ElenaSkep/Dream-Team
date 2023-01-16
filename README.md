# Door2Door
> Keep your friends close and your neighbors closer

Door2Door is an app that gives the opportunity to its users to connect with their neighbors.You can communicate with them
through one to one messages or chatrooms of your neighborhood.These services give the users the chance to learn about their 
neighborhood,different activities that take place there just as volunteering.Door2Door is there to give you the motive to learn 
who lives next to you.


## Compile
In order to compile our program you should use the command mvn compile.

## Execution of Door2Door
You can execute our programm using the command  java -jar Door2Door.jar
Our database called **mydb.db** should be on the resources and target.
Also our logo called **doortodoorlogo.png** should be on the resources 
Our database and logo are in our repository in github.

It is important that these and our jar file are in the same file.

## Run Door2Door
If you don't have an account in our app you should create one with the option **login**, otherwise you can **sign up**.
After you enter our app successful you will see our welcome page that presents you three options:**one to one messages**.
There you can search a person that you like and if that person is in our app you can send him/her a private message 
and get to know them.The second option is the **groupchat**.There you can join a groupchat where people that you share
the same postal code can communicate through messages.You can even show what messages you like using the button like.
Our third option is **'your messages'** where you can see the messages
that other people have sent you.


## Algorithms and Data Structure
In our app we use the search algorithm.This algorithm is used in the option one to one messages in order to search 
if the person you have chosen is a user in our app.

The data structure that we use is a database that was created with the help of SQLite.
Our database contains four tables the users,messages,groupmes and likes.


