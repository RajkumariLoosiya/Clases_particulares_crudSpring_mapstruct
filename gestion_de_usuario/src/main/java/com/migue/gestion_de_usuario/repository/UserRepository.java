package com.migue.gestion_de_usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.migue.gestion_de_usuario.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
