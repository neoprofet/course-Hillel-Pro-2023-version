package java_pro_homeworks.pr5B.shipping_module;

import java.math.BigDecimal;

public class ShippingFactory {
    private ShippingDetails[] deliveryPack1 = {
            new ShippingDetails(new BigDecimal("124.60"), "Zdolbynivska, 105"),
            new ShippingDetails(new BigDecimal("129.20"), "Anna Ahmatova, 11A"),
            new ShippingDetails(new BigDecimal("144.60"), "Zarichna, 18"),
            new ShippingDetails(new BigDecimal("155.20"), "Bazhana,8A"),
            new ShippingDetails(new BigDecimal("190.23"), "Sadova, 14"),
            new ShippingDetails(new BigDecimal("107.40"), "Dovzhenko, 51"),
            new ShippingDetails(new BigDecimal("114.50"), "Bohomolca, 58"),
            new ShippingDetails(new BigDecimal("101.10"), "Tsentalna, 12A"),
            new ShippingDetails(new BigDecimal("152.27"), "Symska, 1"),
            new ShippingDetails(new BigDecimal("147.30"), "Nivki, 11C"),
            new ShippingDetails(new BigDecimal("129.16"), "Vokzalna, 65A"),
            new ShippingDetails(new BigDecimal("106.22"), "Lvivska, 2"),
    };

    public ShippingDetails getRandomShippingDetails(){
        int randomIndex = (int) Math.floor(Math.random() * deliveryPack1.length);
        return deliveryPack1[randomIndex];
    }

    public ShippingDetails[] getDeliveryPack1() {
        return deliveryPack1;
    }
}
