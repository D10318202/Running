package com.springboot.running;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {
	
	//List<Person> findByIdGreaterThanEqualAndAuthorLike(Integer id, String author);
	public List<Person> findByFirstName(String firstName);
	
	
	@Transactional
	@Modifying
	@Query("update Person p set p.firstName = :inputFirstName where p.id = :inputId")
	public void updateByPersonId(@Param("inputFirstName") String firstName,
			                     @Param("inputId") Long id);
	
	@Transactional
	@Query("select p from Person p where p.id = :inputId")
	public List<Person> queryByPersonId(@Param("inputId") String id);
	

	

}
