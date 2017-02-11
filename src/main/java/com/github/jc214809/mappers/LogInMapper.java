package com.github.jc214809.mappers;

import org.apache.ibatis.annotations.*;

import com.github.jc214809.model.RegistrationDetails;

public interface LogInMapper {
	
	@Insert("INSERT INTO `Users`( `socialId`, `emailAddress`, `firstName`, `lastName`, `gender`) VALUES (#{socialId},#{emailAddress},#{firstName},#{lastName},#{gender})")
	public void registerUser(RegistrationDetails registrationDetails);
	
	@Select("Select COUNT(*) from Users WHERE socialId = #{socialId}")
	public int checkIfRegistered(@Param("socialId") String socialId);
	
}
