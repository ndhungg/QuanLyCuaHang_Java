package view;

import controll.SanPhamControll;
import helper.DataValidator;
import helper.ImageHelper;
import helper.MessageDialogHelper;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.LoaiSanPham;
import model.NhaCungCap;
import model.SanPham;
import java.util.List;

public class frmSanPham extends javax.swing.JFrame {

    private DefaultTableModel tbModel;
    private byte[] personalImage;

    public frmSanPham() {
        initComponents();
        initTable();
        loadDataToTable();
        loadTenLoaiSP();
        loadTenNhaCC();
    }

    private void initTable() {
        tbModel = new DefaultTableModel();
        tbModel.setColumnIdentifiers(new String[]{"Mã Sản Phẩm", "Tên Sản Phẩm", "Tên Nhà Cung Cấp", "Loại Sản Phẩm", "Ghi Chú"});
        tblSanPham.setModel(tbModel);
        TableColumnModel columnModel = tblSanPham.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(120);
        columnModel.getColumn(3).setPreferredWidth(80);
        columnModel.getColumn(4).setPreferredWidth(150);
    }

    private void listItemSP(List<SanPham> list) {
        tbModel.setRowCount(0);
        list.forEach((item) -> {
            tbModel.addRow(new Object[]{
                item.getMaSanPham(),
                item.getTenSanPham(),
                item.getMaNhaCungCap(),
                item.getMaLoaiSP(),
                item.getGhiChu()
            });
        });
        tbModel.fireTableDataChanged();
    }

    public void loadDataToTable() {
        try {
            SanPhamControll spControll = new SanPhamControll();
            List<SanPham> list = spControll.findAll();
            listItemSP(list);
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }

    public void loadTenNhaCC() {
        try {
            SanPhamControll spControll = new SanPhamControll();
            List<NhaCungCap> list = spControll.layTenNhaCC();
            DefaultComboBoxModel conBoxModel = new DefaultComboBoxModel();
            list.forEach((item) -> {
                conBoxModel.addElement(item.getTenNhaCungCap());
            });
            cbbNCC.setModel(conBoxModel);
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }

    public void loadTenLoaiSP() {
        try {
            SanPhamControll spControll = new SanPhamControll();
            List<LoaiSanPham> list = spControll.layTenLoaiSP();
            DefaultComboBoxModel conBoxModel = new DefaultComboBoxModel();
            list.forEach((item) -> {
                conBoxModel.addElement(item.getTenLoaiSP());
            });
            cbbLoaiSP.setModel(conBoxModel);
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }

    public void ressetText() {
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtGhiChu.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labHinhAnh = new javax.swing.JLabel();
        btnHinhAnh = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        cbbNCC = new javax.swing.JComboBox<>();
        cbbLoaiSP = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnKhongLuu = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Danh Sách Sản Phẩm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(462, 462, 462)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labHinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-favorite-cart-100.png"))); // NOI18N

        btnHinhAnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-pictures-folder-32.png"))); // NOI18N
        btnHinhAnh.setText("Hình Ảnh ");
        btnHinhAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHinhAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHinhAnh)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(labHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnHinhAnh)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Tên Sản Phẩm: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Mã Sản Phẩm: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Tên Nhà Cung Cấp: ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("Loại Sản Phẩm:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("Ghi Chú:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức Năng"));

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-32.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-delete-32.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-update-32.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-save-32.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnKhongLuu.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnKhongLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-cancel-32 (1).png"))); // NOI18N
        btnKhongLuu.setText("Không Lưu");
        btnKhongLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongLuuActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-search-32.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-exit-32.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnThem)
                .addGap(60, 60, 60)
                .addComponent(btnXoa)
                .addGap(60, 60, 60)
                .addComponent(btnSua)
                .addGap(60, 60, 60)
                .addComponent(btnLuu)
                .addGap(60, 60, 60)
                .addComponent(btnKhongLuu)
                .addGap(60, 60, 60)
                .addComponent(btnTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btnThoat)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnKhongLuu)
                    .addComponent(btnTimKiem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnThem)
                    .addComponent(btnThoat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("Tìm Kiếm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaSP)
                                            .addComponent(txtTenSP)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbNCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbbLoaiSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                    .addComponent(txtTimKiem))
                                .addGap(66, 66, 66)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(167, 167, 167))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel4)
                                                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(25, 25, 25)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel3)
                                                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(25, 25, 25)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel8)
                                                            .addComponent(cbbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(25, 25, 25))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel9)
                                                    .addComponent(cbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel11)
                                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(100, 100, 100)))))
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ressetText();
        personalImage = null;
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icon/icons8-favorite-cart-100.png"));
        labHinhAnh.setIcon(icon);
        loadDataToTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnKhongLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongLuuActionPerformed
        ressetText();
        personalImage = null;
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icon/icons8-favorite-cart-100.png"));
        labHinhAnh.setIcon(icon);
        loadDataToTable();
    }//GEN-LAST:event_btnKhongLuuActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtMaSP, sb, "Mã sản phẩm không được để trống !!!");
        DataValidator.ValidatorEmpty(txtTenSP, sb, "Tên sản phẩm không được để trống !!!");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            return;
        }
        try {
            boolean checkID = false;
            SanPham sp = new SanPham();
            SanPhamControll spControll = new SanPhamControll();
            int row = tblSanPham.getRowCount();
            String ma = txtMaSP.getText().trim();
            for (int i = 0; i < row; i++) {
                if (tblSanPham.getValueAt(i, 0).equals(ma)) {
                    checkID = true;
                    break;
                }
            }
            if (checkID) {
                MessageDialogHelper.ShowErrorDialog(this, "Thông báo", "Mã sản phẩm có mã: " + ma + " đã tồn tại trong danh sách!!!");
                txtMaSP.requestFocus();
            } else {
                String maNCC = spControll.layMaNhaCC(cbbNCC.getSelectedItem().toString());
                String maLoaiSP = spControll.layMaLoaiSP(cbbLoaiSP.getSelectedItem().toString());
                sp.setMaSanPham(txtMaSP.getText());
                sp.setMaNhaCungCap(maNCC);
                sp.setMaLoaiSP(maLoaiSP);
                sp.setTenSanPham(txtTenSP.getText());
                sp.setHinhAnh(personalImage);
                sp.setGhiChu(txtGhiChu.getText());

                if (spControll.insert(sp)) {
                    MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Thêm mới thành công !!!");
                    loadDataToTable();
                    ressetText();
                } else {
                    MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Thêm mới thành công !!!");
                    ressetText();
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtMaSP, sb, "Mã sản phẩm không được để trống !!!");
        DataValidator.ValidatorEmpty(txtTenSP, sb, "Tên sản phẩm không được để trống !!!");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            return;
        }

        if (MessageDialogHelper.ShowConfirmDialog(this, "Hỏi", "Bạn có muốn cập nhật thông tin của sản phẩm") == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            SanPhamControll spControll = new SanPhamControll();
            SanPham sp = new SanPham();

            String maNCC = spControll.layMaNhaCC(cbbNCC.getSelectedItem().toString());
            String maLoaiSP = spControll.layMaLoaiSP(cbbLoaiSP.getSelectedItem().toString());
            sp.setMaSanPham(txtMaSP.getText());
            sp.setMaNhaCungCap(maNCC);
            sp.setMaLoaiSP(maLoaiSP);
            sp.setTenSanPham(txtTenSP.getText());
            sp.setHinhAnh(personalImage);
            sp.setGhiChu(txtGhiChu.getText());

            if (spControll.update(sp)) {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Cập nhật thành công !!!");
                loadDataToTable();
                ressetText();
            } else {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Cập nhật thành công !!!");
                ressetText();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtTimKiem, sb, "Vui lòng nhập tên sản phẩm cần tìm !!!");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            txtTimKiem.requestFocus();
            return;
        }
        String ten = txtTimKiem.getText().trim();
        try {
            SanPhamControll spControll = new SanPhamControll();
            List<SanPham> list = spControll.findKH_ByName(ten);
            if (list.size() > 0) {
                listItemSP(list);
                ressetText();
            } else {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Không tìm thấy sản phẩm có tên: " + txtTimKiem.getText() + " trong danh sách!!!");
                txtTimKiem.setText("");
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int row = tblSanPham.getSelectedRow();

        if (row >= 0) {
            try {
                String id = tblSanPham.getValueAt(row, 0).toString();
                SanPhamControll spControll = new SanPhamControll();
                SanPham sp = spControll.findID(id);
                if (sp != null) {
                    txtMaSP.setText(sp.getMaSanPham());
                    txtTenSP.setText(sp.getTenSanPham());
                    cbbNCC.getModel().setSelectedItem(tblSanPham.getValueAt(row, 2));
                    cbbLoaiSP.getModel().setSelectedItem(tblSanPham.getValueAt(row, 3));
                    if (sp.getHinhAnh() != null) {
                        Image img = ImageHelper.createImageFromByteArray(sp.getHinhAnh(), "jpg");
                        labHinhAnh.setIcon(new ImageIcon(img));
                        personalImage = sp.getHinhAnh();
                    } else {
                        personalImage = sp.getHinhAnh();
                        ImageIcon icon = new ImageIcon(getClass().getResource("/Icon/icons8-favorite-cart-100.png"));
                        labHinhAnh.setIcon(icon);
                    }
                    txtGhiChu.setText(sp.getGhiChu());
                }
            } catch (Exception e) {
                MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
                System.out.println(e.getMessage());
            }
        } else {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", "Bạn chưa sản phẩm nằm trong bảng!!!");
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblSanPham.getSelectedRow();
        if (row >= 0) {
            try {
                if (MessageDialogHelper.ShowConfirmDialog(this, "Thông báo", "Bạn có muốn xóa thông tin sản phẩm") == JOptionPane.NO_OPTION) {
                    ressetText();
                    return;
                } else {
                    SanPhamControll spControll = new SanPhamControll();
                    if (spControll.delete(txtMaSP.getText())) {
                        MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Xóa thành công");
                        ressetText();
                        loadDataToTable();
                    } else {
                        MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Xóa thất bại");
                    }
                }
            } catch (Exception e) {
                MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
            }
        } else {
            MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Vui lòng chọn sản phẩm bạn muốn xóa!!!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnHinhAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHinhAnhActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            }
        });

        if (chooser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File file = chooser.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = ImageHelper.resize(icon.getImage(), 165, 200);
            ImageIcon resizeIcon = new ImageIcon(img);
            labHinhAnh.setIcon(resizeIcon);
            personalImage = ImageHelper.toByteArray(img, "jpg");
        } catch (IOException e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }


    }//GEN-LAST:event_btnHinhAnhActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        if (MessageDialogHelper.ShowConfirmDialog(this, "Thông báo", "Bạn có muốn thoát !!!") == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHinhAnh;
    private javax.swing.JButton btnKhongLuu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbLoaiSP;
    private javax.swing.JComboBox<String> cbbNCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labHinhAnh;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
