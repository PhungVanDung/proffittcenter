/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TaxModify.java
 *
 * Created on 01-Feb-2009, 07:00:38
 */
package proffittcenter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

/**
 *
 * @author HP_Owner
 */
public class Tax extends EscapeDialog {

    Preferences root = Preferences.userNodeForPackage(getClass());
    private Integer thisCode;
    private String taxUpdate = "UPDATE Taxes SET Rate=?,Description=?,Symbol=? WHERE ID=?";
    private String taxLookup = "SELECT * FROM Taxes WHERE ID=?";
    private PreparedStatement ps;
    private int rate;
    private String description;
    private String symbol;
    private int id;
    public static int BILLPAYMENT=6;

    /** Creates new form TaxModify
     * @param parent
     * @param modal
     */
    public Tax(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Main.mainHelpBroker.enableHelpKey(getRootPane(), "Tax", Main.mainHelpSet);
    }

    void execute(int id) {
        try {
            PreparedStatement tax;
            tax = Main.getConnection().prepareStatement(SQL.tax );
            tax.setInt(1, id);
            ResultSet rs = tax.executeQuery();
            jRate.requestFocus();
            this.id = id;
            rs.first();
            jId.setText(rs.getString("ID"));
            jRate.setText(PerCent.asPerCent(rs.getInt("Rate")));
//            jRate.setText(StringOps.asPerCent((Integer) rs.getInt("Rate")));
            description = rs.getString("Description");
            jDescription.setText(description);
            symbol = rs.getString("Symbol").substring(0, 1);
            jSymbol.setText(symbol);
            Audio.play("Tada");
            getRootPane().setDefaultButton(okButton);
            jRate.requestFocus();
            setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tax.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRate = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDescription = new javax.swing.JTextField();
        jSymbol = new javax.swing.JTextField();
        jId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("proffittcenter/resource/Tax"); // NOI18N
        setTitle(bundle.getString("Title")); // NOI18N
        setName("Tax"); // NOI18N

        jRate.setToolTipText("");
        jRate.setName("jRate"); // NOI18N
        jRate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jRateFocusGained(evt);
            }
        });
        jRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jRateKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setName("jPanel1"); // NOI18N

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proffittcenter/resource/OK.png"))); // NOI18N
        okButton.setContentAreaFilled(false);
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                okButtonKeyReleased(evt);
            }
        });

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proffittcenter/resource/Close24.png"))); // NOI18N
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setName("closeButton"); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        closeButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                closeButtonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setText(bundle.getString("jLabel1")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(bundle.getString("jLabel2")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(bundle.getString("jLabel3")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(bundle.getString("Tax.jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jDescription.setName("jDescription"); // NOI18N

        jSymbol.setName("jSymbol"); // NOI18N

        jId.setName("jId"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jId, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRate, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(jSymbol, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jId, jRate, jSymbol});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
}//GEN-LAST:event_closeButtonActionPerformed

    private void closeButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closeButtonKeyReleased
}//GEN-LAST:event_closeButtonKeyReleased

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String s =  StringOps.numericOnly(jRate.getText());
        if (s.isEmpty()) {
            //set focus back to descriptionTextField
            jRate.requestFocus();
            Audio.play("Ring");
            return;
        }
        try {
            double dRate = Double.parseDouble(s);
            if (dRate > 10000 || dRate < 0) {
                Audio.play("Ring");
                jRate.requestFocus();
                return;
            }
            rate = (int) (dRate );
        } catch (NumberFormatException numberFormatException) {
            Audio.play("Ring");
            jRate.requestFocus();
            return;
        }
        //need to save all reults
        saveData();
        setVisible(false);
}//GEN-LAST:event_okButtonActionPerformed

    private void okButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_okButtonKeyReleased
//        StringOps.nextComponent(evt, okButton, okButton);
}//GEN-LAST:event_okButtonKeyReleased

    private void jRateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRateKeyReleased
        PerCent.asPerCent(jRate);
    }//GEN-LAST:event_jRateKeyReleased

    private void jRateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRateFocusGained
        jRate.selectAll();
    }//GEN-LAST:event_jRateFocusGained

    public static int calculateTax(int charge,int rate){
        int returnValue =(charge * rate + 5000) / 10000;
        return returnValue;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Tax dialog = new Tax(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JTextField jDescription;
    private javax.swing.JTextField jId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jRate;
    private javax.swing.JTextField jSymbol;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    private void saveData() {
        try {
            ps = Main.getConnection().prepareStatement(taxUpdate);
            ps.setInt(1, rate);
            ps.setString(2, jDescription.getText());
            ps.setString(3, jSymbol.getText().substring(0, 1));
            ps.setString(4, StringOps.numericOnly(jId.getText().substring(0, 1)));
            int i = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
