package com.example.mediumspringqrgenerator.qr

import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.common.BitMatrix
import com.google.zxing.client.j2se.MatrixToImageWriter
import java.awt.image.BufferedImage
import org.springframework.stereotype.Service

@Service
class QrGenerate {

    @Throws(WriterException::class)
    fun execute(content: String): BufferedImage {

        val qrCodeWriter = QRCodeWriter()
        val bitMatrix: BitMatrix = qrCodeWriter
            .encode(content, BarcodeFormat.QR_CODE, 300, 300)

        return MatrixToImageWriter.toBufferedImage(bitMatrix)
    }

}