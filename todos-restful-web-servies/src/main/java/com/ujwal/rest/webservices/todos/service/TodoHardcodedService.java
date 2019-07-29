package com.ujwal.rest.webservices.todos.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ujwal.rest.webservices.todos.Todo;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static long idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "ujwal", "Love to play cricket", new Date(), false));
		todos.add(new Todo(++idCounter, "ujwal", "Love to singing", new Date(), false));
		todos.add(new Todo(++idCounter, "ujwal", "Love to do drawing", new Date(), false));
		todos.add(new Todo(++idCounter, "ujwal", "Love to reading books", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(long id) {

		Todo todo = findById(id);
		if (todo == null)
			return null;
		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		// TODO Auto-generated method stub
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}

		}
		return null;
	}
	
	public Todo save(Todo todo) {
		if (todo.getId()==-1 || todo.getId()==0 )
		{
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	
}
