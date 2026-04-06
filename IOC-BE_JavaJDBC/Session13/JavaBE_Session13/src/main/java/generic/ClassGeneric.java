package generic;

import java.lang.reflect.Array;

public class ClassGeneric <T>{
    private T list[];
    private int total = 0;

    public ClassGeneric(){
        list = (T[]) new Object[100];
    }

    public void addElement(T element){
        if(total==100){
            System.out.println("Danh sách đầy");
            return;
        }
        list[total++] = element;
    }

    public void showList(){
        if(total==0){
            System.out.println("Danh sách rỗng");
            return;
        }
        for(int i=0;i<total;i++){
            System.out.print(list[i]+"\t");
        }
        System.out.println();
    }

    public T getElement(int index){
        if(index<0 || index>=total){
            System.out.println("Chỉ số không có!");
            return null;
        }
        return list[index];
    }
}
