package enums;

public class ProgramEnumClass {
	public enum ProgramEnum {
		INF(19), EKN(26), ENE(5), MEH(22), OSM(25), PS(9), VAR(35);
		
	    private int numVal;

	    ProgramEnum(int numVal) {
	        this.numVal = numVal;
	    }

	    public int getNumVal() {
	        return numVal;
	    }
	}
	
	public static Integer getEnum(ProgramEnum program) {
		if(ProgramEnum.INF == program) {
			return 3;
		}
		else if (ProgramEnum.EKN == program) {
			return 1;
		}
		else if (ProgramEnum.ENE == program) {
			return 2;
		}
		else if (ProgramEnum.MEH == program) {
			return 4;
		}
		else if (ProgramEnum.OSM == program) {
			return 5;
		}
		else if (ProgramEnum.PS == program) {
			return 6;
		}
		else if (ProgramEnum.VAR == program) {
			return 7;
		}
		else return null;
	}

}