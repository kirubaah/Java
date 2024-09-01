import java.util.HashMap;
import java.util.Scanner;
public class Face_Strobogrammatic
{
    private static HashMap<Character, Character> strobogrammaticMap;
    static 
    {
        strobogrammaticMap = new HashMap<>();
        strobogrammaticMap.put('0', '0');
        strobogrammaticMap.put('1', '1');
        strobogrammaticMap.put('6', '9');
        strobogrammaticMap.put('8', '8');
        strobogrammaticMap.put('9', '6');
    }
    public static boolean isStrobogrammatic(String num) 
    {
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) 
        {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);

            if (!strobogrammaticMap.containsKey(leftChar) || strobogrammaticMap.get(leftChar) != rightChar) 
            {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String number = scanner.nextLine();
        scanner.close();
        boolean isStrobogrammaticNumber = isStrobogrammatic(number);
        if (isStrobogrammaticNumber) 
        {
            System.out.println(number + " is a Strobogrammatic number.");
        } else 
        {
            System.out.println(number + " is not a Strobogrammatic number.");
        }
    }
}
