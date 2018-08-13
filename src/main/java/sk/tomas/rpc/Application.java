package sk.tomas.rpc;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import com.googlecode.jsonrpc4j.spring.JsonProxyFactoryBean;
import com.googlecode.jsonrpc4j.spring.JsonServiceExporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public static AutoJsonRpcServiceImplExporter autoJsonRpcServiceImplExporter() {
        AutoJsonRpcServiceImplExporter exp = new AutoJsonRpcServiceImplExporter();
        //in here you can provide custom HTTP status code providers etc. eg:
        //exp.setHttpStatusCodeProvider();
        //exp.setErrorResolver();
        return exp;
    }

    public static UserService userService() {
        return new UserServiceImpl();
    }

    @Bean(name = "/UserService.json")
    public static JsonServiceExporter userServiceJson() {
        JsonServiceExporter exporter = new JsonServiceExporter();
        exporter.setService(userService());
        exporter.setServiceInterface(UserService.class);
        return exporter;
    }

    @Bean
    public static JsonProxyFactoryBean jsonProxyFactoryBean() {
        JsonProxyFactoryBean bean = new JsonProxyFactoryBean();
        bean.setServiceUrl("http://localhost:8080/UserService.json");
        bean.setServiceInterface(UserService.class);
        return bean;
    }

}
