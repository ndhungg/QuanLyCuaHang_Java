package controll;

import helper.ConnectSQL;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import model.LoaiSanPham;
import model.NhaCungCap;
import model.SanPham;

public class SanPhamControll {

    public List<SanPham> findAll() throws Exception {
        String sql = "select sp.MaSanPham,sp.TenSanPham, ncc.TenNhaCungCap, lsp.TenLoaiSP,sp.SoLuong,sp.DonGiaNhap,sp.DonGiaBan,sp.HinhAnh,sp.GhiChu"
                + " from SanPham sp, NhaCungCap ncc, LoaiSanPham lsp"
                + " where sp.MaNhaCungCap = ncc.MaNhaCungCap and sp.MaLoaiSP = lsp.MaLoaiSP";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery();) {
                List<SanPham> list = new ArrayList<>();
                while (rs.next()) {
                    SanPham sp = createSanPham(rs);
                    list.add(sp);
                }
                return list;
            }
        }
    }

    public SanPham findID(String id) throws Exception {
        String sql = "select sp.MaSanPham,sp.TenSanPham, ncc.TenNhaCungCap, lsp.TenLoaiSP,sp.SoLuong,sp.DonGiaNhap,sp.DonGiaBan,sp.HinhAnh,sp.GhiChu"
                + " from SanPham sp, NhaCungCap ncc, LoaiSanPham lsp"
                + " where sp.MaNhaCungCap = ncc.MaNhaCungCap and sp.MaLoaiSP = lsp.MaLoaiSP and sp.MaSanPham = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, id);
            try (ResultSet rs = pstm.executeQuery();) {
                if (rs.next()) {
                    SanPham sp = createSanPham(rs);
                    return sp;
                }
            }
            return null;
        }
    }

    public List<SanPham> findKH_ByName(String ten) throws Exception {
        String sql = "select sp.MaSanPham,sp.TenSanPham, ncc.TenNhaCungCap, lsp.TenLoaiSP,sp.SoLuong,sp.DonGiaNhap,sp.DonGiaBan,sp.HinhAnh,sp.GhiChu"
                + " from SanPham sp, NhaCungCap ncc, LoaiSanPham lsp"
                + " where TenSanPham like N'%" + ten + "%' and sp.MaNhaCungCap = ncc.MaNhaCungCap and sp.MaLoaiSP = lsp.MaLoaiSP";
        try (Connection con = ConnectSQL.getConnection();
                PreparedStatement pstm = con.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery();) {
                List<SanPham> list = new ArrayList<>();
                while (rs.next()) {
                    SanPham sp = createSanPham(rs);
                    list.add(sp);
                }
                return list;
            }
        }
    }

    private SanPham createSanPham(final ResultSet rs) throws SQLException {
        SanPham sp = new SanPham();
        sp.setMaSanPham(rs.getString("MaSanPham"));
        sp.setTenSanPham(rs.getString("TenSanPham"));
        sp.setMaNhaCungCap(rs.getString("TenNhaCungCap"));
        sp.setMaLoaiSP(rs.getString("TenLoaiSP"));
        sp.setSoLuong(rs.getFloat("SoLuong"));
        sp.setDonGiaNhap(rs.getDouble("DonGiaNhap"));
        sp.setDonGiaBan(rs.getDouble("DonGiaBan"));
        sp.setHinhAnh(rs.getBytes("HinhAnh"));
//        Blob blob = rs.getBlob("HinhAnh");
//        if (blob != null) {
//            sp.setHinhAnh(blob.getBytes(0, (int) blob.length()));
//        }
        sp.setGhiChu(rs.getString("GhiChu"));
        return sp;
    }

    public List<NhaCungCap> layTenNhaCC() throws Exception {
        String sql = "select TenNhaCungCap from NhaCungCap";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery()) {
                List<NhaCungCap> listName = new ArrayList<>();
                while (rs.next()) {
                    NhaCungCap ncc = new NhaCungCap();
                    ncc.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                    listName.add(ncc);
                }
                return listName;
            }
        }
    }

    public List<LoaiSanPham> layTenLoaiSP() throws Exception {
        String sql = "select TenLoaiSP from LoaiSanPham";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            try (ResultSet rs = pstm.executeQuery()) {
                List<LoaiSanPham> listName = new ArrayList<>();
                while (rs.next()) {
                    LoaiSanPham loaiSP = new LoaiSanPham();
                    loaiSP.setTenLoaiSP(rs.getString("TenLoaiSP"));
                    listName.add(loaiSP);
                }
                return listName;
            }
        }
    }

    public String layMaNhaCC(String id) throws Exception {
        String sql = "select ncc.MaNhaCungCap"
                + " from NhaCungCap ncc, SanPham sp"
                + " where ncc.MaNhaCungCap = sp.MaNhaCungCap and ncc.TenNhaCungCap = ?";
        String ma = "";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, id);
            try (ResultSet rs = pstm.executeQuery();) {
                while (rs.next()) {
                    ma = rs.getString("MaNhaCungCap");
                    return ma;
                }
                return ma;
            }
        }
    }

    public String layMaLoaiSP(String id) throws Exception {
        String sql = "select lsp.MaLoaiSP "
                + " from LoaiSanPham lsp, SanPham sp"
                + " where lsp.MaLoaiSP = sp.MaLoaiSP and lsp.TenLoaiSP = ?";
        String ma = "";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, id);
            try (ResultSet rs = pstm.executeQuery();) {
                while (rs.next()) {
                    ma = rs.getString("MaLoaiSP");
                    return ma;
                }
                return ma;
            }
        }
    }

    public boolean insert(SanPham sp) throws Exception {
        String sql = " INSERT INTO [dbo].[SanPham]([MaSanPham],[MaNhaCungCap],[MaLoaiSP],[TenSanPham],[SoLuong],[DonGiaNhap],[DonGiaBan],[HinhAnh],[GhiChu],[TrangThai])"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, sp.getMaSanPham());
            pstm.setString(2, sp.getMaNhaCungCap());
            pstm.setString(3, sp.getMaLoaiSP());
            pstm.setString(4, sp.getTenSanPham());
            pstm.setFloat(5, sp.getSoLuong());
            pstm.setDouble(6, sp.getDonGiaNhap());
            pstm.setDouble(7, sp.getDonGiaBan());
//            File input = null;
//            BufferedImage read = ImageIO.read(input);
            if (sp.getHinhAnh() != null) {
                Blob hinhanh = new SerialBlob(sp.getHinhAnh());
                pstm.setBlob(8, hinhanh);
            } else {
                Blob hinhanh = null;
                pstm.setBlob(8, hinhanh);
            }
            pstm.setString(9, sp.getGhiChu());
            pstm.setInt(10, 0);
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean update(SanPham sp) throws Exception {
        String sql = "  UPDATE [dbo].[SanPham] SET [MaNhaCungCap] = ?,[MaLoaiSP] = ?,[TenSanPham] = ?,[SoLuong] = ?,[DonGiaNhap] = ?,[DonGiaBan] = ?,[HinhAnh] = ?,[GhiChu] = ?"
                + " Where [MaSanPham] = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, sp.getMaNhaCungCap());
            pstm.setString(2, sp.getMaLoaiSP());
            pstm.setString(3, sp.getTenSanPham());
            pstm.setFloat(4, sp.getSoLuong());
            pstm.setDouble(5, sp.getDonGiaNhap());
            pstm.setDouble(6, sp.getDonGiaBan());
            if (sp.getHinhAnh() != null) {
                Blob hinhanh = new SerialBlob(sp.getHinhAnh());
                pstm.setBlob(7, hinhanh);
            } else {
                Blob hinhanh = null;
                pstm.setBlob(7, hinhanh);
            }
            pstm.setString(8, sp.getGhiChu());
            pstm.setString(9, sp.getMaSanPham());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean delete(String id) throws Exception{
        String sql = "Delete from SanPham where MaSanPham = ?";
        try (Connection conn = ConnectSQL.getConnection();
                PreparedStatement pstm = conn.prepareCall(sql);) {
            pstm.setString(1, id);
            return pstm.executeUpdate() > 0;
        }
    }

}
