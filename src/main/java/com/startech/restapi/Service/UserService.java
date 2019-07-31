package com.startech.restapi.Service;

        import com.startech.restapi.Persistence.Account;
        import com.startech.restapi.Persistence.UserPersistence;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserPersistence persistence;

    public List<Account> getAllUsers(){
        return persistence.findAll();}

    public Account getUser(Long id){
        return persistence.findById(id).orElse(null);
    }

    public void save(Account user) {
        persistence.save(user);
    }
}