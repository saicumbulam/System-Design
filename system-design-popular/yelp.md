# Yelp

service will be storing diofferent places information and the system will store them

## Requirements

### Functional requirements

* Users should be able to add/delete/update Places.
* users should be able to find all nearby places within a given radius.
* Users should be able to add feedback/review about a place. The feedback can have pictures, text, and a rating.

### Non-Functional requirements

* Users should have a real-time search experience with minimum latency.
* Our service should support a heavy search load. 

## Main questions to answer

* Effective data structure/ algorithm to achieve it
* DB technology
* Architecture layout to scale the application
* Frontend scalability and backend scalability

## Data Models

* Entities =&gt; places, users, comments
* places =&gt; lat,lon, place name, place id, pictures
* users =&gt; name, userid, address
* comments =&gt; place id, user comments, rating

## Approaches and High level design

* Api request to server. Server will consult the database/backend-servers to get the nearby places
* 
## Back of the envelope estimation. \(Should be always at the last so we can determine the correct memory usage\)

* How many places =&gt; 500M places
* How many requests coming \(DAU\) =&gt; 1 billion

### Insights

* read to write ratio is 100:1.  More load on reading the data
* Storage capacity needed for 5 years:
  * each place size =&gt; 

    lat = 8

    lon = 8

    place name = 100

    place id = 20

    rating = 4

    total =&gt; 140. 

    storage consumed =&gt; 140  _500_  100,0000 = 70 \* 10^9 = 70GB

    for 5 years =&gt; 70\* 2000\(5 years \# days\) = 140 TB  
* Bandwidth required

  read requestes =&gt; 1 \* 10^9 =&gt; per second = \(10^9\)/100,000 = 10^4 = 10,000 RPS

  bandwidth consumed =&gt; 140 \* 10,000 = 1000, 000 =&gt; 1MB/sec

## Best Architecture pattern:

Scatter and gatter pattern. Simlar to distributed document search. Send the request to multiple systems having each locations stored and they all return a matching place.

* How do you handle staggering problem ? =&gt; make the request to slow 
* How to search faster ?

