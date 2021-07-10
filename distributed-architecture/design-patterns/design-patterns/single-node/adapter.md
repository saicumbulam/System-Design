# Adapter pattern

* adapter container is used to modify the interface of the application container so that it conforms to some predefined interface that is expected of all applications. For example, an adapter might ensure that an application implements a consistent monitoring interface Or it might ensure that log files are always written to stdout or anynumber of other conventions.
* When each application provides metrics using a different format and interface, it is very difficult to collect all of those metrics in a single place for visualization andalerting.

  ![picture 6](https://github.com/saicumbulam/System-Design/tree/2cc287ddf42889996c219c060e35761157fcfcd8/distributed-architecture/images/e89ed8ac9f273c72a640c9b3130a8a313a3e1206adc33f9d7fd13d3f051c5d50.png)

