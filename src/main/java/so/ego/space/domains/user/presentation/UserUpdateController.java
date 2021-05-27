package so.ego.space.domains.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.user.application.UserRegisterService;
import so.ego.space.domains.user.application.UserUpdateService;
import so.ego.space.domains.user.application.dto.UserUpdateNicknameRequest;
import so.ego.space.domains.user.application.dto.UserUpdateNicknameResponse;
import so.ego.space.domains.user.application.dto.UserUpdatePasswordRequest;
import so.ego.space.domains.user.application.dto.UserUpdatePasswordResponse;

@RequiredArgsConstructor
@RestController
public class UserUpdateController {
    private final UserUpdateService userUpdateService;

    // 닉네임 변경
    @PutMapping("/user/nickname")
    public UserUpdateNicknameResponse updateNickname(@RequestBody UserUpdateNicknameRequest userUpdateNicknameRequest){
        return userUpdateService.updateNickname(userUpdateNicknameRequest);
    }

    // 비밀번호 변경
    @PutMapping("/user/password")
    public UserUpdatePasswordResponse updatePassword(@RequestBody UserUpdatePasswordRequest userUpdatePasswordRequest){
        return userUpdateService.updatePassword(userUpdatePasswordRequest);
    }
}
