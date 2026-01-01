public class Primes {
    public static void main(String[] args) {
        // Parse the input n
        int n = Integer.parseInt(args[0]);

        // Create a boolean array to represent numbers 0 to n.
        // Index i represents the number i.
        // Initially, we assume all numbers from 2 to n are prime.
        boolean[] isPrime = new boolean[n + 1];
        
        // Initialize the array: numbers >= 2 are considered prime initially.
        // (Java initializes boolean arrays to false, so we must set them to true).
        int i = 2;
        while (i <= n) {
            isPrime[i] = true;
            i++;
        }

        // Sieve of Eratosthenes logic using while loops
        int p = 2;
        // We only need to check up to the square root of n
        while (p * p <= n) {
            // If p is prime, mark all its multiples as not prime
            if (isPrime[p]) {
                int multiple = p * p; // Start marking from p^2
                while (multiple <= n) {
                    isPrime[multiple] = false;
                    multiple = multiple + p;
                }
            }
            p++;
        }

        // Print the prime numbers
        System.out.println("Prime numbers up to " + n + ":");
        int count = 0;
        int printIndex = 2;
        while (printIndex <= n) {
            if (isPrime[printIndex]) {
                System.out.println(printIndex);
                count++;
            }
            printIndex++;
        }

        // Calculate and print the percentage summary
        // Note: Casting to double is necessary to get correct division result before casting back to int
        int percentage = (int)(((double)count / n) * 100);
        System.out.println("There are " + count + " primes between 2 and " + n + " (" + percentage + "% are primes)");
    }
}