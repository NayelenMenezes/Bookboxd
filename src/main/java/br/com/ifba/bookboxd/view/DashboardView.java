package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.autor.controller.AutorController;
import br.com.ifba.bookboxd.editora.contoller.EditoraController;
import br.com.ifba.bookboxd.livro.controller.LivroController;
import br.com.ifba.bookboxd.usuario.controller.UsuarioController;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import br.com.ifba.bookboxd.infrastruture.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//tela de dashboard
@Component
public class DashboardView extends javax.swing.JFrame {
    
    private Usuario usuarioLogado;
    private final UsuarioController usuarioController;
    private final LivroController livroController;
    private final AutorController autorController;
    private final EditoraController editoraController;
    
    @Autowired
    public DashboardView(UsuarioController usuarioController, LivroController livroController,
                        AutorController autorController, EditoraController editoraController) {
        this.usuarioController = usuarioController;
        this.livroController = SpringContextHolder.getBean(LivroController.class);
        this.autorController   = SpringContextHolder.getBean(AutorController.class);
        this.editoraController = SpringContextHolder.getBean(EditoraController.class);
        
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblBemVindo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnPerfil = new javax.swing.JButton();
        btnLivros = new javax.swing.JButton();
        btnAutor = new javax.swing.JButton();
        btnEditoras = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Serif", 0, 32)); // NOI18N
        lblTitulo.setText("BOOKBOXD - DASHBOARD");

        lblBemVindo.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lblBemVindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBemVindo.setText("BEM-VINDO");

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));

        btnPerfil.setText("MEU PERFIL");
        btnPerfil.addActionListener(this::btnPerfilActionPerformed);

        btnLivros.setText("LIVROS");
        btnLivros.addActionListener(this::btnLivrosActionPerformed);

        btnAutor.setText("AUTORES");
        btnAutor.addActionListener(this::btnAutorActionPerformed);

        btnEditoras.setText("EDITORAS");
        btnEditoras.addActionListener(this::btnEditorasActionPerformed);

        btnUsuarios.setText("USUÁRIOS");
        btnUsuarios.addActionListener(this::btnUsuariosActionPerformed);

        btnSair.setBackground(new java.awt.Color(239, 6, 8));
        btnSair.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(102, 0, 0));
        btnSair.setText("SAIR");
        btnSair.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 0)));
        btnSair.addActionListener(this::btnSairActionPerformed);

        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnPerfil)
                .addGap(31, 31, 31)
                .addComponent(btnLivros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAutor)
                .addGap(42, 42, 42)
                .addComponent(btnEditoras)
                .addGap(50, 50, 50)
                .addComponent(btnUsuarios)
                .addGap(40, 40, 40))
            .addComponent(jSeparator2)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBemVindo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerfil)
                    .addComponent(btnLivros)
                    .addComponent(btnAutor)
                    .addComponent(btnEditoras)
                    .addComponent(btnUsuarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void configurarUsuarioLogado(Usuario usuario){
        this.usuarioLogado = usuario;
        lblBemVindo.setText("BEM-VINDO(A), " + usuario.getPessoa().getNome().toUpperCase());
    }
    
    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        PerfilView perfil = SpringContextHolder.getBean(PerfilView.class);
        perfil.configurarUsuario(usuarioLogado);
        perfil.setLocationRelativeTo(this);
        perfil.setVisible(true);
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLivrosActionPerformed
        LivroView livrosView = SpringContextHolder.getBean(LivroView.class);
        livrosView.configurarUsuario(usuarioLogado.getId());
        livrosView.configurarPermissoes(usuarioLogado.isAdministrador());
        livrosView.atualizarLista();
        livrosView.setLocationRelativeTo(this);
        livrosView.setVisible(true);
    }//GEN-LAST:event_btnLivrosActionPerformed

    private void btnAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorActionPerformed
        AutorView autorView = SpringContextHolder.getBean(AutorView.class);
        autorView.configurarPermissoes(usuarioLogado.isAdministrador());
        autorView.atualizarLista();
        autorView.setLocationRelativeTo(this);
        autorView.setVisible(true);
    }//GEN-LAST:event_btnAutorActionPerformed

    private void btnEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditorasActionPerformed
        EditoraView editoraView = SpringContextHolder.getBean(EditoraView.class);
        editoraView.configurarPermissoes(usuarioLogado.isAdministrador());
        editoraView.atualizarLista();
        editoraView.setLocationRelativeTo(this);
        editoraView.setVisible(true);
    }//GEN-LAST:event_btnEditorasActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        UsuarioView usuarioView = SpringContextHolder.getBean(UsuarioView.class);
        usuarioView.configurarUsuario(usuarioLogado.getId()); 
        usuarioView.atualizarLista();
        usuarioView.setLocationRelativeTo(this);
        usuarioView.setVisible(true);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        LoginView loginView = SpringContextHolder.getBean(LoginView.class);
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
        loginView.limparCampos();
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutor;
    private javax.swing.JButton btnEditoras;
    private javax.swing.JButton btnLivros;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
