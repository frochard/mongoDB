package tp7.mongoDB;

import java.net.UnknownHostException;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws UnknownHostException{
		Morphia morphia = new Morphia();
		Mongo mongo = new Mongo();
		morphia.map(Person.class).map(Address.class);
		Datastore ds = morphia.createDatastore(mongo, "my_database");
		//Creation des personnes
		Person p1 = new Person();
		p1.setName("Tintin");
		Person p2 = new Person();
		p2.setName("Capitaine Haddock");
		Person p3 = new Person();
		p3.setName("Professeur Tournessol");
		//Creation des adresses
		Address a1 = new Address();
		a1.setStreet("123 avenue des champs élysée");
		a1.setCity("Paris");
		a1.setPostCode("75 000");
		a1.setCountry("France");
		Address a2 = new Address();
		a2.setStreet("Chateau de Moulinsart");
		a2.setCity("Brussels");
		a2.setPostCode("99 999");
		a2.setCountry("Belgique");
		//set address
		p1.setAddress(a1);
		p2.setAddress(a2);
		p3.setAddress(a2);
		// Sauvegarde des personnes en base
		ds.save(p1);
		ds.save(p2);
		ds.save(p3);
		//Affichage des personnes enregistrées en base
		System.err.println("---------PEOPLE----------");
		for (Person e : ds.find(Person.class)){
			System.err.println(e.toString());
		}
		System.err.println("----------------------");
		//Creation des articles
		Article art1 = new Article();
		art1.setName("Chivas Regal 12 Year Old Whisky");
		art1.setStars(5);
		art1.setBuyer(p2);
		Article art2 = new Article();
		art2.setName("Pendule");
		art2.setStars(3);
		art2.setBuyer(p3);
		Article art3 = new Article();
		art3.setName("Parapluie");
		art3.setStars(4);
		art3.setBuyer(p1);
		art3.setBuyer(p3);
		// Sauvegarde des personnes en base
		ds.save(art1);
		ds.save(art2);
		ds.save(art3);
		//Affichage des articles enregistrés en base
		System.err.println("---------ARTICLES----------");
		for (Article art : ds.find(Article.class)){
			System.err.println(art.toString());
		}
		System.err.println("----------------------");
	}
}