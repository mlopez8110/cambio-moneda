package com.cambio.api.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cambio.api.model.Cambio;
import com.cambio.api.repository.CambioRepository;

//@Component
@Service
public class CambioService {
	
	@Autowired
	private CambioRepository cambioRepository;
	
    public List<Cambio> getAllCambio(){
        List<Cambio> listcambio= cambioRepository.findAll();
        return listcambio;
    }
	
	public Map<String, Object> cambiarMoneda(String monedaorigen,Double monto,String monedafinal) {
		
		List<Cambio> cambio=cambioRepository.findByMonedaNative(monedafinal,monedaorigen);
		
	    Map<String, Object> map = new LinkedHashMap<>();
		
		if (cambio.isEmpty())
		{
			map.put("Error", "No Existe moneda a cambiar");
			return map;
		}
		else
		{
	        Double tipocambio = cambio.get(0).getTipocambio();
	        Double total = monto*tipocambio;
			
		    map.put("monedaOrigen", monedaorigen);
		    map.put("montoCambio", monto);
		    map.put("monedaFinal", monedafinal);
		    map.put("tipocambio", tipocambio);
		    map.put("totalcambio", total);
		    return map;

		}
		
	}
	
	
	public Cambio guardarCambio(Cambio cambio) {
		
		return cambioRepository.save(cambio);		
	}
	
	
	public Object actualizar(Long Id,Cambio cambio) {
		
		Optional<Cambio> buscarCambio = cambioRepository.findById(Id);

		if (buscarCambio.isEmpty())
		{
			return "No se encuentra ID";
		}
		else
		{
			buscarCambio.get().setMonedaorigen(cambio.getMonedaorigen());
			buscarCambio.get().setTipocambio(cambio.getTipocambio());
			return this.guardarCambio(buscarCambio.get());

		}

	}

}
