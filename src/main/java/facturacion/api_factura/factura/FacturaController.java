package facturacion.api_factura.factura;

import java.util.List;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("api/factura")
@CrossOrigin({ "*" })
public class FacturaController {
    @Autowired
    FacturaService facturaService;

    @GetMapping("/")
    public List<Factura> findAll() {
        return facturaService.findAll();
    }

    @GetMapping("/{id}/")
    public Factura findById(@PathVariable Long id) {
        return facturaService.findById(id);
    }

    @PostMapping("/")
    public Factura save(@RequestBody Factura entity) {
        return facturaService.save(entity);
    }

    @PutMapping("/{id}/")
    public Factura update(@RequestBody Factura entity) {
        return facturaService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id) {
        facturaService.deleteById(id);
    }

    @GetMapping("/pdf/{id}/")
	public ResponseEntity<byte[]> getFacturaReporte(@PathVariable long id) throws JRException {

		JasperPrint reporte = facturaService.getFacturaReporte(id);
        
        if (reporte==null)
            return new ResponseEntity<byte[]>(null, null, HttpStatus.NOT_FOUND);
        
		HttpHeaders headers = new HttpHeaders();
		// set the PDF format
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("filename", "factura.pdf");
		// create the report in PDF format
		return new ResponseEntity<byte[]>
            (JasperExportManager.exportReportToPdf(reporte), headers, HttpStatus.OK);
	}

}
