# What
Use a queue that acts as a buffer between a task and a service it invokes in order to smooth intermittent heavy loads that can cause the service to fail or the task to time out. This can help to minimize the impact of peaks in demand

# Why
A service might experience peaks in demand that cause it to overload and be unable to respond to requests in a timely manner. Flooding a service with a large number of concurrent requests can also result in the service failing if it's unable to handle the contention these requests cause.

# How
introduce a queue between the task and the service. The task and the service run asynchronously. The task posts a message containing the data required by the service to a queue. The queue acts as a buffer, storing the message until it's retrieved by the service. The service retrieves the messages from the queue and processes them.

![picture 42](../../images/8840c8f005ad2ce3fa9b7c0c5940610bec70ee3c278138699d165ba1bb8936c0.png)  

benefits:
- It can help to maximize availability because delays arising in services won't have an immediate and direct impact on the application, which can continue to post messages to the queue even when the service isn't available or isn't currently processing messages.
- maximize scalability because both the number of queues and the number of services can be varied to meet demand.
- It can help to control costs because the number of service instances deployed only have to be adequate to meet average load rather than the peak load.

# When to use
- This pattern is useful to any application that uses services that are subject to overloading.
- This pattern isn't useful if the application expects a response from the service with minimal latency.
  
# Example
![picture 43](../../images/2a4d186363259f536b2572e309d3065bd906e47abb0ebbce2518ca79b1f9d2e5.png)  
