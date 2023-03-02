package com.ty.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.user.entity.User;
import com.ty.user.exception.ResourceNotFoundException;
import com.ty.user.userrepo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {


	@Autowired
	private UserRepo urepo;

	@GetMapping(" ")
	public String welcomePage()
	{
		return "Welcome To UserManagement System";
	}
	// Create User or Save User

	@PostMapping("/save")
	public User SaveUser(User user)
	{
		return urepo.save(user);
	}

	// Retrive or Get All Records

	@GetMapping("/getall")
	public List<User> getAll()
	{
		return urepo.findAll();
	}

	//Delete User By Id
	@DeleteMapping("/removebyid/{id}")
	public String removeById(@PathVariable(value = "id") int id)
	{
		User user = urepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Id,Please Enter Valid Id"));
		if(user !=null)
		{
			urepo.deleteById(id);
			return "Record Delete Successfully";
		}
		return null;

	}

	@GetMapping("/getbyid/{id}")
	public User getById(@PathVariable(value = "id") int id)
	{
		return urepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Id,Please Enter Valid Id"));

	}
	
	@PutMapping("/updatebyid/{id}")
	public User updateById(@RequestBody User user,@PathVariable(value = "id")int id)
	{
		User u = this.urepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Id,Please Enter Valid Id"));
	   
	    u.setLoc(user.getLoc());
	    u.setName(user.getName());	
	    u.setPhno(user.getPhno());
	    return urepo.save(u);
	    
	}
	

	





}
