import java.util.Scanner;
public class Face_Euler 
{
    public static int calculatePhi(int n) 
    {
        int result = n;

        for (int i = 2; i * i <= n; i++) 
        {
            if (n % i == 0) {
                while (n % i == 0) 
                {
                    n /= i;
                }
                result -= result / i;
            }
        }

        if (n > 1) 
        {
            result -= result / n;
        }
        return result;
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();
        int phi = calculatePhi(number);
        System.out.println("Euler's phi value for " + number + " is: " + phi);
    }
}
