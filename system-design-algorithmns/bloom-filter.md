# Bloom Filter

 A Bloom filter is a memory-efficient, probabilistic data structure that we can use to answer the question of **whether or not a given element is in a set**.



**What to expect from a Bloom filter?**

1. When a Bloom filter says an element is **not present** it is **for sure not present**. It guarantees 100% that the given element is not available in the set, because either of the bit of index given by hash functions will be set to 0.
2. But when Bloom filter says the given element is **present** it is **not 100% sure**, because there may be a chance due to collision all the bit of index given by hash functions has been set to 1 by other inputs.



**How to get 100% accurate result from a Bloom filter?**  
Well, this could be achieved only by taking more number of hash functions. **The more number of the hash function we take, the more accurate result we get, because of lesser chances of a collision.**

**Time and Space complexity of a Bloom filter**  
Suppose we have around **40 million data sets** and we are using around **H hash functions**, then:

> **Time complexity: O\(H\)**, where H is the number of hash functions used  
> **Space complexity: 159 Mb** \(For 40 million data sets\)  
> **Case of False positive: 1 mistake per 10 million** \(for H = 23\)



![](../.gitbook/assets/image%20%289%29.png)



```python
class BloomFilter:
    def __init__(self, n = 1000, k = 3):
        self.array = [False]*n
        self.hash_algo = [hashlib.md5,
                          hashlib.sha1,
                          hashlib.sha256,
                          hashlib.sha384,
                          hashlib.sha512]
        self.hashes = [self._get_hash(f) for f in self.hash_algo[:3]]

    def _get_hash(self, f):
        #convert value to proper string and calculate hash
        def hash_function(value):
            # string converted value
            # digest of the concatenation of the data fed
            h = f(str(value).encode('utf-8')).hexdigest()
            # convert string to number
            return int(h,16)%len(self.array)
        return hash_function

    def add(self, value):
        for h in self.hashes:
            v = h(value)
            self.array[v] = True

    def check(self, value):
        for h in self.hashes:
            v = h(value)
            if not self.array[v]: return False
        return True
```

