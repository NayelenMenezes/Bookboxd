package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.avaliacao.controller.AvaliacaoController;
import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.listaleitura.controller.ListaLeituraController;
import br.com.ifba.bookboxd.usuario.controller.UsuarioController;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import br.com.ifba.bookboxd.infrastruture.util.StringUtil;
import br.com.ifba.bookboxd.listaleitra.entity.ListaLeitura;
import br.com.ifba.bookboxd.livro.entity.Livro;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//exibe o perfil do usuario
@Component
public class PerfilView extends javax.swing.JDialog {
    
    private Usuario usuarioLogado;
    private final UsuarioController usuarioController;
    private final AvaliacaoController avaliacaoController;
    private final ListaLeituraController listaController;
    private final BuscaLivroDialog buscaLivroDialog;
    private final NovaAvaliacaoDialog novaAvaliacaoDialog;
    private final NovaListaDialog novaListaDialog;
    private final VerListaDialog verListaDialog;
    private final EditarTextoDialog editarTextoDialog;
    private final AlterarSenhaDialog alterarSenhaDialog;

    @Autowired
    public PerfilView(UsuarioController usuarioController, AvaliacaoController avaliacaoController,
                       ListaLeituraController listaController, BuscaLivroDialog buscaLivroDialog,
                       NovaAvaliacaoDialog novaAvaliacaoDialog, NovaListaDialog novaListaDialog,
                        VerListaDialog verListaDialog, EditarTextoDialog editarTextoDialog,
                        AlterarSenhaDialog alterarSenhaDialog) {
        super();
        setModal(true);
        setTitle("Meu Perfil");
        this.usuarioController = usuarioController;
        this.avaliacaoController = avaliacaoController;
        this.listaController = listaController;
        this.buscaLivroDialog = buscaLivroDialog;
        this.novaAvaliacaoDialog = novaAvaliacaoDialog;
        this.novaListaDialog = novaListaDialog;
        this.verListaDialog = verListaDialog;
        this.editarTextoDialog = editarTextoDialog;
        this.alterarSenhaDialog = alterarSenhaDialog;

        initComponents();
        
        txtBiografiaExibicao.setLineWrap(true);
        txtBiografiaExibicao.setWrapStyleWord(true);
        txtBiografiaExibicao.setEditable(false);
        
        txtBiografia.setLineWrap(true);
        txtBiografia.setWrapStyleWord(true);

        tblAvaliacoes.getColumnModel().getColumn(0).setMinWidth(0);
        tblAvaliacoes.getColumnModel().getColumn(0).setMaxWidth(0);
        tblAvaliacoes.getColumnModel().getColumn(0).setWidth(0);

        tblListas.getColumnModel().getColumn(0).setMinWidth(0);
        tblListas.getColumnModel().getColumn(0).setMaxWidth(0);
        tblListas.getColumnModel().getColumn(0).setWidth(0);
    }

    public void configurarUsuario(Usuario usuario) {
       this.usuarioLogado = usuario;
        carregarDadosPerfil();
        carregarAvaliacoes();
        carregarListas();
    }
    
    private void carregarDadosPerfil(){
        lblNomeExibicao.setText(usuarioLogado.getPessoa().getNome());
        lblIdadeExibicao.setText("Idade: " + usuarioLogado.getPessoa().obterIdade() + " anos");
        
        txtBiografiaExibicao.setText(usuarioLogado.getPessoa().getBiografia() != null
                ? usuarioLogado.getPessoa().getBiografia() : "Sem biografia");
        
        txtNome.setText(usuarioLogado.getPessoa().getNome());
        txtBiografia.setText(usuarioLogado.getPessoa().getBiografia());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        panelPerfil = new javax.swing.JPanel();
        lblNomeExibicao = new javax.swing.JLabel();
        lblIdadeExibicao = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtBiografiaExibicao = new javax.swing.JTextArea();
        panelEditarPerfil = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblBiografia = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvarEdicao = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtBiografia = new javax.swing.JTextArea();
        btnAlterarSenha = new javax.swing.JButton();
        panelAvaliacoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAvaliacoes = new javax.swing.JTable();
        btnNovaAvaliacao = new javax.swing.JButton();
        btnEditarAvaliacao = new javax.swing.JButton();
        panelListas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListas = new javax.swing.JTable();
        btnNovaLista = new javax.swing.JButton();
        btnAdicionarLivroNaLista = new javax.swing.JButton();
        btnVerLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNomeExibicao.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lblNomeExibicao.setText("nome");

        lblIdadeExibicao.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lblIdadeExibicao.setText("idade");

        txtBiografiaExibicao.setColumns(20);
        txtBiografiaExibicao.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        txtBiografiaExibicao.setRows(5);
        jScrollPane4.setViewportView(txtBiografiaExibicao);

        javax.swing.GroupLayout panelPerfilLayout = new javax.swing.GroupLayout(panelPerfil);
        panelPerfil.setLayout(panelPerfilLayout);
        panelPerfilLayout.setHorizontalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdadeExibicao)
                    .addComponent(lblNomeExibicao, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        panelPerfilLayout.setVerticalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblNomeExibicao)
                .addGap(55, 55, 55)
                .addComponent(lblIdadeExibicao)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Perfil", panelPerfil);

        lblNome.setText("NOME");

        lblBiografia.setText("BIOGRAFIA");

        btnSalvarEdicao.setText("SALVAR PERFIL");
        btnSalvarEdicao.addActionListener(this::btnSalvarEdicaoActionPerformed);

        txtBiografia.setColumns(20);
        txtBiografia.setRows(5);
        jScrollPane3.setViewportView(txtBiografia);

        btnAlterarSenha.setText("ALTERAR SENHA");
        btnAlterarSenha.addActionListener(this::btnAlterarSenhaActionPerformed);

        javax.swing.GroupLayout panelEditarPerfilLayout = new javax.swing.GroupLayout(panelEditarPerfil);
        panelEditarPerfil.setLayout(panelEditarPerfilLayout);
        panelEditarPerfilLayout.setHorizontalGroup(
            panelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarPerfilLayout.createSequentialGroup()
                .addGroup(panelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditarPerfilLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(panelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBiografia)
                            .addComponent(lblNome))
                        .addGap(66, 66, 66)
                        .addGroup(panelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(txtNome)))
                    .addGroup(panelEditarPerfilLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(panelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAlterarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(btnSalvarEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        panelEditarPerfilLayout.setVerticalGroup(
            panelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarPerfilLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBiografia)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(btnSalvarEdicao)
                .addGap(38, 38, 38)
                .addComponent(btnAlterarSenha)
                .addGap(31, 31, 31))
        );

        jTabbedPane2.addTab("Editar Perfil", panelEditarPerfil);

        tblAvaliacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Livro", "Nota", "Texto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAvaliacoes);
        if (tblAvaliacoes.getColumnModel().getColumnCount() > 0) {
            tblAvaliacoes.getColumnModel().getColumn(2).setResizable(false);
            tblAvaliacoes.getColumnModel().getColumn(3).setResizable(false);
        }

        btnNovaAvaliacao.setText("NOVA AVALIAÇÃO");
        btnNovaAvaliacao.addActionListener(this::btnNovaAvaliacaoActionPerformed);

        btnEditarAvaliacao.setText("EDITAR AVALIAÇÃO");
        btnEditarAvaliacao.addActionListener(this::btnEditarAvaliacaoActionPerformed);

        javax.swing.GroupLayout panelAvaliacoesLayout = new javax.swing.GroupLayout(panelAvaliacoes);
        panelAvaliacoes.setLayout(panelAvaliacoesLayout);
        panelAvaliacoesLayout.setHorizontalGroup(
            panelAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAvaliacoesLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnEditarAvaliacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovaAvaliacao)
                .addGap(40, 40, 40))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );
        panelAvaliacoesLayout.setVerticalGroup(
            panelAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvaliacoesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(panelAvaliacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarAvaliacao)
                    .addComponent(btnNovaAvaliacao))
                .addGap(17, 17, 17))
        );

        jTabbedPane2.addTab("Minhas Avaliações", panelAvaliacoes);

        tblListas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nome", "Qnt. Livros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblListas);

        btnNovaLista.setText("NOVA LISTA");
        btnNovaLista.addActionListener(this::btnNovaListaActionPerformed);

        btnAdicionarLivroNaLista.setText("ADICIONAR LIVROS");
        btnAdicionarLivroNaLista.addActionListener(this::btnAdicionarLivroNaListaActionPerformed);

        btnVerLista.setText("VER LISTA");
        btnVerLista.addActionListener(this::btnVerListaActionPerformed);

        javax.swing.GroupLayout panelListasLayout = new javax.swing.GroupLayout(panelListas);
        panelListas.setLayout(panelListasLayout);
        panelListasLayout.setHorizontalGroup(
            panelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListasLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnAdicionarLivroNaLista)
                .addGap(80, 80, 80)
                .addComponent(btnVerLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovaLista)
                .addGap(46, 46, 46))
        );
        panelListasLayout.setVerticalGroup(
            panelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovaLista)
                    .addComponent(btnAdicionarLivroNaLista)
                    .addComponent(btnVerLista))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Listas de Leitura", panelListas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarEdicaoActionPerformed
        if (StringUtil.isEmpty(txtNome.getText())){
            JOptionPane.showMessageDialog(this, "O nome não pode ser vazio.",
                    "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocus();
            return;
        }
        
        try{
            usuarioController.editarPerfil(usuarioLogado.getId(), txtNome.getText().trim(), txtBiografia.getText().trim());
            JOptionPane.showMessageDialog(this, "Perfil atualizado com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            carregarDadosPerfil(); 
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao atualizar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarEdicaoActionPerformed

    private void carregarAvaliacoes(){
        try {
            List<Avaliacao> avaliacoes = avaliacaoController.findByUsuarioId(usuarioLogado.getId());
            preencherTabelaAvaliacoes(avaliacoes);
        }catch (RuntimeException e){
             preencherTabelaAvaliacoes(List.of());
        }
    }
    
    private void  preencherTabelaAvaliacoes (List<Avaliacao> avaliacoes){
        DefaultTableModel modelo = (DefaultTableModel) tblAvaliacoes.getModel();
        modelo.setRowCount(0);
        for (Avaliacao a : avaliacoes) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getLivro().getTitulo(),
                a.getNota() + " estrelas",
                a.getAvaliacao()
            });
        }
    }
    
    private void btnNovaAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaAvaliacaoActionPerformed
        Livro livroEscolhido = buscaLivroDialog.mostrarESelecionar(this);
        if(livroEscolhido == null) return;
        
        boolean criada = novaAvaliacaoDialog.mostrarParaCriar(this, usuarioLogado.getId(), livroEscolhido);
        if(criada) {
            carregarAvaliacoes();
        }
    }//GEN-LAST:event_btnNovaAvaliacaoActionPerformed

    private void carregarListas(){
        try {
            List<ListaLeitura> listas = listaController.findByUsuarioId(usuarioLogado.getId());
            preencherTabelaListas(listas);
        } catch (RuntimeException e) {
            preencherTabelaListas(List.of());
        }
    }
    
    private void preencherTabelaListas(List<ListaLeitura> listas){
        DefaultTableModel modelo = (DefaultTableModel) tblListas.getModel();
        modelo.setRowCount(0);
        for (ListaLeitura l : listas) {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getNomeLista(),
                l.getListaLivros().size() + " livro(s)"
            });
        }
    }
    
    private void btnNovaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaListaActionPerformed
        boolean criada = novaListaDialog.mostrarParaCriar(this, usuarioLogado.getId());
        if (criada) {
            carregarListas();
        }
    }//GEN-LAST:event_btnNovaListaActionPerformed

    private void btnAdicionarLivroNaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarLivroNaListaActionPerformed
        Long listaId = getListaSelecionadaId();
        if (listaId == null) return;
        
        Livro livroEscolhido = buscaLivroDialog.mostrarESelecionar(this);
        if (livroEscolhido == null) return;
        
        try {
            listaController.adicionarLivro(listaId, livroEscolhido.getId());
            JOptionPane.showMessageDialog(this, "Livro adicionado à lista!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            carregarListas();
        } catch (RuntimeException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarLivroNaListaActionPerformed

    private void btnVerListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerListaActionPerformed
        Long listaId = getListaSelecionadaId();
        if (listaId == null) return;

        verListaDialog.mostrarLista(this, listaId, false, usuarioLogado.getId());
        carregarListas();
    }//GEN-LAST:event_btnVerListaActionPerformed

    private void btnEditarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAvaliacaoActionPerformed
        int linha = tblAvaliacoes.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma avaliação primeiro.",
                    "Nenhuma avaliação selecionada", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tblAvaliacoes.getModel();
        Long avaliacaoId = (Long) modelo.getValueAt(linha, 0);
        String textoAtual = (String) modelo.getValueAt(linha, 3);

        String novoTexto = editarTextoDialog.mostrarParaEditar(this, "Editar Avaliação", textoAtual);

        switch (editarTextoDialog.getAcaoEscolhida()) {
            case SALVAR -> {
                try {
                    avaliacaoController.editarTexto(avaliacaoId, novoTexto);
                    JOptionPane.showMessageDialog(this, "Avaliação atualizada com sucesso!",
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    carregarAvaliacoes();
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao editar", JOptionPane.ERROR_MESSAGE);
                }
            }
            case DELETAR -> {
                try {
                    avaliacaoController.delete(avaliacaoId);
                    JOptionPane.showMessageDialog(this, "Avaliação excluída com sucesso!",
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    carregarAvaliacoes();
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao excluir", JOptionPane.ERROR_MESSAGE);
                }
            }
            case CANCELAR -> {
                
            }
        }
    }//GEN-LAST:event_btnEditarAvaliacaoActionPerformed

    private void btnAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarSenhaActionPerformed
        alterarSenhaDialog.mostrarParaAlterar(this, usuarioLogado.getId());
    }//GEN-LAST:event_btnAlterarSenhaActionPerformed
    
    private Long getListaSelecionadaId(){
        int linha = tblListas.getSelectedRow();
        if(linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma lista primeiro.",
                    "Nenhuma lista selecionada", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        DefaultTableModel modelo = (DefaultTableModel) tblListas.getModel();
        return (Long) modelo.getValueAt(linha, 0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarLivroNaLista;
    private javax.swing.JButton btnAlterarSenha;
    private javax.swing.JButton btnEditarAvaliacao;
    private javax.swing.JButton btnNovaAvaliacao;
    private javax.swing.JButton btnNovaLista;
    private javax.swing.JButton btnSalvarEdicao;
    private javax.swing.JButton btnVerLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblBiografia;
    private javax.swing.JLabel lblIdadeExibicao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeExibicao;
    private javax.swing.JPanel panelAvaliacoes;
    private javax.swing.JPanel panelEditarPerfil;
    private javax.swing.JPanel panelListas;
    private javax.swing.JPanel panelPerfil;
    private javax.swing.JTable tblAvaliacoes;
    private javax.swing.JTable tblListas;
    private javax.swing.JTextArea txtBiografia;
    private javax.swing.JTextArea txtBiografiaExibicao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
