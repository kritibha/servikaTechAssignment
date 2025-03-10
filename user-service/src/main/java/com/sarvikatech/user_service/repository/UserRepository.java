package com.sarvikatech.user_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarvikatech.user_service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findAll();
	Optional<User> findById(Long id);
	void deleteById(Long id);
}
