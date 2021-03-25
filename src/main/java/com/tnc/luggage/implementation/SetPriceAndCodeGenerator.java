package com.tnc.luggage.implementation;

public abstract class SetPriceAndCodeGenerator {
    public void setPrice(long calc) {
        var price = 10;
        if (calc <= 60) {
            System.out.println(price + " lei");
        } else if (calc <= 120) {
            System.out.println((price += 5) + " lei");
        } else if (calc <= 180) {
            System.out.println((price += 10) + " lei");
        } else if (calc <= 240) {
            System.out.println((price += 15) + " lei");
        } else {
            System.out.println("50 lei");
        }
    }

    public double generateCode(double number) {
        return number + (Math.floor(Math.random() * 9_000_000) + 1_000_000);
    }
}
