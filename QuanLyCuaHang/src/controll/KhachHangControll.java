package controll;

import java.sql.Connection;
import model.KhachHang;
import helper.ConnectSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangControll {

    public boolean Insert(KhachHang kh) throws Exception {
        String sql = "INSERT INTO dbo.KhachHang(MaKhachHang,TenKhachHang,DiaChi,SoDienThoai,GioiTinh,TrangThai)"
                + "VALUES(?,?,?,?,?,?)";
        try (Connection con = ConnectSQL.getConnection();
                PreparedStatement pstm = con.prepareCall(sql);) {
            pstm.setString(1, kh.getMaKhachHang());
            pstm.setString(2, kh.getTenKhachHang());
            pstm.setString(3, kh.getDiaChi());
            pstm.setString(4, kh.getSoDienThoai());
            pstm.setInt(5, kh.getGioiTinh());
            pstm.setInt(6, 0);
            return pstm.executeUpdate() > 0;
        }
    }

    public KhachHang findId(String maKH) throws Exception {
        String sql = "Select *from KhachHang where MaKhachHang = ?";
        try (Connection con = ConnectSQL.getConnection();
                PreparedStatement pstm = con.prepareCall(sql);) {
            pstm.setString(1, maKH);
            try (ResultSet rs = pstm.executeQuery();) {
                if (rs.next()) {
                    KhachHang kh = createKhachHang(rs);
                    return kh;
                }
            }
            return null;
        }
    }

    public List<KhachHang> findAll() throws Exception {
        String sql = "Select *from KhachHang";
        try (
                Connection con = ConnectSQL.getConnection();
                PreparedStatement pstm = con.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery();) {
                List<KhachHang> list = new ArrayList<>();
                while (rs.next()) {
                    KhachHang kh = createKhachHang(rs);
                    list.add(kh);
                }
                return list;
            }
        }
    }

    public List<KhachHang> findKH_ByName(String tenKH) throws Exception {
        String sql = "Select *from KhachHang where TenKhachHang like N'%" + tenKH + "%'";
        try (
                Connection con = ConnectSQL.getConnection();
                PreparedStatement pstm = con.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery();) {
                List<KhachHang> list = new ArrayList<>();
                while (rs.next()) {
                    KhachHang kh = createKhachHang(rs);
                    list.add(kh);
                }
                return list;
            }
        }
    }

    private KhachHang createKhachHang(final ResultSet rs) throws SQLException {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(rs.getString("MaKhachHang"));
        kh.setTenKhachHang(rs.getString("TenKhachHang"));
        kh.setDiaChi(rs.getString("DiaChi"));
        kh.setSoDienThoai(rs.getString("SoDienThoai"));
        kh.setGioiTinh(rs.getInt("GioiTinh"));
        kh.setTrangThai(rs.getInt("TrangThai"));
        return kh;
    }

    public boolean update(KhachHang kh) throws Exception {
        String sql = "UPDATE dbo.KhachHang"
                + " SET TenKhachHang = ?,DiaChi = ? ,SoDienThoai = ?,GioiTinh = ?"
                + " where  TrangThai = 0 and MaKhachHang = ?";
        try (Connection con = ConnectSQL.getConnection();
                PreparedStatement pstm = con.prepareCall(sql);) {
            pstm.setString(1, kh.getTenKhachHang());
            pstm.setString(2, kh.getDiaChi());
            pstm.setString(3, kh.getSoDienThoai());
            pstm.setInt(4, kh.getGioiTinh());
            pstm.setString(5, kh.getMaKhachHang());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean delete(String maKH) throws Exception {
        String sql = "Delete dbo.KhachHang"
                + " where MaKhachHang = ?";
        try (Connection con = ConnectSQL.getConnection();
                PreparedStatement pstm = con.prepareCall(sql);) {
            pstm.setString(1, maKH);
            return pstm.executeUpdate() > 0;
        }
    }
}
