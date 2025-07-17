import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Formulario_Sistema_facturacion extends javax.swing.JFrame {
    private final String archivoFactura = "numero_factura.txt";

    public Formulario_Sistema_facturacion() {
        initComponents();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Subtotal");
        jTable1.setModel(modelo);
        jTextField7.setText(obtenerFechaActual()); // Fecha
        jTextField6.setText(obtenerNumeroFactura()); // Número de factura
    }
    
   
    private void limpiarFormulario() {
    // Limpia los campos del cliente
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    
    // Limpia los campos de productos
    jTextField8.setText("");
    jTextField9.setText("");
    jTextField10.setText("");
    
    // Limpia los campos de totales
    jTextField11.setText("");
    jTextField12.setText("");
    jTextField13.setText("");
    
    // Limpia la tabla
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    modelo.setRowCount(0);
}
   private void guardarFacturaPDF() {
    String carpeta = "facturas";
    new java.io.File(carpeta).mkdirs(); // Crear carpeta si no existe
    String nombreArchivo = carpeta + "/factura_" + jTextField6.getText() + ".pdf";

    try {
        com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
        com.itextpdf.text.pdf.PdfWriter.getInstance(documento, new java.io.FileOutputStream(nombreArchivo));
        documento.open();

        // Encabezado
        com.itextpdf.text.Font titulo = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 16, com.itextpdf.text.Font.BOLD);
        com.itextpdf.text.Font negrita = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.BOLD);

        documento.add(new com.itextpdf.text.Paragraph("MINIMARKET Ing. CHIMBORAZO & GARCIA", titulo));
        documento.add(new com.itextpdf.text.Paragraph("Víctor Hugo & Avenida los chásquis"));
        documento.add(new com.itextpdf.text.Paragraph("0999496122 & supercg@hotmail.com"));
        documento.add(new com.itextpdf.text.Paragraph(" ")); // Espacio

        // Datos de factura
        documento.add(new com.itextpdf.text.Paragraph("Factura N°: " + jTextField6.getText(), negrita));
        documento.add(new com.itextpdf.text.Paragraph("Fecha: " + jTextField7.getText()));
        documento.add(new com.itextpdf.text.Paragraph(" ")); // Espacio

        // Datos del cliente
        documento.add(new com.itextpdf.text.Paragraph("Cliente: " + jTextField2.getText() + " " + jTextField3.getText()));
        documento.add(new com.itextpdf.text.Paragraph("C.I: " + jTextField1.getText()));
        documento.add(new com.itextpdf.text.Paragraph("Dirección: " + jTextField4.getText()));
        documento.add(new com.itextpdf.text.Paragraph("Teléfono: " + jTextField5.getText()));
        documento.add(new com.itextpdf.text.Paragraph("Correo: "+ jTextField14.getText()));
        documento.add(new com.itextpdf.text.Paragraph(" ")); // Espacio

        // Tabla de productos
        com.itextpdf.text.pdf.PdfPTable tabla = new com.itextpdf.text.pdf.PdfPTable(4);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(10f);
        tabla.setSpacingAfter(10f);

        tabla.addCell("Producto");
        tabla.addCell("Cantidad");
        tabla.addCell("Precio Unitario");
        tabla.addCell("Subtotal");

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            tabla.addCell(modelo.getValueAt(i, 0).toString());
            tabla.addCell(modelo.getValueAt(i, 1).toString());
            tabla.addCell(modelo.getValueAt(i, 2).toString());
            tabla.addCell(modelo.getValueAt(i, 3).toString());
        }

        documento.add(tabla);

        // Totales
        documento.add(new com.itextpdf.text.Paragraph("Subtotal sin IVA: " + jTextField11.getText()));
        documento.add(new com.itextpdf.text.Paragraph("IVA (15%): " + jTextField12.getText()));
        documento.add(new com.itextpdf.text.Paragraph("Total: " + jTextField13.getText()));

        documento.close();
        java.awt.Desktop.getDesktop().open(new java.io.File(nombreArchivo));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al generar PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
   
   private void guardarFacturaTXT() {
    String carpeta = "facturas";
    new java.io.File(carpeta).mkdirs(); // Crear carpeta si no existe

    String nombreArchivo = carpeta + "/factura_" + jTextField6.getText() + ".txt";

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
        bw.write("Número de factura: " + jTextField6.getText());
        bw.newLine();
        bw.write("Fecha: " + jTextField7.getText());
        bw.newLine();
        bw.write("Cliente: " + jTextField2.getText() + " " + jTextField3.getText());
        bw.newLine();
        bw.write("C.I: " + jTextField1.getText());
        bw.newLine();
        bw.write("----------------------------------------------------");
        bw.newLine();

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            bw.write("Producto: " + modelo.getValueAt(i, 0) +
                     ", Cantidad: " + modelo.getValueAt(i, 1) +
                     ", Precio unitario: " + modelo.getValueAt(i, 2) +
                     ", Subtotal: " + modelo.getValueAt(i, 3));
            bw.newLine();
        }

        bw.write("----------------------------------------------------");
        bw.newLine();
        bw.write("Subtotal sin IVA: " + jTextField11.getText());
        bw.newLine();
        bw.write("IVA (15%): " + jTextField12.getText());
        bw.newLine();
        bw.write("Total: " + jTextField13.getText());
        bw.newLine();

    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

   private void actualizarTotales() {
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    double subtotalConIVA = 0.0;

    for (int i = 0; i < modelo.getRowCount(); i++) {
        Object val = modelo.getValueAt(i, 3); // columna Subtotal
        if (val != null) {
            subtotalConIVA += Double.parseDouble(val.toString());
        }
    }

    double subtotalSinIVA = subtotalConIVA / 1.15;
    double iva = subtotalConIVA - subtotalSinIVA;
    double total = subtotalConIVA; // ya tiene IVA

    jTextField11.setText(String.format("%.2f", subtotalSinIVA));
    jTextField12.setText(String.format("%.2f", iva));
    jTextField13.setText(String.format("%.2f", total));
}
   
   
     private String obtenerFechaActual() {
        java.time.LocalDate fecha = java.time.LocalDate.now();
        return fecha.toString(); // Formato YYYY-MM-DD
    }

    private java.util.List<String[]> leerProductosDesdeTXT() {
        java.util.List<String[]> productos = new java.util.ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("productos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    String nombre = partes[1].trim();   // Nombre del producto
                    String precio = partes[3].trim();   // Precio unitario
                    String stock = partes[4].trim();    // Stock
                    productos.add(new String[]{nombre, precio, stock});
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer productos.txt", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return productos;
    }
    
    

    private String obtenerNumeroFactura() {
        int numero = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoFactura))) {
            String linea = br.readLine();
            if (linea != null) {
                numero = Integer.parseInt(linea.trim());
            }
        } catch (IOException | NumberFormatException e) {
            numero = 1;
        }
        return String.format("%03d", numero); // 001, 002, ...
    }
    
    

 private void actualizarNumeroFactura() {
        int numero = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoFactura))) {
            String linea = br.readLine();
            if (linea != null) {
                numero = Integer.parseInt(linea.trim());
            }
        } catch (IOException | NumberFormatException e) {
            numero = 1;
        }

        numero++; // Incrementa

        if (numero <= 99) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoFactura))) {
                bw.write(Integer.toString(numero));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el número de factura.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Límite de facturas alcanzado (hasta 99).", "Límite", JOptionPane.WARNING_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField14 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 2, 14)); // NOI18N
        jLabel2.setText("Datos del Cliente ");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel3.setText("C.I");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel5.setText("Apellido");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel6.setText("Direccion");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel7.setText("Telefono");

        jButton1.setText("Buscar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar Nuevo Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel18.setText("Correo");

        jButton6.setText("Limpiar Cliente");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jTextField5))
                        .addGap(116, 116, 116)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jTextField14))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jButton6)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(82, 82, 82))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jButton6))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SWRomnc", 2, 36)); // NOI18N
        jLabel1.setText("Sistema de Facturización");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel8.setText("Numero Factura");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel9.setText("Fecha");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel10.setText("Producto");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel11.setText("Precio ");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel12.setText("Cantidad ");

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Productos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Imprimir  Factura ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel13.setText("Subtotal Sin Iva ");

        jLabel14.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel14.setText("I.V.A");

        jLabel15.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel15.setText("Total a Pagar ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel16.setText("Agregar Productos al Carrito ");

        jLabel17.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel17.setText("Lista de Productos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Precio Unitario", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setName("jTableProductos"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jLabel19.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        jLabel19.setText("CARRITO DE PRODUCTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel8)
                                .addGap(32, 32, 32)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(10, 10, 10)))
                .addGap(149, 149, 149))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(33, 33, 33))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jButton4))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(jButton3))
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1107, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String cedulaEntrada = jTextField1.getText().trim().toLowerCase();
    String nombreEntrada = jTextField2.getText().trim().toLowerCase();
    

    if (cedulaEntrada.isEmpty() && nombreEntrada.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingresa al menos la cédula o el nombre.");
        return;
    }

    List<String[]> coincidencias = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String cedula = datos[0].toLowerCase();
            String nombre = datos[1].toLowerCase();
            String apellido = datos[2].toLowerCase();

            if ((!cedulaEntrada.isEmpty() && cedula.equals(cedulaEntrada)) ||
                (!nombreEntrada.isEmpty() && (nombre.contains(nombreEntrada) || apellido.contains(nombreEntrada)))) {
                coincidencias.add(datos);
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (coincidencias.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron coincidencias.");
        return;
    }

    if (coincidencias.size() == 1) {
        rellenarCampos(coincidencias.get(0));
    } else {
        String[] opciones = new String[coincidencias.size()];
        for (int i = 0; i < coincidencias.size(); i++) {
            opciones[i] = coincidencias.get(i)[1] + " " + coincidencias.get(i)[2] + " - C.I: " + coincidencias.get(i)[0];
        }

        String seleccion = (String) JOptionPane.showInputDialog(
            this, "Seleccione un cliente:", "Coincidencias",
            JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion != null) {
            for (String[] cliente : coincidencias) {
                String texto = cliente[1] + " " + cliente[2] + " - C.I: " + cliente[0];
                if (texto.equals(seleccion)) {
                    rellenarCampos(cliente);
                    break;
                }
            }
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed
private void rellenarCampos(String[] datos) {
    jTextField1.setText(datos[0]); // Cédula
    jTextField2.setText(datos[1]); // Nombre
    jTextField3.setText(datos[2]); // Apellido
    jTextField5.setText(datos[3]); // Teléfono
    jTextField14.setText(datos[4]); // Correo
    jTextField4.setText(datos[5]); // Dirección
}
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String cedula = jTextField1.getText().trim();
String nombre = jTextField2.getText().trim();
String apellido = jTextField3.getText().trim();
String direccion = jTextField4.getText().trim();
String telefono = jTextField5.getText().trim();

// Validación de campos obligatorios
if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Debe llenar todos los campos obligatorios (Cédula, Nombre, Apellido, Teléfono y Dirección).", "Campos obligatorios", JOptionPane.WARNING_MESSAGE);
    return;
}

// Generación automática del correo
String correo = nombre.toLowerCase().replace(" ", "") + "." + apellido.toLowerCase().replace(" ", "") + "@example.com";

boolean yaRegistrado = false;

// Verifica si ya existe la cédula
try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {
    String linea;
    while ((linea = br.readLine()) != null) {
        String[] datos = linea.split(",");
        if (datos.length > 0 && datos[0].equals(cedula)) {
            yaRegistrado = true;
            break;
        }
    }
} catch (IOException e) {
    JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

if (yaRegistrado) {
    JOptionPane.showMessageDialog(this, "Cliente ya registrado con esa cédula.", "Aviso", JOptionPane.WARNING_MESSAGE);
    return;
}

// Si no está registrado, lo guarda
try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.txt", true))) {
    bw.write(cedula + "," + nombre + "," + apellido + "," + telefono + "," + correo + "," + direccion);
    bw.newLine();
    JOptionPane.showMessageDialog(this, "Cliente guardado correctamente.");
} catch (IOException e) {
    JOptionPane.showMessageDialog(this, "Error al guardar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     actualizarNumeroFactura(); // Aumenta el número
    jTextField6.setText(obtenerNumeroFactura()); // Actualiza número
    jTextField7.setText(obtenerFechaActual());  // Actualiza fecha

    guardarFacturaTXT();  // Guarda archivo .txt
    guardarFacturaPDF();  // Guarda archivo .pdf
    limpiarFormulario(); // Limpia el formulario

    JOptionPane.showMessageDialog(this, "Factura generada y guardada.");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // Obtener datos de los JTextField
    String producto = jTextField8.getText().trim();       // nombre del producto
    String precioStr = jTextField9.getText().trim();      // precio unitario
    String cantidadStr = jTextField10.getText().trim();   // cantidad ingresada

    // Validar que los campos no estén vacíos
    if (producto.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Faltan datos del producto, precio o cantidad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        double precio = Double.parseDouble(precioStr);
        int cantidad = Integer.parseInt(cantidadStr);

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double subtotal = precio * cantidad;

        // Agregar a la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel(); // jTable1 es la tabla en tu diseño
        modelo.addRow(new Object[]{producto, cantidad, precio, subtotal});

        // Limpiar los campos para el siguiente producto
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        actualizarTotales();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Precio o cantidad no son válidos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     java.util.List<String[]> productos = leerProductosDesdeTXT();
    if (productos.isEmpty()) {
        return;
    }

    String[] opciones = new String[productos.size()];
    for (int i = 0; i < productos.size(); i++) {
        String[] p = productos.get(i);
        opciones[i] = "Producto: " + p[0] + "  |  Precio: $" + p[1] + "  |  Stock: " + p[2];
    }

    String seleccion = (String) JOptionPane.showInputDialog(
        this,
        "Selecciona un producto:",
        "Lista de Productos",
        JOptionPane.PLAIN_MESSAGE,
        null,
        opciones,
        opciones[0]
    );

    if (seleccion != null) {
        for (String[] p : productos) {
            if (seleccion.contains(p[0])) {
                jTextField8.setText(p[0]); // nombre del producto
                jTextField9.setText(p[1]); // precio
                jTextField10.setText("");   // cantidad
                break;
            }
        }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    // Limpia los datos del cliente 
        jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField14.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Formulario_Sistema_facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Sistema_facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Sistema_facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Sistema_facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Sistema_facturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
