package enums;


public class ZavodEnumClass {
	public enum ZavodEnum {
		SCKR(1231), TSCKR(1222), ESIC(1146);
		
	    private int numVal;

		ZavodEnum(int numVal) {
	        this.numVal = numVal;
	    }

	    public int getNumVal() {
	        return numVal;
	    }
	}
	
	public static Integer getEnum(ZavodEnum zav) {
		if(ZavodEnum.SCKR == zav) {
			return 1;
		}
		else if (ZavodEnum.TSCKR == zav) {
			return 2;
		}
		else if (ZavodEnum.ESIC == zav) {
			return 3;
		}
		else return null;
	}
}
