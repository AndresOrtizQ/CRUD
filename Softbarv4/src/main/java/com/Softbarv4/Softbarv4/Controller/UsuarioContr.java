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

import com.Softbarv4.Softbarv4.Model.Rol;
import com.Softbarv4.Softbarv4.Model.Usuario;
import com.Softbarv4.Softbarv4.Service.UsuarioServ;

@RestController
@CrossOrigin
@RequestMapping("usuario")
public class UsuarioContr {

	
	
	@Autowired
	//service_respectivo_a_la_clase
	UsuarioServ usuServ;
	
	
	@GetMapping("/all")
	//Metodo_para_listar_toda_la_tabla
	public ArrayList<Usuario> getAllUser(){
		return usuServ.getAllU();
	} 
	
	@GetMapping("/find/{id_usuario}")
	//Metodo_para_buscar_mediante_el_id
	public Optional<Usuario> getUById(@PathVariable("id_usuario") Long id_usuario ){
		return usuServ.getByIdU(id_usuario);
	}
	
	@PostMapping("/save")
	//metodo_para_crear_y_realizar_update
	public Usuario saveU(@RequestBody Usuario u) {
		return usuServ.saveU(u);
	}
	
	@ DeleteMapping("/delete/{id_usuario}")
	//Metodo_para_borrar_con_el_id
	public  String deleteUById(@PathVariable("id_usuario") Long id_usuario ) {
		if (usuServ.deleteU(id_usuario)) {
			return "Se ha eliminado el usuario";
		} else {
			return "No se ha eliminado el usuario";
		}
	}
	
	@GetMapping("/rol")
	//Metodo_para_listar_toda_la_tabla
	public ArrayList<Rol> getAllRol(){
		return usuServ.getAllRol();
	} 
	
}
