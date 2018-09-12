package com.estopacomplementos.core.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.entity.RemisionesRequestTO;
import com.estopacomplementos.core.exceptions.MensajeExcepcion;
import com.estopacomplementos.core.utils.ConversorNumerosLetrasUtils;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Cesar M Orozco R
 *
 */
@Component
public class CrearRemisionComponent {
	
	private static final Logger log = LoggerFactory.getLogger(CrearRemisionComponent.class);
	
	private static final String ARCHIVO_JASPER = "C:\\Users\\Desarrollo\\Documents\\WorkspaceServicios\\estopacomplementosservicios\\src\\main\\resources\\nota.jasper";
	private static final String PRODUCTOS_VENDIDOS = "productosVendidos";
	private static final String NOMBRE_NEGOCIO = "nombreNegocio";
	private static final String DIRECCION_NEGOCIO = "direccionNegocio";
	private static final String COLONIA_NEGOCIO = "coloniaNegocio";
	private static final String ESTADO_NEGOCIO = "estadoNegocio";
	private static final String TELEFONO_NEGOCIO = "telefonoNegocio";
	private static final String TIPO_VENTA = "tipoVenta";
	private static final String DIAS_DE_CREDITO = "diasCredito";
	private static final String FOLIO_NOTA = "folioNota";	
	private static final String CANTIDAD_LETRA = "cantidadLetra";
	private static final String FECHA_REMISION = "fechaRemision";
	private static final String TOTAL_SIN_DESCUENTO = "totalSinDescuento";
	private static final String TOTAL_CON_DESCUENTO = "totalConDescuento";
	private static final String TOTAL_GLOBAL = "totalGlobal";
	private static final String TOTAL_IVA = "totalIva";
	private static final String AHORRO_TOTAL = "totalDescuento";
	
	private static final Integer ERROR_GENERAR_REMISION = 6;
	private static final Integer ERROR_LISTA_VACIA_PRODUCTOS = 7;
	
	
	/**
	 * @param requestTO
	 */
	public void creaRemisionConDatos(RemisionesRequestTO requestTO) {
		log.info("Entra al metodo de creaRemisionConDatos :::::: CrearRemisionComponent");
		try {
			JRDataSource dataSource = new JRBeanCollectionDataSource(creaListaProductos(requestTO));		
			JasperPrint jprint = JasperFillManager.fillReport(ARCHIVO_JASPER, creaParametros(requestTO), dataSource);
			JasperViewer viewer = new JasperViewer(jprint);
			viewer.setVisible(true);
			JasperPrintManager.printReport(jprint, false);
			log.info("La nota se a generado exitosamente");			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MensajeExcepcion(ERROR_GENERAR_REMISION);			
		}
	}
	
	private Map<String, Object> creaParametros(RemisionesRequestTO requestTO){
		Map<String, Object> parameters = new HashMap<>();
		parameters.put(NOMBRE_NEGOCIO, requestTO.getNombreNegocio());
		parameters.put(DIRECCION_NEGOCIO, requestTO.getDireccionNegocio());
		parameters.put(COLONIA_NEGOCIO, requestTO.getColoniaNegocio());
		parameters.put(ESTADO_NEGOCIO, requestTO.getEstadoNegocio());
		parameters.put(TELEFONO_NEGOCIO, requestTO.getTelefonoNegocio());
		parameters.put(TIPO_VENTA, requestTO.getTipoVenta());
		parameters.put(DIAS_DE_CREDITO, requestTO.getDiasCredito());
		parameters.put(FOLIO_NOTA, requestTO.getFolioNota());		
		parameters.put(CANTIDAD_LETRA, convierteCantidadALetra(requestTO.getTotalNotaGlobal()));
		parameters.put(FECHA_REMISION, requestTO.getFechaRemision());
		parameters.put(TOTAL_SIN_DESCUENTO, requestTO.getTotalNotaSinDescuento());
		parameters.put(TOTAL_CON_DESCUENTO, requestTO.getTotalNotaConDescuento().contains("No Aplica")?requestTO.getTotalNotaConDescuento():"$ "+requestTO.getTotalNotaConDescuento());
		parameters.put(TOTAL_GLOBAL, requestTO.getTotalNotaGlobal());
		parameters.put(TOTAL_IVA, "No Aplica");
		parameters.put(AHORRO_TOTAL, requestTO.getAhorro().contains("No Aplica")?requestTO.getAhorro():"$ "+requestTO.getAhorro());
		return parameters;
	}
	
	private String convierteCantidadALetra(String totalGlobal) {
		String totalGlobalLetra = null;
		String[] splitCantidad = totalGlobal.replace(".", "@").split("@");
		@SuppressWarnings("static-access")
		String cantidadLetra = new ConversorNumerosLetrasUtils().convierteNumerosATexto(splitCantidad[0]);
		totalGlobalLetra = cantidadLetra+"CON "+splitCantidad[1]+"/100 M.N.";
		return totalGlobalLetra;
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
			throw new MensajeExcepcion(ERROR_LISTA_VACIA_PRODUCTOS);
		}		
		return listaProductosVendidos;
	}
}