set GroupId=resources
set ArtifactId=hw
set jersey-version=2.22.1
set Version=1.0
mvn -B archetype:generate -DgroupId=%GroupId% -DartifactId=%ArtifactId% -Dversion=%Version% -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false -DarchetypeVersion=%jersey-version%
rem mvn archetype:generate -DgroupId=%groupId% -DartifactId=%artifactId% -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false -Dpackage=HelloWorld -DarchetypeVersion=2.4.1
