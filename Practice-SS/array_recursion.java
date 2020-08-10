class array_recursion{
 
    static void arr_display(int[] arr,int i){
        if(i==arr.length){
            return;
        }
        System.out.println(arr[i]);
        // if(i==3){
        //     arr[i]=100;
        // }
        arr_display(arr,i+1);
       //  System.out.println(arr[i]);
       
    }
    static boolean find(int[] arr,int i,int f){
        if(i==arr.length){
          return false;
        }
        if(arr[i]==f) return true;
        boolean t=find(arr,i+1,f); 
        return t;
    }
    static int max_array(int[] arr,int i){
        if(i==arr.length-1){
            return arr[i];
        }
        int max=max_array(arr,i+1);
        if(arr[i]>max) max=arr[i];
        return max;
    }
    static int min_array(int[] arr,int i){
        if(i==arr.length-1){
            return arr[i];
        }
        int min=min_array(arr,i+1);
        if(arr[i]<min) min=arr[i];
        return min;
    }
    static int first_occ(int[] arr, int i, int n){
        if(i==arr.length-1) return arr[i];
        if(arr[i]==n) return i+1;
        int occ=first_occ(arr,i+1,n);
        return occ;
    }
     static int last_occ(int[] arr, int i, int n){
        
        if(i==arr.length-1) return -1;
        int occ=last_occ(arr,i+1,n);
        if(occ==-1){
        if(arr[i]==n) {
            return i+1;
           
        }
        
        }
         return occ;
         
    }
    // ===============================================================================
    static int[] index_repeat(int[] arr,int i,int a, int c){
            if(i==arr.length){
                int[] base=new int[c];
                return base;
            }
            if(arr[i]==a){
                c++;
            } 

            int[] recans=index_repeat(arr,i+1,a,c);

            if(arr[i]==a){
                recans[c-1]=i;
            }

            return recans;
    }
    
    // ===============================================================================
    static int counter=0;
   static void toh(int n,char sr,char hep,char de){
       if(n==0){
           return;
       }

       toh(n-1,sr,de,hep);
       counter++;
       
       System.out.println(n+" "+sr+" ->"+de);
    
       toh(n-1,hep,sr,de);
       
       
   }


            
    // ===============================================================================
    
    public static void main(String[] args){
        
      //  int[] arr= {10,11,12,65,12,12,14,15,12};
     // arr_display(arr,0);
    // boolean f=find(arr,0,13);
    // System.out.print(f);
    //  int max=max_array(arr,0);
    //  System.out.print(max);
    //  int min=min_array(arr,0);
    //System.out.print(min);
        // int occ1=first_occ(arr,0,12);
        // System.out.print(occ1);
        // int occ2=last_occ(arr,0,12);
        // System.out.print(occ2);
        // int[] brr=index_repeat(arr,0,12,0);
        // for(int i:brr){
        //     System.out.print(i+" ");
        // } 

        toh(3,'S','H','D');
        System.out.println(counter);
    }
}
 