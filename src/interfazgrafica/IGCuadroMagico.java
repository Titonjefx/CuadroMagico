package interfazgrafica;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import logica.AlgoritmoGenetico;
import static utilidades.MapKeyConstantes.MAP_KEY_INTERFAZ_GRAFICA;

/**
 * Interfaz gr&aacute;fica para configurar y mostrar los resultados del
 * algoritmo gen&eacute;tico.
 *
 * @author Jhonderson
 */
public class IGCuadroMagico extends JFrame {

    /**
     * Tama&ntilde;o de el cuadrado m&aacute;gico.
     */
    private int tamanoDeCuadroMagico;

    /**
     * Crea una nueva ventana IGCuadroMagico
     */
    public IGCuadroMagico() {
        tamanoDeCuadroMagico = 3;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPanelGeneral = new javax.swing.JPanel();
        pPanelDeCuadroMagico = new javax.swing.JPanel();
        btEmpezar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miParametros = new javax.swing.JMenuItem();
        miTamano = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miAcercaDe = new javax.swing.JMenuItem();
        miIndicaciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pPanelDeCuadroMagico.setBackground(new java.awt.Color(255, 255, 255));
        pPanelDeCuadroMagico.setLayout(new java.awt.GridLayout(1, 1));

        btEmpezar.setText("Empezar");
        btEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpezarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPanelGeneralLayout = new javax.swing.GroupLayout(pPanelGeneral);
        pPanelGeneral.setLayout(pPanelGeneralLayout);
        pPanelGeneralLayout.setHorizontalGroup(
            pPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPanelGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEmpezar)
                .addContainerGap())
            .addGroup(pPanelGeneralLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(pPanelDeCuadroMagico, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        pPanelGeneralLayout.setVerticalGroup(
            pPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPanelGeneralLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(pPanelDeCuadroMagico, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEmpezar)
                .addContainerGap())
        );

        jMenu1.setText("Configuraciones");

        miParametros.setText("Parametros Del Algoritmo");
        miParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miParametrosActionPerformed(evt);
            }
        });
        jMenu1.add(miParametros);

        miTamano.setText("Tamaño de Cuadro Magico");
        miTamano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTamanoActionPerformed(evt);
            }
        });
        jMenu1.add(miTamano);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        miAcercaDe.setText("Acerca de");
        jMenu2.add(miAcercaDe);

        miIndicaciones.setText("Indicaciones");
        jMenu2.add(miIndicaciones);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPanelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPanelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * M&eacute;todo que es invocado cuando se clickea el bot&oacute;n empezar.
     * Se inicia el algoritmo gen&eacute;tico.
     *
     * @param evt evento que se genera al ser clickeado el boton
     */
    private void btEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpezarActionPerformed

        AlgoritmoGenetico algoritmoGenetico = new AlgoritmoGenetico();

        //Se crea y se envia la configuracion inicial establecida en la 
        //interfaz grafica como un map de parametros.
        Map<String, Object> parametros = new HashMap<>();

        parametros.put(MAP_KEY_INTERFAZ_GRAFICA, this);

        algoritmoGenetico.setParametrosDeAlgoritmoGenetico(parametros);

        //Se aplica el algoritmo genetico.
        algoritmoGenetico.aplicarAlgoritmo();
    }//GEN-LAST:event_btEmpezarActionPerformed

    /**
     * M&eacute;todo que es invocado cuando se clickea el menu item parametros.
     * Se indican los par&aacute;metros del algoritmo gen&eacute;tico.
     *
     * @param evt evento que se genera al ser clickeado el menu item
     */
    private void miParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miParametrosActionPerformed
    }//GEN-LAST:event_miParametrosActionPerformed

    /**
     * M&eacute;todo que es invocado cuando se clickea el menu item
     * tama&ntilde;o. Se indica el taman&ntilde;o del cuadro m&aacute;gico.
     *
     * @param evt evento que se genera al ser clickeado el menu item
     */
    private void miTamanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTamanoActionPerformed
        final JFrame vTamanoDeCuadro = new JFrame();

        JLabel lbTamano = new JLabel("Tamano de Cuadro"
                + "Magico: ");

        SpinnerNumberModel spModelo =
                new SpinnerNumberModel(3, 3, 20, 1);
        final JSpinner spTamano = new JSpinner(
                spModelo);

        JButton btEstablecerTamano = new JButton(
                "Establecer");
        btEstablecerTamano.addActionListener(
                new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        int valor = Integer.parseInt(
                                spTamano.getValue().toString());
                        establecerTamanoDeCuadroMagico(valor);
                        vTamanoDeCuadro.setVisible(false);
                    }
                });

        JPanel pTamano = new JPanel();

        pTamano.add(lbTamano);
        pTamano.add(spTamano);
        pTamano.add(btEstablecerTamano);
        vTamanoDeCuadro.getContentPane().add(pTamano);

        vTamanoDeCuadro.setSize(350, 80);
        vTamanoDeCuadro.setVisible(true);
    }//GEN-LAST:event_miTamanoActionPerformed

    /**
     * M&eacute;todo para establecer el tama&ntilde;o del cuadro m&aacute;gico.
     *
     * @param valor nuevo tama&ntilde;o del cuadro m&aacute;gico
     */
    public void establecerTamanoDeCuadroMagico(int valor) {
        tamanoDeCuadroMagico = valor;
    }

    /**
     * M&eacute;todo invocado por el algorito gen&eacute;tico para mostrar los
     * resultados del proceso.
     *
     * @param resultadosDeAlgoritmoGenetico objeto de clase Map donde se tienen
     * los resultados del algoritmo aplicado.
     */
    public void mostrarResultadosDeAlgoritmoGenetico(
            Map<String, Object> resultadosDeAlgoritmoGenetico) {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEmpezar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miAcercaDe;
    private javax.swing.JMenuItem miIndicaciones;
    private javax.swing.JMenuItem miParametros;
    private javax.swing.JMenuItem miTamano;
    private javax.swing.JPanel pPanelDeCuadroMagico;
    private javax.swing.JPanel pPanelGeneral;
    // End of variables declaration//GEN-END:variables
}