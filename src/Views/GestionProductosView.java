/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.ClienteController;
import Controllers.EmpleadoController;
import Controllers.ProductoController;
import Controllers.ProveedorController;
import Models.Productos.Producto;
import Models.Productos.ProductoNoPerecedero;
import Models.Productos.ProductoPerecedero;
import com.raven.datechooser.SelectedDate;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Simón David Cruz S
 */
public class GestionProductosView extends javax.swing.JFrame {

    /**
     * Creates new form GestionProductosView
     */
    ProductoController pc;
    EmpleadoController ec;
    ClienteController cc;
    ProveedorController pvC;
    
    
    public GestionProductosView(ProductoController pc, EmpleadoController ec, ClienteController cc, ProveedorController pvC) {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        this.pc = pc;
        this.pvC = pvC;
        this.ec = ec;
        this.cc = cc;
        alistarTabla(0);
        estilarElementos();
        alistarBox1();
        alistarBox2();
        alistarBoxCodigos();
        alistarComboOrden();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    public void estilarElementos(){
        btnSuministrar.setBackground(new Color(60, 179, 113));
        btnBuscar.setBackground(new Color(100, 149, 237));
        btnEditar.setBackground(new Color(255, 215, 0));
        btnEliminar.setBackground(new Color(255, 69, 0));
        regresar.setBackground(new Color(230, 230, 250));
    }
    
    public void alistarBox1(){
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo.addElement("Perecedero");
        modelo.addElement("NoPerecedero");
        CTipo.setModel(modelo);
    }
    
    public void alistarBox2(){
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        for (int i = 0; i < pvC.getProveedores().size(); i++) {
            modelo.addElement(pvC.getProveedores().get(i).getIdProveedor() + "");
        }
        CProveedor.setModel(modelo);
    }
    
    public void alistarBoxCodigos(){
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo.addElement("");
        
        for (int i = 0; i < pc.getProductos(0).size(); i++) {
            modelo.addElement(pc.getProductos(0).get(i).getCodigoProducto() + "");
        }
        comboCodigo.setModel(modelo);
    }
    
    public void alistarComboOrden(){
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        
        modelo.addElement("Codigo");
        modelo.addElement("Nombre");
        modelo.addElement("Precio");
        modelo.addElement("Stock");
        
        comboOrden.setModel(modelo);
    }
    
    public void vaciarCampos(){
        CTipo.setSelectedIndex(0);
        comboCodigo.setSelectedIndex(0);
        nombreTxt.setText("");
        precioTxt.setText("");
        stockTxt.setText("");
        fechaTxt.setText("");
    }
    
    public void alistarTabla(int criterio){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.setColumnIdentifiers(new Object[]{"Proveedor","Codigo", "Nombre", "Precio", "Stock", "Tipo", "Caducidad", "DuracionAlmacen"});
        
        for (int i = 0; i < pc.getProductos(criterio).size(); i++) {
            Producto pro = pc.getProductos(criterio).get(i);
            modelo.addRow(new Object[]{
                pro.getIdProveedor(),
                pro.getCodigoProducto(),
                pro.getNombreProducto(),
                pro.getPrecio(),
                pro.getStock(),
                pro.getClass().getSimpleName().equals("ProductoPerecedero")? "Perecedero":"NoPerecedero",
                pro instanceof ProductoPerecedero? ((ProductoPerecedero)pro).getFechaCaducidad() : "",
                pro instanceof ProductoNoPerecedero? ((ProductoNoPerecedero)pro).getDuracionAlmacen() : ""
            });
        }
        tabla.setModel(modelo);
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        btnRegresar = new javax.swing.JButton();
        date = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        regresar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        comboOrden = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CTipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        precioTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        stockTxt = new javax.swing.JTextField();
        atributo = new javax.swing.JLabel();
        fechaTxt = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSuministrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        CProveedor = new javax.swing.JComboBox<>();
        comboCodigo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        btnRegresar.setText("jButton2");

        date.setForeground(new java.awt.Color(93, 142, 204));
        date.setDateFormat("dd-MMMM-yyyy");
        date.setTextRefernce(fechaTxt);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);

        regresar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        regresar.setText("Regresar");
        regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("ORDENAR POR: ");

        comboOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnOrdenar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnOrdenar.setText("Ordenar");
        btnOrdenar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(167, 167, 167))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("TipoProducto");

        CTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CTipoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Codigo");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Nombre");

        nombreTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Precio");

        precioTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Stock");

        stockTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        stockTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockTxtActionPerformed(evt);
            }
        });

        atributo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        atributo.setText("FechaCaducidad");

        fechaTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fechaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaTxtActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSuministrar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnSuministrar.setText("Suministrar");
        btnSuministrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuministrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuministrarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("PROVEEDOR");

        CProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        comboCodigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precioTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fechaTxt)
                                .addComponent(stockTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSuministrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atributo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(precioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atributo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuministrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        ViewGerente vg = new ViewGerente(pc,ec,cc,pvC);
        vg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void btnSuministrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuministrarActionPerformed
        try{
            String tipo = (String) CTipo.getSelectedItem();
            String nombre = nombreTxt.getText();
            double precio = Double.parseDouble(precioTxt.getText());
            int stock = Integer.parseInt(stockTxt.getText());
            SelectedDate d = date.getSelectedDate();
            String extra = d.getDay() + "/" + d.getMonth() + "/"+d.getYear();
            int IdProveedor = Integer.parseInt((String) CProveedor.getSelectedItem());

            Producto pp;

            if (tipo.equals("Perecedero")) {
                pp = new ProductoPerecedero(-1, nombre, precio, stock, extra, IdProveedor);
            } else {
                pp = new ProductoNoPerecedero(-1, nombre, precio, stock, extra, IdProveedor);
            }

            pc.agregarProducto(pp);
            alistarTabla(comboOrden.getSelectedIndex());
            vaciarCampos();
            alistarBoxCodigos();
            JOptionPane.showMessageDialog(null, "¡PRODUCTO SUMINISTRADO EXITOSAMENTE!");
        }catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, "ERROR AL SUMINISTRAR PRODUCTO");
            System.out.println("ERROR AL SUMINISTRAR PRODUCTO " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuministrarActionPerformed

    private void stockTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockTxtActionPerformed

    private void CTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CTipoActionPerformed
        String opcion =(String) CTipo.getSelectedItem();
        
        if(opcion.equals("Perecedero")){
            atributo.setText("FechaCaducidad");
        }
        else{
            atributo.setText("DuracionAlmacen");
        }
    }//GEN-LAST:event_CTipoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try{
            String opcion = (String) CTipo.getSelectedItem();
            int codigo = Integer.parseInt(comboCodigo.getSelectedItem() + "");
            String nombre = nombreTxt.getText();
            double precio = Double.parseDouble(precioTxt.getText());
            int stock = Integer.parseInt(stockTxt.getText());
            SelectedDate d = date.getSelectedDate();
            String extra = d.getDay() + "/" + d.getMonth() + "/"+d.getYear();
            int id_proveedor = Integer.parseInt(CProveedor.getSelectedItem() + "");

            Producto pp;

            if (opcion.equals("Perecedero")) {
                pp = new ProductoPerecedero(codigo, nombre, precio, stock, extra, id_proveedor);
            } else {
                pp = new ProductoNoPerecedero(codigo, nombre, precio, stock, extra, id_proveedor);
            }

            pc.editarProducto(pp);
            alistarTabla(comboOrden.getSelectedIndex());
            vaciarCampos();
            JOptionPane.showMessageDialog(null, "¡PRODUCTO EDITADO EXITOSAMENTE!");
        }catch(RuntimeException e ){
            JOptionPane.showMessageDialog(null, "ERROR AL EDITAR PRODUCTO");
            System.out.println("ERROR AL EDITAR PRODUCTO " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            int codigo = Integer.parseInt(comboCodigo.getSelectedItem() + "");
            Producto producto = pc.buscarProductoCodigo(codigo);
            
            if (!producto.equals(null)){
                CProveedor.setSelectedItem(producto.getIdProveedor() + "");
                nombreTxt.setText(producto.getNombreProducto());
                precioTxt.setText(producto.getPrecio() + "");
                stockTxt.setText(producto.getStock() + "");
                
                if(producto instanceof ProductoPerecedero){
                    fechaTxt.setText(((ProductoPerecedero) producto).getFechaCaducidad());
                    CTipo.setSelectedIndex(0);
                }else{
                    fechaTxt.setText(((ProductoNoPerecedero) producto).getDuracionAlmacen());
                    CTipo.setSelectedIndex(1);
                }
            }
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PRODUCTO");
            System.out.println("ERROR AL BUSCAR PRODUCTO " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void fechaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaTxtActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            int codigo = Integer.parseInt(comboCodigo.getSelectedItem() + "");
            pc.eliminarProducto(codigo);
            alistarTabla(comboOrden.getSelectedIndex());
            vaciarCampos();
            alistarBoxCodigos();
            JOptionPane.showMessageDialog(null, "¡PRODUCTO ELIMINADO EXITOSAMENTE!");
        }catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PRODUCTO");
            System.out.println("ERROR AL ELIMINAR PRODUCTO " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        alistarTabla(comboOrden.getSelectedIndex());
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        date.showPopup();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CProveedor;
    private javax.swing.JComboBox<String> CTipo;
    private javax.swing.JLabel atributo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSuministrar;
    private javax.swing.JComboBox<String> comboCodigo;
    private javax.swing.JComboBox<String> comboOrden;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JTextField precioTxt;
    private javax.swing.JButton regresar;
    private javax.swing.JTextField stockTxt;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
