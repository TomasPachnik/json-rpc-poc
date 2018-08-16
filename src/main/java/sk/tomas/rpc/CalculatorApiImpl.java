package sk.tomas.rpc;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.stereotype.Service;

@Service
@AutoJsonRpcServiceImpl
public class CalculatorApiImpl implements CalculatorApi {

    @Override
    public Calculation add(double first, double second) {
        return new Calculation(first, second, first + second);
    }

    @Override
    public Calculation subtract(double first, double second) {
        return new Calculation(first, second, first - second);
    }

    @Override
    public Calculation multiply(double first, double second) {
        return new Calculation(first, second, first * second);
    }

    @Override
    public Calculation subdivide(double first, double second) {
        return new Calculation(first, second, first / second);
    }

    @Override
    public Calculation thisMethodThrowError() throws MyException {
        throw new MyException("Some expection message.");
    }
}
