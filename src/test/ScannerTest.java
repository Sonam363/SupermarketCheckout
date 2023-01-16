import main.PromotionList;
import main.Scanner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScannerTest {

    @Test
    public void allPromotionsAppliedTest() {
        List<String> itemsToScan = Arrays.asList("A", "D", "D", "E", "E", "B", "B", "C", "C", "C", "C");
        Scanner scanner = new Scanner(new PromotionList());
        double finalTotal = scanner.scan(itemsToScan);

        // scanner should apply one multibuy promotion, two meal deals, and one get one free promotion
        assertEquals(8.5, finalTotal);
    }

    @Test
    public void noPromotionsAppliedTest() {
        List<String> itemsToScan = Arrays.asList("A", "B", "C", "D", "D");
        Scanner scanner = new Scanner(new PromotionList());
        double finalTotal = scanner.scan(itemsToScan);

        assertEquals(4.5, finalTotal);
    }
}