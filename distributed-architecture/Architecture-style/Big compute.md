![picture 10](../../images/5bb2d1440118f13058eb2528ac8fba7a63ce6ec570aad06137265e0441f5aa95.png)  

**Description:**
The work can be split into discrete tasks, which can be run across many cores simultaneously.
Each task is finite. It takes some input, does some processing, and produces output. The entire application runs for a finite amount of time (minutes to days). A common pattern is to provision a large number of cores in a burst, and then spin down to zero once the application completes.
For some applications, tasks are independent and can run in parallel. In other cases, tasks are tightly coupled, meaning they must interact or exchange intermediate results. 
Depending on your workload, you might use compute-intensive VM sizes


When to use this architecture

    Computationally intensive operations such as simulation and number crunching.
    Simulations that are computationally intensive and must be split across CPUs in multiple computers (10-1000s).
    Simulations that require too much memory for one computer, and must be split across multiple computers.
    Long-running computations that would take too long to complete on a single computer.
    Smaller computations that must be run 100s or 1000s of times, such as Monte Carlo simulations.

Benefits

    High performance with "embarrassingly parallel" processing.
    Can harness hundreds or thousands of computer cores to solve large problems faster.
    Access to specialized high-performance hardware, with dedicated high-speed InfiniBand networks.
    You can provision VMs as needed to do work, and then tear them down.

Challenges

    Managing the VM infrastructure.
    Managing the volume of number crunching
    Provisioning thousands of cores in a timely manner.
    For tightly coupled tasks, adding more cores can have diminishing returns. You may need to experiment to find the optimum number of cores.
