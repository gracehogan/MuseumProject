package stepdefinitions;


import com.barclays.MuseumApiApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;


@CucumberContextConfiguration
@SpringBootTest(classes= MuseumApiApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberSpringConfiguration {
}


//Things to do next:
//Rewrite the two new features to remove any hardcoded values
//Write all of the connecting glue for another endpoint, controller, service, repository, populator
//Write a feature that has a post AND a get in two separate steps that can test that something is being created correctly and then retrieved.
//Bonus: try one of the other more complex mapping scenarios One-to-many and write a feature test for it!
//Bonus: Have fun and try whatever else you want
