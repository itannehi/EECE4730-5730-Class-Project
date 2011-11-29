package instructionTeamInterpreter;

public class LabelTable {
	
	/*
	 * The LabelTable class contains all the labels used in a program
	 * along with its respective machine address.
	 * 
	 * sizeofArray controls how many labels you can use within a code.
	 * 
	 * the table[] will contain each label while the address[] keeps track 
	 * of the machine address. These stay in sync by using the index integer.
	 * The index of a label in the table[] can find its machine address in the 
	 * same exact index at the address[]
	 */

	final int sizeofArray = 10;

	public int index = 0;
	public String []table = new String[sizeofArray];
	public int []address = new int[sizeofArray];

	public void initArrays(){
		/*
		 * initArray() inits the arrays to be empty and have 0 as their address
		 */
		int i = 0;
		while(i >= 0 && i <= sizeofArray-1){
			table[i] = "";
			address[i] = 0;
			i++;
		}
	}
	
	public String checkLabel(String label, int machineLine){
		/*
		 * checkLabel() checks every single array spot in the table[] and tries the match the label
		 * with something inside its table, if it does not make a match, this new label will be stored
		 * 
		 * I did not build a check for this on what would happen if the array is maxed out. will most
		 * likely throw an out of bounds exception
		 */
		int i = 0;
		String machineCode = "";
		String arrayString; 
		while( i >= 0 && i <= (sizeofArray-1) ){
			arrayString = table[i].toString();
			//System.out.println(i + "<" + (sizeofArray-1) ); //debug info
			if(arrayString.equalsIgnoreCase(label)){ 
				//System.out.println(table[i] + " equals " + label);
				machineCode = getMachineCode(address[i]);
				break;
			}else i++;
		}		
		if(machineCode.equalsIgnoreCase("")){
			storeLabel(label, machineLine);
			machineCode = getMachineCode(machineLine);
		}
		return machineCode;
	}
	
	public String checkLabelJ(String label, int machineLine){
		/*
		 * checkLabel() checks every single array spot in the table[] and tries the match the label
		 * with something inside its table, if it does not make a match, this new label will be stored
		 * 
		 * I did not build a check for this on what would happen if the array is maxed out. will most
		 * likely throw an out of bounds exception
		 * 
		 * this is different from checkLabel() because it called getMachineCodeLong() to parse the
		 * integer into an binary string. this had to be done because checkLabel() ALWAYS returns
		 * a byte while J and JR need to return 3 bytes
		 */
		int i = 0;
		String machineCode = "";
		String arrayString; 
		while( i >= 0 && i <= (sizeofArray-1) ){
			arrayString = table[i].toString();
			//System.out.println(i + "<" + (sizeofArray-1) ); //debug info
			if(arrayString.equalsIgnoreCase(label)){ 
				//System.out.println(table[i] + " equals " + label);
				machineCode = getMachineCodeLong(address[i]);
				break;
			}else i++;
		}		
		if(machineCode.equalsIgnoreCase("")){
			storeLabel(label, machineLine);
			machineCode = getMachineCode(machineLine);
		}
		return machineCode;
	}

	public void storeLabel(String imm, int lineNumber){
		/*
		 * when array is maxed out, system displays error and quites.
		 * when array has space, it will store the label and address
		 */
		if(index > sizeofArray - 1){
			System.out.println("Array has been surpassed");
			System.exit(1);
		}else{
			table[index] = imm;
			address[index] = lineNumber;
			index++;
		}
	}//end of storeLabel()

	public String getMachineCode(int index){
		/*
		 * getMachineCode() ONLY returns 1 byte therefore it only needs cases 1-3
		 * this counts the length of the string which is a binary number and 
		 * concats 0s has necessary.
		 */
		String code = "";
		code = Integer.toBinaryString(index);
		switch(code.length()){
		case 1:
			code = "000" + code;
			break;
		case 2:
			code = "00" + code;
			break;
		case 3:
			code = "0" + code;
			break;
		}
		return code;
	}
	
	public String getMachineCodeLong(int index){
		/*
		 * getMachineCodeLong() ALWAYS returns 3 bytes therefore it needs cases 1-13.
		 * This counts the length of the string which is a binary number and 
		 * concats 0s has necessary.
		 */
		String code = "";
		code = Integer.toBinaryString(index);
		switch(code.length()){
		case 1:
			code = "0000 0000 000" + code;
			break;
		case 2:
			code = "0000 0000 00" + code;
			break;
		case 3:
			code = "0000 0000 0" + code;
			break;
		case 4:
			code = "0000 0000" + code;
			break;
		case 5:
			code = "0000 000" + code;
			break;
		case 6:
			code = "0000 00" + code;
			break;
		case 7:
			code = "0000 0" + code;
			break;
		case 8:
			code = "0000 " + code;
			break;
		case 9:
			code = "000" + code;
			break;
		case 10:
			code = "00" + code;
			break;
		case 11:
			code = "00" + code;
			break;
		case 12:
			code = "0" + code;
			break;
		case 13:
			code = code;
			break;
		}
		return code;
	}
	
	public void printLT(){
		/*
		 * printLT() is for debugging purposes
		 * it will print the label arrays for you
		 */
		System.out.println("-----Test printLT");
		int i = 0;
		while(i >= 0 && i <= 9){
			System.out.println("|" + table[i] + "||" +address[i] + "|" );
			i++;
		}
	}
}//end of Class
