package facturacion.api_factura.cliente;
import java.util.Date;

import lombok.Data;

@Data
public class CustomerDTO {
    private long id;
    private String cedula;
    private String nombres;
    private String apellidos;
    private Date fecha_nacimiento;
    private String direccion;
    private String convencional;
    private String celular;
    private String email;
    private boolean aceptado;
    private long institucion_is;
    private long sexo_id; 
}