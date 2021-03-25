package rest.todo.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("admin")
public class Admin extends Utilisateur {

	public Admin(String id, String username, String password) {
		super(id, username, password);
		// TODO Auto-generated constructor stub
	}

}
