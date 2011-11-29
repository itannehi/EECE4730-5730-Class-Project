package testFiles;
import instructionTeamInterpreter.LabelTable;

import org.junit.Before;
import org.junit.Test;

public class LabelTableTest {
	LabelTable lt = new LabelTable();
	int arraySize = 10;
	
	@Before
	public void setupLT(){
		//System.out.println("---init table begin");
		//System.out.println("---init table end---");
	}

	//@Test
	public void testLabelTable() {
		
		String answer;
		
		answer = lt.getMachineCode(1);		
		System.out.println(answer + "---" + answer.length());
		
		answer = lt.getMachineCode(2);
		System.out.println(answer + "---" + answer.length());
		
		answer = lt.getMachineCode(4);
		System.out.println(answer + "---" + answer.length());
		
		answer = lt.getMachineCode(8);
		System.out.println(answer + "---" + answer.length());
		
		answer = lt.getMachineCode(16);
		System.out.println(answer + "---" + answer.length());
		
		answer = lt.getMachineCode(32);
		System.out.println(answer + "---" + answer.length());
		
		answer = lt.getMachineCode(64);
		System.out.println(answer + "---" + answer.length());
		
		answer = lt.getMachineCode(128);
		System.out.println(answer + "---" + answer.length());
	}
	
	@Test
	public void testLTStore() {	
		System.out.println("-----Test testLTStore");
		lt.initArrays();
		lt.storeLabel("init", 0);
		System.out.println(lt.checkLabel("manny", 1));
		printLT();
	}
	
	public void printLT(){
		System.out.println("-----Test printLT");
		int i = 0;
		while(i >= 0 && i <= arraySize-1){
			System.out.println("|" + lt.table[i] + "||" +lt.address[i] + "|" );
			i++;
		}
	}
}


