package Config;

import static org.aeonbits.owner.Config.LoadPolicy;
import static org.aeonbits.owner.Config.LoadType;
import static org.aeonbits.owner.Config.Sources;

import org.aeonbits.owner.Config;

@LoadPolicy(LoadType.MERGE)
@Sources({"file:src/test/resources/androidDriver.properties"})
public interface AndroidDriverProperties extends Config{

    @Key("automation.name")
    String automationName();

}
