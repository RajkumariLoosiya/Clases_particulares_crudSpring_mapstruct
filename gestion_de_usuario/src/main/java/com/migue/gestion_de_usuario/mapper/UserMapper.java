package com.migue.gestion_de_usuario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;import com.migue.gestion_de_usuario.dto.UserDTO;
import com.migue.gestion_de_usuario.model.User;
import com.migue.gestion_de_usuario.vo.UserVO;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserVO toVo(UserDTO userDto); 
	
	UserDTO toDto (UserVO userVo);
	
	User toEntity(UserDTO userDto); 
	
	UserDTO toDTO (User user);

}
