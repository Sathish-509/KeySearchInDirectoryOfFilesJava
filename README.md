"# KeySearchInDirectoryOfFilesJava" 

* Steps to execute either below
* Compile the project as mvn install
* run the application using java -jar
or use
* Intellij set up java and maven
* In File-> Settings change the jdk version to compile
* Add Configuration to run the application
(Add Configuration -> Templates -> Application -> Create
configuration -> provide configuration name
in vm options if you want to run provide particular profile,
in this case its not required,
change the Shorten command to Janifest)

* In postman, provide 
URL: localhost:8080/search/v1/getlistoffiles
Method: POST
Body: 
{
	"directoryPath": "E:\\Technical\\searchbykey",
	"searchKey": "contains"
}

```
Sample Output:
[
    "E:\\Technical\\searchbykey\\.mvn\\wrapper\\MavenWrapperDownloader.java",
    "E:\\Technical\\searchbykey\\mvnw.cmd",
    "E:\\Technical\\searchbykey\\src\\main\\java\\com\\sathish\\practice\\searchbykey\\searchkey\\ServiceSearchKey.java"
]
```
