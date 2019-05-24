# java-job_queue

**Problem Description**

There is a program which is parallelized and uses n independent threads to process the given list of m jobs. Threads take jobs in the order they are given in the input. If there is a free thread,it immediately takes the next job from the list. If a thread has started processing a job, it doesn’t interrupt or stop until it finishes processing the job. If several threads try to take jobs from the list simultaneously, the thread with smaller index takes the job. For each job it will be known exactly how long will it take any thread to process this job, and this time is the same for all the threads. Need to determine for each job which thread will process it and when will it start processing.

**Input Format**

The first line of the input contains integers n and m. The second line contains m integers— the times in seconds it takes any thread to process i-th job. The times are given in the same order as they are in the list from which threads take jobs. Threads are indexed starting from 0.

**Constraints**

1 ≤ n ≤ 10^3 ; 1 ≤ m ≤ 10^

**Output Format**

Output exactly m lines.i-th line (0-based index is used) should contain two space-separated integers — the 0-based index of the thread which will process the i-th job and the time in seconds when it will start processing that job.
