import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Face_SimpleSieve 
{
    public static List<Integer> findPrimes(int limit) 
    {
        boolean[] isComposite = new boolean[limit + 1];
        for (int i = 2; i * i <= limit; i++) {
            if (!isComposite[i]) 
            {
                for (int j = i * i; j <= limit; j += i) 
                {
                    isComposite[j] = true;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) 
        {
            if (!isComposite[i]) 
            {
                primes.add(i);
            }
        }
        return primes;
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the limit: ");
        int limit = scanner.nextInt();
        scanner.close();
        List<Integer> primes = findPrimes(limit);
        System.out.println("Prime numbers up to " + limit + ":");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
    }
}
