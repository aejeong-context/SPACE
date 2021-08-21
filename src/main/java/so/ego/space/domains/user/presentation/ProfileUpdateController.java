package so.ego.space.domains.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import so.ego.space.domains.user.application.ProfileUpdateService;
import so.ego.space.domains.user.application.dto.ProfileUpdateRequest;

@RequiredArgsConstructor
@RestController
public class ProfileUpdateController {
    private final ProfileUpdateService profileUpdateService;

    @PostMapping("/user/{userId}/profile")
//    public String updateProfile(@RequestBody ProfileUpdateRequest profileUpdateRequest){
    public String updateProfile(@PathVariable Long userId, @RequestParam(required = false) MultipartFile profileImage){
        return profileUpdateService.updateProfile(userId, profileImage);

    }

    @PutMapping("/user/{userId}/profile")
    public void deleteProfile(@PathVariable Long userId){
         profileUpdateService.deleteProfile(userId);
    }

}
