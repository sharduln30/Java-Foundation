import java.util.Scanner;
import java.util.Arrays;


class minCostInMazeTraversal{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        dp[n-1][m-1]=arr[n-1][m-1];
        for(int i=n-2;i>=0;i--){
            dp[i][m-1]=dp[i+1][m-1]+arr[i][m-1];    
        }
        for(int j=m-2;j>=0;j--){
            dp[n-1][j]=dp[n-1][j+1]+arr[n-1][j];    
        }

        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                dp[i][j]=arr[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }

        // for(int[] i:dp)
        //     System.out.println(Arrays.toString(i));
        System.out.println(dp[0][0]);
    }
}