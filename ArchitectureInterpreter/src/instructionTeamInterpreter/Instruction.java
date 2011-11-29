package instructionTeamInterpreter;
import java.util.StringTokenizer;


public class Instruction {
	/*
	 * The Instruction class is pretty simple, it contains all possible instructions.
	 * 
	 * The string instructionMachineCode contains the binary code for the instruction.
	 * first contains the binary code for the second byte
	 * second contains the binary code for the thrid byte
	 * third contains the binary code for the final byte
	 * 
	 * So if the word was 0000 0000 0000 0000
	 * 		byte order:		0    1    2    3
	 * 
	 * 0 = instructionMachineCode
	 * 1 = first
	 * 2 = second
	 * 3 = third
	 * 
	 * This pattern was chosen so that I could have one way for all instructions to 
	 * print using only 1 print method since the print method is called in the 
	 * Interpreter class
	 * 
	 * instructionMachineCode, first, second, third and label are initialized below
	 * for debugging purposes. Please leave them as is since these will show if I did
	 * not do something write for a specific instruction
	 */
	String instructionMachineCode = "iMC - N/A";
	String first = "Rd - N/A";
	String second = "Rs - N/A";
	String third = "Rt - N/A";
	String label = "imm N/A";

	/*
	 * The instance reg is made to access all registers in our system written in the 
	 * Register class.
	 * 
	 * The Errors class is a simple class that only checks for number of argument corrections
	 * 
	 * The LabelTable class is the object that stores all unique labels and their respective 
	 * machine address
	 */

	Register reg = new Register();
	Errors e = new Errors();
	LabelTable lt = new LabelTable();

	public void setInstruction(StringTokenizer st, int textLineNumber, String fileText, int machineLine){
		/*
		 *st contains the string as tokens from the text file that was read in
		 *textLineNumber is the actual number shown in note pad for where the instruction was written
		 *machineLine is the expected memory address location for the ROM in our processor
		 *
		 *Below are all the instructions in a huge if/if else statement, I'm sure there are better ways 
		 *of doing this but this was the first easy way to do it in my head so I did it :D
		 *
		 *You will notice that it is in a while(true) loop, this is because I need to account for labels
		 *at the beginning of a line and still continue to parse instruction information. Again,
		 *this was the fastest way I could think of coding this section.
		 *
		 *Each instruction below contains how the instruction should appear in the text file
		 *along with the order in which the word needs to be arranged
		 *
		 *Please note for below what each symbol means
		 *0 = binary 0
		 *1 = binary 1
		 *s = source register
		 *t = target register
		 *d = destination register
		 *i = immediate address
		 */	
		String instruction = st.nextToken();
		int initialTokenCount = st.countTokens();
		while(true){
			if(instruction.equalsIgnoreCase("noop")){
				//noop
				//0000 0000 0000 0000
				e.checkNoop(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "0000";
				first = instructionMachineCode;
				second = instructionMachineCode;
				third = instructionMachineCode;
				break;
			}
			else if(instruction.equalsIgnoreCase("add")){
				//ADD   Rd Rs  Rt
				//0001  ssss  tttt  dddd
				e.checkAdd(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "0001";
				third = reg.getRegMC(st.nextToken());						
				first = reg.getRegMC(st.nextToken());
				second = reg.getRegMC(st.nextToken());
				break;
			}
			else if(instruction.equalsIgnoreCase("inc")){
				//INC   Rd Rs
				//0010  ssss  dddd  dddd
				e.checkInc(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "0010";
				second = reg.getRegMC(st.nextToken());
				first = reg.getRegMC(st.nextToken());
				third = second;
				break;
			}
			else if(instruction.equalsIgnoreCase("slt")){
				//SLT   Rd  Rs  Rt
				//0011  ssss  tttt  dddd
				e.checkSlt(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "0011";
				third = reg.getRegMC(st.nextToken());						
				first = reg.getRegMC(st.nextToken());
				second = reg.getRegMC(st.nextToken());
				break;
			}
			else if(instruction.equalsIgnoreCase("addi")){
				//ADDI  Rd Rs IMM
				//0100  ssss  tttt  iiii
				e.checkAddi(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "0100";
				first = reg.getRegMC(st.nextToken());						
				second = reg.getRegMC(st.nextToken());
				third = st.nextToken(); //label
				//third = lt.checkLabel(third, machineLine);
				break;
			}
			else if(instruction.equalsIgnoreCase("inci")){
				//INCI  Rt IMM
				//0101  tttt  tttt  iiii
				e.checkInci(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "0101";
				first = reg.getRegMC(st.nextToken());						
				second = first;
				third = st.nextToken(); //label
				//third = lt.checkLabel(third, machineLine);
				break;
			}
			else if(instruction.equalsIgnoreCase("slti")){
				//SLTI  Rt Rs IMM
				//0110  ssss  tttt  iiii
				e.checkSlti(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "0110";
				second = reg.getRegMC(st.nextToken());						
				first = reg.getRegMC(st.nextToken());
				third = st.nextToken(); //label
				//third = lt.checkLabel(third, machineLine);
				break;
			}
			else if(instruction.equalsIgnoreCase("beq")){
				instructionMachineCode = "0111";
				//BEQ   Rs Rt IMM
				//0111  ssss  tttt  iiii
				e.checkBeq(st.countTokens(), textLineNumber, fileText);
				first = reg.getRegMC(st.nextToken());						
				second = reg.getRegMC(st.nextToken());
				third = st.nextToken(); //label
				//third = lt.checkLabel(third, machineLine);
				break;
			}
			else if(instruction.equalsIgnoreCase("lw")){
				//LW    Rt IMM Rs
				//1000  ssss  tttt  iiii
				e.checkLw(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "1000";
				second = reg.getRegMC(st.nextToken());						
				third = st.nextToken();//label
				first = reg.getRegMC(st.nextToken());
				//third = lt.checkLabel(third, machineLine);
				break;
			}
			else if(instruction.equalsIgnoreCase("sw")){
				//SW    Rt IMM Rt
				//1001  ssss  tttt  iiii
				e.checkSw(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "1001";
				second = reg.getRegMC(st.nextToken());						
				third = st.nextToken(); //label
				//third = lt.checkLabel(third, machineLine);
				first = reg.getRegMC(st.nextToken());
				break;
			}
			else if(instruction.equalsIgnoreCase("jal")){
				//JAL   IMM
				//1010  iiii  iiii  iiii
				//TODO fix label and reading
				e.checkJal(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "1010";
				first = st.nextToken(); //label
				//first = lt.checkLabelJ(first, machineLine);
				second = "";
				third = "";
				break;
			}
			else if(instruction.equalsIgnoreCase("j")){
				//J	  IMM
				//1011  iiii  iiii  iiii
				//TODO fix label and reading
				e.checkJ(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "1011";
				first = st.nextToken(); //label
				//first = lt.checkLabelJ(first, machineLine);
				second = "";
				third = "";
				break;
			}
			else if(instruction.equalsIgnoreCase("jr")){
				//JR    Rs
				//1100  ssss  0000  0000
				e.checkJr(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "1100";
				first = reg.getRegMC("ra");	
				second = reg.getRegMC("zero");
				third = reg.getRegMC("zero");
				break;
			}
			else if(instruction.equalsIgnoreCase("and")){
				//(Bitwise and)
				//AND Rd Rs Rt
				//1101 ssss tttt dddd
				e.checkAnd(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "1101";
				third = reg.getRegMC(st.nextToken());
				first = reg.getRegMC(st.nextToken());
				second = reg.getRegMC(st.nextToken());
				break;
			}
			else if(instruction.equalsIgnoreCase("or")){
				//(Bitwise or) 
				//OR Rd Rs Rt
				//1110 ssss tttt dddd
				e.checkOr(st.countTokens(), textLineNumber, fileText);
				instructionMachineCode = "1110";
				second = reg.getRegMC(st.nextToken());						
				third = reg.getRegMC(st.nextToken());
				first = reg.getRegMC(st.nextToken());
				break;
			}
			else if(instruction.equalsIgnoreCase("----")){
				//The Golden instruction 1111 :D
			}else{
				//TODO Write Label Code
				/*
				 * If label is the first argument, save and record instruction
				 * else save spot somehow for later address checking
				 * 
				 * after label logic is done, increment to next argument.
				 */
				//if(initialTokenCount != st.countTokens())
				//	lt.checkLabel(instruction, machineLine);
				//else
					//call storage code
				instruction = st.nextToken();				
			}
		}
	}

	public void printMachineCode(){
		//DO NOT use println, that is taken care of in Interpreter
		/*
		 * printMachineCode() will search all four parameters, concat them together
		 * and then printout to the terminal.
		 * 
		 * Once the printout is complete, variables are re-initialized.
		 */
		System.out.print(instructionMachineCode + " " + first 
				+ " " + second + " " + third);
		instructionMachineCode = "iMC - N/A";
		first = "Rd - N/A";
		second = "Rs - N/A";
		third = "Rt - N/A";
		label = "imm N/A";
	}
}
