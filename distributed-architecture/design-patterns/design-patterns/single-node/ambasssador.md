# ambassador pattern

* ambassador container brokers interactions between the application container and the rest of the world
* ambassador container canbe reused with a number of different application containers.

## Use cases

* When adapting an existing application to a sharded backend,you can introduce an ambassador container that contains all of the logic needed to route requests to the appropriate storageshard. Thus, your frontend or middleware application only connectsto what appears to be a single storage backend running on localhost.However, this server is in fact actually a sharding ambassador proxy,which receives all of the requests from your application code, sendsa request to the appropriate storage shard, and then returns theresult to your application.
* Building a portable application requires that the application know how to appropriate MySQL service to connect to. This process is called **service discovery**, and the system that performs this discovery and linking is commonly called a **service broker**.

![picture 5](https://github.com/saicumbulam/System-Design/tree/2cc287ddf42889996c219c060e35761157fcfcd8/distributed-architecture/images/070b00ec608172c64b9d7ff883181734a98d0fec8fa9e97437b8154b49406128.png)

