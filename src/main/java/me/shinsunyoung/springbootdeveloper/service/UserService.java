package me.shinsunyoung.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.dto.AddUserRequest;
import me.shinsunyoung.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import me.shinsunyoung.springbootdeveloper.domain.User;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest request) {
        return userRepository.save(User.builder()
                .email(request.getEmail())
                // 패스워드 암호화
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .build()).getId();
    }
}
