package Threads;

class OrderedPrintingExecutor {

    int count;

    public OrderedPrintingExecutor() {
        count = 1;
    }

    public void printFirst() throws InterruptedException {
        //this is a reference to the current object
        //  synchronized block in Java is synchronized
        //  on some object. All synchronized
        //  blocks synchronized on the same
        //  object can only have one thread
        //  executing inside them at a time.
        //  All other threads attempting to enter
        //  the synchronized block are blocked until
        //  the thread inside the synchronized
        //  block exits the block.
        synchronized(this){
            System.out.println("First");
            count++;
            this.notifyAll();
        }
    }

    public void printSecond() throws InterruptedException {

        synchronized(this){
            while(count != 2){
                this.wait();
            }
            System.out.println("Second");
            count++;
            this.notifyAll();
        }

    }

    public void printThird() throws InterruptedException {

        synchronized(this){
            while(count != 3){
                this.wait();
            }
            System.out.println("Third");
        }

    }
}

class driver extends Thread
{
    private OrderedPrintingExecutor obj;
    private String method;

    public driver(OrderedPrintingExecutor obj, String method)
    {
        this.method = method;
        this.obj = obj;
    }

    public void run()
    {
        //for printing "First"
        if ("first".equals(method))
        {
            try
            {
                obj.printFirst();
            }
            catch(InterruptedException e)
            {

            }
        }
        //for printing "Second"
        else if ("second".equals(method))
        {
            try
            {
                obj.printSecond();
            }
            catch(InterruptedException e)
            {

            }
        }
        //for printing "Third"
        else if ("third".equals(method))
        {
            try
            {
                obj.printThird();
            }
            catch(InterruptedException e)
            {

            }
        }
    }
}

class OrderedPrinting
{
    public static void main(String[] args)
    {
        OrderedPrintingExecutor obj = new OrderedPrintingExecutor();

        driver t1 = new driver(obj, "first");
        driver t2 = new driver(obj, "second");
        driver t3 = new driver(obj, "third");

        t2.start();
        t3.start();
        t1.start();

    }
}
