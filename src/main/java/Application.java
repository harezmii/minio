import io.minio.*;
import io.minio.messages.Bucket;

import java.util.List;

public class Application {

    public static void main(String[] args) {


        try {

            // MinioClient minioClient = new MinioClient("http://127.0.0.1:9000/","minioadmin","minioadmin");
            MinioClient minioClient =  MinioClient.builder()
                    .endpoint("https://s3.amazonaws.com")
                    .credentials("AKIAI3GX7LDPFQW444IQ","4YnoBmXuk4GtVbBRUWL2TqNZaHL7Emj/XtAmkzfk")
                    .region("eu-west-1")
                    .build();

            /*
            List<Bucket> buckets = minioClient.listBuckets();

            for (Bucket bucket : buckets){
                minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucket.name()).build());
            }
            System.out.println("Tamama");

            */

            boolean isBucket = minioClient.bucketExists(BucketExistsArgs.builder().bucket("suatim1").build());

            if(isBucket){
             //   minioClient.putObject("denemem2","denemem.txt","C:\\Users\\harezmi\\Desktop\\coursera_hive_impala.txt",null);
                minioClient.removeBucket(RemoveBucketArgs.builder().bucket("suatim1").build());
            }
            else {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("suatim1").build());
                minioClient.putObject("suatim1","denemem.txt","C:\\Users\\harezmi\\Desktop\\coursera_hive_impala.txt",null);

                System.out.println("Bucket is created");
            }


        }catch (Exception e){
            System.out.println("Hata var");
        }
    }
}
