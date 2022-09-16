/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HienThi;

import DATABASE.ThongTin;
import DoiTuong.LoaiRuou;
import DoiTuong.Ruou;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class HienThiRuou extends javax.swing.JFrame {
    Vector tableData = new Vector();
    Vector tableTittle = new Vector();
    DefaultTableModel TblModel;
    
    public ArrayList<Ruou> DSR = ThongTin.getDSR();
    /**
     * Creates new form HienThiRuou
     */
    public HienThiRuou() {
        initComponents();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight() - 300) / 2);
        this.setLocation(x, y);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         bt_xoa.setEnabled(false);
        bt_sua.setEnabled(false);
        DatTenTieuDe();
        HienDuLieuLen();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_maruou = new javax.swing.JTextField();
        txt_tenruou = new javax.swing.JTextField();
        txt_xuatxu = new javax.swing.JTextField();
        txt_nongdo = new javax.swing.JTextField();
        thetich = new javax.swing.JTextField();
        txt_giaban = new javax.swing.JTextField();
        txt_maloai = new javax.swing.JTextField();
        bt_them = new javax.swing.JButton();
        bt_xoa = new javax.swing.JButton();
        bt_sua = new javax.swing.JButton();
        bt_thoat = new javax.swing.JButton();
        bt_lammoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bang = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Mã rượu");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Tên rượu");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Xuất xứ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Nồng độ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Thể tích");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Giá bán");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Mã rượu");

        txt_giaban.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_giabanKeyTyped(evt);
            }
        });

        bt_them.setText("Thêm");
        bt_them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt_themMousePressed(evt);
            }
        });

        bt_xoa.setText("Xóa");
        bt_xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt_xoaMousePressed(evt);
            }
        });

        bt_sua.setText("Sửa");
        bt_sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt_suaMousePressed(evt);
            }
        });

        bt_thoat.setText("Thoát");
        bt_thoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt_thoatMousePressed(evt);
            }
        });
        bt_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_thoatActionPerformed(evt);
            }
        });

        bt_lammoi.setText("Làm mới");
        bt_lammoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt_lammoiMousePressed(evt);
            }
        });

        tb_bang.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_bang);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("THÔNG TIN RƯỢU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bt_them, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(104, 104, 104)
                                    .addComponent(bt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txt_maloai, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_xuatxu, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tenruou, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(thetich, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_nongdo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_maruou, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_maruou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_tenruou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_xuatxu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_nongdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(thetich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_maloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_them, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangMouseClicked
        int i = tb_bang.getSelectedRow();
        String maruou = tb_bang.getValueAt(i, 0).toString().trim();
        String tenruou = tb_bang.getValueAt(i, 1).toString().trim();
        String xuatxu = tb_bang.getValueAt(i, 2).toString().trim();
        String nongdo = tb_bang.getValueAt(i, 3).toString().trim();
        String thetichh = tb_bang.getValueAt(i, 4).toString().trim();
        String gia = tb_bang.getValueAt(i, 5).toString().trim();
        String mal = tb_bang.getValueAt(i, 6).toString().trim();
        txt_maruou.setText(maruou);
        txt_tenruou.setText(tenruou);
        txt_xuatxu.setText(xuatxu);
        txt_nongdo.setText(nongdo);
        thetich.setText(thetichh);
        txt_giaban.setText(gia);
        txt_maloai.setText(mal);
        bt_them.setEnabled(false);
        bt_xoa.setEnabled(true);
        bt_sua.setEnabled(true);
        txt_maruou.setEnabled(false);
    }//GEN-LAST:event_tb_bangMouseClicked

    private void bt_themMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_themMousePressed
         if(KiemTra()){
        if(JOptionPane.showConfirmDialog(this, "Ban co chac muon them khong ?", "Thông báo", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            String sql = " insert into ruou(maruou,tenruou,xuatxu,nongdo,thetich,giaban,maloai) values ('"+txt_maruou.getText().trim()+"', N'"+txt_tenruou.getText().trim()+"'"
                    + ", N'"+txt_xuatxu.getText().trim()+"', N'"+txt_nongdo.getText().trim()+"', '"+thetich.getText().trim()+"', "+txt_giaban.getText().trim()+", '"+txt_maloai.getText().trim()+"')";
            int kq = ThongTin.ThemXoaSuaBan(sql);
            if(kq != -1)
            {
                DSR = ThongTin.getDSR();
                HienDuLieuLen();
            }
               else
        {
            JOptionPane.showMessageDialog(this, "Ma da ton tai","Thong bao", 2);
        }
        }
        
       }
    }//GEN-LAST:event_bt_themMousePressed

    private void bt_xoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_xoaMousePressed
        int Row = tb_bang.getSelectedRow();
       if(JOptionPane.showConfirmDialog(this, "Ban co chac muon xoa khong ?", "Thông báo", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            String sql = "delete from ruou where maruou = '"+txt_maruou.getText().trim()+"'";
            int kq = ThongTin.ThemXoaSuaBan(sql);
            if(kq != -1)
            {
                DSR = ThongTin.getDSR();
                HienDuLieuLen();
            }
            else
        {
            JOptionPane.showMessageDialog(this, "Khong the xoa","Thong bao", 2);
        }
                
        }
    }//GEN-LAST:event_bt_xoaMousePressed
    
    private void bt_suaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_suaMousePressed
        int Row = tb_bang.getSelectedRow();
       if(JOptionPane.showConfirmDialog(this, "Ban co chac muon sua khong ?", "Thông báo", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            }                                   
    String sql = "update ruou set tenruou = N'"+txt_tenruou.getText().trim()+"',xuatxu = N'"+txt_xuatxu.getText().trim()+"',nongdo = N'"+txt_nongdo.getText().trim()+"',"
                    + "thetich = '"+thetich.getText().trim()+"',giaban = "+txt_giaban.getText().trim()+" ,maloai = '"+txt_maloai.getText().trim()+"' where maruou = '"+txt_maruou.getText().trim()+"'";
            int kq = ThongTin.ThemXoaSuaBan(sql);
            if(kq != -1)
            {
                DSR = ThongTin.getDSR();
                HienDuLieuLen();
            }
             else
        {
            JOptionPane.showMessageDialog(this, "Khong the sua","Thong bao", 2);
        }
        
    }//GEN-LAST:event_bt_suaMousePressed

    private void bt_lammoiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_lammoiMousePressed
        txt_maruou.setText("");
        txt_tenruou.setText("");
        txt_xuatxu.setText("");
        txt_nongdo.setText("");
        thetich.setText("");
        txt_giaban.setText("");
        txt_maloai.setText("");
        bt_them.setEnabled(true);
       txt_maruou.enable(true);
       bt_xoa.setEnabled(false);
       bt_sua.setEnabled(false);
    }//GEN-LAST:event_bt_lammoiMousePressed

    private void bt_thoatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_thoatMousePressed
         // TODO add your handling code here:
        int tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát ?", "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (tl == JOptionPane.NO_OPTION) return;
        else {
            this.dispose();
        }
    }//GEN-LAST:event_bt_thoatMousePressed

    private void bt_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_thoatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_thoatActionPerformed

    private void txt_giabanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_giabanKeyTyped
        char c= evt.getKeyChar();
       if(c < '0' || c > '9')
           evt.consume();
    }//GEN-LAST:event_txt_giabanKeyTyped
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
            tb_bang.setModel(new DefaultTableModel(tableData,tableTittle));
        }
    }
    public Boolean KiemTra(){
        if(txt_maruou.getText().equals("") || txt_tenruou.getText().equals("") || txt_xuatxu.getText().equals("") || txt_nongdo.getText().equals("")
                 || thetich.getText().equals("") || txt_giaban.getText().equals("") || txt_maloai.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui long khong de trong","Thong bao", 2);
            return false;
        }
        return true;
    }
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
            java.util.logging.Logger.getLogger(HienThiRuou.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HienThiRuou.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HienThiRuou.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HienThiRuou.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HienThiRuou().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_lammoi;
    private javax.swing.JButton bt_sua;
    private javax.swing.JButton bt_them;
    private javax.swing.JButton bt_thoat;
    private javax.swing.JButton bt_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_bang;
    private javax.swing.JTextField thetich;
    private javax.swing.JTextField txt_giaban;
    private javax.swing.JTextField txt_maloai;
    private javax.swing.JTextField txt_maruou;
    private javax.swing.JTextField txt_nongdo;
    private javax.swing.JTextField txt_tenruou;
    private javax.swing.JTextField txt_xuatxu;
    // End of variables declaration//GEN-END:variables
}