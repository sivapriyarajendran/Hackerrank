import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import javafx.util.Pair;
public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
int n = arr.length; 
  
        // Create two arrays and use as pairs where first 
        // array is element and second array 
        // is position of first element 
        ArrayList <Pair <Integer, Integer> > arrpos = 
                  new ArrayList <Pair <Integer, Integer> > (); 
        for (int i = 0; i < n; i++) 
             arrpos.add(new Pair <Integer, Integer> (arr[i], i)); 
  
        // Sort the array by array element values to 
        // get right position of every element as the 
        // elements of second array. 
        arrpos.sort(new Comparator<Pair<Integer, Integer>>() 
        { 
            @Override
            public int compare(Pair<Integer, Integer> o1, 
                               Pair<Integer, Integer> o2) 
            { 
                if (o1.getKey() > o2.getKey()) 
                    return 1; 
  
                // We can change this to make it then look at the 
                // words alphabetical order 
                else if (o1.getKey().equals(o2.getKey())) 
                    return 0; 
  
                else
                    return -1; 
            } 
        }); 
  System.out.println(arrpos);
        // To keep track of visited elements. Initialize 
        // all elements as not visited or false. 
        Boolean[] vis = new Boolean[n]; 
        Arrays.fill(vis, false); 
  
        // Initialize result 
        int ans = 0; 
  
        // Traverse array elements 
        for (int i = 0; i < n; i++) 
        { 
            // already swapped and corrected or 
            // already present at correct pos 
            if (vis[i] || arrpos.get(i).getValue() == i) 
                continue; 
  
            // find out the number of  node in 
            // this cycle and add in ans 
            int cycle_size = 0; 
            int j = i; 
            while (!vis[j]) 
            { 
                vis[j] = true; 
  
                // move to next node 
                j = arrpos.get(j).getValue(); 
                cycle_size++; 
            } 
  
            // Update answer by adding current cycle. 
            if(cycle_size > 0) 
            { 
                ans += (cycle_size - 1); 
            } 
        } 
  
        // Return result 
        return ans; 
    
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
