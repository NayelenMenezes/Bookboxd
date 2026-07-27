package br.com.ifba.bookboxd.listaleitura.service;

import br.com.ifba.bookboxd.listaleitra.entity.ListaLeitura;
import java.util.List;
import java.util.Optional;


public interface ListaLeituraIService {
    // salva a lista de leitura
    ListaLeitura save(ListaLeitura lista);
    
    // atualiza a lista de leitura
    ListaLeitura update(ListaLeitura lista);
    
    // busca uma lista de leitura pelo ID
    Optional<ListaLeitura> findById(Long id);
    
    // deleta uma lista de leitura pelo ID
    void delete(Long id);
    
    // retorna todas lista de leitura
    List<ListaLeitura> findAll();
    
    List<ListaLeitura> findByUsuarioId(Long usuarioId);
    
    void adicionarLivro(Long listaId, Long livroId);
    
    void removerLivro(Long listaId, Long livroId);
    
    void esvaziarLista(Long listaId);
    
    ListaLeitura copiarLista(Long listaOriginalId, Long novoUsuarioId, String novoNome);
}
