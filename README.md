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


## The Simulation Process
### Initialization / Round 0
At the beginning of the simulation, all the information is stored in the database, and the
SantaTracker is created and initialized with the simulation year count and the initial budget.
Then, the initial gifts are distributed to the initial children. The gift distribution algorithm
will be detailed at the end of the simulation section.

### Yearly Updates
Every year there are multiple steps:
* the children are notified of the year change, incrementing their age by 1
* new children and gifts are added to the database
* all children updates are applied to the children
* Santa's budget is updated
* the newly obtained gift collection is distributed among the children

### The Gift Distribution Algorithm
The steps are:
* each child is assigned a maximum budget that Santa cannot go over
* Santa attempts to buy at most one gift from each child's preferred gift categories, from left
  to right

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

### Search Manager

```TO_COMPLETE```


### Sort Manager

```TO_COMPLETE```

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
Annual updates represent the changes that take place each year, changes that add new entities and
affect old ones. Each annual update contains a list of new children and gifts to be added to the
database, alongside a new yearly budget and, very importantly, a list of child updates.

Both annual updates and child updates are created with the use of an UpdateFactory that takes in
an input object and turns it into the desired AnnualUpdate / ChildUpdate class.

The annual updates are applied within the SantaTracker class, whereas the child updates are applied
with the help of the ChildManager class.

### Child Updates
Child updates contain 3 fields:
* ID - the id of the child on which the update should be applied
* niceScore - a new nice score to add to the child
* giftsPreferences - a list of new gift categories to add to the child


## Input / Output
### Input
All input test files can be found in the _tests/_ folder. A test is a JSON file with information
about all the initial information, children, gifts and yearly updates that will be added to the
database. The data is parsed with the help of the Jackson library -- this was done by creating an
Input class for each object in the JSON file, and marking each field with a ```@JsonProperty```
annotation. All the data was stored in a single Input class.

The input data was then stored in the corresponding non-input classes with the help of many
Factory classes.

### Output
Every gift distribution event generates output that needs to be written to a file. It's first
added to a list in a general Output object, that is further written to the corresponding output
test file, with the help of Jackson.

The different (NameOfObject)Output objects are created using Factory classes.
