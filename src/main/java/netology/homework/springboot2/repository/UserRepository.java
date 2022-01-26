package netology.homework.springboot2.repository;

import netology.homework.springboot2.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {

        return new ArrayList<>();
    }
}