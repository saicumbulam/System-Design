Implement health monitoring by sending requests to an endpoint on the application. The application should perform the necessary checks, and return an indication of its status.

A health monitoring check typically combines two factors:

1. The checks (if any) performed by the application or service in response to the request to the health verification endpoint.
2. Analysis of the results by the tool or framework that performs the health verification check.

The response code indicates the status of the application and, optionally, any components or services it uses. The latency or response time check is performed by the monitoring tool or framework.

# When to use
Monitoring websites and web applications to verify availability.