# Data Models and Query Languages

* [Data Models and Query Languages](data-models-and-query-languages.md#data-models-and-query-languages)
  * [Relational Model Versus Document Model](data-models-and-query-languages.md#relational-model-versus-document-model)
    * [Why NoSQL](data-models-and-query-languages.md#why-nosql)
    * [NoSQL Databases are in two forms](data-models-and-query-languages.md#nosql-databases-are-in-two-forms)
    * [Impedance Mismatch](data-models-and-query-languages.md#impedance-mismatch)
  * [Relational Versus Document Databases](data-models-and-query-languages.md#relational-versus-document-databases)
  * [Document Databases](data-models-and-query-languages.md#document-databases)
    * [When to use Document databases](data-models-and-query-languages.md#when-to-use-document-databases)
    * [Schema Flexibility in the document model](data-models-and-query-languages.md#schema-flexibility-in-the-document-model)
    * [Data locality for queries](data-models-and-query-languages.md#data-locality-for-queries)
  * [Query Languages For Data](data-models-and-query-languages.md#query-languages-for-data)
  * [Graph-Like Data Models](data-models-and-query-languages.md#graph-like-data-models)

## Relational Model Versus Document Model

### Why NoSQL

Some of the driving forces behind NoSQL's dominance are:

* A need for greater scalability
* Preference for free & open source software
* Some specialized query operations
* Flexible data model.

### NoSQL Databases are in two forms

* **Document databases**: Targets use cases where data comes in self-contained documents and relationships between one document and another are rare. One to many relationships
* **Graph databases**: Target use cases where anything is potentially related to everything. Many to many relationships

### Impedance Mismatch

* An awkward translation layer \(JDBC\) is required between objects stored in relational tables and the application code. The disconnect between the models is called an impedance mismatch. 
* ORMs usually help with this but they don't hide all the differences between both models.

## Relational Versus Document Databases

* index: While relational models refer to a related item by a unique identifier called the foreign key, document models use the document reference.
* joins: For the relational model, it provides better support for joins, and many to one and many to many relationships.

  The document data model has the advantages of schema flexibility, better performance due to locality, and for some applications, it's closer to the data structures used by the application.

## Document Databases

### When to use Document databases

* If data in the application has a document-like structure \(i.e. a tree of one-to-many relationships, where typically the entire tree is loaded at once\), document model is a good idea.
* Document databases typically have poor support for many-to-many relationships. In an analytics application, for example, many to many relationships may never be needed.
* Basically, for highly interconnected data, the document model is awkward, the relational model is acceptable, and graph models are the most natural.

### Schema Flexibility in the document model

* Document databases have the advantage of having an implicit schema which is not enforced by the database: Also known as **schema-on-read**
* The structure of the data is implicit, and only interpreted when the data is read. This is contrasted with **schema-on-write**: The schema is explicit and database ensures all written data conforms to it.

### Data locality for queries

* There is a performance advantage to data locality in the document model if you need to access large parts of the document at the same time. Compared with many relational databases where data is usually spread among tables, there is less need for disk seeks and it takes less time.

## Query Languages For Data

Distinction here between imperative query languages and declarative.

* An imperative language tells the computer to perform certain operations in a certain order. Like micromanaging boss
* A declarative language specifies the pattern of the data wanted, and how the data should be transformed, but not how to achieve that goal.
* An advantage of this declarative approach to query languages is that it hides the implementation details of the database engine, which makes it possible for the database system to introduce performance improvements without requiring any changes to query.
* Some declarative languages for querying graphs are: Cypher, SPARQL and Datalog.

## Graph-Like Data Models

* If many-to-many relationships are common, the Graph model is probably best suited for it.

  Graphs are not limited to homogenous data. Facebook, for example, maintains a single graph with many different types of vertices and edges. Their vertices represent: people, location, events, checkins, comments made by users. Their edges indicate which people are friends with each other, which checkin happened in which location, who commented on what, who attended which event etc.

  There are a couple of different but related ways for representing graphs:

* Property graph model: Neo4j, Titan and InfiniteGraph
* Triple-store model: Datomic, AllegroGraph

