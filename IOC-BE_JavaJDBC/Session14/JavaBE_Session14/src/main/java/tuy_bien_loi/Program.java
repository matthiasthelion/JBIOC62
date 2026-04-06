package tuy_bien_loi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product("p01", "Máy tính", 15000000D));
        products.add(new Product("p02", "Tivi", 3000000D));
        products.add(new Product("p03", "Tủ lạnh", 8000000D));
        products.add(new Product("p04", "Máy chiếu", 12000000D));
        products.add(new Product("p05", "Máy khâu", 7000000D));
        products.add(new Product("p06", "Máy cày", 1200000000D));
        products.add(new Product("p07", "Bàn là", 230000D));
        products.add(new Product("p08", "Điện thoại", 6000000D));
        products.add(new Product("p09", "Bình uống nước", 120000D));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose;

        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("=================== MENU ===================");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xoá sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Thanh toán");
            System.out.println("0. Thoát");
            System.out.println("=====================================");
            System.out.println("Lựa chọn của bạn: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("============ Danh sách sản phẩm ==========");
                    for (Product p : products) {
                        System.out.printf("| %-15s| %-20s| %-15.2f|\n", p.getId(), p.getName(), p.getPrice());
                    }
                    break;
                case 2:
                    String proId;
                    Product p;
                    while (true) {
                        System.out.println("Nhập mã sản phẩm cần thêm vào giỏ hàng: ");
                        proId = sc.nextLine();
                        if (proId.isEmpty()) {
                            System.out.println("Bạn chưa nhập mã sản phẩm");
                        } else {
                            p = productExist(proId);
                            if (p == null) {
                                System.err.println("Sản phẩm không có trong kho hàng!");
                            } else {
                                break;
                            }
                        }
                    }

                    //Nhap vao so luong can them vao gio hang
                    int quantity;
                    while (true) {
                        System.out.println("Nhập số lượng sản phẩm thêm vào giỏ hảng: ");
                        String strQuantity = sc.nextLine();
                        if (strQuantity.isEmpty()) {
                            System.err.println("Nhập sai số lượng");
                        } else {
                            try {
                                quantity = Integer.parseInt(strQuantity);
                                if (quantity < 1) {
                                    System.err.println("Số âm hoặc bằng 0");
                                } else {
                                    break;
                                }
                            } catch (Exception e) {
                                System.err.println("Lỗi: Số lượng không hợp lệ!");
                            }
                        }
                    }

                    cart.addToCart(p, quantity);
                    break;
                case 3:

                    System.out.println("Nhập mã sản phẩm cần xoá khỏi giỏ hàng: ");
                    proId = sc.nextLine();
                    if (proId.isEmpty()) {
                        System.out.println("Bạn chưa nhập mã sản phẩm");
                    }else{
                        cart.removeFromCart(proId);
                    }
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 5:
                    cart.checkout();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không đúng!");
            }
        }
    }

    private static Product productExist(String proId) {
        for (Product p : products) {
            if (p.getId().equals(proId)) {
                return p;
            }
        }
        return null;
    }


}
