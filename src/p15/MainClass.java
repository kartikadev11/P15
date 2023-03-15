package p15;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainClass extends javax.swing.JFrame {
    
    int MhsID;
    Mahasiswa mahasiswa;

    public MainClass() {
        initComponents();
        
        ViewDataMahasiswa(""); 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Olah Data Mahasiswa");

        jPanel1.setPreferredSize(new java.awt.Dimension(626, 50));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
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
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        TambahMahasiswa TM = new TambahMahasiswa(this, true);
        TM.setVisible(true); 
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        String key = txtCari.getText();
        String where = " WHERE "
                + "nim LIKE '%"+key+"%' OR "
                + "nama LIKE '%"+key+"%' OR "
                + "angkatan LIKE '%"+key+"%' OR "
                + " LIKE '%"+key+"%' OR "
                + "semester LIKE '%"+key+"%'";
        ViewDataMahasiswa(where); 
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        HapusData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        int index = tblData.getSelectedRow();
        if(index != -1){
            String id = tblData.getValueAt(index, 0).toString();
            int TheID = Integer.parseInt(id);
            MhsID = TheID;
            
            String nim = tblData.getValueAt(index, 1).toString();
            String nama = tblData.getValueAt(index, 2).toString();
            String angkatan = tblData.getValueAt(index, 3).toString();
            String kelas = tblData.getValueAt(index, 4).toString();
            String semester = tblData.getValueAt(index, 5).toString();
            String dosenWali = tblData.getValueAt(index, 6).toString();
            mahasiswa = new Mahasiswa();
            mahasiswa.setId(id);
            mahasiswa.setNim(nim); 
            mahasiswa.setNama(nama); 
            mahasiswa.setAngkatan(angkatan); 
            mahasiswa.setKelas(kelas); 
            mahasiswa.setSemester(semester); 
            mahasiswa.setDosenWali(dosenWali); 
            
        }
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        EditData();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariActionPerformed

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
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainClass().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblData;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables

    public static void ViewDataMahasiswa(String where){
        Object[] kolom = {"ID","NIM","NAMA","ANGKATAN","KELAS","SEMESTER","DOSEN WALI"};
        DefaultTableModel model = new DefaultTableModel(null, kolom);
        tblData.setModel(model); 
        
        //ambil data dari database
        
        try {
            Connection c = Koneksi.sambungkeDB();
            Statement st = c.createStatement();
            String sql = "SELECT * FROM mahasiswa "+where;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            //dan tambahkan data ke dalam tabel
            while (rs.next()) {                 
                int id = rs.getInt("id");
                int nim = rs.getInt("nim");
                String nama = rs.getString("nama");
                int angkatan = rs.getInt("angkatan");
                String kelas = rs.getString("kelas");
                int semester = rs.getInt("semester");
                int dosenWali = rs.getInt("dosen_wali");
                Object[] data = {id, nim,nama,angkatan,kelas,semester,dosenWali};
                model.addRow(data); 
            }
        } catch (SQLException e) {
        }
    }

    private void HapusData() {
        if(MhsID > 0){
            try {
                Object[] tombol = {"YA", "Tidak"};
                int option = JOptionPane.showOptionDialog(this, 
                        "Apakah anda ingin menghapus data?", 
                        "Konfirmasi", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.INFORMATION_MESSAGE, null, tombol, 0);
                if(option == 0){
                    //YA
                    //YES
                    Connection c = Koneksi.sambungkeDB();
                    Statement st = c.createStatement();
                    String sql = "DELETE FROM mahasiswa WHERE id='"+MhsID+"'";
                    //eksekusi query
                    st.executeUpdate(sql);
                    //refresh view table
                    ViewDataMahasiswa(""); 
                    JOptionPane.showMessageDialog(this, "Data telah dihapus");
                }                
            } catch (HeadlessException | SQLException e) {
            }
        }else {
            JOptionPane.showMessageDialog(this, "Anda belum memilih Data"); 
        }
    }

    private void EditData() {
        if(MhsID > 0){
            EditMahasiswa edit = new EditMahasiswa(this, true);
            edit.mhs = mahasiswa;
            edit.setVisible(true); 
        }
    }

}
