package com.revisao.ecommerce.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.revisao.ecommerce.services.Relatorio;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller para expor o endpoint de geração de relatório de pedidos.
 */
@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private Relatorio relatorio;

    /**
     * Gera o relatório PDF no caminho especificado e devolve o arquivo para download.
     * O parâmetro caminho pode ser um diretório (usa relatorio_pedidos.pdf) ou um arquivo.
     */
    @GetMapping
    public ResponseEntity<InputStreamResource> gerarRelatorio(
            @RequestParam("caminho") String caminho) throws JRException, IOException {

        // Normaliza barras e espaços
        String path = caminho.trim()
                .replace('/', File.separatorChar)
                .replaceAll(" ", "");

        File fileParam = new File(path);
        File pdfFile;
        if (fileParam.isDirectory() || path.endsWith(File.separator)) {
            pdfFile = new File(fileParam, "relatorio_pedidos.pdf");
        } else {
            pdfFile = fileParam;
        }

        // Gera o PDF no serviço
        relatorio.gerarRelatorioPDF(path);

        // Lê o arquivo gerado
        if (!pdfFile.exists()) {
            throw new IOException("Arquivo PDF não encontrado: " + pdfFile.getAbsolutePath());
        }
        InputStreamResource resource = new InputStreamResource(new FileInputStream(pdfFile));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition
                .builder("attachment")
                .filename(pdfFile.getName())
                .build());

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(pdfFile.length())
                .body(resource);
    }
}
