# Gateway Aggregation

* Use a gateway to aggregate multiple individual requests into a single request.
* A client needs to communicate with multiple backend services to perform an operation.
* The client may use networks with significant latency, such as cellular networks.





#### How

* Use a gateway to reduce chattiness between the client and the services. 
* The gateway receives client requests, dispatches requests to the various backend systems, and then aggregates the results and sends them back to the requesting client.
* This pattern can reduce the number of requests that the application makes to backend services, and improve application performance over high-latency networks.

![](../../../.gitbook/assets/image%20%281%29.png)

