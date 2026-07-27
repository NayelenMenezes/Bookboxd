package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Component;

//tela para editar comentario ou avaliações
@Component
public class EditarTextoDialog extends javax.swing.JDialog {
    
    public enum Acao {
        SALVAR, DELETAR, CANCELAR
    }
    
    private String resultado; 
    private Acao acaoEscolhida;

    public EditarTextoDialog() {
        super();
        setModal(true);
        initComponents();
        txtConteudo.setLineWrap(true);
        txtConteudo.setWrapStyleWord(true);
    }
    
    public String mostrarParaEditar(java.awt.Component parent, String tituloJanela, String textoAtual) {
        setTitle(tituloJanela);
        this.resultado = null;
        this.acaoEscolhida = Acao.CANCELAR;
        txtConteudo.setText(textoAtual);
        setLocationRelativeTo(parent);
        setVisible(true);
        return resultado;
    }
    
    public Acao getAcaoEscolhida() {
        return acaoEscolhida;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtConteudo = new javax.swing.JTextArea();
        btnSalvarTexto = new javax.swing.JButton();
        btnCancelarTexto = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtConteudo.setColumns(20);
        txtConteudo.setRows(5);
        jScrollPane1.setViewportView(txtConteudo);

        btnSalvarTexto.setText("SALVAR");
        btnSalvarTexto.addActionListener(this::btnSalvarTextoActionPerformed);

        btnCancelarTexto.setText("CANCELAR");
        btnCancelarTexto.addActionListener(this::btnCancelarTextoActionPerformed);

        btnDeletar.setText("DELETAR");
        btnDeletar.addActionListener(this::btnDeletarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnCancelarTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnSalvarTexto)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarTexto)
                    .addComponent(btnSalvarTexto)
                    .addComponent(btnDeletar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarTextoActionPerformed
        if (StringUtil.isEmpty(txtConteudo.getText())) {
            JOptionPane.showMessageDialog(this, "O texto não pode ficar vazio.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.resultado = txtConteudo.getText().trim();
        this.acaoEscolhida = Acao.SALVAR;
        dispose();
    }//GEN-LAST:event_btnSalvarTextoActionPerformed

    private void btnCancelarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTextoActionPerformed
        this.resultado = null;
        this.acaoEscolhida = Acao.CANCELAR;
        dispose();
    }//GEN-LAST:event_btnCancelarTextoActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja excluir isto? Esta ação não pode ser desfeita.",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        
        if (confirmacao == JOptionPane.YES_OPTION) {
            this.resultado = null;
            this.acaoEscolhida = Acao.DELETAR;
            dispose();
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarTexto;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvarTexto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtConteudo;
    // End of variables declaration//GEN-END:variables
}
