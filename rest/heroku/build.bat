set groupId=resources
set artifactId=hw
set package="unitbv.cs.td"
set jersey-version=2.13
mvn archetype:generate -DarchetypeArtifactId=jersey-heroku-webapp -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false -DgroupId=%groupId% -DartifactId=%artifactId% -Dpackage=%package% -DarchetypeVersion=%jersey-version%
