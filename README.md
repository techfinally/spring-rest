# spring-rest

## 1. REST và RESTful API


REST là viết tắt của REpresentational State Transfer là kiến trúc sử dụng cho việc truyền tải dữ liệu trong mạng. REST áp dụng phổ biến cho các WebApp nhưng cũng hoàn toàn có thể sử dụng cho các phần mềm nói chung.

REST lần đầu tiên được giới thiệu vào năm 2000 trong luận văn tiến sĩ của Roy Thomas Fielding (đồng sáng lập giao thức HTTP). Trong luận văn ông giới thiệu khá chi tiết về các ràng buộc, quy ước.

## 2. Nguyên tắc thiết kế của REST API

### 2.1 Dùng HTTP method phù hợp.

* GET (SELECT): Trả về một Resource hoặc một danh sách Resource.
* POST (CREATE): Tạo mới một Resource.
* PUT (UPDATE): Cập nhật thông tin cho Resource.
* PATCH (UPDATE): Cập nhật một thành phần, thuộc tính của Resouce.
* DELETE (DELETE): Xoá một Resource.
* HEAD – Trả về thông tin chung của một hoặc danh sách Resource.
* OPTIONS – Trả về thông tin mà người dùng được phép với Resource.

### 2.2 Dữ liệu trả về định dạng nên là JSON.

JSON hay XML? Hầu hết những người viết RESTful API thường lựa chọn JSON.

### 2.3 Sử dụng danh từ số nhiều và không sử dụng động từ



FAILE

### 2.4 Sử dụng danh từ số nhiều và không sử dụng động từ