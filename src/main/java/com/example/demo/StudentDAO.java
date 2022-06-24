package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDAO {
	@Autowired
	StudentRepository repo;

	
//insert a single object
public Student insert(Student s) {
	return repo.save(s);
}

//retrieve all the objects
public List<Student> getall(){
	return repo.findAll();
}

//insert a collection of objects
public List<Student> insertall(List<Student> s){
	return repo.saveAll(s);
}


//fetch by id
public Student getByid(int id) {
	return repo.findById(id).orElse(null);
}


//delete an id
public String deleteByid(int id) {
	repo.deleteById(id);
	return "deleted the id of value"+id;
}



//update->find the value and save it
//student 1 karthik k@c.c  update to ->1 pavan k@c.c
public Student update(Student s) {
	Student stu=repo.findById(s.getSid()).orElse(null);
	stu.setName(s.getName());
	return repo.save(stu);
}

}
