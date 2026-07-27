package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.autor.controller.AutorController;
import br.com.ifba.bookboxd.autor.entity.Autor;
import br.com.ifba.bookboxd.livro.entity.Livro;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//exibe o perfil do autor
@Component
public class AutorPerfilDialog extends javax.swing.JDialog {
    
    private final AutorController autorController;
    
   @Autowired
    public AutorPerfilDialog(AutorController autorController) {
        super();
        setModal(true);
        setTitle("Perfil do Autor");
        this.autorController = autorController;
        initComponents();
        
        txtBiografia.setLineWrap(true);
        txtBiografia.setWrapStyleWord(true);
        txtBiografia.setEditable(false);
        
        tblLivrosAutor.getColumnModel().getColumn(0).setMinWidth(0);
        tblLivrosAutor.getColumnModel().getColumn(0).setMaxWidth(0);
        tblLivrosAutor.getColumnModel().getColumn(0).setWidth(0);
    }

    public void mostrarPerfil(java.awt.Component parent, Autor autor) {
        lblNomeAutor.setText(autor.getPessoa().getNome());
        lblNacionalidade.setText(autor.getNacionalidade());
        txtBiografia.setText(autor.getPessoa().getBiografia() != null
                ? autor.getPessoa().getBiografia() : "Sem biografia");

        preencherTabela(autor.getLivros());
        setLocationRelativeTo(parent);
        setVisible(true);
    }
    
    private void preencherTabela(java.util.List<Livro> livros) {
        DefaultTableModel modelo = (DefaultTableModel) tblLivrosAutor.getModel();
        modelo.setRowCount(0);
        for (Livro l : livros) {
            String editoraNome = l.getEditora() != null ? l.getEditora().getNome() : "Sem editora";
            String notaMedia = String.format("%.1f", l.calcularMediaAvaliacao());
            modelo.addRow(new Object[]{l.getId(), l.getTitulo(), notaMedia, editoraNome});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeAutor = new javax.swing.JLabel();
        lblNacionalidade = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLivrosAutor = new javax.swing.JTable();
        btnFecharPerfilAutor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBiografia = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNomeAutor.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lblNomeAutor.setText("nome");

        lblNacionalidade.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        lblNacionalidade.setText("nacionalidae");

        tblLivrosAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Título", "Nota Media", "Editora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLivrosAutor);

        btnFecharPerfilAutor.setText("FECHAR");
        btnFecharPerfilAutor.addActionListener(this::btnFecharPerfilAutorActionPerformed);

        txtBiografia.setColumns(20);
        txtBiografia.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        txtBiografia.setRows(5);
        jScrollPane2.setViewportView(txtBiografia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFecharPerfilAutor)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNacionalidade, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(lblNomeAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblNomeAutor)
                .addGap(22, 22, 22)
                .addComponent(lblNacionalidade)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFecharPerfilAutor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharPerfilAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharPerfilAutorActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharPerfilAutorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFecharPerfilAutor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNacionalidade;
    private javax.swing.JLabel lblNomeAutor;
    private javax.swing.JTable tblLivrosAutor;
    private javax.swing.JTextArea txtBiografia;
    // End of variables declaration//GEN-END:variables
}
