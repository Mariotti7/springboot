package com.api.blogpessoal.repository;

import java.util.List;	

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.blogpessoal.model.ModelBlog;

public interface BlogRepository extends JpaRepository<ModelBlog, Long>{
	
	List<ModelBlog> findById(long id);
	
	public List<ModelBlog> findAllByTituloContainingIgnoreCase (String content);
}
