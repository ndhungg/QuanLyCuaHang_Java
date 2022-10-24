
import controll.NhanVienControll;
import helper.DataValidator;
import helper.MessageDialogHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.ChucVu;
import model.NhanVien;

public class frmNhanVien extends javax.swing.JFrame {

    private DefaultTableModel tbModel;
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public frmNhanVien() {
        initComponents();
        this.txtTenNV.requestFocus();
        initTable();
        loadDataToTable();
        loadDataToComBoBox();
    }

    public void resetText() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtDiaChi.setText("");
        txtDT.setText("");
    }

    private void initTable() {
        tbModel = new DefaultTableModel();
        tbModel.setColumnIdentifiers(new String[]{"Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ", "Giới Tính", "Địa Chỉ", "Số Điện Thoại", "Ngày Sinh"});
        tblNhanVien.setModel(tbModel);
        TableColumnModel columnModel = tblNhanVien.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(150);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
    }

    private void loadDataToTable() {
        try {
            NhanVienControll nhanVienControll = new NhanVienControll();
            List<NhanVien> list = nhanVienControll.findAll();
            tbModel.setRowCount(0);
            list.forEach((item) -> {
                tbModel.addRow(new Object[]{
                    item.getMaNhanVien(),
                    item.getTenNhanVien(),
                    item.getMaChucVu(),
                    item.getGioiTinh() == 1 ? "Nam" : "Nữ",
                    item.getDiaChi(),
                    item.getSoDienThoai(),
                    item.getNgaySinh(),});
            });
            tbModel.fireTableDataChanged();
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public void loadDataToComBoBox() {
        try {
            NhanVienControll nhanVienControll = new NhanVienControll();
            List<ChucVu> list = nhanVienControll.getByNameCBB();
            DefaultComboBoxModel conBoxModel = new DefaultComboBoxModel();
            list.forEach((item) -> {
                conBoxModel.addElement(item.getTenChucVu());
            });
            cbbChucVu.setModel(conBoxModel);
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbNam = new javax.swing.JRadioButton();
        rbNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        btnKhongLuu = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Danh Mục Nhân Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Mã Nhân Viên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Tên Nhân Viên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Địa Chỉ:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Điện Thoại");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Ngày Sinh: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Giới Tính:");

        rbNam.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rbNam.setText("Nam");

        rbNu.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rbNu.setText("Nữ");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vu", "Giới Tính", "Địa Chỉ", "Số Điện Thoại", "Ngày Sinh"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblNhanVien.getColumnModel().getColumn(3).setPreferredWidth(40);
            tblNhanVien.getColumnModel().getColumn(4).setPreferredWidth(140);
            tblNhanVien.getColumnModel().getColumn(5).setPreferredWidth(120);
            tblNhanVien.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\DoAnJava\\QuanLyCuaHang\\src\\HinhAnh\\icons8-add-32.png")); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
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

        btnSua.setBackground(new java.awt.Color(255, 255, 255));
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

        jLabel8.setText("Chức Vụ");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        btnKhongLuu.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnKhongLuu.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\DoAnJava\\QuanLyCuaHang\\src\\HinhAnh\\icons8-cancel-32 (1).png")); // NOI18N
        btnKhongLuu.setText("Không Lưu");
        btnKhongLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongLuuActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\DoAnJava\\QuanLyCuaHang\\src\\HinhAnh\\icons8-add-32.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(75, 75, 75)
                        .addComponent(btnXoa)
                        .addGap(75, 75, 75)
                        .addComponent(btnSua)
                        .addGap(75, 75, 75)
                        .addComponent(btnLuu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKhongLuu)
                        .addGap(75, 75, 75)
                        .addComponent(btnThoat))
                    .addComponent(jScrollPane1))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(30, 30, 30)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addGap(59, 59, 59)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rbNam)
                                    .addGap(57, 57, 57)
                                    .addComponent(rbNu))
                                .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDT)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(rbNam)
                                .addComponent(rbNu)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addGap(20, 20, 20)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoa)
                        .addComponent(btnSua)
                        .addComponent(btnLuu)
                        .addComponent(btnThem))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThoat)
                        .addComponent(btnKhongLuu)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
       
        String ten = txtTimKiem.getText();
        try {
             NhanVienControll nhanVienControll = new NhanVienControll();
            List<NhanVien> list = nhanVienControll.findKH_ByName(ten);
            if (list != null) {
                tbModel.setRowCount(0);
                list.forEach((item) -> {
                    tbModel.addRow(new Object[]{
                        item.getMaNhanVien(),
                        item.getTenNhanVien(),
                        item.getMaChucVu(),
                        item.getGioiTinh() == 1 ? "Nam" : "Nữ",
                        item.getDiaChi(),
                        item.getSoDienThoai(),
                        item.getNgaySinh(),});
                });
                tbModel.fireTableDataChanged();
                resetText();
            } else if (list == null) {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Không tìm thấy Nhân viên có tên trong danh sách!!!");
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtMaNV, sb, "Mã nhân viên không được để trống !!!!");
        DataValidator.ValidatorEmpty(txtTenNV, sb, "Tên nhân viên không được để trống !!!!");
        DataValidator.ValidatorEmpty(txtDiaChi, sb, "Địa chỉ nhân viên không được để trống !!!!");
        DataValidator.ValidatorEmpty(txtDT, sb, "Điện thoại nhân viên không được để trống !!!!");

        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
        }
        try {
            NhanVien nv = new NhanVien();
            NhanVienControll nvControll = new NhanVienControll();
            nv.setMaNhanVien(txtMaNV.getText());
            nv.setTenNhanVien(txtTenNV.getText());
            String layMaChucVuTheoTen = nvControll.layMaChucVuTheoTen(cbbChucVu.getSelectedItem().toString());
            String date = sdf.format(dateChooser.getDate());
            nv.setMaChucVu(layMaChucVuTheoTen);
            nv.setGioiTinh(rbNam.isSelected() ? 1 : 0);
            nv.setDiaChi(txtDiaChi.getText());
            nv.setSoDienThoai(txtDT.getText());
            nv.setNgaySinh(date);
            if (nvControll.insert(nv)) {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Thêm mới nhân viên thành công !!!");
                loadDataToTable();
                resetText();
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", "Nhân viên có mã : " + txtMaNV.getText() + " đã tồn tạit trong danh sách !!!");
            System.out.println(e.getMessage());
            txtMaNV.setText("");
            txtMaNV.requestFocus();
        }

    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnKhongLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongLuuActionPerformed
        resetText();
    }//GEN-LAST:event_btnKhongLuuActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        txtMaNV.requestFocus();
        resetText();
        loadDataToTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int row = tblNhanVien.getSelectedRow();
        try {
            if (row >= 0) {
                String sex = "Nam";
                txtMaNV.setText(tblNhanVien.getValueAt(row, 0).toString());
                txtTenNV.setText(tblNhanVien.getValueAt(row, 1).toString());
                cbbChucVu.getModel().setSelectedItem(tblNhanVien.getValueAt(row, 2));
                if (sex.equals(tblNhanVien.getValueAt(row, 3).toString())) {
                    rbNam.setSelected(true);
                    rbNu.setSelected(false);
                } else {
                    rbNu.setSelected(true);
                    rbNam.setSelected(false);
                }
                txtDiaChi.setText(tblNhanVien.getValueAt(row, 4).toString());
                txtDT.setText(tblNhanVien.getValueAt(row, 5).toString());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) tblNhanVien.getValueAt(row, 6));
                dateChooser.setDate(date);
            }
        } catch (ParseException e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
            System.out.println(e.getMessage());
        }


    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblNhanVien.getSelectedRow();
        if (row >= 0) {
            if (txtMaNV.getText().equals("")) {
                MessageDialogHelper.ShowErrorDialog(this, "Lỗi", "Lỗi khi xóa nhân viên: " + txtTenNV.getText());
            } else {
                if (MessageDialogHelper.ShowConfirmDialog(this, "Thông báo", "Bạn có muốn xóa thông tin nhân viên: " + txtTenNV.getText() + " ?") == JOptionPane.NO_OPTION) {
                    resetText();
                    return;
                }
                try {
                    NhanVienControll nccControll = new NhanVienControll();
                    if (nccControll.delete(txtMaNV.getText())) {
                        MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Xóa nhân viên: " + txtTenNV.getText() + " thành công");
                        resetText();
                        loadDataToTable();
                    }
                } catch (Exception e) {
                    MessageDialogHelper.ShowErrorDialog(this, "Lỗi", "Lỗi khi xóa nhân viên có tên : " + txtTenNV.getText());
                }
            }
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        StringBuffer sb = new StringBuffer();
        DataValidator.ValidatorEmpty(txtMaNV, sb, "Mã nhân viên không được để trống !!!");
        DataValidator.ValidatorEmpty(txtTenNV, sb, "Tên nhân viên không được để trống !!!");
        DataValidator.ValidatorEmpty(txtDiaChi, sb, "Địa chỉ nhân viên không được để trống !!!");
        DataValidator.ValidatorNumberPhone(txtDT, sb, "Số điện thoại nhân viên không được để trống !!!");
        DataValidator.ValidatorNumberPhone(txtDT, sb, "Số điện thoại chưa đúng, vui lòng kiểm tra lại (10 <= SĐT <= 11)");
        if (sb.length() > 0) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", sb.toString());
            txtMaNV.requestFocus();
            return;
        }
        if (MessageDialogHelper.ShowConfirmDialog(this, "Hỏi", "Bạn có muốn cập nhật thông tin nhân viên ?") == JOptionPane.NO_OPTION) {
            resetText();
            txtTimKiem.setText("");
            return;
        }
        try {
            NhanVien nv = new NhanVien();
            NhanVienControll nhanVienControll = new NhanVienControll();
            String maCV = nhanVienControll.layMaChucVuTheoTen(cbbChucVu.getSelectedItem().toString());

            nv.setMaNhanVien(txtMaNV.getText());
            nv.setTenNhanVien(txtTenNV.getText());
            nv.setMaChucVu(maCV);
            nv.setGioiTinh(rbNam.isSelected() ? 1 : 0);
            nv.setDiaChi(txtDiaChi.getText());
            nv.setSoDienThoai(txtDT.getText());

            String date = sdf.format(dateChooser.getDate());
            nv.setNgaySinh(date);
            if (nhanVienControll.update(nv)) {
                MessageDialogHelper.ShowMessageDialog(this, "Thông báo", "Cập nhật thông tin nhân viên: " + txtTenNV.getText() + " thành công.");
                loadDataToTable();
                resetText();
                txtTimKiem.setText("");
            } else {
                MessageDialogHelper.ShowErrorDialog(this, "Cảnh Báo", "Không thể cập nhật thông tin nhân viên !!!" + txtTenNV.getText());
            }
        } catch (Exception e) {
            MessageDialogHelper.ShowErrorDialog(this, "Lỗi", e.getMessage());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKhongLuu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbChucVu;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDT;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
