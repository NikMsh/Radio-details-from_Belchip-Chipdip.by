# Requirements Document
### Contents
1. [Introduction](#1)
2. [User Requirements](#2) <br>
  2.1. [Software Interfaces](#2.1) <br>
  2.2. [User Interfaces](#2.2) <br>
  2.3. [User Characteristics](#2.3) <br>
3. [System Requirements](#3.) <br>
  3.1 [Functional Requirements](#3.1) <br>
  3.2 [Non-Functional Requierements](#3.2) <br>
    3.2.1 [Software Quality Attributes](#3.2.1) <br>
    3.2.1.1 [External Quality Criteria](#3.2.1.1) <br>
    3.2.1.2 [Internal Quality Criteria](#3.2.1.2) <br>
4. [Analogues](#4) <br>

### Glossary
* A website is a collection of related web pages, including multimedia content, typically identified with a common domain name, and published on at least one web server. Notable examples are wikipedia.org, google.com, and amazon.com. 
* Online shopping is a form of electronic commerce which allows consumers to directly buy goods or services from a seller over the Internet using a web browser.

### 1\. Intoduction <a name="1"></a>
There are many online shops, but usually we need to find some products and check availability of them. For this purpose it is necessary to visit each of them.The solution is to create one web site which can search products we need in several online shops.

### 2\. User Requirements <a name="2"></a>
#### 2.1\. Software Interfaces <a name="2.1"></a>The project uses jsp, css and bootstrap framework.
#### 2.2\. User Interfaces <a name="2.2"></a>The GUI of the project is presented with the help of mocaps[main_page]() and [found_product_page]().The main page requires a separate view:

Button | Event
--- | ---
"Home" | Return or update the main page
"Exit" | Go to login page
"Search" | Find products required in the input field

#### 2.3\. User Characteristics <a name="2.3"></a>
People who need to find and check availability of radio components simultaneously from two online shops in Belarus belchip.by and chipdip.by.
#### 3\. System Requirements <a name="3"></a>For user: run the application on the web-browser by link.
For developer: you should have JDK 8 or later, JRE 8 or later, Tomcat server 9.0.6 and application jar file.
#### 3.1\. Functional Requirements <a name="3.1"></a>
The user is given the opportunities provided in the table.

Function | Requirements
--- | ---
Search product | The application should find products by your requirements 
Click on the catalog from list | Get product lists by clicking on the link 
Ability to return  back to main page | The application should provide the ability to return to the main page by pressing “Main” in navigational bar 
Ability to return  back to the list | The application should provide the ability to return back to the list by pressing “Back” 

#### 3.2\. Non-Functional Requierements <a name="3.2"></a>
##### 3.2.1\. Software Quality Attributes <a name="3.2.1"></a>
##### 3.2.1.1 External Quality Criteria <a name="3.2.1.1"></a>
Important external criteria for this application are: low resource consumption and high performance, namely parsing of https://belchip.by/catalog/ and https://www.ru-chipdip.by/.
##### 3.2.1.2 Internal Quality Criteria <a name="3.2.1.2"></a>
Internal criteria are: Easy to use due to a minimal interface, fast response speed to find products and get catalogs of them, Portability between different web-browsers.
### 4\. Analogues <a name="4"></a>
This project is in some way a simplified version ["ScreamingFrog"](https://www.screamingfrog.co.uk/seo-spider/), ["Q-Parser"](https://q-parser.ru/), ["Netpeak Spider 3.0"](https://www.softpedia.com/get/Internet/Search-engine-tools-submiting/Netpeak-Spider.shtml) that greatly simplifies the use of.
