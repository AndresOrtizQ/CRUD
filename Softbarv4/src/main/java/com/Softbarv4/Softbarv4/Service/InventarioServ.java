package com.Softbarv4.Softbarv4.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.Softbarv4.Softbarv4.Model.Inventario;

public interface InventarioServ {

	ArrayList<Inventario> getAllI();
	Optional<Inventario> getByIdI(Long id_inventario);
	Inventario saveI (Inventario i);
	boolean deleteI(Long id_inventario);
}
