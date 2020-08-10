import java.util.*;



class pattern{

static void p1 (int n){
    int i=0,j=0;
        for(i=1;i<=n;i++){
            for(j=1;j<=n;j++){
                System.out.print("*");
        }
            System.out.println();
    }
}

static void p3(int n){
 int i=0,j=0;
        for(i=n;i>=1;i--){
            for(j=1;j<=i;j++){
                System.out.print("*");
        }
            System.out.println();
    }

}
static void p4(int n){
 int i=0,j=0;
        for(i=1;i<=n;i++){
            for(j=1;j<=i;j++){
                System.out.print(j);
        }
            System.out.println();
    }

}
static void p5(int n){
 int i=0,j=0;
        for(i=1;i<=n;i++){
            for(j=1;j<=i;j++){
                System.out.print(1);
        }
            System.out.println();
    }
}
static void p6(int n){
 int i=0,j=0;
    int k=1;
        for(i=1;i<=n;i++){
            for(j=1;j<=i;j++){
                System.out.print(k+++" ");
        }
            System.out.println();
    }

}
static void p7(int n){
 int i=0,j=0;
        int a=-1,b=1;
        int s=0;
      
        for(i=1;i<=n;i++){
            for(j=1;j<=i;j++){
                s=a+b;
                System.out.print(s+" ");
        
                a=b;
                b=s;
        }
            System.out.println();
    }
}
static void p8(int n){
    int nsp=n-1;
    int nst=1;
    for(int i=0;i<n;i++){
        for(int j=0;j<nsp;j++){
            System.out.print("   ");
        }
        for(int j=0;j<nst;j++){
            System.out.print(" * ");
        }
        nsp--;
        nst++;
        System.out.println();
    }
}
static void p9(int n){
    int nsp=n-1;
    int nst=1;
    for(int i=0;i<n;i++){
        for(int j=0;j<nsp;j++){
            System.out.print("   ");
        }
        for(int j=0;j<nst;j++){
            System.out.print(" * ");
        }
        nsp--;
        nst+=2;
        System.out.println();
    }
}

static void p10(int n){
    int nsp=n/2;
    int nst=1;

    for(int i=0;i<n;i++){
        for(int j=0;j<nsp;j++){
            System.out.print("   ");
        }
        
        for(int j=0;j<nst;j++){
            System.out.print(" * ");
        }
        if(i<n/2){
            nst+=2;
            nsp--;
        
        }
        else{
        nst-=2;
        nsp++;}
         System.out.println();
    }
  
}

static void p11(int n){
    int nsp=n/2;
    int nst=1;
    int i=0,j=0;
    int var=1;
    for(i=0;i<n;i++){
        int k=var;
        for(j=0;j<nsp;j++){
            System.out.print("   ");
        }
        
        for(j=0;j<nst;j++){
            System.out.print(" "+k+" ");
            if(j<nst/2){

              k++;
            }else{
                k--;
            }
        }
        if(i<n/2){
            nst+=2;
            nsp--;
            var++;
        
        }
        else{
        nst-=2;
        nsp++;
        var--;
        }
         System.out.println();
    }
  
}
static void p11_2way(int n){
    int nsp=n/2;
    int nst=1;
    int i=0,j=0;
   
    for(i=0;i<n;i++){
        for(j=0;j<nsp;j++){
            System.out.print("   ");
        }
        
        int k=nst/2+1;//gfg
        for(j=0;j<nst;j++){
            System.out.print(" "+k+" ");
            if(j<k/2){

              k++;
            }else{
                k--;
            }
        }
        if(i<n/2){
            nst+=2;
            nsp--;
           
        
        }
        else{
        nst-=2;
        nsp++;
      
        }
         System.out.println();
    }
  
}

static void p12(int n){
    int i=0,j=0;
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            if(i==j || i+j==n-1){
                System.out.print(" * ");
            }else 
            System.out.print("   ");
            
        }
        System.out.println();
            
    }
}

    static void p13(int n){
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(i<n/2){
                    if(j==0 || j==n-1)
                        System.out.print(" * ");
                    else 
                        System.out.print("   ");
                    
                }
                else{
                    if(i==j || i+j==n-1 || j==0 || j==n-1)
                        System.out.print(" * ");
                    else 
                        System.out.print("   ");
                    
                }
                
            }
            System.out.println();
        }
    }
     static void p14(int n){
        int i=0,j=0;
        int outsp=n/2;
        int insp=-1;
        for(i=0;i<n;i++){

            for(j=1;j<=outsp;j++){
                System.out.print("   ");
            }

            System.out.print(" * ");
            
            for(j=1;j<=insp;j++){
                System.out.print("   ");
            }
            if(i!=0 && i!=n-1){
                
              System.out.print(" * ");
            }
                if(i<n/2){
                    outsp--;
                    insp+=2;
                }
                else{
                    outsp++;
                    insp-=2;
                }
                System.out.println();

            }
        }
    
    static void p15(int n){
        for(int i=0;i<n;i++){
            int var=1;
            System.out.print(var+" ");
            for(int j=0;j<i;j++){
                var=(var*(i-j))/(j+1);
            System.out.print(var+" ");
            }
            System.out.println();
            
        }
    }
    static void p16(int n){
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                if(j<=n/2 || j==n-1)
                    System.out.print(" * ");
                else
                        System.out.print("   ");
                }
                if(i>0 && i<n/2){
                    if(j==n/2 || j==n-1)
                        System.out.print(" * ");
                    else
                        System.out.print("   ");
                }
                if(i==n/2){
                    System.out.print(" * ");
                }
                if(i>n/2 && i<n-1){
                    if(j==0 || j==n/2)
                        System.out.print(" * ");
                    else
                        System.out.print("   ");
                    }
                if(i==n-1){
                     if(j==0 || j>=n/2)
                        System.out.print(" * ");
                    else
                        System.out.print("   ");
                    }
                }
                System.out.println();
                }

    }
            
    static void p17(int n){
    
    int var=2*n-3;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            if(i==n && j==n) continue;
            System.out.print(" "+j+" ");
        }
        for(int j=1;j<=var;j++){
            System.out.print("   ");
        }
        for(int j=i;j>=1;j--){
            System.out.print(" "+j+" ");
        }
        System.out.println();
      
        var-=2;
    }
    }
    
    static void p18(int n){
        
        if(n%2==0) {
            System.out.print("Not Possible");
            return;
        }
        int j=0,t=0;
        
        for(int i=0;i<n;i++){
            if(i<n/2){
                for(j=0;j<n/2;j++)
                      System.out.print("   "); 
                      int var=++t;
                for(j=0;j<var;j++)
                      System.out.print(" * "); 
                

            }
            else if(i==n/2){
                for(j=0;j<n;j++)
                    System.out.print(" * "); ;
            }
            else if(i>n/2){
                 for(j=0;j<n/2;j++)
                      System.out.print("   ");
                      int var=t--; 
                for(j=0;j<var;j++)
                      System.out.print(" * "); 
              
            }
            System.out.println();
            }
              
        }
         
    
    // static void p19(int n){
    //     int outsp=0;
    //     int insp=0;
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=n;j++){
    //             if(<n/2)
    //         }
    //     }
    // }       

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
       p1(n);
       p3(n);
       p4(n);
       p5(n);
       p6(n);
       p7(n);
       p8(n);
       p9(n);
       p10(n);
      p11(n);
      p11_2way(n); 
     p12(n);
     p13(n);
     p14(n);
     p15(n);//pascal triangle 
       p16(n);
      p17(n);
       p18(n);//arrow
      //p19(n);//incomplete
     }
}