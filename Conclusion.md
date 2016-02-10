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
