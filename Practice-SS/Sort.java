//import java.util.*;

class Sort{

   static void SelectionSort(int[] arr){

    for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
            if(arr[i]>arr[j]){
              int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    for(int i:arr)
        System.out.print(i+" ");
}

 static void rec_SelectionSort(int[] arr,int i){

     if(i==arr.length-1){
         return;
     }

        for(int j=i+1;j<arr.length;j++){
            if(arr[i]>arr[j]){
              int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        rec_SelectionSort(arr,i+1);

}

 static void BubbleSort(int[] arr){

    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr.length-1-i;j++){
            if(arr[j]>arr[j+1]){
              int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
    for(int i:arr)
        System.out.print(i+" ");
}
 static void rec_BubbleSort(int[] arr, int i){
     if(i==arr.length){
        for(int k:arr)
            System.out.print(k+" ");

         return;
     }
        for(int j=0;j<arr.length-1-i;j++){
            if(arr[j]>arr[j+1]){
              int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    rec_BubbleSort(arr,i+1);

    }



    public static void main(String[] args){
        // Scanner sc=new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] arr =new int[n];
        // for(int i=0;i<arr.length;i++)
        //     arr[i]=sc.nextInt();

        int[] arr={34,56,2,98,98,12,76,35,9,5};
       
        
        // SelectionSort(arr);
        // rec_SelectionSort(arr,0);

        //  for(int ii:arr){
        //      System.out.print(ii+" ");}
        // BubbleSort(arr);
        rec_BubbleSort(arr,0);
        
         }
        
    }


