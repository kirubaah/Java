import java.util.Scanner;
public class Face_ChineseRemainder
{
    public static long calculateCRT(long[] num, long[] rem) 
    {
        long product = 1;
        for (long n : num) 
        {
            product *= n;
        }
        long result = 0;
        for (int i = 0; i < num.length; i++) 
        {
            long partialProduct = product / num[i];
            result += rem[i] * inverseMod(partialProduct, num[i]) * partialProduct;
        }
        return result % product;
    }
    public static long inverseMod(long a, long m) 
    {
        long m0 = m;
        long y = 0, x = 1;
        if (m == 1) 
        {
            return 0;
        }
        while (a > 1) 
        {
            long q = a / m;
            long t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0) 
        {
            x += m0;
        }

        return x;
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of congruences: ");
        int numCongruences = scanner.nextInt();
        long[] num = new long[numCongruences];
        long[] rem = new long[numCongruences];
        System.out.println("Enter the values for each congruence:");
        for (int i = 0; i < numCongruences; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            num[i] = scanner.nextLong();
            System.out.print("Remainder " + (i + 1) + ": ");
            rem[i] = scanner.nextLong();
        }
        scanner.close();
        long solution = calculateCRT(num, rem);
        System.out.println("The solution to the system of congruences is: " + solution);
    }
}
