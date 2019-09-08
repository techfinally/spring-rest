# Spring Boot - REST - RESTful API

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

Nên sử dụng danh từ số nhiều.
Không sử dụng động từ.

### 2.4 Luôn đánh dấu phiên bản

Luôn sử dụng đánh dấu version giúp bạn dễ dàng khi nâng cấp phiên bản API cũng như hỗ trợ phiên bản cũ trong một khoảng thời gian nào đó.

```
http://localhost:8080/api/v1/employees/
```

### 2.5 Bảo mật

* Luôn sử dụng một mã bí mật access_token với mỗi yêu cầu được gởi đến. 
* Luôn sử dụng SSL.

### 2.6 Dữ liệu trả về

Dữ liệu trả về nên có định dạng cố định để dể dàng sử dụng hơn.

```
{
	"code": 200,
	"data": {
		"empNo": "20200010",
		"empName": "Truong Duong",
		"empMail": "truongduong@techfinally.com",
		"empPhone": "+84.886.987.987"
	}
}
```

```
{
	"code": 200,
	"data": [
		{
			"empNo": "20200010",
			"empName": "Truong Duong",
			"empMail": "truongduong@techfinally.com",
			"empPhone": "+84.886.987.987"
		},
		{
			"empNo": "20701210",
			"empName": "Minh Nguyen",
			"empMail": "minhnguyen@techfinally.com",
			"empPhone": "+84.356.123.321"
		}
	],
}
```

### 2.7 Phân trang

Dữ liệu trả về nhiều sẽ nên gây tốn kém tài nguyên, đồng thời không hữu dụng khi phần kích thước màn hình có hạn.

```
http://localhost:8080/api/v1/employees?page=2
```

### 2.8 Trạng thái

* 200 OK – Trả về thành công cho những phương thức GET, PUT, PATCH hoặc DELETE.
* 201 Created – Trả về khi một Resouce vừa được tạo thành công.
* 204 No Content – Trả về khi Resource xoá thành công.
* 304 Not Modified – Client có thể sử dụng dữ liệu cache.
* 400 Bad Request – Request không hợp lệ
* 401 Unauthorized – Request cần có sự authentication.
* 403 Forbidden – Server hiểu request nhưng bị từ chối không cho phép.
* 404 Not Found – Không tìm thấy rource từ URI
* 405 Method Not Allowed – Phương thức không cho phép với user hiện tại.
* 410 Gone – Resource không còn tồn tại, Version cũ đã không còn hỗ trợ.
* 415 Unsupported Media Type
* 422 Unprocessable Entity – Dữ liệu không được kiểm chứng
* 429 Too Many Requests – Request bị từ chối do bị giới hạn

### 2.9 Lựa chọn snake_case hay camelCase

Giữa snake_case hay camelCase chủ yếu do sở thích của lập trình viên thôi. Nhiều nghiên cứu chỉ ra rằng snake_case dễ đọc hơn camelCase khoảng 20% và rất nhiều những API phổ biến đều sử dụng snake_case.

snake_case

```
{
	"code": 200,
	"data": {
		"emp_no": "20200010",
		"emp_name": "Truong Duong",
		"emp_mail": "truongduong@techfinally.com",
		"emp_phone": "+84.886.987.987"
	}
}
```

camelCase

```
{
	"code": 200,
	"data": {
		"empNo": "20200010",
		"empName": "Truong Duong",
		"empMail": "truongduong@techfinally.com",
		"empPhone": "+84.886.987.987"
	}
}
```
