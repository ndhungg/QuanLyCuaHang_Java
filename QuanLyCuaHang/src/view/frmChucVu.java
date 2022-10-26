package view;

import controll.ChucVuControll;
import helper.DataValidator;
import helper.MessageDialogHelper;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.ChucVu;

public class frmChucVu extends javax.swing.JFrame {

    private DefaultTableModel tbModel;

    public frmChucVu() {
        initComponents();
        initTable();
        loadDataToTable();
    }

    public void initTable() {
        tbModel = new DefaultTableModel();
        tbModel.setColumnIdentifiers(new String[]{"Mã chức vụ", "Tên chức vụ"});
        tblChucVu.setModel(tbModel);
        TableColumnModel columnModel = tblChucVu.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(160);

    }

    public void ressetText() {
        txtMaCV.setText("");
        txtTenCV.setText("");
        txtMaCV.requestFocus();
    }

    public void loadDataToTable() {
        try {
            ChucVuControll cvControll = new ChucVuControll();
            List<ChucVu> list = cvControll.findAll();
            tbModel.setRowCount(0);
            list.forEach((item) -> {
                tbModel.addRow(new Object[]{
                    item.getMaChucVu(),
                    item.getTenChucVu(),});
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
        txtMaCV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenCV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChucVu = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Danh Mục Chức Vụ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Mã Chức Vụ: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Tên Chức Vụ: ");

        tblChucVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChucVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChucVu);

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/icons8-delete-32.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/icons8-add-32.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/icons8-update-32.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/icons8-save-32.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/icons8-search-32.png"))); // NOI18N
        jButton5.setText("Tìm Kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/icons8-exit-32.png"))); // NOI18N
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
                        .addComponent(jButton5)
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
                            .addComponent(txtTenCV)
                            .addComponent(txtMaCV))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txtMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnLuu)
                    .addComponent(btnThoat)
                    .addComponent(btnXoa)
                    .addComponent(btnThem)
                    .addComponent(jButton5))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChucVuMouseClicked
        try {
            int row = tblChucVu.getSelectedRow();
            String id = tblChucVu.getValueAt(row, 0).toString();
            if (row >= 0) {
                ChucVuControll cvControll = new ChucVuControll();
                ChucVu cv = cvControll.findId(id);
                if (cv != null) {
                    txtMaCV.setText(cv.getMaChucVu());
                    txtTenCV.setText(cv.getTenChucVu());
                }
            } else {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Bạn chưa lựa chọn chức vụ");
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }//GEN-LAST:event_tblChucVuMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ressetText();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtMaCV, sb, "Mã khách hàng không được để trống !!!");
        DataValidator.ValidatorEmpty(txtTenCV, sb, "Tên khách hàng không được để trống !!!");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            return;
        }
        txtMaCV.requestFocus();
        try {
            boolean checkId = false;
            String maCV = txtMaCV.getText().trim();
            int row = tblChucVu.getRowCount();
            for (int i = 0; i < row; i++) {
                if (maCV.equalsIgnoreCase(tblChucVu.getValueAt(i, 0).toString().trim())) {
                    checkId = true;
                    break;
                }
            }
            if (checkId) {
                MessageDialogHelper.ShowErrorDialog(this, "Thông báo", "Mã chức vụ: " + maCV + " đã tồn tại");
                txtMaCV.requestFocus();
            } else {
                ChucVu cv = new ChucVu();
                ChucVuControll cvControll = new ChucVuControll();
                cv.setMaChucVu(txtMaCV.getText());
                cv.setTenChucVu(txtTenCV.getText());
                if (cvControll.insert(cv)) {
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
        int row = tblChucVu.getSelectedRow();
        if (row >= 0) {
            try {
                if (MessageDialogHelper.ShowConfirmDialog(this, "Thông báo", "Bạn có muốn xóa thông tin chức vụ") == JOptionPane.NO_OPTION) {
                    ressetText();
                    return;
                } else {
                    ChucVuControll cvControll = new ChucVuControll();
                    if (cvControll.delete(txtMaCV.getText())) {
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
            MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Vui lòng chọn chức vụ bạn muốn xóa!!!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtMaCV, sb, "Mã khách hàng không được để trống !!!");
        DataValidator.ValidatorEmpty(txtTenCV, sb, "Tên khách hàng không được để trống !!!");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            return;
        }
        if (MessageDialogHelper.ShowConfirmDialog(this, "Hỏi", "Bạn có muốn cập nhật thông tin chức vụ ?") == JOptionPane.NO_OPTION) {
            ressetText();
            txtTimKiem.setText("");
            return;
        }
        try {
            ChucVu cv = new ChucVu();
            cv.setMaChucVu(txtMaCV.getText());
            cv.setTenChucVu(txtTenCV.getText());
            ChucVuControll ChucVuControll = new ChucVuControll();
            if (ChucVuControll.update(cv)) {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Cập nhật thông tin thành công.");
                loadDataToTable();
                ressetText();
                txtTimKiem.setText("");
            } else {
                MessageDialogHelper.ShowErrorDialog(this, "Cảnh Báo", "Không thể cập nhật thông tin !!!");
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtTimKiem, sb, "Vui lòng nhập tên chức vụ cần tìm !!!");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            txtTimKiem.requestFocus();
            return;
        }
        String ten = txtTimKiem.getText().trim();
        try {
            ChucVuControll cvControll = new ChucVuControll();
            List<ChucVu> list = cvControll.findByName(ten);
            if (list.size() > 0) {
                tbModel.setRowCount(0);
                list.forEach((item) -> {
                    tbModel.addRow(new Object[]{
                        item.getMaChucVu(),
                        item.getTenChucVu(),});
                });
                tbModel.fireTableDataChanged();
                ressetText();
            } else {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Không tìm thấy chức vụ: " + txtTimKiem.getText() + " có tên trong danh sách!!!");
                loadDataToTable();
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(frmChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmChucVu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblChucVu;
    private javax.swing.JTextField txtMaCV;
    private javax.swing.JTextField txtTenCV;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
