import java.math.BigInteger;


/**
 * Kiran Sridhar 2/22/18
 * WorkerThread generates Mersenne prime numbers btw min and max
 */
public class WorkerThread implements Runnable {
	private int min;
	private int max;
	public WorkerThread(int min, int max)
	{
		this.min = min;
		this.max = max;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int p = min; p <= max; p += 2)
            if (isPrime(p) && isMersennePrime(p)) //find if it's a prime mersenne no
                System.out.print(" " + p); //display

	}
	
	//check if it is a prime number
	public static boolean isPrime(int p) {
        if (p == 2)
            return true;
        else if (p <= 1 || p % 2 == 0)
            return false;
        else {
            int to = (int)Math.sqrt(p);
            for (int i = 3; i <= to; i += 2)
                if (p % i == 0)
                    return false;
            return true;
        }
    }
 
	//check if it is a Mersenne Prime number
    public static boolean isMersennePrime(int p) {
        if (p == 2)
            return true;
        else {
            BigInteger m_p = BigInteger.ONE.shiftLeft(p).subtract(BigInteger.ONE);
            BigInteger s = BigInteger.valueOf(4);
            for (int i = 3; i <= p; i++)
                s = s.multiply(s).subtract(BigInteger.valueOf(2)).mod(m_p);
            return s.equals(BigInteger.ZERO);
        }
    }

}