package com.magasin;

class Magasin {
    Item[] items; // variable global tableau d'objets

    public Magasin(Item[] items) {
        this.items = items;
    } //Il a une liste d'item dans la classe Magasin

    public void updateQuality() {
        for (Item item : items) {
            // rentre si cas specifique
            if (item.name.equals("Pass VIP Concert") || item.name.equals("Comté") || item.name.equals("Kryptonite")) {
                // rentre si Kryptonite
                if (item.name.equals("Kryptonite")) {
                    continue;
                }
                // rentre si Comté
                if (item.name.equals("Comté")) {
                    if (item.sellIn > 0) {
                        item.quality = Math.min(50, item.quality + 1);
                    } else {
                        item.quality = Math.min(50, item.quality + 2);
                    }

                }
                // Rentre si Pass Vip Concert
                if (item.name.equals("Pass VIP Concert")) {
                    if (item.sellIn <= 0) {
                        item.quality = 0;
                    } else if (item.sellIn <= 5) {
                        item.quality = Math.min(50, item.quality + 3);
                    } else if (item.sellIn <= 10) {
                        item.quality = Math.min(50, item.quality + 2);
                    } else {
                        item.quality = Math.min(50, item.quality + 1);
                    }
                }
                // hors cas specifique
            } else {
                if (item.quality > 0) {
                    if (item.sellIn <= 0) {
                        item.quality = Math.max(0, item.quality - 2);
                    } else {
                        item.quality--;
                    }

                }
            }
            item.sellIn--;
        }

    }

    public void updateQuality() {// Pour la qualité des objets
        for (int i = 0; i < items.length; i++) { //on parcour le tableau d'item
            if (!items[i].name.equals("Comté") //Les exceptions pour le comté
                    && !items[i].name.equals("Pass VIP Concert")) { //Et le passe VIP qui gagne en qualité avec le temps
                if (items[i].quality > 0) { //Si les objets on une qualité > à 0
                    if (!items[i].name.equals("Kryptonite")) { //Excepté la kryptonite
                        items[i].quality = items[i].quality - 1; //La qualité diminue de 1
                    }
                }
            } else {
                if (items[i].quality < 50) { //SI les items comté et passvip sont < à 50 car c'est la limite
                    items[i].quality = items[i].quality + 1; //la qualité augmente de 1

                    if (items[i].name.equals("Pass VIP Concert")) { //Si l'item c'est passvip
                        if (items[i].sellIn < 11) { // qu'il a une date de péremption < à 11
                            if (items[i].quality < 50) { //et une qualité < 50
                                items[i].quality = items[i].quality + 1; //il augmente sa qualité de 1
                            }
                        }

                        if (items[i].sellIn < 6) { //Si la date de péremption est <6
                            if (items[i].quality < 50) { //la qualité <50 alors il prend +1
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
ds
            if (!items[i].name.equals("Kryptonite")) { // pour tout les items sauf kryptonite
                items[i].sellIn = items[i].sellIn - 1; //la date de péremption diminue de 1
            }

            if (items[i].sellIn < 0) { //Si la date de péremption des items est < 0
                if (!items[i].name.equals("Comté")) { // excepté le comté
                    if (!items[i].name.equals("Pass VIP Concert")) { //excepté le passvip
                        if (items[i].quality > 0) { //et si la qualité est > 0
                            if (!items[i].name.equals("Kryptonite")) { //sauf pour la krypto
                                items[i].quality = items[i].quality - 1; //la qualité baisse de 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality; //sinon la qualité est égale à 0
                    }
                } else {
                    if (items[i].quality < 50) { //si la qualité est < 50 alors il prend +1
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
