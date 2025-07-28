package zielinskin.springboote2e.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties("zielinskin.cross-instance")
public class CrossInstancePropertySource {
    private final String externalInstanceIp;
    private final Integer numberOfObjectInstances;

    @ConstructorBinding
    public CrossInstancePropertySource(String externalInstanceIp, Integer numberOfObjectInstances) {
        this.externalInstanceIp = externalInstanceIp;
        this.numberOfObjectInstances = numberOfObjectInstances;
    }

    public String getExternalInstanceIp() {
        return externalInstanceIp;
    }

    public Integer getNumberOfObjectInstances() {
        return numberOfObjectInstances;
    }
}
