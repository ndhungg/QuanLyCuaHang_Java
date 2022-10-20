package controll;

import helper.ConnectSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhaCungCap;

/**
 *
 * @author DELL
 */
public class NhaCungCapControll {

    public boolean Insert(NhaCungCap ncc) throws Exception {
        String sql = "INSERT INTO dbo.NhaCungCap(MaNhaCungCap,TenNhaCungCap,DiaChi,SoDienThoai,Email,TrangThai)"
                + "VALUES(?,?,?,?,?,?)";
        try (Connection con = ConnectSQL.getConnection();
                PreparedStatement pstm = con.prepareCall(sql);) {
            pstm.setString(1, ncc.getMaNhaCungCap());
            pstm.setString(2, ncc.getTenNhaCungCap());
            pstm.setString(3, ncc.getDiaChi());
            pstm.setString(4, ncc.getSoDienThoai());
            pstm.setString(5, ncc.getEmail());
            pstm.setInt(6, 0);
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean delete(String maNCC) throws Exception {
        String sql = "Delete from NhaCungCap where MaNhaCungCap = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, maNCC);
            return pstm.executeUpdate() > 0;
        }
    }

    public List<NhaCungCap> findAll() throws Exception {
        String sql = "Select *from NhaCungCap";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery()) {
                List<NhaCungCap> list = new ArrayList<>();
                while (rs.next()) {
                    NhaCungCap ncc = createNhaCungCap(rs);
                    list.add(ncc);
                }
                return list;
            }
        }
    }

    public NhaCungCap findId(String maNCC) throws Exception {
        String sql = "Select *from NhaCungCap where MaNhaCungCap = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, maNCC);
            try (ResultSet rs = pstm.executeQuery();) {
                if (rs.next()) {
                    NhaCungCap ncc = createNhaCungCap(rs);
                    return ncc;
                }
            }
            return null;
        }
    }

    private NhaCungCap createNhaCungCap(final ResultSet rs) throws SQLException {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMaNhaCungCap(rs.getString("MaNhaCungCap"));
        ncc.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
        ncc.setDiaChi(rs.getString("DiaChi"));
        ncc.setSoDienThoai(rs.getString("SoDienThoai"));
        ncc.setEmail(rs.getString("Email"));
        ncc.setTrangThai(rs.getInt("TrangThai"));
        return ncc;
    }
}
