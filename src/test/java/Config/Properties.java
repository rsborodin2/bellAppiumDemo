package Config;

import org.aeonbits.owner.ConfigFactory;

/**
 * Класс управления глобальными настройками (пропертями)
 */
public class Properties {

    public  static ApiDemosProperties apiDemosProperties = ConfigFactory.create(ApiDemosProperties.class);
    public  static EmulatorProperties emulatorProperties = ConfigFactory.create(EmulatorProperties.class);
    public  static AndroidDriverProperties androidDriverProperties = ConfigFactory.create(AndroidDriverProperties.class);
    public  static AppiumServerProperties appiumServerProperties = ConfigFactory.create(AppiumServerProperties.class);


}
