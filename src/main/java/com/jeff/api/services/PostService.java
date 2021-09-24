package com.jeff.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.api.domain.Post;
import com.jeff.api.repository.PostRepository;
import com.jeff.api.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll() {

		return postRepository.findAll();
	}

	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);

		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.searchByTitle(text);
	}
	
}
