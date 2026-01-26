# Bài tập hằng tuần
|||
|--|--|
|Học viên|Vũ Đức Mạnh - JBIOC62|
|Module|BE101 - Nhập môn CSDL - PostgreSQL|
|Nội dung bài tập|Quản lý sản phẩm cửa hàng|

## Yêu cầu đề bài
### Mô tả
Bạn quản lý một bảng `products` lưu thông tin sản phẩm gồm tên, danh mục, giá và số lượng tồn kho
```SQL
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR (50),
    category VARCHAR(50),
    price DECIMAL(10,2),
    stock INT

);

INSERT INTO products (name, category, price, stock) VALUES
('Laptop Dell', 'Electronics', 1500.00, 5),
('Chuột Logitech', 'Electronics', 25.50, 50),
('Bàn phím Razer', 'Electronics', 120.00, 20),
('Tủ lạnh LG', 'Home Appliances', 800.00, 3),
('Máy giặt Samsung', 'Home Appliances', 600.00, 2);
```
### Yêu cầu:
* Thêm sản phẩm mới: 'Điều hòa Panasonic', category 'Home Appliances', giá 400, stock 10
* Cập nhật stock của 'Laptop Dell' thành 7
* Xóa các sản phẩm có stock bằng 0 (nếu có)
* Liệt kê tất cả sản phẩm theo giá tăng dần
* Liệt kê danh mục duy nhất của các sản phẩm (DISTINCT)
* Liệt kê sản phẩm có giá từ 100 đến 1000
* Liệt kê các sản phẩm có tên chứa từ 'LG' hoặc 'Samsung' (sử dụng LIKE/ILIKE)
* Hiển thị 2 sản phẩm đầu tiên theo giá giảm dần, hoặc lấy sản phẩm thứ 2 đến thứ 3 bằng LIMIT và OFFSET

## Bài làm
### Thêm sản phẩm mới
```SQL
INSERT INTO products (name, category, price, stock) VALUES
('Điều hòa Panasonic', 'Home Appliances', 400.00, 10);
```
### Cập nhật tồn kho
```SQL
update products set stock = 7 where name = 'Laptop Dell';
```
### Liệt kê theo giá tăng dần
> Trong trường hợp này, các sản phẩm đồng giá được xếp theo mã sản phẩm.
``` SQL
select * from products order by price asc, id asc;
```
### Liệt kê danh mục duy nhất
``` SQL
select distinct category from products order by id asc;
```
### Liệt kê theo khoảng giá
```SQL
select * from products where price between 100 and 1000 order by price asc, id asc;
```
### Tìm sản phẩm theo hãng
```SQL
select * from products where name like '%LG%' or name like '%Samsung%'
```
### Hiển thị có Limit
#### Không có Offset
```SQL
select * from products order by price desc limit 2;
```
#### Có Offset
```SQL
select * from products order by price desc limit 2 offset 1;
```
### Xóa sản phẩm
> Ta xóa sản phẩm có stock bằng không, nghĩa là ta ngừng kinh doanh sản phẩm đó.
``` SQL
delete from products where stock = 0;
```