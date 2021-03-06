# Cucumber for Java

In this example, the code for chapter 7 of the book is provided. While going through the commits, we'll begin by providing a basic maven skeleton and work our way towards the step definitions and implementations. 

So let's begin:

## Create a maven project from archetype

In order to create a maven project from an archetype, launch terminal and type the command below: 

`mvn archetype:generate 
-DartifactId=atm 
-DgroupId=nicebank 
-DinteractiveMode=false 
-DartifactArchetypeId=maven-archetype-quickstart`

## Add Cucumber Dependencies 

Now that we have a basic maven skeleton to work with, let's add the appropriate dependencies to the pom. Please refer to snippets below:

        <dependency>
            <groupId>info.cukes</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>1.1.6</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>info.cukes</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>1.1.6</version>
            <scope>test</scope>
        </dependency>
        
## Invoke Maven Install on Project to Get dependencies resolved and installed on .m2

To get the dependencies (cucumber jar files) resolved and installed on local, invoke the following command on root (make sure to `cd` into the folder where te `pom.xml` is located):

`mvn install`

**Notes:** if maven complains about the following `ERROR        `


`[ERROR] Source option 5 is no longer supported. Use 6 or later.
 [ERROR] Target option 1.5 is no longer supported. Use 1.6 or later.`
 
 it can be corrected by making the addition of the maven compiler plugin to the `pom.xml` and make it point to a different java version (example below)
 
 
    <build>
        <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>


## Add Cucumber Runner

The only missing piece to have a fully functional cucumber skeleton, is to add a runner. A runner is an empty class that instructs cucumber where the features and glue code is, and which class invoke to use the Junit runner. Refer to example below:

#### Class location

`src/test/java/nicebank/RunCukesTest.java`


```
package nicebank;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:nicebank",
glue = "classpath:nicebank")
public class RunCukesTest {
}
```
