# Bài tập hằng tuần
|||
|--|--|
|Học viên|Vũ Đức Mạnh - JBIOC62|
|Module|BE101 - Nhập môn CSDL - PostgreSQL|
|Nội dung bài tập|Tìm sản phẩm bán chạy nhất và so sánh doanh thu giữa các nhóm|

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

1. Viết truy vấn con (Subquery) để tìm sản phẩm có doanh thu cao nhất trong bảng `orders`. Hiển thị: `product_name`, `total_revenue`
2. Viết truy vấn hiển thị tổng doanh thu theo từng nhóm category (dùng `JOIN` + `GROUP BY`)
3. Dùng `INTERSECT` để tìm ra nhóm category có sản phẩm bán chạy nhất (ở câu 1) cũng nằm trong danh sách nhóm có tổng doanh thu lớn hơn 3000

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

-- yêu cầu 1
select product_name, os.total_revenue
from products p
join (select product_id, sum(total_price) as total_revenue from orders o group by product_id) as os on p.product_id = os.product_id
order by p.product_id asc;

-- yêu cầu 2
select p.category, sum(o.total_price) as total_sales, sum(o.quantity) as total_quantity
from orders o join products p on o.product_id = p.product_id
group by p.category;

-- yêu cầu 3
-- Category của sản phẩm có doanh thu cao nhất
SELECT p.category
FROM products p
WHERE p.product_id = (
    SELECT o.product_id
    FROM orders o
    GROUP BY o.product_id
    ORDER BY SUM(o.total_price) DESC
    LIMIT 1
)

INTERSECT

-- Category có tổng doanh thu > 3000
SELECT p.category
FROM products p
JOIN orders o ON p.product_id = o.product_id
GROUP BY p.category
HAVING SUM(o.total_price) > 3000;

```

### Kết quả:

![Kết quả truy vấn](/BE101/Session5/images/sq_total-revenue.png)