# Basics #

----------

A penetration test, or the short form pentest, is an attack on a computer system with the intention of finding security weaknesses, potentially gaining access to it, its functionality and data.

## 1. Introduction to web applications (client \- server architecture) ##
The [client\-server model](http://en.wikipedia.org/wiki/Client%E2%80%93server_model "wiki: Client-server model") of computing is a distributed computing structure that partitions tasks or workloads between the providers of a resource or service, called servers, and service requesters, called clients.

A [Web application](http://www.acunetix.com/websitesecurity/web-applications/ "acunetix: Web applications") (Web app) is an application program that is stored on a remote server and delivered over the Internet through a browser interface.


## 2. Communication: TCP/IP, HTTP, HTTPS, IP addresses, ports ##
The [Transmission Control Protocol (TCP)](http://en.wikipedia.org/wiki/Transmission_Control_Protocol "wiki: Transmission Control Protocol") provides reliable, ordered, and error\-checked delivery of a stream of octets between applications running on hosts communicating over an IP network. TCP is the protocol that major Internet applications such as the World Wide Web, email, remote administration and file transfer rely on. Applications that do not require reliable data stream service may use the [User Datagram Protocol (UDP)](http://en.wikipedia.org/wiki/User_Datagram_Protocol "wiki: User Datagram Protocol") , which provides a connectionless datagram service that emphasizes reduced latency over reliability.

The [Internet protocol suite](http://en.wikipedia.org/wiki/Internet_protocol_suite "wiki: Internet protocol suite") is the computer networking model and set of communications protocols used on the Internet and similar computer networks.

The [Hypertext Transfer Protocol (HTTP)](http://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol "wiki: Hypertext Transfer Protocol") is an application protocol for distributed, collaborative, hypermedia information systems.[1] HTTP is the foundation of data communication for the World Wide Web.

[HTTPS](http://en.wikipedia.org/wiki/HTTPS "wiki: HTTPS") ("HTTP over TLS", "HTTP over SSL" or "HTTP Secure") is a communications protocol for secure communication over a computer network, with especially wide deployment on the Internet. Technically, it is not a protocol in and of itself; rather, it is the result of simply layering the Hypertext Transfer Protocol (HTTP) on top of the SSL or TLS protocol, thus adding the security capabilities of SSL/TLS to standard HTTP communications. The main motivation for HTTPS is to provide authentication of the visited website and to protect the privacy and integrity of exchanged data.

The [Open Systems Interconnection model (OSI Model)](http://en.wikipedia.org/wiki/OSI_model "wiki: OSI model") is a conceptual model that characterizes and standardizes the internal functions of a communication system by partitioning it into abstraction layers. 

## 3. Introduction to proxies ##
In computer networks, a [proxy server](http://en.wikipedia.org/wiki/Proxy_server "wiki: Proxy server") is a server (a computer system or an application) that acts as an intermediary for requests from clients seeking resources from other servers.

## 4. Certificates ##
In cryptography, a [public key certificate](http://en.wikipedia.org/wiki/Public_key_certificate "wiki: Public key certificate") (also known as a digital certificate or identity certificate) is an electronic document used to prove ownership of a public key. The certificate includes information about the key, information about its owner's identity, and the digital signature of an entity that has verified the certificate's contents are correct. If the signature is valid, and the person examining the certificate trusts the signer, then they know they can use that key to communicate with its owner.

## 5. Linux basics (console) ##
[Linux](http://en.wikipedia.org/wiki/Linux "wiki: Linux") is a Unix\-like computer operating system assembled under the model of free and open\-source software development and distribution.

The [Linux Foundation](http://www.linuxfoundation.org/ "www.linuxfoundation.org") is a non\-profit consortium dedicated to fostering the growth of Linux. Founded in 2000, The Linux Foundation sponsors the work of Linux creator Linus Torvalds and is supported by leading Linux and open source companies and developers from around the world.

Tutorials: [www.linux.org](http://www.linux.org/ "www.linux.org")

Tutorials and Q/A: [www.linux.com](https://www.linux.com/ "www.linux.com")

[Kali Linux](http://en.wikipedia.org/wiki/Kali_Linux "Kali Linux") is a Debian\-derived Linux distribution designed for digital forensics and penetration testing. It is maintained and funded by Offensive Security Ltd. It was developed by Mati Aharoni and Devon Kearns of Offensive Security through the rewrite of BackTrack, their previous forensics Linux distribution. Official website can be found at [www.kali.org](https://www.kali.org/ "www.kali.org")

## 6. Introduction to injections (sql, xss) ##
[Code injection](http://en.wikipedia.org/wiki/Code_injection "wiki: Code injection") is the exploitation of a computer bug that is caused by processing invalid data. Code injection can be used by an attacker to introduce (or "inject") code into a computer program to change the course of execution. The results of a code injection attack can be disastrous. For instance, code injection is used by some computer worms to propagate.

[SQL injection](http://en.wikipedia.org/wiki/SQL_injection "wiki: SQL injection") is a code injection technique, used to attack data\-driven applications, in which malicious SQL statements are inserted into an entry field for execution (e.g. to dump the database contents to the attacker). SQL injection must exploit a security vulnerability in an application's software, for example, when user input is either incorrectly filtered for string literal escape characters embedded in SQL statements or user input is not strongly typed and unexpectedly executed. SQL injection is mostly known as an attack vector for websites but can be used to attack any type of SQL database.

You can find some examples here: [SQL injection example](http://www.w3schools.com/sql/sql_injection.asp "w3schools: SQL injection example")

SQL Injection by OWASP: [SQL injection OWASP](https://www.owasp.org/index.php/SQL_Injection "owasp: SQL injection")

[Cross\-site scripting](http://en.wikipedia.org/wiki/Cross-site_scripting "wiki: Cross-site scripting") (XSS) is a type of computer security vulnerability typically found in Web applications. XSS enables attackers to inject client\-side script into Web pages viewed by other users. A cross\-site scripting vulnerability may be used by attackers to bypass access controls such as the same\-origin policy. Cross\-site scripting carried out on websites accounted for roughly 84% of all security vulnerabilities documented by Symantec as of 2007. Their effect may range from a petty nuisance to a significant security risk, depending on the sensitivity of the data handled by the vulnerable site and the nature of any security mitigation implemented by the site's owner.

## 7. Introduction to path traversal ##
[Directory traversal](https://www.owasp.org/index.php/Path_Traversal "owasp: Path Traversal") is an HTTP exploit which allows attackers to access restricted directories and execute commands outside of the web server's root directory. An Access Control List is used in the authorization process.

More about directory (path) traversal atacks could be found [here](http://www.acunetix.com/websitesecurity/directory-traversal/ "acunetix: directory traversal") and [here](http://en.wikipedia.org/wiki/Directory_traversal_attack "wiki: Directory traversal attack").

## 8. Introduction to OWASP top 10 ##

The [OWASP Top Ten](https://www.owasp.org/index.php/Top_10_2013-Top_10 "OWASP Top Ten") is a list of the 10 most dangerous current Web application security flaws, along with effective methods of dealing with those flaws. OWASP (Open Web Application Security Project) is an organization that provides unbiased and practical, cost\-effective information about computer and Internet applications. Project members include a variety of security experts from around the world who share their knowledge of vulnerabilities, threats, attacks and countermeasures.

## 9. Installing Firefox plugins (foxyproxy) ##
**This step\-by\-step walkthrough refers to Kali linux.**

1. start the ***firefox*** by using `<ALT>+<F2>` and type in `firefox`
2. by using ***firefox*** google for ***foxyproxy*** plugin and follow the install instructions

## 10. Setting up Foxyproxy ##
[Foxyproxy](http://getfoxyproxy.org/ "getfoxyproxy: Foxyproxy") is a set of proxy and VPN management tools for OS/X, Windows, iOS, Android, Chrome, Firefox, and Linux.

## 11. Introduction to BurpSuite, sqlmap and dirb ##
[Burp Suite](http://portswigger.net/burp/ "portswigger: Burp Suite") is an integrated platform for performing security testing of web applications. Its various tools work seamlessly together to support the entire testing process, from initial mapping and analysis of an application's attack surface, through to finding and exploiting security vulnerabilities.

## 12. Lab ##
-	[Lab 1](Lab1.md "Lab 1"): Using [sqlmap](http://sqlmap.org/ "sqlmap.org")
-	[Lab 2](Lab2.md "Lab 2"): Using [dirb](http://dirb.sourceforge.net/ "dirb.sourcefoge.net")
-	[Lab 3](Lab3.md "Lab 3"): Performing different injections (xss + sql) using [burpsuite](http://portswigger.net/burp/ "portswigger: Burp suite")

Attack surface: Mutillidae, WebGoat or similar app.