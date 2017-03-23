# url-pinger
url-pinger

## Pre-requisites

* Java 8
* Maven
* Junit

## How to build the project

mvn clean install

## Solutions for Q2.2 , Q2.3

### Run the main class
mvn exec:java -Dexec.mainClass="com.ping.executor.PingTest" -Dexec.args="http://google.com http://yahoo.com"

## Solutions for Q2.4

mvn test -Dtest=PingTest
