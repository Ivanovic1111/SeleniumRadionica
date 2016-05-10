package com.levi9.ison.FoodOrdersISON.core;

import java.util.List;

import org.apache.log4j.Logger;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.embedder.Embedder;

/**
 * This class is a simple replacement of JUnitStories.
 * It simply annotates run() method as TestNG test!!
 */
public abstract class testNGStories extends ConfigurableEmbedder {

	
	static Logger LOGGER = Logger.getLogger(testNGStories.class);

    @org.testng.annotations.Test 
    public void run() throws Throwable {
        Embedder embedder = configuredEmbedder();
        try {
            embedder.runStoriesAsPaths(storyPaths());
        } finally {
            embedder.generateCrossReference();
        }
    }

    protected abstract  List<String> storyPaths();
	 
}