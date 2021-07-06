# What
Implement functional checks in an application that external tools can access through exposed endpoints at regular intervals. This verify that applications and services are performing correctly.

# Why
monitor web applications and back-end services, to ensure they're available and performing correctly. 
# How
Implement health monitoring by sending requests to an endpoint on the application. The application should perform the necessary checks, and return an indication of its status.

A health monitoring check typically combines two factors:

    The checks (if any) performed by the application or service in response to the request to the health verification endpoint.
    Analysis of the results by the tool or framework that performs the health verification check.

The response code indicates the status of the application and, optionally, any components or services it uses. The latency or response time check is performed by the monitoring tool or framework.

![picture 46](../../images/24e9de079f6f9f6047a7f485ad255f4dbc5691da68c85d680a52a3ca67915142.png)  

Typical checks that can be performed by the monitoring tools include:

    Validating the response code. For example, an HTTP response of 200 (OK) indicates that the application responded without error. The monitoring system might also check for other response codes to give more comprehensive results.
    Checking the content of the response to detect errors, even when a 200 (OK) status code is returned. This can detect errors that affect only a section of the returned web page or service response. For example, checking the title of a page or looking for a specific phrase that indicates the correct page was returned.
    Measuring the response time, which indicates a combination of the network latency and the time that the application took to execute the request. An increasing value can indicate an emerging problem with the application or network.
    Checking resources or services located outside the application, such as a content delivery network used by the application to deliver content from global caches.
    Checking for expiration of SSL certificates.
    Measuring the response time of a DNS lookup for the URL of the application to measure DNS latency and DNS failures.
    Validating the URL returned by the DNS lookup to ensure correct entries. This can help to avoid malicious request redirection through a successful attack on the DNS server.


# When to use
Monitoring websites and web applications to verify availability.
Monitoring websites and web applications to check for correct operation.
Monitoring middle-tier or shared services to detect and isolate a failure that could disrupt other applications.
  
# Example