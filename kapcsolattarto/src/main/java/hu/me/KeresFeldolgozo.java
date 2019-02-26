package hu.me;

import hu.me.logika.Calculator;

public class KeresFeldolgozo {

    Calculator calculator;

    public KeresFeldolgozo(Calculator calculator) {
        this.calculator = calculator;
    }

    public OutputValues feldolgoz(InputValues input) {
        OutputValues outputValues = new OutputValues();

        if(input != null || input.getMuvelet() != null || input.getMuvelet().isEmpty()) {
            outputValues.setHibakod(Hibakod.HibasMuveletiJel);
        }

        if("+".equals(input.getMuvelet())) {
            outputValues.setEredmeny(
                    this.calculator.osszeadas(
                            input.getOperandus1(),
                            input.getOperandus2()
                    )
            );
            outputValues.setHibakod(Hibakod.NincsHiba);
        }

        if("/".equals(input.getMuvelet())) {
            outputValues.setEredmeny(
                    this.calculator.osztas(
                            input.getOperandus1(),
                            input.getOperandus2()
                    )
            );
        }


        return outputValues;
    }
}

//ha a dobott kivétel nullával való osztás, akkor válaszkódba új hibakódtípus