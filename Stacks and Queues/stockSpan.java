import java.util.Scanner;
import java.util.Stack;

public class stockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        ans[0]=1;
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=i+1;
            }else{
                ans[i]=i-st.peek();
            }
            st.push(i);
       }   
       for(int i:ans){
           System.out.println(i);
       }
       sc.close();
    }
}