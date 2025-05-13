package com.revisao.ecommerce.services;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revisao.ecommerce.dto.RelatorioPedidoDTO;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.repositories.PedidoRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class Relatorio {

    private final PedidoRepository pedidoRepository;

    public Relatorio(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    /**
     * Gera um relatório PDF no caminho especificado.
     * Substitui barras para o padrão do sistema e remove espaços.
     * Se o parâmetro for um diretório (existente ou terminado em separador),
     * usa 'relatorio_pedidos.pdf'.
     * @param caminhoArquivo Caminho completo ou diretório para salvar o PDF.
     */
    @Transactional(readOnly = true)
    public void gerarRelatorioPDF(String caminhoArquivo) throws JRException {
        // Normaliza barras e espaços
		String path = caminhoArquivo.trim()
		                           .replace('/', File.separatorChar)
		                           .replaceAll("\\\\$", "") // remove barra invertida final
		                           .replaceAll(" " , "");

		File destino = new File(path);
		if (destino.isDirectory() || path.endsWith(File.separator)) {
		    destino = new File(destino, "relatorio_pedidos.pdf");
		}

		// Cria diretórios pai se necessário
		File pasta = destino.getParentFile();
		if (pasta != null && !pasta.exists()) {
		    if (!pasta.mkdirs()) {
		        throw new JRException("Não foi possível criar diretórios: " + pasta);
		    }
		}

		// Coleta e mapeia dados
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<RelatorioPedidoDTO> dados = pedidos.stream()
		    .map(RelatorioPedidoDTO::new)
		    .collect(Collectors.toList());

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dados);
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("titulo", "Relatório de Pedidos");

		JasperReport jasperReport = JasperCompileManager.compileReport(
		    getClass().getResourceAsStream("/relatorios/relatorio_pedidos.jrxml")
		);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

		// Exporta para PDF
		JasperExportManager.exportReportToPdfFile(jasperPrint, destino.getAbsolutePath());
    }
}