package com.startech.restapi.Service;

        import com.startech.restapi.Persistence.User;
        import com.startech.restapi.Persistence.UserPersistence;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserPersistence persistence;

    public List<User> getAllUsers(){
        System.out.println("LOG: persistence for users");

        return persistence.findAll();}

}