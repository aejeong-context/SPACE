package so.ego.space.domains.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.user.application.ProfileUpdateService;
import so.ego.space.domains.user.application.dto.ProfileUpdateRequest;

@RequiredArgsConstructor
@RestController
public class ProfileUpdateController {
    private final ProfileUpdateService profileUpdateService;

    @PutMapping("/user/profile")
    public String updateProfile(@RequestBody ProfileUpdateRequest profileUpdateRequest){
        return profileUpdateService.updateProfile(profileUpdateRequest);

    }
}
