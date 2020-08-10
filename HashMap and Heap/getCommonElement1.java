import java.util.HashMap;
import java.util.Scanner;

public class getCommonElement1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] brr = new int[m];
        for (int i = 0; i < brr.length; i++) {
            brr[i] = sc.nextInt();
        }
        HashMap<Integer,Integer> hm= new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i]+1));
            }else{
                hm.put(arr[i],1);
            }
        }
        for (int i = 0; i < brr.length; i++) {
            if(hm.containsKey(brr[i])){
                System.out.println(brr[i]);
                hm.remove(brr[i]);
            }
        }
    }
}