set GroupID=cmmdc
set ArtifactID=interface
set Version=1.0.0
mvn archetype:generate -B -DgroupId=%GroupID% -DartifactId=%ArtifactID% -DarchetypeArtifactId=maven-archetype-quickstart -Dversion=%Version%