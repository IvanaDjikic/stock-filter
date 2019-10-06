
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MakeMeRich {
	public static final List<String> symbols = Arrays.asList("AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE",
			"AMZN", "CRAY", "CSCO", "SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN", "YHOO");

	public static void main(String[] args) {

		// 1. Print these symbols using a Java 8 for-each and lambdas
		symbols.stream().forEach(sym -> System.out.println(sym));
		// 2. Use the StockUtil class to print the price of Bitcoin

		System.out.println(StockUtil.getPrice("BTC-USD"));
		// 3. Create a new List of StockInfo that includes the stock price
		List<StockInfo> list = new ArrayList<StockInfo>();
		for (String i : StockUtil.prices.keySet()) {
			list.add(new StockInfo(i, StockUtil.prices.get(i)));

		}
		System.out.println(list.toString());
		// System.out.println(list.get(3).price);

		// 4. Find the highest-priced stock under $500

		// list.stream().sort( s -> s.StockUtil.isPricelessThan(500));
		// list.stream().filter(s-> s.price<500).sort((s1,s2)->(int)(s1.price*100) -
		// (int)(s2.price*100)).collect(Collectors.toList());
		// System.out.println(list.get(list.size()-1).toString());
		// System.out.println(list);

		// i've tried many things with strings but it didn't function for me so i did it
		// the old fashion way :)
		List<StockInfo> list1 = new ArrayList<StockInfo>();
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).price < 500) {
				list1.add(list.get(i));
			}
		}
		StockInfo max = list1.get(0);

		for (int i = 1; i < list1.size(); i++) {

			if (list1.get(i).price > max.price) {
				max = list1.get(i);
			}
		}
		System.out.println(max.toString());

	}

}
