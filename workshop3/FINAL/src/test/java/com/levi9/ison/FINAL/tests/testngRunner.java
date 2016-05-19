package com.levi9.ison.FINAL.tests;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;

import java.util.List;

import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.levi9.ison.jbehave.JBehaveStoryEmbedderForTestNG;

public class testngRunner extends JBehaveStoryEmbedderForTestNG {
   
	

	 @org.testng.annotations.Test 
	    public void run() throws Throwable {
		 System.out.println("run method in testngRunner class");
	    	Embedder embedder = configuredEmbedder();
	        try {
	        	embedder.runStoriesAsPaths(storyPaths());
	        	System.out.println("runStoriesAsPaths");
	        } finally {
	            embedder.generateCrossReference();
	        }
	    }

		protected List<String> storyPaths() {
			System.out.println("storyPaths method in testngRunner class");
			final String searchInDirectory = codeLocationFromPath("src/test/resources").getFile();
			final String[] stories = { "**/*.story"};
			return new StoryFinder().findPaths(searchInDirectory, asList(stories),null);
		}
		
		 // Here we specify the steps classes
		@Override
		 public InjectableStepsFactory stepsFactory() {
			System.out.println("stepsFactory: ");
			
			//dodati Steps klasu
			return new InstanceStepsFactory(new MostUsefulConfiguration(), new AgileTestingSteps());
			
		 }
	 
}
