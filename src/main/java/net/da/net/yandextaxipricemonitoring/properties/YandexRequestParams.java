package net.da.net.yandextaxipricemonitoring.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "yandex-request")
public class YandexRequestParams {
    private String[][] route;
    private Boolean skip_estimated_waiting;
    private Boolean supports_forced_surge;
}
