package facturacion.api_factura.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/producto")
@CrossOrigin({ "*" })
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/")
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}/")
    public Producto findById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping("/")
    public Producto save(@RequestBody Producto entity) {
        return productoService.save(entity);
    }

    @PutMapping("/{id}/")
    public Producto update(@RequestBody Producto entity) {
        return productoService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        productoService.deleteById(id);
    }
}
