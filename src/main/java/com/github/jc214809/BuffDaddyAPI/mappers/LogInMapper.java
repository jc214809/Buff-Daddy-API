package com.github.jc214809.BuffDaddyAPI.mappers;

import org.apache.ibatis.annotations.*;

import com.github.jc214809.BuffDaddyAPI.model.RegistrationDetails;

@Mapper
public interface LogInMapper {
	
	@Insert("INSERT INTO `Users`( `socialId`, `emailAddress`, `firstName`, `lastName`, `gender`) VALUES (#{socialId},#{emailAddress},#{firstName},#{lastName},#{gender})")
	void registerUser(RegistrationDetails registrationDetails);
	
	@Select("Select COUNT(*) from Users WHERE socialId = #{socialId}")
	int checkIfRegistered(@Param("socialId") String socialId);
	
}
