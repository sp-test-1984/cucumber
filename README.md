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
