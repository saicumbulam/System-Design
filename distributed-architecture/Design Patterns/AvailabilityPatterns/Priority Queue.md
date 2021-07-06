# What
Prioritize requests sent to services so that requests with a higher priority are received and processed more quickly than those with a lower priority.

# Why
prioritize specific requests. These requests should be processed earlier than lower priority requests that were sent previously by the application.

# How
![picture 39](../../images/913fea9558520695da0f0015ca53304e4576eaf1006b3c4ade9def6179301792.png)  
- some message queues support priority messaging. The application posting a message can assign a priority and the messages in the queue are automatically reordered so that those with a higher priority will be received before those with a lower priority.
- an alternative solution is to maintain a separate queue for each priority. The application is responsible for posting messages to the appropriate queue. Each queue can have a separate pool of consumers.

![picture 40](../../images/7d0e6890e6e3a98dda474c61f6dcd95eb6a15eff232d77f9688ce6f8f7f732c6.png)  

**Advantages:**
- It allows applications to meet business requirements that require prioritization of availability or performance.
- It can help to minimize operational costs. In the single queue approach, you can scale back the number of consumers if necessary. High priority messages will still be processed first (although possibly more slowly), and lower priority messages might be delayed for longer.
- The multiple message queue approach can help maximize application performance and scalability. vital tasks can be prioritized to be handled by receivers that run immediately while less important background tasks can be handled by receivers that are scheduled to run at less busy periods.


# When to use
- The system must handle multiple tasks that have different priorities.
- Different users or tenants should be served with different priority.

