package itse1909r.borangaziyev.service;

import itse1909r.borangaziyev.model.User;
import itse1909r.borangaziyev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public boolean batchInsertUsers(List<User> users) {
        int []inserted = userRepository.batchInsert(users);
        if(inserted.length != 0 || Arrays.stream(inserted).allMatch(row -> row != 0)) return true;

        return false;
    }

    public boolean insertUser(User user) {
        return userRepository.insertUser(user);
    }
}
