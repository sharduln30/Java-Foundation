import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class mergeOverlappingIntervals {
    
    public static class Pair implements Comparable<Pair>{
        int st;
        int et;
    public int compareTo(Pair other){
        return this.st-other.st;
    }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }    
        Pair[] pair = new Pair[n];
        for (int i = 0; i < pair.length; i++) {
            pair[i] = new Pair();
            pair[i].st=arr[i][0];
            pair[i].et=arr[i][1];
        }
        Arrays.sort(pair);
        
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < pair.length; i++) {
            if(i==0){
                st.push(pair[i]);
            }else{
                if(pair[i].st>st.peek().et){
                    st.push(pair[i]);
                }else{
                    st.peek().et=Math.max(st.peek().et,pair[i].et);
                }
            }
        }
        Stack<Pair> ans = new Stack<>();
        while(st.size()>0){
            ans.push(st.pop());
        }
        while(ans.size()>0){
            System.out.println(ans.peek().st+" "+ans.peek().et);
            ans.pop();
        }
        sc.close();
    }
}