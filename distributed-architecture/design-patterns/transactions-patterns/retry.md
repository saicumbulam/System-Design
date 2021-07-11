# Retry

Enable an application to handle transient failures when it tries to connect to a service or network resource, by transparently retrying a failed operation.

#### How

The following  strategies of retries:

* **Cancel**. If the fault indicates that the failure isn't transient or is unlikely to be successful if repeated, the application should cancel the operation and report an exception. 
* **Retry**. If the specific fault reported is unusual or rare, it might have been caused by unusual circumstances. In this case, the application could retry the failing request again immediately because the same failure is unlikely to be repeated and the request will probably be successful.
* **Retry after delay**. If the fault is caused by one of the more commonplace connectivity or busy failures, the network or service might need a short period while the connectivity issues are corrected or the backlog of work is cleared. The application should wait for a suitable time before retrying the request.

![](../../../.gitbook/assets/image%20%288%29.png)

