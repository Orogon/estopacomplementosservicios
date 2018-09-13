import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.estopacomplementos.core.ServiciosApplication;
import com.estopacomplementos.core.beans.base.DireccionBeanTO;
import com.estopacomplementos.core.beans.base.TelefonosBeanTO;
import com.estopacomplementos.core.beans.base.VentaRemisionBeanTO;
import com.estopacomplementos.core.business.ClientesComponent;
import com.estopacomplementos.core.business.GeneraRemisionesComponent;
import com.estopacomplementos.core.dao.CodigosErrorDAO;
import com.estopacomplementos.core.dao.GestorClientesDAO;
import com.estopacomplementos.core.entity.AltaClienteRequestTO;
import com.estopacomplementos.core.entity.RemisionesRequestTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServiciosApplication.class)
public class TestMongo {
	
	@Autowired
	private ClientesComponent clientesComponent;
	@Autowired
	private GeneraRemisionesComponent remisiones;
	@Autowired
	private GestorClientesDAO dao;
	@Autowired
	private CodigosErrorDAO erroDao;
	
	
//	@Test
//	public void registroCliente() {
//		AltaClienteRequestTO requestTO = new AltaClienteRequestTO();		
//		requestTO.setCorreoElectronico("cesarorozcorivera@yahoo.com");		
//		requestTO.setDireccion(direccionBeanTO());
//		requestTO.setNombreNegocio("Tlapaleria Michoacan");
//		requestTO.setNombreResponsable("Juan Alberto Juarez Perez");
//		requestTO.setTelefonos(telefonosBeanTO());
//		requestTO.setRfc("OORC9310136X8");
//		clientesComponent.registraCliente(requestTO);
//	}
	
	@Test
	public void registraNota() {
		RemisionesRequestTO requestTO = new RemisionesRequestTO();
		requestTO.setAhorro("190.00");
		requestTO.setColoniaNegocio("MIGUEL HIDALGO 1RA SECCION");
		requestTO.setDiasCredito("15");
		requestTO.setDireccionNegocio("CALLE MICHOACNA 19");
		requestTO.setEstadoNegocio("ESTADO DE MEXICO");
		requestTO.setFechaRemision("12-09-2018");
		requestTO.setFolioNota("5454545");
		requestTO.setNombreNegocio("TLAPALERIA MICHOACAN");
		requestTO.setTelefonoNegocio("5564596649");
		requestTO.setTipoVenta("CREDITO");
		requestTO.setTotalNotaConDescuento("1500.89");
		requestTO.setTotalNotaGlobal("2583.36");
		requestTO.setTotalNotaSinDescuento("1236.36");
		requestTO.setVenta(ventaRemision());
		remisiones.realizaRemision(requestTO);
	}
	
//	@Test
//	public void codigosError() {
//		CodigosErrorEntityTO entityTO = new CodigosErrorEntityTO();
//		entityTO.setCode(1);
//		entityTO.setLanguage("es");
//		entityTO.setMensaje("Lo sentimos, ocurrio un incidencia al realizar la operacion");
//		erroDao.registraError(entityTO);
//	}
	
	private List<VentaRemisionBeanTO> ventaRemision(){
		VentaRemisionBeanTO benaTO = new VentaRemisionBeanTO();
		List<VentaRemisionBeanTO> list = new ArrayList<>();
		benaTO.setCantidadProducto("50");
		benaTO.setDescripcion("Descripcion de Prueba");
		benaTO.setImporte("566");
		benaTO.setCodigoProducto("HGT85");
		benaTO.setPrecioVenta("875");
		list.add(benaTO);
		benaTO = new VentaRemisionBeanTO();
		benaTO.setCantidadProducto("50");
		benaTO.setDescripcion("Descripcion de Prueba 2");
		benaTO.setImporte("566");
		benaTO.setCodigoProducto("PLO85");
		benaTO.setPrecioVenta("875");
		list.add(benaTO);
		return list;
	}
	
	
	private DireccionBeanTO direccionBeanTO() {
		DireccionBeanTO beanTO = new DireccionBeanTO();
		beanTO.setCalle("Michoacan");
		beanTO.setCodigoPostal("14260");
		beanTO.setDelgacionMunicipio("Tlalpan");
		beanTO.setEstado("CDMX");
		beanTO.setNumInterior("19");
		beanTO.setTxtLibre("Edificio B1 Depto 204");
		beanTO.setColonia("Miguel Hidalgo 1ra Seccion");
		return beanTO;
	}
	
	private TelefonosBeanTO telefonosBeanTO() {
		TelefonosBeanTO beanTO = new TelefonosBeanTO();
//		beanTO.setNumCasa("26071038");
//		beanTO.setNumCelular("5564596649");
//		beanTO.setNumNegocio("59370281");
		return beanTO;
	}
}
