 Bài tập hằng tuần
|||
|--|--|
|Học viên|Vũ Đức Mạnh - JBIOC62|
|Module|BE101 - Nhập môn CSDL - PostgreSQL|
|Nội dung bài tập|Thiết kế hệ thống quản lý bán hàng|
## Yêu cầu đề bài
### Mục tiêu
* Thực hành tạo database, schema, bảng bằng PostgreSQL
* Hiểu cách thiết kế cơ sở dữ liệu với nhiều bảng có quan hệ với nhau
* Thực hành ràng buộc dữ liệu cơ bản: khóa chính (PK), khóa ngoại (FK), `NOT NULL`, `UNIQUE`, `CHECK`
 

### Mô tả/ Yêu cầu:

1. Tạo database và schema
* Database: `SalesDB`
* Schema: `sales` (giúp nhóm các bảng lại với nhau)
2. Tạo các bảng và cột
* Bảng `Customers` (khách hàng)
    * `customer_id`: số nguyên tự tăng, khóa chính
    * `first_name`: tên, tối đa 50 ký tự, không được bỏ trống
    * `last_name`: họ, tối đa 50 ký tự, không được bỏ trống
    * `email`: email khách hàng, không trùng nhau, không được bỏ trống
    * `phone`: số điện thoại (có thể bỏ trống)
 

* Bảng Products (sản phẩm)
    * `product_id`: số nguyên tự tăng, khóa chính
    * `product_name`: tên sản phẩm, tối đa 100 ký tự, không bỏ trống
    * `price`: giá sản phẩm, kiểu số thực, không bỏ trống
    * `stock_quantity`: số lượng còn trong kho, kiểu số nguyên, không bỏ trống
 

* Bảng Orders (đơn hàng)
    * `order_id`: số nguyên tự tăng, khóa chính
    * `customer_id`: tham chiếu đến khách hàng (khóa ngoại)
    * `order_date`: ngày đặt hàng, không được bỏ trống
 

* Bảng OrderItems (chi tiết đơn hàng, mỗi đơn hàng có nhiều sản phẩm)
    * `order_item_id`: số nguyên tự tăng, khóa chính
    * `order_id`: tham chiếu đến bảng Orders (khóa ngoại)
    * `product_id`: tham chiếu đến bảng Products (khóa ngoại)
    * `quantity`: số lượng sản phẩm trong đơn, không được nhỏ hơn 1


## Bài làm

### 1. Tạo database

```SQL
CREATE DATABASE SalesDB;
```

### 2~3. Tạo schema và các bảng (trong Query Tool của `SalesDB`)
```SQL
create schema sales;
create table sales.customers (
    customer_id int generated always as identity primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email text unique not null check (email like '%_@__%.__%'),
    phone varchar(12) -- số điện thoại di động có 10 chữ số, số điện thoại bàn có 11 chữ số
);
create table sales.products (
    product_id int generated always as identity primary key,
    product_name varchar(100) not null,
    price float(10, 0) not null, -- đơn vị đồng Việt Nam, độ chia nhỏ nhất 100 đồng
    stock_quantity int not null
);
create table orders (
    order_id int generated always as identity primary key,
    customer_id int references sales.customers(customer_id),
    order_date date,
);
create table sales.orderitems(
    order_item_id int generated always as identity primary key,
    order_id int references sales.orders(order_id),
    product_id int references sales.products(product_id),
    quantity int check quantity > 1;
);
```
