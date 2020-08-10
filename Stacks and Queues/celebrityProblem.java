import java.util.Scanner;
import java.util.Stack;

public class celebrityProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        while(st.size()>1) {
            int b=st.pop();
            int a=st.pop();
            if(arr[a][b]==1){
                st.push(b);
            }
            if(arr[a][b]==0){
                st.push(a);
            }
            System.out.println(st);
        }
        int celeb = st.pop();
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(celeb!=i){
                if(arr[celeb][i]==1 || arr[i][celeb]==0){
                    flag=true;
                }
            }
        }
        if(flag)
            System.out.println("none");
        else
            System.out.println(celeb);
    sc.close();
    }
}