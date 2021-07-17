## Scaling with MYSQL

### Replication

- *Replication* is to have multiple copies of the same data stored on different machines. 

- replication allows you to synchronize the state of two servers, where one of the servers is called a *master* and the other one is called a *slave*

- When using MySQL  replication, your application can connect to a slave to read data from  it, but it can modify data only through the master server. 

- The master server records all of  these statements in a log file called a *binlog*, together with a  timestamp, and it also assigns a sequence number to each statement. 

- At this stage the master server returns a response to the client and continues processing other transactions. 

- At  any point in time the slave server can connect to the master server and  ask for an incremental update of the master’s binlog file. In its  request, the slave server provides the sequence number of the last  command that it saw. 

- the master server quickly locate the data and begin streaming the binlog file back to the slave  server. The slave server then writes all of these statements to its own copy of the master’s binlog file, called a *relay log*. 

  ![image-20210716213816770](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716213816770.png)

- MySQL replication is asynchronous. That means that the master server does not wait for slave to get the statements  replicated.  allows for  decoupling of the master from its slaves.

- Below is a pattern of master server with multiple slave machines.  Each of the slave servers keeps track of the last statement that was  replicated. They all connect to the master and keep waiting for new  events, but they do not interact with each other. 

  ![image-20210716213940260](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716213940260.png)

  

  #### Benefits of Replication

  - Distribute read-only statements among more servers, thus sharing the load among more machines.

  - use different slaves for different types of  queries. For example, you could use one slave for regular application  queries and another slave for slow, long-running reports.

  - You can use the asynchronous nature of MySQL replication to perform zero-downtime backups. 

    

  One of the main reasons why people use  replication in MySQL and other data stores is to increase availability  by reducing the time needed to replace the broken database.



#### Master Failure

- Rebuilding slaves can seem like a lot of trouble, but a scenario that is even more complex to recover from is master failure. 

- Avoid master failure using deployment topology called master-master. In this case you have two servers that could accept writes, as Master A replicates from Master B and Master B replicates from Master A. MySQL  replication allows for that type of circular replication

  

### ![image-20210716214412472](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716214412472.png)

![image-20210716214435984](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716214435984.png)



- Although master-master replication can be useful in increasing the availability of your system, it is not a scalability tool
- chain three or more masters together to create a ring. Not only does ring replication not help you scale writes, as all masters need to execute all the write statements, but it also reduces your availability and makes failure recovery much more difficult.
- *Replication lag* is a measurement of how far behind a particular slave is from its master.

![image-20210716214831746](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716214831746.png)



#### Replication Challenges

- When using replication, you will not be able to scale writes of your MySQL database.
- If your application does many more reads than writes, replication is a good way to scale.
- By adding multiple levels of replication,  your replication lag increases, as changes need to propagate through  more servers, but you can increase read capacity, which may be a  reasonable tradeoff.

![image-20210716215142498](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716215142498.png)



-  Having a lot of  inactive data may increase the size of your database indexes, but if you do not need to access that data repeatedly, it does not put much  pressure on your database. Active data, on the other hand, needs to be  accessed, so your database can either buffer it in memory or fetch it  from disk, which is usually where the bottleneck is. When the active  data set is small, the database can buffer most of it (or all of it) in  memory. As your active data set grows, your database needs to load more  disk blocks because your in-memory buffers are not large enough to  contain enough of the active disk blocks. 
-  slaves can return stale data due to more replication lag. To prevent reading the stale ones, 
  - one approach is to cache the data that has been written on the client side so that you would not need to read the data  just written. -
  -  send critical read requests to the master so that they would always result in the most up-to-date data. 

### Data Portioning

- divide the data set into smaller pieces so that it could be distributed across multiple machines 
-  servers become independent from one another, as they share nothing. Without data overlap, each server can make authoritative decisions about data  modifications without communication overhead and without affecting  availability.

#### Sharding Key

- A *Sharding key* is the information that is used to decide which server is responsible for the data that you are looking for.

- If you shard by the country of origin, you  are likely to have an uneven distribution of data. Some countries will  have a majority of your users and others will have very few, making it  harder to ensure equal distribution and load. 

  ![image-20210716215915768](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716215915768.png)



#### Challenges of Sharding

- Limitations is that you cannot execute queries spanning multiple shards.  Any time you want to run such a query, you need to execute parts of it  on each shard and then somehow merge the results in the application  layer.

- distributing data across multiple machines is that you lose the ACID properties of your database as a whole.
- as your data grows, you may need to add more servers





![image-20210716220431822](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716220431822.png)



By dividing your web service into two highly decoupled services, you could now scale them independently. 







## Scaling with NoSQL

### The Rise of Eventual Consistency

- As the simplified version of the CAP theorem suggests (pick two), building a distributed data store requires us to relax the guarantees around availability, consistency, or partition tolerance. Some of the NoSQL data stores choose to sacrifice some of the consistency guarantees to make scalability easier. 

- Eventual consistency is a property of a system where different nodes may have different versions of the data. If you asked a single server for data, you would not be able to tell whether you got the latest data or some older version of it because the server you choose might be lagging behind.

  

  

  ### ![image-20210716220910038](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716220910038.png)

  

  - Some data stores use eventual consistency as a way to increase high availability. Clients do not have to wait for the entire system to be ready for them to be able to read or write. Servers accept reads and writes at all times, hoping that they will be able to replicate incoming state changes to their peers later on. The downside of such an optimistic write policy is that it can lead to conflicts, since multiple clients can update the same data at the exact same time.

    ![image-20210716221017549](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716221017549.png)

  - different ways in which conflicts like this  can be resolved. The simplest policy is to accept the most recent write  and discard earlier writes. This is usually called “the most recent write wins” and it is appealing due to its simplicity, 

  - some data stores like Dynamo push the responsibility for conflict resolution onto its clients. They detect conflicts and keep all of the conflicting values. Any time a client asks for that data, they would then return all of the conflicted versions of the data, letting the client decide how to resolve the conflict. The client can then apply different business rules to resolve each type of conflict in the most graceful way. 

  - For example, with the Amazon shopping cart, even if some servers were down, people would be able to keep adding items to their shopping carts. These writes would then be sent to different servers, potentially resulting in multiple versions of each shopping cart. Whenever multiple versions of a shopping cart are discovered by the client code, they are merged by adding all the items from all of the shopping carts rather than having to choose one winning version of the cart. This way, users will never lose an item that was added to a cart, making it easier to buy.

    ![image-20210716221208272](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716221208272.png)

  - 10 percent of reads sent to Cassandra nodes trigger a background read repair mechanism. As part of this process, after a response is sent to the client, the Cassandra node fetches the requested data from all of the replicas, compares their values, and sends updates back to any node with inconsistent or stale data. 

  - Using an eventually consistent data store  does not mean that you can never enforce read-after-write semantics.  Some of the eventually consistent systems, like Cassandra, allow clients to fine-tune the guarantees and tradeoffs made by specifying the  consistency level of each query independently.

  - *Quorum consistency* means the majority of the replicas agree on the result. When you write using quorum consistency, the majority of the servers need to confirm that they have persisted your change. Reading using a quorum, on the other hand, means that the majority of the replicas need to respond so that the most up-to-date copy of the data can be found and returned to the client. A quorum is a good way to trade latency for consistency in eventually consistent stores.

    ![image-20210716221447159](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716221447159.png)

    

  

  ### Faster Recovery to Increase Availability

  - n MongoDB, data is automatically sharded and distributed among multiple servers. Each piece of data belongs to a single server, and anyone who wants to  update data needs to talk to the server responsible for that data. That  means any time a server becomes unavailable, MongoDB rejects all writes  to the data that the failed server was responsible for.

  - To add data redundancy and increase high availability, MongoDB supports replica sets, and it  is recommended to set up each of the shards as a replica set. In replica sets, multiple servers share the same data, with a single server being  elected as a primary. Whenever the primary node fails, an election  process is initiated to decide which of the remaining nodes should take  over the primary role. Once the new primary node is elected, replication within the replica set resumes and the new primary node’s data is  replicated to the remaining nodes.

  -  shows how a primary node failure causes some writes to be lost.

    ![image-20210716221807649](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210716221807649.png)

    