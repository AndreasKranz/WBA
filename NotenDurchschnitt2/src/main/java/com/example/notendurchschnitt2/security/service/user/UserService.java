package com.example.notendurchschnitt2.security.service.user;

import com.example.notendurchschnitt2.security.model.User;
import com.example.notendurchschnitt2.security.model.UserCreateForm;
import com.example.notendurchschnitt2.security.service.dto.UserDTO;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    UserDTO getUserById(long id);

    Optional<User> getUserByEmail(String email);

    boolean existsByNickname(String nickname);

    boolean existsByEmail(String email);

    Collection<UserDTO> getAllUsers();

    User create(UserCreateForm form);
}
