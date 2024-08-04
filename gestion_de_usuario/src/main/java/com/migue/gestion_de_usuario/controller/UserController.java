package com.migue.gestion_de_usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.migue.gestion_de_usuario.dto.UserDTO;
import com.migue.gestion_de_usuario.mapper.UserMapper;
import com.migue.gestion_de_usuario.service.UserService;
import com.migue.gestion_de_usuario.vo.UserVO;

@RestController
@RequestMapping("/migue/beanUsuarios")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("/createUser")
	public UserDTO createUser(@RequestBody UserVO userVo) {
		return us.createUser(UserMapper.INSTANCE.toDto(userVo));
	}
	
	@GetMapping("/findUserById/{Id}")
	public UserDTO findUserById(@PathVariable Long Id) {
		return us.getUserById(Id);
	}
	
	@GetMapping("/findAllUsers")
	public List<UserDTO> findAllUsers() {
		return us.getAllUsers();
	}
	
	@PutMapping("/updateUserById/{Id}")
	
	public UserDTO updateUserById(@RequestBody UserVO usVo, @PathVariable Long Id) {
		
		return us.updateUser(UserMapper.INSTANCE.toDto(usVo), Id);
	}
	
	@DeleteMapping("/deleteUserById/{Id}")
	public void deleteUserById(@PathVariable Long Id) {
		us.deleteUser(Id);
	}
}
