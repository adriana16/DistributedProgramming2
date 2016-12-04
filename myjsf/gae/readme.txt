1. In catalogul war/WEB-INF/lib se copiaza resursele din apache-myfaces
Varianta originala javax-faces-2.2.13 genereaza eroara in executie.

2. Fisierul appengine-web.xml se completeaza cu 

<sessions-enabled>true</sessions-enabled>

3. In build.xml se includ in obiectivul compile

      <fileset dir="war/WEB-INF/lib">
          <include name="*.jar"/>
      </fileset>
          
     <copy todir="war/WEB-INF/classes/appjud" file="src/judete.txt"/>
     
4. In sarcina javac se adauga source="1.7" target="1.7"

Se va apela http://localhost:8080