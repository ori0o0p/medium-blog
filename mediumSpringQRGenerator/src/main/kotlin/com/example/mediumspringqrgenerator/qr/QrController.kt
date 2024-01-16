package com.example.mediumspringqrgenerator.qr

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.awt.image.BufferedImage

@RestController
class QrController(
    private val qrGenerate: QrGenerate
) {

    @PostMapping("/qr")
    fun execute(@RequestBody content: String): BufferedImage {
        return qrGenerate.execute(content)
    }

}