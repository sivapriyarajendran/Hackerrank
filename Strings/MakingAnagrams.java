import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
final static int CHARS = 26; 

    // Complete the makeAnagram function below.
    static int makeAnagram(String str1, String str2) {
       int arr[] = new int[CHARS]; 
        for (int i = 0; i < str1.length(); i++) { 
            arr[str1.charAt(i) - 'a']++; 
        } 
  
        for (int i = 0; i < str2.length(); i++) { 
            arr[str2.charAt(i) - 'a']--; 
        } 
  
        int ans = 0; 
        for (int i = 0; i < CHARS; i++) { 
            ans += Math.abs(arr[i]); 
        } 
        return ans; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
