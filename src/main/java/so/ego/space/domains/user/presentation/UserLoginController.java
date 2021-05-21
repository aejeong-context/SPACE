package so.ego.space.domains.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.user.application.UserLoginService;
import so.ego.space.domains.user.application.UserRegisterService;
import so.ego.space.domains.user.application.dto.UserLoginRequest;
import so.ego.space.domains.user.application.dto.UserLoginResponse;

@RequiredArgsConstructor
@RestController
public class UserLoginController {
    private final UserLoginService userLoginService;

    @GetMapping("/user")
    public UserLoginResponse loginUser(@RequestBody UserLoginRequest userLoginRequest){
        return userLoginService.loginUser(userLoginRequest);

    }

}
