package Tablero;

//import TableroAjedrez;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
//import java.util.List;
public class FormularioAjedrez extends JFrame {
    private JPanel panelControles;
    private JPanel panelTablero;
    private JButton[][] casillas = new JButton[8][8];
    private TableroAjedrez tablero;
    //private JComboBox<String> jComboBox1;
    private ImageIcon iconoReina = new ImageIcon(getClass().getResource("/resources/Reina.png"));
    private ImageIcon iconoPeón = new ImageIcon(getClass().getResource("/resources/Peón.png"));
    private ImageIcon iconoAlfil = new ImageIcon(getClass().getResource("/resources/Alfil.png"));
    private ImageIcon iconoAlfilNegro = new ImageIcon(getClass().getResource("/resources/AlfilNegro.png"));
    private ImageIcon iconoTorre = new ImageIcon(getClass().getResource("/resources/Torre.png"));
    private ImageIcon iconoCaballo = new ImageIcon(getClass().getResource("/resources/Caballo.png"));
    //private JComboBox<String> jComboBox1;
    private JTextField campoFila; 
    private JTextField campoColumna;    
public FormularioAjedrez() {
        initComponents();
        setTitle("Ajedrez GUI");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());        
        crearTablero();
        crearPanelControles();
        panelControles.setPreferredSize(new Dimension(200, getHeight()));
        add(panelControles, BorderLayout.EAST);
        setVisible(true);
        tablero = new TableroAjedrez();
    }
private void crearTablero() {
        panelTablero = new JPanel(new GridLayout(8, 8));
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new JButton();
                casillas[i][j].setPreferredSize(new Dimension(50, 50));
                // Alternar colores de las casillas
                if ((i + j) % 2 == 0) {
                    casillas[i][j].setBackground(Color.YELLOW);
                } else {
                    casillas[i][j].setBackground(Color.BLACK);
                }
                panelTablero.add(casillas[i][j]);
            }
        }
        panelTablero.setPreferredSize(new Dimension(600, 600));
        add(panelTablero, BorderLayout.CENTER);
        panelTablero.setBounds(130, 130, 600, 600);
        panelTablero.setOpaque(false);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(panelTablero, JLayeredPane.DEFAULT_LAYER);
        add(layeredPane, BorderLayout.CENTER);
    }
private void crearPanelControles() {
        panelControles = new JPanel();
        panelControles.setLayout(new BoxLayout(panelControles, BoxLayout.Y_AXIS)); 
        jComboBox1 = new JComboBox<>();
        jComboBox1.addItem("Reina");
        jComboBox1.addItem("Alfil");
        jComboBox1.addItem("Alfil Negro");
        jComboBox1.addItem("Peón");
        jComboBox1.addItem("Torre");
        jComboBox1.addItem("Caballo");
        panelControles.add(jComboBox1);       
        campoFila = new JTextField();
        campoColumna = new JTextField();
        panelControles.add(campoFila);
        panelControles.add(campoColumna);
    // Añadiendo el ItemListener al JComboBox
        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String item = (String) e.getItem();
                    try {
                        int fila = Integer.parseInt(campoFila.getText());
                        int columna = Integer.parseInt(campoColumna.getText());
                        colocarFicha(fila, columna, item);
                        
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingresa números válidos para la fila y la columna.");
                    }
                }
            }
        });
    }
    
        /** Añadir el JComboBox al panel de controles
        panelControles.add(jComboBox1);
        JButton botonStart = new JButton("Start");
        JButton botonRestart = new JButton("Restart");
        panelControles.add(botonStart);
        panelControles.add(botonRestart);       
        add(panelControles, BorderLayout.EAST);
    }
        */
// Método para colocar una ficha en el tablero
    public void colocarFicha(int fila, int columna, String ficha) {
        JButton casilla = casillas[fila][columna];
        switch (ficha) {
            case "Reina":
                casilla.setIcon(iconoReina);
                panelTablero.revalidate();
                panelTablero.repaint();
                break;
            case "Alfil":
                casilla.setIcon(iconoAlfil);
                panelTablero.revalidate();
                panelTablero.repaint();
                break;
            case "Alfil Negro":
                casilla.setIcon(iconoAlfilNegro);
                panelTablero.revalidate();
                panelTablero.repaint();
                break;
            case "Peón":
                casilla.setIcon(iconoPeón);
                panelTablero.revalidate();
                panelTablero.repaint();
                break;
            case "Torre":
                casilla.setIcon(iconoTorre);
                panelTablero.revalidate();
                panelTablero.repaint();
                break;
            case "Caballo":
                casilla.setIcon(iconoCaballo);
                panelTablero.revalidate();
                panelTablero.repaint();
                break;
        }
        Icon icono = null;
        if (icono != null) {
        casilla.setIcon(icono);
        panelTablero.revalidate();
        panelTablero.repaint();
    }
        panelTablero.revalidate();
        panelTablero.repaint();
        // Mostrar movimientos posibles
    }       
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Fila = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Columna = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 102, 0));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setEnabled(false);
        jPanel2.setFocusable(false);

        jLabel1.setText("Escoge una ficha");
        jPanel2.add(jLabel1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose one", "Reina", "Caballo", "Peon", "Alfil", "AlfilNegro" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);

        Fila.setText("Ingresa la Fila");
        jPanel2.add(Fila);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);

        Columna.setText("Ingresa la Columna");
        jPanel2.add(Columna);

        jTextField2.setName(""); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2);

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setText("Start  👀");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Restart 😁");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        getContentPane().add(jPanel2, new java.awt.GridBagConstraints());

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new java.awt.GridLayout(8, 8));
        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JButton botonRestart = new JButton("Restart");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JButton botonStart = new JButton("Start");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    String fichaSeleccionada = (String) jComboBox1.getSelectedItem();
    try {
        int fila = Integer.parseInt(campoFila.getText());
        int columna = Integer.parseInt(campoColumna.getText());
        colocarFicha(fila, columna, fichaSeleccionada);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Ingresa valores numéricos válidos para fila y columna.");
    }    
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
            java.util.logging.Logger.getLogger(FormularioAjedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioAjedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioAjedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioAjedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(() -> {
            new FormularioAjedrez();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Columna;
    private javax.swing.JLabel Fila;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private static class TableroAjedrez {

        public TableroAjedrez() {
        }
    }
}
