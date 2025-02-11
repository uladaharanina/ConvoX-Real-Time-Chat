package AuthService.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import AuthService.Models.User;

public interface IUserRepo extends MongoRepository<User, String> {

    User findByUsername(String username);

}
