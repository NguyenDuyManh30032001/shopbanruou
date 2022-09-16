/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HienThi;

import DATABASE.ThongTin;
import DATABASE.daoCTHOADON;
import DoiTuong.CTHOADON;
import DoiTuong.Ruou;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kero
 */
public class bangCTHOADON extends javax.swing.JFrame {
    
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Vector Data = new Vector();
    Vector title = new Vector();
    Vector tableData = new Vector();
    Vector tableTittle = new Vector();
    DefaultTableModel TblModel;
    
    public ArrayList<Ruou> DSR = ThongTin.getDSR();
    public ArrayList<CTHOADON> dsb = daoCTHOADON.getDSB();
    public bangCTHOADON() {
        initComponents();
         Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) (dimension.getHeight() - this.getHeight() +50);
        this.setLocation(x, y);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            txt_maruou.setEnabled(false);
        txt_thanhtien.setEnabled(false);
        bt_xoa.setEnabled(false);
        bt_sua.setEnabled(false);
        dattieude();
        hienthidulieu();
        DatTenTieuDe();
        HienDuLieuLen();
    }
    
    public void dattieude(){
        title.add("Mã Hóa Đơn");
        title.add("Mã Rượu");
        title.add("Số lượng");
        title.add("Thành tiền");
        
    }
    public void hienthidulieu(){
        Data.removeAllElements();
        for(CTHOADON b : dsb){
            Vector v = new Vector();
            v.add(b.getMahd());
            v.add(b.getMaruou());
            v.add(b.getSoluong());
            v.add(b.getThanhtien());
            Data.add(v);
            tblban.setModel(new DefaultTableModel(Data, title));
        }
        
    }
    public void DatTenTieuDe()
    {
        tableTittle.add("Mã rượu");
        tableTittle.add("Tên rượu");
        tableTittle.add("Xuất xứ");
        tableTittle.add("Nồng độ");
        tableTittle.add("Thể tích");
        tableTittle.add("Giá bán");
        tableTittle.add("Mã loại");
        
    }
    public void HienDuLieuLen()
    {
        tableData.removeAllElements();
        for(Ruou a : DSR)
        {
            Vector v = new Vector();
            v.add(a.getMaruou());
            v.add(a.getTenruou());
            v.add(a.getXuatxu());
            v.add(a.getNongdo());
            v.add(a.getThetich());
            v.add(a.getGiaban());
            v.add(a.getMal());
            tableData.add(v);
            tb_bangHD.setModel(new DefaultTableModel(tableData,tableTittle));
        }
    }
    public void LayDuLieu(ArrayList<Ruou> ds)
    {
        tableData.removeAllElements();
        for(Ruou a : ds)
        {
            Vector v = new Vector();
            v.add(a.getMaruou());
            v.add(a.getTenruou());
            v.add(a.getXuatxu());
            v.add(a.getNongdo());
            v.add(a.getThetich());
            v.add(a.getGiaban());
            v.add(a.getMal());
            tableData.add(v);
            tb_bangHD.setModel(new DefaultTableModel(tableData,tableTittle));
        }
    }
    public Boolean KiemTra(){
        if(txt_mahd.getText().equals("") || txt_maruou.getText().equals("") || txt_soluong.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Không để trống", "Thông báo", 2);
            return false;
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblban = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_mahd = new javax.swing.JTextField();
        txt_maruou = new javax.swing.JTextField();
        txt_soluong = new javax.swing.JTextField();
        txt_thanhtien = new javax.swing.JTextField();
        bt_them = new javax.swing.JButton();
        bt_xoa = new javax.swing.JButton();
        bt_sua = new javax.swing.JButton();
        bt_lammoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_bangHD = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        dropdown1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        bt_tim = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("CHI TIẾT HÓA ĐƠN");

        tblban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblban);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Mã Hóa Đơn:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("Mã Rượu:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Số lượng:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setText("Thành Tiền:");

        txt_soluong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_soluongKeyTyped(evt);
            }
        });

        bt_them.setText("THÊM");
        bt_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_themActionPerformed(evt);
            }
        });

        bt_xoa.setText("XÓA");
        bt_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_xoaActionPerformed(evt);
            }
        });

        bt_sua.setText("SỬA");
        bt_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suaActionPerformed(evt);
            }
        });

        bt_lammoi.setText("LÀM MỚI");
        bt_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_lammoiActionPerformed(evt);
            }
        });

        tb_bangHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_bangHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_bangHD);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("BẢNG RƯỢU");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        dropdown1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Rượu", "Tên Rượu" }));

        jLabel7.setText("Tìm Kiếm Theo:");

        bt_tim.setText("Tìm");
        bt_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_timActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(276, 276, 276))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bt_them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_maruou, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(143, 143, 143)
                                        .addComponent(bt_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(124, 124, 124)
                                .addComponent(bt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dropdown1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(297, 297, 297))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_tim)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txt_maruou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_them)
                    .addComponent(bt_lammoi)
                    .addComponent(bt_xoa)
                    .addComponent(bt_sua))
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropdown1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_tim))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblbanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbanMouseClicked
        int i = tblban.getSelectedRow();
        String mahd = tblban.getValueAt(i, 0).toString().trim();
        String maruou = tblban.getValueAt(i, 1).toString().trim();
        String soluong = tblban.getValueAt(i, 2).toString().trim();
        String thanhtien = tblban.getValueAt(i, 3).toString().trim();
        txt_mahd.setText(mahd);
        txt_maruou.setText(maruou);
        txt_soluong.setText(soluong);
        txt_thanhtien.setText(thanhtien);
        bt_them.setEnabled(false);
        bt_xoa.setEnabled(true);
        bt_sua.setEnabled(true);
        txt_mahd.setEnabled(true);
    }//GEN-LAST:event_tblbanMouseClicked

    private void bt_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_themActionPerformed
        if(KiemTra()){
          if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm không?", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION)== JOptionPane.YES_OPTION)
            {
                String sql = "insert into CTHOADON(mahd, maruou, soluong) values ('"+txt_mahd.getText().trim()+"',N'" + txt_maruou.getText().trim()+ "', " + txt_soluong.getText()+ ")";
                int kq = daoCTHOADON.ThemXoaSua(sql);
                if(kq != -1)
                {
                    dsb = daoCTHOADON.getDSB();
                    hienthidulieu();
                }
                 else{
              JOptionPane.showMessageDialog(this, "Mã hóa đơn này chưa được tạo", "Thông báo", 2);
          }
            }
         
        }
    }//GEN-LAST:event_bt_themActionPerformed

    private void bt_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_xoaActionPerformed
        int i = tblban.getSelectedRow();
        
        if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION)== JOptionPane.YES_OPTION)
        {
            String sql = "delete from CTHOADON where mahd = '"+txt_mahd.getText().trim()+"', '"+txt_maruou.getText().trim()+"'";
            if(daoCTHOADON.ThemXoaSua(sql)!=-1)
            {
                dsb = daoCTHOADON.getDSB();
                hienthidulieu();
            }
            else
                JOptionPane.showMessageDialog(this, "Dữ liệu này đang được sử dụng không thể xóa", "Thông báo", 2);
        }
    }//GEN-LAST:event_bt_xoaActionPerformed

    private void bt_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_suaActionPerformed
        int cot = tblban.getSelectedRow();
        if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không?", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION)== JOptionPane.YES_OPTION)
        {
            String sql = "update CTHOADON set mahd = '"+txt_mahd.getText().trim()+"',maruou = '"+txt_maruou.getText().trim()+"', soluong = '"+txt_soluong.getText().trim()+"' where mahd = '"+txt_mahd.getText().trim()+"'";
            int kq = daoCTHOADON.ThemXoaSua(sql);
            if(kq != 1)
            {
                dsb = daoCTHOADON.getDSB();
                hienthidulieu();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Không thể sửa", "Thông báo", 2);
        }
    }//GEN-LAST:event_bt_suaActionPerformed

    private void bt_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_lammoiActionPerformed
        bt_them.setEnabled(true);
        bt_xoa.setEnabled(false);
        bt_sua.setEnabled(false);
        txt_mahd.setEnabled(true);
        txt_soluong.setEnabled(true);
        txt_thanhtien.setEnabled(true);
        txt_mahd.setText(" ");
        txt_maruou.setText(" ");
        txt_soluong.setText(" ");
        txt_thanhtien.setText(" ");
    }//GEN-LAST:event_bt_lammoiActionPerformed

    private void bt_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_timActionPerformed
        
        if(dropdown1.getSelectedItem().equals("Mã Rượu"))
        {
            ArrayList<Ruou> DS = new ArrayList<Ruou>();
            DS = daoCTHOADON.TimTheoMa(txt_timkiem.getText());
            LayDuLieu(DS);
            
        }

        if(dropdown1.getSelectedItem().equals("Tên Rượu"))
        {
            ArrayList<Ruou> DS = new ArrayList<Ruou>();
            
            DS = daoCTHOADON.TimTheoTen(txt_timkiem.getText());
            LayDuLieu(DS);
        }

    }//GEN-LAST:event_bt_timActionPerformed

    private void tb_bangHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangHDMouseClicked
        int i = tb_bangHD.getSelectedRow();
        String maruou = tb_bangHD.getValueAt(i, 0).toString().trim();
        txt_maruou.setText(maruou);
       
    }//GEN-LAST:event_tb_bangHDMouseClicked

    private void txt_soluongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_soluongKeyTyped
       char c= evt.getKeyChar();
       if(c < '0' || c > '9')
           evt.consume();
    }//GEN-LAST:event_txt_soluongKeyTyped

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(bangCTHOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bangCTHOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bangCTHOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bangCTHOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bangCTHOADON().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_lammoi;
    private javax.swing.JButton bt_sua;
    private javax.swing.JButton bt_them;
    private javax.swing.JButton bt_tim;
    private javax.swing.JButton bt_xoa;
    private javax.swing.JComboBox<String> dropdown1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_bangHD;
    private javax.swing.JTable tblban;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_maruou;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_thanhtien;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
