package Config;

import static org.aeonbits.owner.Config.LoadPolicy;
import static org.aeonbits.owner.Config.LoadType;
import static org.aeonbits.owner.Config.Sources;

import org.aeonbits.owner.Config;

@LoadPolicy(LoadType.MERGE)
@Sources({"file:src/test/resources/emulator.properties"})
public interface EmulatorProperties extends Config{

    @Key("device.name")
    String deviceName();

    @Key("udid")
    String udid();
}
