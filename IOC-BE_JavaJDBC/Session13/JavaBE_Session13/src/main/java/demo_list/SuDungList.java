package demo_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SuDungList {
    public static void main(String[] args) {
        List<Integer> ds = new ArrayList<Integer>();
        ds.add(1);
        ds.add(15);
        ds.add(3);
        ds.add(20);
        ds.add(5);
        ds.add(10);

        System.out.println("Duyệt cổ điển: ");
        for (int i = 0; i<ds.size();i++){
            System.out.print(ds.get(i)+"\t");
        }

        System.out.println("\nDuyệt theo for-each: ");
        for (Integer v : ds){
            System.out.print(v+"\t");
        }

        System.out.println("\nDuyệt theo interator: ");
        Iterator<Integer> it1 = ds.iterator();
        while(it1.hasNext()){
            System.out.print(it1.next()+"\t");
        }
        System.out.println("\nDuyệt theo ListIterator: ");
        ListIterator<Integer> it2 = ds.listIterator();
        while(it2.hasNext()){
            System.out.print(it2.next()+"\t");
        }

        System.out.println("\nDuyệt ngược với ListIterator: ");
        while(it2.hasPrevious()){
            System.out.print(it2.previous()+"\t");
        }
    }
}
