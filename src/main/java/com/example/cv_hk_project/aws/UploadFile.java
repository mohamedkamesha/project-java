package com.example.cv_hk_project.aws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import java.io.IOException;
import java.io.InputStream;




public class UploadFile {
    private final static  String bucketName = "mycvfile";


    public static String upload(String fileName , InputStream inputStream ) throws IOException {

        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create("AKIAXMQHKAN3DLF4LE6Y","WKdcPK4l7SYC9VH0VShneo0nXHIihkolqMISsz1b");
        StaticCredentialsProvider staticCredentialsProvider = StaticCredentialsProvider .create(awsBasicCredentials);

        Region region = Region.US_EAST_1;
        AwsCredentialsProvider provider = staticCredentialsProvider ;

        S3Client client = S3Client.builder().credentialsProvider(provider).region(region).build();
        PutObjectRequest request = PutObjectRequest.
                builder().
                bucket(bucketName).
                key(fileName).
                acl("public-read").
                build();



        client.putObject(request,RequestBody.fromInputStream(inputStream, inputStream.available()) );

        client.close();

        return "cv uploaded";
    }

}
