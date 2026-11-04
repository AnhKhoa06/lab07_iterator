# Lab 07 - Exercise 6 và 7: Iterator cho CompositeShow

Bài thực hành chương 6 (Composite, Decorator và Iterator) của giáo trình
*Introduction to Software Design with Java*.

Yêu cầu: cho phép client "mở gói" một `CompositeShow` để lấy các show bên trong, bằng Iterator.

- **Exercise 6:** làm mà không đổi interface `Show`. Chỉ `CompositeShow` có `iterator()`.
- **Exercise 7:** làm bằng cách sửa interface `Show`, cho `Show` kế thừa `Iterable<Show>`.

## Cấu trúc project

![Cấu trúc project](images/project-structure.png)

| Package | Nội dung |
|---|---|
| `ex6` | `Show`, `Movie`, `Concert`, `CompositeShow` (có `Iterable`), `IntroducedShow`, `Exercise06` |
| `ex7` | Như `ex6`, nhưng `Show extends Iterable<Show>` và mọi lớp đều có `iterator()` |

## Cách chạy

Mở project bằng Eclipse (Java 21), chuột phải `Exercise06.java` hoặc `Exercise07.java`,
chọn Run As -> Java Application.

## Kết quả

Exercise 06:

![Kết quả Exercise06](images/ex6-console.png)

Exercise 07:

![Kết quả Exercise07](images/ex7-console.png)

## Ghi chú

Lớp `Show`, `Movie`, `Concert` lấy từ mã nguồn bài tập của giáo trình
(repository prmr/DesignBook), có rút gọn. `CompositeShow` và `IntroducedShow` do em viết theo Exercise 1 và 2.