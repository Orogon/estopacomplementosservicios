import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.estopacomplementos.core.ServiciosApplication;
import com.estopacomplementos.core.dao.GestorProductosDAO;
import com.estopacomplementos.core.entity.ProductosEntityTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServiciosApplication.class)
public class TestMongo {
	
	@Autowired
	private GestorProductosDAO gestorProductosDAO;
	
	@Test
	public void prueba() {
		ProductosEntityTO entityTO = new ProductosEntityTO();
		entityTO.setNombreProudcto("PRUEBA");
		entityTO.setPrecio("100.00");
		gestorProductosDAO.prueba(entityTO);
	}

}
