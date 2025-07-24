package com.maxiamikel.qrCodeGeneratorApi.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SandardErro {
    private String message;
}
