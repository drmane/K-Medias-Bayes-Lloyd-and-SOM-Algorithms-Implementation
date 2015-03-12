/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ic;

import algorithms.Bayes;
import algorithms.KMedias;
import algorithms.Lloyd;
import algorithms.SOM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo
 */
public class MainFrame extends javax.swing.JFrame {

    public String nombreTest;
    public String clasificador;
    private static double SAMPLES[][] = new double[100][4];
    private static double TEST[][] = new double[1][4];

    /**
     *
     * /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        CTextAreaOutputStream taos = new CTextAreaOutputStream();
        this.setVisible(true);
        LloydButton.setSelected(true);
        try {
            readFile("Iris2Clases.txt", SAMPLES);


        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Fichero Iris2Clases.txt no encontrado \n");
        }


        //Redirijo los println

        System.setOut(new PrintStream(taos, true) {
            @Override
            public synchronized void println(String s) {
                if ((s != null) && (s.length() > 0)) {
                    textArea1.setText(textArea1.getText() + " " + s);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        textField1 = new java.awt.TextField();
        textArea1 = new java.awt.TextArea();
        BayesButton = new javax.swing.JRadioButton();
        LloydButton = new javax.swing.JRadioButton();
        KMediasButton = new javax.swing.JRadioButton();
        SOMButton = new javax.swing.JRadioButton();
        TodosButton = new javax.swing.JRadioButton();
        label1 = new java.awt.Label();
        campoNombreArchivo = new java.awt.TextField();
        botonEjecutar = new java.awt.Button();

        textField1.setText("textField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(BayesButton);
        BayesButton.setText("Bayes");

        buttonGroup1.add(LloydButton);
        LloydButton.setText("LLoyd");

        buttonGroup1.add(KMediasButton);
        KMediasButton.setText("K-Medias");

        buttonGroup1.add(SOMButton);
        SOMButton.setText("SOM");

        buttonGroup1.add(TodosButton);
        TodosButton.setText("Todos");

        label1.setText("Nombre de archivo del test");

        campoNombreArchivo.setText("TestIris01.txt");

        botonEjecutar.setLabel("Ejecutar");
        botonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TodosButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LloydButton)
                                .addGap(18, 18, 18)
                                .addComponent(SOMButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BayesButton)
                                .addGap(18, 18, 18)
                                .addComponent(KMediasButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BayesButton)
                            .addComponent(KMediasButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LloydButton)
                            .addComponent(SOMButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TodosButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEjecutarActionPerformed
        nombreTest = campoNombreArchivo.getText();
        clasificador = buttonGroup1.getSelection().getActionCommand();

        try {

            readFile(nombreTest, TEST);
            


        } catch (IOException ex) {
            
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
             
          
        }

        System.out.println(nombreTest + "__");
        if (LloydButton.isSelected()) {

            System.out.println("LLoyd");
            Lloyd lloyd = new Lloyd(SAMPLES);
            lloyd.calcularPertencia(TEST);
            System.out.println("\n");

        } else if (BayesButton.isSelected()) {
            System.out.println("Bayes");
            Bayes bayes = new Bayes(SAMPLES);
            bayes.calcularPertenencia(TEST);
            System.out.println("\n");

        } else if (KMediasButton.isSelected()) {
            System.out.println("KMedias");
            KMedias kMedias = new KMedias(SAMPLES);
            kMedias.calcularPertencia(TEST);
            System.out.println("\n");

        } else if (SOMButton.isSelected()) {


            System.out.println("SOM");
            SOM som = new SOM(SAMPLES);
            som.calcularPertencia(TEST);
            System.out.println("\n");



        } else {

            textArea1.setText("");
            System.out.println(nombreTest + "__");
            System.out.println("LLoyd");
            Lloyd lloyd = new Lloyd(SAMPLES);
            lloyd.calcularPertencia(TEST);
            System.out.println("\n");
            System.out.println(nombreTest + "__");
            System.out.println("Bayes");
            Bayes bayes = new Bayes(SAMPLES);
            bayes.calcularPertenencia(TEST);
            System.out.println("\n");
            System.out.println(nombreTest + "__");
            System.out.println("KMedias");
            KMedias kMedias = new KMedias(SAMPLES);
            kMedias.calcularPertencia(TEST);
            System.out.println("\n");
            System.out.println(nombreTest + "__");
            System.out.println("SOM");
            SOM som = new SOM(SAMPLES);
            som.calcularPertencia(TEST);
            System.out.println("\n");

        }




    }//GEN-LAST:event_botonEjecutarActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    public static void readFile(String fileName, double[][] array) throws IOException {

        FileInputStream in = null;
        try {
            File inputFile = new File(fileName);
            in = new FileInputStream(fileName);
        } catch (Exception e) {
            System.err.println("Incapaz de abrir el fichero: " + fileName + "\n" + e);
        JOptionPane.showMessageDialog(new JFrame(), "No se encontro el fichero con nombre "+fileName);
        }

        BufferedReader sample_file = new BufferedReader(new InputStreamReader(in));
        String input;

        input = sample_file.readLine();
        if (input == null) {
            System.err.println("No se han encontado datos en el fichero: " + fileName + "\n");
        }
        StringTokenizer tokenizer;

        int i = 0;
        while (input != null) {
            tokenizer = new StringTokenizer(input, ",");
            array[i][0] = Double.valueOf(tokenizer.nextToken());
            array[i][1] = Double.valueOf(tokenizer.nextToken());
            array[i][2] = Double.valueOf(tokenizer.nextToken());
            array[i][3] = Double.valueOf(tokenizer.nextToken());
            tokenizer.nextToken();
            input = sample_file.readLine();
            i++;

        }
        sample_file.close();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BayesButton;
    private javax.swing.JRadioButton KMediasButton;
    private javax.swing.JRadioButton LloydButton;
    private javax.swing.JRadioButton SOMButton;
    private javax.swing.JRadioButton TodosButton;
    private java.awt.Button botonEjecutar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private java.awt.TextField campoNombreArchivo;
    private java.awt.Label label1;
    private java.awt.TextArea textArea1;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}