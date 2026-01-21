# Bài tập hằng tuần
|||
|--|--|
|Học viên|Vũ Đức Mạnh - JBIOC62|
|Module|BE101 - Nhập môn CSDL - PostgreSQL|
|Nội dung bài tập|Xác định thực thể và thuộc tính|

## Yêu cầu đề bài
### Mô tả
Giả sử bạn có bảng `order_detail` lưu thông tin chi tiết đơn hàng:

```SQL
CREATE TABLE order_detail (
    id SERIAL PRIMARY KEY,
    order_id INT,
    product_name VARCHAR(100),
    quantity INT,
    unit_price NUMERIC
);
```
 

### Yêu cầu:

Viết một Stored Procedure có tên `calculate_order_total(order_id_input INT, OUT total NUMERIC)`
* Tham số `order_id_input`: mã đơn hàng cần tính
* Tham số `total`: tổng giá trị đơn hàng
* Trong Procedure:
    * Viết câu lệnh tính tổng tiền theo `order_id`
* Gọi Procedure để kiểm tra hoạt động với một `order_id` cụ thể

## Bài làm
### Stored Procedure
``` SQL
create procedure calculate_order_total(
    order_id_input INT, 
    OUT total NUMERIC --dữ liệu đề bài cung cấp
)
language plpgsql
as $$
begin
    select sum(quantity * unit_price) into total from order_detail where order_id = order_id_input
end $$

```
### Chạy thử chương trình
Code:
```SQL

-- tạo bảng
CREATE TABLE order_detail (
    id SERIAL PRIMARY KEY,
    order_id INT,
    product_name VARCHAR(100),
    quantity INT,
    unit_price NUMERIC
);

-- dữ liệu mẫu
INSERT INTO order_detail (order_id, product_name, quantity, unit_price) VALUES
(1001, 'Wireless Mouse', 2, 15.99),
(1001, 'USB-C Cable', 3, 7.49),
(1002, 'Laptop Stand', 1, 29.95),
(1003, 'Bluetooth Keyboard', 1, 45.00),
(1003, 'Monitor 24-inch', 2, 129.99),
(1004, 'Webcam HD', 1, 39.99),
(1005, 'External SSD 1TB', 1, 109.50),
(1005, 'Laptop Sleeve', 2, 18.75),
(1006, 'Noise Cancelling Headphones', 1, 199.99),
(1007, 'Portable Charger', 3, 22.49);

-- đổ dữ liệu bảng 
SELECT * FROM order_detail order by order_id asc;

-- stored procedure
create or replace procedure calculate_order_total(
    order_id_input INT,
    OUT total NUMERIC --dữ liệu đề bài cung cấp
)
language plpgsql
as $$
begin
    select sum(quantity * unit_price) into total from order_detail where order_id = order_id_input group by order_id;
end $$;

-- chạy thử procedure
DO $$
    DECLARE
      order_id_l int;
      total numeric;
    BEGIN
      FOR order_id_l IN SELECT distinct order_id FROM order_detail order by order_id LOOP
        call calculate_order_total(order_id_l, total);
        raise notice 'Order # % : % GBP', order_id_l, total;
      END LOOP;
END $$;
```
Kết quả:
![Kết quả test](/BE101/Session8/images/procedure_ordersum.png)

Kiểm tra tính toán bằng Excel:
![Kết quả Excel](/BE101/Session8/images/procedure_ordersum_excel.png)