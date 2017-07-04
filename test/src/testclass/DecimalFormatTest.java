package testclass;

import java.text.DecimalFormat;

public class DecimalFormatTest {

	public static void main(String[] args) {
		Double a = 1.3;
		DecimalFormat df = new DecimalFormat("#0.00");
		System.out.println(df.format(a));
	}

}
