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
        Scanner sc = new Scanner(System.in);

        /*
        System.out.println("Adja meg az első számot: ");
        calc.setNum1(sc.nextInt());
        System.out.println("Adja meg a második számot: ");
        calc.setNum2(sc.nextInt());
        */

        String calcJson =
                "{ \"operator\" : [ \"+\", \"-\", \"*\", \"/\" ], \"num1\" : \"null\", \"num2\" : 3 }";

        try {
            JsonNode jsonNode = objectMapper.readValue(calcJson, JsonNode.class);



            JsonNode operatorNode = jsonNode.get("operator");
            String operator = operatorNode.toString();
            System.out.println("operator = " + operator);


            JsonNode num1Node = jsonNode.get("num1");
            int num1 = num1Node.asInt();
            System.out.println("num1 = " + num1);

            JsonNode num2Node = jsonNode.get("num2");
            int num2 = num2Node.asInt();
            System.out.println("num2 = " + num2);

            System.out.println("Adjon meg egy operátort: ");
            calc.setOperator(sc.nextLine());


            switch (calc.getOperator()) {
                case("+"):
                    System.out.println("eredmény: " + calc.add(num1, num2));
                    break;
                case("-"):
                    System.out.println("eredmény: " + calc.subtract(num1, num2));
                    break;
                case("*"):
                    System.out.println("eredmény: " + calc.multiply(num1, num2));
                    break;
                case("/"):
                    System.out.println("eredmény: " + calc.divide(num1, num2));
                    break;
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    }

