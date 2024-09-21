package Config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({"file:src/test/resources/apidemos.properties"})
public interface ApiDemosProperties extends Config{

    @Key("apk.path")
    String apkPath();

    @Key("app.package")
    String appPackage();

    @Key("app.activity")
    String appActivity();

}
