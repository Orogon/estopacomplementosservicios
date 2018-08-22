package com.estopacomplementos.core.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.entity.RemisionesRequestTO;

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
public class CrearRemisionComponent {
	
	private static final Logger log = LoggerFactory.getLogger(CrearRemisionComponent.class);
	
	private static final String ARCHIVO_JASPER = "/home/cesarorozco/git/estopacomplementosservicios/src/main/resources/nota.jasper";
	private static final String ARCHIVO_PDF_STORAGE = "/home/cesarorozco/Documentos/Remisiones/";
	private static final String PRODUCTOS_VENDIDOS = "productosVendidos";
	private static final String NOMBRE_NEGOCIO = "nombreNegocio";
	private static final String DIRECCION_NEGOCIO = "direccionNegocio";
	private static final String COLONIA_NEGOCIO = "coloniaNegocio";
	private static final String ESTADO_NEGOCIO = "estadoNegocio";
	private static final String TELEFONO_NEGOCIO = "telefonoNegocio";
	private static final String TIPO_VENTA = "tipoVenta";
	private static final String DIAS_DE_CREDITO = "diasCredito";
	private static final String FOLIO_NOTA = "folioNota";	
	
	
	/**
	 * @param requestTO
	 */
	public void creaRemisionConDatos(RemisionesRequestTO requestTO) {
		log.info("Entra al metodo de creaRemisionConDatos :::::: CrearRemisionComponent");
		try {
			JRDataSource dataSource = new JRBeanCollectionDataSource(creaListaProductos(requestTO));		
			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(ARCHIVO_JASPER, creaParametros(requestTO), dataSource);
			JasperExportManager.exportReportToPdfFile(jprint, ARCHIVO_PDF_STORAGE+requestTO.getNombreNegocio());
			log.info("La nota se a generado exitosamente");
		} catch (JRException e) {
			/** Agregar error de que no se pudo generar nota y se para el flujo **/
			e.printStackTrace();
		}
	}
	
	private Map<String, Object> creaParametros(RemisionesRequestTO requestTO){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put(NOMBRE_NEGOCIO, requestTO.getNombreNegocio());
		parameters.put(DIRECCION_NEGOCIO, requestTO.getDireccionNegocio());
		parameters.put(COLONIA_NEGOCIO, requestTO.getColoniaNegocio());
		parameters.put(ESTADO_NEGOCIO, requestTO.getColoniaNegocio());
		parameters.put(TELEFONO_NEGOCIO, requestTO.getTelefonoNegocio());
		parameters.put(TIPO_VENTA, requestTO.getTipoVenta());
		parameters.put(DIAS_DE_CREDITO, requestTO.getDiasCredito());
		parameters.put(FOLIO_NOTA, requestTO.getFolioNota());
		return parameters;
	}
	
	private List<Map<String, Object>> creaListaProductos(RemisionesRequestTO requestTO){
		List<Map<String, Object>> listaProductosVendidos = new ArrayList<>();
		Map<String, Object> productosLista = new HashMap<>();
		if(requestTO.getVenta().size() > 0) {
			for(int a=0;a<requestTO.getVenta().size();a++) {
				productosLista.put(PRODUCTOS_VENDIDOS, requestTO.getVenta().get(a));
				listaProductosVendidos.add(productosLista);
				productosLista = new HashMap<>();
			}	
		}else {
			/** Generar error de lista vacia y retornarlo y parar flujo**/
		}		
		return listaProductosVendidos;
	}
	
	
}