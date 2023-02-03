package facturacion.api_factura.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "bff.customer", url = "http://localhost:8000/api/persona")
public interface CustomerClient {

    @GetMapping("/{id}/")
    CustomerDTO findCustomerById(@PathVariable("id") Long id);
}
