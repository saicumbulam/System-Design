# What
The Bulkhead pattern is a type of application design that is tolerant of failure. In a bulkhead architecture, elements of an application are isolated into pools so that if one fails, the others will continue to function.


# Why
A large number of requests originating from one client may exhaust available resources in the service. Other consumers are no longer able to consume the service, causing a cascading failure effect.

# How
Partition service instances into different groups, based on consumer load and availability requirements. This design helps to isolate failures, and allows you to sustain service functionality for some consumers, even during a failure.

The following diagram shows bulkheads structured around connection pools that call individual services. If Service A fails or causes some other issue, the connection pool is isolated, so only workloads using the thread pool assigned to Service A are affected. Workloads that use Service B and C are not affected and can continue working without interruption.

![picture 45](../../images/c8fa6f4af58d0fc834cebe4d4e9f30ed60e87ff1e84c6a0d98267e13587a5eae.png)  

The benefits of this pattern include:

    Isolates consumers and services from cascading failures. 
    Allows you to preserve some functionality in the event of a service failure.
    Allows you to deploy services that offer a different quality of service for consuming applications. A high-priority consumer pool can be configured to use high-priority services.


# When to use
Use this pattern to:

    Isolate resources used to consume a set of backend services, especially if the application can provide some level of functionality even when one of the services is not responding.
    Isolate critical consumers from standard consumers.
    Protect the application from cascading failures.

This pattern may not be suitable when:

    Less efficient use of resources may not be acceptable in the project.
    The added complexity is not necessary

  