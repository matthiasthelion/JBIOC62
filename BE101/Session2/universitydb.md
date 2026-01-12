 Bài tập hằng tuần
|||
|--|--|
|Học viên|Vũ Đức Mạnh - JBIOC62|
|Module|BE101 - Nhập môn CSDL - PostgreSQL|
|Nội dung bài tập|Thực hành thiết kế cơ sở dữ liệu quản lý sinh viên|
## Yêu cầu đề bài
### Mục tiêu
Thực hành thiết kế database nhỏ
Sử dụng DDL để tạo bảng, thêm quan hệ giữa bảng
Hiểu cách làm việc với database, schema, bảng và kiểu dữ liệu
 

### Mô tả/Yêu cầu
1. Tạo database `UniversityDB`
2. Trong database, tạo schema `university`
3. Trong schema, tạo 2 bảng:
    * Students:
        * `student_id` (số nguyên, khóa chính, tự tăng)
        * `first_name` (chuỗi, tối đa 50 ký tự, không null)
        * `last_name` (chuỗi, tối đa 50 ký tự, không null)
        * `birth_date` (ngày)
        * `email` (chuỗi, không null, duy nhất)
    * Courses:
        * `course_id` (số nguyên, khóa chính, tự tăng)
        * `course_name` (chuỗi, tối đa 100 ký tự, không null)
        * `credits` (số nguyên)
4. Tạo bảng phụ Enrollments để lưu thông tin sinh viên đăng ký khóa học:
    * `enrollment_id` (số nguyên, khóa chính, tự tăng)
    * `student_id` (khóa ngoại tham chiếu Students)
    * `course_id` (khóa ngoại tham chiếu Courses)
    * `enroll_date` (ngày đăng ký)
5. Thực hành các câu lệnh:
    * Xem danh sách database
    * Xem danh sách schema
    * Xem cấu trúc bảng `Students`, `Courses`, `Enrollments`


## Bài làm

### 1. Tạo database

```SQL
CREATE DATABASE UniversityDB;
```

### 2~3. Tạo schema và bảng (trong Query Tool của `UniversityDB`)
```SQL
create schema university;
create table university.students (
    student_id int generated always as identity primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    birth_date date,
    email varchar(120) unique not null
);
create table university.courses (
    course_id int generated always as identity primary key,
    course_name varchar(100) not null,
    credits int
);
```
### 4. Tạo bảng phụ (quản lý đăng ký học)
```SQL
create table university.enrollments (
    enrollment_id int generated always as identity primary key,
    student_id int references university.students(student_id),
    course_id int references university.courses(course_id),
    enroll_date date
);
```

### 5. Thực hành câu lệnh
#### a) Xem tất cả các database
```SQL
SELECT datname FROM pg_database WHERE datistemplate = false;
```
#### b) Xem tất cả các schema trong database
```SQL
SELECT schema_name FROM information_schema.schemata;
```
#### c) Xem cấu trúc bảng 
##### Bảng `Students`
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
    table_name = 'students'
ORDER BY
    ordinal_position;
```
##### Bảng `Courses`
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
    table_name = 'courses'
ORDER BY
    ordinal_position;
```
##### Bảng `Enrollments`
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
    table_name = 'enrollments'
ORDER BY
    ordinal_position;
```