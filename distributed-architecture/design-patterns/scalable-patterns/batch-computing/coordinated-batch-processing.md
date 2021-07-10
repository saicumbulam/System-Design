# Coordinated Batch Processing

sometimes it is equallyimportant to pull multiple outputs back together in order togenerate some sort of aggregate output

![picture 19](../../../../.gitbook/assets/3c9d9bf441899e34b3d4e73d874db8f267925ef1bf5490f790678d76b5b681f1.png)

## Join

* Join is similar tojoining a thread. The basic idea is that all of the work is happening in parallel, but work items aren’t released out of the join until all ofthe work items that are processed in parallel are completed. This isalso generally known as barrier synchronization in concurrent programming
* Coordination through join ensures that no data is missing before some sort of aggregation phase is performed \(e.g., finding the sum of some value in a set\). The value of the join is that it ensures that all of the data in the set is present.
* The downside of the join pattern is that it requires that all data be processed by a previous stage before subsequent computation can begin. This reduces the parallelism that is possible in the batch workflow, and thus increases the overall latency of running the workflow.

![picture 20](../../../../.gitbook/assets/03ac770961d65a44517654baef73a05adcefa20c2fc7d52bdbc383934c5df957.png)

## Reducer

* the goal of reduce is not to wait until all data has been processed, but rather to optimistically merge together all of the parallel data items into a single comprehensive representation of the full set.
* With the reduce pattern, each step in the reduce merges several different outputs into a single output. This stage is called “reduce” because it reduces the total number of outputs. 
* Because the reduce phase operates on a range of input, and produces a similar output, the reduce phase can berepeated as many or as few times as necessary in order to successfully reduce the output down to a single output for the entire data set.

## An Image Tagging and Processing Pipeline

job of tagging and processing a set of images.Let us assume that we have a large collection of images of highways atrush hour, and we want to count both the numbers of cars, trucks, and motorcycles, as well as distribution of the colors of each of the cars

![picture 21](../../../../.gitbook/assets/e42b443dc64efa5e516bf509a8e43bfc6298ab214c0b567a59cf6bb6ce6ca679.png)

**Use cases for Count, sum and histogram can be calculated**

