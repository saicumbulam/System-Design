- [Encoding and Evolution](#encoding-and-evolution)
  - [Evolvability](#evolvability)
  - [Rolling upgrade](#rolling-upgrade)
  - [Formats for Encoding Data](#formats-for-encoding-data)
    - [Programs working with data](#programs-working-with-data)
    - [Translation between the two representation](#translation-between-the-two-representation)
    - [Language-Specific Formats](#language-specific-formats)
      - [Problems in Language-Specific Formats](#problems-in-language-specific-formats)
  - [JSON, XML, and Binary Variants](#json-xml-and-binary-variants)
    - [Different formats](#different-formats)
    - [Problems with XML](#problems-with-xml)
    - [Binary Encoding](#binary-encoding)
      - [Why data formats are so important in Big data](#why-data-formats-are-so-important-in-big-data)
      - [Different Binary Encodings](#different-binary-encodings)
      - [BSON](#bson)
      - [Thrift](#thrift)
      - [Avro](#avro)
  - [Modes of Dataflow](#modes-of-dataflow)
  - [Dataflow Through Databases](#dataflow-through-databases)
    - [Schema evolution support](#schema-evolution-support)
  - [Dataflow Through Services: REST and RPC](#dataflow-through-services-rest-and-rpc)
    - [REST](#rest)
    - [Service-oriented architecture (SOA)](#service-oriented-architecture-soa)
    - [Web Services](#web-services)
    - [RPC](#rpc)
      - [RPC calls vs Network](#rpc-calls-vs-network)
      - [RPC problems](#rpc-problems)
      - [How exactly do RPCs differ from REST? Is it just the way the endpoints look?](#how-exactly-do-rpcs-differ-from-rest-is-it-just-the-way-the-endpoints-look)
  - [Message-Passing Dataflow](#message-passing-dataflow)
    - [Asynchronous message-passing](#asynchronous-message-passing)
    - [Message brokers](#message-brokers)
  - [Distributed actor frameworks](#distributed-actor-frameworks)
    - [Popular distributed actor frameworks are:](#popular-distributed-actor-frameworks-are)

# Encoding and Evolution

## Evolvability

Evolvability: Systems that make it easy to adapt to change

## Rolling upgrade

- Rolling upgrade: Deploying a new version to a few nodes at a time, checking whether the new version is running smoothly, and gradually working your way through all the nodes.
- new and old versions of the code, and old and new data formats may potentially all coexist in the system at the same time. For a system to run smoothly, compatibility needs to be in both directions.

**Backward Compatibility**

- Newer code can read data that was written by older code. Simpler to achieve.

**Forward Compatibility**

- Older code can read data written by newer code. 
- This is trickier because it requires older code to ignore additions made by a newer.

## Formats for Encoding Data

### Programs working with data

Programs work with data that have at least 2 different representations:
• **In memory data structures**: optimized for efficient access and CPU manipulation
• **Sequence of bytes** (e.g. JSON) for transmitting over the network.

### Translation between the two representation

**Encoding/Serialization/Marshalling** - Translation from in-memory representation to a byte sequence.
**Decoding/ Deserialization** - Byte sequence to in-memory representation.

### Language-Specific Formats

- Different programming languages have their built-in support for encoding.
  - Java has Serializable, Ruby has Marshal and so on.

#### Problems in Language-Specific Formats

- The encoding is tied to a particular programming language, and reading the data in another language is difficult.
- Versioning problems. They often neglect the problems of backward and forward compatibility.
- Less Efficiency. Java's serialization is notorious for bad performance.

## JSON, XML, and Binary Variants

### Different formats

- JSON, XML, CSV are the contenders for standard encodings.

### Problems with XML

- XML is often criticized for its verbose syntax.
- There's ambiguity around how numbers are encoded. In XML and CSV, there's no distinction between a number and a string.
- JSON distinguishes both, but does not distinguish integers and floating-point numbers, and does not specify a precision.
- No support for binary strings (sequences of bytes without a character encoding)

### Binary Encoding

#### Why data formats are so important in Big data

- The choice of data format can have a big impact especially when the dataset is in the order of terabytes.

#### Different Binary Encodings

Binary encodings for JSON (BSON, BJSON, etc) and XML (WBXML, etc).

#### BSON

BSON is used as the primary data representation in MongoDB for example.

#### Thrift

Thrift and Protocol Buffers: These are binary encoding libraries. Protocol Buffers were developed at Google, while Thrift was developed at Facebook.

#### Avro

Avro: Another binary encoding format different from the two above. This started out as a sub project of Hadoop.

## Modes of Dataflow
## Dataflow Through Databases

- The process that writes to a **database encodes the data, while the process the reads from it decodes** it. It could be the same process doing both, or different processes.
- **Forward compatibility is required in databases**: If different processes are accessing the database, and one of the processes is from a newer version of the application ( say during a rolling upgrade), the newer code might write a value to the database.
- We also need **backward compatibility** so that code from a newer version of the app can read data written by an older version.

### Schema evolution support

Avro has sophisticated schema evolution rules that can allow a database to appear as if was encoded with a single schema, even though the underlying storage may contain records encoded with previous schema versions.

## Dataflow Through Services: REST and RPC

### REST

- Communication between processes over a network, a common arrangement is to have two roles: clients (e.g. web browser) and servers.
- The server typically exposes an API over the network for
the client to make requests.
- This API is known as a service.
- A server can also be a client to another service. E.g. a web app server is usually a client to a database.

### Service-oriented architecture (SOA)

- Decomposing a large application into smaller components by area of functionality.

### Web Services

- If a service is communicated with using HTTP as the underlying protocol, it is called a web service. Two approaches to web services are **REST and SOAP** (Simple Object Access Protocol).

### RPC

- The RPC model tries to make a request to a remote network look the same as calling a function or method, within the same process.
- It uses Location transparency - In computer networks, location transparency is the use of names to identify network resources, rather than their actual location).

#### RPC calls vs Network

- A local function call is predictable and succeeds or fails depending on parameters under the control. A network call is unpredictable - the request or response packets can get lost, the remote machine may be slow etc.
• A local function call either returns a result, or throws an exception, or never returns (infinite loop). A network request has another possible outcome, it may return without a result, due to a timeout. There's no way of knowing whether the request got through or not.
• **Retrying a failed network request could cause the action to be performed multiple times if the request actually got through, but the response was lost. Building a system for idempotence could prevent this though.**

#### RPC problems

- The client and service may be implemented in different languages, so the RPC library would need to translate datatypes from one language to another.

#### How exactly do RPCs differ from REST? Is it just the way the endpoints look?

## Message-Passing Dataflow

### Asynchronous message-passing

- Asynchronous message-passing systems are somewhere between RPC and databases.
- Similar to RPCs because a client's request is delivered to another process with low latency.
- Similar to databases in that a message is not sent via a direct network connection, but via an intermediary called a message broker or message queue.

**Advantages of a message broker**

- It can act as a buffer if the recipient is down or unable to receive messages due to overloading.
- The sender can act without knowing the IP address and port number of the recipient
- A message can be delivered to multiple recipients.
- It can retry message delivering to a crashed process and prevent lost messages.
- It decouples the sender from the recipient.
- the sender does not wait for the message to be delivered, but simply sends it and forgets about it.

### Message brokers

- A process sends a message to a named queue or topic
- The broker ensures that the message is delivered to one or more consumers or subscribers to that queue or topic.
- A topic can have many producers and many consumers.

## Distributed actor frameworks

- The actor model is a programming model for concurrency in a single process.
- Each part of the system is represented as an actor. An actor is usually a client or an entity which communicates with other actors by sending and receiving asynchronous messages.

- In distributed actor frameworks, this model is especially useful for scaling an application across multiple nodes as the same message-passing mechanism is used, regardless of whether the sender and recipient are on the same or different nodes.

### Popular distributed actor frameworks are:

• Akka
• Orleans
• Erlang OTP
