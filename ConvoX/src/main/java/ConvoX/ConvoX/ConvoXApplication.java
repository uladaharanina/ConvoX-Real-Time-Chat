package ConvoX.ConvoX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConvoXApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvoXApplication.class, args);
		System.out.println("DB Username: " + System.getenv("DBusername"));
		System.out.println("DB Password: " + System.getenv("DB_PASSWORD"));
	}

}
