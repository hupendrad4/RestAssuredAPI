set projectPath=C:\Users\HDeore\SchlumbergerAutomation\MyTest\RestAssured
cd\
cd %projectPath%
set classpath=%projectPath%\bin;%projectPath%\lib\*;
java org.testng.TestNG testng.xml