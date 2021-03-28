package rest.todo.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//import javax.xml.bind.annotation.XmlRootElement;

public class Utilisateur {


    private String id;
    private String username;
    private String password;
    private String role;



    public Utilisateur(String id, String username, String password,String role){
        this.id = id;
        this.username = username;
        this.password = password;
        this.setRole(role);
    }
    public Utilisateur( String username, String password){
        this.username = username;
        this.password = password;
    }
    public Utilisateur() {
    	
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}




}
