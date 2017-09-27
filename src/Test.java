import java.util.Collection;
import java.util.Map;

import com.zssy.sbwx.common.ConstantsXmlPath;


public class Test {
	public Map<String,String> orgMap1=ConstantsXmlPath.orgMap;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t=new Test();
		Collection<String> string=t.orgMap1.values();
		System.out.println(string);
	}

}
