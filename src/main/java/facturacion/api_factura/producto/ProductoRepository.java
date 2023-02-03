package facturacion.api_factura.producto;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    public List<Producto> findAll();
}
