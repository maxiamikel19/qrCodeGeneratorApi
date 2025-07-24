package com.maxiamikel.qrCodeGeneratorApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maxiamikel.qrCodeGeneratorApi.dto.TextoRequest;
import com.maxiamikel.qrCodeGeneratorApi.entity.Texto;
import com.maxiamikel.qrCodeGeneratorApi.service.QRCodeService;
import com.maxiamikel.qrCodeGeneratorApi.service.TextoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/textos")
@CrossOrigin("*")
public class TextoController {

    private final TextoService textoService;
    private final QRCodeService qrCodeService;

    public TextoController(TextoService textoService, QRCodeService qrCodeService) {
        this.textoService = textoService;
        this.qrCodeService = qrCodeService;
    }

    @GetMapping
    public List<Texto> listar() {
        return textoService.listarTodos();
    }

    @GetMapping("/{id}/qrcode")
    public String gerarQRCode(@PathVariable Long id) throws Exception {
        Texto texto = textoService.buscarPorId(id);
        return qrCodeService.gerarQRCode(texto.getConteudo(), 100, 100);
    }

    @PostMapping
    public Texto criarTexto(@RequestBody @Valid TextoRequest request) {
        return textoService.salvarTexto(request);
    }

    @GetMapping("/{id}")
    public Texto buscarTexto(@PathVariable Long id) {
        return textoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Texto atualizarTexto(@PathVariable Long id, @RequestBody @Valid TextoRequest request) {
        return textoService.atualizarTexto(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletarTexto(@PathVariable Long id) {
        textoService.deletarTexto(id);
    }

}
