package sk.tomas.rpc;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

@JsonRpcService("/calculator")
public interface CalculatorApi {

    //rpc method name is not necessary if same as method name
    @JsonRpcMethod("add")
    Calculation add(@JsonRpcParam(value = "input") Calculation calculation);

    Calculation subtract(@JsonRpcParam(value = "input") Calculation calculation);

    Calculation multiply(@JsonRpcParam(value = "input") Calculation calculation);

    Calculation subdivide(@JsonRpcParam(value = "input") Calculation calculation);
}
