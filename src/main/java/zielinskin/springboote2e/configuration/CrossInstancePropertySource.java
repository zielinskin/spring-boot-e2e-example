package zielinskin.springboote2e.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties("zielinskin.cross-instance")
public record CrossInstancePropertySource(String externalInstanceIp,
                                          Integer numberOfObjectInstances) {

}
