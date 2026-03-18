import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class CustomerMgmt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer customer1 = new Customer();
        System.out.print("Nhập thông tin khách hàng thứ nhất: ");
        customer1.setName(sc.nextLine());
        customer1.setMale(Boolean.parseBoolean(sc.nextLine()));
        customer1.setBirthDate(LocalDate.parse(sc.nextLine()));
        customer1.setAddress(sc.nextLine());
        customer1.setPhone(sc.nextLine());
        customer1.setEmail(sc.nextLine());
        System.out.println("Nhập thông tin khách hàng thứ hai: ");
        String name = sc.nextLine();
        Boolean isMale = Boolean.parseBoolean(sc.nextLine());
        LocalDate birthDate = LocalDate.parse(sc.nextLine());
        String address = sc.nextLine();
        String phone = sc.nextLine();
        String email = sc.nextLine();
        Customer customer2 = new Customer(name, isMale, birthDate, email, phone, address);
        System.out.println("------------------------------\nChú ý: Mã khách hàng được tạo ngẫu nhiên nên có thể khác nhau mỗi lần chạy chương trình.\n------------------------------");
        System.out.println("Thông tin hai khách hàng đã nhập: ");
        System.out.println(customer1);
        System.out.println(customer2);
        sc.close();
    }
}
class Customer {
    private String id;
    private String name;
    private Boolean isMale;
    private LocalDate birthDate;
    private String address;
    private String email;
    private String phone;

    public Customer() {
    }

    public Customer(String name, Boolean isMale, LocalDate birthDate, String email, String phone, String address) {
        setId();
        this.name = name;
        this.isMale = isMale;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    //setters
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMale(Boolean isMale) {
        this.isMale = isMale;
    }
    public void setId() {
        Random rd = new Random();
        this.id = String.format("%03d", rd.nextInt(300))+"-"+String.format("%02d", rd.nextInt(80))+
                "-"+String.format("%04d", rd.nextInt(9999));
    }

    @Override
    public String toString() {
        return isMale ? "Anh " : "Chị " + name.toUpperCase()+"\n"+
                "\tMã khách hàng: "+id+"\n"+
                "\tNgày sinh: "+birthDate+"\n"+
                "\tEmail: "+email+"\n"+
                "\tSố điện thoại: "+phone +"\n"+
                "\tĐịa chỉ: "+address;

    }
}

/*TEST DATA:
Chu Đình Bảo
true
2001-02-16
Phường Thành Sen, TP Hà Tĩnh
0771984894
baocd.htn194923@techmaster.edu
Lê Thị Thanh Hằng
false
1998-06-12
Phường Lang Biang, TP Đà Lạt, Lâm Đồng
0531158749
hangltt.ldg160227@techmaster.edu

*/