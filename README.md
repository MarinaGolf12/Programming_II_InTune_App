# Project
## Programming II
###### **How to use InTune**
```
STEP 1: Download INTUNE.jar, InTune.db, logo.png and profile.png from the main branch of this GitHub repository.
STEP 2: Place all of these files in a newly created SQLITE file in your Local Disk C.
STEP 3: Enjoy tuning in!
```


>How to compile the app through Maven

```
mvn clean                                    
mvn validate
mvn initialize
mvn generate‐sources
mvn process‐sources
mvn generate‐resources
mvn process‐resources
mvn compile
mvn process‐classes
mvn generate‐test‐sources
mvn process‐test‐sources
mvn generate‐test‐resources
mvn process‐test‐resources
mvn test‐compile
mvn process‐test‐classes
mvn test
mvn prepare‐package
mvn package
mvn pre‐integration‐test
mvn integration‐test
mvn post‐integration‐test
mvn verify
mvn install                                            
mvn site
```


>How to run the app through a command line.

```
Open Command Line pressing the Windows icon + r, then type cmd and hit enter. 
Use the cd C:\\SQLITE command and after that, using the command java -jar INTUNE.jar will get the app running.
```


>What to know while using the app.

```
- The feature of reading new messages is currently out of order. Nevertheless, users can still watch new posts and share.
- In order to react, comment or listen to a post, please choose and type the number of the post you are reffering to.
- When posting, a user has two options: Either posting the title of a song - which will not be available for others to listen to - or to post an EXACT link of the song they want to post.
- When editing your profile, use the process described before. You should once again pick the number of the information you would like to edit and then write the new information.
```


>What you will find in this repository

```
In this repository, the main branch contains all the classes and test classes used for the app in the src folder.
Also, in the main branch is the final product and what the user needs to run the app.
Then, there are some seperate branches formerly used by the app's developers when the app was first developed. Do not take those into account, the final version is on the main branch.
If you want to contribute to this project, please do so in the Contribute branch.
Feel free to open an issue for any bugs.
```


>UML Diagram regarding the code

```

```

>Data Structure of this Project

```
This project uses the SQLite database. 
There the development team created an INTUNE database which contains four tables.
These tables are User, Post, Messages and Friends and they contain information regarding all functions of the app.
```



