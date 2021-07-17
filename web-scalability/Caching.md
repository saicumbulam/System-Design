## Cache Hit Ratio

- cache effectiveness depends on how many times you can reuse the same cached response, 

- Factors affecting cache:

  - Cache keyspace. Each object in the cache is identified by its cache key, and the only way to locate an object is by performing an  exact match on the cache key.
  -  number of items that you can store in your cache before running out of space. 
  - how long, on average, each object can be  stored in cache before expiring or being invalidated. Usually, you can cache objects for a predefined amount of time called Time to  Live (TTL)

  - Use cases with a high ratio of reads to writes are usually good candidates for caching, as cached objects can be created once and stored for longer periods of time before expiring or becoming invalidated

Caching Based on HTTP

- *Read-through cache* is a caching component that can return cached resources or fetch the  data for the client, if the request cannot be satisfied from cache 

  ![image-20210717064341409](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210717064341409.png)

- Read-through caches are especially attractive because they are transparent to the client. Clients are not able to  distinguish whether they received a cached object or not.

![image-20210717064407656](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210717064407656.png)





![image-20210717065434460](C:\Users\sadithya\AppData\Roaming\Typora\typora-user-images\image-20210717065434460.png)







