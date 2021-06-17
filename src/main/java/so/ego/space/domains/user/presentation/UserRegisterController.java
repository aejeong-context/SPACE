package so.ego.space.domains.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import so.ego.space.domains.user.application.UserLoginService;
import so.ego.space.domains.user.application.UserRegisterService;
import so.ego.space.domains.user.application.dto.*;

@RequiredArgsConstructor
@RestController
public class UserRegisterController {

    private final UserRegisterService userRegisterService;

    @PostMapping("/user")
    public UserRegisterResponse registerUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        return userRegisterService.registerUser(userRegisterRequest);
    }

    @GetMapping("/user/email")
    public UserCheckEmailResponse checkEmail(@RequestParam String email) {
        return userRegisterService.emailCheck(email);
    }

    @DeleteMapping("/user")
    public void UserDrop(@RequestBody UserDropRequest userDropRequest){
        userRegisterService.userDrop(userDropRequest);
    }
}
