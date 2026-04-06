package demo_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SuDungMap {
    public static void main(String[] args) {
        Map<Integer, String> list = new HashMap<Integer, String>();

        list.put(5, "Cường");
        list.put(5, "Bình");
        list.put(5, "Tiến");
        list.put(5, "Dũng");
        list.put(5, "Mai");
        list.put(5, "Tuyết");

        System.out.println("Duyệt theo key set: ");
        Set<Integer> keys = list.keySet();
        for(Integer key : keys){
            System.out.println(key+"\t"+list.get(key));
        }

        System.out.println("\nDuyệt theo Map.entry<K,V>: ");

        for(Map.Entry<Integer, String> entry : list.entrySet()){
            System.out.println("Key: "+entry.getKey()+"\tValue: "+entry.getValue());
        }
    }
}
