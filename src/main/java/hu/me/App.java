package hu.me;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

        ObjectMapper objectMapper = new ObjectMapper();
        Calculator calc = new Calculator();
        Output output = new Output();
        Scanner sc = new Scanner(System.in);

        System.out.println("Adjon meg egy operátort: ");
        calc.setOperator(sc.nextLine());
        System.out.println("Adja meg az első számot: ");
        calc.setNum1(sc.nextInt());
        System.out.println("Adja meg a második számot: ");
        calc.setNum2(sc.nextInt());

        String calcJson =
                "{ \"operator\" : [ \"+\", \"-\", \"*\", \"/\" ], " +
                        "\"num1\" : " + calc.getNum1() +"," +
                        " \"num2\" : "+ calc.getNum2() +"}";

        try {
            JsonNode jsonNode = objectMapper.readValue(calcJson, JsonNode.class);

            JsonNode operatorNode = jsonNode.get("operator");
            String operator = operatorNode.toString();
            System.out.println("operator = " + operator);

            JsonNode num1Node = jsonNode.get("num1");
            double num1 = num1Node.asDouble();
            System.out.println("num1 = " + num1);

            JsonNode num2Node = jsonNode.get("num2");
            double num2 = num2Node.asInt();
            System.out.println("num2 = " + num2);



            switch (calc.getOperator()) {
                case("+"):
                    output.setResult(calc.add(num1, num2));
                    break;
                case("-"):
                    output.setResult(calc.subtract(num1, num2));
                    break;
                case("*"):
                    output.setResult(calc.multiply(num1, num2));
                    break;
                case("/"):
                    if(num2 == 0)
                        throw new IllegalArgumentException("Nem lehet 0-val osztani!");
                    output.setResult(calc.divide(num1, num2));
                    break;
            }

            String json = objectMapper.writeValueAsString(output);
            System.out.println(json);


        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }
}