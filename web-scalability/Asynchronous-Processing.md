## Core Concepts

Synchronous Processing

- The caller sends a request to get something done and waits for the response before continuing its own work.
- Blocking occurs when your code has to wait for an external operation to finish
- *Blocking I/O* means blocking input/output. This term is used to describe blocking read and write operations on resources like hard drives
- Blocked threads consume resources without making progress
- The more blocking operations you perform, the slower your system becomes, as all this execution time adds up

Asynchronous Example

- Issuing requests that do not block your execution.
- A callback is a construct of asynchronous processing where the caller does not block while waiting for the result of the operation, but provides a mechanism to be notified once the operation is finished. A callback is a function, an object, or an endpoint that gets invoked whenever the asynchronous call is completed.

![image-20210717071346376](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210717071346376.png)

- *Nonblocking I/O* refers to input/output operations that do not block the client code’s  execution. When using nonblocking I/O libraries, your code does not wait while you read data from disk or write to a network socket

  ![image-20210717071442957](C:\Users\sadithya\Documents\System-Design\image-20210717071442957.png)

## Message Queues

- Message queues are a great tool for achieving asynchronous processing 
- A *message queue* is a component that buffers and distributes asynchronous requests

![image-20210717072105392](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210717072105392.png)



- The separation of producers and consumers  using a queue gives us the benefit of nonblocking communication between  producer and consumer

### Message routing methods

- Below routing model is well suited for the distribution of time-consuming tasks across multiple worker machines. 



## 

![image-20210717072330224](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210717072330224.png)



- Below routing model is to publish a message for every purchase. Your e-commerce application  could publish a message to a topic each time a purchase is confirmed.  Then you could create multiple consumers performing different actions  whenever a purchase message is published. You could have a consumer that notifies shipping providers and a different consumer that processes  loyalty program rules and allocates reward points. 

![image-20210717072531078](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210717072531078.png)



- Custom routing

  ![image-20210717072609456](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210717072609456.png)

- 

## Benefits of Message Queues

Enabling Asynchronous Processing
Easier Scalability
Evening Out Traffic Spikes
Isolating Failures and Self-Healing
Decoupling



## Message Queue–Related Challenges

No Message Ordering
Message Requeueing
Race Conditions Become More Likely
Risk of Increased Complexity



## Message Queue–Related Anti-Patterns



Treating the Message Queue as a TCP Socket
Treating Message Queue as a Database
Coupling Message Producers with Consumers
Lack of Poison Message Handling

## Comparison of Selected Messaging Platforms

Amazon Simple Queue Service
RabbitMQ
ActiveMQ

-  neither ActiveMQ nor RabbitMQ supports horizontal scalability 
- use SQS, you should be able to publish tens of thousands of messages per second, per queue,
- SQS does not preserve message ordering and has very few advanced features,
-  high-availability focus and how they handle extreme conditions. In this comparison, ActiveMQ scores the worst of all three system

