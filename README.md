# PowerBI Java SDK

## License
[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/satya64/powerbi-sdk-java/blob/master/LICENSE)
![Java CI with Gradle](https://github.com/satya64/powerbi-sdk-java/workflows/Java%20CI%20with%20Gradle/badge.svg)

## Introduction

This is simple Java client(synchronous) over Microsoft PowerBI REST API using Retrofit HTTP client. It is wrapped around the common functionality available in the PowerBI REST API.

## Background

The official PowerBI page doesn't have an API for Java developers to access - ![PowerBI Dev Center](https://powerbi.microsoft.com/en-us/developers/). The alternative way is to use REST clients in java to access the functionality. So, that is the motivation to create this API which will enable developers to quickly and easily access the PowerBI in Java applications.

## Installation

### Maven

    <dependency>
        <groupId>io.github.satya64</groupId>
        <artifactId>powerbi-sdk-java</artifactId>
        <version>1.0.0</version>
    </dependency>

### Gradle

    compile group: 'io.github.satya64', name: 'powerbi-sdk-java', version: '1.0.0'

### Usage

PowerBI clients depend on authentication tokens from Azure AD for allowing access to the powerbi resources for all activities. As such it it required to know the basics of authentication flow from below links.

https://docs.microsoft.com/en-us/azure/active-directory/azuread-dev/v1-authentication-scenarios

Below will help with acquiring tokens based on the type of your application.

https://github.com/AzureAD/azure-activedirectory-library-for-java/wiki/ADAL4J-Basics

https://github.com/AzureAD/azure-activedirectory-library-for-java/wiki/Acquire-tokens

Once access token acquired, powerbi client instance can be initilized.

    PowerBiClient client = PowerBiClient.getInstance(accessToken);

This will instantiate the client and that's mostly enough for us get started with operations inside the API. Below are examples how you can access different operations related to Report, Dashboard, EmbedToken, Group, etc.

 1. List your reports in your organization.
 
        client.getReportOperations().getReports(); // Returns a list of reports of user.
    
 2. List reports in a group that you have access.
    
        client.getReportOperations().getReportsInGroup(groupId); // Returns a list of reports associated with group/workspace
  
  <TODO> more examples
   
Access tokens will have an expiry time, after which access requests will be denied. So new access toke need to be acquired and submitted to client instance.

    client.updateAccessToken(newAccessToken);
    
This will internally update the Retrofit client configured in the API and requests can be continued using the client.

## Upcoming improvements
 
 We have thought of some more changes to improve the API.
 
 - Add adal4j authentication to incorporate token generation using the client itself.
