package com.maxiamikel.qrCodeGeneratorApi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TextoRequest {
    @NotBlank(message = "Campo é obligatorio")
    private String conteudo;
}
