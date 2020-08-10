import java.util.*;

class RecursionQues{
    
    static void print_subsequence(String str,String ans){
        if(str.length()==0){
            System.out.print(ans+", ");
            return;
        }
    
        print_subsequence(str.substring(1),ans+str.charAt(0));
        print_subsequence(str.substring(1),ans+"_");
    }
    
    static int get_subsequence(String str,String ans){
        if(str.length()==0){
            return 1;
        }
        int c=0;

        c+=get_subsequence(str.substring(1),ans+str.charAt(0));
        c+=get_subsequence(str.substring(1),ans);
        return c;
    }
    static void sseq(){
          //  Scanner sc = new Scanner(System.in);
        // String str=sc.nextLine();
        // String ans="";
        // print_subsequence(str,ans);
        // System.out.println();
        // int c = get_subsequence(str,ans); 
        // System.out.print(c+" ");
    
    }
    static String[] keys = {" ", ".","ab", "cde", "fgh", "ijk", "lmno", "pqrs", "tuvw", "xyz"};

    //===================kpc 1st way=============================================
    static void print_KeypadCombination(String press,ArrayList<String> ans){
       if(press.length()==0){
           System.out.println(ans);
           return;
       }
       //pre===============================================================
       char ch1=press.charAt(0);
       int n1=ch1-48;

       String code=keys[n1];
       ArrayList<String> ourans=new ArrayList<>();
       for(char chs:code.toCharArray()){

           for(String j:ans){
              ourans.add(j+chs);
           }
       }
       //pre===============================================================
       print_KeypadCombination(press.substring(1),ourans);
    } 
    //===================kpc 1st way=============================================
    


    //===================kpc 2st way=============================================
       static ArrayList<String> print_KeypadCombination2(String press){
       if(press.length()==0){
           ArrayList<String> base = new ArrayList<>();
           base.add("");
           return base;
       }
       ArrayList<String> rec=print_KeypadCombination2(press.substring(1));
       //post===============================================================
       char ch1=press.charAt(0);
       int n1=ch1-48;
       String code=keys[n1];
       ArrayList<String> ourans=new ArrayList<>();
       for(char chs:code.toCharArray()){    
           for(String j:rec){
              ourans.add(chs+j);
           }
       }
       //post===============================================================
       return ourans;
       }
    //===================kpc 2st way=============================================

  //===================getkpc 2st way=============================================
       static int get_KeypadCombination2(String press){
       if(press.length()==0){
           return 1;
       }
       int  rec=get_KeypadCombination2(press.substring(1));
       
       //post===============================================================
       char ch1=press.charAt(0);
       int n1=ch1-48;
       int var=0;
       String code=keys[n1];
       for(char chs:code.toCharArray()){

           for(int j=0;j<rec;j++){
             var++  ;
           }
       }
       //post===============================================================
       return var;
    } 

    //===================kpc 2st way=============================================



//Keypad Combination
static void gkc(){
     String press="678";
        // ArrayList<String> ans=new ArrayList<>();
        // ans.add("");
        // print_KeypadCombination1(press,ans);
        // System.out.println(print_KeypadCombination2(press));
        System.out.println(get_KeypadCombination2(press));
}
//===================print stair path===========================
    static void print_psp(int n,String ans){
       
        if(n==0){
            System.out.print(ans+" ");
            return ;
        }
    if(n-1>=0){
    print_psp(n-1,ans+1);

    }
    if(n-2>=0){
    print_psp(n-2,ans+2);
    }
    if(n-3>=0){
    print_psp(n-3,ans+3);
    }
    }
    //=================get_psp1--1st Way==========================
    static int get_psp1(int n){
      
        if(n==0){
            return 1;
        }
    int var=0;
    if(n-1>=0){
    
    var+=get_psp1(n-1);
    

    }
    if(n-2>=0){
    
    var+=get_psp1(n-2);
    }
    if(n-3>=0){
    
    var+=get_psp1(n-3);
    }
    return var;
    }
    //=================get_psp--1st Way========================== 

    //=================get_psp2--2nd Way========================== 

    static int get_psp2(int n){
      if(n<0){
        return 0;
        }
        if(n==0){
            return 1;
        }
    int var=0;
    
    var+=get_psp2(n-1);
       
    var+=get_psp2(n-2);
   
    var+=get_psp2(n-3);
    
    return var;
    }

    //=================get_psp2--2nd Way========================== 
static void StairPath(){
    // String ans="";
    // print_psp(5,ans);
    System.out.println(get_psp1(5));
    System.out.println(get_psp2(5));

}
    //===============MazePath1===================================
    static void print_MazePath1(int sr,int sc, int er,int ec,String ans){
        if(sr==er && sc==ec){
            System.out.println(ans);
            return;
        }
        if(sc+1<=ec)
         print_MazePath1(sr,sc+1,er,ec,ans+"H");
        if(sr+1<=er)
        print_MazePath1(sr+1,sc,er,ec,ans+"V");
    }


       static int get_MazePath1(int sr,int sc, int er,int ec){
        if(sr==er && sc==ec){
            return 1;
        }

        int var=0;
        if(sc+1<=ec)
           var+=get_MazePath1(sr,sc+1,er,ec);
        if(sr+1<=er)
          var+=get_MazePath1(sr+1,sc,er,ec);

        return var;
    }

//==================MazePath1 with diagonal===================================
    static void print_MazePath2(int sr,int sc, int er,int ec,String ans){
        if(sr==er && sc==ec){
            System.out.println(ans);
            return;
        }
        if(sc+1<=ec)
         print_MazePath2(sr,sc+1,er,ec,ans+"H");
        if(sr+1<=er)
        print_MazePath2(sr+1,sc,er,ec,ans+"V");
        if(sr+1<=er && sc+1<=ec){
         print_MazePath2(sr+1,sc+1,er,ec,ans+"D");
          
         
        }
    }

       static int get_MazePath2(int sr,int sc, int er,int ec){
        if(sr==er && sc==ec){
            return 1;
        }
        int var=0;
        if(sc+1<=ec)
           var+=get_MazePath2(sr,sc+1,er,ec);
        if(sr+1<=er)
          var+=get_MazePath2(sr+1,sc,er,ec);
        if(sr+1<=er && sc<=ec)
          var+=get_MazePath2(sr+1,sc+1,er,ec);
        return var;
    }

//==================MazePath1 with diagonal===================================

//==================MazePath2===================================

static void print_MazePathII(int sr,int sc,int er,int ec,String ans){
    // System.out.print(sr+" "+sc+"\n");
    if(sr==er && sc==ec){
        System.out.println(ans);
        return;
    }

    for(int i=1;i<=er;i++){
        if(sr+i<=er)
            print_MazePathII(sr+i,sc,er,ec,ans+"V"+i);
    }
    
    for(int i=1;i<=ec;i++){
        if(sc+i<=ec)
            print_MazePathII(sr,sc+i,er,ec,ans+"H"+i);
    }
}


static int get_MazePathII(int sr,int sc,int er,int ec){
    if(sr==er && sc==ec){
        return 1;
    }
    int var=0;
    for(int i=1;i<=er;i++){
        if(sr+i<=er)
        var+= get_MazePathII(sr+i,sc,er,ec);
    }
    
    for(int i=1;i<=ec;i++){
        if(sc+i<=ec)
            var+= get_MazePathII(sr,sc+i,er,ec);
    }
    return var;
}
static void print_MazePathIIb(int sr,int sc,int er,int ec,String ans){
    // System.out.print(sr+" "+sc+"\n");
    if(sr==er && sc==ec){
        System.out.println(ans);
        return;
    }

    for(int i=1;i<=er;i++){
        if(sr+i<=er)
            print_MazePathIIb(sr+i,sc,er,ec,ans+"V"+i);
    }
    
    for(int i=1;i<=ec;i++){
        if(sc+i<=ec)
            print_MazePathIIb(sr,sc+i,er,ec,ans+"H"+i);
    }
    for(int i=1;i<=er;i++){
        if(sr+i<=er && sc+i<=ec)
            print_MazePathIIb(sr+i,sc+i,er,ec,ans+"D"+i);
    }
}


static int get_MazePathIIb(int sr,int sc,int er,int ec){
    if(sr==er && sc==ec){
        return 1;
    }
    int var=0;
    for(int i=1;i<=er;i++){
        if(sr+i<=er)
        var+= get_MazePathIIb(sr+i,sc,er,ec);
    }
    
    for(int i=1;i<=ec;i++){
        if(sc+i<=ec)
            var+= get_MazePathIIb(sr,sc+i,er,ec);
    }
    
    for(int i=1;i<=er;i++){
        if(sr+i<=er && sc+i<=ec)
                var+= get_MazePathIIb(sr+i,sc+i,er,ec);
    }
    return var;
}


static void MazePath(){

    // print_MazePath1(0,0,2,2,"");
    // System.out.println(get_MazePath1(0,0,2,2));
    // print_MazePath2(0,1,2,2,"");
    // System.out.println(get_MazePath2(0,1,2,2));
    // print_MazePathII(0,0,2,2,"");
    // System.out.println(get_MazePathII(0,0,2,2));
    print_MazePathIIb(0,0,2,2,"");
    System.out.println(get_MazePathIIb(0,0,2,2));
    
}

//==================MazePath2===================================

static boolean issafe(int x,int y,int[][] brr,boolean[][] visited){
    if(x>=0 && y>=0  && x<brr.length && y<brr[0].length && brr[x][y]!=1 && !visited[x][y]){
        return true;
    }
    return false;
}

//======================ff 1st way=====================================

static void ff(int[][] arr,int sr,int sc,String ans,boolean[][] visited){
    if(sr==arr.length-1 && sc==arr[0].length-1){
        System.out.println(ans);
        return;

    }

    visited[sr][sc]=true;
    if(issafe(sr-1,sc,arr ,visited)){
        ff(arr,sr-1,sc,ans+"U",visited);
    }
    if(issafe(sr+1,sc,arr , visited)){
        ff(arr,sr+1,sc,ans+"D",visited);
    }
    
    if(issafe(sr,sc+1,arr , visited)){
        ff(arr,sr,sc+1,ans+"R",visited);
    }
    
    if(issafe(sr,sc-1,arr , visited)){
        ff(arr,sr,sc-1,ans+"L",visited);
    }
    visited[sr][sc]=false;
}

// =====================ff 2nd way=====================

static int[][] dir={{-1,0},{1,0},{0,1},{0,-1},{-1,1},{1,1},{1,-1},{-1,-1}};
static String[] sdr={"U","D","R","L",".UR.",".RD.",".DL.",".LU."};
static void ff2(int[][] arr,int sr,int sc,String ans,boolean[][] visited){
    if(sr==arr.length-1 && sc==arr[0].length-1){
        System.out.println(ans);
        return;

    }

    visited[sr][sc]=true;
    for(int d=0;d<dir.length;d++){
      int x=sr+dir[d][0];
      int y=sc+dir[d][1];
    //   System.out.println(x+"x"+y);
      if(issafe(x,y,arr ,visited)){
         ff2(arr,x,y,ans+sdr[d],visited);
      }

    }
    visited[sr][sc]=false;
}



static void FloodFill(){
    int[][] arr = {{0,0,0,0},
                    {0,0,0,1},
                    {0,1,0,1},
                    {0,1,0,0}};
    boolean[][] visited=new boolean[arr.length][arr[0].length];
    // ff(arr,0,0,"",visited);
    ff2(arr,0,0,"",visited);
}


//===============PIPELINE=====================
static int[][] dir1={{2,2},{0,1},{0,2},{1,0},{2,0},{2,2}};
static String[] sdr1={"P1","P2","P3","P4","P5","P6","P7","P8","P9","P10"};

static void pp(int[][] arr,int sr,int sc,String ans,boolean[][] visited){
    if(sr==arr.length-1 && sc==arr[0].length-1){
        System.out.println(ans);
        return;

    }

    visited[sr][sc]=true;
    for(int d=0;d<dir1.length;d++){
      int x=sr+dir1[d][0];
      int y=sc+dir1[d][1];
    //   System.out.println(x+"x"+y);
      if(issafe(x,y,arr ,visited)){
         pp(arr,x,y,ans+sdr1[d],visited);
      }

    }
    visited[sr][sc]=false;
}



static void Pipeline(){
    int[][] arr = new int[3][4];
    boolean[][] visited=new boolean[arr.length][arr[0].length];
    // ff(arr,0,0,"",visited);
    pp(arr,0,0,"",visited);
}




public static void main(String[] args){
        //sseq();
        //gkc();
        //StairPath();
        //MazePath();
        //FloodFill();
        Pipeline();       
    }
}