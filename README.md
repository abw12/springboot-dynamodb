# springboot-dynamodb
Simple springboot CRUD service which interact with aws dynamoDB using aws sdk

Add Below dependancy in pom.xml aws-java-sdk-dynamodb
<dependency>
			<groupId>com.amazonaws</groupId>
			<artifactId>aws-java-sdk-dynamodb</artifactId>
			<version>1.12.129</version>
</dependency>

Add IAM policy and attach it to a Group/User in aws console
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action":   [ "dynamodb:PutItem" ],
      "Resource": [ "*" ]
    },
    {
      "Effect": "Allow",
      "Action":   [ "sns:Publish" ],
      "Resource": [ "*" ]
    }
  ]

Sample Request JSON
{
	"name":"abw12",
	"email":"abw12@gmail.com",
	"age":30,
	"address":{
		"city":"Bangalore",
		"state":"karnataka",
		"pinCode":"560037"
	}
}
