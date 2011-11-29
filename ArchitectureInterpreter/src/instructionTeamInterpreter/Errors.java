package instructionTeamInterpreter;

public class Errors {
	/*
	 * the Errors class simply checks the amount of arguments needed for each instruction.
	 * when the argument count is wrong, the program will exit. and show debug information
	 */
	
	public void checkNoop(int instructionArgumentsLeft, int lineTextNumber, String lineText){
		if(instructionArgumentsLeft != 0){
			System.out.println("---error, line:" + lineTextNumber
					+ " expected no arguments");
			System.out.println(lineText);
			System.exit(1);
		}
	}
	
	public void checkAdd(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 3){
			System.out.println("error, line:" + lineNumber
					+ " expected 3 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkInc(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 2){
			System.out.println("error, line " + lineNumber
					+ " expected 2 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkSlt(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 3){
			System.out.println("error, line " + lineNumber
					+ " expected 3 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkAddi(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 3){
			System.out.println("error, line " + lineNumber
					+ " expected 3 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkSlti(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 3){
			System.out.println("error, line " + lineNumber
					+ " expected 3 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkInci(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 2){
			System.out.println("error, line " + lineNumber
					+ " expected 2 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkBeq(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 3){
			System.out.println("error, line " + lineNumber
					+ " expected 3 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkLw(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 3){
			System.out.println("error, line " + lineNumber
					+ " expected 3 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkSw(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 3){
			System.out.println("error, line " + lineNumber
					+ " expected 3 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkJal(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 1){
			System.out.println("error, line " + lineNumber
					+ " expected 1 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkJ(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 1){
			System.out.println("error, line " + lineNumber
					+ " expected 1 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkJr(int argumentsLeft, int lineNumber, String lineArg){
		//TODO double check the arguments
		if(argumentsLeft != 1){
			System.out.println("error, line " + lineNumber
					+ " expected 1 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkAnd(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 3){
			System.out.println("error, line " + lineNumber
					+ " expected 3 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	public void checkOr(int argumentsLeft, int lineNumber, String lineArg){
		if(argumentsLeft != 3){
			System.out.println("error, line " + lineNumber
					+ " expected 3 arguments");
			System.out.println(lineArg);
			System.exit(1);
		}
	}
	
	
}
