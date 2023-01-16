import main.PromotionList;
import main.Scanner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScannerTest {

    @Test
    public void scannerTest(){
        List<String> itemsToScan = Arrays.asList("A", "D", "D", "E", "E", "B", "B", "C", "C", "C", "C");
        Scanner scanner = new Scanner(new PromotionList());
        int finalTotal = scanner.scan(itemsToScan);

        // scanner should apply one multibuy promotion, two meal deals, and one get one free promotion
        assertEquals(850, finalTotal);
    }
}