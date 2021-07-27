# Reliability, Scalability and Maintainability

3 concerns that are important in most software systems are:

* **Reliability**: The system should work correctly even in the face of adversity.
* **Scalability**: As the system grows there should be reasonable ways of dealing with that growth.
* **Maintainability**: People should be able to work on the system productively in the future.

## Reliability

Typical expectations for software to be termed as reliable are that:

* The application performs as expected.
* It can tolerate user mistakes or unexpected usage of the product.
* Performance is good enough for the required use case, under the expected load and data volume.
* The system prevents any unauthorized access and abuse.

### Fault tolerant

* A reliable system is fault-tolerant or resilient. Fault is different from failure. 
* A fault is one component of the system deviating from its spec, whereas a failure is when the system as a whole stops providing the required service to a user.
* It's impossible to reduce the probability of faults to zero, thus, it's useful to design fault-tolerance mechanisms that prevent faults from causing failures.

## Hardware Faults

* Dealing with hardware faults is to add redundancy to the individual hardware components so that if one fails, it can be replaced. RAID configuration.
* An advantage of these software fault-tolerant systems is that: For a single server system, it requires planned downtime if the machine needs to be rebooted \(e.g. to apply operating system security patches\). However for a system that can tolerate machine failure, it can be patched one node at a time \(without downtime of the entire system - a rolling upgrade\)

## Software Errors

* fault in one node is more likely to cause many more system failures than uncorrelated hardware failures.

  There is no quick solution to the problem of faults in software, however, different things can help such as:

* Thorough testing
* Process isolation
* Measuring, monitoring, and analyzing system behavior in production.

## Human Errors

Steps to reduce Human Errors

* Designing systems in a way that minimize opportunities for error through well-designed abstractions, APIs, and admin interfaces.
* Decoupling the places where people make the most mistakes from the places where they can cause failures. 
* Testing thoroughly at all levels: from unit tests to integration tests to manual tests to automated tests.
* Allow quick and easy recovery from human errors, to minimize the impact of failure. Eg: Roll backs
* Set up detailed and clear monitoring, such as performance metrics and error rates.

## Scalability

Scalability describes the ability to cope with increased load."

### Describing Load \(System design back of envelope estimation\)

Load can be described by the load parameters. The choice of parameters depends on the system architecture. It may be:

* Requests per second to a web server \(RPS\)
* Ratio of reads to writes in a database
* Number of simultaneously active users in a chat room \(Dau\)
* Hit rate on a cache.

**Twitter Case-study**

Twitter has two main operations:

* **Posting a tweet:**
* **Home timeline:**

**Twitter's scaling challenge**

* It is primarily due to fan-out. 
* For twitter, each user follows many people, and each user is followed by many people. 
* What is an optimal way of loading all the tweets of people followed by a user? Two operations could happen:
* Posting a tweet inserts the new tweet into a global collection of tweets. This collection could be a relational database which could then have billions of rows - not ideal.
* Maintain a cache for each user's home timeline - like a mailbox of tweets for each recipient user. When a user posts a tweet, look up all the people who follow the user, and insert the new tweet into each of their home timeline caches. Reading the home timeline is cheap.

**Approach 2 failed in Twitter** Twitter used the first approach initially but they now use approach 1. The downside to approach 2 is that posting a tweet requires a lot of extra work.

Note that Twitter is now implementing a hybrid of both approaches. For most users, tweets continue to be fanned out to home timelines at the time when they are posted. However, for a small number of users with millions of followers \(celebrities\), they are exempted from the fan out.

## Latency vs response time

**Response time** is what the client sees: besides the actual time to process a request\(service time\), it includes network delays and queuing delays. **Latency** is the duration that a request is waiting to be handled - during which it is latent, awaiting service.

* Response time can vary a lot, it is a distribution of values. 
* random additional latency could be introduced by a context switch on the background process, loss of a network packet and TCP retransmission, a garbage collection pause.

**Average Response time** of a service is often reported but it is not a very good metric if you want to know your "typical" response time, because it doesn't tell you how many users actually experienced that delay. A better approach is to use percentiles.

**Percentiles**

* If you take your list of response times and sort from fastest to slowest, then the median is the halfway point. Thus, median is a good metric if you want to know how long users typically wait. Median is known as the 50th percentile, and sometimes abbreviated as p50.
* Occasionally slow requests are known as outliers. In order to figure out how bad they are, you look at higher percentiles: 95th, 99th and 99.9th percentiles are common. These are the response time thresholds at which 95%, 99%, or 99.9% of requests are faster than that particular threshold. For example, if the 95th percentile response time is 1.5 seconds, it means 95 out of 100 requests take less than 1.5 seconds, and 5 out of 100 requests take 1.5 seconds or more.

High percentiles of response times \(**Tail latencies**\) are important because they directly impact a user's experience.

Percentiles are often used in SLOs \(Service Level Objectives\) and SLAs \(Service Level Agreements\). They set the expectations of a user, and a refund may be demanded if the expectation is not met.

**Causes of Tail Latencies**

* A large part of the response time at high percentiles can be accounted for by queuing delays. It basically refers to how a number of slow requests on the server-side can hold up the processing of subsequent requests. This effect is called **Head-of-Line blocking**.
* Those requests may be fast to process on the server, but the client will see a slow overall response time due to the time waiting for the prior request to complete. This is why it is important to measure response times on the client side. Basically, requests could be fast individually but one slow request could slow down all the other requests.

  **Tail latency amplification** It takes just one slow call to make the entire end-user request slow.

**Monitor response times** A good idea is to keep a rolling window of response times of requests in the last 10 minutes. So there could be a graph of the median and various percentiles over that window.

**Approaches for Coping with Load** An architecture that is appropriate for one level of load is unlikely to cope with 10 times that load. Different terms that come up for dealing with this include:

* vertical scaling
* horizontal scaling
* shared-nothing architecture.

## Maintainability

Design software in a way that it will minimize pain during maintenance, thereby avoiding the creation of legacy software by ourselves. Three design principles for software systems are:

**Operability:** Make it easy for operations teams to keep the system running smoothly.

**Simplicity** Make it easy for new engineers to understand the system, by removing as much complexity as possible from the system.

**Evolvability** Make it easy for engineers to make changes to the system in the future, adapting it for unanticipated use cases as requirements change.

**Operability:** Making Life Easy For Operations A system is said to have good operability if it makes routine tasks easy so that it allows the operations teams to focus their efforts on high-value activities.

**Steps for maintenability Enhancement** Data systems can do the following to make routine tasks easy e.g.

* Providing visibility into the runtime behavior and internals of the system, with good monitoring.
* Providing good support for automation and integration with standard tools.
* Providing good documentation and easy-to-understand operational model \("If I do X, Y will happen"\).
* Self-healing where appropriate, but also giving administrators manual control over the system state when needed.

## Simplicity: Managing Complexity

Reducing complexity improves software maintainability the functionality of a system, it can also mean reducing accidental complexity. Complexity is accidental if it is not inherent in the problem that the software solves \(as seen by the users\) but arises only from the implementation. **Abstraction** is one of the best tools that we have for dealing with accidental complexity. A good abstraction can hide a great deal of implementation detail behind a clean, simple-to-understand façade.

## Evolvability: Making Change Easy

System requirements change constantly and we must ensure that we're able to deal with those changes.

## Functional and non-functional requirements

An application has to meet .

* Functional - What is should do, such as allowing data to be stored, retrieved, searched, and processed in various ways.
* Nonfunctional - General properties like security, reliability, compliance, scalability, compatibility, and maintainability.

