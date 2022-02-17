package com.abw12.springbootawsdynamodb.config;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class DynamoDBConfig {

//    public static final String ACCESS_KEY = "AKIARBKK4UBPPT3PCL6G";
//    public static final String SECRET_KEY = "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";
//    public static final String SERVICE_ENDPOINT = "dynamodb.ap-south-1.amazonaws.com";
//    public static final String REGION = "ap-south-1";
//
//    @Bean
//    public DynamoDBMapper mapper(){
//        return new DynamoDBMapper(amazonDynamoDbConfig());
//    }
//
//    public AmazonDynamoDB amazonDynamoDbConfig() {
//
//        return AmazonDynamoDBClientBuilder.standard()
//                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION))
//                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY))).build();
//    }
}
