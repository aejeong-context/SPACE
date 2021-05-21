package so.ego.space.domains.user.application;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.user.application.dto.UserLoginRequest;
import so.ego.space.domains.user.application.dto.UserLoginResponse;
import so.ego.space.domains.user.domain.User;
import so.ego.space.domains.user.domain.UserRepository;

@RequiredArgsConstructor
@Service
public class UserLoginService {

    private final UserRepository userRepository;

    public UserLoginResponse loginUser(UserLoginRequest userLoginRequest){
        User user =  userRepository.
                findByEmailAndPassword(
                        userLoginRequest.getEmail(),
                        userLoginRequest.getPassword()
                ).orElseThrow(()-> new IllegalArgumentException("invalid user."));

        return UserLoginResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .build();

    }
}
