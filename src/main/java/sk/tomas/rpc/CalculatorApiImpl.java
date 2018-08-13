package sk.tomas.rpc;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.stereotype.Service;

@Service
@AutoJsonRpcServiceImpl
public class CalculatorApiImpl implements CalculatorApi {

    @Override
    public Calculation add(Calculation calculation) {
        calculation.setResult(calculation.getFirst() + calculation.getSecond());
        return calculation;
    }

    @Override
    public Calculation subtract(Calculation calculation) {
        calculation.setResult(calculation.getFirst() - calculation.getSecond());
        return calculation;
    }

    @Override
    public Calculation multiply(Calculation calculation) {
        calculation.setResult(calculation.getFirst() * calculation.getSecond());
        return calculation;
    }

    @Override
    public Calculation subdivide(Calculation calculation) {
        calculation.setResult(calculation.getFirst() / calculation.getSecond());
        return calculation;
    }

    @Override
    public Calculation thisMethodThrowError() throws MyException {
        throw new MyException("Some expection message.");
    }
}
