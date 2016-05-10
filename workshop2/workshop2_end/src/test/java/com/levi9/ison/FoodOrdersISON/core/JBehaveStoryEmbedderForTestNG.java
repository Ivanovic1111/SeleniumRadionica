package com.levi9.ison.FoodOrdersISON.core;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.levi9.ison.FoodOrdersISON.steps.LoginSteps;
import com.levi9.ison.FoodOrdersISON.steps.MealSteps;
import com.levi9.ison.FoodOrdersISON.steps.RestaurantSteps;


/**
 * This embedder allows to run JBehave stories as JUnit tests in TestNG
 * I used http://jbehave.org/reference/stable/getting-started.html as a basis.
 * */
public class JBehaveStoryEmbedderForTestNG extends testNGStories {

	
    static Logger log = Logger.getLogger(JBehaveStoryEmbedderForTestNG.class);
    
    // Here we specify the configuration, starting from default MostUsefulConfiguration, and changing only what is needed
    @Override
    public Configuration configuration() {
        // partially based upon http://jbehave.org/reference/stable/reporting-stories.html
        log.info("configuration()");
        Class<? extends Embeddable> embeddableClass = this.getClass();
        Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
        return new MostUsefulConfiguration()
                // where to find the stories
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                 // CONSOLE and TXT reporting
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                                .withDefaultFormats()
                                .withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
                                .withViewResources(viewResources)
                                .withFormats(Format.CONSOLE, Format.HTML, Format.XML, Format.TXT)
                                .withFailureTrace(true)
                                .withFailureTraceCompression(true));
    }

    // Here we specify the steps classes
	@Override
	 public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(new MostUsefulConfiguration(),new LoginSteps(), new RestaurantSteps(), new MealSteps());
	 }

	@Override
	protected List<String> storyPaths() {
	final String searchInDirectory =
	codeLocationFromPath("src/test/resources").getFile();
	final String[] stories = { "**/Login.story", "**/Restaurant.story", "**/Meal.story"};
	return new StoryFinder().findPaths(searchInDirectory, asList(stories),null);
	}
}