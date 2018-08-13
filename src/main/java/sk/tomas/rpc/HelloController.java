package sk.tomas.rpc;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() throws MalformedURLException {
        int a = 5;
        int b = 8;
        return "result of " + a + " * " + b + " is " + method(a, b);
    }

    private int method(int a, int b) throws MalformedURLException {
        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://localhost:8080/calculator"));

        ExampleServerAPI clientProxy = ProxyUtil
                .createClientProxy(getClass().getClassLoader(), ExampleServerAPI.class, client);

        return clientProxy.multiplier(a, b);

    }

}
