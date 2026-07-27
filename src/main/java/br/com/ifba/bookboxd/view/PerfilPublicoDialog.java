package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.avaliacao.controller.AvaliacaoController;
import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.listaleitra.entity.ListaLeitura;
import br.com.ifba.bookboxd.listaleitura.controller.ListaLeituraController;
import br.com.ifba.bookboxd.usuario.entity.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//exibe o perfil de outros usuarios
@Component
public class PerfilPublicoDialog extends javax.swing.JDialog {
    
    private final AvaliacaoController avaliacaoController;
    private final ListaLeituraController listaController;
    private final ComentariosDialog comentariosDialog; 
    private final VerListaDialog verListaDialog;
    private Long usuarioLogadoId;
    private Long usuarioVisitadoId;
    
    @Autowired
    public PerfilPublicoDialog(AvaliacaoController avaliacaoController, ListaLeituraController listaController,
                                ComentariosDialog comentariosDialog, VerListaDialog verListaDialog) {
        super();
        setModal(true);
        setTitle("Perfil do Usuário");
        this.avaliacaoController = avaliacaoController;
        this.listaController = listaController;
        this.comentariosDialog = comentariosDialog;
        this.verListaDialog = verListaDialog;
        initComponents();
        
        txtBiografia.setLineWrap(true);
        txtBiografia.setWrapStyleWord(true);
       
        tblAvaliacoesPublicas.getColumnModel().getColumn(0).setMinWidth(0);
        tblAvaliacoesPublicas.getColumnModel().getColumn(0).setMaxWidth(0);
        tblAvaliacoesPublicas.getColumnModel().getColumn(0).setWidth(0);
        
        tblAvaliacoesPublicas.getColumnModel().getColumn(4).setMinWidth(0);
        tblAvaliacoesPublicas.getColumnModel().getColumn(4).setMaxWidth(0);
        tblAvaliacoesPublicas.getColumnModel().getColumn(4).setWidth(0);

        tblListasPublicas.getColumnModel().getColumn(0).setMinWidth(0);
        tblListasPublicas.getColumnModel().getColumn(0).setMaxWidth(0);
        tblListasPublicas.getColumnModel().getColumn(0).setWidth(0);
    }

    public void mostrarPerfil(java.awt.Component parent, Usuario usuario, Long usuarioLogadoId) {
        this.usuarioLogadoId = usuarioLogadoId;
        this.usuarioVisitadoId = usuario.getId();
        lblNomeUsuario.setText(usuario.getPessoa().getNome());
        txtBiografia.setText(usuario.getPessoa().getBiografia() != null
                ? usuario.getPessoa().getBiografia() : "Sem biografia");
        carregarAvaliacoes(usuario.getId());
        carregarListas(usuario.getId());
        setLocationRelativeTo(parent);
        setVisible(true);
    }
    
    private void carregarAvaliacoes(Long usuarioId) {
        try {
            List<Avaliacao> avaliacoes = avaliacaoController.findByUsuarioId(usuarioId);
            preencherTabelaAvaliacoes(avaliacoes);
        } catch (RuntimeException e) {
            preencherTabelaAvaliacoes(List.of());
        }
    }
    
    private void preencherTabelaAvaliacoes(List<Avaliacao> avaliacoes) {
        DefaultTableModel modelo = (DefaultTableModel) tblAvaliacoesPublicas.getModel();
        modelo.setRowCount(0);
        for (Avaliacao a : avaliacoes) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getLivro().getTitulo(),
                a.getNota() + " estrelas",
                a.isContemSpoiler() ? "[CONTÉM SPOILER] " + a.getAvaliacao() : a.getAvaliacao(),
                a.isContemSpoiler()
            });
        }
    }
    
    private void carregarListas(Long usuarioId) {
        try {
            List<ListaLeitura> listas = listaController.findByUsuarioId(usuarioId);
            preencherTabelaListas(listas);
        } catch (RuntimeException e) {
            preencherTabelaListas(List.of());
        }
    }

    private void preencherTabelaListas(List<ListaLeitura> listas) {
        DefaultTableModel modelo = (DefaultTableModel) tblListasPublicas.getModel();
        modelo.setRowCount(0);
        for (ListaLeitura l : listas) {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getNomeLista(),
                l.getListaLivros().size() + " livro(s)"
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblNomeUsuario = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtBiografia = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAvaliacoesPublicas = new javax.swing.JTable();
        btnVerDetalhesAvaliacao = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListasPublicas = new javax.swing.JTable();
        btnVerLista = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNomeUsuario.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        lblNomeUsuario.setText("nome");

        txtBiografia.setColumns(20);
        txtBiografia.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        txtBiografia.setRows(5);
        jScrollPane4.setViewportView(txtBiografia);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeUsuario))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblNomeUsuario)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PERFIL", jPanel1);

        tblAvaliacoesPublicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Livro", "Nota", "Texto", "spoiler"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAvaliacoesPublicas);

        btnVerDetalhesAvaliacao.setText("VER DETALHES");
        btnVerDetalhesAvaliacao.addActionListener(this::btnVerDetalhesAvaliacaoActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerDetalhesAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnVerDetalhesAvaliacao)
                .addContainerGap())
        );

        jTabbedPane1.addTab("AVALIAÇÕES", jPanel2);

        tblListasPublicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nome", "Qtd. LIvros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListasPublicas);

        btnVerLista.setText("VER DETALHES");
        btnVerLista.addActionListener(this::btnVerListaActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerLista, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnVerLista)
                .addContainerGap())
        );

        jTabbedPane1.addTab("LISTAS", jPanel3);

        btnVoltar.setText("FECHAR");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVoltar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVerDetalhesAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalhesAvaliacaoActionPerformed
        int linha = tblAvaliacoesPublicas.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma avaliação primeiro.",
                    "Nenhuma avaliação selecionada", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tblAvaliacoesPublicas.getModel();
        Long avaliacaoId = (Long) modelo.getValueAt(linha, 0);
        boolean contemSpoiler = (Boolean) modelo.getValueAt(linha, 4);

        if (contemSpoiler) {
            int confirmacao = JOptionPane.showConfirmDialog(this,
                    "Esta avaliação contém spoiler. Deseja continuar?", "Aviso de Spoiler",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirmacao != JOptionPane.YES_OPTION) return;
        }

        comentariosDialog.mostrarComentarios(this, avaliacaoId, usuarioLogadoId);
        carregarAvaliacoes(usuarioVisitadoId);
    }//GEN-LAST:event_btnVerDetalhesAvaliacaoActionPerformed

    private void btnVerListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerListaActionPerformed
        int linha = tblListasPublicas.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma lista primeiro.",
                    "Nenhuma lista selecionada", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tblListasPublicas.getModel();
        Long listaId = (Long) modelo.getValueAt(linha, 0);

        verListaDialog.mostrarLista(this, listaId, true, usuarioLogadoId);
    }//GEN-LAST:event_btnVerListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerDetalhesAvaliacao;
    private javax.swing.JButton btnVerLista;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JTable tblAvaliacoesPublicas;
    private javax.swing.JTable tblListasPublicas;
    private javax.swing.JTextArea txtBiografia;
    // End of variables declaration//GEN-END:variables
}
