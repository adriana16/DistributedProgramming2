package resources;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;

@ApplicationPath("app")
public class App extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Collections.singleton(CmmdcController.class);
    }
}
