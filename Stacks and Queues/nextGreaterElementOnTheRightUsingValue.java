//in this approach we will traverse the array from right to left
// import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class nextGreaterElementOnTheRightUsingValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        st.push(arr[n-1]);
        int[] ans = new int[n];
        ans[n-1]=-1;
        
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=-1;
            }else{
                ans[i]=st.peek();
            }
            st.push(arr[i]);
        }
 
        for(int i:ans)
        System.out.println(i);
        sc.close();
    }
}