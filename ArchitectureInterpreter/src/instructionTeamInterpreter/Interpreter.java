package instructionTeamInterpreter;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Interpreter {
	public static void main(String []args){
		/*Interpreter main(String []args)
		 * The main method requires an absolute file path in order to work.
		 * Once a file path is inserted, just run the program and you will get
		 * an output onto the terminal.
		 * 
		 * For your sake and mine, I have commented parts of the code that
		 * you might want to know what's going on.
		 * 
		 * Please note that not all functions may not work 100%
		 * Although I have tried to fix every possible problem I could think of, 
		 * I'm sure some bugs exist somewhere...
		 * 
		 * Here are some things I assume:
		 * 	You know how to write assembly language
		 * 		(You know the syntax for a specific function, if not,
		 * 		please open the Instruction Class for information on how
		 * 		I expect you to write code)
		 * 	
		 * 	You know the order in which commands should be written
		 * 		(I read in code one line at a time, word by word.
		 * 		I assume you have written the correct information 
		 * 		in the right spot, therefore I DO NOT check the correctness
		 * 		of how you supply your arguements with each instruction)
		 * 	
		 * 	You can write comments! :D
		 * 		(comments can only by written on a new line.
		 * 		the interpreter will not work if you use a comment 
		 * 		in the same line as an instruction.
		 * 		to write a comment, simply start a line with //
		 * 		This is the ONLY way to write a comment)
		 * 	
		 * 	You will ONLY use 10 unique labels
		 * 		(I say 10 because I have hard-coded only 10 available 
		 * 		locations for 10 unique labels. Should you find yourself
		 * 		using more, simply go to the LabelTable Class and change
		 * 		the sizeofArray attribute to the number of unique labels that you use.
		 * 		You changing this number SHOULD NOT break my code, but if it does, 
		 * 		tell me and I will try to fix it fast :D )
		 */


		//replace Absolute path with your assembly file!
		//TODO Replace filePath!
		String filePath = "C:\\Users\\Manny\\workspace\\ArchitectureInterpreter\\src\\make.txt";
		Instruction ins = new Instruction();
		StringTokenizer st;

		try{
			/* 
			 * Create the file stream to start the assembly language processing
			 */
			FileInputStream fstream = new FileInputStream(filePath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String fileText;

			/*
			 * initArrays() function is called here to avoid a label is null problem found while creating
			 * this program. 
			 * 
			 * notePadLineNumber refers to the number written in your actual text file. this is to help 
			 * with debugging information for if you missed an argument, the program will stop and show 
			 * you the line number and the code. 
			 * 
			 * memoryInstructionNumber refers to the actual location in memory that the processor uses
			 * and will be used in my code to figure out what address a label should obtain
			 */
			ins.lt.initArrays();
			int notePadLineNumber = 1;
			int memoryInstructionNumber = 0;
			while ((fileText = br.readLine()) != null){
				/*
				 * While there is still text in the file, we will tokenize the current line
				 * if the line is a comment (shown by looking for //) we do not parse the line
				 * and check the next line in the text file
				 * 
				 * else we send the information to the setInstruction() method to prepare the actual printout
				 * then we print it out with printMachineCode and check the next line
				 */

				st = new StringTokenizer(fileText);
				if(fileText.contains("//")){
					//comment detected, skip line
					notePadLineNumber++;
				}else{
					//System.out.print(count + ": ");
					ins.setInstruction(st, notePadLineNumber, fileText, memoryInstructionNumber);
					ins.printMachineCode();
					//System.out.print("\t|" +  fileText); //use for debugging your assembly code
					System.out.println();
					notePadLineNumber++;
					memoryInstructionNumber++;
				}
				//ins.lt.printLT(); //used for debugging the Label Table
			}//end of while true loop
			in.close();
			System.out.println("\nCode Interpretation Ended");			
		}catch(Exception e){
			System.out.println("error: " + e.getMessage());
		}
	}//end of main()
}
