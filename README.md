# PowerBI Java SDK

## License
[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/satya64/powerbi-sdk-java/blob/master/LICENSE)
![Java CI with Gradle](https://github.com/satya64/powerbi-sdk-java/workflows/Java%20CI%20with%20Gradle/badge.svg)

## Introduction

This is simple Java client over Microsoft PowerBI REST API as there is no Microsoft provided java library available - 
![PowerBI Dev Center](https://powerbi.microsoft.com/en-us/developers/)

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

Once added to your code, you initialize the client as below.

    PowerBiClient client = PowerBiClient.getInstance(accessToken);
