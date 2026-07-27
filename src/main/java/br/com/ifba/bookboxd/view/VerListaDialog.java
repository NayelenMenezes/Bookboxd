package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.listaleitra.entity.ListaLeitura;
import br.com.ifba.bookboxd.listaleitura.controller.ListaLeituraController;
import br.com.ifba.bookboxd.livro.entity.Livro;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//telinha que exibe as listas de leitura
@Component
public class VerListaDialog extends javax.swing.JDialog {
    
    private final ListaLeituraController listaController;
    private final BuscaLivroDialog buscaLivroDialog;
    private Long listaId;
    private Long usuarioLogadoId;
    
    @Autowired
    public VerListaDialog(ListaLeituraController listaController, BuscaLivroDialog buscaLivroDialog) {
        super();
        setModal(true);
        setTitle("Detalhes da Lista");
        this.listaController = listaController;
        this.buscaLivroDialog = buscaLivroDialog;
        initComponents();
        
        txtDescricaoLista.setLineWrap(true);
        txtDescricaoLista.setWrapStyleWord(true);
        txtDescricaoLista.setEditable(false);
        
        tblLivrosDaLista.getColumnModel().getColumn(0).setMinWidth(0);
        tblLivrosDaLista.getColumnModel().getColumn(0).setMaxWidth(0);
        tblLivrosDaLista.getColumnModel().getColumn(0).setWidth(0);
    }

    public void mostrarLista(java.awt.Component parent, Long listaId, boolean somenteLeitura, Long usuarioLogadoId) {
        this.listaId = listaId;
        this.usuarioLogadoId = usuarioLogadoId;
        carregarLista();

        btnAdicionarLivro.setVisible(!somenteLeitura);
        btnRemoverLivro.setVisible(!somenteLeitura);
        btnEsvaziarLista.setVisible(!somenteLeitura);
        btnCopiarLista.setVisible(somenteLeitura); 

        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void carregarLista() {
        try {
            ListaLeitura lista = listaController.findById(listaId).orElseThrow();
            lblNomeLista.setText(lista.getNomeLista());
            txtDescricaoLista.setText(lista.getDescricao() != null ? lista.getDescricao() : "Sem descrição");
            preencherTabela(lista.getListaLivros());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
    
    private void preencherTabela(java.util.List<Livro> livros) {
        DefaultTableModel modelo = (DefaultTableModel) tblLivrosDaLista.getModel();
        modelo.setRowCount(0);
        for (Livro l : livros) {
            modelo.addRow(new Object[]{l.getId(), l.getTitulo(), l.getGenero()});
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeLista = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLivrosDaLista = new javax.swing.JTable();
        btnAdicionarLivro = new javax.swing.JButton();
        btnRemoverLivro = new javax.swing.JButton();
        btnEsvaziarLista = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricaoLista = new javax.swing.JTextArea();
        btnCopiarLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNomeLista.setText("Nome lista");

        tblLivrosDaLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Título", "Gênero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLivrosDaLista);

        btnAdicionarLivro.setText("ADICIONAR LIVRO");
        btnAdicionarLivro.addActionListener(this::btnAdicionarLivroActionPerformed);

        btnRemoverLivro.setText("REMOVER LIVRO");
        btnRemoverLivro.addActionListener(this::btnRemoverLivroActionPerformed);

        btnEsvaziarLista.setText("ESVAZIAR LISTA");
        btnEsvaziarLista.addActionListener(this::btnEsvaziarListaActionPerformed);

        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        txtDescricaoLista.setColumns(20);
        txtDescricaoLista.setRows(5);
        jScrollPane2.setViewportView(txtDescricaoLista);

        btnCopiarLista.setText("COPIAR LISTA");
        btnCopiarLista.addActionListener(this::btnCopiarListaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCopiarLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdicionarLivro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnRemoverLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEsvaziarLista))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(btnFechar)))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomeLista, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblNomeLista)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarLivro)
                    .addComponent(btnEsvaziarLista)
                    .addComponent(btnRemoverLivro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnCopiarLista))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarLivroActionPerformed
        Livro escolhido = buscaLivroDialog.mostrarESelecionar(this);
        if(escolhido == null) return;
        
        try {
            listaController.adicionarLivro(listaId, escolhido.getId());
            carregarLista();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarLivroActionPerformed

    private void btnRemoverLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverLivroActionPerformed
        int linha = tblLivrosDaLista.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um livro para remover.",
                    "Nenhum livro selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tblLivrosDaLista.getModel();
        Long livroId = (Long) modelo.getValueAt(linha, 0);
        
        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Certeza que quer remover esse livro?", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirmacao != JOptionPane.YES_OPTION) return;
        
        try {
            listaController.removerLivro(listaId, livroId);
            carregarLista();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoverLivroActionPerformed

    private void btnEsvaziarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsvaziarListaActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Remover todos os livros desta lista?", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirmacao != JOptionPane.YES_OPTION) return;
        
         try {
            listaController.esvaziarLista(listaId);
            carregarLista();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEsvaziarListaActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnCopiarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarListaActionPerformed
        String nomeSugerido = "Cópia de " + lblNomeLista.getText();
        String nome = JOptionPane.showInputDialog(this, "Nome da nova lista:", nomeSugerido);

        if (nome == null) return; 

        try {
            listaController.copiarLista(listaId, usuarioLogadoId, nome.trim());
            JOptionPane.showMessageDialog(this, "Lista copiada com sucesso para o seu perfil!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao copiar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCopiarListaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarLivro;
    private javax.swing.JButton btnCopiarLista;
    private javax.swing.JButton btnEsvaziarLista;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRemoverLivro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNomeLista;
    private javax.swing.JTable tblLivrosDaLista;
    private javax.swing.JTextArea txtDescricaoLista;
    // End of variables declaration//GEN-END:variables
}
