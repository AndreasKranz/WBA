package com.example.notendurchschnitt2.security.service.user;

import com.example.notendurchschnitt2.Note.model.Note;
import com.example.notendurchschnitt2.security.model.User;
import com.example.notendurchschnitt2.security.model.UserCreateForm;
import com.example.notendurchschnitt2.security.repository.UserRepository;
import com.example.notendurchschnitt2.security.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUserById(long id) {
        log.debug("getting user={}", id);
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format(">>> User=%s not found", id)));
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        log.debug("getting user by email={}");
        return userRepository.findOneByEmail(email);
    }

    @Override
    public boolean existsByNickname(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.debug("getting all users");
        List<User> targetListOrigin = userRepository.findAllByOrderByNicknameAsc();
        List<UserDTO> targetList= new ArrayList<>();
        for (User source: targetListOrigin ) {
            UserDTO target= new UserDTO();
            BeanUtils.copyProperties(source , target);
            targetList.add(target);
        }
        return targetList;
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setNickname(form.getNickname());
        user.setPassword(form.getPassword());
        user.setRole(form.getRole());
        user.setNotenListe(new ArrayList<Note>());
        return userRepository.save(user);
    }
}
