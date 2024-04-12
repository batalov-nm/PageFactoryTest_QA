package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:application.conf")
public interface ProjectConfig extends Config {

    @Key("base_url")
    String baseUrl();

//    @Key("correct_email")
//    String email();
//
//    @Key("correct_password")
//    String password();
}
