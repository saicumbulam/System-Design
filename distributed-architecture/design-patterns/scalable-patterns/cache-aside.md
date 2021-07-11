# Cache-Aside

* Load data on demand into a cache from a data store. This can improve performance and also helps to maintain consistency between data held in the cache and data in the underlying data store.
* A cache doesn't provide native read-through and write-through operations.
* Resource demand is unpredictable. This pattern enables applications to load data on demand. It makes no assumptions about which data an application will require in advance.

#### How

![](../../../.gitbook/assets/image%20%2814%29.png)

