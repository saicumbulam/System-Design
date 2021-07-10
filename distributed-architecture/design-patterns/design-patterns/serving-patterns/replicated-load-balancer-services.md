# replicated load-balanced service.

every server is identical to every other server and all are capable of supporting traffic. The pattern consists of a scalable number of servers with a load balancer in front of them

## Stateless Services

* They don’t require saved state to operate correctly. Even individual requests may be routed to separate instances of the service ![picture 7](../../../../.gitbook/assets/91406b48557dcedada2f2b0461a98c21010e101ce2d3c676d86ae63e11854d6b.png)
* Horizontally scalable systems handle more and more users by adding more replicas

![picture 8](../../../../.gitbook/assets/0d666db331f80a579ab6234e7a751a9bda86726027d7cc9f9a615f9448172119.png)

## Readiness Probes for Load Balancing

* When designing a replicated service, it is equally important to 

  build and deploy a readiness probe to inform the load balancer.

* Readiness probe determines when an application is ready to serve user requests. The reason for the differentiationis 

  that  many applications require some time to become initialized before they are ready to serve. They may need to connect to databases,load plugins, or download serving files from the network. In all of thesecases, the containers are alive, but they are not ready. When building an application for a replicated service pattern, be sure toinclude a special URL that implements this readiness check.

## Session Tracked Services

* reasons for wanting to ensure that a particular user’s requests always end up on the same machine. Sometimes this is because you are caching that user’s data in memory, so landing on the same machine ensures a higher cache hit rate. Sometimes it is because the interaction is long-running in nature, so some amount of state is maintained between requests. 

![picture 1](../../../../.gitbook/assets/8ebe0a5be2fa14e08258e25b6bc0e065fe4a833163fe1a7d09ca41a34cdabf65.png)

Session tracking is accomplished via a consistent hashing function.

## Caching Layer

It might make queries to a database to service requestsor do a significant amount of rendering or data mixing toservice the request. In such a world, a caching layer can make a great deal of sense. A cache exists between your stateless application andthe end-user request.

![picture 2](../../../../.gitbook/assets/69d9471032bd863225a95495bc86f1d04a22ca1405bbce59ded3ac15214122b4.png)

Wrong method of deploying cache. Doesnt scale well. ![picture 3](../../../../.gitbook/assets/703ca33e07d388273b08908466676e54886504f951f49fafcbd10ae62333f5d8.png)

makes the most sense to configure your caching layer as a second stateless replicated serving tier ![picture 4](../../../../.gitbook/assets/ddc2596dd58aa459fa740a266cc9d64d4bab9a9bff73b1c1e1eaf9a1912e7aee.png)

### Expanding cache layer

* Varnishhas a throttle module that can be configured to provide throttlingbased on IP address and request path
* Add a third layer to our stateless application pattern,which will be a replicated layer of nginx servers that will handleSSL termination for HTTPS traffic and forward traffic on to ourVarnish cache. 

![picture 5](../../../../.gitbook/assets/ef28fc99a41560c78b890e4203e1c22a50d3fc5081af441b1cb94383678708f6.png)

