package com.miaoshaproject.congif;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

// 当spring容器内没有TomcatEmbeddedServletContainerFactory这个bean时，会把此bean加载到spring容器中
@Component
public class WebServerConfiguration implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    // 使用对应的工厂类提供给我们的接口，定制化我们的 tomcat connector
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        ((TomcatServletWebServerFactory)factory).addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                // 30秒无请求，断开
                protocol.setKeepAliveTimeout(30000);
                // 超过10000个请求，自动断开
                protocol.setMaxKeepAliveRequests(10000);
            }
        });
    }
}
