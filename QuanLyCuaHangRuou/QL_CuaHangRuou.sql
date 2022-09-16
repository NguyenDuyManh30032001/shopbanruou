create database QL_RUOU
go
use QL_RUOU
go
create table NHACUNGCAP
(
	MACC nchar(8) not null, --CHINH
	TENCC nchar(30)
)
Create table LOAIRUOU
(	
	MALOAI nchar(8) not null, --CHINH
	TENLOAI nvarchar(20)
)

Create table RUOU
(
	MARUOU nchar(15) not null, --CHINH
	TENRUOU nvarchar(30),
	XUATXU nvarchar(20),
	NONGDO nvarchar (5),
	THETICH char (10),
	GIABAN float,
	MALOAI nchar(8) not null --NGOAI
)
create table NHAPHANG
(
	MANHAP nchar(15) not null, --CHINH
	MACC nchar(8) not null, --NGOAI
	MARUOU nchar(15) not null, --NGOAI
	TINHTRANG nchar(50),
	TIENDAUTU money,
	NGAYNHAP date
)
--create table CTSANPHAMNHAP
--(
--	MANHAP nchar(15) not null,--NGOAI
--	MASANPHAM nchar(10) not null,--CHINH,NGOAI
--	TENSANPHAM nvarchar(30),
--	DONVITINH nvarchar(10),
--	SLNHAP int,
--	GIANHAP money
--)
create table KHACHHANG
(
	MAKH nchar(10) not null,--CHINH
	TENKH nvarchar(30),
	NGSINH Date,
	DIACHI nvarchar(30),
	DTHOAI nchar(12)
)

create table NHANVIEN
(
	MANV nchar(10) not null,--CHINH
	TENNV nvarchar(30),
	NGSINH Date,
	DIACHI nvarchar(30),
	DTHOAI nchar(12),
	LUONG money,
	TAIKHOAN nchar(50),
	MATKHAU nchar(50),
	CHUCVU nvarchar(20)
)
create table HOADON
(
	MAHD nchar(10) not null,--CHINH
	NGAYHD Date,
	MAKH nchar(10) not null,--NGOAI
	TONGTIEN money,
	MANV nchar(10) not null--NGOAI
)

create table CTHOADON
(
	MAHD nchar(10) not null,--CHINH,NGOAI
	MARUOU nchar(15) not null ,--CHINH,NGOAI
	SOLUONG int
)




-----------KHÓA CHÍNH-----------
alter table NHACUNGCAP
add constraint PK_MACC primary key (MACC)

alter table NHAPHANG
add constraint PK_MANHAP primary key (MANHAP)


--alter table CTSANPHAMNHAP
--add constraint PK_MASANPHAM primary key (MASANPHAM)

alter table LOAIRUOU 
add constraint PK_MALOAI primary key (MALOAI)

alter table RUOU 
add constraint PK_MARUOU primary key (MARUOU)

alter table KHACHHANG 
add constraint PK_MAKH primary key (MAKH)

alter table NHANVIEN 
add constraint PK_MANV primary key (MANV)

alter table HOADON
add constraint PK_MAHD primary key (MAHD)

alter table CTHOADON
add constraint PK_CT2 primary key (MAHD, MARUOU)

-----------KHÓA NGOẠI------------

alter table RUOU 
add constraint FK_MA foreign key (MALOAI) references LOAIRUOU (MALOAI)
alter table NHAPHANG
add constraint FK_MARR foreign key (MARUOU) references RUOU (MARUOU)
alter table NHAPHANG
add constraint FK_MACC foreign key (MACC) references NHACUNGCAP (MACC)
--alter table CTSANPHAMNHAP
--add constraint FK_CTMANHAP foreign key (MANHAP) references NHAPHANG(MANHAP)
alter table HOADON 
add constraint FK_MAKH foreign key (MAKH) references KHACHHANG (MAKH)
alter table HOADON 
add constraint FK_MANV foreign key (MANV) references NHANVIEN (MANV)

alter table CTHOADON 
add constraint FK_CTHD foreign key (MAHD) references HOADON (MAHD)
alter table CTHOADON 
add constraint FK_CTHD3 foreign key (MARUOU) references RUOU (MARUOU)

-------Rang Buoc-------
alter table NHACUNGCAP
add constraint UN_TEN unique (TENCC)---check

alter table LOAIRUOU
add constraint UN_MAL unique (MALOAI)---check

alter table RUOU
add constraint UN_MAR unique (MARUOU)---check

alter table KHACHHANG
add constraint UN_MAKH unique (MAKH)---check

alter table HOADON
add constraint UN_MAHD unique (MAHD)---check

alter table CTHOADON
add constraint UN_SL2 check (SOLUONG >= 0)---check

alter table KHACHHANG
add constraint DF_DCH default (NULL) for DIACHI

---------Nhap lieu----------------
insert into NHACUNGCAP(MACC,TENCC)
values ('NCC01','JACKSON'),
	('NCC02','NEEDPOEM'),
	('NCC03','WHARFBAMBOO'),
	('NCC04','MICHAELMOVE'),
	('NCC05','RUNAWAY'),
	('NCC06','FASTESTBOIZ')
insert into LOAIRUOU (MALOAI,TENLOAI)
values ('RUOUNG',N'Rượu Ngoại'),
	('RUOUVA',N'Rượu Vang'),
	('RPC001',N'Rượu Pha Chế')
insert into RUOU (MARUOU,TENRUOU,XUATXU,NONGDO,THETICH,GIABAN,MALOAI)
values ('MR001',N'Chivas',N'Scotland',N'40 độ','700 ml',600000,'RUOUNG'),
		('MR002',N'Jack Daniel',N'Mỹ',N'40 độ','350 ml',410000,'RUOUNG'),
		('MR003',N'HIBIKI',N'Nhật',N'43 độ','700 ml',3900000,'RUOUNG'),
		('MR004',N'KANGAROO Shiraz',N'Úc',N'13 độ','750 ml',340000,'RUOUVA'),
		('MR005',N'Gran Coronas',N'Tây Ban Nha',N'14 độ','749 ml',740000,'RUOUVA'),
		('MR006',N'PASSION',N'Chi Lê',N'12 độ','750 ml',120000,'RUOUVA'),
		('MR007',N'Gin Master',N'Anh',N'40 độ','700 ml',400000,'RUOUVA'),
		('MR008',N'Smirnoff red',N'Nga',N'39 độ','700 ml',340000,'RPC001'),
		('MR009',N'Choya Kishu',N'Nhật',N'14 độ','720 ml',400000,'RPC001')
set dateformat dmy
insert into NHAPHANG(MANHAP, MACC,MARUOU,NGAYNHAP,TINHTRANG,TIENDAUTU)
values ('MN001', 'NCC03', 'MR001', '22/04/2019','DA NHAN',100000),
	   ('MN002', 'NCC02', 'MR002', '04/04/2019','DA NHAN',150000),
	   ('MN003', 'NCC04', 'MR003', '14/08/2020','DA NHAN',200000),
	   ('MN004', 'NCC01', 'MR004', '26/03/2020','DA NHAN',120000),
	   ('MN005', 'NCC06', 'MR005', '01/12/2020','DA NHAN',110000),
	   ('MN006', 'NCC02', 'MR006', '19/05/2020','DA NHAN',50000),
	   ('MN007', 'NCC05', 'MR007', '12/04/2019','DA NHAN',100000),
	   ('MN008', 'NCC03', 'MR008', '12/06/2019','DA NHAN',100000),
	   ('MN009', 'NCC02', 'MR001', '12/09/2019','DA NHAN',100000)
--insert into CTSANPHAMNHAP(MANHAP,MASANPHAM,TENSANPHAM,DONVITINH,SLNHAP,GIANHAP)
--values ('MN001','SP001','KANGAROO Shiraz','CHAI',5,300000),
--		('MN003','SP002','Gran Coronas','CHAI',3,700000),
--		('MN004','SP003','Gin Master','CHAI',10,350000),
--		('MN006','SP004','Smirnoff red','CHAI',1,300000),
--		('MN002','SP005','Choya Kishu','CHAI',4,350000),
--		('MN005','SP006','HIBIKI','LON',2,300000)
set dateformat dmy
insert into KHACHHANG(MAKH,TENKH,NGSINH,DIACHI,DTHOAI)
values ('MK001',N'Nguyễn Duy Manh','30/03/2001',N'Tân Phú','0969564123'),
	   ('MK002',N'Nguyễn Hùng Cường','30/04/2001',N'Quy Nhơn','0909090909'),
	   ('MK003',N'Đỗ Đăng Khoa','02/04/2001',N'Long An','0901234567'),
	   ('MK004',N'Ricardo MiLos','12/08/1991',N'Cà Mau','0973511847'),
	   ('MK005',N'Trần Đức Bo','04/11/1997',N'Hà Nội','0123458524'),
	   ('MK006',N'Nguyễn Ca Nhật Long','16/09/1999',N'Hải Phòng','0901274567'),
	   ('MK007',N'Ricardo MiLos','15/07/2000',N'Cà Mau','0912511847'),
	   ('MK008',N'Trần Đức Bo','16/10/2003',N'Hà Nội','0123369524')
set dateformat dmy
insert into NHANVIEN(MANV,TENNV,NGSINH,DIACHI,DTHOAI,LUONG,TAIKHOAN,MATKHAU,CHUCVU)
values ('NV001',N'Nguyễn Tân kì','30/12/1997',N'Quảng Ngãi','0954548123',10000000.0,'tanki','tanki',N'Quản lý'),
	   ('NV002',N'Trần Đỗ Phúc Long','12/05/1998',N'Đà Nẵng','0658090909',2500000.0,'phuclong','phuclong',N'Nhân Viên'),
	   ('NV003',N'Cử Thị Tạ','02/07/1995',N'TP.HCM','0901258767',1000000.0,'thita','thita',N'Nhân Viên'),
	   ('NV004',N'Trần Thị Mộng Mèo','07/08/1990',N'TP.HCM','0986631321',1000000.0,'mongmeo','mongmeo',N'Nhân Viên'),
	   ('NV005',N'Xu Cà Na','08/11/1993',N'TP.HCM','0123985524',1000000.0,'cana','cana',N'Nhân Viên')
Set DateFormat dmy
insert into HOADON(MAHD,NGAYHD,MAKH,MANV)
values ('HD001','08-03-2021','MK001','NV003'),
		('HD002','12-01-2021','MK003','NV005'),
		('HD003','28-02-2021','MK005','NV002'),
		('HD004','05-03-2021','MK001','NV003'),
		('HD005','17-02-2021','MK002','NV001'),
		('HD006','12-12-2020','MK004','NV005')
insert into CTHOADON(MAHD,MARUOU,SOLUONG)
values ('HD001','MR006',5),
		('HD003','MR003',3),
		('HD004','MR004',10),
		('HD006','MR006',1),
		('HD002','MR001',4),
		('HD005','MR004',2)

-----------Khai thac du lieu----------


--1. Cho biết thông tin của rượu có tên rượu là Gin Master
select RUOU.*
from RUOU
where TENRUOU = N'Gin Master'
--2. Cho biết tên rượu được khách hàng KH001 mua
select CTHOADON.MARUOU,TENRUOU
from HOADON,CTHOADON,RUOU
where RUOU.MARUOU = CTHOADON.MARUOU and HOADON.MAHD = CTHOADON.MAHD and MAKH = 'MK001'
--3. Cho biết thông của rượu có mã loại RV001
select RUOU.*
from RUOU,LOAIRUOU
where RUOU.MALOAI = LOAIRUOU.MALOAI and RUOU.MALOAI = 'RV001'
--4 Cho biết tổng tiền của hóa đơn HD003
select SOLUONG*GIABAN 'Tổng tiền'
From RUOU,CTHOADON
where RUOU.MARUOU = CTHOADON.MARUOU and MAHD='HD003'
--5 Cho biết địa chỉ của Trần Đức Bo
select DIACHI
from KHACHHANG
where TENKH = N'Trần Đức Bo'
--6. Xuất THời gian mà Khách Hàng MK005 thanh toán hóa đơn
Select NGAYHD
from HOADON
where MAKH = 'MK005'
--7. Cho biết thông tin của hóa đơn HD003
select *
from HOADON
where MAHD='HD003'
--8. Xuất nồng độ của rượu Smirnoff red
select NONGDO
from RUOU
where TENRUOU = 'Smirnoff red'
--9. Đếm rượu có dung tích 700ml
select count(THETICH) as SoluongRuou
from RUOU
where THETICH = '700 ml'
--10. Cho biết các smã rượu và tên rượu của loại rượu pha chế
select MARUOU,TENRUOU
from LOAIRUOU,RUOU
where LOAIRUOU.MALOAI = RUOU.MALOAI and TENLOAI = N'rượu pha chế'
--11. Cho biết số lượng rượu đã mua bởi khách hàng MK001
select sum(SOLUONG) 'tổng số lượng'
from CTHOADON,KHACHHANG,HOADON
where KHACHHANG.MAKH = HOADON.MAKH and HOADON.MAHD = CTHOADON.MAHD and KHACHHANG.MAKH = 'MK001'
--12.Xuất ra  Tên rượu, xuat xu và giá bán của các chai rượu có thể tích là 700ml.
select TENRUOU, XUATXU,GIABAN
from RUOU
where THETICH = '700 ml'
--13.Tính tổng số lượng loai rượu của từng nước sản xuất.
select XUATXU,COUNT(LOAIRUOU.MALOAI) 'Tổng số lượng' 
from LOAIRUOU, RUOU
where LOAIRUOU.MALOAI = RUOU.MALOAI
group by XUATXU
--14. Với từng nước sản xuất, tìm giá bán cao nhất của các sản phẩm.
select MARUOU ,XUATXU, MAX(GIABAN) 'Giá bán cao nhất'
from RUOU
Group by MARUOU,XUATXU
Having MAX(GIABAN) >= ALL(select MAX(GIABAN) from RUOU group by MARUOU)
--15. Với từng nước sản xuất, tìm giá bán thấp nhất của các sản phẩm.
select MARUOU ,XUATXU, MIN(GIABAN) 'Giá bán cao nhất'
from RUOU
Group by MARUOU,XUATXU
Having MIN(GIABAN) <= ALL(select MIN(GIABAN) from RUOU group by MARUOU)
--16. Tìm khách hàng (MAKH, TENKH) có số lần mua hàng nhiều nhất.
select HOADON.MAKH, TENKH 'Tên thằng bợm nhậu'
from KHACHHANG, HOADON
where KHACHHANG.MAKH = HOADON.MAKH
Group by HOADON.MAKH, TENKH
HAVING count(HOADON.MAKH) >= ALL(select count(HOADON.MAKH) from HOADON group by MAKH)
--17. Tổng số lượng rượu do nước Nhật sản xuất
select COUNT(MARUOU) as Tong
from  RUOU
where XUATXU = N'Nhật'
--18. Cho biết tổng số lượng bán ra vào tháng 3/2021
select SUM(SOLUONG) as TongSoLuong
from HOADON, CTHOADON
where HOADON.MAHD = CTHOADON.MAHD and MONTH(NGAYHD) = '03' and YEAR(NGAYHD) = '2021'
--19. Cho biết tên rượu có số lượng bán thấp nhất
select CTHOADON.MARUOU, TENRUOU
from CTHOADON, RUOU
where CTHOADON.MARUOU = RUOU.MARUOU
Group by CTHOADON.MARUOU, TENRUOU
Having MIN(SOLUONG) <= ALL(select MIN(SOLUONG) from CTHOADON group by MARUOU)
--20. Đếm số lượng rượu của từng loại rượu
select LOAIRUOU.MALOAI,Count(MARUOU) 'Số lượng rượu'
from RUOU, LOAIRUOU
where RUOU.MALOAI = LOAIRUOU.MALOAI
group by LOAIRUOU.MALOAI
--21. Cho biết mã rượu , tên rượu chưa được mua
select MARUOU,TENRUOU
from RUOU
where not exists (select MARUOU from CTHOADON where RUOU.MARUOU = CTHOADON.MARUOU)
--22. Cho biết thông tin khách hàng mua số lượng rượu ít nhất
select KHACHHANG.MAKH,TENKH
from KHACHHANG,HOADON,CTHOADON
where KHACHHANG.MAKH = HOADON.MAKH and HOADON.MAHD = CTHOADON.MAHD
group by KHACHHANG.MAKH,TENKH
having min(SOLUONG) <= ALL(select min(SOLUONG) from CTHOADON group by MAHD)
--23. Tính tổng đơn giá của từng loại rượu
select LOAIRUOU.MALOAI,SUM(GIABAN) 'Tổng giá bán'
from LOAIRUOU,RUOU
where LOAIRUOU.MALOAI = RUOU.MALOAI
group by LOAIRUOU.MALOAI
--24.Cho biết loại rượu có số lượng rượu nhiều nhất
select LOAIRUOU.MALOAI,COUNT(MARUOU) 'số lượng'
from LOAIRUOU,RUOU
where LOAIRUOU.MALOAI = RUOU.MALOAI
group by LOAIRUOU.MALOAI
having COUNT(MARUOU) >= ALL (select COUNT(MARUOU) from RUOU group by MALOAI)
--25. Cho biết tên rượu được khách hàng KH001 mua
select CTHOADON.MARUOU,TENRUOU
from HOADON,CTHOADON,RUOU
where RUOU.MARUOU = CTHOADON.MARUOU and HOADON.MAHD = CTHOADON.MAHD and MAKH = 'MK001'
---------------Sử dụng các lệnh, hàm thông dụng--------
update HOADON
set TONGTIEN = SOLUONG* GIABAN from RUOU, CTHOADON where HOADON.MAHD = CTHOADON.MAHD and RUOU.MARUOU = CTHOADON.MARUOU
select *
from HOADON

insert into KHACHHANG(MAKH,TENKH,DIACHI,DTHOAI)
values ('MK010',N'Nguyễn Huy Khánh',N'Tân Phú','0984563103')
Delete from KHACHHANG
where MAKH = 'MK010'

select count(*) 'Số lượng hóa đơn' 
from HOADON

select SUM(TONGTIEN) 'Tổng tiền của các hóa đơn'
from HOADON

select MAX(TONGTIEN) 'Hóa đơn có số tiền nhiều nhất'
from HOADON

---------------------------------TRIGGER---------------------
--Số lượng phải lớn hoặc bằng 0
create trigger KT_SOLUONG on CTHOADON
for insert,update
as
begin
	if(select SOLUONG from  inserted) < 0
	begin
	print 'So luong phai lon hon hoac bang 0'
	rollback
	end
end

Update CTHOADON
set SOLUONG = -1 where MAHD = 'HD001'

-- Ngày in hóa đơn phải bé hơn hoặc bằng ngày hiện tại
create trigger KT_NGAY on HOADON
for insert,update
as
begin
	if(select NGAYHD from inserted) > GETDATE()
	begin
	print 'Ngay in hoa dơn phai be hon hoac bang ngay hien tai'
	rollback
	end
end

Set DateFormat dmy
Update HOADON
set NGAYHD = '30-03-2021' where MAHD = 'HD001'
------------------Cursor-------------------
Declare SHOW_RN CURSOR
DYNAMIC
FOR
	select LOAIRUOU.MALOAI,MARUOU,TENRUOU
	from RUOU,LOAIRUOU
	where RUOU.MALOAI = LOAIRUOU.MALOAI and RUOU.MALOAI = 'RN001'
	group by LOAIRUOU.MALOAI,MARUOU,TENRUOU

-----------------------------------------------
create proc DemRuou
@MALOAI nchar(10), @SOLUONGRUOU int output
as
begin
	set @SOLUONGRUOU = (select COUNT(*) from RUOU where MALOAI = @MALOAI)
end

DECLARE @SL int
EXEC DemRuou 'RPC001', @SL output
print N'Số lượng của loại rượu Pha chế 001 là: ' +cast(@SL as char)



------------------------Thủ tục procedure---------------------------
--1. Cho biết số lượng nhân viên hiện tại của quán
create proc sp_SoLuongNV
as
begin
	select count(*) from NHANVIEN
end

EXEC sp_SoLuongNV

--2.  Đếm số lượng rượu khi truyền vào mã loại
create proc Dem_Ruou @MALOAI nchar(10), @SOLUONGRUOU int output
as
begin
	set @SOLUONGRUOU = (select COUNT(*) from RUOU where MALOAI = @MALOAI)
end

DECLARE @SL int
EXEC Dem_Ruou 'RPC001', @SL output
print N'Số lượng của loại rượu Pha chế 001 là: ' +cast(@SL as char)
--3. Cập nhật tổng tiền cho hóa hơn khi truyền vào một mã hóa đơn
create proc CAP_NHAT_TIEN_HD @MaHD nchar(10), @TONGTIEN int output
as
begin
	if not exists (select * from HOADON where MAHD = @MaHD)
			return 0
	else
		begin
		Select @TONGTIEN = SOLUONG*GIABAN from HOADON,RUOU,CTHOADON where RUOU.MARUOU = CTHOADON.MARUOU and HOADON.MAHD=CTHOADON.MAHD and  HOADON.MAHD = @MaHD
		return 1
		end
end
Declare @KQ int
Declare @TIEN money
exec @KQ = CAP_NHAT_TIEN_HD 'HD001', @TIEN output
if @KQ = 0
	print 'Hoa don khong ton tai'
else
	update HOADON set TONGTIEN = @TIEN where MAHD = 'HD001'
--4. Cập nhập tổng tiền cho toàn bộ hóa đơn

create PROC sp_CapNhatHD
as
begin
	UPDATE HOADON
	set TONGTIEN = (select SOLUONG*GIABAN from HOADON,RUOU,CTHOADON where RUOU.MARUOU = CTHOADON.MARUOU and HOADON.MAHD=CTHOADON.MAHD and  HOADON.MAHD = p.MAHD) from HOADON p
end

exec sp_CapNhatHD
--5. Cho biết lương của 1 nhân viên khi nhập vào MANV
create proc Luong_NV @MANV nchar(10)
as
begin
	Select LUONG from NHANVIEN where MANV = @MANV
end

EXEC Luong_NV 'NV001'

--6. Cập nhật tiền đầu tư cho 1 đơn nhập hàng khi truyền vào mà nhập hàng
create proc CAP_NHAT_TIEN_DT @MaNH nchar(10), @TONGTIENDT int output
as
begin
	if not exists (select * from NHAPHANG where MANHAP = @MaNH)
			return 0
	else
		begin
		Select @TONGTIENDT = SLNHAP*GIANHAP from NHAPHANG,CTSANPHAMNHAP where NHAPHANG.MANHAP=CTSANPHAMNHAP.MANHAP and  NHAPHANG.MANHAP = @MaNH
		return 1
		end
end
Declare @KQ int
Declare @TIEN money
exec @KQ = CAP_NHAT_TIEN_DT 'MN001', @TIEN output
if @KQ = 0
	print 'Don nhap hang khong ton tai'
else
	update NHAPHANG set TIENDAUTU = @TIEN where MANHAP = 'MN001'
	select * from NHAPHANG
--7. Cập nhập tiền đầu tư cho toàn bộ đơn nhập hàng
alter PROC sp_CapNhatDonNH
as
begin
	UPDATE NHAPHANG
	set TIENDAUTU = (select SUM(SLNHAP*GIANHAP) from NHAPHANG,CTSANPHAMNHAP where NHAPHANG.MANHAP=CTSANPHAMNHAP.MANHAP and  NHAPHANG.MANHAP = p.MANHAP) from NHAPHANG p
end

exec sp_CapNhatDonNH
select * from NHAPHANG
select * from CTSANPHAMNHAP
--8. Cho biết số lượng khi đã mua khi nhập vào mã hóa đơn
create proc sp_SOLUONGRUOU_MUA @MAHD nchar(10)
as
begin
	select SOLUONG from CTHOADON where MAHD = @MAHD
end

EXEC sp_SOLUONGRUOU_MUA 'HD003'


--9. Cho biết nhân viên nào đã bán hàng cho hóa đơn nhập vào

create proc sp_KiemTraHD @MAHD nchar(10)
as
begin
	select NHANVIEN.* from HOADON,NHANVIEN where HOADON.MANV = NHANVIEN.MANV and MAHD = @MAHD
end

EXEC sp_KiemTraHD 'HD001'

--10. Cho biết thông tin của rượu khi nhập vào 1 mã rượu
create proc Thong_Tin_Ruou @MaRuou nchar(10)
as
begin
	Select RUOU.* from RUOU where MARUOU = @MaRuou
end

EXEC Thong_Tin_Ruou 'MR002'
--11. Cho biết tình trạng của 1 đơn hàng khi nhập vào mã hàng
create proc sp_KiemTra_TT @MANHAP nchar(10)
as
begin
	Select TINHTRANG from NHAPHANG where MANHAP = @MANHAP
end

EXEC sp_KiemTra_TT 'MN005'
--12. Tăng giá 1000 cho rượu khi truyền vào mã rượu
create proc sp_TANG_1000 @MARUOU nchar(10)
as
begin
	Update RUOU set GIABAN = GIABAN + 1000  where MARUOU = @MARUOU
end

EXEC sp_TANG_1000 'MR003'

select * from RUOU


--13. Viết thủ tục in ra thông tin nhân viên khi truyền vào một mã nhân viên

create proc sp_ThongTinNhanVien @MANV nchar(10)
as
begin
	Select * from NHANVIEN where MANV  = @MANV 
end

EXEC sp_ThongTinNhanVien 'NV001'

--14. Viết thủ tục tính tổng số hàng nhập về

create proc sp_TongHang  @SOLUONGRUOU int output
as
begin
	select @SOLUONGRUOU = (select SUM(SOLUONG) from CTNHAPHANG)
end

DECLARE @SL int
EXEC sp_TongHang @SL output
print N'Tổng số lượng hàng đã nhập về  là: ' +cast(@SL as char)
--15. Cho biết mã rượu chưa được mua
create proc sp_KIEMTRA @maruou nchar(10) output
as
begin
	select @maruou= MARUOU from RUOU where not exists (select MARUOU from CTHOADON where RUOU.MARUOU = CTHOADON.MARUOU)
end
DECLARE @MR nchar(10)
EXEC sp_KIEMTRA @MR output
print N'Mã rượu là: ' + @MR
--16. Viết thủ tục in mã nhân viên phụ trách hóa đơn khi truyền vào mã hóa đơn
create proc sp_ThongTin @mahd nchar(10)
as
begin
	select MANV from HOADON where MAHD=@mahd
end

EXEC sp_ThongTin 'HD001' 
--17. Cho biết tên rượu được mua khi truyền vào mã khách hàng
create proc sp_TenRuouDcMua @makh nchar(10),@tenruou nvarchar(30) output
as
begin
	select @tenruou=TENRUOU from RUOU,HOADON,CTHOADON where RUOU.MARUOU= CTHOADON.MARUOU and CTHOADON.MAHD=HOADON.MAHD and MAKH=@makh
end

DECLARE @TR nvarchar(30)
EXEC sp_TenRuouDcMua 'MK003', @TR output
print N'Tên Rượu: ' + @TR
--18.Cho biết nhân viên nào bán được nhiều đơn nhất
create proc sp_TTNVBanNhieuNhat @tennv nvarchar(30) output
as
begin
	select @tennv=TENNV  from NHANVIEN, HOADON,CTHOADON where NHANVIEN.MANV=HOADON.MANV and HOADON.MAHD = CTHOADON.MAHD group by TENNV HAVING COUNT(HOADON.MANV) >= ALL(select count(HOADON.MANV) from HOADON group by MANV)
end
DECLARE @TNV nvarchar(30)
EXEC sp_TTNVBanNhieuNhat @TNV output
print N'Nhân Viên: '+@TNV
--19.Cho biết Khách hàng có tuổi lớn nhất
create proc sp_TTKHLonTuoiNhat @tenkh nvarchar(30) output
as 
begin
	select  @tenkh=TENKH from KHACHHANG group by TENKH, NGSINH Having (YEAR(GETDATE()) - YEAR(NGSINH)) >= ALL(select YEAR(GETDATE()) - YEAR(NGSINH)from KHACHHANG group by MAKH,NGSINH) 
end

DECLARE @tk nvarchar(30)
EXEC sp_TTKHLonTuoiNhat @tk output
print N'Khách Hàng: '+@tk
--20. Viết thủ tục cho biết tình trạng nhập hàng khi truyền vào mã nhập
create proc sp_KiemTraTinhTrang @manhap nchar(10), @tinhtrang nchar(50) output
as
begin
	select @tinhtrang=TINHTRANG from NHAPHANG where MANHAP=@manhap
end

DECLARE @TT nchar(50)
EXEC sp_KiemTraTinhTrang 'MN005', @TT output
print N'Tình Trạng: ' + @TT

---------------------------FUNCTION--------------------------------------------


--1. Tạo hàm cho biết số lượng nhân viên hiện tại của quán
create function f_SoLuongNV()
returns int
begin
	declare @sl int
	select @sl=count(*) from NHANVIEN
	return @sl
end

select dbo.f_SoLuongNV()

--2. Tạo hàm Đếm số lượng rượu khi truyền vào mã loại
create function f_Dem_Ruou(@MALOAI nchar(10)) 
returns int
begin
	declare @SOLUONGRUOU int
	set @SOLUONGRUOU = (select COUNT(*) from RUOU where MALOAI = @MALOAI)
	return @SOLUONGRUOU
end

DECLARE @SL int
set @SL = dbo.f_Dem_Ruou('RPC001')
print N'Số lượng là: ' +cast(@SL as char)
--3. Tạo hàm Cập nhật tổng tiền cho hóa hơn khi truyền vào một mã hóa đơn
create function f_CAP_NHAT_TIEN_HḌ(@MaHD nchar(10))
returns table

		return (Select HOADON.MAHD,sum(SOLUONG*GIABAN) 'Tong Tien' from HOADON,RUOU,CTHOADON where RUOU.MARUOU = CTHOADON.MARUOU and HOADON.MAHD=CTHOADON.MAHD and  HOADON.MAHD = @MaHD group by HOADON.MAHD)


select * from f_CAP_NHAT_TIEN_HḌ('HD001')
--4. Tạo hàm Cập nhập tổng tiền cho toàn bộ hóa đơn

create function f_CapNhatHD()
returns table
	return (select HOADON.MAHD,sum(SOLUONG*GIABAN) 'Tong Tien' from HOADON,RUOU,CTHOADON where RUOU.MARUOU = CTHOADON.MARUOU and HOADON.MAHD=CTHOADON.MAHD group by HOADON.MAHD)


select * from f_CapNhatHD()
--5. Tạo hàm Cho biết lương của 1 nhân viên khi nhập vào MANV
create function f_Luong_NV(@MANV nchar(10))
returns table
	return(Select MANV,LUONG from NHANVIEN where MANV = @MANV)

select * from f_Luong_NV('NV001')

--6. Tạo hàm Cập nhật tiền đầu tư cho 1 đơn nhập hàng khi truyền vào mà nhập hàng
create function f_CAP_NHAT_TIEN_DT(@MaNH nchar(10))
returns table

		return (Select NHAPHANG.MANHAP,sum(SOLUONG*GIABAN) 'Tong Tien' from NHAPHANG,RUOU,CTNHAPHANG where RUOU.MARUOU = CTNHAPHANG.MARUOU and NHAPHANG.MANHAP=CTNHAPHANG.MANHAP and  NHAPHANG.MANHAP = @MaNH group by NHAPHANG.MANHAP)

select * from f_CAP_NHAT_TIEN_DT('MN001')
--7. Tạo hàm Cập nhập tiền đầu tư cho toàn bộ đơn nhập hàng
create function f_CapNhatDonNH()
returns table

	return (select NHAPHANG.MANHAP,sum(SOLUONG*GIABAN) 'Tong tien' from NHAPHANG,RUOU,CTNHAPHANG where RUOU.MARUOU = CTNHAPHANG.MARUOU and NHAPHANG.MANHAP=CTNHAPHANG.MANHAP group by NHAPHANG.MANHAP)

select * from f_CapNhatDonNH()

--8. Tạo hàm Cho biết số lượng khi đã mua khi nhập vào mã hóa đơn
create function f_SOLUONGRUOU_MUA(@MAHD nchar(10))
returns int
begin
	declare @SL int
	select @SL = SOLUONG from CTHOADON where MAHD = @MAHD
	return @SL
end

select dbo.f_SOLUONGRUOU_MUA('HD003') 'So Luong'


--9. Tạo hàm Cho biết nhân viên nào đã bán hàng cho hóa đơn nhập vào

create function f_KiemTraHD(@MAHD nchar(10))
returns table
	return (select NHANVIEN.* from HOADON,NHANVIEN where HOADON.MANV = NHANVIEN.MANV and MAHD = @MAHD)

select * from f_KiemTraHD('HD001')

--10. Tạo hàm Cho biết thông tin của rượu khi nhập vào 1 mã rượu
create function f_Thong_Tin_Ruou(@MaRuou nchar(10))
returns table
	return(Select RUOU.* from RUOU where MARUOU = @MaRuou)
select * from f_Thong_Tin_Ruou('MR002')

--11. Tạo hàm Cho biết loại rượu được mua khi truyền vào mã khách hàng
alter function f_LOAIRUOU(@MAKH nvarchar(30))
returns table
	return(select Distinct(RUOU.MALOAI) from HOADON, CTHOADON, RUOU, LOAIRUOU, KHACHHANG 
		   where HOADON.MAHD = CTHOADON.MAHD and CTHOADON.MARUOU = RUOU.MARUOU and RUOU.MALOAI = LOAIRUOU.MALOAI and KHACHHANG.MAKH = HOADON.MAKH and HOADON.MAKH = @MAKH)
select * from f_LOAIRUOU('MK002')

--12. Tạo hàm Cho biết số lượng rượu đã mua khi truyền vào mã khách hàng
create function f_SLRUOU(@MAKH nvarchar(30))
returns int
begin
	declare @SL int
	select @SL = sum(SOLUONG) 
	from CTHOADON,KHACHHANG,HOADON
	where KHACHHANG.MAKH = HOADON.MAKH and HOADON.MAHD = CTHOADON.MAHD and KHACHHANG.MAKH = @MAKH
	return @SL
end

DECLARE @s int
set @s = dbo.f_SLRUOU('MK001')
print N'Số lượng là: ' +cast(@s as char)
--13. Tạo hàm Cho biết tài khoản và mật khẩu của 1 nhân viên khi nhập vào MANV
create function f_TT_TKMK(@MANV nvarchar(30))
returns table

	return (Select TAIKHOAN, MATKHAU from NHANVIEN where MANV = @MANV)

select * from f_TT_TKMK('NV002')
----------------------------------------CURSOR----------------------------------
--1. Dùng cursor in ra rượu của cửa hàng
declare SHOW_RN CURSOR for select MALOAI,MARUOU,TENRUOU from RUOU
OPEN SHOW_RN
Declare @MALOAI nchar(10),@MARUOU nchar(10),@TENRUOU nvarchar(30)
FETCH next from SHOW_RN into @MALOAI,@MARUOU,@TENRUOU
while(@@FETCH_STATUS = 0)
begin
 PRINT @MALOAI + ' , ' + @MARUOU +' , ' +@TENRUOU
 FETCH next from SHOW_RN into @MALOAI,@MARUOU,@TENRUOU
end

----------------------Đóng cursor--------------------------------

CLOSE SHOW_RN
----------------------Hủy cursor--------------------------------

DEALLOCATE SHOW_RN



--2. Dùng cursor cập nhật lại mã nhập hàng = mã nhà cung cấp + mã nhập hàng hiện tại
----------------KHAI BAO CUR--------------
declare CUR_CAPNHATRNH CURSOR for select MACC from NHACUNGCAP

----------------MO CUR--------------
OPEN CUR_CAPNHATRNH
declare @MACC nchar(20)
FETCH NEXt from CUR_CAPNHATRNH into @MACC
While (@@FETCH_STATUS = 0)
begin
	UPDATE NHAPHANG
	SET MANHAP = MACC + MANHAP
	where MACC = @MACC
FETCH NEXt from CUR_CAPNHATRNH into @MACC
end
select * from NHAPHANG
------------------DONG CUR--------------
CLOSE CUR_CAPNHATRNH

-------------------HUY CUR-------------
DEALLOCATE CUR_CAPNHATRNH

--3. Sử dụng cursor cập nhật lại tên loại rượu = “Chưa xác định” tại dòng thứ 2 của bảng LOAIRUOU
----------------KHAI BAO CUR--------------
declare CUR_DSLR CURSOR Scroll for
select MALOAI,TENLOAI
from LOAIRUOU
----------------MO CUR--------------
OPEN CUR_DSLR
FETCH Absolute 2 from CUR_DSLR
if (@@FETCH_STATUS = 0)
	UPDATE LOAIRUOU
	SET TENLOAI = N'Chưa xác định'
	where current of CUR_DSLR

select * from LOAIRUOU
------------------DONG CUR--------------
CLOSE CUR_DSL
-------------------HUY CUR-------------
DEALLOCATE CUR_DSL
----------------------Sao lưu cơ sở dữ liệu định kỳ--------------------------------

BACKUP LOG RUOU
TO DISK = 'C:\RUOU_log.TRN'
WITH DESCRIPTION = 'QLSV Log Backup';

--Bỏ mã loại trong chi tiết hóa đơn, bỏ chi tiết nhập hàng, chuyển số lượng qua nhập hàng

insert into NHANVIEN(MANV,TENNV,NGSINH,DIACHI,DTHOAI,LUONG,TAIKHOAN,MATKHAU)
values ('NV0016',N'Nguyễn Tân kì',GETDATE(),N'Quảng Ngãi','0954548123',10000000.0,'tanki','tanki')	

create function f_LOAIRUOU(@TENKH nvarchar(30))
returns nchar(8)
begin
	declare @maloai nchar(8)
	select @maloai = (Distinct(RUOU.MALOAI)) from HOADON, CTHOADON, RUOU, LOAIRUOU, KHACHHANG where HOADON.MAHD = CTHOADON.MAHD and CTHOADON.MARUOU = RUOU.MARUOU and RUOU.MALOAI = LOAIRUOU.MALOAI and KHACHHANG.MAKH = HOADON.MAKH and TENKH = @TENKH
	return @maloai
end	

select Distinct(RUOU.MALOAI), TENLOAI from HOADON, CTHOADON, RUOU, LOAIRUOU, KHACHHANG where HOADON.MAHD = CTHOADON.MAHD and CTHOADON.MARUOU = RUOU.MARUOU and RUOU.MALOAI = LOAIRUOU.MALOAI and KHACHHANG.MAKH = HOADON.MAKH and TENKH = N'Nguyễn Hùng Cường'					