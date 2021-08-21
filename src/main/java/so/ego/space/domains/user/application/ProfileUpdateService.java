package so.ego.space.domains.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import so.ego.space.commons.aws.S3FileUploader;
import so.ego.space.domains.user.application.dto.ProfileUpdateRequest;
import so.ego.space.domains.user.domain.User;
import so.ego.space.domains.user.domain.UserRepository;

@RequiredArgsConstructor
@Service
public class ProfileUpdateService {
    private final UserRepository userRepository;
    private  final S3FileUploader s3FileUploader;

    @Transactional
    public String updateProfile(Long userId,MultipartFile profileImage) {
        // 유저 아이디
//        User user = userRepository.findById(profileUpdateRequest.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException("invalid user_id"));
//        // 이미지 경로
//        user.updateProfilePath(profileUpdateRequest.getPath());
//        return user.getProfile().getPath();
        String filePath = s3FileUploader.uploadImagesToS3(userId,profileImage);
        User user = userRepository.findById(userId)
             .orElseThrow(() -> new IllegalArgumentException("invalid user_id"));
        user.updateProfilePath(filePath);

        return filePath;
    }

    @Transactional
    public void deleteProfile(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Invalid UserId"));
        user.updateProfilePath("");

    }
}
