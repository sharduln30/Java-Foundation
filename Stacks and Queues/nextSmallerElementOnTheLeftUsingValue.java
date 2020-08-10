// In the case when we are storing value in the stack then we will move from left to Right
import java.util.Scanner;
import java.util.Stack;

public class nextSmallerElementOnTheLeftUsingValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        int[] ans = new int[n];
        ans[0]=-1;
        
        for(int i=0;i<arr.length;i++){
            while(st.size()>0 && st.peek()>=arr[i]){
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