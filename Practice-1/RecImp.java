package Practice;
class RecImp {

    static void subseq(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        subseq(str.substring(1), ans+str.charAt(0));
        subseq(str.substring(1), ans);
    }
   // static void kpc(String str, )
    public static void main(String[] args){

        subseq("abc","");
      //  kpc("abc");
    }
}