// In the case when we are storing index in the stack then we will move from right to left
import java.util.Scanner;
import java.util.Stack;

public class nextSmallerElementOnTheLeftUsingIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        st.push(arr.length-1);

        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>arr[i]){
                ans[st.pop()]=arr[i];
            }
            st.push(i);
        }
        while(st.size()>0){
            ans[st.pop()]=-1;
        }
       
       for(int i:ans)
        System.out.println(i);
        sc.close();
    }
}