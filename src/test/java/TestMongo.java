import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.estopacomplementos.core.ServiciosApplication;
import com.estopacomplementos.core.benas.base.DireccionBeanTO;
import com.estopacomplementos.core.benas.base.TelefonosBeanTO;
import com.estopacomplementos.core.benas.base.VentaRemisionBenaTO;
import com.estopacomplementos.core.business.ClientesComponent;
import com.estopacomplementos.core.business.GeneraRemisionesComponent;
import com.estopacomplementos.core.dao.GestorClientesDAO;
import com.estopacomplementos.core.entity.ClienteRequestTO;
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
	
	
//	@Test
//	public void registroCliente() {
//		ClienteRequestTO requestTO = new ClienteRequestTO();		
//		requestTO.setCorreoElectronico("cesarorozcorivera@yahoo.com");
//		requestTO.setCreditoDias("8");
//		requestTO.setDireccion(direccionBeanTO());
//		requestTO.setNombreNegocio("Tlapaleria Michoacan");
//		requestTO.setNombreResponsable("Juan Alberto Juarez Perez");
//		requestTO.setTelefonos(telefonosBeanTO());
//		requestTO.setTipoVenta("Credito");		
//		clientesComponent.registraCliente(requestTO);
//	}
	
	@Test
	public void registraNota() {
		RemisionesRequestTO requestTO = new RemisionesRequestTO();
		requestTO.setFechaRemision("15-08-2018");
		requestTO.setFolioNota("0001");
		requestTO.setNombreNegocio("Tlapaleria Michoacan");
		requestTO.setTipoVenta("Credito");
		requestTO.setTotalNota("6000");
		requestTO.setVenta(ventaRemision());
		remisiones.realizaRemision(requestTO);
	}
	
	private List<VentaRemisionBenaTO> ventaRemision(){
		VentaRemisionBenaTO benaTO = new VentaRemisionBenaTO();
		List<VentaRemisionBenaTO> list = new ArrayList<>();
		benaTO.setCantidadProducto("50");
		benaTO.setDescripcion("Descripcion de Prueba");
		benaTO.setImporte("566");
		benaTO.setPrecioVenta("875");
		list.add(benaTO);
		benaTO = new VentaRemisionBenaTO();
		benaTO.setCantidadProducto("50");
		benaTO.setDescripcion("Descripcion de Prueba 2");
		benaTO.setImporte("566");
		benaTO.setPrecioVenta("875");
		list.add(benaTO);
		return list;
	}
	
	
	private DireccionBeanTO direccionBeanTO() {
		DireccionBeanTO beanTO = new DireccionBeanTO();
		beanTO.setCalle("Michoacan");
		beanTO.setCodigoPostal("14260");
		beanTO.setDelgacionMunicipio("Tlalpan");
		beanTO.setEstado("Mexico");
		beanTO.setNumInterior("19");
		beanTO.setTxtLibre("Edificio B1 Depto 204");
		beanTO.setReferencias("Saguan negro");
		return beanTO;
	}
	
	private TelefonosBeanTO telefonosBeanTO() {
		TelefonosBeanTO beanTO = new TelefonosBeanTO();
		beanTO.setNumCasa("26071038");
		beanTO.setNumCelular("5564596649");
		beanTO.setNumNegocio("59370281");
		return beanTO;
	}
}
