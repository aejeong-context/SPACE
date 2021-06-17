package so.ego.space.domains.user.application;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.user.application.dto.*;
import so.ego.space.domains.user.domain.Profile;
import so.ego.space.domains.user.domain.ProfileRepository;
import so.ego.space.domains.user.domain.User;
import so.ego.space.domains.user.domain.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserRegisterService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    // 회원가입
    @Transactional
    public UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest) {

        Profile profile = profileRepository.save(Profile.builder().path("").build());

        User user = userRepository.save(
                User.builder()
                    .email(userRegisterRequest.getEmail())
                    .password(userRegisterRequest.getPassword())
                    .nickname(userRegisterRequest.getNickname())
                        .profile(profile)
                    .build()
        );
        return UserRegisterResponse.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .build();
    }

    // 이메일 중복검사
    public UserCheckEmailResponse emailCheck(String email){
        boolean isExist = userRepository
                .existsByEmail(email);
       return UserCheckEmailResponse.builder()
               .email(email)
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
