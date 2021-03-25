package rest.todo.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("customer")
public class Customer extends Utilisateur{

	public Customer(String id, String username, String password) {
		super(id, username, password);
		// TODO Auto-generated constructor stub
	}

}
