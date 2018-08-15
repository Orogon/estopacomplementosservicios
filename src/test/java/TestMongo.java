import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.estopacomplementos.core.ServiciosApplication;
import com.estopacomplementos.core.benas.base.TelefonosBeanTO;
import com.estopacomplementos.core.business.ClientesComponent;
import com.estopacomplementos.core.entity.ClienteRequestTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServiciosApplication.class)
public class TestMongo {
	
	@Autowired
	private ClientesComponent clientesComponent;
	
	
	@Test
	public void prueba() {
		ClienteRequestTO requestTO = new ClienteRequestTO();
		TelefonosBeanTO beanTO = new TelefonosBeanTO();
		beanTO.setNumCelular("55858");
		requestTO.setTelefonos(beanTO);
		clientesComponent.registraCliente(requestTO, null);
	}
	

}
