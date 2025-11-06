package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() {
        System.out.println("Golden master");
        Item[] items = {new Item("Random", 3, 20),
                new Item("Random", -6, -20),
                new Item("Comté", 1, 40),
                new Item("Kryptonite", -3, 80),
                new Item("Pass VIP Concert", 13, 37),
                new Item("Pass VIP Concert", 5, 37),
                new Item("Pass VIP Concert", -1, 37),
        };

        Magasin magasin = new Magasin(items);
        for(int i = 0; i<=10; i++){
            System.out.println("Jour "+i);
            magasin.updateQuality();
            for (Item item : items) {
                System.out.println(item.toString());
            }

        }
    }

}
