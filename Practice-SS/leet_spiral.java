import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.Map;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int frow = 0;
            int fcol = 0;
            int lrow = matrix.length;
            int lcol = matrix[0].length;
        int x=(matrix.length)*(matrix[0].length);
        System.out.print(lcol+" "+lrow+" "+x);
        List<Integer> a = new ArrayList<Integer>();
        while(x>0){
            for(int i=fcol;i<=lcol;i++){
                a.add(matrix[frow][i]);
                x--;
            }
            frow++;
            if(x==0) break;
            for(int i=frow;i<=lrow;i++){
                a.add(matrix[i][lcol]);
                x--;
            }
            lcol--;
            if(x==0) break;
            for(int i=lcol;i>=fcol;i--){
                a.add(matrix[lrow][i]);
                x--;
            }
            lrow--;
            if(x==0) break;
            for(int i=lrow;i>=frow;i--){
                a.add(matrix[i][fcol]);
                x--;
            }
            fcol++;
            if(x==0) break;
            
            
        }
        
    return a;
    }
}

public class leet_spiral {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
          return new int[0][0];
        }
    
        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
          JsonArray cols = jsonArray.get(i).asArray();
          arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }
    
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] matrix = stringToInt2dArray(line);
            
            List<Integer> ret = new Solution().spiralOrder(matrix);
            
            String out = integerArrayListToString(ret);
            
            System.out.print(out);
        }
    }
}