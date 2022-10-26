Create database QuanLyBanHang_Java
go

Use QuanLyBanHang_Java
go


--Câu lệnh khởi tạo bảng Nhân viên
 Create table NhanVien
 (
	MaNhanVien nvarchar(20) not null,
	MaChucVu nvarchar(20) not null,
	TenNhanVien nvarchar(50) not null,
	DiaChi nvarchar(50) not null,
	SoDienThoai nvarchar(15) not null,
	NgaySinh datetime not null,
	GioiTinh bit not null,
	TrangThai bit default 0, -- 0- chưa xóa , 1- đã xóa 
	Primary Key Clustered ([MaNhanVien] ASC),
	Foreign Key(MaChucVu) References ChucVu(MaChucVu)
 );
 go

--Câu lệnh khởi tạo bảng chức vụ 
 Create table ChucVu
(
	MaChucVu nvarchar(20) not null,
	TenChucVu nvarchar(20) not null,
	Primary Key Clustered ([MaChucVu] ASC)
);
go

--Câu lệnh khởi tạo bảng Khách Hàng
 Create table KhachHang
 (
	MaKhachHang nvarchar(20) not null,
	TenKhachHang nvarchar(50) not null,
	DiaChi nvarchar(50) not null,
	SoDienThoai nvarchar(15) not null,
	GioiTinh bit not null,
	TrangThai bit default 0, -- 0- chưa xóa , 1- đã xóa 
	Primary Key Clustered (MaKhachHang ASC)
 );
 go


--Câu lệnh khởi tạo bảng Sản Phẩm
 Create table SanPham
 (
	MaSanPham nvarchar(20) not null,
	MaNhaCungCap nvarchar(20) not null,
	MaLoaiSP nvarchar(20) not null,
	TenSanPham nvarchar(50) not null,
	SoLuong float(53) not null,
	DonGiaNhap float(53) not null,
	DonGiaBan float(53) not null,
	HinhAnh nvarchar(200) not null,
	GhiChu nvarchar(200) not null,
	TrangThai bit default 0, -- 0- chưa xóa , 1- đã xóa 
	Primary Key Clustered (MaSanPham ASC),
	Foreign Key(MaNhaCungCap) References NhaCungCap(MaNhaCungCap),
	Foreign Key(MaLoaiSP) References LoaiSanPham(MaLoaiSP)
 );
 go

--Câu lệnh khởi tạo bảng Nhà Cung Cấp
 Create table NhaCungCap
 (
	MaNhaCungCap nvarchar(20) not null,
	TenNhaCungCap nvarchar(50) not null,
	DiaChi nvarchar(50) not null,
	SoDienThoai nvarchar(15) not null,
	Email nvarchar(50) not null,
	TrangThai bit default 0, -- 0- chưa xóa , 1- đã xóa 
	Primary Key Clustered (MaNhaCungCap ASC)
 );
 go

 --Câu lệnh khởi tạo bảng Loại Sản Phẩm
 Create table LoaiSanPham
 (
	MaLoaiSP nvarchar(20) not null,
	TenLoaiSP nvarchar(50) not null,
	TrangThai bit default 0, -- 0- chưa xóa , 1- đã xóa 
	Primary Key Clustered (MaLoaiSP ASC)
 );
 go

 --Câu lệnh khởi tạo bảng Hóa Đơn Bán Hàng
 Create table HoaDonBan
 (
	MaHDBan nvarchar(20) not null,
	MaNhanVien nvarchar(20) not null,
	MaKhachHang nvarchar(20) not null,
	NgayBan datetime not null,
	TongTien float(53) not null,
	TrangThai bit default 0, -- 0- chưa xóa , 1- đã xóa 
	Primary Key Clustered (MaHDBan ASC),
	Foreign Key(MaNhanVien) References NhanVien(MaNhanVien),
	Foreign Key(MaKhachHang) References KhachHang(MaKhachHang)
 );
 go

 --Câu lệnh khởi tạo bảng Chi Tiết Hóa Đơn Bán Hàng
 Create table CTHoaDonBan
 (
	MaHDBan nvarchar(20) not null,
	MaSanPham nvarchar(20) not null,
	SoLuong int not null,
	DonGia float(53) not null,
	GiamGia float(53) not null,
	ThanhTien float(53) not null,
	TrangThai bit default 0, -- 0- chưa xóa , 1- đã xóa 
	Primary Key Clustered ([MaHDBan] ASC, [MaSanPham] ASC)
 );
 go

 --Câu lệnh khởi tạo bảng Hóa Đơn Bán Hàng
 Create table PhieuNhapHang
 (
	MaPNHang nvarchar(20) not null,
	MaNhanVien nvarchar(20) not null,
	MaSanPham nvarchar(20) not null,
	GiamGia float(53) not null,
	TongTien float(53) not null,
	TrangThai bit default 0, -- 0- chưa xóa , 1- đã xóa 
	Primary Key Clustered ([MaPNHang] ASC, [MaSanPham] ASC),
	Foreign Key(MaNhanVien) References NhanVien(MaNhanVien)
 );
 go


--Định dạng thời gian thành date mouth year
set dateformat dmy

-- Xóa 1 table trong sql
-- Drop table (Tên bảng cần xóa)

-- Thay đổi dữ liệu cho cột
-- Alter table <tên bảng>  Alter column <tên cột> <kiểu dữ liệu mới>;
-- sp_rename 'ten_bang.ten_cot_cu', 'ten_cot_moi', 'COLUMN': Đổi tên cột chứa dữ liệu bên trong bảng

--Nhập dữ liệu

--Khách Hàng
insert into KhachHang values('KH01',N'Nguyễn Đình Hùng',N'TP.HCM','0374838123',1,0)
insert into KhachHang values('KH02',N'Nguyễn Thị Xuân Mai',N'TP Hà Nội','0374838567',0,0)
insert into KhachHang values('KH03',N'Nguyễn Văn Minh',N'TP.HCM','0374838098',1,0)
insert into KhachHang values('KH04',N'Nguyễn Huy Sỹ',N'TP Hà Nội','0374838113',1,0)
insert into KhachHang values('KH05',N'Dương Hồng Thủy',N'TP Hà Nội','0374838189',0,0)

--Chức Vụ
insert into ChucVu values('TN', N'Thu Ngân')
insert into ChucVu values('BV', N'Bảo Vệ')
insert into ChucVu values('TK', N'Thủ Kho')

--Nhân Viên
insert into NhanVien values('NV01','TN',N'Dương Hà Nhi',N'TP.HCM','0374838189','10-10-2001',0,0)
insert into NhanVien values('NV03','TK',N'Dư Văn Thảo',N'TP Hà Nội','0374836612','11-11-2001',1,0)
insert into NhanVien values('NV02','BV',N'Dương Minh Chiến',N'TP Hà Nam','0374838812','05-10-2001',1,0)

--Phiếu Nhập Hàng
insert into PhieuNhapHang values('PNH01','NV01','SP01',10000,123456,0)
insert into PhieuNhapHang values('PNH02','NV01','SP02',20000,103456,0)
insert into PhieuNhapHang values('PNH03','NV03','SP03',30000,113456,0)
insert into PhieuNhapHang values('PNH04','NV03','SP04',40000,153456,0)

--Hóa Đơn Bán
insert into HoaDonBan values('HDB01','NV01','KH01','12-10-2022',123456,0)
insert into HoaDonBan values('HDB02','NV03','KH01','12-10-2022',123456,0)
insert into HoaDonBan values('HDB03','NV02','KH01','26-11-2022',123456,0)
insert into HoaDonBan values('HDB04','NV02','KH01','05-08-2022',123456,0)
insert into HoaDonBan values('HDB05','NV01','KH01','04-10-2022',123456,0)

--Chi Tiết Hóa Đơn Bán
insert into CTHoaDonBan values('HDB01','SP01',10,1000,500,50000,0)
insert into CTHoaDonBan values('HDB02','SP04',10,1000,500,50000,0)
insert into CTHoaDonBan values('HDB03','SP02',10,1000,500,50000,0)
insert into CTHoaDonBan values('HDB04','SP03',10,1000,500,50000,0)
insert into CTHoaDonBan values('HDB02','SP05',10,1000,500,50000,0)

--Nhà Cung Cấp
insert into NhaCungCap values('NCC01',N'Hùng Mai',N'TP.HCM','0123456789','hungmai@gmail.com',0)
insert into NhaCungCap values('NCC02',N'Hùng Phượng',N'TP Hà Nội','0123456779','hungphuong@gmail.com',0)
insert into NhaCungCap values('NCC03',N'Hùng Thủy',N'TP.HCM','0123456759','hungthuy@gmail.com',0)

--Loại Sản Phẩm
insert into LoaiSanPham values('DT01',N'Máy Giặt',0)
insert into LoaiSanPham values('DT03',N'Máy Tính',0)
insert into LoaiSanPham values('DT02',N'TV',0)

--Sản Phẩm
insert into SanPham values('SP01',N'NCC01','DT01',N'Máy Giặt ToSiBa',10,1500000,2000000,'maygiat.jpg',N'Chưa có',0)
insert into SanPham values('SP02',N'NCC02','DT03',N'Máy Tính Dell',10,1500000,2300000,'maytinh.jpg',N'Chưa có',0)
insert into SanPham values('SP03',N'NCC03','DT02',N'TiVi Sony',10,1500000,2500000,'tivi.jpg',N'Chưa có',0)
insert into SanPham values('SP04',N'NCC01','DT03',N'Máy Tính Apple',10,1500000,2000000,'maytinh.jpg',N'Chưa có',0)
insert into SanPham values('SP05',N'NCC01','DT01',N'Máy Giặt SamSung',10,1500000,2000000,'maygiat.jpg',N'Chưa có',0)


