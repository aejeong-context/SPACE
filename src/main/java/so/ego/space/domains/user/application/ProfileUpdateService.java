package so.ego.space.domains.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.user.application.dto.ProfileUpdateRequest;
import so.ego.space.domains.user.domain.User;
import so.ego.space.domains.user.domain.UserRepository;

@RequiredArgsConstructor
@Service
public class ProfileUpdateService {
    private final UserRepository userRepository;
    public String updateProfile(ProfileUpdateRequest profileUpdateRequest) {
        User user = userRepository.findById(profileUpdateRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("invalid user_id"));
        user.updateProfilePath(profileUpdateRequest.getPath());
        return user.getProfile().getPath();
    }
}
