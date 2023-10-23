package com.cambio.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cambio.api.model.Cambio;
import com.cambio.api.service.CambioService;

@RestController
@RequestMapping("api/cambio")
public class CambioController {
	
    @Autowired
    private CambioService cambioService;
    
	@GetMapping("/listatipocambio")
    public List<Cambio> getAllCambio(){
        return cambioService.getAllCambio();
    }
	
    
	@PostMapping("monedaorigen/{monedaorigen}/monto/{monto}/monedafinal/{monedafinal}")
	public Map<String, Object> cambiarMoneda(@PathVariable String monedafinal,@PathVariable String monedaorigen,@PathVariable Double monto){

	  return cambioService.cambiarMoneda(monedaorigen,monto, monedafinal);
	}
	
    @PostMapping("/guadarcambio")
    public Cambio guardarCambio(@RequestBody Cambio cambio){
        return cambioService.guardarCambio(cambio);
    }
	
	@PutMapping("/updatecambio/{id}")
	public Object updateCambio(@PathVariable Long id, @RequestBody Cambio cambio)
	{
		return cambioService.actualizar(id,cambio);
	}

}
