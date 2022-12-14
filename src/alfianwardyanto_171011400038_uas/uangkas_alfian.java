package alfianwardyanto_171011400038_uas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wardyanto
 */
public class uangkas_alfian extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection cn = koneksi.getKoneksi();
    public ResultSet rsl;
    public DefaultTableModel tabdata;
    public DefaultTableModel tabdatal;

    /**
     * Creates new form uangkas_alfian
     */
    public uangkas_alfian() {
        initComponents();
        judul();
        reset();
        date();
        tampilData();
        jTextField1.setEnabled(false);
        nis_alfian.setEnabled(false);
        nama_alfian.setEnabled(false);
        uangkass_alfian.setText("1000");
        uangkass_alfian.setEnabled(false);
        bayar_alfian.setText("");
        kembalian_alfian.setEnabled(false);
        
        //rata kiri kanan
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 3);
    }
    
    public void tampilData()    {
        try{
            st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("select * from tb_siswa where ket='belum'");
            while (rs.next()){
                Object[] data = {
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("jkelamin"),
                };
                tabModel.addRow(data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public void bayar(){
        int a = Integer.parseInt(uangkass_alfian.getText());
        int b = Integer.parseInt(bayar_alfian.getText());
        int c;
        c = b - a;
        
        kembalian_alfian.setText(String.valueOf(c));
    }
     
     public void reset(){
        nis_alfian.setText("");
        nama_alfian.setText("");
        bayar_alfian.setText("");
        kembalian_alfian.setText("");
    }
     
     public void judul(){
        Object[] judul = {"NIS","Nama","J. Kelamin"};
        tabModel = new DefaultTableModel(null, judul);
        tabel.setModel(tabModel);
    }
     
     public class Tanggal{
        private String getTanggal(){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
        }
        
        public void main(String [] Args){
            Tanggal tgl = new Tanggal();
            System.out.println("Tanggal dan waktu sekarang : "+tgl.getTanggal());
        }
    }
     
     public String tgl(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public void date(){
        Date a = new Date();
        SimpleDateFormat af = new SimpleDateFormat("dd-MM-yyyy");
        jTextField1.setText(af.format(a));
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
        nis_alfian = new javax.swing.JTextField();
        nama_alfian = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        uangkass_alfian = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bayar_alfian = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        kembalian_alfian = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        bbayar_alfian = new javax.swing.JButton();
        lihat_alfian = new javax.swing.JButton();
        reset_alfian = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NIS");

        jLabel2.setText("NAMA");

        nis_alfian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nis_alfianKeyTyped(evt);
            }
        });

        jLabel3.setText("UANG KAS");

        uangkass_alfian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uangkass_alfianActionPerformed(evt);
            }
        });
        uangkass_alfian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uangkass_alfianKeyTyped(evt);
            }
        });

        jLabel4.setText("MEMBAYAR");

        bayar_alfian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayar_alfianKeyReleased(evt);
            }
        });

        jLabel5.setText("KEMBALIAN");

        kembalian_alfian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kembalian_alfianKeyReleased(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        bbayar_alfian.setText("BAYAR");
        bbayar_alfian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbayar_alfianActionPerformed(evt);
            }
        });

        lihat_alfian.setText("LIHAT PEMBAYARAN");
        lihat_alfian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihat_alfianActionPerformed(evt);
            }
        });

        reset_alfian.setText("RESET");
        reset_alfian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_alfianActionPerformed(evt);
            }
        });

        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("TANGGAL");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("UANG KAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reset_alfian)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bbayar_alfian)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lihat_alfian)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(kembalian_alfian, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bayar_alfian))
                                .addGap(32, 32, 32))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nis_alfian, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nama_alfian, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(uangkass_alfian, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nis_alfian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nama_alfian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(bayar_alfian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(kembalian_alfian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(uangkass_alfian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bbayar_alfian)
                    .addComponent(lihat_alfian)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(reset_alfian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        nis_alfian.setText(tabModel.getValueAt(tabel.getSelectedRow(), 0) + "");
        nama_alfian.setText(tabModel.getValueAt(tabel.getSelectedRow(), 1) + "");
        jTextField1.setText(tabModel.getValueAt(tabel.getSelectedRow(), 5) + "");

        reset_alfian.setEnabled(true);
        nis_alfian.setEnabled(false);
    }//GEN-LAST:event_tabelMouseClicked

    private void reset_alfianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_alfianActionPerformed
        // TODO add your handling code here:
        try{
                st = cn.createStatement();
                st.executeUpdate("update tb_siswa set ket='belum'");
                JOptionPane.showMessageDialog(null, "Data direset!");
                reset();
                
                tampilData();
            }catch(Exception e){
                e.printStackTrace();
            }
    }//GEN-LAST:event_reset_alfianActionPerformed

    private void bbayar_alfianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbayar_alfianActionPerformed
        // TODO add your handling code here:
        if(nis_alfian.getText().equals("") || nama_alfian.getText().equals("") || bayar_alfian.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data!");
        }else{
            try{
                st = cn.createStatement();
                st.executeUpdate("insert into tb_uangkas set nis='" + nis_alfian.getText()+ "', nama='" +nama_alfian.getText()+  "', membayar='" +bayar_alfian.getText()+ "', kembalian='" +kembalian_alfian.getText() + "'," + "tgl='"+ jTextField1.getText()+ "'");
                st.executeUpdate("update tb_siswa set ket='sudah' where nis='"+nis_alfian.getText()+"'");
                JOptionPane.showMessageDialog(null, "Pembayaran Berhasil");
                reset();
                tampilData();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_bbayar_alfianActionPerformed

    private void uangkass_alfianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uangkass_alfianKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_uangkass_alfianKeyTyped

    private void nis_alfianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nis_alfianKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_nis_alfianKeyTyped

    private void kembalian_alfianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kembalian_alfianKeyReleased
        // TODO add your handling code here:
        bayar();
    }//GEN-LAST:event_kembalian_alfianKeyReleased

    private void bayar_alfianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayar_alfianKeyReleased
        // TODO add your handling code here:
        bayar();
    }//GEN-LAST:event_bayar_alfianKeyReleased

    private void lihat_alfianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihat_alfianActionPerformed
        // TODO add your handling code here:
        new lihatbayaran_alfian().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lihat_alfianActionPerformed

    private void uangkass_alfianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uangkass_alfianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uangkass_alfianActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new home_alfian().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(uangkas_alfian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uangkas_alfian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uangkas_alfian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uangkas_alfian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uangkas_alfian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar_alfian;
    private javax.swing.JButton bbayar_alfian;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField kembalian_alfian;
    private javax.swing.JButton lihat_alfian;
    private javax.swing.JTextField nama_alfian;
    private javax.swing.JTextField nis_alfian;
    private javax.swing.JButton reset_alfian;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField uangkass_alfian;
    // End of variables declaration//GEN-END:variables
}
