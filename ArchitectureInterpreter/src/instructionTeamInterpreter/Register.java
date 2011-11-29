package instructionTeamInterpreter;


public class Register {
	/*
	 * Register class contains all the current to-be implemented registers by the
	 * pipeline team. 
	 * 
	 * If a register is not supported, I assume you wrote a byte and will return it
	 * without any processing
	 */

	public String getRegMC(String register){
		String value = register;		
		if(register.equalsIgnoreCase("zero")){
			value = "0000";
		}
		if(register.equalsIgnoreCase("s0")){
			value = "0001";
		}
		if(register.equalsIgnoreCase("s1")){
			value = "0010";
		}
		if(register.equalsIgnoreCase("s2")){
			value = "0011";
		}
		if(register.equalsIgnoreCase("s3")){
			value = "0100";
		}
		if(register.equalsIgnoreCase("s4")){
			value = "0101";
		}
		if(register.equalsIgnoreCase("s5")){
			value = "0110";
		}
		if(register.equalsIgnoreCase("s6")){
			value = "0111";
		}
		if(register.equalsIgnoreCase("t0")){
			value = "1000";
		}
		if(register.equalsIgnoreCase("t1")){
			value = "0101";
		}
		if(register.equalsIgnoreCase("a0")){
			value = "0110";
		}
		if(register.equalsIgnoreCase("a1")){
			value = "0111";
		}
		if(register.equalsIgnoreCase("v0")){
			value = "1000";
		}
		if(register.equalsIgnoreCase("ra")){
			value = "0100";
		}
		return value;
	}//End of regRS method
}//end of Register Class File
