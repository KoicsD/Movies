## Objectives of the week

This week you'll step to a higher level of software development.
First you will learn about describing structured data in a global standard format.
The second topic is an introduction to the well known programming language, Java.

What you need to know at the end of the week:
* XML (E**X**tensible **M**arkup **L**anguage): describing structured data, e.g. configuration files
* Java 8: the basics

------------

------------

## Init

Before you develop your first Java application, you should do the followings first:
* Download Java 8 SDK (or JDK) ! **JRE IS NOT ENOUGH !!!**
  (Windows 64-bit: http://download.oracle.com/otn-pub/java/jdk/8u65-b17/jdk-8u65-windows-x64.exe)
* Install Java 8 SDK
* Get an IDE
  ([Eclipse](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/mars/1/eclipse-java-mars-1-win32-x86_64.zip)
  or [IntelliJ](https://www.jetbrains.com/idea/#chooseYourEdition))

------------

------------

## Movies

In this task you will have to work with movies and actresses/actors.
Your task is to create a Java application
which is able to handle movies, actresses/actors as persons
and is able to make an XML report from your object structure.

Create the following class structure:

![](Description/movies_uml.jpg)

You will have to do the followings:
* Movies have title, genre, duration (in minutes),
  rate and a list (**java.util.List**) of actresses/actors (called cast) who are persons.
  Persons have firstname, lastname, gender and two flags (boolean type property)
  if the current person has already won the Oscar and if the current person has already won the Golden Globe
* Gender of a Person and Genre of a Movie are both **enum**s
  (<-hint; Gender: MALE or FEMALE, Genre: ROMANTIC, DRAMA, SCI_FI, THRILLER, HORROR, etc.)
* Both Movie and Person classes have to have a public method toXMLString(),
  which creates an xml like String from the properties set in the current object and returns with it,
  e.g. attachment: movies.xml
* Tools class contains only static methods.
  Tools class should contain a method (countMoviesPerPerson)
  which gets a List of Movies and returns with a **java.util.HashMap**
  where the keys are the Persons in the Movies
  and the values mean the quantity how many movies they are starred in.
* Tools class should contain a method, called getMovieTitles(),
  what gets a List of Movies as a parameter and returns with an **array** of Strings
  which contains the title of each movies.
* Tools class should contain a method, called toXMLTag(),
  which gets a tagName (String) and a value (String) parameters
  and creates an XML-tag-like String and returns with it.
  (e.g. toXMLTag("myTag", "myValue") => <myTag>myValue</myTag>)
* Create a MovieManager class which contains the main method !
  In the main method instantiate some Persons, Movies with demo data and write the movies to a file in XML format.
  The path and the name of the file should be stored in a "constant" variable (static final)

-----

[movies.xml](Description/movies.xml)

-----------

-----------

## Hints

Before you start coding, please read about Java naming conventions
(e.g. classes always start with capital, methods and instance variables never) !

What you should read about:
* XML
* Java classes
* modifiers (public, private, protected, static, final)
* enum
* java.lang.String
* java.lang.StringBuffer
* primitive types: int, double, boolean, float, etc.
* "new" operator
* java.util.List
* java.util.HashMap
* for loop (2 types: iterate over array, foreach type)
* "if" structure
* array in Java (be careful: List and array are not the same in Java !)
* java.util.ArrayList
* exception handling in Java: try-catch, Exception
* java.io.BufferedWriter
* java.io.File
* java.io.FileWriter

(If you use Eclipse, press Ctrl+Shift+F on your XML content to make it well-formed)

----------

----------

## How to prepare for week B

Create a small demo for your work.  
Collect all the topics what you have learnt this week.  
Define some questions related to Java and/or XML.

----------

----------

tags:
Java
OOP
XML

----------

----------

## What I've done

On Week9A I got acquainted with [*Java*](https://en.wikipedia.org/wiki/Java_(programming_language)).

It's a new approach for me that every variables and functions must be defined within a class.
It says: Everything, including the program with main method itself, is a unigue category.
This is different from [*Python*](https://en.wikipedia.org/wiki/Python_(programming_language))
(and even [*c++*](https://en.wikipedia.org/wiki/C%2B%2B)).

The other big difference between [*Java*](https://en.wikipedia.org/wiki/Java_(programming_language))
and [*Python*](https://en.wikipedia.org/wiki/Python_(programming_language)) is
that [*Java*](https://en.wikipedia.org/wiki/Java_(programming_language)) is a compiled and statically type-checker language.
It means you have to define the type of every variable, even if you decide to give the value later.
For me it's very easy to implement my thoughts under these circuimstances.
To tell the truth, I'm used to it because of my [*c++*](https://en.wikipedia.org/wiki/C%2B%2B)-knowledge.

What is a new feature for me is [interfaces](http://www.tutorialspoint.com/java/java_interfaces.htm).
(I bumped into it when I had to use
[*java.util.List*](http://www.tutorialspoint.com/java/java_list_interface.htm) objects.
[*java.util.List*](http://www.tutorialspoint.com/java/java_list_interface.htm) soon
[turned out to be uninstantiatable](https://stackoverflow.com/questions/7960149/cannot-instantiate-the-type-listproduct)
as it is just an interface and not a class. Finally, I used
[*java.util.ArrayList*](http://www.tutorialspoint.com/java/util/java_util_arraylist.htm) as implementation.)
Now I know that interface is a class-like feature,
which is so abstract that none of it's methods can be implemented within its definition.
The main advantage of it is that a class can have multiple interfaces as base-class,
while there must be only one real base-class at the same time.

To finalize, I've managed to make my code generate [an *XML*-file](SampleData/movies.xml)
having the same content as [the sample](Description/movies.xml)
(except from some differences in using lower- and upper-case).

I hope it's a beginning of a new friendship with a new language.
