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
import com.Softbarv4.Softbarv4.Model.Inventario;
import com.Softbarv4.Softbarv4.Service.InventarioServ;

@RestController
@CrossOrigin
@RequestMapping("inventario")
public class InventarioContr {

	@Autowired
	//service_respectivo_a_la_clase
	InventarioServ invenServ;
	
	@GetMapping("/all")
	//Metodo_para_listar_toda_la_tabla
	public ArrayList<Inventario> getAllUser(){
		return invenServ.getAllI();
	} 
	
	@GetMapping("/find/{id_inventario}")
	//Metodo_para_buscar_mediante_el_id
	public Optional<Inventario> getUById(@PathVariable("id_inventario") Long id_inventario ){
		return  invenServ.getByIdI(id_inventario);
	}
	
	@PostMapping("/save")
	//metodo_para_crear_y_realizar_update
	public Inventario saveU(@RequestBody Inventario i) {
		return invenServ.saveI(i);
	}
	
	@ DeleteMapping("/delete/{id_inventario}")
	//Metodo_para_borrar_con_el_id
	public  String deleteUById(@PathVariable("id_inventario") Long id_inventario ) {
		if (invenServ.deleteI(id_inventario)) {
			return "Se ha eliminado el usuario";
		} else {
			return "No se ha eliminado el usuario";
		}
	}
	
}
