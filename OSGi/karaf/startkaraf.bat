set JAVA_HOME=c:\Program Files\Java\jdk1.8.0_05
set KARAF_HOME=d:\JavaApp\apache-karaf-3.0.1
del %KARAF_HOME%\lock
del %KARAF_HOME%\data\log\*
del %KARAF_HOME%\instances\*
rmdir %KARAF_HOME%\instances

%KARAF_HOME%\bin\karaf.bat clean