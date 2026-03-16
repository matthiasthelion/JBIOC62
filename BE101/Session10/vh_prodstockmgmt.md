# Bài tập hằng tuần
|Học viên|Module|Nội dung bài tập|
|--|--|--|
|Vũ Đức Mạnh - JBIOC62|BE101 - Nhập môn CSDL - PostgreSQL|Quản lý tồn kho tự động cho cửa hàng trực tuyến|

## Yêu cầu đề bài
### Mô tả
* Bảng products lưu thông tin sản phẩm (id, name, stock)
* Bảng orders lưu đơn hàng (id, product_id, quantity, order_status)
* Yêu cầu Trigger:
    * Khi tạo đơn hàng mới: giảm tồn kho theo số lượng
    * Khi chỉnh sửa đơn hàng: điều chỉnh tồn kho theo sự thay đổi số lượng
    * Khi hủy/xóa đơn hàng: trả lại tồn kho tương ứng
    * Chỉ cho phép insert/update nếu tồn kho đủ, ngăn chặn đơn hàng vượt quá số lượng hiện có
* Tình huống ứng dụng: tự động quản lý kho, giảm rủi ro oversale, chuẩn hóa dữ liệu kho hàng

### Yêu cầu:

* Sinh viên tự viết Function Trigger bằng PL/pgSQL
* Tạo Trigger gắn với bảng orders
* Thực hành insert/update/delete đơn hàng, kiểm tra tồn kho products

## Bài làm
