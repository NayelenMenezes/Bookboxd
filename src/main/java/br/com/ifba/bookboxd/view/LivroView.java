package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.infrastruture.util.SpringContextHolder;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.livro.controller.LivroIController;
import br.com.ifba.bookboxd.livro.entity.Livro;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//tela responsável pelos CRUDs de livro
@Component
public class LivroView extends javax.swing.JFrame {
    
    private final LivroIController livroController;
    private final LivroDetalheDialog livroDetalheDialog;
    private Long usuarioLogadoId;
    private boolean isAdmin;
    
    @Autowired
    public LivroView(LivroIController livroController, LivroDetalheDialog livroDetalheDialog) {
        this.livroController = livroController;
        this.livroDetalheDialog = livroDetalheDialog;
        initComponents();
        
        tblLivros.getColumnModel().getColumn(0).setMinWidth(0);
        tblLivros.getColumnModel().getColumn(0).setMaxWidth(0);
        tblLivros.getColumnModel().getColumn(0).setWidth(0);
        
        carregarTodosLivros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLivro = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLivros = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        cbFiltro = new javax.swing.JComboBox<>();
        btnVerDetalhes = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblLivro.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lblLivro.setText("LIVRO");

        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(this::btnCadastrarActionPerformed);

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnDeletar.setText("DELETAR");
        btnDeletar.addActionListener(this::btnDeletarActionPerformed);

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        tblLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Título", "ISBN", "Ano de Publicação", "Gênero", "Autor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLivros);

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));

        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Título", "Gênero", " " }));

        btnVerDetalhes.setText("VER DETALHES");
        btnVerDetalhes.addActionListener(this::btnVerDetalhesActionPerformed);

        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(lblLivro))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 271, Short.MAX_VALUE)
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnCadastrar)
                                .addGap(61, 61, 61)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeletar)
                                .addGap(45, 45, 45)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))))
                .addGap(16, 16, 16))
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnFechar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerDetalhes)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLivro)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar)
                    .addComponent(btnEditar)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerDetalhes)
                    .addComponent(btnFechar))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void configurarUsuario(Long usuarioLogadoId) {
        this.usuarioLogadoId = usuarioLogadoId;
    }
    
    public void configurarPermissoes(boolean isAdmin) {
        this.isAdmin = isAdmin;
        btnCadastrar.setVisible(isAdmin);
        btnEditar.setVisible(isAdmin);
        btnDeletar.setVisible(isAdmin);
       
    }
    
    public void atualizarLista(){
        txtBusca.setText("");
        carregarTodosLivros();
    }
    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        CadastroLivroDialog telaCadastro = SpringContextHolder.getBean(CadastroLivroDialog.class);
        telaCadastro.prepararParaNovoCadastro(this);
        telaCadastro.setVisible(true); 
        carregarTodosLivros();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String termo = txtBusca.getText().trim();
        
        // se o campo de busca estiver vazio, recarrega a lista completa
        if(StringUtil.isEmpty(termo)){
            carregarTodosLivros();
            return;
        }
        
        String filtro = cbFiltro.getSelectedItem().toString();
        
        try{
            List<Livro> resultados = filtro.equals("Título")
                    ? livroController.findByTitulo(termo)
                    : livroController.findByGenero(termo);
            
            preencherTabela(resultados);
        } catch (RuntimeException e){
            preencherTabela(List.of());
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Busca sem resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    // remove o livro selecionado após confirmação do usuário
    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        Livro selecionado = getLivroSelecionado();
        if (selecionado == null) return;
       
        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja deletar o livro:\n\"" + selecionado.getTitulo() + "\"?\n\nEsta ação não pode ser desfeita.",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
                
        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                livroController.delete(selecionado.getId());
                JOptionPane.showMessageDialog(this, "Livro deletado com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                carregarTodosLivros();
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(),
                        "Erro ao deletar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed
    
    // abre a tela de edição já com o livro selecionado
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Livro selecionado = getLivroSelecionado();
        if (selecionado == null) return;
 
        EdicaoLivroDialog dialog = SpringContextHolder.getBean(EdicaoLivroDialog.class);
        dialog.prepararParaEdicao(this, selecionado);
        dialog.setVisible(true);
        carregarTodosLivros();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVerDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalhesActionPerformed
        Livro selecionado = getLivroSelecionado();
        if (selecionado == null) return;

        livroDetalheDialog.mostrarDetalhes(this, selecionado, usuarioLogadoId);
        carregarTodosLivros();
    }//GEN-LAST:event_btnVerDetalhesActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed
    
    // identifica qual linha da tabela tá selecionada e busca o Livro correspondente
    private Livro getLivroSelecionado() {
        int linhaSelecionada = tblLivros.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecione um livro na tabela primeiro.",
                    "Nenhum livro selecionado",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblLivros.getModel();
        Long id = (Long) modelo.getValueAt(linhaSelecionada, 0);

        try {
            return livroController.findById(id).orElse(null);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    // busca todos os registros do banco e envia para preenchimento da tabela
    private void carregarTodosLivros() {
        try {
            List<Livro> livros = livroController.findAll();
            preencherTabela(livros);
        } catch (RuntimeException e) {
            preencherTabela(List.of());
        }
    }
    
    // limpa a tabela e insere as linhas com as informações da lista de livros
    private void preencherTabela(List<Livro> livros) {
        DefaultTableModel modelo = (DefaultTableModel) tblLivros.getModel();
        modelo.setRowCount(0);

        for (Livro l : livros) {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getTitulo(),
                l.getIsbn(),
                l.getAnoPublicacao(),
                l.getGenero(),
                l.getAutor().getPessoa().getNome()
            });
        }
    } 
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnVerDetalhes;
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblLivro;
    private javax.swing.JTable tblLivros;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
