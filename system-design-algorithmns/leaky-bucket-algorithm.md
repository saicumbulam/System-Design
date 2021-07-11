# Leaky bucket algorithm

* **Traffic Shaping** is a mechanism to control the amount and the rate of the traffic sent to the network

![](../.gitbook/assets/image%20%282%29.png)

```java
class Leakybucket {
    public static void main (String[] args) {
        //total no. of times bucket content is checked
        int no_of_queries = 4;
        
        //initial packets in the bucket
        int storage = 0;
        
        //no. of packets that exits the bucket at a time
        int output_pkt_size = 1;
        
         //no. of packets that enters the bucket at a time       
        int input_pkt_size = 4;
        
        //total no. of packets that can
        // be accommodated in the bucket        
        int bucket_size = 10;
        
        int size_left;
         
        for(int i=0;i<no_of_queries;i++)
        {
            size_left=bucket_size-storage; //space left
             
            if(input_pkt_size<=(size_left))        
            {
                storage+=input_pkt_size;
                System.out.println("Buffer size= "+storage+
                    " out of bucket size= "+bucket_size);
            }
            else
            {
                System.out.println("Packet loss = "
                            +(input_pkt_size-(size_left)));
                             
                     //full size      
                storage=bucket_size;
                 
                System.out.println("Buffer size= "+storage+
                            " out of bucket size= "+bucket_size);
                 
            }
            storage-=output_pkt_size;
        }
    }
}
```

![](../.gitbook/assets/image%20%285%29.png)

![](../.gitbook/assets/image%20%2813%29.png)

