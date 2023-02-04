package dev.yestoday.yestoday.core.user.application;

import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.dto.UserDTO;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public List<User> findAll() { return userRepository.findAll(); }

    public List<User> save(UserDTO newUser) {
        userRepository.save(newUser.toUserEntity());
        return userRepository.findAll();
    }

    public List<User> delete(Long id){
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

    public User findById(Long id) {
        String message = String.format("%s에 해당하는 User 가 없습니다.", id);

        User user = userRepository.findById(id).orElseThrow(()->new NoSuchElementException(message));
        return user;
    }

    public User findByNickname(String nickname) {
        String message = String.format("%s에 해당하는 User 가 없습니다.", nickname);
        System.out.println(nickname);
        User user = userRepository.findByNickname(nickname).orElseThrow(()->new NoSuchElementException(message));
        return user;
    }


}