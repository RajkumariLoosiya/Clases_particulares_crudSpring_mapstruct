package com.migue.gestion_de_usuario.service;

import java.util.List;

import com.migue.gestion_de_usuario.dto.UserDTO;

public interface UserService {
	
	public UserDTO createUser(UserDTO userDto);
	
	public UserDTO getUserById(Long Id);
	
	public List<UserDTO> getAllUsers();
	
	public UserDTO updateUser(UserDTO userDto,Long id);
	
	public void deleteUser(Long Id); 

}
