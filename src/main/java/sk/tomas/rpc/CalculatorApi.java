package sk.tomas.rpc;

import com.googlecode.jsonrpc4j.JsonRpcError;
import com.googlecode.jsonrpc4j.JsonRpcErrors;
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

    @JsonRpcErrors({
            @JsonRpcError(exception = MyException.class, code = -404, message = "Not found", data = "data object"),
            @JsonRpcError(exception = Throwable.class, code = -1234)})
    Calculation thisMethodThrowError() throws MyException;
}


