package tp7.mongoDB;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Person {

	@Id
	private ObjectId id;
	private String name;
	@Embedded
	private List<Address> adressList;

	public Person() {
		this.adressList =new ArrayList<Address>();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAdress() {
		return adressList;
	}

	public void setAddress(Address adress) {
		this.adressList.add(adress);
	}
	
	public String toString(){
		return ("Name : "+this.name+"\nId : "+this.id+"\nAdresses : "+this.adressList);
	}
}