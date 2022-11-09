package com.Softbarv4.Softbarv4.Impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.Model.Rol;
import com.Softbarv4.Softbarv4.Model.Usuario;
import com.Softbarv4.Softbarv4.Repo.RolRepo;
import com.Softbarv4.Softbarv4.Repo.UsuarioRepo;
import com.Softbarv4.Softbarv4.Service.UsuarioServ;

@Service
public class UsuarioImpl implements UsuarioServ {

	@Autowired
	//Repositorio_del_servicio
	UsuarioRepo usurepo;
	
	@Autowired
	RolRepo rolRepo;
	
	
	@Override
	public ArrayList<Usuario> getAllU() {
		// metodo_de_listar
		return (ArrayList<Usuario>) usurepo.findAll();
	}

	@Override
	public Optional<Usuario> getByIdU(Long id_usuario) {
		// Metodo_de_encontrar_por_id
		return usurepo.findById(id_usuario);
	}

	@Override
	public Usuario saveU(Usuario u) {
		// Metodo_de_update_y_crear
		return usurepo.save(u);
	}

	@Override
	public boolean deleteU(Long id_usuario) {
		// Metodo_de_borrar
		try {
			Optional<Usuario> u = getByIdU(id_usuario);
			usurepo.delete(u.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<Rol> getAllRol() {
		// TODO Auto-generated method stub
		return (ArrayList<Rol>) rolRepo.findAll();
	}

}
