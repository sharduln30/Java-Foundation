//import java.util.*;
class twoD{

    static void mat_mul(){
               int[][] arr = {{1,2},
                        {1,2},
                        {1,3}};
        
        int[][] brr = {{1,2},
                        {1,2}};
       if(arr[0].length!=brr.length) 
        System.out.println("Matrix mul not possible");

        else{
            int[][] crr = new int[arr.length][brr[0].length];
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<brr[0].length;j++){
                    for(int k=0;k<arr[0].length;k++){
                        crr[i][j] += arr[i][k]*brr[k][j];
                    }
            }

        }
        for(int[] i:crr){
            for(int j:i){
                System.out.print(j+" ");
            }
                System.out.println();
        }
    }
    }
    static void waveprint1(){
        int[][] arr = {{11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25},
                        {26,27,28,29,30}};

            for(int j=0;j<arr[0].length;j++){
                if(j%2==0){
                    for(int i=0;i<arr.length;i++){
                        System.out.print(arr[i][j]+" ");
                }
                }
                else{
                    for(int i=arr.length-1;i>=0;i--){
                        System.out.print(arr[i][j]+" ");
                } 
                
            }
        }
    }

 static void waveprint2(){
        int[][] arr = {{11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25},
                        {26,27,28,29,30}};

                for(int i=0;i<arr.length;i++){
                if(i%2==0){
                    for(int j=0;j<arr[0].length;j++){

                        System.out.print(arr[i][j]+" ");
                }
                }
                else{
                    for(int j=arr[0].length-1;j>=0;j--){
                        System.out.print( arr[i][j]+" ");
                } 
                
            }
        }
    }
    static void spiralprint(){
        int[][] arr = {{11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25},
                        {26,27,28,29,30},
                        {31,32,33,34,35}};
        
        int rmin=0;
        int rmax=arr.length-1;
        int cmin=0;
        int cmax=arr[0].length-1;

        int n=arr.length*arr[0].length;

        while(n>0){
            for(int i=rmin;i<=rmax;i++){
                System.out.print(arr[i][cmin]+" ");
                n--;
            }
            cmin++;
            for(int i=cmin;i<=cmax;i++){
                System.out.print(arr[rmax][i]+" ");
                n--;
            }
            rmax--;
            for(int i=rmax;i>=rmin;i--){
                System.out.print(arr[i][cmax]+" ");
                n--;
            }
            cmax--;
            for(int i=cmax;i>=cmin;i--){
                System.out.print(arr[rmin][i]+" ");
                n--;
            }
            rmin++;
        }

    
    }
    static void exitpoint(){
        int[][] arr = {{0,0,1,0},
                        {1,0,0,1},
                        {0,0,0,0},
                        {0,0,0,0},
                        {1,0,1,0}};
        int i=0,j=0,d=0;
        while(true){
            // System.out.println(i+" "+j);
            d+=arr[i][j];
            d=d%4;
            switch(d){
                case 0: j++;
                        if(j>arr[0].length-1){
                            j--;
                            System.out.print("Exit Point: "+i+", "+j);
                            return;
                        }
                        break;
                        
                case 1: i++;
                        if(i>arr.length-1){
                            i--;
                            System.out.print("Exit Point: "+i+", "+j);
                            return;
                        }
                        break;
                        
                case 2: j--;
                        if(j<0){
                            j--;
                            System.out.print("Exit Point: "+i+", "+j);
                            return;
                        }
                        break;
                        
                case 3: i--;
                        if(i<0){
                            i--;
                            System.out.print("Exit Point: "+i+", "+j);
                            return;
                        }
                        break;
            }   
        }
    }

    public  static void main(String[] args){
      //  Scanner sc = new Scanner(System.in);
        //  mat_mul();
      //  waveprint1();
     // waveprint2();
      //spiralprint();//IMP
     // exitpoint();
}
}