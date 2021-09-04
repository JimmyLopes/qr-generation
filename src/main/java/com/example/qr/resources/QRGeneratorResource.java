package com.example.qr.resources;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/v1/generate-qr")
public class QRGeneratorResource {

    @GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage generateQRCodeImage(@RequestParam String qrText) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrText, BarcodeFormat.QR_CODE, 250, 250);

            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (Exception ex) {
            Logger.getLogger(ex.getLocalizedMessage());
            return null;
        }
    }
}
