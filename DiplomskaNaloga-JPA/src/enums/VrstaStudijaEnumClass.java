package enums;

public class VrstaStudijaEnumClass {
	public enum VrstaStudijaEnum {
		REDNI(0), IZREDNI(5);
		
	    private int numVal;

	    VrstaStudijaEnum(int numVal) {
	        this.numVal = numVal;
	    }

	    public int getNumVal() {
	        return numVal;
	    }
	}

	public static Integer getEnum(VrstaStudijaEnum zav) {
		if(VrstaStudijaEnum.REDNI == zav) {
			return 1;
		}
		else if (VrstaStudijaEnum.IZREDNI == zav) {
			return 2;
		}
		else return null;
	}
}
