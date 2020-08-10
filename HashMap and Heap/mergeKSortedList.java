import java.util.ArrayList;
import java.util.Scanner;

public class mergeKSortedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                list.add(val);
            }
            lists.add(list);
        }            
        System.out.println(lists);
    }
}
