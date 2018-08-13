package sk.tomas.rpc;

public class Calculation {

    double first;
    double second;
    double result;

    public Calculation() {
    }

    public Calculation(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
