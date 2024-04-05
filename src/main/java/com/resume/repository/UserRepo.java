package com.resume.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.resume.entities.UserDtls;

public interface UserRepo extends JpaRepository<com.resume.entities.UserDtls, Integer> {
	public com.resume.entities.UserDtls findByemail(String string);
	@Query("select u from UserDtls u where u.email =:email")
	public UserDtls getUserByUserName(@Param("email") String email);
	
}
