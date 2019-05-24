import java.io.*;
import java.util.*;

// Worker class to keep information of the threads

class Worker{
	
	int index;
	long nextFreeTime = 0;
	
	public Worker(int index) {
		
		this.index = index;
		
	}
	
	public String toString() {
		
		return String.valueOf(index);
		
	}
	
}

// Comparing Worker objects. First compare for nextFreeTimes and if they equal compare for indexes. 

class WorkerComparator implements Comparator<Worker> {
 
    public int compare(Worker this, Worker that) {
        
		if (this.nextFreeTime > that.nextFreeTime) {
            return 1;
        } 
		else if (this.nextFreeTime < that.nextFreeTime) {
            return -1;
        } 
		else {
            if (this.index > that.index) {
                return 1;
            } 
			else if (this.index < that.index) {
                return -1;
            } 
			else {
                return 0;
            }
        }
    }

}

public class main {
		
		private int numWorkers;
		private long numJobs;
	    
	    long[] jobs;

	    Worker[] assignedWorker;
	    long[] startTimes;
	    
    	PriorityQueue<Worker> WorkerQueue;

	    private FastScanner in;

	    public static void main(String[] args) throws IOException {
	        new main().solve();
	    }

	    private void readData() throws IOException {
	        numWorkers = in.nextInt();   
	        
	        WorkerQueue = new PriorityQueue<Worker>(numWorkers, new WorkerComparator());
	        
	        for (int i = 0; i < numWorkers; i++) {
				
	        	Worker myWorker = new Worker(i);
	            WorkerQueue.add(myWorker);
	        }
	        
	        int m = in.nextInt();
	        numJobs = m;
	        jobs = new long[(int) numJobs];
	        for (int i = 0; i < m; ++i) {	        	
	            jobs[i] = in.nextInt();
	        }
	    }
	    
	    private void assignJobs() {
	    	   	
	    	Worker currentWorker = null;
	    	
	    	long currentTime = 0, jobCounter = 0;
	    	
	    	boolean incCounter = false;
	        
	    		while(jobCounter < jobs.length) {
	    			
	    			if(incCounter == false) {currentWorker = WorkerQueue.poll();};
	    			
	    			if(currentWorker != null && currentWorker.nextFreeTime > currentTime) {currentTime++;incCounter = true;continue;}
	    			
	    			incCounter = false;
					
					// Assign a work to best available thread
					
	    			currentWorker.nextFreeTime += jobs[(int) jobCounter];
	    			
	    			jobCounter++;
	    			
	    			System.out.println(currentWorker + " " + currentTime);
	    			WorkerQueue.add(currentWorker);
	    			    			
	    		}
	    		
	    }

	    public void solve() throws IOException {
	        in = new FastScanner();
	        readData();
	        assignJobs();
	    }

		static class FastScanner {
	        private BufferedReader reader;
	        private StringTokenizer tokenizer;

	        public FastScanner() {
	            reader = new BufferedReader(new InputStreamReader(System.in));
	            tokenizer = null;
	        }

	        public String next() throws IOException {
	            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	                tokenizer = new StringTokenizer(reader.readLine());
	            }
	            return tokenizer.nextToken();
	        }

	        public int nextInt() throws IOException {
	            return Integer.parseInt(next());
	        }
	    }
	
}
