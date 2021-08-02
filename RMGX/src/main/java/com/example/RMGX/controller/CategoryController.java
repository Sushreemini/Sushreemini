package com.example.RMGX.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RMGX.entity.Category;
import com.example.RMGX.repository.CategoryRepository;

@RestController
public class CategoryController {
	
	
   @Autowired
   CategoryRepository categoryRepository;

   
   @PostMapping("/Category")
	public ResponseEntity<Category> save(@RequestBody Category category){
	   try {
		   return new ResponseEntity<>( categoryRepository.save(category),HttpStatus.CREATED);
	   }catch(Exception e) {
		   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	   }
		
	}
   @GetMapping("/Category")
   public ResponseEntity<List<Category>>getAllCategory(){
	   try {
		   List<Category> list=categoryRepository.findAll();
		   if(list.isEmpty() || list.size()==0) {
			   return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		   }
		   return new  ResponseEntity<List<Category>>(list,HttpStatus.OK);
		   
	   }catch(Exception e) {
		   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	   }

   }
	@GetMapping("/Category/{id}")
public ResponseEntity<Category> getSingleCategory(@PathVariable Long id){
	
			Optional<Category> customer=categoryRepository.findById(id);
			if(customer.isPresent()) {
				return new ResponseEntity<Category>(customer.get(),HttpStatus.OK);
			}
		
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
	@PutMapping("/Category/{id}")
	public ResponseEntity<Category>updateCategory(@RequestBody Category category){
		try {
			return new ResponseEntity<Category>(categoryRepository.save(category),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/Category/{id}")
	public ResponseEntity<HttpStatus> deleteCategory(@PathVariable Long id){
		try {
			Optional<Category> category=categoryRepository.findById(id);
			if(category.isPresent()) {
				categoryRepository.delete(category.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	}


