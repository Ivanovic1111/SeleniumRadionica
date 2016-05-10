# **XPath Introduction** #

----------

XPath is the language used for locating nodes in an XML document. As HTML can be an implementation of XML (XHTML), Selenium users can leverage this powerful language to target elements in their web applications.

**XPath Syntax**

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

The form elements can be located by using this xpath expression:

- "/html/body/form/input[1]" - Absolute path (would break if the HTML was changed only slightly)

- "//input[1]" - First input element in the HTML

- "//input[@name='password']" - First input element with attribute named ‘name’ and the value password

- "//input[@name='continue'][@type='button']" - Input with attribute named name and the value continue and attribute named type and the value button


----------

**The Firebug add-on for Firefox and FirePath extension**

It’s recommended to use Firebug add-on for Mozzila Firefox. This add-on allows the user to select the specific web element on a web page and Firebug will show the line of code that refers to that element. Firebug can be activated from browser toolbar Tools/Web Developer or by clicking F12 on the keyboard. 

FirePath is a Firebug extension that adds a development tool to edit, inspect and generate XPath expressions.

![](https://gitlab.levi9.com/qa/Code9-2015/raw/master/workshop2/img/XPathFirebug.png)

- Textbox 'Name':  "//*[@id='Name']"
- Button  'Add' :  "//*[@id='fsBig']/p/input or better path //input[@value='Add']"
- Radio buttons "Type': "//input[@id='Type'][@value='Restaurant']"

 



