package controll;

import helper.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import model.ChucVu;

public class NhanVienControll {

    public boolean insert(NhanVien nv) throws Exception {
        String sql = "INSERT INTO NhanVien(MaNhanVien,MaChucVu,TenNhanVien,DiaChi,SoDienThoai,NgaySinh,GioiTinh,TrangThai)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        try (Connection con = ConnectSQL.getConnection();
                PreparedStatement pstm = con.prepareCall(sql);) {
            pstm.setString(1, nv.getMaNhanVien());
            pstm.setString(2, nv.getMaChucVu());
            pstm.setString(3, nv.getTenNhanVien());
            pstm.setString(4, nv.getDiaChi());
            pstm.setString(5, nv.getSoDienThoai());
            pstm.setString(6, nv.getNgaySinh());
            pstm.setInt(7, nv.getGioiTinh());
            pstm.setInt(8, 0);
            return pstm.executeUpdate() > 0;
        }
    }

    public List<NhanVien> findAll() throws Exception {
        String sql = "select nv.MaNhanVien, nv.TenNhanVien, cv.TenChucVu, nv.DiaChi, nv.SoDienThoai, nv.NgaySinh,nv.GioiTinh"
                + " from NhanVien nv , ChucVu cv"
                + " where nv.MaChucVu = cv.MaChucVu";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery()) {
                List<NhanVien> list = new ArrayList<>();
                while (rs.next()) {
                    NhanVien nv = createNhanVien(rs);
                    list.add(nv);
                }
                return list;
            }
        }
    }

    public NhanVien findId(String id) throws Exception {
        String sql = "select nv.MaNhanVien, nv.TenNhanVien, cv.MaChucVu, nv.DiaChi, nv.SoDienThoai, nv.NgaySinh,nv.GioiTinh"
                + " from NhanVien nv, ChucVu cv"
                + " Where nv.MaChucVu = cv.MaChuVu and nv.MaNhanVien = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, id);
            try (ResultSet rs = pstm.executeQuery();) {
                if (rs.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNhanVien(rs.getString("MaNhanVien"));
                    nv.setTenNhanVien(rs.getString("TenNhanVien"));
                    nv.setMaChucVu(rs.getString("MaChucVu"));
                    nv.setGioiTinh(rs.getInt("GioiTinh"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    nv.setSoDienThoai(rs.getString("SoDienThoai"));
                    nv.setNgaySinh(rs.getString("NgaySinh"));
                    return nv;
                }
            }
            return null;
        }
    }

    private NhanVien createNhanVien(final ResultSet rs) throws SQLException {
        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(rs.getString("MaNhanVien"));
        nv.setTenNhanVien(rs.getString("TenNhanVien"));
        nv.setMaChucVu(rs.getString("TenChucVu"));
        nv.setGioiTinh(rs.getInt("GioiTinh"));
        nv.setDiaChi(rs.getString("DiaChi"));
        nv.setSoDienThoai(rs.getString("SoDienThoai"));
        nv.setNgaySinh(rs.getString("NgaySinh"));
        return nv;
    }

    public List<ChucVu> getByNameCBB() throws Exception {
        String sql = "Select cv.TenChucVu "
                + " from ChucVu cv";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery()) {
                List<ChucVu> listName = new ArrayList<>();
                while (rs.next()) {
                    ChucVu cv = new ChucVu();
                    cv.setTenChucVu(rs.getString("TenChucVu"));
                    listName.add(cv);
                }
                return listName;
            }
        }
    }

    public boolean delete(String maNV) throws Exception {
        String sql = "Delete from NhanVien where MaNhanVien = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, maNV);
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean update(NhanVien nv) throws Exception {
        String sql = "Update dbo.NhanVien"
                + " SET TenNhanVien = ?,MaChucVu = ?,GioiTinh = ?, DiaChi = ?, SoDienThoai = ?, NgaySinh = ?"
                + " Where MaNhanVien = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, nv.getTenNhanVien());
            pstm.setString(2, nv.getMaChucVu());
            pstm.setInt(3, nv.getGioiTinh());
            pstm.setString(4, nv.getDiaChi());
            pstm.setString(5, nv.getSoDienThoai());
            pstm.setString(6, nv.getNgaySinh());
            pstm.setString(7, nv.getMaNhanVien());
            return pstm.executeUpdate() > 0;
        }
    }

    public String layMaChucVuTheoTen(String maCV) throws Exception {
        String sql = "select nv.MaChucVu"
                + " from NhanVien nv , ChucVu cv"
                + " where nv.MaChucVu = cv.MaChucVu and cv.TenChucVu = ?";
        String ma = "";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, maCV);
            try (ResultSet rs = pstm.executeQuery();) {
                while (rs.next()) {
                    NhanVien nv = new NhanVien();
                    ma = rs.getString("MaChucVu");
                    return ma;
                }
                return ma;
            }
        }
    }

    public List<NhanVien> layMaNhanVien() throws Exception {
        String sql = "Select MaNhanVien "
                + " from NhanVien nv, ChucVu cv"
                + " where nv.MaChucVu = cv.MaChucVu";
        String ma = "";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
             List<NhanVien> listID = new ArrayList<>();
            try (ResultSet rs = pstm.executeQuery();) {
                while (rs.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNhanVien(rs.getString("MaNhanVien"));
                   listID.add(nv);
                }
               return listID;
            }
        }
    }

    public List<NhanVien> findKH_ByName(String ten) throws Exception {
        String sql = "select nv.MaNhanVien, nv.TenNhanVien, cv.TenChucVu, nv.DiaChi, nv.SoDienThoai, nv.NgaySinh,nv.GioiTinh"
                + " from NhanVien nv , ChucVu cv"
                + " where TenNhanVien like N'%" + ten + "%' and cv.MaChucVu = nv.MaChucVu";
        try (Connection con = ConnectSQL.getConnection();
                PreparedStatement pstm = con.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery();) {
                List<NhanVien> list = new ArrayList<>();
                while (rs.next()) {
                    NhanVien nv = createNhanVien(rs);
                    list.add(nv);
                }
                return list;
            }
        }
    }

}
