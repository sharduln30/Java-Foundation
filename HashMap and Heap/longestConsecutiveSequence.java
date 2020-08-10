import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class longestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Boolean> hm = new HashMap<>();

        for (int val : arr) {
            hm.put(val, true);
        }

        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i] - 1)) {
                hm.put(arr[i], false);
            }
        }

        int maxSize = 0;
        
        ArrayList<Integer> largestAL = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (hm.get(arr[i])) {
                int j = 0;
                int size = 0;
                ArrayList<Integer> al = new ArrayList<>();
                while (true) {
                    if (hm.containsKey(arr[i] + j)) {
                        al.add(arr[i]+j);
                        size++;
                    } else {
                        break;
                    }
                    j++;
                }
                if (size > maxSize) {
                    maxSize=size;
                    largestAL = al;
                }
            }
        }
        for(int i:largestAL){
            System.out.println(i);
        }
    }
}