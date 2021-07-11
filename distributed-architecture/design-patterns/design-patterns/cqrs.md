# CQRS

CQRS stands for Command and Query Responsibility Segregation, a pattern that separates read and update operations for a data store. Implementing CQRS in your application can maximize its performance, scalability, and security

* In traditional architectures, the same data model is used to query and update a database. Read and write workloads are often asymmetrical, with very different performance and scale requirements.

![](../../../.gitbook/assets/image%20%283%29.png)

* Scenarios where performance of data reads must be fine-tuned separately from performance of data writes, especially when the number of reads is much greater than the number of writes.

#### How

If separate read and write databases are used, they must be kept in sync. Typically this is accomplished by having the write model publish an event whenever it updates the database

![](../../../.gitbook/assets/image%20%288%29.png)



