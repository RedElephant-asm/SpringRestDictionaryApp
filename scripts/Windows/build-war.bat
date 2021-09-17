@echo off

call .\environment.bat

mvn -f %PROJECT_DIRECTORY%/pom.xml package