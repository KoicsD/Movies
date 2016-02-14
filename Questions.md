* *final*  
  modifier to finalize implementation:
  * constant variables,
  * functions which must not be overridden,
  * classes which must not have subclasses
* *HashMap*  
  collection of key-value pairs like *dictionary* in *python*
* Generic Types  
  classes having type-parameters in their class-definition
* inner classes  
  classes defined inside another class-definition  
  can be annotated as *private*, *protected* or even *static*,
  as well as any other members of a class

Hey, Mentors:
* On your UML-diagram there is no setter for *Product.title* and *Product.person*.  
  Should I use constructor instead of setters to set them? (Finally, I did use constructor.)
* Products have id but there is no getter on your diagram to access it.  
  Getter has to exist for each instance variable, doesn't it?
  (Only setters can be substituted by constructor.)  
  I've added a *getId* method to both *Product* and *Buyable*.
  (And also a *getTitle* to *Buyable*.)
* To maintain runnability of class *MovieManager*, I've moved field *hasOscar* and *hasGoldenGlobe*
  from class *Person* to a subclass, *Actor*.  
  When we give a *person* (customer/lender) to a *Product*, we can give salary.
  Is it not illogical to think of a customer in the same way as a game-developer (or an actor)?  
  We should consider adding a new subclass *Developer* to *Person*.
  (Or even a *Customer* class, making *Person* abstract.
  Finally, I simply changed the name *person* to *lender* in class *Product*.)

One more thing:
* How could I change *Tools.getMovieTitles(List<Movie>)*
  to a polymorphic *Tools.getProductTitles(List<Product>)*
  or *Tools.getProductTitles(List<Buyable>)* function
  that can collect the titles from any kinds of list of Products?
  Where is the limit when overloading a function with polymorphic parameter types?
