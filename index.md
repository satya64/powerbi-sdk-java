# PowerBI Java SDK - Home Page

### Introduction

This library is a wrapper around Microsoft PowerBI REST API. This includes a singleton class wrapper around Retrofit HTTP client and makes synchronous calls to PowerBI REST API using API classes.

### Usage

Add the maven dependency in your project as below
    
    <dependency>
        <groupId>io.github.satya64</groupId>
        <artifactId>powerbi-sdk-java</artifactId>
        <version>VERSION</version>
    </dependency>
    
    
Start by getting a singleton instance for class 'PowerBiClient' class. To create this instance you need to pass the AD access token.

String accessToken = "..............";

PowerBiClient client = PowerBiClient.getInstance(accessToken);

Once obtaining the client instance, you can make calls to perform various operations on report, dashboard, groups, datasets, and generate embed tokens for report/dashboard/tiles.

Example:

    client.getReportOperations().getReports() -- fetches all reports for account associated with access token passed.
    
   Another example to get datasets in Group/workspace,
   
    client.getDatasetOperations().getDatasetsInGroup(groupId) -- fetches all datasets in group/workspace for account associated with access token passed.


--- TODO ---