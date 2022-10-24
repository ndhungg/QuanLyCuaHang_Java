package model;

public class NhanVien {
    private String MaNhanVien, MaChucVu, TenNhanVien, DiaChi, SoDienThoai;
    private String NgaySinh;
    private int GioiTinh;
    private int TrangThai;

    public NhanVien() {
    }

    public NhanVien(String MaNhanVien, String MaChucVu, String TenNhanVien, String DiaChi, String SoDienThoai, String NgaySinh, int GioiTinh, int TrangThai) {
        this.MaNhanVien = MaNhanVien;
        this.MaChucVu = MaChucVu;
        this.TenNhanVien = TenNhanVien;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.TrangThai = TrangThai;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

}
