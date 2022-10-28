package view;

import controll.LoaiSanPhamControll;
import helper.DataValidator;
import helper.MessageDialogHelper;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.LoaiSanPham;

public class frmLoaiSP extends javax.swing.JFrame {

    private DefaultTableModel tbModel;

    public frmLoaiSP() {
        initComponents();
        initTable();
        loadDataToTable();
    }

    public void initTable() {
        tbModel = new DefaultTableModel();
        tbModel.setColumnIdentifiers(new String[]{"Mã loại sản phẩm", "Tên loại sản phẩm"});
        tblLoaiSP.setModel(tbModel);
        TableColumnModel columnModel = tblLoaiSP.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(160);

    }

    public void ressetText() {
        txtMaLoaiSP.setText("");
        txtTenLoaiSP.setText("");
        txtMaLoaiSP.requestFocus();
    }

    public void loadDataToTable() {
        try {
            LoaiSanPhamControll loaiSPControll = new LoaiSanPhamControll();
            List<LoaiSanPham> list = loaiSPControll.findAll();
            tbModel.setRowCount(0);
            list.forEach((item) -> {
                tbModel.addRow(new Object[]{
                    item.getMaLoaiSP(),
                    item.getTenLoaiSP(),});
            });
            tbModel.fireTableDataChanged();
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaLoaiSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenLoaiSP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoaiSP = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Danh Mục Loại Sản Phẩm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Mã Sản Phẩm:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Tên Sản Phẩm");

        tblLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLoaiSP);

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-delete-32.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-32.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Tìm Kiếm:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addGap(57, 57, 57)
                        .addComponent(btnThem)
                        .addGap(67, 67, 67)
                        .addComponent(btnXoa)
                        .addGap(66, 66, 66)
                        .addComponent(btnSua)
                        .addGap(79, 79, 79)
                        .addComponent(btnLuu)
                        .addGap(72, 72, 72)
                        .addComponent(btnThoat))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimKiem)
                            .addComponent(txtTenLoaiSP)
                            .addComponent(txtMaLoaiSP))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txtMaLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnLuu)
                    .addComponent(btnThoat)
                    .addComponent(btnXoa)
                    .addComponent(btnThem)
                    .addComponent(btnTimKiem))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiSPMouseClicked
        try {
            int row = tblLoaiSP.getSelectedRow();
            String id = tblLoaiSP.getValueAt(row, 0).toString();
            if (row >= 0) {
                LoaiSanPhamControll loaiSPControll = new LoaiSanPhamControll();
                LoaiSanPham loaiSP = loaiSPControll.findId(id);
                if (loaiSP != null) {
                    txtMaLoaiSP.setText(loaiSP.getMaLoaiSP());
                    txtTenLoaiSP.setText(loaiSP.getTenLoaiSP());
                }
            } else {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Bạn chưa lựa chọn loại sản phẩm");
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }//GEN-LAST:event_tblLoaiSPMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ressetText();
        loadDataToTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtMaLoaiSP, sb, "Mã loại sản phẩm không được để trống !!!");
        DataValidator.ValidatorEmpty(txtTenLoaiSP, sb, "Tên loại sản phẩm không được để trống !!!");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            return;
        }
        txtMaLoaiSP.requestFocus();
        try {
            boolean checkId = false;
            String maCV = txtMaLoaiSP.getText().trim();
            int row = tblLoaiSP.getRowCount();
            for (int i = 0; i < row; i++) {
                if (maCV.equalsIgnoreCase(tblLoaiSP.getValueAt(i, 0).toString().trim())) {
                    checkId = true;
                    break;
                }
            }
            if (checkId) {
                MessageDialogHelper.ShowErrorDialog(this, "Thông báo", "Mã loại sản phẩm: " + maCV + " đã tồn tại");
                txtMaLoaiSP.requestFocus();
            } else {
                LoaiSanPham loaiSP = new LoaiSanPham();
                LoaiSanPhamControll loaiSPControll = new LoaiSanPhamControll();
                loaiSP.setMaLoaiSP(txtMaLoaiSP.getText());
                loaiSP.setTenLoaiSP(txtTenLoaiSP.getText());
                if (loaiSPControll.insert(loaiSP)) {
                    MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Thêm mới thành công");
                    loadDataToTable();
                    ressetText();
                } else {
                    MessageDialogHelper.ShowErrorDialog(this, "Lỗi", "Thêm mới thất bại");
                }
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblLoaiSP.getSelectedRow();
        if (row >= 0) {
            try {
                if (MessageDialogHelper.ShowConfirmDialog(this, "Thông báo", "Bạn có muốn xóa thông tin loại sản phẩm") == JOptionPane.NO_OPTION) {
                    ressetText();
                    return;
                } else {
                    LoaiSanPhamControll loaiSPControll = new LoaiSanPhamControll();
                    if (loaiSPControll.delete(txtMaLoaiSP.getText())) {
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
            MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Vui lòng chọn loại sản phẩm bạn muốn xóa!!!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtMaLoaiSP, sb, "Mã loại sản phẩm không được để trống !!!");
        DataValidator.ValidatorEmpty(txtTenLoaiSP, sb, "Tên loại sản phẩm không được để trống !!!");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            return;
        }
        if (MessageDialogHelper.ShowConfirmDialog(this, "Hỏi", "Bạn có muốn cập nhật thông tin loại sản phẩm ?") == JOptionPane.NO_OPTION) {
            ressetText();
            txtTimKiem.setText("");
            return;
        }
        try {
            boolean checkName = false;
            String tenLoaiSP = txtTenLoaiSP.getText().trim();
            int row = tblLoaiSP.getRowCount();
            for (int i = 0; i < row; i++) {
                if (tenLoaiSP.equalsIgnoreCase(tblLoaiSP.getValueAt(i, 1).toString().trim())) {
                    checkName = true;
                    break;
                }
            }
            if (checkName) {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Loại sản phẩm có tên:" + txtTenLoaiSP.getText() + " đã tồn tại trong danh sách");
                return;
            } else {
                LoaiSanPham loaiSP = new LoaiSanPham();
                loaiSP.setMaLoaiSP(txtMaLoaiSP.getText());
                loaiSP.setTenLoaiSP(txtTenLoaiSP.getText());
                LoaiSanPhamControll loaiSPControll = new LoaiSanPhamControll();
                if (loaiSPControll.update(loaiSP)) {
                    MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Cập nhật thông tin thành công.");
                    loadDataToTable();
                    ressetText();
                    txtTimKiem.setText("");
                } else {
                    MessageDialogHelper.ShowErrorDialog(this, "Cảnh Báo", "Không thể cập nhật thông tin !!!");
                }
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtTimKiem, sb, "Vui lòng nhập tên loại sản phẩm cần tìm !!!");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            txtTimKiem.requestFocus();
            return;
        }
        String ten = txtTimKiem.getText().trim();
        try {
            LoaiSanPhamControll loaiSPControll = new LoaiSanPhamControll();
            List<LoaiSanPham> list = loaiSPControll.findByName(ten);
            if (list.size() > 0) {
                tbModel.setRowCount(0);
                list.forEach((item) -> {
                    tbModel.addRow(new Object[]{
                        item.getMaLoaiSP(),
                        item.getTenLoaiSP(),});
                });
                tbModel.fireTableDataChanged();
                ressetText();
            } else {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Không tìm thấy loại sản phẩm: " + txtTimKiem.getText() + " có tên trong danh sách!!!");
                loadDataToTable();
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(frmLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLoaiSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLoaiSP;
    private javax.swing.JTextField txtMaLoaiSP;
    private javax.swing.JTextField txtTenLoaiSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
