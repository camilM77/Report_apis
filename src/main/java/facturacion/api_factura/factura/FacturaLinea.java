package facturacion.api_factura.factura;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import facturacion.api_factura.producto.Producto;

@Data
@Entity
public class FacturaLinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Producto producto;
    private BigDecimal cantidad;
    private BigDecimal precio;
}
