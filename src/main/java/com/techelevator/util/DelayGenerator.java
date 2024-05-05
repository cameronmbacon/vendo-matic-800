package com.techelevator.util;

public class DelayGenerator {
    public static void excecuteOneSecondDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("ERROR: SYSTEM CONNECTION DISRUPTED ");
        } catch (Exception e) {
            System.out.println("ERROR: SYSTEM MALFUNCTION ");
        }
    }


    public static void excecuteTwoSecondDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("ERROR: SYSTEM CONNECTION DISRUPTED ");
        } catch (Exception e) {
            System.out.println("ERROR: SYSTEM MALFUNCTION ");
        }
    }


    public static void excecuteThreeSecondDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("ERROR: SYSTEM CONNECTION DISRUPTED ");
        } catch (Exception e) {
            System.out.println("ERROR: SYSTEM MALFUNCTION ");
        }
    }

    public static void excecuteFourSecondDelay() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            System.out.println("ERROR: SYSTEM CONNECTION DISRUPTED ");
        } catch (Exception e) {
            System.out.println("ERROR: SYSTEM MALFUNCTION ");
        }
    }

    public static void excecuteFiveSecondDelay() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println("ERROR: SYSTEM CONNECTION DISRUPTED ");
        } catch (Exception e) {
            System.out.println("ERROR: SYSTEM MALFUNCTION ");
        }
    }

    public static void excecuteHalfSecondDelay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("ERROR: SYSTEM CONNECTION DISRUPTED ");
        } catch (Exception e) {
            System.out.println("ERROR: SYSTEM MALFUNCTION ");
        }
    }

    public static void excecuteOneFourthSecondDelay() {
        try {
            Thread.sleep(250);
        } catch (InterruptedException ex) {
            System.out.println("ERROR: SYSTEM CONNECTION DISRUPTED ");
        } catch (Exception e) {
            System.out.println("ERROR: SYSTEM MALFUNCTION ");
        }
    }

}

