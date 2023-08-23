package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ForgotPasswordDTO {
	@NotBlank
	private String email;
	@NotBlank
	private String securityQuestion;
	
	@NotBlank
	private String newPassword;
	

}
