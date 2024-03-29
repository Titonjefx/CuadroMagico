package interfazgrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import logica_implementacion.AlgoritmoGenetico;
import static utilidades.MapKeyConstantes.*;

/**
 * Interfaz gr&aacute;fica para configurar y mostrar los resultados del
 * algoritmo gen&eacute;tico cuadro m&aacute;gico.
 */
public class IGCuadroMagico extends JFrame {

    /**
     * Tama&ntilde;o de el cuadrado m&aacute;gico.
     */
    private int tamanoDeCuadroMagico;
    /**
     * Mapeo donde estan los par&aacute;metros del algoritmo.
     */
    private Map<String, Object> parametrosDeAlgoritmo;
    /**
     * Texto que se muestra cuando se pasa el puntero del mouse sobre el panel
     * del cuadro m&aacute;gico.
     */
    private String informacionResultados = "Panel donde se muestra el resultado"
            + " del algoritmo genético para el problema del cuadro mágico.";

    /**
     * Crea una nueva ventana IGCuadroMagico
     */
    public IGCuadroMagico() {
        super("Cuadro Mágico - Algoritmo Genético");
        establecerParametrosPorDefecto();
        initComponents();
    }

    private void establecerParametrosPorDefecto() {
        if (parametrosDeAlgoritmo == null) {
            parametrosDeAlgoritmo = new HashMap<>();
            tamanoDeCuadroMagico = 3;
        } else {
            parametrosDeAlgoritmo.clear();
        }
        parametrosDeAlgoritmo.put(MAP_KEY_INTERFAZ_GRAFICA, this);
        parametrosDeAlgoritmo.put(MAP_KEY_PORCENTAJE_CRUCE, 0.6);
        parametrosDeAlgoritmo.put(MAP_KEY_PORCENTAJE_MUTACION, 0.005);
        parametrosDeAlgoritmo.put(MAP_KEY_NUMERO_MAX_GENERACIONES, 100);
        parametrosDeAlgoritmo.put(MAP_KEY_NUM_CROM_POBLACION, 100);
        parametrosDeAlgoritmo.put(MAP_KEY_ALGORITMO_COMBINATORIO,
                false);
        parametrosDeAlgoritmo.put(MAP_KEY_TIPO_SELECTOR,
                MAP_KEY_SELECTOR_INGENUO);
    }
    
    public int getTamanoDeCuadroMagico() {
        return tamanoDeCuadroMagico;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pPanelGeneral.setLayout(new java.awt.BorderLayout());

        pPanelDeCuadroMagico.setBackground(new java.awt.Color(255, 255, 255));
        pPanelDeCuadroMagico.setToolTipText("");
        pPanelDeCuadroMagico.setPreferredSize(new java.awt.Dimension(350, 274));
        pPanelDeCuadroMagico.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pPanelDeCuadroMagicoMouseMoved(evt);
            }
        });
        pPanelDeCuadroMagico.setLayout(new java.awt.GridLayout(1, 1));
        pPanelGeneral.add(pPanelDeCuadroMagico, java.awt.BorderLayout.CENTER);

        btEmpezar.setText("Empezar");
        btEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpezarActionPerformed(evt);
            }
        });
        pPanelGeneral.add(btEmpezar, java.awt.BorderLayout.SOUTH);

        jMenu1.setText("Configuraciones");

        miParametros.setText("Parámetros del Algoritmo");
        miParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miParametrosActionPerformed(evt);
            }
        });
        jMenu1.add(miParametros);

        miTamano.setText("Tamaño de Cuadro Mágico");
        miTamano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTamanoActionPerformed(evt);
            }
        });
        jMenu1.add(miTamano);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        miAcercaDe.setText("Acerca de");
        miAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAcercaDeActionPerformed(evt);
            }
        });
        jMenu2.add(miAcercaDe);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPanelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
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

        algoritmoGenetico.setParametrosDeAlgoritmoGenetico(
                parametrosDeAlgoritmo);

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
        final JDialog vParametrosAlgoritmo = new JDialog(this, "Parámetros de "
                + "Cuadro Mágico", true);

        JLabel lbPorcentajeCruce = new JLabel("Porcentaje de Cruce (x100%): ");

        SpinnerNumberModel spModeloPorcentajeCruce = new SpinnerNumberModel(
                ((Double) parametrosDeAlgoritmo.get(MAP_KEY_PORCENTAJE_CRUCE))
                .doubleValue(), 0.2, 0.6, 0.01);
        final JSpinner spPorcentajeCruce = new JSpinner(
                spModeloPorcentajeCruce);

        JLabel lbPorcentajeMutacion = new JLabel("Porcentaje de Mutación "
                + "(x100%): ");

        SpinnerNumberModel spModeloPorcentajeMutacion = new SpinnerNumberModel(
                ((Double) parametrosDeAlgoritmo.get(MAP_KEY_PORCENTAJE_MUTACION))
                .doubleValue(), 0.001, 0.05,
                0.001);
        final JSpinner spPorcentajeMutacion = new JSpinner(
                spModeloPorcentajeMutacion);

        JLabel lbNumMaxGeneraciones = new JLabel(
                "Número Máximo de Generaciones: ");

        SpinnerNumberModel spModeloNumMaxGeneraciones = new SpinnerNumberModel(
                ((Integer) parametrosDeAlgoritmo.get(
                MAP_KEY_NUMERO_MAX_GENERACIONES)).intValue(), 20, 1000,
                10);
        final JSpinner spNumMaxGeneraciones = new JSpinner(
                spModeloNumMaxGeneraciones);

        JLabel lbNumCromPoblacion = new JLabel(
                "Número de Cromosomas en la Población: ");

        SpinnerNumberModel spModeloNumCromPoblacion = new SpinnerNumberModel(
                ((Integer) parametrosDeAlgoritmo.get(
                MAP_KEY_NUM_CROM_POBLACION)).intValue(), 50, 150,
                1);
        final JSpinner spNumCromPoblacion = new JSpinner(
                spModeloNumCromPoblacion);
        
        JLabel lbTipoSelector = new JLabel(
                "Tipo de Selector Natural: ");
        
        final JComboBox cbTipoSelector = new JComboBox(new Object[]{
            MAP_KEY_SELECTOR_INGENUO, MAP_KEY_SELECTOR_TORNEO});
        
        cbTipoSelector.setSelectedItem(parametrosDeAlgoritmo.get(MAP_KEY_TIPO_SELECTOR));

        final JCheckBox cbAlgoritmoCombinatorio = new JCheckBox(
                "Algoritmo Combinatorio");
        cbAlgoritmoCombinatorio.setSelected((boolean) parametrosDeAlgoritmo
                .get(MAP_KEY_ALGORITMO_COMBINATORIO));

        JButton btEstablecerParametros = new JButton("Establecer");
        btEstablecerParametros.addActionListener(
                new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        double nuevoPorcentajeCruce = Double.parseDouble(
                                spPorcentajeCruce.getValue().toString());
                        double nuevoPorcentajeMutacion = Double.parseDouble(
                                spPorcentajeMutacion.getValue().toString());
                        int nuevoNumMaxGeneraciones = Integer.parseInt(
                                spNumMaxGeneraciones.getValue().toString());
                        int nuevoNumCromPoblacion = Integer.parseInt(
                                spNumCromPoblacion.getValue().toString());
                        String tipoSelector = (String)cbTipoSelector.getSelectedItem();

                        getParametrosDeAlgoritmo().remove(
                                MAP_KEY_PORCENTAJE_CRUCE);
                        getParametrosDeAlgoritmo().remove(
                                MAP_KEY_PORCENTAJE_MUTACION);
                        getParametrosDeAlgoritmo().remove(
                                MAP_KEY_NUMERO_MAX_GENERACIONES);
                        getParametrosDeAlgoritmo().remove(
                                MAP_KEY_NUM_CROM_POBLACION);
                        getParametrosDeAlgoritmo().remove(
                                MAP_KEY_ALGORITMO_COMBINATORIO);
                        getParametrosDeAlgoritmo().remove(
                                MAP_KEY_TIPO_SELECTOR);

                        getParametrosDeAlgoritmo().put(MAP_KEY_PORCENTAJE_CRUCE,
                                nuevoPorcentajeCruce);
                        getParametrosDeAlgoritmo().put(
                                MAP_KEY_PORCENTAJE_MUTACION,
                                nuevoPorcentajeMutacion);
                        getParametrosDeAlgoritmo().put(
                                MAP_KEY_NUMERO_MAX_GENERACIONES,
                                nuevoNumMaxGeneraciones);
                        getParametrosDeAlgoritmo().put(
                                MAP_KEY_NUM_CROM_POBLACION,
                                nuevoNumCromPoblacion);
                        getParametrosDeAlgoritmo().put(
                                MAP_KEY_ALGORITMO_COMBINATORIO,
                                cbAlgoritmoCombinatorio.isSelected());
                        getParametrosDeAlgoritmo().put(MAP_KEY_TIPO_SELECTOR,
                                tipoSelector);

                        vParametrosAlgoritmo.setVisible(false);
                    }
                });

        final JButton btEstablecerParametrosPorDefecto = new JButton(
                "Parámetros por Defecto");
        btEstablecerParametrosPorDefecto.addActionListener(
                new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        establecerParametrosPorDefecto();
                        spPorcentajeCruce.setValue((double) parametrosDeAlgoritmo
                                .get(MAP_KEY_PORCENTAJE_CRUCE));
                        spPorcentajeMutacion.setValue((double) parametrosDeAlgoritmo
                                .get(MAP_KEY_PORCENTAJE_MUTACION));
                        spNumMaxGeneraciones.setValue((int) parametrosDeAlgoritmo
                                .get(MAP_KEY_NUMERO_MAX_GENERACIONES));
                        spNumCromPoblacion.setValue((int) parametrosDeAlgoritmo
                                .get(MAP_KEY_NUM_CROM_POBLACION));
                        cbAlgoritmoCombinatorio.setSelected((boolean) parametrosDeAlgoritmo
                                .get(MAP_KEY_ALGORITMO_COMBINATORIO));
                        cbTipoSelector.setSelectedItem((String) parametrosDeAlgoritmo
                                .get(MAP_KEY_TIPO_SELECTOR));
                    }
                });

        final int GRIYA_COLUMNAS = 2;
        final int GRIYA_FILAS = 7;
        final int GRIYA_ESPACIADO = 5;
        GridLayout griya = new GridLayout(GRIYA_FILAS, GRIYA_COLUMNAS,
                GRIYA_ESPACIADO, GRIYA_ESPACIADO);
        JPanel pParametrosAlgoritmo = new JPanel(griya);

        pParametrosAlgoritmo.add(lbPorcentajeCruce);
        pParametrosAlgoritmo.add(spPorcentajeCruce);
        pParametrosAlgoritmo.add(lbPorcentajeMutacion);
        pParametrosAlgoritmo.add(spPorcentajeMutacion);
        pParametrosAlgoritmo.add(lbNumMaxGeneraciones);
        pParametrosAlgoritmo.add(spNumMaxGeneraciones);
        pParametrosAlgoritmo.add(lbNumCromPoblacion);
        pParametrosAlgoritmo.add(spNumCromPoblacion);
        pParametrosAlgoritmo.add(lbTipoSelector);
        pParametrosAlgoritmo.add(cbTipoSelector);
        pParametrosAlgoritmo.add(cbAlgoritmoCombinatorio);
        pParametrosAlgoritmo.add(new JLabel(""));
        pParametrosAlgoritmo.add(btEstablecerParametrosPorDefecto);
        pParametrosAlgoritmo.add(btEstablecerParametros);
        vParametrosAlgoritmo.getContentPane().add(pParametrosAlgoritmo);

        vParametrosAlgoritmo.pack();
        vParametrosAlgoritmo.setVisible(true);
    }//GEN-LAST:event_miParametrosActionPerformed

    /**
     * M&eacute;todo que es invocado cuando se clickea el menu item
     * tama&ntilde;o. Se indica el taman&ntilde;o del cuadro m&aacute;gico.
     *
     * @param evt evento que se genera al ser clickeado el menu item
     */
    private void miTamanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTamanoActionPerformed
        final JDialog vTamanoDeCuadro = new JDialog(this, "Tamaño de Cuadro "
                + "Mágico", true);

        JLabel lbTamano = new JLabel("Tamaño de Cuadro Mágico: ");

        SpinnerNumberModel spModelo = new SpinnerNumberModel(tamanoDeCuadroMagico,
                3, 20, 1);
        final JSpinner spTamano = new JSpinner(spModelo);

        JButton btEstablecerTamano = new JButton("Establecer");
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

        vTamanoDeCuadro.pack();
        vTamanoDeCuadro.setVisible(true);
    }//GEN-LAST:event_miTamanoActionPerformed

    /**
     * M&eacute;todo que es invocado cuando se clickea el menu item Acerca de.
     *
     * @param evt evento que se genera al ser clickeado el menu item
     */
    private void miAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAcercaDeActionPerformed
        JLabel lbTitulo = new JLabel("Cuadro Mágico", JLabel.CENTER);
        JLabel lbDesarrolladores = new JLabel("Desarrolladores:",
                JLabel.CENTER);
        JLabel lbAutor1 = new JLabel("Jhon Anderson Cardenas Diaz",
                JLabel.CENTER);
        JLabel lbAutor2 = new JLabel("Alejandro Gomez Anaya", JLabel.CENTER);
        JLabel lbAutor3 = new JLabel("Andres Felipe Orejuela Betancourt",
                JLabel.CENTER);
        JLabel lbDerechos = new JLabel("2013 Universidad del Valle",
                JLabel.CENTER);

        JButton btAceptar = new JButton("Aceptar");

        JPanel pPrincipal = new JPanel(new BorderLayout());
        JPanel pInformacion = new JPanel(new GridLayout(8, 1));
        JPanel pBoton = new JPanel(new FlowLayout());

        final JDialog dgAcercaDe = new JDialog(this, "Acerca de...",
                true);

        pInformacion.add(lbTitulo);
        pInformacion.add(new JLabel(""));
        pInformacion.add(lbDesarrolladores);
        pInformacion.add(lbAutor1);
        pInformacion.add(lbAutor2);
        pInformacion.add(lbAutor3);
        pInformacion.add(new JLabel(""));
        pInformacion.add(lbDerechos);

        pBoton.add(btAceptar);
        btAceptar.addActionListener(
                new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        dgAcercaDe.setVisible(false);
                    }
                });

        pPrincipal.add(pInformacion, BorderLayout.CENTER);
        pPrincipal.add(pBoton, BorderLayout.SOUTH);

        dgAcercaDe.getContentPane().add(pPrincipal);
        dgAcercaDe.pack();
        dgAcercaDe.setResizable(false);
        dgAcercaDe.setVisible(true);
    }//GEN-LAST:event_miAcercaDeActionPerformed

    private void pPanelDeCuadroMagicoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pPanelDeCuadroMagicoMouseMoved
        this.pPanelDeCuadroMagico.setToolTipText(informacionResultados);
    }//GEN-LAST:event_pPanelDeCuadroMagicoMouseMoved

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


        pintarCuadroMagico((int[][]) resultadosDeAlgoritmoGenetico.get(
                MAP_KEY_MATRIZ_CUADRO_MAGICO),
                (Point[]) resultadosDeAlgoritmoGenetico.get(
                MAP_KEY_TUPLAS_QUE_CUMPLEN));
        
        informacionResultados = "Tuplas que cumplen con la suma: " + 
                resultadosDeAlgoritmoGenetico.get(
                MAP_KEY_NUMERO_DE_TUPLAS_QUE_CUMPLEN);
        informacionResultados += "; Tiempo Transcurrido: " +
                resultadosDeAlgoritmoGenetico.get(MAP_KEY_TIEMPO_TRANSCURRIDO) +
                " (milisegundos)";
        informacionResultados += "; Número de alelos repetidos: " +
                resultadosDeAlgoritmoGenetico.get(
                MAP_KEY_NUMERO_DE_ALELOS_REPETIDOS);
        informacionResultados += ".";
    }

    /**
     * Regresa los par&aacute;metros del algoritmo establecidas en la interfaz
     * gr&aacute;fica.
     *
     * @return par&aacute;metros del algoritmo gen&eacute;tico
     */
    public Map getParametrosDeAlgoritmo() {
        return this.parametrosDeAlgoritmo;
    }

    /**
     * Apartir de una matriz de n&uacute;meros pinta el cuadro m&aacute;gico en
     * la interfaz gr&aacute;fica.
     *
     * @param cuadroMagico matriz de n&uacute;meros
     */
    public void pintarCuadroMagico(int cuadroMagico[][],
            Point puntosQueCumplen[]) {
        pPanelDeCuadroMagico.removeAll();
        pPanelDeCuadroMagico.setLayout(new GridLayout(cuadroMagico.length,
                cuadroMagico[0].length, 5, 5));

        JLabel lbMatrizCuadroMagico[][] = new JLabel[cuadroMagico.length][cuadroMagico[0].length];
        JPanel pMatrizColores[][] = new JPanel[cuadroMagico.length][cuadroMagico[0].length];

        for (int i = 0; i < cuadroMagico.length; i++) {
            for (int j = 0; j < cuadroMagico[i].length; j++) {

                lbMatrizCuadroMagico[i][j] = new JLabel(String.valueOf(
                        cuadroMagico[i][j]), JLabel.CENTER);
                lbMatrizCuadroMagico[i][j].setForeground(Color.white);
                pMatrizColores[i][j] = new JPanel(new BorderLayout());
                pMatrizColores[i][j].setBackground(Color.LIGHT_GRAY);
                pMatrizColores[i][j].add(lbMatrizCuadroMagico[i][j],
                        BorderLayout.CENTER);
                pPanelDeCuadroMagico.add(pMatrizColores[i][j]);
            }
        }

        //Pintamos las columnas, filas o diagonales cuya suma sea igual que las
        //demas
        for (int i = 0; i < puntosQueCumplen.length; i++) {
            if (puntosQueCumplen[i] != null) {
                if (pMatrizColores[puntosQueCumplen[i].x][puntosQueCumplen[i].y]
                        .getBackground().equals(Color.LIGHT_GRAY)) {
                    pMatrizColores[puntosQueCumplen[i].x][puntosQueCumplen[i].y]
                            .setBackground(new Color(120, 140, 194));
                } else if (pMatrizColores[puntosQueCumplen[i].x][puntosQueCumplen[i].y]
                        .getBackground().equals(new Color(120, 140, 194))) {
                    pMatrizColores[puntosQueCumplen[i].x][puntosQueCumplen[i].y]
                            .setBackground(new Color(159, 117, 198));
                } else if (pMatrizColores[puntosQueCumplen[i].x][puntosQueCumplen[i].y]
                        .getBackground().equals(new Color(159, 117, 198))) {
                    pMatrizColores[puntosQueCumplen[i].x][puntosQueCumplen[i].y]
                            .setBackground(new Color(242, 72, 115));
                }
                /*pMatrizColores[puntosQueCumplen[i].x][puntosQueCumplen[i].y]
                 .setBackground(new Color(39, 123, 237));*/
            }
        }
        this.paintAll(this.getGraphics());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEmpezar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miAcercaDe;
    private javax.swing.JMenuItem miParametros;
    private javax.swing.JMenuItem miTamano;
    private javax.swing.JPanel pPanelDeCuadroMagico;
    private javax.swing.JPanel pPanelGeneral;
    // End of variables declaration//GEN-END:variables
}
