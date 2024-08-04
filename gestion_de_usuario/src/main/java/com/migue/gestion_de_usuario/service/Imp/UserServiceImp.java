package com.migue.gestion_de_usuario.service.Imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.migue.gestion_de_usuario.dto.UserDTO;
import com.migue.gestion_de_usuario.mapper.UserMapper;
import com.migue.gestion_de_usuario.model.User;
import com.migue.gestion_de_usuario.repository.UserRepository;
import com.migue.gestion_de_usuario.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository ur;

	@Override
	public UserDTO createUser(UserDTO userDto) {
		User user = UserMapper.INSTANCE.toEntity(userDto);
		User userSave = ur.save(user);

		return UserMapper.INSTANCE.toDTO(userSave);
	}

	@Override
	public UserDTO getUserById(Long Id) {
		return UserMapper.INSTANCE.toDTO(ur.findById(Id).orElse(null));
	}

	@Override
	public List<UserDTO> getAllUsers() {
//		List<User> userList = ur.findAll();

		return ur.findAll().stream().map(UserMapper.INSTANCE::toDTO).collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, Long Id) {

		User user = ur.findById(Id).orElseThrow(() -> new RuntimeException("User not found"));

		user.setNombre(userDto.getNombre());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		ur.save(user);

		return UserMapper.INSTANCE.toDTO(user);
	}

	@Override
	public void deleteUser(Long Id) {

		ur.delete(ur.findById(Id).orElseThrow(() -> new RuntimeException("User not found")));

	}

}
