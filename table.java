/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugaspraktikum;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cakkr
 */
public class table extends javax.swing.JFrame {

    private static int getSelectedRow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Creates new form table
     */
    public table() {
        initComponents();
        tampil();
 //Mengambil model data dari tabel dan menyimpannya dalam objek DefaultTableModel dataModel
 DefaultTableModel dataModel = (DefaultTableModel) tampil.getModel();
 //Mendapatkan jumlah baris yang ada dalam model data saat ini
 int rowCount = dataModel.getRowCount();
 while (rowCount > 0){
 //Menghapus baris terakhir dari model data
 dataModel.removeRow(rowCount - 1);
 //Memperbarui nilai rowCount setelah penghapusan baris terakhir
 rowCount = dataModel.getRowCount();
    }
    }
    public Connection conn;
    
    public void refresh() {
        new table().setVisible(true);
        this.setVisible(false);
    }


    
   public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/OOP_2218085?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(table.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(table.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(table.class.getName()).log(Level.SEVERE, null, es);
        }
    }
public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("nama");
        tabelhead.addColumn("nomor");
        tabelhead.addColumn("durasi");
        tabelhead.addColumn("mode");
        tabelhead.addColumn("jeniskamar");
        tabelhead.addColumn("harga");
        tabelhead.addColumn("ppn");
        tabelhead.addColumn("admin");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_tabel";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getString(8), });
            }
            tampil.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

    public void insert() {
        String nama = txtnama.getText();
        String tlp = txttlp.getText();
        String durasi = txtdurasi.getText();
       
       CLI boking = new CLI();
        boking.cetaknama(txtnama.getText() );
        boking.cetaknama(txttlp.getText());
        boking.durasi = Integer.parseInt(txtdurasi.getText());

        if(radionormal.isSelected()){
            boking.datajenis(radionormal.getText()+" 100000/jam");
            boking.harga = boking.durasi*10000;
        }
        else if(radiovip.isSelected()){
            boking.datajenis(radiovip.getText()+" 200000/jam");
            boking.harga = boking.durasi*200000;
        }
        else{
            boking.datajenis(radiovvip.getText()+" 300000/jam");
            boking.harga = boking.durasi*300000;
        }
        
        if(radiosingle.isSelected()){
            boking.datamode(radiosingle.getText());
            boking.harga = boking.harga+100000;
        }else{
            boking.datamode(radiodouble.getText());
            boking.harga = boking.harga+200000;
        }
        
        try {
            koneksi();
            Statement statement = conn.createStatement();
             statement.executeUpdate("INSERT INTO tb_tabel (nim, nama,jk, prodi, th_angkatan,alamat)"
                    + "VALUES('" + nama + "','" + tlp + "','" + durasi + "','"  + "')");
            statement.close();

            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Mahasiswa!" + "\n" );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }

    public void itempilih() {
         String tlp1 = null, nama1 = null, jk1 = null, prodi1 = null, ang1, alamat1;
        txtnama.setText(nama1);
        txttlp.setText(tlp1);
        txtdurasi.setText(prodi1);
         CLI boking = new CLI();
        boking.cetaknama(txtnama.getText() );
        boking.cetaknama(txttlp.getText());
        boking.durasi = Integer.parseInt(txtdurasi.getText());

        if(radionormal.isSelected()){
            boking.datajenis(radionormal.getText()+" 100000/jam");
            boking.harga = boking.durasi*10000;
        }
        else if(radiovip.isSelected()){
            boking.datajenis(radiovip.getText()+" 200000/jam");
            boking.harga = boking.durasi*200000;
        }
        else{
            boking.datajenis(radiovvip.getText()+" 300000/jam");
            boking.harga = boking.durasi*300000;
        }
        
        if(radiosingle.isSelected()){
            boking.datamode(radiosingle.getText());
            boking.harga = boking.harga+100000;
        }else{
            boking.datamode(radiodouble.getText());
            boking.harga = boking.harga+200000;
        }
        if (jk1.equalsIgnoreCase("L")) {
            laki.setSelected(true);
        } else {
            perempuan.setSelected(true);

        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        radiovip = new javax.swing.JRadioButton();
        txtnama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnbo = new javax.swing.JButton();
        radiovvip = new javax.swing.JRadioButton();
        txttlp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tampil = new javax.swing.JTable();
        radiosingle = new javax.swing.JRadioButton();
        txtdurasi = new javax.swing.JTextField();
        radiodouble = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        radionormal = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        cmbnama = new javax.swing.JComboBox<>();
        cmbtlp = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("jam");

        jLabel5.setText("Mode");

        jLabel6.setText("Jenis Kamar");

        radiovip.setText("vip");
        radiovip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiovipActionPerformed(evt);
            }
        });

        jLabel3.setText("Nomor Telepon");

        btnbo.setText("Boking");
        btnbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnboActionPerformed(evt);
            }
        });

        radiovvip.setText("vvip");

        txttlp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttlpActionPerformed(evt);
            }
        });

        jLabel4.setText("Durasi ");

        tampil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "Nomor Telepon", "Durasi", "Mode", "Jenis Kamar", "harga ", "+ ppn", "admin"
            }
        ));
        tampil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tampilMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tampil);

        radiosingle.setText("single");
        radiosingle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiosingleActionPerformed(evt);
            }
        });

        txtdurasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdurasiActionPerformed(evt);
            }
        });

        radiodouble.setText("double");
        radiodouble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiodoubleActionPerformed(evt);
            }
        });

        jButton2.setText("cencel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Persewaan Kamar Hotel");

        radionormal.setText("normal");
        radionormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radionormalActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        cmbnama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nama" }));
        cmbnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbnamaActionPerformed(evt);
            }
        });

        cmbtlp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nomor" }));
        cmbtlp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtlpActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "durasi" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        laki.setText("laki");

        perempuan.setText("perempuan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radionormal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radiovip, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radiovvip, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnama)
                                .addComponent(txttlp, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtdurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(radiodouble, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radiosingle, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbtlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(perempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(laki, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)))))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(btnbo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 430, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbtlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtdurasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radiosingle)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radiodouble)
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(radionormal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radiovip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radiovvip))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(laki)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(perempuan))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbo)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnboActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel dataModel = (DefaultTableModel) tampil.getModel();
        // Inisialisasi sebuah ArrayList bernama 'list'
        List list = new ArrayList<>();

        CLI boking = new CLI();
        boking.cetaknama(txtnama.getText() );
        boking.cetaknama(txttlp.getText());
        boking.durasi = Integer.parseInt(txtdurasi.getText());

        if(radionormal.isSelected()){
            boking.datajenis(radionormal.getText()+" 100000/jam");
            boking.harga = boking.durasi*10000;
        }
        else if(radiovip.isSelected()){
            boking.datajenis(radiovip.getText()+" 200000/jam");
            boking.harga = boking.durasi*200000;
        }
        else{
            boking.datajenis(radiovvip.getText()+" 300000/jam");
            boking.harga = boking.durasi*300000;
        }
        
        if(radiosingle.isSelected()){
            boking.datamode(radiosingle.getText());
            boking.harga = boking.harga+100000;
        }else{
            boking.datamode(radiodouble.getText());
            boking.harga = boking.harga+200000;
        }

        list.add(boking.cetaknama());
        list.add(boking.cetaktlp());
        list.add(boking.durasi);
        list.add(boking.cetakmode());
        list.add(boking.cetakjenis());
        list.add(boking.harga);
        list.add(boking.hargatotall());
        list.add(boking.namaadmin());
        dataModel.addRow(list.toArray());
    }//GEN-LAST:event_btnboActionPerformed

    private void txttlpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttlpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttlpActionPerformed

    private void radiosingleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiosingleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiosingleActionPerformed

    private void txtdurasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdurasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdurasiActionPerformed

    private void radiodoubleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiodoubleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiodoubleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void radionormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radionormalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radionormalActionPerformed

    private void radiovipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiovipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiovipActionPerformed

    private void cmbnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbnamaActionPerformed
        // TODO add your handling code here:
         new TAMBAH().setVisible(true);
    }//GEN-LAST:event_cmbnamaActionPerformed

    private void tampilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tampilMouseClicked
        // TODO add your handling code here:
//      int tabel = table.getSelectedRow();
//        nama1 = table.getValueAt(tabel, 0).toString();
//        nama1 = table_data_mahasiswa.getValueAt(tabel, 1).toString();
//        jk1 = table_data_mahasiswa.getValueAt(tabel, 2).toString();
//        prodi1 = table_data_mahasiswa.getValueAt(tabel, 3).toString();
//        ang1 = table_data_mahasiswa.getValueAt(tabel, 4).toString();
//        alamat1 = table_data_mahasiswa.getValueAt(tabel, 5).toString();
//        itempilih();


    }//GEN-LAST:event_tampilMouseClicked

    private void cmbtlpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtlpActionPerformed
        // TODO add your handling code here:
        new TAMBAH().setVisible(true);
    }//GEN-LAST:event_cmbtlpActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        new TAMBAH().setVisible(true);
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbo;
    private javax.swing.JComboBox<String> cmbnama;
    private javax.swing.JComboBox<String> cmbtlp;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton laki;
    private javax.swing.JRadioButton perempuan;
    private javax.swing.JRadioButton radiodouble;
    private javax.swing.JRadioButton radionormal;
    private javax.swing.JRadioButton radiosingle;
    private javax.swing.JRadioButton radiovip;
    private javax.swing.JRadioButton radiovvip;
    private javax.swing.JTable tampil;
    private javax.swing.JTextField txtdurasi;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txttlp;
    // End of variables declaration//GEN-END:variables

    
}
