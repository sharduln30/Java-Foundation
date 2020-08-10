public class test1 {
    public static void main(String args[] ) {
 
    int[][] arr = {{1,2,3,4,11},
                    {5,6,7,8,22},
                    {9,10,11,12,33},
                    {13,14,15,16,44},
                  };
            
        int m=arr.length;
        int n=arr[0].length;
        
        for(int g=arr.length-1;g>0;g--){
            
            int j=0;
            int i=g;
           while(i<m){
            System.out.print(arr[i][j]+"\t");
            i++;
            j++;
            }
           System.out.println();
        }

        for(int g=0;g<m;g++){
            int i=0;
            int j=g;
             while(j<n){
                 System.out.print(arr[i][j]+"\t");
                 i++;
                 j++;
             }
            System.out.println();
        }
    }
}
   