# healenium-example-maven
Java + Maven + Junit5 project with healenium usage example 

## How to start
### 1.Start Healenium backend from infra folder

```cd infra```

```docker-compose up -d```

Verify that images ```healenium/hlm-backend:latest``` and ```postgres:11-alpine``` are up and running

### 2. Project structure
```
|__pom.xml
   |__healenium-web-htmlelements
	  |__src
		 |__main
		    |__java
			   |__htmlelements.pages	
		 |__test
		    |__java
			   |__htmlelements.tests
			|__resources
			   |__healenium.properties			
   |__healenium-web-selenide
	  |__src
         |__main
		    |__selenide.pages
         |__test
			|__java
			   |selenide.tests	
			|__resources
			   |__healenium.properties			
   |__healenium-web-selenium
	  |__src
         |__main
			|__selenium.pages
         |__test
			|__java
			   |__selenium.tests	
			|__resources
			   |__healenium.properties	
``` 
			   
### 3.Run test in terminal with maven
> If you want to execute all tests, please use the command: 
```mvn clean test```

> If you want to execute tests from healenium-web-htmlelements module, please use the command: 
```mvn clean test -Dtest=HtmlElementTests -pl healenium-web-htmlelements/```

> If you want to execute tests from healenium-web-selenide module, please use the command: 
```mvn clean test -Dtest=SelenideTests -pl healenium-web-selenide/```
>> Also if you want to get an allure report you could use this command:
```mvn clean test -Dtest=SelenideTests -pl healenium-web-selenide/ allure:report```

> If you want to execute tests from healenium-web-selenium module, please use the command: 
```mvn clean test -Dtest=MarkupTest -pl healenium-web-selenium/```
>> Also if you want to get an allure report you could use this command:
```mvn clean test -Dtest=MarkupTest -pl healenium-web-selenium/ allure:report```


### 4.After test execution you should see generated report link in command line logs

![img.png](img.png)

Report contains only healed locators with old-new values and a button that tells if healing was successful for further algorithm corrections

![img_1.png](img_1.png)

### 5. Screenshots 

Also you could take a screenshots for your tests like it implements here: selenium.tests.BaseTest.screenshot

### 6. @DisableHealing annotation

If don't want to use Healenium in some methods just use @DisableHealing annotation. 
> The example of usage you can find here: selenium.pages.MainPageWithFindBy.checkLocatorTestButtonDontHealing 

![img_2.png](img_2.PNG)

### 7. Plugin Healenium for Intellij IDE

For updating broken locators you could use Plugin "Healenium" for Intellij IDE (https://plugins.jetbrains.com/plugin/14178-healenium).

With this plugin you can update your locators:
* on class level

![update_on_class_level](img_6.PNG)
* or on variable level

![update_on_class_level](img_5.PNG)

![element_update](img_4.png)
