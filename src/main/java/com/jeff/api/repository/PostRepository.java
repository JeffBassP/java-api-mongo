package com.jeff.api.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.jeff.api.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, Serializable> {
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchByTitle(String text);
}
