## Week9A

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

-------

## Week10A

On Week10A I've extended my application.
I've managed to both add the new main class
and keep the original one only with a little change in its functionality.

### Structural changes

As demanded by mentors, *Movie* become a subclass of an abstract *Product* class.
Class *Book* and *Game* also appeared as subclasses.
*Movie* and *Game* also become an implementation of a new interface, *Buyable*.
My application also got the new main class, called *RentManager*.

But there were also new features that had not been on task-list:
* We had to remove instance variable *hasOscar* and *hasGoldenGlobe* from class *Person*.
  It would have caused problems to the old main class *MovieManager*.
  To resolve this problem, these variables were moved to a new subclass, named *Actor*.
  *Movie* and *MovieManager* were rebased on this new class.
* The other main difference is that
  the new main class *RentManager* is also able to write the demo data it works with to an xml-file.
  For this reason, *Book*, *Game*, *Movie*, *Person* and *Actor* all have the method *toXMLString*.
  The declaration of this method was moved to a new interface, called *XMLCompatible*.
  *Product*, *Buyable* and *Person* were all annotated as an implementation of this interface.

There were some other changes to be mentioned, as well:
* The file-handler method moved to class *Tools*, enabling both main classes to use it.
* In both of the main classes demo-data creator function was separated from *main* method,
  enabling both *main* methods to consist of few rows.

### Entry points and output files

My application has 2 entry-points.
One of them is the original class *MovieManager* and the other is *RentManager*.

If you run *MovieManager*, it behaves almost the same way as in *v1.0*
(ie. creates some demo *Movie*s, prints their titles to screen and saves all data to xml-file).
The only differences are the following:
* The objects on cast-list are *Actor*s instead of *Person*s.
* Each *Actor* has a *sellary* field as well.
* Each *Movie* has a *lender* field of type *Person* to show who has rent the *Book*.
* These *Person*s also have their own *salary*.

If you run *RentManager*, it does the followings:
* Creates 2 instances of all kinds of products,
* Fills them with demo data,
* Prints the title, lender and investment of all to screen
* Stores the data in an xml-file, namely *products.xml*.

-------

I hope it's a beginning of a new friendship with a new language.
