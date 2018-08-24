package com.estopacomplementos.core.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.entity.RemisionesRequestTO;
import com.estopacomplementos.core.exceptions.MensajeExcepcion;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Cesar M Orozco R
 *
 */
@Component
public class CrearRemisionComponent {
	
	private static final Logger log = LoggerFactory.getLogger(CrearRemisionComponent.class);
	
	private static final String ARCHIVO_JASPER = "E:\\Users\\corozcor\\Documents\\BAZDigital\\Workspace´s\\WorkspaceCesar\\ServiciosEstopaComplementos\\src\\main\\resources\\nota.jasper";
	private static final String PRODUCTOS_VENDIDOS = "productosVendidos";
	private static final String NOMBRE_NEGOCIO = "nombreNegocio";
	private static final String DIRECCION_NEGOCIO = "direccionNegocio";
	private static final String COLONIA_NEGOCIO = "coloniaNegocio";
	private static final String ESTADO_NEGOCIO = "estadoNegocio";
	private static final String TELEFONO_NEGOCIO = "telefonoNegocio";
	private static final String TIPO_VENTA = "tipoVenta";
	private static final String DIAS_DE_CREDITO = "diasCredito";
	private static final String FOLIO_NOTA = "folioNota";
	
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
//			JasperViewer.viewReport(jprint, true);
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
			throw new MensajeExcepcion(ERROR_LISTA_VACIA_PRODUCTOS);
		}		
		return listaProductosVendidos;
	}
	
	private static String convierteCantidadATexto(String numero) {
		String num = "1598@00";
		String cantidad[] = num.split("@");
		String entero = cantidad[0];
		
		String decimal = cantidad[1];
		
		StringBuilder result = new StringBuilder();	
		
        BigDecimal totalBigDecimal = new BigDecimal(decimal).setScale(2, BigDecimal.ROUND_DOWN);
        
        long parteEntera = totalBigDecimal.toBigInteger().longValue(); 
        
        int triUnidades      = (int)((parteEntera % 1000));
        int triMiles         = (int)((parteEntera / 1000) % 1000);
        int triMillones      = (int)((parteEntera / 1000000) % 1000);
        int triMilMillones   = (int)((parteEntera / 1000000000) % 1000);
        if (parteEntera == 0) {
            result.append("Cero ");
            return result.toString();
        }
        
        if (triMilMillones > 0) result.append(triTexto(triMilMillones).toString() + "Mil ");
        
        if (triMillones > 0)    result.append(triTexto(triMillones).toString());
 
        if (triMilMillones == 0 && triMillones == 1) result.append("Millón ");
        else if (triMilMillones > 0 || triMillones > 0) result.append("Millones ");
 
        if (triMiles > 0)       result.append(triTexto(triMiles).toString() + "Mil ");
        if (triUnidades > 0)    result.append(triTexto(triUnidades).toString());
        
 
        return result.toString();	 
	}
	
	 private static StringBuilder triTexto(int n) {
	        StringBuilder result = new StringBuilder();
	        int centenas = n / 100;
	        int decenas  = (n % 100) / 10;
	        int unidades = (n % 10);	 
	        switch (centenas) {
	            case 0: break;
	            case 1:
	                if (decenas == 0 && unidades == 0) {
	                    result.append("Cien ");
	                    return result;
	                }
	                else result.append("Ciento ");
	                break;
	            case 2: result.append("Doscientos "); break;
	            case 3: result.append("Trescientos "); break;
	            case 4: result.append("Cuatrocientos "); break;
	            case 5: result.append("Quinientos "); break;
	            case 6: result.append("Seiscientos "); break;
	            case 7: result.append("Setecientos "); break;
	            case 8: result.append("Ochocientos "); break;
	            case 9: result.append("Novecientos "); break;
	        }
	 
	        switch (decenas) {
	            case 0: break;
	            case 1:
	                if (unidades == 0) { result.append("Diez "); return result; }
	                else if (unidades == 1) { result.append("Once "); return result; }
	                else if (unidades == 2) { result.append("Doce "); return result; }
	                else if (unidades == 3) { result.append("Trece "); return result; }
	                else if (unidades == 4) { result.append("Catorce "); return result; }
	                else if (unidades == 5) { result.append("Quince "); return result; }
	                else result.append("Dieci");
	                break;
	            case 2:
	                if (unidades == 0) { result.append("Veinte "); return result; }
	                else result.append("Veinti");
	                break;
	            case 3: result.append("Treinta "); break;
	            case 4: result.append("Cuarenta "); break;
	            case 5: result.append("Cincuenta "); break;
	            case 6: result.append("Sesenta "); break;
	            case 7: result.append("Setenta "); break;
	            case 8: result.append("Ochenta "); break;
	            case 9: result.append("Noventa "); break;
	        }
	 
	        if (decenas > 2 && unidades > 0)
	            result.append("y ");
	 
	        switch (unidades) {
	            case 0: break;
	            case 1: result.append("Un "); break;
	            case 2: result.append("Dos "); break;
	            case 3: result.append("Tres "); break;
	            case 4: result.append("Cuatro "); break;
	            case 5: result.append("Cinco "); break;
	            case 6: result.append("Seis "); break;
	            case 7: result.append("Siete "); break;
	            case 8: result.append("Ocho "); break;
	            case 9: result.append("Nueve "); break;
	        }
	 
	        return result;
	    }
	 
	 public static void main(String[] args) {
		 String result = convierteCantidadATexto(null);
		 System.out.println(result);
	}
	
	
}