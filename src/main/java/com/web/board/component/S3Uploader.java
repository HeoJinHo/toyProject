package com.web.board.component;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.web.board.construct.ErrorType;
import com.web.board.construct.RestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@Component
public class S3Uploader {

    private final AmazonS3Client amazonS3Client;
    private static final String FILE_EXTENSION_SEPARATOR = ".";
    private static final String CATEGORY_PREFIX = "/";
    private static final String TIME_SEPARATOR = "_";
    private static final int UNDER_BAR_INDEX = 1;
//    @Value("${cloud.aws.s3.bucket}")
    public String bucket = "toyproject-burket";  // S3 버킷 이름

    public String uploadFileV1(MultipartFile multipartFile) {
        validateFileExists(multipartFile);
        String category = "static";
        String fileName = buildFileName(category, multipartFile.getOriginalFilename());

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(multipartFile.getContentType());

        try (InputStream inputStream = multipartFile.getInputStream()) {
            amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            System.out.println("e = " + e);
        }

        return amazonS3Client.getUrl(bucket, fileName).toString();
    }

    private void validateFileExists(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            throw new RestException(ErrorType.REST_TEST);
        }
    }


    public static String buildFileName(String category, String originalFileName) {
        int fileExtensionIndex = originalFileName.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        String fileExtension = originalFileName.substring(fileExtensionIndex);

        return category + CATEGORY_PREFIX + UUID.randomUUID() + fileExtension;
    }

}
