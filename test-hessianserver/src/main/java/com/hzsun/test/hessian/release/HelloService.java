package com.hzsun.test.hessian.release;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/3/10 0010
 */

import com.hzsun.demotest.hessian.api.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.stereotype.Component;

@Component
public class HelloService {
    @Autowired
    private IHelloService helloService;

    @Bean(name = "/Hessian/helloService")
    public HessianServiceExporter exportmerchantAuthenticationService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(helloService);
        exporter.setServiceInterface(IHelloService.class);
        return exporter;
    }
}