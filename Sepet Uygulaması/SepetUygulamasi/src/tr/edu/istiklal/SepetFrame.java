
package tr.edu.istiklal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Sedo
 */
public class SepetFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SepetFrame.class.getName());

    // ===== KENDİ KODUMUZ =====
private final Sepet sepet = new Sepet();

private DefaultTableModel mdlSepet;
private DefaultTableModel mdlKatEkmek;
private DefaultTableModel mdlKatTelefon;
private DefaultTableModel mdlKatTekstil;

private final DecimalFormat df = new DecimalFormat("#,##0.00",
        DecimalFormatSymbols.getInstance(new Locale("tr","TR")));

private double r2(double v) { return Math.round(v * 100.0) / 100.0; }

private double toDouble(Object o) {
    if (o == null) return 0;
    if (o instanceof Number) return ((Number) o).doubleValue();
    String s = o.toString().trim().replace(",", ".");
    try { return Double.parseDouble(s); } catch (Exception e) { return 0; }
}

private void initModeller() {
    // Katalog modeller
    mdlKatEkmek = new DefaultTableModel(new Object[]{"Tür", "Gramaj(g)", "Fiyat"}, 0) {
        @Override public boolean isCellEditable(int r, int c) { return false; }
    };
    mdlKatTelefon = new DefaultTableModel(new Object[]{"Marka", "Model", "Fiyat"}, 0) {
        @Override public boolean isCellEditable(int r, int c) { return false; }
    };
    mdlKatTekstil = new DefaultTableModel(new Object[]{"Kumaş", "Beden", "Firma", "Fiyat"}, 0) {
        @Override public boolean isCellEditable(int r, int c) { return false; }
    };

    // Sepet modeli
    mdlSepet = new DefaultTableModel(
            new Object[]{"#", "Kategori", "Ad", "Detay1", "Detay2", "Detay3", "Fiyat", "KDV'li"}, 0
    ) {
        @Override public boolean isCellEditable(int r, int c) { return false; }
    };

    // Tabloya bağla
    tblKatEkmek.setModel(mdlKatEkmek);
    tblKatTelefon.setModel(mdlKatTelefon);
    tblKatTekstil.setModel(mdlKatTekstil);
    tblSepet.setModel(mdlSepet);

    tblKatEkmek.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tblKatTelefon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tblKatTekstil.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tblSepet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
}

private void katalogDoldur() {
    mdlKatEkmek.setRowCount(0);
    mdlKatTelefon.setRowCount(0);
    mdlKatTekstil.setRowCount(0);

    // EKMEK
    mdlKatEkmek.addRow(new Object[]{"Somun", 200, 15.0});
    mdlKatEkmek.addRow(new Object[]{"Kepek", 400, 20.0});
    mdlKatEkmek.addRow(new Object[]{"Çavdar", 500, 25.0});

    // TELEFON
    mdlKatTelefon.addRow(new Object[]{"Samsung", "A54", 18000.0});
    mdlKatTelefon.addRow(new Object[]{"Apple", "iPhone 13", 32000.0});
    mdlKatTelefon.addRow(new Object[]{"Xiaomi", "Note 12", 12000.0});

    // TEKSTİL
    mdlKatTekstil.addRow(new Object[]{"Yün", 42, "KazakCo", 420.0});
    mdlKatTekstil.addRow(new Object[]{"Kot", 42, "DenimTR", 250.0});
    mdlKatTekstil.addRow(new Object[]{"Pamuk", 38, "TisortX", 180.0});
}

private void sepetiYenile() {
    mdlSepet.setRowCount(0);
    int i = 1;

    for (Urun u : sepet.getUrunler()) {
        String kategori = "Ürün";
        String ad = u.getUrunAdi();
        String d1 = "", d2 = "", d3 = "";

        if (u instanceof CepTelefonu) {
            CepTelefonu t = (CepTelefonu) u;
            kategori = "Telefon";
            d1 = t.getMarka();
            d2 = t.getModel();
        } else if (u instanceof Ekmek) {
            Ekmek e = (Ekmek) u;
            kategori = "Ekmek";
            ad = "Ekmek";
            d1 = e.getEkmekTuru();
            d2 = (int) e.getGramaj() + " g";
        } else if (u instanceof Tekstil) {
            Tekstil k = (Tekstil) u;
            kategori = "Tekstil";
            d1 = k.getKumasTuru();
            d2 = String.valueOf(k.getBeden());
            d3 = k.getUreticiFirma();
        }

        double fiyat = r2(u.getFiyat());
        double kdvli = r2(u.kdvHesapla());

        mdlSepet.addRow(new Object[]{i++, kategori, ad, d1, d2, d3, fiyat, kdvli});
    }

    toplamGuncelle();
}

private void toplamGuncelle() {
    double ara = r2(sepet.araToplam());
    double kdvli = r2(sepet.kdvliToplam());
    double kdv = r2(kdvli - ara);

    lblAraToplam.setText("Ara Toplam: " + df.format(ara));
    lblKdv.setText("KDV: " + df.format(kdv));
    lblKdvliToplam.setText("KDV'li Toplam: " + df.format(kdvli));
}

private void ekleSeciliUrun() {
    int tabIndex = jTabbedPane1.getSelectedIndex();

    if (tabIndex == 0) { // Ekmek: Tür | Gramaj | Fiyat
        int r = tblKatEkmek.getSelectedRow();
        if (r < 0) { JOptionPane.showMessageDialog(this, "Ekmek seç!"); return; }

        String tur = String.valueOf(mdlKatEkmek.getValueAt(r, 0));
        double gramaj = toDouble(mdlKatEkmek.getValueAt(r, 1));
        double fiyat = toDouble(mdlKatEkmek.getValueAt(r, 2));

        Ekmek e = new Ekmek("Ekmek", fiyat, tur, gramaj);
        e.setUrunAdi("Ekmek " + tur);
        sepet.ekle(e);

    } else if (tabIndex == 1) { // Telefon: Marka | Model | Fiyat
        int r = tblKatTelefon.getSelectedRow();
        if (r < 0) { JOptionPane.showMessageDialog(this, "Telefon seç!"); return; }

        String marka = String.valueOf(mdlKatTelefon.getValueAt(r, 0));
        String model = String.valueOf(mdlKatTelefon.getValueAt(r, 1));
        double fiyat = toDouble(mdlKatTelefon.getValueAt(r, 2));

        CepTelefonu t = new CepTelefonu(marka + " " + model, fiyat, marka, model);
        sepet.ekle(t);

    } else { // Tekstil: Kumaş | Beden | Firma | Fiyat
        int r = tblKatTekstil.getSelectedRow();
        if (r < 0) { JOptionPane.showMessageDialog(this, "Tekstil seç!"); return; }

        String kumas = String.valueOf(mdlKatTekstil.getValueAt(r, 0));
        int beden = (int) toDouble(mdlKatTekstil.getValueAt(r, 1));
        String firma = String.valueOf(mdlKatTekstil.getValueAt(r, 2));
        double fiyat = toDouble(mdlKatTekstil.getValueAt(r, 3));

        Tekstil k = new Tekstil(kumas + " (" + beden + ") - " + firma, fiyat, kumas, beden, firma);
        sepet.ekle(k);
    }

    sepetiYenile();
}


    public SepetFrame() {
        initComponents();     // formu kurar
        pAlt.remove(pAltSag);
        pAlt.add(pAltSag, java.awt.BorderLayout.LINE_END);

        initModeller();       // table modelleri bağlar
        katalogDoldur();      // katalog verilerini doldurur
        sepetiYenile();       // sepeti + toplamları günceller
        setLocationRelativeTo(null); // ortalar
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pUst = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pOrta = new javax.swing.JPanel();
        spMain = new javax.swing.JSplitPane();
        pSol = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pEkmek = new javax.swing.JPanel();
        spKatEkmek = new javax.swing.JScrollPane();
        tblKatEkmek = new javax.swing.JTable();
        pTelefon = new javax.swing.JPanel();
        spKatTelefon = new javax.swing.JScrollPane();
        tblKatTelefon = new javax.swing.JTable();
        pTekstil = new javax.swing.JPanel();
        spKatTekstil = new javax.swing.JScrollPane();
        tblKatTekstil = new javax.swing.JTable();
        pSolAlt = new javax.swing.JPanel();
        btnEkle = new javax.swing.JButton();
        pSag = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSepet = new javax.swing.JTable();
        pAlt = new javax.swing.JPanel();
        pAltSol = new javax.swing.JPanel();
        lblAraToplam = new javax.swing.JLabel();
        lblKdv = new javax.swing.JLabel();
        lblKdvliToplam = new javax.swing.JLabel();
        pAltSag = new javax.swing.JPanel();
        btnSil = new javax.swing.JButton();
        btnTemizle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sepet Uygulamasi");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(900, 600));

        pUst.setPreferredSize(new java.awt.Dimension(0, 60));
        pUst.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SEPET UYGULAMASI");
        pUst.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pUst, java.awt.BorderLayout.PAGE_START);

        pOrta.setPreferredSize(new java.awt.Dimension(0, 70));
        pOrta.setLayout(new java.awt.BorderLayout());

        spMain.setDividerLocation(460);
        spMain.setResizeWeight(0.35);

        pSol.setPreferredSize(new java.awt.Dimension(380, 0));
        pSol.setLayout(new java.awt.BorderLayout());

        pEkmek.setLayout(new java.awt.BorderLayout());

        tblKatEkmek.setModel(new javax.swing.table.DefaultTableModel(
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
        spKatEkmek.setViewportView(tblKatEkmek);

        pEkmek.add(spKatEkmek, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Ekmek", pEkmek);

        pTelefon.setLayout(new java.awt.BorderLayout());

        tblKatTelefon.setModel(new javax.swing.table.DefaultTableModel(
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
        spKatTelefon.setViewportView(tblKatTelefon);

        pTelefon.add(spKatTelefon, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Telefon", pTelefon);

        pTekstil.setLayout(new java.awt.BorderLayout());

        tblKatTekstil.setModel(new javax.swing.table.DefaultTableModel(
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
        spKatTekstil.setViewportView(tblKatTekstil);

        pTekstil.add(spKatTekstil, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Tekstil", pTekstil);

        pSol.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pSolAlt.setLayout(new java.awt.BorderLayout());

        btnEkle.setText("EKLE");
        btnEkle.setPreferredSize(new java.awt.Dimension(0, 40));
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });
        pSolAlt.add(btnEkle, java.awt.BorderLayout.CENTER);

        pSol.add(pSolAlt, java.awt.BorderLayout.PAGE_END);

        spMain.setLeftComponent(pSol);

        pSag.setLayout(new java.awt.BorderLayout());

        tblSepet.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblSepet);

        pSag.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        spMain.setRightComponent(pSag);

        pOrta.add(spMain, java.awt.BorderLayout.CENTER);

        getContentPane().add(pOrta, java.awt.BorderLayout.CENTER);

        pAlt.setPreferredSize(new java.awt.Dimension(400, 70));
        pAlt.setLayout(new java.awt.BorderLayout());

        pAltSol.setPreferredSize(new java.awt.Dimension(450, 70));
        pAltSol.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 25, 20));

        lblAraToplam.setText("Ara Toplam: 0,00");
        pAltSol.add(lblAraToplam);

        lblKdv.setText("KDV: 0,00");
        pAltSol.add(lblKdv);

        lblKdvliToplam.setText("KDV'li Toplam: 0,00");
        pAltSol.add(lblKdvliToplam);

        pAlt.add(pAltSol, java.awt.BorderLayout.LINE_START);

        pAltSag.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });
        pAltSag.add(btnSil);

        btnTemizle.setText("Temizle");
        btnTemizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemizleActionPerformed(evt);
            }
        });
        pAltSag.add(btnTemizle);

        pAlt.add(pAltSag, java.awt.BorderLayout.CENTER);

        getContentPane().add(pAlt, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        // TODO add your handling code here:
        ekleSeciliUrun();
    }//GEN-LAST:event_btnEkleActionPerformed

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        // TODO add your handling code here:
        int r = tblSepet.getSelectedRow();
        if (r < 0) {
            JOptionPane.showMessageDialog(this, "Sepetten silmek için satır seç!");
        return;
        }
        sepet.sil(r);
        sepetiYenile();
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnTemizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemizleActionPerformed
        // TODO add your handling code here:
        sepet.temizle();
        sepetiYenile();
    }//GEN-LAST:event_btnTemizleActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new SepetFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnTemizle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAraToplam;
    private javax.swing.JLabel lblKdv;
    private javax.swing.JLabel lblKdvliToplam;
    private javax.swing.JPanel pAlt;
    private javax.swing.JPanel pAltSag;
    private javax.swing.JPanel pAltSol;
    private javax.swing.JPanel pEkmek;
    private javax.swing.JPanel pOrta;
    private javax.swing.JPanel pSag;
    private javax.swing.JPanel pSol;
    private javax.swing.JPanel pSolAlt;
    private javax.swing.JPanel pTekstil;
    private javax.swing.JPanel pTelefon;
    private javax.swing.JPanel pUst;
    private javax.swing.JScrollPane spKatEkmek;
    private javax.swing.JScrollPane spKatTekstil;
    private javax.swing.JScrollPane spKatTelefon;
    private javax.swing.JSplitPane spMain;
    private javax.swing.JTable tblKatEkmek;
    private javax.swing.JTable tblKatTekstil;
    private javax.swing.JTable tblKatTelefon;
    private javax.swing.JTable tblSepet;
    // End of variables declaration//GEN-END:variables
}
