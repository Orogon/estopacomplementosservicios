package com.estopacomplementos.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.entity.RemisionesEntityTO;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Cesar M Orozco R
 *
 */
@Component
public class DatosRemisionUtils {
	
	private static final Logger log = LoggerFactory.getLogger(DatosRemisionUtils.class);
	
	private static final String PRODUCTOS_VENDIDOS = "productosVendidos";
	
	private static final String ARCHIVO_JASPER = "E:\\Users\\corozcor\\Documents\\BAZDigital\\Workspace´s\\WorkspaceCesar\\ServiciosEstopaComplementos\\src\\main\\resources\\nota.jasper";
	private static final String ARCHIVO_PDF_STORAGE = "E:\\Users\\corozcor\\Documents\\prueba\\nota.pdf";
	
	public void creaRemisionConDatos(RemisionesEntityTO requestTO) {	
		List<Map<String, Object>> listaProductosVendidos = new ArrayList<>();
		Map<String, Object> productosLista = new HashMap<>();		
		try {
			for(int a=0;a<requestTO.getProductosVendidos().size();a++) {
				productosLista.put(PRODUCTOS_VENDIDOS, requestTO.getProductosVendidos().get(a));
				listaProductosVendidos.add(productosLista);
				productosLista = new HashMap<>();
			}	
			JRDataSource dataSource = new JRBeanCollectionDataSource(listaProductosVendidos);		
			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(ARCHIVO_JASPER, creaParametros(requestTO), dataSource);
			JasperExportManager.exportReportToPdfFile(jprint, ARCHIVO_PDF_STORAGE);
			log.info("El PDF se ha generado correctamente");
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	private Map<String, Object> creaParametros(RemisionesEntityTO entityTO){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("nombreNegocio", entityTO.getNombreNegocio());
		return parameters;
	}

}
