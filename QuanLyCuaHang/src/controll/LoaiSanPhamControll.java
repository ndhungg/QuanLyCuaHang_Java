package controll;

import helper.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.LoaiSanPham;

public class LoaiSanPhamControll {
    
    public List<LoaiSanPham> findAll() throws Exception {
        String sql = "Select *from LoaiSanPham";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery();) {
                List<LoaiSanPham> list = new ArrayList<>();
                while (rs.next()) {
                    LoaiSanPham loaiSP = new LoaiSanPham();
                    loaiSP.setMaLoaiSP(rs.getString("MaLoaiSP"));
                    loaiSP.setTenLoaiSP(rs.getString("TenLoaiSP"));
                    list.add(loaiSP);
                }
                return list;
            }
        }
    }
    
    public LoaiSanPham findId(String id) throws Exception {
        String sql = "Select *from LoaiSanPham where MaLoaiSP = ? ";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, id);
            try (ResultSet rs = pstm.executeQuery();) {
                while (rs.next()) {
                    LoaiSanPham loaiSP = new LoaiSanPham();
                    loaiSP.setMaLoaiSP(rs.getString("MaLoaiSP"));
                    loaiSP.setTenLoaiSP(rs.getString("TenLoaiSP"));
                    return loaiSP;
                }
            }
            return null;
        }
    }
    
    public boolean insert(LoaiSanPham loaiSP) throws Exception {
        String sql = "INSERT INTO dbo.LoaiSanPham(MaLoaiSP,TenLoaiSP,TrangThai)"
                + "Values(?,?,?)";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, loaiSP.getMaLoaiSP());
            pstm.setString(2, loaiSP.getTenLoaiSP());
            pstm.setInt(3, 0);
            return pstm.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String maloaiSP) throws Exception {
        String sql = "Delete from LoaiSanPham where MaLoaiSP = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, maloaiSP);
            return pstm.executeUpdate() > 0;
        }
    }
    
    public boolean update(LoaiSanPham loaiSP) throws Exception {
        String sql = "Update LoaiSanPham set TenLoaiSP = ? where MaLoaiSP = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, loaiSP.getTenLoaiSP());
            pstm.setString(2, loaiSP.getMaLoaiSP());
            return pstm.executeUpdate() > 0;
        }
    }
    
    public List<LoaiSanPham> findByName(String tenloaiSP) throws Exception {
        String sql = "Select *from LoaiSanPham where TenLoaiSP like N'%" + tenloaiSP + "%'";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery()) {
                List<LoaiSanPham> list = new ArrayList<>();
                while (rs.next()) {
                    LoaiSanPham loaiSP = new LoaiSanPham();
                    loaiSP.setMaLoaiSP(rs.getString("MaLoaiSP"));
                    loaiSP.setTenLoaiSP(rs.getString("TenLoaiSP"));
                    list.add(loaiSP);
                }
                return list;
            }
        }
    }
    
}
