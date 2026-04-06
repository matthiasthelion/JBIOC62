package tuy_bien_loi;

public class FindNotFoundInCart extends Exception{
    private String message = "Lỗi: Không tìm thấy sản phẩm trong giỏ hàng";

    public FindNotFoundInCart(){
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
