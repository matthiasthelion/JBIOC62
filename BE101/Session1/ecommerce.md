# Bài tập hằng tuần
|||
|--|--|
|Học viên|Vũ Đức Mạnh - JBIOC62|
|Module|BE101 - Nhập môn CSDL - PostgreSQL|
|Nội dung bài tập|Hệ thống quản lý đơn hàng Thương mại điện tử|
## Yêu cầu đề bài
### Mục tiêu
* Vận dụng mô hình **thực thể – quan hệ (ER)** để mô tả nghiệp vụ mua bán online
* Phân biệt rõ **mối quan hệ 1–n** và **n–n** trong tình huống thực tế
* Chuẩn hóa sơ đồ để tránh dư thừa dữ liệu
 

### Mô tả
Một trang web bán hàng trực tuyến cần quản lý thông tin về:

* **Khách hàng (Customer):** mã khách hàng, họ tên, email, số điện thoại, địa chỉ
* **Sản phẩm (Product):** mã sản phẩm, tên sản phẩm, giá, mô tả, loại hàng
* **Đơn hàng (Order):** mã đơn, ngày đặt hàng, tổng tiền, trạng thái
* **Chi tiết đơn hàng (OrderDetail):** số lượng, đơn giá tại thời điểm mua
* **Nhân viên (Staff):** mã nhân viên, họ tên, vị trí, ngày vào làm
 

### Yêu cầu:

* Xác định các **thực thể** và **thuộc tính** chính
* Xác định **mối quan hệ** giữa các thực thể, ví dụ:
    * Khách hàng **đặt** nhiều đơn hàng
    * Một đơn hàng **chứa** nhiều sản phẩm
    * Nhân viên **xử lý** đơn hàng
* Vẽ **sơ đồ ERD** thể hiện các thực thể, mối quan hệ, và ràng buộc (1–n, n–n)
* Ghi chú **khóa chính (PK), khóa ngoại (FK)** rõ ràng trong sơ đồ


## Bài làm
### Thực thể và Thuộc tính chính
1. Thực thể: Người dùng (User)
    * **Mã người dùng**
    * Username
    * Mật khẩu (mã hóa)
    * Họ tên người dùng
    * Email
    * Số điện thoại
    * Quyền người dùng
    * Địa chỉ (xã, huyện, tỉnh)
    * Trạng thái
2. Thực thể: Quyền người dùng
    * **Mã quyền**
    * Tên quyền
3. Thực thể: Nhà cung cấp
    * **Mã nhà cung cấp**
    * Tên nhà cung cấp
    * Địa chỉ
    * Số điện thoại
    * Email
    * Tên người đại diện
    * Trạng thái
4. Thực thể: Hợp đồng lao động
    * **Mã hợp đồng lao động**
    * Mã nhân viên (user_id)
    * Ngày ký hợp đồng
    * Ngày hết hạn hợp đồng
5. Thực thể: Sản phẩm
    * Mã sản phẩm (mã SKU)
    * Mã vạch bao bì
    * Danh mục sản phẩm
    * Nhà cung cấp
    * Giá sản phẩm (tính bằng VND)
    * Mô tả sản phẩm
    * Trạng thái
6. Thực thể: Danh mục sản phẩm
    * Mã danh mục
    * Tên danh mục
    * Ảnh danh mục (cloud link)
    * Mô tả
    * Trạng thái
7. Thực thể: Giỏ hàng
    * Mã khách hàng (user_id)
    * Mã sản phẩm
    * Số lượng
8. Thực thể: Đơn hàng
    * Mã đơn hàng (order_id)
    * Mã khách hàng (user_id)
    * Ngày đặt hàng
    * Người nhận hàng
    * Hình thức vận chuyển (delivery_type)
    * Địa chỉ giao hàng
    * Số điện thoại
    * Hình thức thanh toán
    * Trạng thái

9. Thực thể yếu: order_detail (lưu thông tin chi tiết về đơn hàng)
    * Mã đơn hàng
    * Mã sản phẩm
    * Số lượng
    * Giá bán

---
**_Ghi chú:_**
* **Đối với các thuộc tính Địa chỉ:** Địa chỉ được ghi theo bản đồ hành chính 34 tỉnh thành từ tháng 7/2025 hoặc bản đồ hành chính 63 tỉnh thành từ tháng 01/2025 (TP Huế trực thuộc trung ương, có 02 quận trực thuộc thành phố), nhưng đều phải ghi chi tiết địa chỉ từ cấp xã/phường đến cấp tỉnh/TP trực thuộc TW (từ số nhà đến thôn/ tổ dân phố có thể bỏ qua).
* **Đối với thuộc tính Ngày ký hợp đồng lao động tại thực thể Nhân viên:** Chỉ ghi nhận ngày ký hợp đồng lao động đầu tiên, không ghi nhận ngày ký hợp đồng gia hạn lao động.
---


### Quan hệ giữa các thực thể
- Một danh mục có nhiều sản phẩm nhưng mỗi sản phẩm chỉ thuộc về một danh mục ==> thuộc tính Danh mục sản phẩm tại thực thể Sản phẩm
- Một nhà cung cấp có nhiều sản phẩm nhưng một sản phẩm chỉ thuộc về một nhà cung cấp ==> thuộc tính Nhà cung cấp tại thực thể Sản phẩm
- Một quyền có thể gán cho nhiều người dùng nhưng một người dùng chỉ có thể được gán một quyền. ==> thuộc tính Quyền người dùng tại thực thể Người dùng
- Một nhân viên (người dùng) có thể có nhiều hợp đồng lao động, nhưng một hợp đồng lao động chỉ thuộc về một nhân viên ==> thuộc tính Mã nhân viên tại thực thể Hợp đồng lao động
- Trong giỏ hàng có thể có nhiều người cùng chọn một sản phẩm, và một người cũng có thể được chọn nhiều sản phẩm ==> Giỏ hàng là thực thể trung gian giữa Người dùng và Sản phẩm.
- Một người dùng có nhiều đơn hàng nhưng một đơn hàng chỉ thuộc về một người dùng ==> thuộc tính Mã khách hàng tại thực thể Đơn hàng.
- Một đơn hàng có nhiều chi tiết nhưng một bản ghi chi tiết chỉ thuộc về một đơn hàng ==> thuộc tính Mã đơn hàng tại thực thể Chi tiết đơn hàng
- Một sản phẩm thuộc về nhiều chi tiết đơn hàng nhưng một bản ghi chi tiết chỉ chứa một sản phẩm ==> thuộc tính Mã sản phẩm tại thực thể Chi tiết đơn hàng
### Lược đồ quan hệ thực thể
![](/BE101/Session1/ecommerce.png)