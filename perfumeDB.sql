create database perfumeshop

use perfumeshop
go
create table brands(
id int primary key identity(1,1) ,
name nvarchar(100) not null ,
description nvarchar(255) 
)
create table origin(
id int primary key identity(1,1) ,
name nvarchar(100) not null ,
description nvarchar(255) 
)
create table gender(
id varchar(5) primary key ,
gender bit
)
create table image_perfumes(
id int primary key identity(1,1) ,
name varchar(255),
perfume_id int ,
foreign key (perfume_id) references perfumes(id) on DELETE no ACTION on UPDATE CASCADE
)

create table perfumes(
id int primary key identity(1,1),
brand_id int not null,
origin_id int not null, 
gender_id varchar(5) ,
perfume_detail_id int,
 FOREIGN KEY (brand_id) REFERENCES brands(id) on DELETE no ACTION on UPDATE CASCADE,
 FOREIGN KEY (origin_id) references origin(id) on DELETE no ACTION on UPDATE CASCADE,
 foreign key (gender_id) references gender(id) on DELETE no ACTION on UPDATE CASCADE
)

 create table perfume_details (
 id int primary key identity(1,1) ,
name nvarchar(255) not null ,
description nvarchar(max) not null,
quantity int not null,
create_date date not null
 )

 create table perfume_price(
 id int primary key identity(1,1),
 purchase_price money not null,
sale_price money not null,
original_price money not null ,
perfume_id int not null,
foreign key(perfume_id) references perfumes(id) on DELETE no ACTION on UPDATE CASCADE
 )

create table users(
id int primary key identity(1,1) ,
fullname nvarchar(100) not null ,
email varchar(50) not null ,
phone_number varchar(15) not null ,
activate bit 
)
create table accounts(
id int primary key identity(1,1) ,
account_name varchar(30) not null ,
password varchar(255) not null,
user_id int not null,
activate bit not null,
foreign key (user_id) references users(id) on DELETE no ACTION on UPDATE CASCADE
)

create table carts(
id int primary key identity(1,1) ,
account_id int not null, 
total_price money
, status_id varchar(5) not null,
created_date date ,
foreign key(account_id) references accounts(id) on DELETE no ACTION on UPDATE CASCADE,
foreign key(status_id) references status_cart(id) on DELETE no ACTION on UPDATE CASCADE,
)
create table cart_details(
id int primary key identity(1,1) ,
cart_id int,
perfume_id int ,
quantity int,
foreign key (cart_id) references carts(id) on DELETE no ACTION on UPDATE CASCADE,
foreign key (perfume_id) references perfumes(id) on DELETE no ACTION on UPDATE CASCADE 
)

create table status_cart(
id varchar(5) primary key not null ,
status nvarchar(50) not null
)


create table discounts(
id int primary key identity(1,1) ,
name nvarchar(20) ,
created_person_id int ,
activated bit ,
discount_detail_id int not null ,
foreign key (discount_detail_id) references discount_details(id) on DELETE no ACTION on UPDATE CASCADE,
foreign key (created_person_id) references accounts(id) on DELETE no ACTION on UPDATE CASCADE
)

create table discount_details(
id int primary key identity(1,1) ,
perfume_id int ,
attribute int ,
start_date date  not null ,
end_date date ,
quantity int ,
foreign key (perfume_id) references perfumes(id) on DELETE no ACTION on UPDATE CASCADE
)

create table invoices(
id int primary key identity(1,1) ,
created_date date not null ,
seller_id int  ,
total_money money ,
note nvarchar(255) ,
buyer_id int ,
discount_id int ,
status varchar(20) ,
foreign key (seller_id) references accounts(id) ,
foreign key (buyer_id) references accounts(id)  ,
foreign key  (discount_id) references discounts(id)  on DELETE no ACTION on UPDATE CASCADE
)

create table invoice_details (
id int primary key identity(1,1) ,
perfume_id int ,
invoice_id int , 
price_perfume money ,
foreign key (perfume_id) references perfumes(id) on DELETE no ACTION on UPDATE CASCADE ,
foreign key (invoice_id) references invoices(id) on DELETE no ACTION on UPDATE CASCADE ,
)

insert into brands(name, description) values 
('Chanel', N'Được thành lập bởi Gabrielle Chanel tại Pháp năm 1909'),
('Dior', N'Thương hiệu nổi tiếng của Pháp được thành lập bởi Christian Dior năm 1946'),
('Guerlain', N'Hãng nước hoa Pháp có lịch sử hơn 200 năm, thành lập năm 1828'),
('Tom Ford', N'Thương hiệu của nghệ sĩ đa tài Tom Ford, được thành lập năm 2005'),
('Yves Saint Laurent', N'Thương hiệu nổi tiếng của Pháp được thành lập bởi Yves Saint Laurent năm 1961');

insert into origin(name, description) values
('Pháp', N'Nước sản xuất các thương hiệu danh tiếng như Chanel, Dior, Guerlain,...'),
('Ý', N'Nổi tiếng với các thương hiệu như Dolce & Gabbana, Giorgio Armani, Versace,...'),
('Mỹ', N'Sản xuất nhiều thương hiệu nước hoa nổi tiếng như Calvin Klein, Tom Ford, Ralph Lauren,...'),
('Anh', N'Nổi tiếng với các thương hiệu như Jo Malone, Burberry, Penhaligon,...'),
('Đức', N'Sản xuất các thương hiệu nổi tiếng như Jil Sander, Joop!, Hugo Boss,...');


insert into gender(id, gender) values
('M', 1), -- Mã id cho giới tính nam và dữ liệu giới tính là 1
('F', 0); -- Mã id cho giới tính nữ và dữ liệu giới tính là 0

insert into perfume_details(name, description, quantity, create_date) values
('Candy Gloss', N'Nước hoa dành cho phụ nữ, hương thơm ngọt ngào, tươi tắn, đầy sự quyến rũ.', 100, '2022-10-01'),
('The One', N'Nước hoa dành cho nữ, hương thơm đầy ngọt ngào, quyến rũ và nữ tính.', 50, '2021-06-15'),
('Sauvage', N'Nước hoa dành cho nam, hương thơm mạnh mẽ, cuốn hút và cá tính.', 80, '2022-03-20'),
('Chanel No.5', N'Nước hoa dành cho phụ nữ, hương thơm ấm áp, quyến rũ và sang trọng.', 120, '2020-11-01'),
('Le Male', N'Nước hoa dành cho nam, hương thơm mạnh mẽ, đầy quyến rũ và quyến rũ.', 60, '2022-01-16'),
('Opium', N'Nước hoa dành cho nữ, hương thơm quyến rũ, đầy mê hoặc và cá tính.', 40, '2021-12-03'),
('Boss Bottled', N'Nước hoa dành cho nam, hương thơm đầy nam tính, quyến rũ và mạnh mẽ.', 90, '2022-05-05'),
('La Vie Est Belle', N'Nước hoa dành cho phụ nữ, hương thơm tinh tế, quyến rũ và đầy sáng tạo.', 70, '2022-07-10'),
('Legend', N'Nước hoa dành cho nam, hương thơm đầy quyến rũ, nổi bật và cá tính.', 110, '2021-11-11'),
('Black Opium', N'Nước hoa dành cho nữ, hương thơm đầy mê hoặc, quyến rũ và táo bạo.', 100, '2022-09-20');

insert into perfumes(brand_id, origin_id, gender_id, perfume_detail_id) values
(1, 1, 'F', 1),
(2, 2, 'F', 2),
(3, 1, 'M', 3),
(1, 3, 'F', 4),
(4, 1, 'M', 5),
(2, 2, 'F', 6),
(5, 3, 'M', 7),
(1, 1, 'F', 8),
(3, 1, 'M', 9),
(2, 3, 'F', 10);

insert into perfume_price(purchase_price, sale_price, original_price, perfume_id) values
(1000000, 1280000, 1500000, 1),
(1250000, 1550000, 1850000, 2),
(1500000, 1780000, 2000000, 3),
(1100000, 1350000, 1600000, 4),
(1600000, 1900000, 2200000, 5),
(1200000, 1500000, 1800000, 6),
(1700000, 1980000, 2300000, 7),
(1300000, 1630000, 1900000, 8),
(1800000, 2150000, 2500000, 9),
(1400000, 1750000, 2050000, 10);

insert into image_perfumes(name, perfume_id) values
('Candy Gloss', 1),
('The One', 2),
('Sauvage', 3),
('Chanel No.5', 4),
('Le Male', 5),
('Opium', 6),
('Boss Bottled', 7),
('La Vie Est Belle', 8),
('Legend', 9),
('Black Opium', 10);

-- Thêm 10 dữ liệu vào bảng users
insert into users(fullname, email, phone_number, activate) values
(N'Ngô Thanh Tùng', 'tungnt@example.com', '0901234567', 1),
(N'Nguyễn Thị Anh Thư', 'thu.na@example.com', '0987654321', 1),
(N'Trần Trung Trực', 'tructt@example.com', '0912345678', 1),
(N'Hồ Ngọc Huy', 'huyhn@example.com', '0934567890', 1),
(N'Huỳnh Thị Phương Thảo', 'thaohtp@example.com', '0898765432', 1),
(N'Nguyễn Văn Hậu', 'haunv@example.com', '0976543210', 1),
(N'Lê Thị Hồng Ngọc', 'ngoclt@example.com', '0965432109', 1),
(N'Phạm Văn Dũng', 'dungpv@example.com', '0945678901', 1),
(N'Đỗ Thị Tuyết Mai', 'maidtt@example.com', '0911122233', 1),
(N'Vũ Hoàng Long', 'longvh@example.com', '0987654321', 1);

-- Thêm 10 dữ liệu vào bảng accounts
insert into accounts(account_name, password, user_id, activate) values
('user1', '123456', 1, 1),
('user2', '123456', 2, 1),
('user3', '123456', 3, 1),
('user4', '123456', 4, 1),
('user5', '123456', 5, 1),
('user6', '123456', 6, 1),
('user7', '123456', 7, 1),
('user8', '123456', 8, 1),
('user9', '123456', 9, 1),
('user10', '123456', 10, 1);


INSERT INTO status_cart (id, status) VALUES ('GH', 'Giỏ hàng');
INSERT INTO status_cart (id, status) VALUES ('DH', 'Đặt hàng');
INSERT INTO status_cart (id, status) VALUES ('XN', 'Xác nhận');
INSERT INTO status_cart (id, status) VALUES ('DG', 'Đang giao');
INSERT INTO status_cart (id, status) VALUES ('DN', 'Đã nhận');


INSERT INTO carts (account_id, total_price, status_id, created_date) VALUES (2, 1200000, 'DG', '2022-02-03');
INSERT INTO carts (account_id, total_price, status_id, created_date) VALUES (1, 500000, 'DH', '2022-02-05');
INSERT INTO carts (account_id, total_price, status_id, created_date) VALUES (3, 3500000, 'XN', '2022-02-07');
INSERT INTO carts (account_id, total_price, status_id, created_date) VALUES (4, 800000, 'DN', '2022-02-10');
INSERT INTO carts (account_id, total_price, status_id, created_date) VALUES (1, 2500000, 'DG', '2022-02-12');

INSERT INTO cart_details (cart_id, perfume_id, quantity) VALUES (1, 6, 2);
INSERT INTO cart_details (cart_id, perfume_id, quantity) VALUES (2, 1, 1);
INSERT INTO cart_details (cart_id, perfume_id, quantity) VALUES (3, 4, 4);
INSERT INTO cart_details (cart_id, perfume_id, quantity) VALUES (4, 3, 1);
INSERT INTO cart_details (cart_id, perfume_id, quantity) VALUES (5, 7, 3);