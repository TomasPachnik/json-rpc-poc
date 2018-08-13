package sk.tomas.rpc;

import com.googlecode.jsonrpc4j.JsonRpcClient;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.googlecode.jsonrpc4j.spring.JsonProxyFactoryBean;
import com.googlecode.jsonrpc4j.spring.rest.JsonRpcRestClient;
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
        Calculation calc = new Calculation(5, 8);
        StringBuilder sb = new StringBuilder();

        sb.append("numbers: " + calc.getFirst() + " and " + calc.getSecond());
        sb.append(", add: " + factory.add(calc).getResult());
        sb.append(", subtract: " + factory.subtract(calc).getResult());
        sb.append(", multiply: " + factory.multiply(calc).getResult());
        sb.append(", subdivide: " + factory.subdivide(calc).getResult());

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
