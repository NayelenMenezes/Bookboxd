package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.autor.controller.AutorController;
import br.com.ifba.bookboxd.autor.entity.Autor;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//responsavel pelos CRUDs de autor
@Component
public class AutorView extends javax.swing.JFrame {
    
    private final AutorController autorController;
    private final CadastroAutorDialog cadastroAutorDialog;
    private final EdicaoAutorDialog edicaoAutorDialog;
    private final AutorPerfilDialog autorPerfilDialog;
    private boolean isAdmin;
    
    @Autowired
    public AutorView(AutorController autorController, CadastroAutorDialog cadastroAutorDialog,
                      EdicaoAutorDialog edicaoAutorDialog, AutorPerfilDialog autorPerfilDialog) {
        this.autorController = autorController;
        this.cadastroAutorDialog = cadastroAutorDialog;
        this.edicaoAutorDialog = edicaoAutorDialog;
        this.autorPerfilDialog = autorPerfilDialog;
        initComponents();
        
        tblAutores.getColumnModel().getColumn(0).setMinWidth(0);
        tblAutores.getColumnModel().getColumn(0).setMaxWidth(0);
        tblAutores.getColumnModel().getColumn(0).setWidth(0);

        carregarTodosAutores();
    }
    
    public void configurarPermissoes(boolean isAdmin) {
        btnCadastrar.setVisible(isAdmin);
        btnEditar.setVisible(isAdmin);
        btnDeletar.setVisible(isAdmin);
    }
    
    public void atualizarLista() {
        txtBuscaAutor.setText("");
        carregarTodosAutores();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lblAutor = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscaAutor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAutores = new javax.swing.JTable();
        btnVerPerfil = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));

        lblAutor.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lblAutor.setText("AUTOR");

        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(this::btnCadastrarActionPerformed);

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnDeletar.setText("DELETAR");
        btnDeletar.addActionListener(this::btnDeletarActionPerformed);

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        tblAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nome", "Nacionalidae", "Qtd. Livros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAutores);

        btnVerPerfil.setText("VER PERFIL");
        btnVerPerfil.addActionListener(this::btnVerPerfilActionPerformed);

        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVerPerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addGap(124, 124, 124)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeletar)
                        .addGap(47, 47, 47))))
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(lblAutor)
                .addGap(31, 31, 31))
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAutor)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVerPerfil, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnDeletar)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastroAutorDialog.prepararParaNovoCadastro(this);
        cadastroAutorDialog.setVisible(true);
        carregarTodosAutores();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Autor selecionado = getAutorSelecionado();
        if (selecionado == null) return;

        edicaoAutorDialog.prepararParaEdicao(this, selecionado);
        edicaoAutorDialog.setVisible(true);
        carregarTodosAutores();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        Autor selecionado = getAutorSelecionado();
        if (selecionado == null) return;

        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja deletar o autor:\n\"" + selecionado.getPessoa().getNome() + "\"?",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                autorController.delete(selecionado.getId());
                JOptionPane.showMessageDialog(this, "Autor deletado com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                carregarTodosAutores();
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao deletar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String termo = txtBuscaAutor.getText().trim();
        if (StringUtil.isEmpty(termo)) {
            carregarTodosAutores();
            return;
        }
        try {
            List<Autor> resultados = autorController.findByNomePessoa(termo);
            preencherTabela(resultados);
        } catch (RuntimeException e) {
            preencherTabela(List.of());
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Busca sem resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVerPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPerfilActionPerformed
        Autor selecionado = getAutorSelecionado();
        if (selecionado == null) return;

        autorPerfilDialog.mostrarPerfil(this, selecionado);
    }//GEN-LAST:event_btnVerPerfilActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed
    
    private Autor getAutorSelecionado() {
        int linha = tblAutores.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um autor na tabela primeiro.",
                    "Nenhum autor selecionado", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        DefaultTableModel modelo = (DefaultTableModel) tblAutores.getModel();
        Long id = (Long) modelo.getValueAt(linha, 0);

        try {
            return autorController.findById(id).orElse(null);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void carregarTodosAutores() {
        try {
            preencherTabela(autorController.findAll());
        } catch (RuntimeException e) {
            preencherTabela(List.of());
        }
    }

    private void preencherTabela(List<Autor> autores) {
        DefaultTableModel modelo = (DefaultTableModel) tblAutores.getModel();
        modelo.setRowCount(0);
        for (Autor a : autores) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getPessoa().getNome(),
                a.getNacionalidade(),
                a.contarLivrosPublicados() + " livro(s)"
            });
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnVerPerfil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JTable tblAutores;
    private javax.swing.JTextField txtBuscaAutor;
    // End of variables declaration//GEN-END:variables
}
