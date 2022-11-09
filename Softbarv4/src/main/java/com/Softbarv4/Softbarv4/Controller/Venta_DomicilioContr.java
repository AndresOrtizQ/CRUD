package com.Softbarv4.Softbarv4.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Softbarv4.Softbarv4.Model.Venta_Domicilio;
import com.Softbarv4.Softbarv4.Service.Venta_DomicilioServ;

@RestController
@CrossOrigin
@RequestMapping("ventadomicilio")
public class Venta_DomicilioContr {

	@Autowired
	//service_respectivo_a_la_clase
	Venta_DomicilioServ  ventDomiServ;
	
	@GetMapping("/all")
	//Metodo_para_listar_toda_la_tabla
	public ArrayList<Venta_Domicilio> getAllVentaDomicilio(){
		return ventDomiServ.getAllVD();
	} 
	
	@GetMapping("/find/{id_venta_domicilio}")
	//Metodo_para_buscar_mediante_el_id
	public Optional<Venta_Domicilio> getVentaDomicilioById(@PathVariable("id_venta_domicilio") Long id_venta_domicilio ){
		return  ventDomiServ.getByIdVD(id_venta_domicilio);
	}
	
	@PostMapping("/save")
	//metodo_para_crear_y_realizar_update
	public Venta_Domicilio saveVentaDomicilio(@RequestBody Venta_Domicilio vd) {
		return ventDomiServ.saveVD(vd);
	}
	
	@ DeleteMapping("/delete/{id_venta_reserva}")
	//Metodo_para_borrar_con_el_id
	public  String deleteVentaDomicilioById(@PathVariable("id_venta_domicilio") Long id_venta_domicilio ) {
		if (ventDomiServ.deleteVD(id_venta_domicilio)) {
			return "Se ha eliminado el usuario";
		} else {
			return "No se ha eliminado el usuario";
		}
	}
	
}
