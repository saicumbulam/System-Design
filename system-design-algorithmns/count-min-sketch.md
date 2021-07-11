# Count Min Sketch

* Count-min sketch algorithm talks about keeping track of the count of things. i.e, How many times an element is present in the set
* The **Count-min sketch** is a **probabilistic** **data structure**. The Count-Min sketch is a simple technique to summarize large amounts of frequency data

**The fewer hash functions we take there will be a high probability of collision**. Hence it always recommended taking more number of hash functions.   
**Applications of Count-min sketch:** 

* Stream Processing
* Frequency tracking
* Extension: Heavy-hitters
* Extension: Range-query

```java
class CountMinSketch

{

    private int[] h1;

    private int[] h2;

    private int[] h3;

    private int size;

    private static int DEFAULT_SIZE = 11;

 

    /** Constructor **/

    public CountMinSketch()

    {

        size = DEFAULT_SIZE;

        h1 = new int[ size ];

        h2 = new int[ size ];

        h3 = new int[ size ];

    }

    /** Function to clear al counters **/

    public void clear()

    {

        size = DEFAULT_SIZE;

        h1 = new int[ size ];

        h2 = new int[ size ];

        h3 = new int[ size ];

    }

    /** Function to insert value **/

    public void insert(int val)

    {

        int hash1 = hashFunc1(val);

        int hash2 = hashFunc2(val);

        int hash3 = hashFunc3(val);

        /** increment counters **/

        h1[ hash1 ]++;

        h2[ hash2 ]++;

        h3[ hash3 ]++;

    }

    /** Function to get sketch count **/

    public int sketchCount(int val)

    {

        int hash1 = hashFunc1(val);

        int hash2 = hashFunc2(val);

        int hash3 = hashFunc3(val);

        return min( h1[ hash1 ], h2[ hash2 ], h3[ hash3 ] );

    }

    /** Hash function 1 **/

    private int hashFunc1(int val)

    {

        return val % size;

    }

    /** Hash function 2 **/

    private int hashFunc2(int val)

    {

        return ((val * (val + 3)) % size);

    }

    /** Hash function 3 **/

    private int hashFunc3(int val)

    {

        return (size - 1) - val % size;

    }
}
```

![](../.gitbook/assets/image%20%286%29.png)

![](../.gitbook/assets/image%20%2812%29.png)

