import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    static final Random random = new Random();
    static final Scanner scanner = new Scanner(System.in);
    static final int DEALS_QUANTITY = 300;
    static final int ORIGIN = 1;
    static final int BOUND = 100;

    public static void main(String[] args) {
        System.out.println("Ведите цену за квадратный метр:");
        int salePricePerSquareMeter = Integer.parseInt(scanner.nextLine());

        List<LandForSale> deals = generateDeals(new ArrayList<>(),
                DEALS_QUANTITY, salePricePerSquareMeter);

        Predicate<LandForSale> integrity = x -> x.getRecommendedSalePrice() <= x.getSalePrice();

        Function<List<LandForSale>, List<LandForSale>> function = checkDealsIntegrity(deals, integrity);

        System.out.println("Честные сделки: " + function.apply(deals));
    }

    public static List<LandForSale> generateDeals(List<LandForSale> deals, int dealsQuantity, int salePricePerSquareMeter) {
        if (dealsQuantity == 0) return deals;

        deals.add(new LandForSale(random.nextInt(ORIGIN, BOUND),
                random.nextInt(ORIGIN, BOUND), salePricePerSquareMeter,
                random.nextLong(ORIGIN * 100_000, BOUND * 100_000)));

        dealsQuantity--;

        return generateDeals(deals, dealsQuantity, salePricePerSquareMeter);
    }

    public static Function<List<LandForSale>, List<LandForSale>> checkDealsIntegrity(List<LandForSale> deals,
                                                                                     Predicate<LandForSale> integrity) {
        return x -> deals.stream()
                .filter(integrity)
                .collect(Collectors.toList());
    }
}
