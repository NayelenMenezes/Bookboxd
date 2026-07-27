package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.avaliacao.controller.AvaliacaoController;
import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.comentario.controller.ComentarioController;
import br.com.ifba.bookboxd.comentario.entity.Comentario;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//telinha que permite o usuario fazer comentarios em avaliações
@Component
public class ComentariosDialog extends javax.swing.JDialog {
    
    private final AvaliacaoController avaliacaoController;
    private final ComentarioController comentarioController;
    private final EditarTextoDialog editarTextoDialog;
    private Long avaliacaoId;
    private Long usuarioLogadoId;
    
    @Autowired
    public ComentariosDialog(AvaliacaoController avaliacaoController, ComentarioController comentarioController,
                          EditarTextoDialog editarTextoDialog) {
        super();
        setModal(true);
        setTitle("Comentários");
        this.avaliacaoController = avaliacaoController;
        this.comentarioController = comentarioController;
        this.editarTextoDialog = editarTextoDialog;
        initComponents();
        
        txtAvaliacaoResumo.setLineWrap(true);
        txtAvaliacaoResumo.setWrapStyleWord(true);
        txtAvaliacaoResumo.setEditable(false);
        
        txtNovoComentario.setLineWrap(true);
        txtNovoComentario.setWrapStyleWord(true);

        tblComentarios.getColumnModel().getColumn(0).setMinWidth(0);
        tblComentarios.getColumnModel().getColumn(0).setMaxWidth(0);
        tblComentarios.getColumnModel().getColumn(0).setWidth(0);
        
        tblComentarios.getColumnModel().getColumn(1).setMinWidth(0);
        tblComentarios.getColumnModel().getColumn(1).setMaxWidth(0);
        tblComentarios.getColumnModel().getColumn(1).setWidth(0);
    }

    public void mostrarComentarios(java.awt.Component parent, Long avaliacaoId, Long usuarioLogadoId) {
        this.avaliacaoId = avaliacaoId;
        this.usuarioLogadoId = usuarioLogadoId;
        txtNovoComentario.setText("");
        carregarComentarios();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
    
    private void carregarComentarios() {
        try {
            Avaliacao avaliacao = avaliacaoController.findById(avaliacaoId).orElseThrow();
            txtAvaliacaoResumo.setText(avaliacao.getUsuario().getPessoa().getNome()
                    + " avaliou com " + avaliacao.getNota() + " estrelas: \"" + avaliacao.getAvaliacao() + "\"");

            preencherTabela(avaliacao.getComentarios());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
    
    private void preencherTabela(List<Comentario> comentarios) {
        DefaultTableModel modelo = (DefaultTableModel) tblComentarios.getModel();
        modelo.setRowCount(0);
        for (Comentario c : comentarios) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getUsuario().getId(),
                c.getUsuario().getPessoa().getNome(),
                c.getTexto(),
                c.getDataComentario()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblComentarios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNovoComentario = new javax.swing.JTextArea();
        bntEnviar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAvaliacaoResumo = new javax.swing.JTextArea();
        btnEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblComentarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "usuID", "Usuario", "Texto", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblComentarios);
        if (tblComentarios.getColumnModel().getColumnCount() > 0) {
            tblComentarios.getColumnModel().getColumn(1).setResizable(false);
        }

        txtNovoComentario.setColumns(20);
        txtNovoComentario.setRows(5);
        jScrollPane2.setViewportView(txtNovoComentario);

        bntEnviar.setText("ENVIAR");
        bntEnviar.addActionListener(this::bntEnviarActionPerformed);

        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        txtAvaliacaoResumo.setColumns(20);
        txtAvaliacaoResumo.setRows(5);
        jScrollPane3.setViewportView(txtAvaliacaoResumo);

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 12)); // NOI18N
        jLabel1.setText("Escreva seu comentário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnFechar)
                        .addGap(108, 108, 108)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntEnviar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntEnviar)
                    .addComponent(btnFechar)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEnviarActionPerformed
        if (StringUtil.isEmpty(txtNovoComentario.getText())) {
            JOptionPane.showMessageDialog(this, "Escreva algo para comentar.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            avaliacaoController.adicionarComentario(avaliacaoId, usuarioLogadoId, txtNovoComentario.getText().trim());
            txtNovoComentario.setText("");
            carregarComentarios();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao comentar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bntEnviarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblComentarios.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um comentário primeiro.",
                    "Nenhum comentário selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblComentarios.getModel();
        Long comentarioId = (Long) modelo.getValueAt(linha, 0);
        Long autorDoComentarioId = (Long) modelo.getValueAt(linha, 1);
        String textoAtual = (String) modelo.getValueAt(linha, 3);

        if (!autorDoComentarioId.equals(usuarioLogadoId)) {
            JOptionPane.showMessageDialog(this, "Você só pode editar ou excluir os seus próprios comentários.",
                    "Ação não permitida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String novoTexto = editarTextoDialog.mostrarParaEditar(this, "Editar Comentário", textoAtual);

        switch (editarTextoDialog.getAcaoEscolhida()) {
            case SALVAR -> {
                try {
                    comentarioController.editarTexto(comentarioId, novoTexto);
                    JOptionPane.showMessageDialog(this, "Comentário atualizado com sucesso!",
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    carregarComentarios();
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao editar", JOptionPane.ERROR_MESSAGE);
                }
            }
            case DELETAR -> {
                try {
                    comentarioController.delete(comentarioId);
                    JOptionPane.showMessageDialog(this, "Comentário excluído com sucesso!",
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    carregarComentarios();
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao excluir", JOptionPane.ERROR_MESSAGE);
                }
            }
            case CANCELAR -> {
                
            }
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntEnviar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblComentarios;
    private javax.swing.JTextArea txtAvaliacaoResumo;
    private javax.swing.JTextArea txtNovoComentario;
    // End of variables declaration//GEN-END:variables
}
