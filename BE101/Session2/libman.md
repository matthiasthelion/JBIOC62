 Bài tập hằng tuần
|||
|--|--|
|Học viên|Vũ Đức Mạnh - JBIOC62|
|Module|BE101 - Nhập môn CSDL - PostgreSQL|
|Nội dung bài tập|Tạo cơ sở dữ liệu và bảng quản lý sách|
## Yêu cầu đề bài
### Mục tiêu
* Thực hành cài đặt PostgreSQL và pgAdmin
* Thực hành các câu lệnh DDL: `CREATE DATABASE`, `CREATE SCHEMA`, `CREATE TABLE`
* Làm quen với các kiểu dữ liệu cơ bản
 

### Mô tả/ Yêu cầu:

1. Tạo một database có tên `LibraryDB`
2. Trong database `LibraryDB`, tạo schema có tên `library`
3. Trong schema `library`, tạo bảng `Books` với các cột sau:
    * `book_id` (số nguyên, khóa chính, tự tăng)
    * `title` (chuỗi, tối đa 100 ký tự, không được null)
    * `author` (chuỗi, tối đa 50 ký tự, không được null)
    * `published_year` (số nguyên)
    * `price` (số thực)
4. Thực hành các câu lệnh:
    * Xem tất cả các database
    * Xem tất cả các schema trong database
    * Xem cấu trúc bảng `Books`


## Bài làm

### 1. Tạo database

```SQL
CREATE DATABASE LibraryDB;
```

### 2~3. Tạo schema và bảng (trong Query Tool của `LibraryDB`)
```SQL
CREATE SCHEMA library;
CREATE TABLE library.books (
    book_id int generated always as identity primary key,
    title varchar(100) not null,
    author varchar(50) not null,
    published_year int,
    price float(10, 2)
    );
```

### 4. Thực hành câu lệnh
#### a) Xem tất cả các database
```SQL
SELECT datname FROM pg_database WHERE datistemplate = false;
```
#### b) Xem tất cả các schema trong database
```SQL
SELECT schema_name FROM information_schema.schemata;
```
#### c) Xem cấu trúc bảng `Books`
```SQL
SELECT
    column_name,
    data_type,
    character_maximum_length,
    is_nullable,
    column_default
FROM
    information_schema.columns
WHERE
    table_name = 'Books'
ORDER BY
    ordinal_position;
```