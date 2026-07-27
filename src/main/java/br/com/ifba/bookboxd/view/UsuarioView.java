package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.usuario.controller.UsuarioController;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//permite que você encontre outros usuarios
@Component
public class UsuarioView extends javax.swing.JFrame {
    
    private final UsuarioController usuarioController;
    private final PerfilPublicoDialog perfilPublicoDialog;
    private Long usuarioLogadoId;
    
    @Autowired
    public UsuarioView(UsuarioController usuarioController, PerfilPublicoDialog perfilPublicoDialog) {
        this.usuarioController = usuarioController;
        this.perfilPublicoDialog = perfilPublicoDialog;
        initComponents();

        tblUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
        tblUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        tblUsuarios.getColumnModel().getColumn(0).setWidth(0);
    }
    
    public void configurarUsuario(Long usuarioLogadoId) {
        this.usuarioLogadoId = usuarioLogadoId;
    }
    
    public void atualizarLista() {
        txtBuscaUsuario.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
        modelo.setRowCount(0); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerPerfil = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblEditora = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtBuscaUsuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        cbFiltroUsuario = new javax.swing.JComboBox<>();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnVerPerfil.setText("VER PERFIL");
        btnVerPerfil.addActionListener(this::btnVerPerfilActionPerformed);

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));

        lblEditora.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lblEditora.setText("USUÁRIOS");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nome", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(2).setResizable(false);
        }

        cbFiltroUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Email" }));

        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtBuscaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBuscar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cbFiltroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnVerPerfil)
                                    .addGap(9, 9, 9))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(lblEditora)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblEditora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerPerfil)
                    .addComponent(cbFiltroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPerfilActionPerformed
        int linha = tblUsuarios.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário na tabela primeiro.",
                    "Nenhum usuário selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
        Long id = (Long) modelo.getValueAt(linha, 0);

        try {
            Usuario usuario = usuarioController.findById(id).orElseThrow();
            perfilPublicoDialog.mostrarPerfil(this, usuario, usuarioLogadoId); // usa o campo agora existente
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerPerfilActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String termo = txtBuscaUsuario.getText().trim();
        if (StringUtil.isEmpty(termo)) {
            JOptionPane.showMessageDialog(this, "Digite um nome ou email para buscar.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String filtro = cbFiltroUsuario.getSelectedItem().toString();
        try{
            if(filtro.equals("Nome")){
                List<Usuario> resultados = usuarioController.findByNome(termo);
                preencherTabela(resultados);
            } else {
                Optional<Usuario> resultado = usuarioController.findByEmail(termo);
                preencherTabela(resultado.map(List::of).orElse(List.of()));
            }
        } catch (RuntimeException e) {
            preencherTabela(List.of());
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Busca sem resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void preencherTabela(List<Usuario> usuarios) {
        DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
        modelo.setRowCount(0);
        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{u.getId(), u.getPessoa().getNome(), u.getEmail()});
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnVerPerfil;
    private javax.swing.JComboBox<String> cbFiltroUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEditora;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtBuscaUsuario;
    // End of variables declaration//GEN-END:variables
}
