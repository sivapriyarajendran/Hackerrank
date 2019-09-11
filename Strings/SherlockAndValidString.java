import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String str) {
       if(str == null || str.isEmpty()) { 
            return "YES"; 
        } 
          
        Map<Character, Integer> map = new HashMap<>(); 
          
        // Run loop form 0 to length of string 
        for(int i = 0; i < str.length(); i++) { 
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1); 
        } 
        Iterator<Integer> itr = map.values().iterator(); 
          
        // declaration of variables 
        boolean first = true, second = true; 
        int val1 = 0, val2 = 0; 
        int countOfVal1 = 0, countOfVal2 = 0; 
          
        while(itr.hasNext()) { 
            int i = itr.next(); 
              
            // if first is true than countOfVal1 increase 
            if(first) { 
                val1 = i; 
                first = false; 
                countOfVal1++; 
                continue; 
            } 
              
            if(i == val1) { 
                countOfVal1++; 
                continue; 
            } 
              
            // if second is true than countOfVal2 increase 
            if(second) { 
                val2 = i; 
                countOfVal2++; 
                second = false; 
                continue; 
            } 
              
            if(i == val2) { 
                countOfVal2++; 
                continue; 
            } 
              
            return "NO"; 
        } 
          
        if(countOfVal1 > 1 && countOfVal2 > 1) { 
            return "NO"; 
        }else { 
            return "YES"; 
        } 
          
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
