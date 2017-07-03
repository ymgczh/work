package testclass;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigTest {

	public static void main(String[] args) {
		Double a = 19.22;
		Double v = 0.02;
		DecimalFormat tf = new DecimalFormat("#0.00");
		BigDecimal ba = new BigDecimal(tf.format(a));
		BigDecimal bb = new BigDecimal(tf.format(v));
		BigDecimal c = ba.add(bb);
		BigDecimal d = ba.subtract(bb);
		System.out.println(c.toString());
		System.out.println(tf.format(d.doubleValue()));
	}

}
