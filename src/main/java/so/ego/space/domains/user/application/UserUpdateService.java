package so.ego.space.domains.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.user.application.dto.*;
import so.ego.space.domains.user.domain.User;
import so.ego.space.domains.user.domain.UserRepository;

@RequiredArgsConstructor
@Service
public class UserUpdateService {
    private final UserRepository userRepository;

    // 닉네임 변경
    @Transactional
    public UserUpdateNicknameResponse updateNickname(UserUpdateNicknameRequest userUpdateNicknameRequest) {
        User user = userRepository.findById(userUpdateNicknameRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("invalid user id."));
        // 닉네임을 변경한다.
        user.updateNickname(userUpdateNicknameRequest.getNickname());
        return UserUpdateNicknameResponse.builder()
                .id(userUpdateNicknameRequest.getId())
                .new_nickname(userUpdateNicknameRequest.getNickname()).build();
    }

    // 비밀번호 변경
    @Transactional
    public UserUpdatePasswordResponse updatePassword(UserUpdatePasswordRequest userUpdatePasswordRequest) {
        // 이메일, 비밀번호가 일치하는지 확인한다.
        User user = userRepository.findByEmailAndPassword(
                userUpdatePasswordRequest.getEmail(),
                userUpdatePasswordRequest.getOld_password()
        ).orElseThrow(()-> new IllegalArgumentException("invalid user id."));
        // 비밀번호를 변경한다.
        user.updatePassword(userUpdatePasswordRequest.getNew_password());
        return UserUpdatePasswordResponse.builder()
                .password(userUpdatePasswordRequest.getNew_password())
                .build();
    }

    // 프로필 이미지 변경

}
