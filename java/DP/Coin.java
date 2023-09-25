import java.util.*;

// n = 동전 개수
// k = 만들어야 하는 금액
// coin[i] = 동전의 종류
// d[i] = i 금액을 만들기 위해 필요한 동전의 최소 갯수
public class Coin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt(); 

        int coin[] = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        int d[] = new int[k + 1];
		// 핵심 아이디어는 d[i]를 순회하면서 미리 구해놓은 필요한 최소 동전 갯수를 가져다 사용하면서 넘어가는 것임!
		// 동전을 중복해서 사용할 수 있다는 점이 knapsack과의 중요한 차이점 중 하나!
		// d[0]은 0인 채로 두는 것이 매우 중요한 포인트 중 하나이다
		for (int i = 1; i <= k; i++) {
            d[i] = -1;
            for (int j = 0; j < n; j++) {
                if (coin[j] <= i) { // i(만들고자 하는 금액)보다 크기가 더 작거나 같은 동전만 순회한다.
					// (그리고 그 동전을 쓰고 남은 금액에 대해서 이미 이전에 계산해 둔 것들이 있을테니 만들 수 있는 금액인지 아닌지를 검사한다)
                    if (d[i - coin[j]] == -1) // coin[j]를 사용하면, 남는 금액을 만들 수 있는 동전 조합이 나오지 않는다. 즉, coin[j]는 쓸 수 없다.
						continue;
                    if (d[i] < 0) // 현재 coin[j]는 이걸 써서 i를 만드는 것이 가능한 최초의 동전이다
						d[i] = d[i - coin[j]] + 1; // 즉, i - coin[j]는 만들 수 있는 금액이고 따라서 i도 만들 수 있는 금액이다!
                    else if (d[i - coin[j]] + 1 < d[i]) // 이전에 계산해둔 d[i]의 값 보다 지금의 coin[j]를 쓰는 게 더 적은 동전을 사용
						d[i] = d[i - coin[j]] + 1; // 그러면 d[i]값을 그걸로 뱌꿔준다
                }
            }
        }
        System.out.println(d[k]);
		sc.close();
    }
}