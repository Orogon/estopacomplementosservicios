package com.estopacomplementos.core.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.estopacomplementos.core.benas.base.VentaRemisionBeanTO;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class CreaRemisionPDF {
	
	private static final Logger log = LoggerFactory.getLogger(CreaRemisionPDF.class);
    
    public void crearPDF(File pdfNewFile, List<VentaRemisionBeanTO> articulos) {
        try {
            Document documento = new Document();
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(pdfNewFile));     
            
            documento.addTitle("Remision");            
            documento.open();
            
            Paragraph tituloDocumento = new Paragraph();
            tituloDocumento.add("Estopa y Complementos");
            
            tituloDocumento.add("\n\n");
            documento.add(tituloDocumento);
            
       
            
            PdfPTable tablaArticulos = new PdfPTable(4);
            
            Paragraph columnaCantidad = new Paragraph("Cantidad");
            columnaCantidad.getFont().setStyle(Font.BOLD);            
            tablaArticulos.addCell(columnaCantidad);
            
            Paragraph columnaDescripcion = new Paragraph("Descripcion del producto");
            columnaDescripcion.getFont().setStyle(Font.BOLD);            
            tablaArticulos.addCell(columnaDescripcion);
            
            Paragraph columnaPrecioU = new Paragraph("Precio Unitario");
            columnaPrecioU.getFont().setStyle(Font.BOLD);            
            tablaArticulos.addCell(columnaPrecioU);
            
            Paragraph columnaImporte = new Paragraph("Importe");
            columnaImporte.getFont().setStyle(Font.BOLD);            
            tablaArticulos.addCell(columnaImporte);
            
            for(int a = 0; a<articulos.size(); a++) {
            	tablaArticulos.addCell(articulos.get(a).getCantidadProducto());
            	tablaArticulos.addCell(articulos.get(a).getDescripcion());
            	tablaArticulos.addCell(articulos.get(a).getPrecioVenta());
            	tablaArticulos.addCell(articulos.get(a).getImporte());            	
            }            
            
//            documento.add(tablaCliente);
            documento.add(tablaArticulos);
            documento.close();
            
            writer.close();

            
        } catch (Exception documentException) {
            log.info("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }

    
    public static void main(String args[]) {
    	CreaRemisionPDF generatePDFFileIText = new CreaRemisionPDF();
        generatePDFFileIText.crearPDF(new File("/home/cesarorozco/Documentos/GeneratePDFFileIText.pdf"), ventaRemision());
    }
    
    private static List<VentaRemisionBeanTO> ventaRemision(){
		VentaRemisionBeanTO benaTO = new VentaRemisionBeanTO();
		List<VentaRemisionBeanTO> list = new ArrayList<>();
		benaTO.setCantidadProducto("50");
		benaTO.setDescripcion("Descripcion de Prueba");
		benaTO.setImporte("566");
		benaTO.setPrecioVenta("875");
		list.add(benaTO);
		benaTO = new VentaRemisionBeanTO();
		benaTO.setCantidadProducto("50");
		benaTO.setDescripcion("Descripcion de Prueba 2");
		benaTO.setImporte("566");
		benaTO.setPrecioVenta("875");
		list.add(benaTO);
		return list;
	}
    
}
