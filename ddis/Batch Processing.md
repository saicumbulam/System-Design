- [Batch Process](#batch-process)
  - [What is service,batch and streams](#what-is-servicebatch-and-streams)
  - [Batch processing with Unix tools](#batch-processing-with-unix-tools)
    - [What are advantages in Unix Commands](#what-are-advantages-in-unix-commands)
  - [Map reduce and distributed filesystems](#map-reduce-and-distributed-filesystems)
    - [Advantages of Map reduce](#advantages-of-map-reduce)
    - [HDFS](#hdfs)
    - [Replication](#replication)
    - [Workflow](#workflow)
    - [Mapper and Reducer](#mapper-and-reducer)
    - [Computation near the data](#computation-near-the-data)
    - [How to configure Mapper and Reducer](#how-to-configure-mapper-and-reducer)
    - [How Sorting problem is handled](#how-sorting-problem-is-handled)
    - [What is Shuffling](#what-is-shuffling)
    - [Combining several files together Reducer](#combining-several-files-together-reducer)
    - [Workflow chaining](#workflow-chaining)
    - [DB reference for Map Reduce](#db-reference-for-map-reduce)
    - [Hot key problem handling](#hot-key-problem-handling)
    - [Resolution to Hot key](#resolution-to-hot-key)
    - [Where to use Map reduce](#where-to-use-map-reduce)
    - [Write batch output to databases](#write-batch-output-to-databases)
    - [Hadoop Maintaince Advantages](#hadoop-maintaince-advantages)
    - [Difference btw massively parallel processing (MPP) databases](#difference-btw-massively-parallel-processing-mpp-databases)
- [Beyond MapReduce](#beyond-mapreduce)
    - [materialisation disadvantages](#materialisation-disadvantages)
    - [Map reduce Alternatives](#map-reduce-alternatives)
  - [Graphs and iterative processing](#graphs-and-iterative-processing)
    - [Why use Graph](#why-use-graph)
    - [Graph communication](#graph-communication)
    - [Fault tolerance](#fault-tolerance)
# Batch Process

## What is service,batch and streams

- Service (online): waits for a request and sends back response as quicky
- Batch processing system (offline): takes a large amount of input data, runs a job to process it, and produces some output.
- Stream processing (near-real-time): Consumes input and produces outputs. A stream job operates on events shortly after they happen.

## Batch processing with Unix tools

### What are advantages in Unix Commands

- Unix commands automatically handle larger-than-memory datasets and automatically paralelizes sorting across multiple CPU cores.
- Programs must have the same data format to pass information to one another. In Unix, that interface is a file (file descriptor), an ordered sequence of bytes. By convention Unix programs treat this sequence of bytes as ASCII text.
- The unix approach works best if a program simply uses stdin and stdout. This allows a shell user to wire up the input and output in whatever way they want; the program doesn't know or care where the input is coming from and where the output is going to.

## Map reduce and distributed filesystems

### Advantages of Map reduce

- MapReduce job does not modify the input.

### HDFS

- MapReduce jobs read and write files on a distributed filesystem. In Hadoop, that filesystem is called HDFS (Hadoop Distributed File System).
- HDFS is based on the shared-nothing principe. Implemented by centralised storage appliance, often using custom hardware and special network infrastructure.
- HDFS consists of a daemon process running on each machine, exposing a network service that allows other nodes to access files stored on that machine. A central server called the NameNode keeps track of which file blocks are stored on which machine.

### Replication

File blocks are replicated on multiple machines. Replication may mean simply several copies of the same data on multiple machines, or an erasure coding scheme such as Reed-Solomon codes, which allow lost data to be recovered.

### Workflow

1. Read a set of input files, and break it up into records.
2. Call the mapper function to extract a key and value from each input record.
3. Sort all of the key-value pairs by key.
4. Call the reducer function to iterate over the sorted key-value pairs.

### Mapper and Reducer

**Mapper**: Called once for every input record, and its job is to extract the key and value from the input record.
**Reducer**: Takes the key-value pairs produced by the mappers, collects all the values belonging to the same key, and calls the reducer with an interator over that collection of vaues.

### Computation near the data

- The MapReduce scheduler tries to run each mapper on one of the machines that stores a replica of the input file, putting the computation near the data.

### How to configure Mapper and Reducer

- While the number of map tasks is determined by the number of input file blocks
- the number of reduce tasks is configured by the job author. To ensure that all key-value pairs with the same key end up in the same reducer, the framework uses a hash of the key.

### How Sorting problem is handled

- The dataset is likely too large to be sorted with a conventional sorting algorithm on a single machine. - Sorting is performed in stages.

### What is Shuffling

- Whenever a mapper finishes reading its input file and writing its sorted output files, the MapReduce scheduler notifies the reducers that they can start fetching the output files from that mapper.
- The reducers connect to each of the mappers and download the files of sorted key-value pairs for their partition. Partitioning by reducer, sorting and copying data partitions from mappers to reducers is called shuffle.

### Combining several files together Reducer

- The reduce task takes the files from the mappers and merges them together, preserving the sort order.

### Workflow chaining

- MapReduce jobs can be chained together into workflows, the output of one job becomes the input to the next job.
- In Hadoop this chaining is done implicitly by directory name: the first job writes its output to a designated directory in HDFS, the second job reads that same directory name as its input.

### DB reference for Map Reduce

- It is common in datasets for one record to have an association with another record: a foreign key in a relational model, a document reference in a document model, or an edge in graph model.
- If the query involves joins, it may require multiple index lookpus. MapReduce has no concept of indexes.
- When a MapReduce job is given a set of files as input, it reads the entire content of all of those files, like a **full** **table** **scan**.
- In analytics it is common to want to calculate aggregates over a large number of records. Scanning the entire input might be quite reasonable.
- Requests over the network are too slow and nondeterministic. Other databases could be prohibitive.
- A better approach is to take a copy of the data and put it in the same distributed filesystem.

### Hot key problem handling

- In an example of a social network, small number of celebrities may have many millions of followers. Such disproportionately active database records are known as linchpin objects or hot keys.
- A single reducer can lead to significant skew that is, one reducer that must process significantly more records than the others.

### Resolution to Hot key

- The **skewed join method in Pig first** runs a sampling job to determine which keys are hot and then records related to the hot key need to be replicated to all reducers handling that key.
- Handling the hot key over several reducers is called **shared join method**.
- **Hive's skewed join** optimisation requires hot keys to be specified explicitly and it uses map-side join. If you can make certain assumptions about your input data, it is possible to make joins faster.

### Where to use Map reduce

- Google's uses to build indexes for its search engine.
- Hadoop MapReduce remains a good way of building indexes for Lucene/Solr. If you need to perform a full-text search, a batch process is very effective way of building indexes: the mappers partition the set of documents as needed, each reducer builds the index for its partition, and the index files are written to the distributed filesystem. It pararellises very well.
- Machine learning systems such as clasifiers and recommendation systems are a common use for batch processing.
- MapReduce is more appropriate for larger jobs. At Google, a MapReduce task that runs for an hour has an approximately 5% risk of being terminated to make space for higher-priority process.
- That is why MapReduce is designed to tolerate frequent unexpected task termination.

### Write batch output to databases

- Writing from the batch job directly to the database server is a bad idea:
- Making a network request for every single record is magnitude slower than the normal throughput of a batch task.
- Mappers or reducers concurrently write to the same output database an it can be easily overwhelmed.
- You have to worry about the results from partially completed jobs being visible to other systems.
A much better solution is to build a brand-new database inside the batch job an write it as files to the job's output directory, so it can be loaded in bulk into servers that handle read-only queries.
- Various key-value stores support building database files in MapReduce including Voldemort, Terrapin, ElephanDB and HBase bulk loading.

### Hadoop Maintaince Advantages

- By treating inputs as immutable and avoiding side effects become much easier to maintain.
- Design principles that worked well for Unix also seem to be working well for Hadoop.

### Difference btw massively parallel processing (MPP) databases

- MPP databases focus on parallel execution of analytic SQL queries on a cluster of machines, while the combination of MapReduce like a general-purpose operating system that can run arbitraty programs.
- Hadoop opened up the possibility of indiscriminately dumping data into HDFS. MPP databases typically require careful upfront modeling of the data and query patterns before importing data into the database's proprietary storage format.
- If a node crashes while a query is executing, most MPP databases abort the entire query. MPP databases also prefer to keep as much data as possible in memory.
MapReduce can tolerate the failure of a map or reduce task without it affecting the job. It is also very eager to write data to disk, partly for fault tolerance, and partly because the dataset might not fit in memory anyway.

# Beyond MapReduce

### materialisation disadvantages

- The process of writing out the intermediate state to files is called materialisation.
MapReduce's approach of fully materialising state has some downsides compared to Unix pipes:
  - A MapReduce job can only start when all tasks in the preceding jobs have completed.
  - Mappers are often redundant: they just read back the same file that was just written by a reducer.
  - Files are replicated across several nodes, which is often overkill for such temporary data.

### Map reduce Alternatives

- Spark, Tez and Flink. These new ones can handle an entire workflow as one job, rather than breaking it up into independent subjobs.
- They are assembled in flexible ways, in functions called operators.
- Spark, Flink, and Tex avoid writing intermediate state to HDFS, so they take a different approach to tolerating faults: if a machine fails and the intermediate state on that machine is lost, it is recomputed from other data that is still available.
- The framework must keep track of how a given piece of data was computed. Spark uses the resilient distributed dataset (RDD) to track ancestry data.
  
## Graphs and iterative processing

### Why use Graph

- Used to perform some kind of offline processing or analysis on an entire graph. This need often arises in machine learning applications such as recommednation engines, or in ranking systems.

- "repeating until done" cannot be expressed in plain MapReduce as it runs in a single pass over the data and some extra trickery is necessary.

- An optimisation for batch processing graphs, the bulk synchronous parallel (BSP) has become popular. It is implemented by Apache Giraph, Spark's GraphX API, and Flink's Gelly API (_Pregel model, as Google Pregel paper popularised it).

### Graph communication

- One vertex can "send a message" to another vertex, and typically those messages are sent along the edges in a graph.
- The fact that vertices can only communicate by message passing helps improve the performance of Pregel jobs, since messages can be batched.

### Fault tolerance

- Fault tolerance is achieved by periodically checkpointing the state of all vertices at the end of an interation.
- Graph algorithms often have a lot of cross-machine communication overhead, and the intermediate state is often bigger than the original graph.
- If your graph can fit into memory on a single computer, it's quite likely that a single-machine algorithm will outperform a distributed batch process. If the graph is too big to fit on a single machine, a distributed approach such as Pregel is unavoidable.
