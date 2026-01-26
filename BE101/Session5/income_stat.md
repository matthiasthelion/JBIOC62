# Bài tập hằng tuần
|||
|--|--|
|Học viên|Vũ Đức Mạnh - JBIOC62|
|Module|BE101 - Nhập môn CSDL - PostgreSQL|
|Nội dung bài tập|Phân tích doanh số bán hàng theo nhóm sản phẩm|

## Yêu cầu đề bài
### Mô tả
Giả sử bạn có 2 bảng dữ liệu sau:
Bảng `products (product_id, product_name, category)`

product_id|product_name|category
--|--|--
1|Laptop Dell|Electronics
2|iPhone 15|Electronics
3|Bàn học gỗ|Furniture
4|Ghế xoay|Furniture

 

Bảng `orders (order_id, product_id, quantity, total_price)`

order_id|product_id|quantity|total_price
--|--|--|--
101|1|2|2200
102|2|3|3300
103|3|5|2500
104|4|4|1600
105|1|1|1100

### Yêu cầu:

1. Viết truy vấn hiển thị tổng doanh thu (SUM(total_price)) và số lượng sản phẩm bán được (SUM(quantity)) cho từng nhóm danh mục (category)
    * Đặt bí danh cột như sau:
        * `total_sales` cho tổng doanh thu
        * `total_quantity` cho tổng số lượng
2. Chỉ hiển thị những nhóm có tổng doanh thu lớn hơn 2000
3. Sắp xếp kết quả theo tổng doanh thu giảm dần

## Bài làm
### Code:
```SQL

-- tạo bảng
CREATE TABLE products (
product_id int primary key,
product_name varchar(255),
category varchar(100)
);

CREATE TABLE orders (
order_id int primary key,
product_id int references products(product_id),
quantity int,
total_price int
);

-- insert dữ liệu
INSERT INTO products (product_id, product_name, category) VALUES
(1,'Laptop Dell','Electronics'),
(2,'iPhone 15','Electronics'),
(3,'Bàn học gỗ','Furniture'),
(4,'Ghế xoay','Furniture');

INSERT into orders (order_id, product_id, quantity, total_price) VALUES
(101,1,2,2200),
(102,2,3,3300),
(103,3,5,2500),
(104,4,4,1600),
(105,1,1,1100);

-- kiểm tra dữ liệu
select o.order_id, o.product_id, p.product_name, o.quantity, o.total_price
from orders o join products p on o.product_id = p.product_id;


-- yêu cầu chính
select p.category, sum(o.total_price) as total_sales, sum(o.quantity) as total_quantity
from orders o join products p on o.product_id = p.product_id
group by p.category;
```

### Kết quả:

![Kết quả truy vấn](/BE101/Session5/images/income_stat.png)