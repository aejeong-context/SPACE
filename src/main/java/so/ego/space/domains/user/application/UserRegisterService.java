package so.ego.space.domains.user.application;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.user.application.dto.*;
import so.ego.space.domains.user.domain.User;
import so.ego.space.domains.user.domain.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserRegisterService {

    private final UserRepository userRepository;

    // 회원가입
    public UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest) {
        User user = userRepository.save(
                User.builder()
                    .email(userRegisterRequest.getEmail())
                    .password(userRegisterRequest.getPassword())
                    .nickname(userRegisterRequest.getNickname())
                    .build()
        );
        return UserRegisterResponse.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .build();
    }

    // 이메일 중복검사
    public UserCheckEmailResponse emailCheck(UserCheckEmailRequest userCheckEmailRequest){
        boolean isExist = userRepository
                .existsByEmail(userCheckEmailRequest.getEmail());
       return UserCheckEmailResponse.builder()
               .email(userCheckEmailRequest.getEmail())
               .accept(isExist? false : true)
               .build();
    }

    // 회원 탈퇴
    public void userDrop(UserDropRequest userDropRequest) {
        User user = userRepository.findById(userDropRequest.getId())
                .orElseThrow(() ->  new IllegalArgumentException("invalid user."));
        userRepository.delete(user);
    }
}
