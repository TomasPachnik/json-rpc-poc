package sk.tomas.rpc;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.googlecode.jsonrpc4j.spring.JsonProxyFactoryBean;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private JsonProxyFactoryBean jsonProxyFactoryBean;

    @RequestMapping("/")
    public String index() throws MalformedURLException {
        CalculatorApi factory = factory();
        double first = 8;
        double second = 5;
        StringBuilder sb = new StringBuilder();

        sb.append("numbers: " + first + " and " + second);
        sb.append(", add: " + factory.add(first, second).getResult());
        sb.append(", subtract: " + factory.subtract(first, second).getResult());
        sb.append(", multiply: " + factory.multiply(first, second).getResult());
        sb.append(", subdivide: " + factory.subdivide(first, second).getResult());

        try {
            factory.thisMethodThrowError();
        } catch (MyException e) {
            System.out.println("e.getMessage(): " + e.getMessage());
        }
        new RuntimeException();
        System.out.println(method().getUserCount());

        return sb.toString();
    }

    private CalculatorApi factory() throws MalformedURLException {
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://localhost:8080/calculator"));
        return ProxyUtil.createClientProxy(getClass().getClassLoader(), CalculatorApi.class, client);

    }

    private UserService method() {
        return (UserService) jsonProxyFactoryBean.getObject();
    }

}
