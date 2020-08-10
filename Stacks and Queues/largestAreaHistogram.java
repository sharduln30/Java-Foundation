// import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class largestAreaHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        int[] rb = new int[n];
        st.push(n - 1);
        rb[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                rb[i] = n;// if no element is smaller on the right then arr.length is the ans
            } else {
                rb[i] = st.peek();
            }
            st.push(i); 
        }
        
        int[] lb = new int[n];
        st = new Stack<>();
        
        st.push(0);
        lb[0] = -1;
        for (int i = 1; i <n; i++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                lb[i] = -1;// if no element is smaller on the left then -1 is the ans
            } else {
                lb[i] = st.peek();
            }
            st.push(i); 
        }
        // System.out.println(Arrays.toString(lb));
        // System.out.println(Arrays.toString(rb));
        
        int max = 0;

        for(int i=0;i<n;i++){
            int width = rb[i]-lb[i]-1;
            int area=arr[i]*width;
            if(area>max){
                max=area;
            }
        }
        System.out.println(max);
        sc.close();
    }
}