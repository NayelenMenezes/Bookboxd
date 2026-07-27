package br.com.ifba.bookboxd.usuario.entity;

import br.com.ifba.bookboxd.pessoa.entity.Pessoa;
import br.com.ifba.bookboxd.listaleitra.entity.ListaLeitura;
import br.com.ifba.bookboxd.avaliacao.entity.Avaliacao;
import br.com.ifba.bookboxd.infrastruture.entity.PersistenceEntity;
import br.com.ifba.bookboxd.livro.entity.Livro;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends PersistenceEntity{
    @Column(nullable = false)
    private String senha;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    private LocalDate dataCadastro;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avaliacao> avaliacoes = new ArrayList<>();
   
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ListaLeitura> listas = new ArrayList<>();
    
    @Column(nullable = false)
    private boolean administrador = false;
    
    //confere se a senha e o email bate com os dados do usuário
    public boolean autenticar(String email, String senha) {
        return this.email.equalsIgnoreCase(email) && this.senha.equals(senha);
    }
    
    //muda a senha do usuário após validar a senha antiga
    public boolean alterarSenha(String antigaSenha, String novaSenha){
        if(this.senha != null && this.senha.equals(antigaSenha)){
            this.senha = novaSenha;
            return true;
        }
        log.warn("Tentativa de alteração de senha falhou para o usuário: {}", email);
        return false;
    }
    
    //atualiza nome e bio
    public void editarPerfil(String nome, String bio){
        if(this.pessoa != null){
            this.pessoa.setNome(nome);
            this.pessoa.setBiografia(bio);
        }
    }
    
    //cria uma nova lista de leitura
    public ListaLeitura criarListaLeitura(String nome, String descricao){
        ListaLeitura lista = new ListaLeitura();
        lista.setNomeLista(nome);
        lista.setDescricao(descricao);
        lista.setUsuario(this);
        this.listas.add(lista);
        return lista;
    }
    
    public Avaliacao criarAvaliacao(Livro livro, int nota, String texto, boolean contemSpoiler) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setUsuario(this);
        avaliacao.setLivro(livro);
        avaliacao.setNota(nota);
        avaliacao.setAvaliacao(texto);
        avaliacao.setContemSpoiler(contemSpoiler);
        avaliacao.setDataPublicacao(LocalDate.now());
        return avaliacao;
    }
    
    private static final org.slf4j.Logger log =
        org.slf4j.LoggerFactory.getLogger(Usuario.class);
}
