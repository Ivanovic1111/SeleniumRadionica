# XPath

XPath is the language used for **locating nodes** in an XML document. It models an XML document as a tree of nodes. As HTML can be an implementation of XML (XHTML), Selenium users can leverage this powerful language to target elements in their web applications.

You can use XPath to locate the element with:

- absolute path (not advised)

			    //html/body/form/input[2]

- relative path, to an element that does have an id or name attribute 

			    //input[@name='username']

The result of an Xpath expression can be various data types, e.g. sets of nodes, a single node, a number, etc.

### Firebug add-on for Firefox and FirePath extension

It’s recommended to use Firebug add-on for Mozzila Firefox. This add-on allows the user to select the specific web element on a web page and Firebug will show the line of code that refers to that element. 
To add the Firebug add-on for Firefox use the [link](https://addons.mozilla.org/en-US/firefox/addon/firebug/).


FirePath is a Firebug extension that adds a development tool to edit, inspect and generate XPath expressions. To add the FirePath use the [link](https://addons.mozilla.org/en-US/firefox/addon/firepath/).

### Syntax

XPath uses path expressions to select nodes or node-sets in an XML document.  

For instance, consider this page source:

	<html>
     <body>
      <form id="loginForm">
       <input name="username" type="text" />
	   <input name="password" type="password" />
	   <input name="continue" type="submit" value="Login" />
	   <input name="continue" type="button" value="Clear" />
	  </form>
	 </body>
    <html>

The *form* elements can be located by using XPath expression:

- "/html/body/form/input[1]" - Absolute path (would break if the HTML was changed only slightly)

- "//input[1]" - First input element in the HTML

- "//input[@name='password']" - First input element with attribute named ‘name’ and the value password

- "//input[@name='continue'][@type='button']" - Input with attribute named name and the value continue and attribute named type and the value button

The *username* element can be located by using XPath expression:

- //form[input/@name='username']" - First form element with an input child element with attribute named name and the valueusername

- //form[@id='loginForm']/input[1]" - First input child element of the form element with attribute named id and the value loginForm

- "//input[@name='username']" - First input element with attribute named ‘name’ and the value username

The *“Clear” button* element can be located by using XPath expression:

- "//input[@name='continue'][@type='button']" - Input with attribute named name and the value continue and attribute named type and the value button

- "//form[@id='loginForm']/input[4]" - Fourth input child element of the form element with attribute named id and value loginForm

### Exercises

With help of the locators table create XPath expressions for Albums.xml.

Tasks:

1. Select all the albums

2. Select all the tracks in all albums

3.  Select all albums of the Kings Of Leon artist

4. Select all tracks in all albums by the Kings Of Leon

5. Select the second album

6. Select all tracks with a rating greater than 2

7. Select BlackThumbnail track

8. Select all artist whose name is starts from "The"

9. Select all albums with [EP] title

Extra task:

In FoodOrders application add new restaurant and locate its name over XPath.