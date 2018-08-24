package packageTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HelperClass {

	public static int currentHour() {

		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

		Calendar calobj = Calendar.getInstance();

		int hr = Integer.parseInt(df.format(calobj.getTime()).toString().substring(9, 11));

		System.out.println("The current hour is:"+hr);
		return hr;
	}

}
