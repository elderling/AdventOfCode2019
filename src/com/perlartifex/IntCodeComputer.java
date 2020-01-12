package com.perlartifex;

import java.util.Map;

public class IntCodeComputer {
    private int[] ram;

    private static int ADD = 1;
    private static int MULTIPLY = 2;
    private static int INPUT = 3;
    private static int OUTPUT = 4;
    private static int HALT = 99;

    // Instruction, Number of Parameters
    private static Map<Integer,Integer> instructionLength = Map.of(
            ADD, 3,
            MULTIPLY, 3,
            INPUT, 1,
            OUTPUT, 1,
            HALT, 0
    );

    IntCodeComputer(int[] ram) {
        this.ram = ram.clone(); // we don't want to mutate the input
    }

    public int runProgram() {
        int programCounter = 0;
        int instruction = ram[programCounter];

        String instructionString = String.format("%05d", instruction);

        int opcode = Integer.parseInt(instructionString.substring(3,5));
        int param1mode = Integer.parseInt(instructionString.substring(2,3));
        int param2mode = Integer.parseInt(instructionString.substring(1,2));
        int param3mode = Integer.parseInt(instructionString.substring(0,1));
        while (opcode != HALT) {
            var numberOfParameters = this.instructionLength.get(opcode);

            if (numberOfParameters == 1 ) {
                var parameter1 = ram[programCounter+1];
            }
            else if (numberOfParameters == 3 ) {
                var parameter1 = ram[programCounter+1];
                var parameter2 = ram[programCounter+2];
                var parameter3 = ram[programCounter+3];
            }
            programCounter += numberOfParameters + 1;
        }

        return 0;
    }
    /*
    Instruction, Number of Parameters
    ADD, 3
    Multiply, 3
    INPUT, 1
    OUTPUT, 1
     */
}
