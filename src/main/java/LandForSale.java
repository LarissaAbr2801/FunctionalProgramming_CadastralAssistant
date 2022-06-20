public class LandForSale {

    private final int width;
    private final int length;
    private final int salePricePerSquareMeter;
    private final long salePrice;
    private final long recommendedSalePrice;

    public LandForSale(int width, int length, int salePricePerSquareMeter, long salePrice) {
        this.width = width;
        this.length = length;
        this.salePricePerSquareMeter = salePricePerSquareMeter;
        this.salePrice = salePrice;
        this.recommendedSalePrice = calculateSalePrice();
    }

    public int calculateSalePrice() {
        return width*length*salePricePerSquareMeter;
    }

    public long getSalePrice() {
        return salePrice;
    }

    public long getRecommendedSalePrice() {
        return recommendedSalePrice;
    }

    @Override
    public String toString() {
        return String.format("\nРекомендованная цена продажи участка шириной %d и длиной %d - %d $, " +
                        "фактическая - %d $",
                width, length, recommendedSalePrice, salePrice);
    }
}
