import java.util.HashMap;

public class FractionToDecimal{
public static String fractionToDecimal(int num, int den) {
        
	if(num==0) return "0";

	StringBuilder res = new StringBuilder();
	System.out.println((num > 0) ^ (den > 0) );

	// Negative sign is appended if either of num or den is negative
	res.append((num > 0) ^ (den > 0) ? "-" : "");

	// Get rid of signs and convert to long to prevent overflow
	long n = Math.abs((long) num);
	long d = Math.abs((long) den);

	// Append the integral part
	res.append(n/d);

	n %= d;
	if(n==0) return res.toString();             // Cause there is no fraction

	// Append the fraction
	res.append(".");
	HashMap<Long, Integer> hm = new HashMap();  // Map will store remainders and their positions
	hm.put(n, res.length());
	while(n!=0) {                               // We will break in case of recurring fraction
		n *= 10;
		res.append(n/d);
		n %= d;

		Integer remainderIndex = hm.get(n);
		if(remainderIndex!=null) {              // We have a recurrence
			res.insert(remainderIndex, "(");
			res.append(")");
			return res.toString();
		} else {
			hm.put(n, res.length());            // Add for future checks
		}
	}
	return res.toString();
}
public static void main(String[] args) {
	System.out.println(fractionToDecimal(2, 3));
}

}