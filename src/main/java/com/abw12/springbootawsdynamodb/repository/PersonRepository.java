package com.abw12.springbootawsdynamodb.repository;

import com.abw12.springbootawsdynamodb.entity.Person;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonRepository {
    public static final String ACCESS_KEY = "";
    public static final String SECRET_KEY = "";
    public static final String SERVICE_ENDPOINT = "";
    public static final String REGION = "";


//    @Autowired
    private DynamoDBMapper mapper =new DynamoDBMapper(amazonDynamoDbConfig());


    private AmazonDynamoDB amazonDynamoDbConfig() {

        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY))).build();
    }

    public Person addPerson(Person person){
        mapper.save(person);
        return person;
    }

    public Person findPersonById(String personId){
        return mapper.load(Person.class,personId);
    }

    public String deletePerson(Person person){
        mapper.delete(person,buildDeleteExpression(person));
        return "Person Removed!!";
    }

    public String editPerson(Person person){
        mapper.save(person,buildExpression(person));
        return "Updated Person...";
    }

    private DynamoDBSaveExpression buildExpression(Person person){
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
        expectedMap.put("personId",new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }

    private DynamoDBDeleteExpression buildDeleteExpression(Person person){
        DynamoDBDeleteExpression dynamoDBDeleteExpression=new DynamoDBDeleteExpression();
        Map<String,ExpectedAttributeValue> expectedMap=new HashMap<>();
        expectedMap.put("personId",new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));
        dynamoDBDeleteExpression.setExpected(expectedMap);
        return dynamoDBDeleteExpression;
    }
}
