# Requirements Document
### Contents
1. [Introduction](#1)
2. [User Requirements](#2) <br>
  2.1. [Software Interfaces](#2.1) <br>
  2.2. [User Interfaces](#2.2) <br>
  2.3. [User Characteristics](#2.3) <br>
  2.4. [Assumptions and dependencies](#2.4) <br>
3. [System Requirements](#3) <br>
  3.1 [Functional Requirements](#3.1) <br>
  3.2 [Non-Functional Requierements](#3.2) <br>
4. [Analogues](#4) <br>

### Glossary
* A website is a collection of related web pages, including multimedia content, typically identified with a common domain name, and published on at least one web server. Notable examples are wikipedia.org, google.com, and amazon.com. 
* Online shopping is a form of electronic commerce which allows consumers to directly buy goods or services from a seller over the Internet using a web browser.

### 1\. Intoduction <a name="1"></a>
There are many online shops, but usually we need to find some products and check availability of them. For this purpose it is necessary to visit each of them.The solution is to create one web site which can search products we need in several online shops.

### 2\. User Requirements <a name="2"></a>
#### 2.1\. Software Interfaces <a name="2.1"></a>
The project uses jsp, css and bootstrap framework.
#### 2.2\. User Interfaces <a name="2.2"></a>
The GUI of the project is presented with the help of mocaps [main_page](https://github.com/NikMsh/Radio-details-from_Belchip-Chipdip.by/blob/master/Project%20Documentation/mockups/Main_page.png) and [found_product_page](https://github.com/NikMsh/Radio-details-from_Belchip-Chipdip.by/blob/master/Project%20Documentation/mockups/Found_product_page.png).The main page requires a separate view:

Button | Event
--- | ---
"Home" | Return or update the main page
"Exit" | Go to login page
"Search" | Find products required in the input field

#### 2.3\. User Characteristics <a name="2.3"></a>
People who need to find and check availability of radio components simultaneously from two online shops in Belarus belchip.by and chipdip.by.
#### 2.4\. Assumptions and dependencies<a name= " 2.4 " >< / a>
For the user: the presence of a modern browser and Internet connection.<br>
For developer: you must have JDK 8 or later, JRE 8 or later, Tomcat 9.0.6 server, and application jar file installed.
### 3\. System Requirements <a name="3"></a>
#### 3.1\. Functional Requirements <a name="3.1"></a>
Function | Requirements
--- | ---
Product search | user can find the product through the input field " search"
Select a directory from the list | get a list of products or subcatalogs by reference to one of the directories 
Return to main page | ability to go to main page
Back to list | ability to go to previous catalog

#### 3.2\. Non-Functional Requierements <a name="3.2"></a>
Low consumption of resources, ease of use due to the minimum interface, fast response speed to search for products and obtain catalogs, performance in various web browsers.
### 4\. Analogues <a name="4"></a>
This project is in some way a simplified version ["ScreamingFrog"](https://www.screamingfrog.co.uk/seo-spider/), ["Q-Parser"](https://q-parser.ru/), ["Netpeak Spider 3.0"](https://www.softpedia.com/get/Internet/Search-engine-tools-submiting/Netpeak-Spider.shtml) that greatly simplifies the use of.
