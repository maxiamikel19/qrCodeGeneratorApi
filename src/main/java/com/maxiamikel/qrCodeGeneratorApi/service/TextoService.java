package com.maxiamikel.qrCodeGeneratorApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maxiamikel.qrCodeGeneratorApi.dto.TextoRequest;
import com.maxiamikel.qrCodeGeneratorApi.entity.Texto;
import com.maxiamikel.qrCodeGeneratorApi.repository.TextoRepository;

@Service
public class TextoService {

    private final TextoRepository textoRepository;

    public TextoService(TextoRepository textoRepository) {
        this.textoRepository = textoRepository;
    }

    public Texto salvarTexto(TextoRequest request) {
        Texto texto = new Texto();
        texto.setConteudo(request.getConteudo());
        return textoRepository.save(texto);
    }

    public List<Texto> listarTodos() {
        return textoRepository.findAll();
    }

    public Texto buscarPorId(Long id) {
        return findById(id);
    }

    public Texto atualizarTexto(Long id, TextoRequest request) {

        Texto texto = findById(id);
        texto.setConteudo(request.getConteudo());
        return textoRepository.save(texto);
    }

    public void deletarTexto(Long id) {
        Texto texto = findById(id);
        textoRepository.deleteById(texto.getId());
    }

    private Texto findById(Long id) {
        return textoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Texto não encontrado"));
    }

}
