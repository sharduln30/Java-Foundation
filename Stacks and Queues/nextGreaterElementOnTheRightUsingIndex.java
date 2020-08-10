//in this approach we will traverse the array from left to right
import java.util.Scanner;
import java.util.Stack;

public class nextGreaterElementOnTheRightUsingIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        st.push(0);

        for(int i=1;i<n;i++){
            while(st.size()>0 && arr[st.peek()]<arr[i]){
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