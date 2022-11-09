package com.Softbarv4.Softbarv4.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.Softbarv4.Softbarv4.Model.Rol;
import com.Softbarv4.Softbarv4.Model.Usuario;

public interface UsuarioServ {
	
	ArrayList<Usuario> getAllU();
	Optional<Usuario> getByIdU(Long id_usuario);
	Usuario saveU (Usuario u);
	boolean deleteU(Long id_usuario);
	ArrayList<Rol> getAllRol();  
}
