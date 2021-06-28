# Data Models and Query Languages

- [Data Models and Query Languages](#data-models-and-query-languages)
  - [Relational Model Versus Document Model](#relational-model-versus-document-model)
    - [Why NoSQL](#why-nosql)
    - [NoSQL Databases are in two forms](#nosql-databases-are-in-two-forms)
    - [Impedance Mismatch](#impedance-mismatch)
  - [Relational Versus Document Databases](#relational-versus-document-databases)
  - [Document Databases](#document-databases)
    - [When to use Document databases](#when-to-use-document-databases)
    - [Schema Flexibility in the document model](#schema-flexibility-in-the-document-model)
    - [Data locality for queries](#data-locality-for-queries)
    - [Convergence of document and relational databases](#convergence-of-document-and-relational-databases)
  - [Query Languages For Data](#query-languages-for-data)
  - [MapReduce Querying](#mapreduce-querying)
  - [Graph-Like Data Models](#graph-like-data-models)

## Relational Model Versus Document Model

SQL is the best known data model today. Two of the earlier competitors of this model were the network model and the hierarchical model.

### Why NoSQL

Some of the driving forces behind NoSQL's dominance are:

- A need for greater scalability than relational databases can easily achieve, including very large datasets or very high write throughput
- Preference for free & open source software over commercial DB products.
- Some specialized query operations not well supported by the relational model.
- Restrictiveness of relational schemas, and a desire for a more dynamic and expressive data model.

### NoSQL Databases are in two forms

- Document databases: Targets use cases where data comes in self-contained documents and relationships between one document and another are rare. One to many relationships

- Graph databases: Target use cases where anything is potentially related to everything. Many to many relationships

### Impedance Mismatch

- An awkward translation layer (JDBC) is required between objects stored in relational tables and the application code. The disconnect between the models is called an impedance mismatch. 
- ORMs usually help with this but they don't hide all the differences between both models.

## Relational Versus Document Databases

- While relational models refer to a related item by a unique identifier called the foreign key, document models use the document reference.
- For the relational model, it provides better support for joins, and many to one and many to many relationships.
The document data model has the advantages of schema flexibility, better performance due to locality, and for some applications, it's closer to the data structures used by the application.

## Document Databases

### When to use Document databases

- If data in the application has a document-like structure (i.e. a tree of one-to-many relationships, where typically the entire tree is loaded at once), document model is a good idea.
- Document databases typically have poor support for many-to-many relationships. In an analytics application, for example, many to many relationships may never be needed.
- Basically, for highly interconnected data, the document model is awkward, the relational model is acceptable, and graph models are the most natural.

### Schema Flexibility in the document model

Document databases have the advantage of having an implicit schema which is not enforced by the database: Also known as **schema-on-read** - The structure of the data is implicit, and only interpreted when the data is read. This is contrasted with **schema-on-write**: The schema is explicit and database ensures all written data conforms to it.

### Data locality for queries

- There is a performance advantage to data locality in the document model if you need to access large parts of the document at the same time. Compared with many relational databases where data is usually spread among tables, there is less need for disk seeks and it takes less time.

- There are a couple of tools nowadays that offer this locality in a relational model e.g. Google Spanner, Oracle (multi-table index cluster tables), Cassandra and HBase (column-family concept).

### Convergence of document and relational databases

- Relational databases like PostgresSQL, MySQL and IBM DB2 have added support for JSON documents in recent times.
- Document databases like RethinkDB also support relational-like joins in its query language.

## Query Languages For Data

There is a distinction here between imperative query languages and declarative.

- An imperative language tells the computer to perform certain operations in a certain order.
- A declarative language specifies the pattern of the data wanted, and how the data should be transformed, but not how to achieve that goal.
- An advantage of this declarative approach to query languages is that it hides the implementation details of the database engine, which makes it possible for the database system to introduce performance improvements without requiring any changes to query.
HTML and CSS are also declarative languages.

## MapReduce Querying

- MapReduce is a paradigm for querying large amounts of data in bulk across many machines.
- Basically, map jobs are run on all the machines in parallel, and then the results are reduced.
- It's neither a declarative query language nor a fully imperative query API, but somewhere in between. The logic of the query is expressed with code but it's repeatedly called by the processing framework.
- Both the map and the reduce functions must be pure functions, they only use data passed to them as input, and they cannot perform additional database queries, and they must not have any side effects.
- MongoDB has implemented aggregation pipelines, which are similar to MapReduce jobs.

## Graph-Like Data Models

- If many-to-many relationships are common, the Graph model is probably best suited for it.
Graphs are not limited to homogenous data. Facebook, for example, maintains a single graph with many different types of vertices and edges. Their vertices represent: people, location, events, checkins, comments made by users. Their edges indicate which people are friends with each other, which checkin happened in which location, who commented on what, who attended which event etc.
There are a couple of different but related ways for representing graphs:
- Property graph model: Neo4j, Titan and InfiniteGraph
- Triple-store model: Datomic, AllegroGraph
- Some declarative languages for querying graphs are: Cypher, SPARQL and Datalog.
