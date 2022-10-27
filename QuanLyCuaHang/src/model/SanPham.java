package model;

public class SanPham {

    private String MaSanPham, MaNhaCungCap, MaLoaiSP, TenSanPham, GhiChu;
    private double DonGiaNhap, DonGiaBan;
    private byte[] HinhAnh;
    private int TrangThai,SoLuong;

    public SanPham() {
    }

    public SanPham(String MaSanPham, String MaNhaCungCap, String MaLoaiSP, String TenSanPham, String GhiChu, int SoLuong, double DonGiaNhap, double DonGiaBan, byte[] HinhAnh, int TrangThai) {
        this.MaSanPham = MaSanPham;
        this.MaNhaCungCap = MaNhaCungCap;
        this.MaLoaiSP = MaLoaiSP;
        this.TenSanPham = TenSanPham;
        this.GhiChu = GhiChu;
        this.SoLuong = SoLuong;
        this.DonGiaNhap = DonGiaNhap;
        this.DonGiaBan = DonGiaBan;
        this.HinhAnh = HinhAnh;
        this.TrangThai = TrangThai;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public String getMaLoaiSP() {
        return MaLoaiSP;
    }

    public void setMaLoaiSP(String MaLoaiSP) {
        this.MaLoaiSP = MaLoaiSP;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(double DonGiaNhap) {
        this.DonGiaNhap = DonGiaNhap;
    }

    public double getDonGiaBan() {
        return DonGiaBan;
    }

    public void setDonGiaBan(double DonGiaBan) {
        this.DonGiaBan = DonGiaBan;
    }

    public byte[] getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(byte[] HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

}
