@echo off

::  Project directory
set PROJECT_DIRECTORY=C:\Users\ksavchenko\Documents\Projects\Java\SpringRestDictionaryApp

::  Available Tomcat versions
set TOMCAT9_VERSION=9.0.52
set TOMCAT10_VERSION=10.0.10

set CURRENT_TOMCAT_VERSION=%TOMCAT9_VERSION%

:: Tomcat required variables
set CATALINA_HOME=C:\Program Files\Apache\Tomcat\apache-tomcat-%CURRENT_TOMCAT_VERSION%
set CLASSPATH=%CATALINA_HOME%\bin

:: Custom variables
set TOMCAT_HOME=%CATALINA_HOME%
set TOMCAT_BIN=%CLASSPATH%

set PATH=%PATH%;%TOMCAT_BIN%;

set WAR_PACKAGE_DIRECTORY=%PROJECT_DIRECTORY%\target
set WAR_PACKAGE_NAME=SpringRestDictionaryApp-1.0-SNAPSHOT.war
set WAR_DESTINATION_DIRECTORY=%TOMCAT_HOME%\webapps