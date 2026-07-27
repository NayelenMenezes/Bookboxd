package br.com.ifba.bookboxd.view;

import br.com.ifba.bookboxd.avaliacao.controller.AvaliacaoController;
import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.livro.entity.Livro;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//tela que exibe avaliações do livro e permite que o usuário escolha
//se quer fazer um avaliação ou deixar um comentario
@Component
public class LivroDetalheDialog extends javax.swing.JDialog {
    
    private final AvaliacaoController avaliacaoController;
    private final NovaAvaliacaoDialog novaAvaliacaoDialog;
    private final ComentariosDialog comentariosDialog;

    private Livro livroAtual;
    private Long usuarioLogadoId;
    
    @Autowired
    public LivroDetalheDialog(AvaliacaoController avaliacaoController,
                               NovaAvaliacaoDialog novaAvaliacaoDialog,
                               ComentariosDialog comentariosDialog) {
        super();
        setModal(true);
        setTitle("Detalhes do Livro");
        this.avaliacaoController = avaliacaoController;
        this.novaAvaliacaoDialog = novaAvaliacaoDialog;
        this.comentariosDialog = comentariosDialog;
        initComponents();
        
        txtSinopseLivro.setLineWrap(true);
        txtSinopseLivro.setWrapStyleWord(true);
        txtSinopseLivro.setEditable(false);

        tblAvaliacoesLivro.getColumnModel().getColumn(0).setMinWidth(0);
        tblAvaliacoesLivro.getColumnModel().getColumn(0).setMaxWidth(0);
        tblAvaliacoesLivro.getColumnModel().getColumn(0).setWidth(0);
        
        tblAvaliacoesLivro.getColumnModel().getColumn(5).setMinWidth(0);
        tblAvaliacoesLivro.getColumnModel().getColumn(5).setMaxWidth(0);
        tblAvaliacoesLivro.getColumnModel().getColumn(5).setWidth(0);
    }

    public void mostrarDetalhes(java.awt.Component parent, Livro livro, Long usuarioLogadoId) {
        this.livroAtual = livro;
        this.usuarioLogadoId = usuarioLogadoId;

        lblTitulo.setText("Título: " + livro.getTitulo());
        lblAutor.setText("Autor(a): " + (livro.getAutor() != null ? livro.getAutor().getPessoa().getNome() : "Desconhecido"));
        lblEditora.setText("Editora: " + (livro.getEditora() != null ? livro.getEditora().getNome() : "Sem editora"));
        lblNotaMedia.setText(String.format("Nota média: %.1f / 5", livro.calcularMediaAvaliacao()));
        txtSinopseLivro.setText(livro.getSinopse() != null ? livro.getSinopse() : "Sem sinopse");

        carregarAvaliacoes();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
    
    private void carregarAvaliacoes() {
        try {
            List<Avaliacao> avaliacoes = avaliacaoController.findByLivroId(livroAtual.getId());
            preencherTabela(avaliacoes);
        } catch (RuntimeException e) {
            preencherTabela(List.of());
        }
    }

    private void preencherTabela(List<Avaliacao> avaliacoes) {
        DefaultTableModel modelo = (DefaultTableModel) tblAvaliacoesLivro.getModel();
        modelo.setRowCount(0);
        for (Avaliacao a : avaliacoes) {
            String texto = a.isContemSpoiler() ? "[CONTÉM SPOILER] " + a.getAvaliacao() : a.getAvaliacao();
            modelo.addRow(new Object[]{
                a.getId(),
                a.getUsuario().getPessoa().getNome(),
                a.getNota() + " estrelas",
                texto,
                a.getComentarios().size() + " comentário(s)",
                a.isContemSpoiler()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAvaliacoesLivro = new javax.swing.JTable();
        btnVerComentarios = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnAvaliar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        lblEditora = new javax.swing.JLabel();
        lblNotaMedia = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSinopseLivro = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblAvaliacoesLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Usuario", "Nota", "Texto", "Qtd. Comentarios", "spoiler"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAvaliacoesLivro);

        btnVerComentarios.setText("VER COMENTARIOS");
        btnVerComentarios.addActionListener(this::btnVerComentariosActionPerformed);

        btnFechar.setText("FECHAR DETALHES");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        btnAvaliar.setText("AVALIAR LIVRO");
        btnAvaliar.addActionListener(this::btnAvaliarActionPerformed);

        lblTitulo.setText("TITULO");

        lblAutor.setText("AUTOR");

        lblEditora.setText("EDITORA");

        lblNotaMedia.setText("NOTA");

        txtSinopseLivro.setColumns(20);
        txtSinopseLivro.setRows(5);
        jScrollPane2.setViewportView(txtSinopseLivro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEditora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNotaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 17, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVerComentarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAvaliar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFechar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(lblAutor)
                        .addGap(18, 18, 18)
                        .addComponent(lblEditora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNotaMedia))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAvaliar)
                        .addGap(51, 51, 51)
                        .addComponent(btnVerComentarios)
                        .addGap(47, 47, 47)
                        .addComponent(btnFechar)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliarActionPerformed
        boolean criada = novaAvaliacaoDialog.mostrarParaCriar(this, usuarioLogadoId, livroAtual);
        if (criada) {
            carregarAvaliacoes();
            lblNotaMedia.setText(String.format("Nota média: %.1f / 5", livroAtual.calcularMediaAvaliacao()));
        }
    }//GEN-LAST:event_btnAvaliarActionPerformed

    private void btnVerComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerComentariosActionPerformed
         int linha = tblAvaliacoesLivro.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma avaliação primeiro.",
                    "Nenhuma avaliação selecionada", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tblAvaliacoesLivro.getModel();
        Long avaliacaoId = (Long) modelo.getValueAt(linha, 0);
        boolean contemSpoiler = (Boolean) modelo.getValueAt(linha, 5);

        if (contemSpoiler) {
            int confirmacao = JOptionPane.showConfirmDialog(this,
                    "Esta avaliação contém spoiler. Deseja continuar?", "Aviso de Spoiler",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirmacao != JOptionPane.YES_OPTION) return;
        }

        comentariosDialog.mostrarComentarios(this, avaliacaoId, usuarioLogadoId);
        carregarAvaliacoes();
    }//GEN-LAST:event_btnVerComentariosActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvaliar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnVerComentarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblEditora;
    private javax.swing.JLabel lblNotaMedia;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblAvaliacoesLivro;
    private javax.swing.JTextArea txtSinopseLivro;
    // End of variables declaration//GEN-END:variables
}
