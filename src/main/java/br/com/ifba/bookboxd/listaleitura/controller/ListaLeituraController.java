package br.com.ifba.bookboxd.listaleitura.controller;

import br.com.ifba.bookboxd.listaleitra.entity.ListaLeitura;
import br.com.ifba.bookboxd.listaleitura.service.ListaLeituraIService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ListaLeituraController implements ListaLeituraIController{
    private final ListaLeituraIService listaLeituraService;

    @Override
    public ListaLeitura save(ListaLeitura lista) {
        try {
            log.info("Controller: salvando lista");
            return listaLeituraService.save(lista);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao salvar lista - {}", e.getMessage());
            throw e;
        }
    }
    
    @Override
    public ListaLeitura update(ListaLeitura lista) {
        try {
            log.info("Controller: atualizando lista");
            return listaLeituraService.update(lista);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao atualizar lista - {}", e.getMessage());
            throw e;
        }
    }
    
    @Override
    public Optional<ListaLeitura> findById(Long id) {
        try {
            log.info("Controller: buscando lista por ID: {}", id);
            return listaLeituraService.findById(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar lista id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        try {
            log.info("Controller: deletando lista com ID: {}", id);
            listaLeituraService.delete(id);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao deletar lista id {} - {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ListaLeitura> findAll() {
        try {
            log.info("Controller: listando todas as listas de leitura");
            return listaLeituraService.findAll();
        } catch (RuntimeException e) {
            log.error("Controller: erro ao listar listas de leitura - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ListaLeitura> findByUsuarioId(Long usuarioId) {
        try {
            log.info("Controller: buscando listas do usuário ID: {}", usuarioId);
            return listaLeituraService.findByUsuarioId(usuarioId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao buscar listas do usuário id {} - {}", usuarioId, e.getMessage());
            throw e;
        }
    }

    @Override
    public void adicionarLivro(Long listaId, Long livroId) {
        try {
            log.info("Controller: adicionando livro {} à lista ID: {}", livroId, listaId);
            listaLeituraService.adicionarLivro(listaId, livroId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao adicionar livro {} à lista id {} - {}", livroId, listaId, e.getMessage());
            throw e;
        }
    }

    @Override
    public void removerLivro(Long listaId, Long livroId) {
        try {
            log.info("Controller: removendo livro {} da lista ID: {}", livroId, listaId);
            listaLeituraService.removerLivro(listaId, livroId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao remover livro {} da lista id {} - {}", livroId, listaId, e.getMessage());
            throw e;
        }
    }

    @Override
    public void esvaziarLista(Long listaId) {
        try {
            log.info("Controller: esvaziando lista ID: {}", listaId);
            listaLeituraService.esvaziarLista(listaId);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao esvaziar lista id {} - {}", listaId, e.getMessage());
            throw e;
        }
    }

    @Override
    public ListaLeitura copiarLista(Long listaOriginalId, Long novoUsuarioId, String novoNome) {
        try {
            log.info("Controller: copiando lista ID: {}", listaOriginalId);
            return listaLeituraService.copiarLista(listaOriginalId, novoUsuarioId, novoNome);
        } catch (RuntimeException e) {
            log.error("Controller: erro ao copiar lista id {} - {}", listaOriginalId, e.getMessage());
            throw e;
        }
    }
}