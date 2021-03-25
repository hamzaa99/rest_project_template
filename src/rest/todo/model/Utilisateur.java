package rest.todo.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//import javax.xml.bind.annotation.XmlRootElement;
@JsonTypeInfo(
	      use = JsonTypeInfo.Id.NAME, 
	      include = JsonTypeInfo.As.PROPERTY, 
	      property = "type")
	    @JsonSubTypes({
	        @JsonSubTypes.Type(value = Admin.class, name = "admin"),
	        @JsonSubTypes.Type(value = Customer.class, name = "customer")
	    })
public abstract class Utilisateur {


    private String id;
    private String username;
    private String password;
   


    public Utilisateur(String id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
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




}
