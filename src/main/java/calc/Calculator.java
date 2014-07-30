package calc;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    List<Double> stack = new ArrayList<Double>();

    public void push(double arg) {
        stack.add(arg);
    }

    public double divide() {
		Double result = stack.remove(stack.size() - 2) / stack.get(stack.size() - 1);
		stack.add(result);
		return result;
    }

    public double add() {
		Double result = stack.remove(stack.size() - 2) + stack.get(stack.size() - 1);
		stack.add(result);
		return result;
    }
}
