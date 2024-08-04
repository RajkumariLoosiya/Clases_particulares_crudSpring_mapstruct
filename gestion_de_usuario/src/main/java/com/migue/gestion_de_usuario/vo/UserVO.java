package com.migue.gestion_de_usuario.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserVO {

	private Long id;

	private String nombre;

	private String email;
	
	private String password; 

}
