# Database use cases

## Redis Use Cases

* Redis data resides in the server’s main memory. 
* blazing fast performance with average read or write operations taking less than a millisecond and support for millions of operations per second

### Caching

* Redis is a great choice for implementing a highly available in-memory cache to decrease data access latency, increase throughput, and ease the load off your relational or NoSQL database and application. 
* Database query results caching, persistent session caching, web page caching, and caching of frequently used objects such as images, files, and metadata.

### Chat, messaging, and queues

* Redis supports Pub/Sub with pattern matching and a variety of data structures such as lists, sorted sets, and hashes. 
* Redis to support high performance chat rooms, real-time comment streams, social media feeds and server intercommunication. 

### Gaming leaderboards

* Redis is a popular choice among game developers looking to build real-time leaderboards. 
* Use the Redis Sorted Set data structure, which provides uniqueness of elements while maintaining the list sorted by users' scores. 
* use Sorted Sets to handle time series data by using timestamps as the score.

### Session store

* store and manage session data for internet-scale applications. 
* Redis provides the sub-millisecond latency, scale, and resiliency required to manage session data such as user profiles, credentials, session state, and user-specific personalization.

### Geospatial

Redis offers purpose-built in-memory data structures and operators to manage real-time geospatial data at scale and speed.

### Machine Learning

* fraud detection in gaming and financial services, real-time bidding in ad-tech, and matchmaking in dating and ride sharing, the ability to process live data and make decisions within tens of milliseconds is of utmost importance. 

### Real-time analytics

Redis can be used with streaming solutions such as Apache Kafka and Amazon Kinesis as an in-memory data store to ingest, process, and analyze real-time data with **sub-millisecond latency**. Redis is an ideal choice for real-time analytics use cases such as **social media analytics, ad targeting, personalization,** and IoT.

## Cassandra

* eventually consistent. 
* Cassandra is optimized for high throughput and faster writes, and can be used for **collecting big data for performing real-time analysis**.

Here are some of its top use cases:

* Storing key-value data with high availability - Reddit and Digg use Cassandra as a persistent store for their data. Cassandra’s ability to scale linearly without any downtime makes it very suitable for their growth needs.
* Time series data model - Cassandra well suited for storing and analyzing sequentially captured metrics \(i.e., measurements from sensors, application logs, etc.\). Such usages take advantage of the fact that columns in a row are determined by the application, not a predefined schema. Each row in a table can contain a different number of columns, and there is no requirement for the column names to match.
* Write-heavy applications - Cassandra is especially suited for write-intensive applications such as time-series streaming services, sensor logs, and Internet of Things \(IoT\) applications.

## DynamoDB

* Dynamo is an eventually consistent database. Therefore, any application where strong consistency is not a concern can utilize Dynamo. Though Dynamo can support strong consistency, it comes with a performance impact.
* Dynamo is used at Amazon to manage services that have very high-reliability requirements and need tight control over the trade-offs between availability, consistency, cost-effectiveness, and performance. Amazon’s platform has a very diverse set of applications with different storage requirements.
* Many services on Amazon’s platform require only primary-key access to a data store.

## Redis vs Dynamo DB

Two deployments

* Standalone
* Multi-AZ cluster

Redis:

* With standalone installation it is possible to turn on persistence for a Redis instance, so service can recover data after reboot. 
* But in some cases, like underlying hardware degradation, AWS can migrate Redis to another instance and lose persistent log.
* In Multi-AZ cluster installation it is not possible to enable persistence, only replication is occur. In case of failure it takes a time to promote replica to master state. 
* Redis doesn't provide high durability of the data, while gives you very good performance.

Dynamodb

* DynamoDB is highly available and durable storage of you data. 
* Internally it replicates data into several availability zones, so it is highly available by default
* DynamoDB is a SSD Database comparing to Redis in-memory store, but it is possible to use DAX - 

  in-memory cache read replica for DynamoDB as accelerator on heavy load

