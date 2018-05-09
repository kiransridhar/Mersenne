/**
* Kiran Sridhar 2/22/18
*/

public class Mersenne
{
    // main method
    public static void main(String[] args) {

        System.out.println("Finding Mersenne prime numbers between in 1 and 10000 \n");
        int numOfThreads = 50;
        //create threads array
        Thread threads[] = new Thread[numOfThreads];
        
        //create threads
        for(int i=0; i<numOfThreads; i++)
        {
        	//calculate the lower bound value for the thread
        	int from = i * (10000/numOfThreads) + 1;
        	//calculate the upper bound value for the thread
        	int to = from + (10000/numOfThreads) -1;

        	//System.out.println(" FROM "+from + " : "+to);

        	//create a thread
        	WorkerThread thread = new WorkerThread(from, to);
        	threads[i] = new Thread(thread, ""+1);
        	//start thread
        	threads[i].start();
        }

        //wait for all threads to complete
        for(int i=0; i<threads.length; i++)
        {
        	try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }

        //program has finished executing
        System.out.println(" All threads finished executing. \n");
    }
}
