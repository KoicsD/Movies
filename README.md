Note:
Although the sample data (xml) of this repository is based on real persons and products,
not all the data fits the truth.

# Welcome to my first Java-project!

On **Week9A** at [*CodeCool*](https://www.codecool.com/) we had to get acquanted
with [*Java*](https://en.wikipedia.org/wiki/Java_(programming_language))
and [*XML*](https://en.wikipedia.org/wiki/XML).
Here is the work-alone project we should achieve it via.
Its main class is *MovieManager*, which makes a list of *Movie*s,
from wich each *Movie* has its own cast as a list of *Person*s.
Finally, data structure is printed into an *XML*-file.
Each object contributes to converting its data to *XML*-tagged string via its own method,
and a *Tools* class also helps this task.

Two weeks later, on **Week10A**
our task was to extend our work and create *movies v2.0*.
The new modell is about a store where you can rend *Product*s
(ie. *Movie*s, *Game*s and *Book*s)
but only *Game*s and *Movie*s are *Buyable*.
The new main class is *RentManager*,
which instantiates some *Product*s and prints out the investments.

Now, another two weeks later, it's **Week11A**.
Our task is to add a new main-class to our project, called [*ObjectServer*](movies/ObjectServer.java),
making our project have multiple entry-points.
The new class has to function as a server,
which recieves and sends [*Product*](movies/Product.java)s via [TCP/IP](https://en.wikipedia.org/wiki/Internet_protocol_suite).
Objects recieved has to be stored in a file in serialized form.
When [*Command*](movies/Command.java) *GET* arrives, objects stored in file have to be sent.
[*RentManager*](movies/RentManager.java) has to be able to connect as a client
to another instance of our application running in server mode.

Task descriptions and my conclusions can be found here:
* [Week9A -- v1.0](Description.md)
* [Week10A -- v2.0](Description2.md)
* [Week11A -- v3.0](Description3.md)

You can find my solution in [package *movies*](movies/). Please:
* [checkout *Week9A*](https://github.com/KoicsD/Movies/tree/Week9A) if you want to see *movies v1.0*.
* [checkout *Week10A*](https://github.com/KoicsD/Movies/tree/Week10A) if you want to see *movies v2.0*.
* [checkout *master*](https://github.com/KoicsD/Movies/tree/master) if you want to follow my further work.

In [directory *Description*](Description/) you can find
the *UML*-diagrams and sample files provided by mentors.
In [directory *SampleData*](SampleData/) there is the output files
generated by class *MovieManager* and *RentManager*.

[Here](Questions.md) you can find some notes about my questions.

Thank you for following my work! :D
