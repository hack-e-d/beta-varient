package vijay.projects.betavarient.Controllers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vijay.projects.betavarient.Exceptions.DuplicateUserException;
import vijay.projects.betavarient.Exceptions.NoUserFoundException;
import vijay.projects.betavarient.Repositories.UserRepository;
import vijay.projects.betavarient.Entities.Users;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    public static Logger logger  = LogManager.getLogger(UserController.class);

    @GetMapping("/users")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Users getUser(@PathVariable String id) {
        Users user = userRepository.findOne(Integer.parseInt(id));
        if(user == null) {
            throw new NoUserFoundException();
        }
        logger.log(Level.INFO,"Found User : "+ user.toString());
        return user;
    }

    @PostMapping("/addUser")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Users addUser(@RequestBody Users users) {
        List<Users> usersList = userRepository.findAll();
        if(usersList.contains(users)) {
            throw new DuplicateUserException();
        }
        System.out.println(users.toString());
        return userRepository.save(users);
    }

//    @PutMapping("/updateUser")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public Users(@ResponseBody Users users) {
//
//    }
}
