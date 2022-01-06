**Project by:** Mihnea Tudor \
**Group:** 321CAb

University Politehnica of Bucharest \
Faculty of Automatic Control and Computer Science

# Santa's Helpers
## Project Overview
This project simulates a simplified method of how Santa Claus would distribute his gifts to
children throughout the entire world. The logic of the program is built around a **database** that
stores the main entities: _Children_, _Gifts_ and _Updates_. The _main logic_ of the gift
distribution algorithm can be found in the **SantaTracker** class. Input and output represent
**JSON** files and are read / written with the **Jackson** library.

All main components of the project will be presented in the following sections, with an _emphasis_
on the **interactions** between classes and the **general flow** of the program.


## The Gift Distribution Algorithm
### Initialization / Round 0


### Yearly Updates


## The Database
The database is a very important part of this project, as it holds the information of all the
entities that implement the DatabaseTrackable interface. The interface has a single
```String getKey()``` method which returns the primary key of the object that implements it. 

The Database class follows the Singleton pattern, therefore there can only be a single instance
of it at a time, and can be accessed from anywhere in the project by calling
```Database.getInstance()```.

The main object is a private HashMap named 'database', with the key being a class that extends
DatabaseTrackable, and the value being a LinkedHashMap. The latter is another Map that ties the
primary key of an object, represented as a String, to the object itself.

The actions that can be done on the database are the following:
* add
  * using runtime class - adds a list of objects to the runtime class of the first object
  * using given class - adds a list of objects to the given class

* retrieve
  * class entities - retrieves all the entities from the database of the given class
  * entity - retrieves the entity of the given class, by the given key

* remove
  * entity - removes the entity from the database and returns it

* clear
  * clears the entire database

## Main Entities
The main entities of this project are considered to be the ones that are stored in the database,
the classes that implement the DatabaseTrackable interface.

Those classes are:

### Child
* holds information describing a child
* notable details:
  * has an ```update()``` method used for the Observer pattern; the object is notified by the
    SantaTracker whenever a new annual update happens 
  * a ChildFactory class (Factory pattern) is used to create new children from JSON input
    (ChildInput class)
  * there is a ChildManager used specifically to apply updates to children
  * based on the age, each child uses a Strategy to calculate their average score; the strategy is
    updated when the child is created and every time the child grows 1 year older

#### Score Strategies
* the score strategies are created with the help of a ScoreStrategyFactory, taking in the age and
  returning the corresponding strategy
* there are 3 strategies
  * _BabyScoreStrategy_: returns a constant value of 10
  * _KidScoreStrategy_: returns an average of the child's nice scores
  * _TeenScoreStrategy_: returns a weighted average of the child's nice scores

### Gift
* holds information describing a gift
* notable details:
  * a GiftFactory class (Factory pattern) is used to create new gifts from JSON input (GiftInput
    class)


### Annual Update
* will be detailed in the following section


## Annual Updates



## Input / Output
### Input
All input test files can be found in the test_db/test_files folder. A test is a JSON file with information about all
the users, videos, actors and actions in the database. The data is parsed and saved in an Input object, after which
each individual component is created and added to the database.

For the creation of the Action objects, there is a specialized class called ActionFactory, which takes in the input of
a single Action and creates either a Command, a Query or a Recommendation, based on the requested type.

### Output
Each action creates a certain output message containing either the result of the query / recommendation or if the
command was successful. The output is formatted as a JSON object and added to an array of JSON objects, which is then
printed into a file in the result/ folder (or to out.txt, if calling ```main()``` from the Test class).
