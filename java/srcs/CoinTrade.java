public class CoinTrade {

	public static void main(String[] args) {
		double won = 100000;
		System.out.println("first, won = " + won);
		
		double e = 1300;
		double domesticTRX = 83.4;
		double foreignTRX = 0.06422;
		double dollar;
		dollar = upbitToBinance(won, domesticTRX, foreignTRX);
		won = foreignToDomestic(dollar, e);
		System.out.println("after sending to Binance, won = " + won);

		domesticTRX += 1;
		foreignTRX -= 0.001;
		e -= 1100;
		won = binanceToUpbit(dollar, foreignTRX, domesticTRX);
		System.out.println("after sending back to Upbit, won = " + won);
	}

	public static double domesticToForeign(double KRW, double e) {
		return KRW / e;
	}

	public static double foreignToDomestic(double USD, double e) {
		return USD * e;
	}

	public static double upbitToBinance(double won, double domesticTRX, double foreignTRX) {
		double TRXVolume = won / domesticTRX;
		double dollar = TRXVolume * foreignTRX;
		return dollar;
	}

	public static double binanceToUpbit(double dollar, double foreignTRX, double domesticTRX) {
		double TRXVolume = dollar / foreignTRX;
		double won = TRXVolume * domesticTRX;
		return won;
	}

	// public static double crossTrans() {

	// }

	// 여기다가 좀 하다가 어떤 방식으로 할지 정해지면,
	// 그때부터는 프로젝트 테스트 코드로 가서 거기서 먼저 작성하고 그걸 실제 소스코드로 옮기는 식으로 개발하자
	// javac CoinTrade.java; java CoinTrade;
}