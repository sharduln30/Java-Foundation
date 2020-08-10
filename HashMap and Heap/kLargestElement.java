import java.util.*;

public class kLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        // This code is valid for distinct integers and 
        //complexity is O(k.n)
        int maxUP = Integer.MAX_VALUE;
        
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int max = arr[0];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > max && arr[j] < maxUP) {
                    max = arr[j];
                }
            }
            al.add(max); 
            maxUP=max;
        }
        Collections.reverse(al);
        for(int i:al){
            System.out.println(i);
        }

        //Using min priority queue

        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int i=0;i<k;i++){
        //     pq.add(arr[i]);
        // }
        // for(int i=k;i<arr.length;i++){
        //     if(arr[i]>pq.peek()){
        //         pq.remove();
        //         pq.add(arr[i]);
        //     }
        // }
        // while(pq.size()>0){
        //     System.out.println(pq.remove());
        // }
        
    }
}