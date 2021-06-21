package so.ego.space.commons.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@NoArgsConstructor
public class S3FileUploader {

    private static final Logger logger = LogManager.getLogger(S3FileUploader.class);

    @Value("${custom.aws.s3.ACCESS_KEY}")
    private String accessKey;

    @Value("${custom.aws.s3.SECRET_KEY}")
    private String secretKey;

    private final String BUCKET_NAME = "ego-workspace-fileserver";

    private final String BUCKET = "https://ego-workspace-fileserver.s3-ap-northeast-2.amazonaws.com/";

    private AmazonS3 s3Client;

    @PostConstruct
    public void setS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        this.s3Client =
                AmazonS3ClientBuilder.standard()
                        .withRegion(Regions.AP_NORTHEAST_2)
                        .withCredentials(new AWSStaticCredentialsProvider(credentials))
                        .build();
    }

    public String uploadFile(String userId, MultipartFile file) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(MediaType.IMAGE_PNG_VALUE);
        objectMetadata.setContentLength(file.getSize());
        String uploadPath = createObjectPath(userId, file.getOriginalFilename());
        PutObjectRequest putObjectRequest = null;
        try {
            putObjectRequest =
                    new PutObjectRequest(
                            BUCKET_NAME, uploadPath, file.getInputStream(), objectMetadata)
                            .withCannedAcl(CannedAccessControlList.PublicRead);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        s3Client.putObject(putObjectRequest);

        return BUCKET + uploadPath;
    }

    public void deleteFile(String path) {
        String key = path.split(".com/")[1];
        try {
            DeleteObjectsRequest multiObjectDeleteRequest =
                    new DeleteObjectsRequest(BUCKET_NAME).withKeys(key).withQuiet(false);
            DeleteObjectsResult delObjRes = s3Client.deleteObjects(multiObjectDeleteRequest);
            int successfulDeletes = delObjRes.getDeletedObjects().size();
            logger.debug("S3 : Number of files deleted : {}", successfulDeletes);
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
        s3Client.deleteObject(BUCKET_NAME, key);
    }

    private String createObjectPath(String key, String fileName) {
        return String.join(
                "/", key, LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY/MM-dd")), fileName);
    }

    public String uploadImagesToS3(Long userId,MultipartFile productImage) {
        return uploadFile(String.valueOf(userId),productImage);
    }
}