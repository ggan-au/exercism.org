import java.util.*;

class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

       Operation op = Operation.fromSymbol(operation);

        return switch (op) {
            case ADD -> String.format("%d + %d = %d", operand1, operand2, operand1 + operand2);
            case MULTIPLY -> String.format("%d * %d = %d", operand1, operand2, operand1 * operand2);
            case DIVIDE -> {
                    try {
                        Double result = (double) operand1 / operand2;
                        if (result % 1 == 0) {
                            yield String.format("%d / %d = %d", operand1, operand2, operand1 / operand2);
                        } else {
                            yield String.format("%d / %d = %.2f", operand1, operand2, operand1 / operand2);
                        }
                    } catch (ArithmeticException e) {
                        throw new IllegalOperationException("Division by zero is not allowed", e);
                    }
            }
        };
    }
}

enum Operation {
    ADD("+"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static Operation fromSymbol(String operation) {
        for (Operation op : values()) {
            if (op.symbol.equals(operation)) {
                return op;
            }
        }
        throw new IllegalOperationException("Operation '" + operation + "' does not exist");
    }
}
