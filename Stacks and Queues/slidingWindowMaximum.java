// import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class slidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        int nge[] = new int[n];
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                nge[st.pop()] = i;
            }
            st.push(i);
        }
        while (st.size() > 0) {
            nge[st.pop()] = n;
        }
        // System.out.println(Arrays.toString(nge));
        
        int[] max = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int j = i;
            while (nge[j] < i + k)
                j = nge[j];
            max[i] = arr[j];
        }

       for(int i:max)
        System.out.println(i);
        sc.close();
    }
}