package demo_set;

import java.util.*;

public class SuDungSet {
    public static void main(String[] args) {
        Set<String> ds = new HashSet<String>();
        ds.add("Cường");
        ds.add("Bình");
        ds.add("Nam");
        ds.add("Cường");
        ds.add("Nam");

        System.out.println("Có "+ds.size()+" sinh viên!");

        for(String s: ds){
            System.out.println(s);
        }

        System.out.println("\nDanh sách theo Iterator: ");
        Iterator<String> it = ds.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        List<String> list = new ArrayList<String>(ds);
    }
}
