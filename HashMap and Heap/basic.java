import java.util.*;

class basic {
    public static void main(String[] args) {
       HashMap<String,Integer> hm = new HashMap<>();
       hm.put("apple", 80);
       hm.put("banana", 40);
       hm.put("orange", 60);
       hm.put("ananas", 50);
       hm.put("grapes", 100);

       System.out.println(hm);

       System.out.println(hm.get("apple"));
       System.out.println(hm.get("banana"));

       System.out.println(hm.containsKey("grapes"));
       System.out.println(hm.containsKey("fruit"));

       System.out.println(hm.put("grapes",120));
       System.out.println(hm.put("mango",90));
       System.out.println(hm);

       HashSet<String> keys = new HashSet<>(hm.keySet());

       for(String key:keys){
           System.out.println(key+" -> "+hm.get(key));
       }
    }
}