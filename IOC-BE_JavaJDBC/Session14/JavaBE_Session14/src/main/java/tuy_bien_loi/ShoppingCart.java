package tuy_bien_loi;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        //Kiem tra sản phẩm đã có trong giỏ hàng hay không?
        boolean blExists = false;
        for (CartItem c : cartItems) {
            if (c.getProduct().getId().equals(product.getId())) {
                //San pham da nam trong gio hang
                blExists = true;
                c.setQuantity(c.getQuantity() + quantity);
                break;
            }
        }
        if (!blExists){
            //San pham chua co trong gio hang
            CartItem cNew = new CartItem(product, quantity);
            cartItems.add(cNew);
        }
        System.err.println("Đã thêm sản phẩm "+product.getName()+" vào giỏ hàng");
    }

    public void removeFromCart(String productId){
        boolean blExists = false;
        for(CartItem c: cartItems){
            if(c.getProduct().getId().equals(productId)){
                blExists = true;
                cartItems.remove(c);
                break;
            }
        }
        if(blExists){
            System.out.println("Đã xoá sản phẩm khỏi giỏ hàng");
        }else{
            System.out.println(new FindNotFoundInCart().getMessage());
        }
    }

    public void displayCart(){
        if(cartItems==null || cartItems.size()==0){
            System.err.println("Chưa có sản phẩm trong giỏ hàng");
            return;
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("-------- Danh sách sản phẩm trong giỏ hàng --------");
        for(CartItem c: cartItems){
            System.out.println("|"+c.getProduct().getId()+"\t|"+c.getProduct().getName()+"\t|"+c.getQuantity()+"\t|"+nf.format(c.getProduct().getPrice())+"\t|");
        }
    }
    public void checkout(){
        double totalMoney = 0;
        for(CartItem c: cartItems){
            totalMoney += c.getProduct().getPrice()*c.getQuantity();
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("=============================");
        System.out.println("Tổng số tiền cần thanh toán là: "+nf.format(totalMoney));
    }
}
