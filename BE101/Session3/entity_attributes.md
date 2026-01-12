# Bài tập hằng tuần
|||
|--|--|
|Học viên|Vũ Đức Mạnh - JBIOC62|
|Module|BE101 - Nhập môn CSDL - PostgreSQL|
|Nội dung bài tập|Xác định thực thể và thuộc tính|

## Yêu cầu đề bài
### Mô tả
Một hệ thống quản lý thư viện cần lưu trữ thông tin về:
* Sách (bao gồm tên sách, mã ISBN, tác giả, năm xuất bản, thể loại)
* Độc giả (bao gồm mã độc giả, họ tên, ngày sinh, địa chỉ, số điện thoại)
* Phiếu mượn sách (gồm mã phiếu, ngày mượn, ngày trả dự kiến, trạng thái)
 

### Yêu cầu:

* Xác định các thực thể chính trong hệ thống
* Liệt kê thuộc tính của từng thực thể
* Phân loại thuộc tính nào là khóa chính (Primary Key) và thuộc tính nào là khóa ngoại (Foreign Key) nếu có
* Vẽ sơ đồ ERD và các quan hệ giữa các thực thể

## Bài làm
### Xác định thực thể và thuộc tính
> Trong danh sách sau, các thực thể được in đậm là khóa chính, in nghiêng là khóa ngoại, có tham chiếu trong ngoặc đơn đi kèm.
* Danh mục sách
    * **Mã danh mục**
    * Tên danh mục
    * Trạng thái
* Sách
    * **Mã sách**
    * Số ISBN
    * Tên sách
    * Tên tác giả
    * Năm xuất bản
    * *Mã danh mục* (thực thể Danh mục sách, *cũng là thể loại sách*)
    * Trạng thái
* Ấn bản
    * **Mã ấn bản**
    * *Mã sách* (thực thể Sách)
    * Ngày nhập kho
    * Loại ấn bản (Printed - bản in, Digital - bản điện tử, Audio - bản sách nói)
    * Trạng thái
* Độc giả
    * **Mã độc giả**
    * Tên độc giả
    * Ngày sinh
    * Địa chỉ (xã, huyện, tỉnh)
    * Số điện thoại
    * Loại thẻ đọc (Thường, Sinh viên, Cán bộ GD, VIP, ...)
* Phiếu mượn sách
    * **Mã phiếu mượn sách**
    * *Mã độc giả* (thực thể Độc giả)
    * Ngày mượn sách
    * Ngày trả dự kiến
* Chi tiết phiếu mượn sách **(thực thể yếu)**
    * ***Mã phiếu mượn*** (thực thể Phiếu mượn sách)
    * ***Mã ấn bản*** (thực thể Ấn bản)
    * Trạng thái
    * Ngày trả thực tế

### Lược đồ quan hệ thực thể

![](/BE101/Session3/images/libman.png)

