import controll.KhachHangControll;
import helper.DataValidator;
import helper.MessageDialogHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.KhachHang;

public class frmKhachHang extends javax.swing.JFrame {

    private DefaultTableModel tbModel;

    public frmKhachHang() throws Exception {
        initComponents();
        txtMaKH.setEnabled(false);
        txtTenKH.requestFocus();
        initTable();
        loadDataToTable();
    }

    private void initTable() {
        tbModel = new DefaultTableModel();
        tbModel.setColumnIdentifiers(new String[]{"Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "SĐT", "Giới Tính"});
        tblKhachHang.setModel(tbModel);
        TableColumnModel columnModel = tblKhachHang.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(120);
        columnModel.getColumn(4).setPreferredWidth(40);
    }

    public void resetText() {
        this.txtMaKH.setText("");
        this.txtTenKH.setText("");
        this.txtDiaChi.setText("");
        this.txtDT.setText("");
        this.txtMaKH.requestFocus();
    }

    private void loadDataToTable() {
        try {
            KhachHangControll khachHangControll = new KhachHangControll();
            List<KhachHang> list = khachHangControll.findAll();
            tbModel.setRowCount(0);
            list.forEach((item) -> {
                tbModel.addRow(new Object[]{
                    item.getMaKhachHang(), item.getTenKhachHang(), item.getDiaChi(),
                    item.getSoDienThoai(), item.getGioiTinh() == 1 ? "Nam" : "Nữ"
                });
            });
            tbModel.fireTableDataChanged();
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rbNam = new javax.swing.JRadioButton();
        rbNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Danh Mục Khách Hàng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Mã Khách Hàng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Tên Khách Hàng:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Địa Chỉ:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Điện Thoại");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Giới Tính:");

        rbNam.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rbNam.setText("Nam");

        rbNu.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rbNu.setText("Nữ");

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại", "Giới Tính"
            }
        ));
        tblKhachHang.setMaximumSize(new java.awt.Dimension(1000, 0));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblKhachHang.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblKhachHang.getColumnModel().getColumn(2).setPreferredWidth(140);
            tblKhachHang.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblKhachHang.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\DoAnJava\\QuanLyCuaHang\\src\\HinhAnh\\icons8-add-32.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\DoAnJava\\QuanLyCuaHang\\src\\HinhAnh\\icons8-delete-32.png")); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\DoAnJava\\QuanLyCuaHang\\src\\HinhAnh\\icons8-update-32.png")); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\DoAnJava\\QuanLyCuaHang\\src\\HinhAnh\\icons8-save-32.png")); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\DoAnJava\\QuanLyCuaHang\\src\\HinhAnh\\icons8-exit-32.png")); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Tìm Kiếm");

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\DoAnJava\\QuanLyCuaHang\\src\\HinhAnh\\icons8-search-32.png")); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(55, 55, 55)
                        .addComponent(btnXoa)
                        .addGap(55, 55, 55)
                        .addComponent(btnSua)
                        .addGap(55, 55, 55)
                        .addComponent(btnLuu)
                        .addGap(55, 55, 55)
                        .addComponent(btnTimKiem)
                        .addGap(55, 55, 55)
                        .addComponent(btnThoat))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbNam)
                                .addGap(54, 54, 54)
                                .addComponent(rbNu))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaKH)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDT)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                            .addComponent(txtTimKiem))))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbNam)
                                .addComponent(rbNu)
                                .addComponent(jLabel6))
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addComponent(btnLuu)
                        .addComponent(btnTimKiem))
                    .addComponent(btnThoat, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        resetText();
        txtTimKiem.setText("");
        txtMaKH.setEnabled(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtMaKH, sb, "Mã khách hàng không được để trống !!!");
        DataValidator.ValidatorEmpty(txtTenKH, sb, "Tên khách hàng không được để trống !!!");
        DataValidator.ValidatorEmpty(txtDiaChi, sb, "Địa chỉ khách hàng không được để trống !!!");
        DataValidator.ValidatorEmpty(txtDT, sb, "Số điện thoại khách hàng không được để trống !!!");
        DataValidator.ValidatorNumberPhone(txtDT, sb, "Số điện thoại chưa đúng, vui lòng kiểm tra lại (10 <= SĐT <= 11)");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            return;
        }
        txtMaKH.requestFocus();
        try {
            KhachHang kh = new KhachHang();
            kh.setMaKhachHang(txtMaKH.getText());
            kh.setTenKhachHang(txtTenKH.getText());
            kh.setGioiTinh(rbNam.isSelected() ? 1 : 0);
            kh.setDiaChi(txtDiaChi.getText());
            kh.setSoDienThoai(txtDT.getText());
            KhachHangControll khachHangControll = new KhachHangControll();
            if (khachHangControll.Insert(kh)) {
                MessageDialogHelper.ShowMessageDialog(null, "Khách Hàng đã được lưu thành công", "Thông báo");
                loadDataToTable();
                resetText();
                txtTimKiem.setText("");
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", "Khách hàng có mã: " + txtMaKH.getText() + " đã tồn tại, Vui lòng nhập lại Mã khách hàng mới !!!");
            txtMaKH.setText("");
            txtMaKH.setEnabled(true);
            txtMaKH.requestFocus();
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtMaKH, sb, "Mã khách hàng không được để trống !!!");
        DataValidator.ValidatorEmpty(txtTenKH, sb, "Tên khách hàng không được để trống !!!");
        DataValidator.ValidatorEmpty(txtDiaChi, sb, "Địa chỉ khách hàng không được để trống !!!");
        DataValidator.ValidatorNumberPhone(txtDT, sb, "Số điện thoại khách hàng không được để trống !!!");
        DataValidator.ValidatorNumberPhone(txtDT, sb, "Số điện thoại chưa đúng, vui lòng kiểm tra lại (10 <= SĐT <= 11)");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            return;
        }
        if (MessageDialogHelper.ShowConfirmDialog(this, "Hỏi", "Bạn có muốn cập nhật thông tin khách hàng ?") == JOptionPane.NO_OPTION) {
            resetText();
            txtTimKiem.setText("");
            return;
        }
        try {
            KhachHang kh = new KhachHang();
            kh.setMaKhachHang(txtMaKH.getText());
            kh.setTenKhachHang(txtTenKH.getText());
            kh.setDiaChi(txtDiaChi.getText());
            kh.setSoDienThoai(txtDT.getText());
            kh.setGioiTinh(rbNam.isSelected() ? 1 : 0);
            KhachHangControll khachHangControll = new KhachHangControll();
            if (khachHangControll.update(kh)) {
                MessageDialogHelper.ShowMessageDialog(this, "Cập nhật thông tin khách hàng thành công.", "Thông báo");
                loadDataToTable();
                resetText();
                txtTimKiem.setText("");
            } else {
                MessageDialogHelper.ShowErrorDialog(this, "Không thể cập nhật thông tin khách hàng !!!", "Cảnh báo");
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        try {
            txtMaKH.setEnabled(false);
            int row = tblKhachHang.getSelectedRow();
            if (row >= 0) {
                String id = (String) tblKhachHang.getValueAt(row, 0);
                KhachHangControll khachHangControll = new KhachHangControll();
                KhachHang kh = khachHangControll.findId(id);
                if (kh != null) {
                    txtMaKH.setText(kh.getMaKhachHang());
                    txtTenKH.setText(kh.getTenKhachHang());
                    txtDiaChi.setText(kh.getDiaChi());
                    txtDT.setText(kh.getSoDienThoai());
                    if (kh.getGioiTinh() == 1) {
                        rbNam.setSelected(true);
                        rbNu.setSelected(false);
                    } else if (kh.getGioiTinh() == 0) {
                        rbNu.setSelected(true);
                        rbNam.setSelected(false);
                    }
                }
            } else {
                MessageDialogHelper.ShowErrorDialog(this, "Lỗi", "Bạn chưa chọn vào dữ liệu trong bảng khách hàng !!!");
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtTimKiem, sb, "Vui lòng nhập tên khách hàng cần tìm !!!");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            txtTimKiem.requestFocus();
            return;
        }
        String ten = txtTimKiem.getText();
        try {
            KhachHangControll khachHangControll = new KhachHangControll();
            List<KhachHang> list = khachHangControll.findKH_ByName(ten);
            if (list != null) {
                tbModel.setRowCount(0);
                list.forEach((item) -> {
                    tbModel.addRow(new Object[]{
                        item.getMaKhachHang(),
                        item.getTenKhachHang(),
                        item.getDiaChi(),
                        item.getGioiTinh(),
                        item.getGioiTinh() == 1 ? "Nam" : "Nữ",});
                });
                tbModel.fireTableDataChanged();
                resetText();
            } else if (list == null) {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Không tìm thấy khách hàng có tên trong danh sách!!!");
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblKhachHang.getSelectedRow();
        if (row >= 0) {
            if (MessageDialogHelper.ShowConfirmDialog(this, "Hỏi", "Bạn có muốn xóa thông tin khách hàng") == JOptionPane.NO_OPTION) {
                return;
            }
            try {
                KhachHangControll khachHangControll = new KhachHangControll();
                if (khachHangControll.delete(txtMaKH.getText())) {
                    MessageDialogHelper.ShowMessageDialog(this, "Xóa thông tin khách hàng thành công !!!", "Thông báo");
                    loadDataToTable();
                    resetText();
                    txtTimKiem.setText("");
                } else {
                    MessageDialogHelper.ShowErrorDialog(this, "Cảnh báo", "Xóa thất bại");
                }
            } catch (Exception e) {
                MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
            }
        } else {
            MessageDialogHelper.ShowMessageDialog(this, "Vui lòng lựa chọn khách hàng bạn muốn xóa !!!", "Thông báo");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(frmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmKhachHang().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDT;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
