package generic;

public class SuDungGeneric {
    public static void main(String[] args) {
        ClassGeneric<Integer> obj1 = new  ClassGeneric<>();

        obj1.addElement(10);
        obj1.addElement(20);
        obj1.addElement(15);
        obj1.addElement(7);

        System.out.println("Danh sách số: ");
        obj1.showList();

        ClassGeneric<String> obj2 = new  ClassGeneric<>();
        obj2.addElement("Cường");
        obj2.addElement("Dũng");
        obj2.addElement("Tiến");
        obj2.addElement("Nam");
        System.out.println("Danh sách chữ: ");
        obj2.showList();
    }
}
