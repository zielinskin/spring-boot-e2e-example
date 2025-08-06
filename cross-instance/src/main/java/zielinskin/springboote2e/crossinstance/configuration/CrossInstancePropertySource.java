package zielinskin.springboote2e.crossinstance.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("zielinskin.cross-instance")
public record CrossInstancePropertySource(String externalInstanceIp,
                                          Integer numberOfObjectInstances) {

}
