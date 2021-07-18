# Transactions

## Transactions

### Transaction properties

* Transactions are for applications accessing a database.
* All the reads and writes in a transaction are executed as one operation: either the entire operation succeeds \(commit\) or it fails \(abort, rollback\).

### Transaction tradeoff

a system would have to abandon transactions in order to maintain good performance and high availability.

### ACID and BASE

**ACID** stands for Atomicity, Consistency, Isolation, and Durability.

* It is often used to describe the safety guarantees provided by transactions.
* Systems that don't meet the ACID criteria are sometimes called BASE: Basically Available, Soft state, and Eventual Consistency.

#### Atomicity

* cannot be broken down into smaller parts.
* Atomicity refers to the ability to abort a transaction on error and have all the writes from the transaction discarded.

#### Consistency

* Doesn't allow data of certain constraint be present in the database

  #### Isolation

* Ensures that when concurrently executing transactions are committed, the result is the same as if they had run serially, even though they may have run concurrently.

  

  #### Durability

* A promise that when a transaction is committed successfully, any data that has been written will not be forgotten, even in the event of a hardware fault or database crashes.

* usually involves a write-ahead log which helps with recovery in case the data structures on disk are corrupted.

* In a replicated database, durability often means that data has been successfully copied to a number of nodes.

* perfect durability does not exist. If all the hard disks and backups are destroyed at the same time, there's nothing the database can do to save you. 

### Single-Object and Multi-Object Operations

* multi-object transactions are several objects \(rows, documents, records\) will be modified at once. _Atomicity and Isolation_ are needed if several pieces of data are to be kept in sync.

**Determine which transaction wrote to a database**

In relational databases, this is done based on the client's TCP connection to the database server: on any particular connection, everything between BEGIN TRANSACTION and a COMMIT is considered to be part of the same transaction.

**Problems in single-object**

* the network connection is interrupted during transaction
* power fails while the database is in the middle of transaction
* If another client reads a document while it's being updated, will it see a partially updated value.

**Resolution for single-object**

* Atomicity can be implemented by using a log for crash recovery, 
* isolation can be implemented using a lock on each object.

**Issues with multi-object transactions**

* Some distributed datastores have abandoned multi-object transactions because they are difficult to implement across partitions, and can hinder performance when high availability/performance is required.

**Use cases of multi-object operations**

* When we are adding new rows to a table which have references to a row in another table using **foreign keys**. The foreign keys have to be coordinated across the tables and must be correct and up to date.

* In a document data model, when **denormalized information** needs to be updated, several documents often need to be updated in one go.

* In databases with **secondary indexes** \(i.e. almost everything except pure key-value stores\), the indexes also need to be updated every time a value is changed.

  

  **Handling Errors And Aborts**

  The idea of atomicity is to make it so that retrying failed transactions is safe.

  Things to take into consideration:

* What if the transaction actually succeeded but the network failed while the server tried to acknowledge the successful commit to the client \(so the client thinks it failed\), retrying the transaction will cause it to be performed twice - unless there's a de-duplication mechanism in place.

* If the error is due to overload, retrying the transaction will only compound the problem.

* If a transaction has side effects outside of the database, those side effects may happen even if the transaction is aborted. E.g. Sending an email.

## Weak Isolation Levels

**when concurrency issues happens ?**

* when one transaction reads data that is concurrently modified by another transaction
* when two transactions simultaneously modify the same data.
* Weak Isolation levels to handle concurrency bugs
* Why serial isolation cannot be used to handle concurrency issues: Serializable Isolation is a performance cost.

#### Read Committed

The core characteristics of this isolation level are that it prevents dirty reads and dirty writes.

**Dirty Reads**

If an object has been updated in a transaction but has not yet been committed, the act of any transaction being able to see that uncommitted data is known as a dirty read.

**Dirty Writes**

If an object has been updated in a transaction but has not yet been committed, the act of any transaction being able to overwrite the uncommitted value is a dirty write.

**Situation this level cannot be used**

* Imagine that I read a value as '30' and increment it in one transaction, and another transaction reads that value before the increment operation. If that new transaction also tries to increment it even after my transaction has committed, they would be incrementing it based on the earlier value seen as '30' before any locks were added when modifying the object. This is because the isolation level is implemented for objects that have been modified. When the new transaction happens, the value has not yet been modified.

**Implementing read committed**

* Most databases prevent dirty-writes by using row-level locks i.e. when a transaction wants to modify an object, it must first acquire a lock on the object. It must then hold the lock until the transaction is committed or aborted. Only one transaction can hold a lock at a time.
* Preventing dirty reads can also be implemented in a similar fashion. One can require that any transaction that wants to read an object should briefly acquire the lock and release it again after reading.
* approach of requiring locks before reading is inefficient is practice because one long-running write transaction can force other read-only transactions to wait for a long time. 
* Most databases prevent this by using approach: for every object that is written, the database remembers both the old committed value and the new value set by the transaction which holds the write lock. Any transactions that want to read the object are simply given the old value until the new value is committed.

#### Snapshot Isolation and Repeatable Read

**non-repeatable read or a read skew**.

**Read skew** a long running read-only transaction can have situations where the value of an object or multiple objects changes between when the transaction starts and when it ends, which can lead to inconsistencies.

**Non-Repeatable**

* when a value that has been read by a still in-flight transaction is overwritten by another transaction. Even without a second read of the value actually occurring this can still cause database invariants to be violated"

Suitations that Read skew cannot be tolerated:

* **Backups:**

  A backup requires making a copy of a database which can take long hours. During this time, writes will be made to the database. It's possible that some parts of the backup will contain an older version of the data, and other parts will have a newer version. These inconsistencies will become permanent on the database level.

* **Analytic queries and integrity checks**

  Long running analytics queries could end up returning incorrect data if the data in the db has changed over the course of the run.

**Solve Read Skew Errors**

* Snapshot isolation is commonly used. 
* The main idea is that each transaction reads a consistent snapshot of the database - that is, a transaction will only see all the data that was committed in the database at the start of the transaction. Even if another transaction changes the data, it won't be seen by the current transaction.
* This kind of isolation is especially beneficial for long-running, read only queries like backups and analytics, as the data on which they operate remains the same throughout the transaction.

**Implementing snapshot isolation**

_A core principle of snapshot isolation is this: Readers never block writers, and writers never block readers._

* Implementations of snapshot isolation typically use write locks to prevent dirty writes, but have an alternate mechanism for preventing dirty reads.
* Write locks mean that a transaction that makes a write to an object can block the progress of another transaction that makes a write to the same object.
* To implement snapshot isolation, databases potentially keep multiple different committed version of the same object. Due to the fact that it maintains several versions of an object side by side, the technique is known as **multi-version concurrency control \(MVCC\)**.

**The scenario below explains why multiple copes are needed**:

* If Transaction A has a snapshot of the database and Transaction B has the same snapshot of the database. If transaction A commits before Transaction B, the database still needs to keep track of the snapshot being used by Transaction B, and the new committed value of Transaction A.This can continue if there's a Transaction C, D, etc.
* That's why we could have multiple versions of the same object.

**MVCC in Storage engines**

* storage engines that support snapshot isolation typically use MVCC for their read committed isolation level as well.
* MVCC-based snapshot isolation is typically implemented by given each transaction a unique, always-increasing transaction ID. Any writes to the database by a transaction are tagged with the transaction ID of the writer. 
* Each row in the table is tagged with a created\_by and deleted\_by field which has the transaction ID that performed the creation or deletion.

**Indexes and snapshot isolation**

* One option with indexes and snapshot isolation is to have the index point to all the versions of an object and require any index query to filter out object versions which are not visible to the current transaction.
* Some databases like CouchDB and Datomic use an append-only B-tree which does not overwrites pages of the tree when they are updated or modified, but creates a new copy of each modified page.

#### Preventing Lost Updates

the lost update problem. Basically, if two writes concurrently update a value, what's going to happen? The lost update problem mainly occurs when an application reads a value, modifies it, and writes back the modified value \(called a read-modify-write cycle\). If two transactions try to do this concurrently, one of the updates can be lost as the second write does not include the first modification.

The key difference between this and a dirty write is that: if you overwrite a value that has been committed, it's no longer a dirty write. A dirty write happens when in a transaction, you overwrite a value which has been updated in another uncommitted transaction.

This can happen in different scenarios:

* If a counter needs to be incremented. It requires reading the current value, calculating the new value, and writing back the updated value. If two transactions increment the counter by different values, one of those updates will be lost. 
* Two users editing a wiki page at the same time, where each user's changed is saved by sending the entire page contents to the server, it will overwrite whatever is in the database.

A variety of solutions have been developed to deal with this scenario:

* Atomic Write Operations: Many databases support atomic updates, which remove the need for the read-modify-write cycles. Atomic updates look like:

  Atomic operations are usually implemented by taking an exclusive lock on the object when it's read to prevent any other transaction from reading it until the update has been applied.

Another option for implementing atomic writes is to ensure that all atomic operations run on the same database thread.

However, not all database updates fit into this model. Some updates require more complex logic and won't benefit from atomic writes.

* Explicit Locking: Another option for preventing lost updates is to explicitly lock objects which are going to be updated. You may need to specify in your application's code through an ORM or directly in SQL that the rows returned from a query should be locked.

**Automatically detecting lost updates**

One alternative is to allow concurrent cycles to execute in parallel and let the transaction manager detect a lost update. When a lost update is detected, the transaction can be aborted and it can be forced to retry its read-modify-write cycle. This approach has an advantage that the check for lost updates can be performed efficiently with snapshot isolation.

**Compare-and-set**

In databases which don't provide transactions, an atomic compare-and-set operation is usually found. What this means is that when an operation wants to update a value, it reads the previous value and only completes if the value at the time of the update is the same as the value it read earlier. This is safe as long as the database is not comparing the current value against an old snapshot.

**Conflict resolution and replication**

Locks and compare-and-set operations assume that there's a single up-to-date copy of the data. However, for databases with multi-leader or leaderless replication, there's no guarantee of a single up-to-date copy of data. A common approach in replicated databases is to allow concurrent writes create several conflicting versions of a value, and allow application code or special data structures to be used to resolve the conflicts.

#### Write Skew and Phantoms

To recap the two race conditions we have treated so far:

* Dirty Writes: The ability of one running transaction to overwrite an update made by another running, uncommitted transaction. If a transaction updates multiple objects, dirty writes can lead to a bad outcome. There's the car example in the book of Alice and Bob buying a car in different transactions and having to update the listings and invoices tables. If Alice writes to the listings table first and Bob overrides it, but Bob writes to the invoices table first and Alice overrides it, we'll have inconsistent records in our tables as the records for that car should have the same recipient.
* Lost Update: If two transactions happen concurrently and another commit firsts, the later one could overwrite an update made by the earlier transaction, which could lead to lost changes. E.g. Incrementing a counter.
* Write skew. Basically, if two transactions read from the same objects, and then update some of those objects, a write skew can occur.

  Imagine a scenario where two transactions running concurrently first make a query, and then update a database object based on the result of the first query. The operations performed by the transaction to commit first may render the result of the query invalid for the later transaction.

Serializable isolation helps to prevent this. However, if it's not available, one way of preventing this is to explicitly lock the rows that a transaction depends on. Unfortunately, if the original query returns no rows \(say it's checking for the absence of rows matching a condition\), we can't attach locks to anything.

Another example: If you're distributing students into the same class room and you want to make sure that no students with the same last name belong to the same class. Two concurrently executing transactions could first check that the condition is met, then insert separate rows for a surname. Of course, a simple solution to this is a uniqueness constraint. The effect, where a write in one transaction changes the result of a search query in another transaction, is called a phantom.

**Materializing Conflicts**

we can reduce the effect of phantoms by attaching locks to the rows used in a transaction. However, if there's no object to which we can attach the locks \(say if our initial query is searching for the absence of rows\), we can artificially introduce locks. The approach of taking a phantom and turning it into a lock conflict on a concrete set of rows introduced in the database is known as materializing conflicts.

## Serializability

Serializable isolation is regarded as the strongest isolation level. It guarantees that even though transactions may execute in parallel, the end result will be as if they executed one at a time, without any concurrency. Most databases use of the following three techniques for serializable isolation, which we will explore next:

* Actual serial execution i.e. literally executing transactions in a serial order.
* Two-phase locking
* Serializable snapshot isolation

### Actual Serial Execution

The simplest way to avoid concurrency issues is by removing concurrency entirely, and making sure transactions are executed in serial order, on a single thread. This approach for serial transaction execution is implemented in Redis.

**Encapsulating transactions in stored procedures**

1. Transactions are typically executed in a client/server style, one statement at a time.
2. a lot of time is spent in network communication between the application and the database.
3. all the requests in a transaction must be submitted at the same time as a stored procedure. With this approach, there's only one network hop instead of having multiple.
4. Stored procedures and in-memory data make executing transactions on a single thread become feasible.

**Partitioning**

1. If we can partition the data so that each transaction only needs to read and write data within a single partition, then each partition can have its own transaction processing thread running independently from the others.
2. This will likely involve some cross-partition coordination though, especially in the presence of secondary indexes. Cross-partition coordination has much less throughput than single partitions.

**Summary of serial execution**

* It requires that each transaction is small and fast, else one slow transaction can stall all transaction processing.
* A transaction that needs to access data not in memory can slow down processing.
* Write throughput must be low enough to be handled on a CPU core, or else transactions need to be partitioned without requiring cross-partition coordination.

### Two-Phase Locking \(2PL\)

The key ideas behind two-phase locking are these:

* A transaction cannot write a value that has been read by another transaction.
* A transaction cannot read a value that has been written by another transaction. It must wait till the other transaction commits or aborts.

**Implementation of two-phase locking**

* The blocking of readers and writers is implemented by having a lock on each object used in a transaction. 
* The lock can either be in shared mode or in exclusive mode. The lock is used as follows:
  * When a transaction wants to read an object, it must first acquire a shared mode lock. Multiple read-only transactions can share the lock on an object.
  * When a transaction wants to write an object, it must acquire an exclusive lock on that object.
  * If a transaction first reads and then writes to an object, it may upgrade its shared lock to an exclusive lock.
  * After a transaction has acquired the lock, it must continue to hold the lock until the end of the transaction.

**Two-phase origin**

* First phase is acquiring the locks, second phase is when all the locks are released.
* If an exclusive lock already exists on an object, a transaction which wants to acquire a shared mode lock must wait for the lock to be released.
* Since so many locks are in use, a deadlock can easily happen if transaction A is stuck waiting for transaction B to release its lock, and vice versa.

**Performance of two-phase locking**

* Transaction throughput and response times of queries are significantly worse under two-phase locking than under weak isolation.
* This is as a result of the overhead of acquiring and releasing locks, but more importantly due to reduced concurrency as some transactions have wait for the others to complete. 
* Deadlocks also occur more frequently here than in lock-based read committed isolation levels.

**Predicate Locks**

* The idea with predicate locks is to lock all the objects that meet a condition, even for objects that do not yet exist in the database.
* A condition is first run in a select query, and a predicate lock holds a lock on any objects that could meet that query.

**Index Range Locks**

* Predicate locks don't perform well, however, and checking for matching locks can become time consuming. Thus, most databases implement index-range locking.
* With index range locks, we don't just lock the objects which match a condition, we lock a bigger range of objects. For example, if an index is hit in the original query, we could lock any writes to that index entry, even if it doesn't match the condition.
* These are not as precise as predicate locks, but there's less overhead with checking for locks as more objects will be locked.

### Serializable Snapshot Isolation

**For Faster concurrency controls**

* It provides full serializability at only a small performance penalty compared to snapshot isolation.
* The main idea here is that instead of holding locks on transactions, it allows transactions to continue to execute as normal until the stage where the transaction is about to commit, when it then decides whether the transaction executed in a serializable manner. This approach is known as an **optimistic concurrency control technique**.
* Optimistic in this sense means that instead of blocking if something potentially dangerous happens, transactions continue anyway, in the hope that everything will be fine. If everything isn't fine, it's only controlled at the time the transactions want to commit, after which it will be aborted. **This approach differs from the pessimistic technique used in Two-phase locking**.
* Optimistic concurrency control is an old idea, but in the right conditions \(e.g. contention between transactions is not too high and there's enough spare capacity\), they tend to perform better than pessimistic ones.
* Based on snapshot isolation and obeys the rules that readers don’t block writers, and writers don't block readers. The main difference is that SSI adds an algorithm for detecting serialization conflicts among writes and determining which transactions to abort.

**Decisions based on an outdated premise**

With write skew in snapshot isolation, the recurring pattern was this: a transaction reads some data from the database, examines the result of the query and takes some action based on the result of that query. However, the result from the original query may no longer be valid as at the time the transaction commits, because the data may have been modified in the meantime. The database has to be able to detect situations in which a transaction may have acted on outdated premise and abort the transaction in that case. To do this, there are two cases to consider:

* Detecting reads of a stale MVCC object version \(uncommitted write occurred before the read\).
* Detecting writes that affect prior reads \(the write occurs after the read\).

Detecting stale MVCC reads Basically, with snapshot isolation, there can be multiple versions of an object. When a transaction reads from a consistent snapshot in an MVCC database, it ignores writes that were made by transactions that had not committed at the time the snapshot was taken. This means that if Transaction A reads a value when there are uncommitted writes by Transaction B to that value, and transaction B commits before transaction A, then Transaction A may have performed some operations as a result of that earlier read which is no longer valid. To prevent this anomaly, a database needs to keep track of transactions which ignore another transaction's writes due to MVCC visibility rules. When the transaction that performed the read wants to commit, the database checks whether any of the ignored writes have been committed. If so, the transaction must be aborted. Some of the reasons why it waits for the transaction to commit, rather than aborting a transaction when a stale read is detected are that:

* The reading transaction might be a read-only transaction, in which case there's no risk of a write skew. The database has no way of knowing whether the transaction will later perform a write.
* There's no guarantee that the transaction that performed the uncommitted write will actually commit, so the read may not be a stale one at the end.

  SSI avoids unnecessary aborts and thus preserves snapshot isolation's support for long-running reads from a consistent snapshot.

  Detecting writes that affect prior reads

  The key idea here is to keep track of which values \(for example, track the indexes\) have been read by what transactions. When a transaction writes to the database, it looks in the indexes for what other transactions have recently read the data. It then notifies the transactions that what they read may be out of date.

**Performance of serializable snapshot isolation**

**Performance advantages**

* The advantage that this has over two-phase locking that one transaction does not need to be blocked when waiting for locks held by another transaction.
* the advantage over serial execution that it is not limited to the throughput of a single CPU core.

