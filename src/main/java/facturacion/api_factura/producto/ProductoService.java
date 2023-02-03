package facturacion.api_factura.producto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository entityRepository;

    public Producto save(Producto entity) {
        return entityRepository.save(entity);
    }

    public Producto findById(Long id) {
        return entityRepository.findById(id).orElse(new Producto());
    }

    public void deleteById(Long id) {
        entityRepository.deleteById(id);
    }

    public List<Producto> findAll() {
        return entityRepository.findAll();
    }
}
