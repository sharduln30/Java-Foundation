import java.util.*;

public class highestFrequencyCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }else{
                hm.put(ch, 1);
            }
        }
        char mcf=str.charAt(0);
        for(char key:hm.keySet()){
            if(hm.get(key)>hm.get(mcf)){
                mcf=key;
            }
        }
        System.out.println(mcf);
    }
}