package com.sena.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.evaluacion.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	// Puedes agregar métodos personalizados si lo necesitas, por ejemplo:
	Usuario findByEmail(String email);
}
