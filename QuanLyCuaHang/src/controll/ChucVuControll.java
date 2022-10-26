package controll;

import helper.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChucVu;

public class ChucVuControll {
    
    public List<ChucVu> findAll() throws Exception {
        String sql = "Select *from ChucVu";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery();) {
                List<ChucVu> list = new ArrayList<>();
                while (rs.next()) {
                    ChucVu cv = new ChucVu();
                    cv.setMaChucVu(rs.getString("MaChucVu"));
                    cv.setTenChucVu(rs.getString("TenChucVu"));
                    list.add(cv);
                }
                return list;
            }
        }
    }
    
    public ChucVu findId(String id) throws Exception {
        String sql = "Select *from ChucVu where MaChucVu = ? ";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, id);
            try (ResultSet rs = pstm.executeQuery();) {
                while (rs.next()) {
                    ChucVu cv = new ChucVu();
                    cv.setMaChucVu(rs.getString("MaChucVu"));
                    cv.setTenChucVu(rs.getString("TenChucVu"));
                    return cv;
                }
            }
            return null;
        }
    }
    
    public boolean insert(ChucVu cv) throws Exception {
        String sql = "INSERT INTO dbo.ChucVu(MaChucVu,TenChucVu)"
                + "Values(?,?)";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, cv.getMaChucVu());
            pstm.setString(2, cv.getTenChucVu());
            return pstm.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String maCV) throws Exception {
        String sql = "Delete from ChucVu where MaChucVu = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, maCV);
            return pstm.executeUpdate() > 0;
        }
    }
    
    public boolean update(ChucVu cv) throws Exception {
        String sql = "Update ChucVu set TenChucVu = ? where MaChucVu = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, cv.getTenChucVu());
            pstm.setString(2, cv.getMaChucVu());
            return pstm.executeUpdate() > 0;
        }
    }
    
    public List<ChucVu> findByName(String tenCV) throws Exception {
        String sql = "Select *from ChucVu where TenChucVu like N'%" + tenCV + "%'";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery()) {
                List<ChucVu> list = new ArrayList<>();
                while (rs.next()) {
                    ChucVu cv = new ChucVu();
                    cv.setMaChucVu(rs.getString("MaChucVu"));
                    cv.setTenChucVu(rs.getString("TenChucVu"));
                    list.add(cv);
                }
                return list;
            }
        }
    }
    
}
