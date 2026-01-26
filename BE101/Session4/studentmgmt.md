# Bài tập hằng tuần
|||
|--|--|
|Học viên|Vũ Đức Mạnh - JBIOC62|
|Module|BE101 - Nhập môn CSDL - PostgreSQL|
|Nội dung bài tập|Quản lý thông tin sinh viên|

## Yêu cầu đề bài
### Mô tả
Bạn được giao nhiệm vụ quản lý dữ liệu sinh viên trong một lớp học. Bảng students lưu thông tin về tên, tuổi, chuyên ngành và GPA của sinh viên

Dữ liệu mẫu:
```SQL
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    major VARCHAR(50),
    gpa DECIMAL(3,2)
);

INSERT INTO students (name, age, major, gpa) VALUES
('An', 20, 'CNTT', 3.5),
('Bình', 21, 'Toán', 3.2),
('Cường', 22, 'CNTT', 3.8),
('Dương', 20, 'Vật lý', 3.0),
('Em', 21, 'CNTT', 2.9);

```

### Yêu cầu:

1. Thêm sinh viên mới: "Hùng", 23 tuổi, chuyên ngành "Hóa học", GPA 3.4
2. Cập nhật GPA của sinh viên "Bình" thành 3.6
3. Xóa sinh viên có GPA thấp hơn 3.0
4. Liệt kê tất cả sinh viên, chỉ hiển thị tên và chuyên ngành, sắp xếp theo GPA giảm dần
5. Liệt kê tên sinh viên duy nhất có chuyên ngành "CNTT"
6. Liệt kê sinh viên có GPA từ 3.0 đến 3.6
7. Liệt kê sinh viên có tên bắt đầu bằng chữ 'C' (sử dụng LIKE/ILIKE)
8. Hiển thị 3 sinh viên đầu tiên theo thứ tự tên tăng dần, hoặc lấy từ sinh viên thứ 2 đến thứ 4 bằng LIMIT và OFFSET

## Bài làm
### Thêm sinh viên mới
```SQL
INSERT INTO students (name, age, major, gpa) VALUES
('Hùng', 23, 'Hóa học', 3.4);
```

### Cập nhật điểm
```SQL
update students set gpa = 3.6 where name = 'Bình';
```
### Liệt kê sinh viên
#### Tất cả sinh viên
Trong trường hợp hai sinh viên có GPA bằng nhau thì được xếp theo mã số sinh viên.
```SQL
select name, major from students order by gpa desc, id asc;
```
#### Sinh viên chuyên ngành CNTT
Yêu cầu chọn tên sinh viên duy nhất.
```SQL
select name from students where major = 'CNTT' limit 1;
```
#### Liệt kê theo GPA
```SQL
select id, name, gpa from students where gpa between 3 and 3.6 order by gpa desc, id asc;
```
#### Liệt kê theo chữ cái đầu tên
```SQL
select * from students where name like 'C%';
```
#### Liệt kê tên tăng dần (Limit và Offset)
* Không có Offset (từ 1 đến 3):
```SQL
select * from students order by name asc limit 3;
```

* Có Offset (từ 2 đến 4):
```SQL
select * from students order by name asc limit 3 offset 1;
```

### Xóa sinh viên
**🔴 CẢNH BÁO QUAN TRỌNG:** Trong nghiệp vụ thực tế, ta không nên xóa tên một sinh viên vì điều này đồng nghĩa với việc ta buộc sinh viên này thôi học mà không có thông báo trước.
```SQL
delete from students where gpa < 3;
```
