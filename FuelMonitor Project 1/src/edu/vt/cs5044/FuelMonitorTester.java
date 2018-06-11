package edu.vt.cs5044;

/**
 * Basic test suite for the FuelMonitor class. You will need to develop additional tests to ensure
 * correctness of your system. This file is ignored by Web-CAT, but it will be graded by a human to
 * ensure you've added reasonable tests.
 */
// CHECKSTYLE:OFF
@SuppressWarnings("javadoc")
public class FuelMonitorTester
{

    public static void main(String[] args)
    {

        // create a new fuel monitor object
        System.out.println("-- Constructing new FuelMonitor object FM(14.5)");
        FuelMonitor monitor = new FuelMonitor(14.5);
        System.out.println("Trip miles (expected: 0) was: " + monitor.getTripMiles());
        System.out.println("Lifetime miles (expected: 0) was: " + monitor.getLifetimeMiles());
        System.out.println("Fuel remaining (expected: 14.5) was: " + monitor.getFuelRemaining());

        System.out.println();
        monitor.useInGreenMode(5, 0.123);
        System.out.println("-- After G(5, 0.123)");
        System.out.println("Trip miles (expected: 5) was: " + monitor.getTripMiles());
        System.out.println("Lifetime miles (expected: 5) was: " + monitor.getLifetimeMiles());

        // We've used 0.123 gallons, so 14.5 - 0.123 = 14.377 gallons remain
        System.out.println("Fuel remaining (expected: 14.377) was: " + monitor.getFuelRemaining());

        // Trip and Lifetime MPG are 5 / 0.123 = 40.6504... truncated to 40.6
        System.out.println("Trip MPG (expected: 40.6) was: " + monitor.getTripMPG());
        System.out.println("Lifetime MPG (expected: 40.6) was: " + monitor.getLifetimeMPG());

        // Green miles remaining is 40.6504... * 14.377 = 584.4309... truncated to 580
        System.out.println(
            "Green miles remaining (expected: 580) was: " + monitor.getGreenMilesRemaining());

        System.out.println();
        monitor.useInSportMode(23, 1.234);
        monitor.useInGreenMode(150, 3.14);
        System.out.println("-- After S(23, 1.234) then G(150, 3.14)");
        System.out.println("Trip miles (expected: 178) was: " + monitor.getTripMiles());
        System.out.println("Lifetime miles (expected: 178) was: " + monitor.getLifetimeMiles());

        // We've used an additional 4.374 gallons, so 14.377 - 4.374 = 10.003 gallons remain
        System.out.println("Fuel remaining (expected: 10.003) was: " + monitor.getFuelRemaining());

        // Trip and Lifetime MPG are 178 / 4.497 = 39.5819... truncated to 39.5
        System.out.println("Trip MPG (expected: 39.5) was: " + monitor.getTripMPG());
        System.out.println("Lifetime MPG (expected: 39.5) was: " + monitor.getLifetimeMPG());

        // Green MPG this trip is 155 / 3.263 = 47.5023...
        // Green miles remaining is 10.003 * 47.5023... = 475.1655 truncated to 470
        System.out.println(
            "Green miles remaining (expected: 470) was: " + monitor.getGreenMilesRemaining());

        // Sport MPG this trip is 23 / 1.234 = 18.6386...
        // Sport miles remaining is 10.003 * 18.6383... = 186.4417... truncated to 180
        System.out.println(
            "Sport miles remaining (expected: 180) was: " + monitor.getSportMilesRemaining());

        System.out.println();
        monitor.addFuel(5.55);
        monitor.useInSportMode(0, 0.5);
        monitor.useInSportMode(42, 2.4);
        monitor.useInGreenMode(5, 0.01);
        System.out.println("-- After F(5.55), S(0, 0.5), S(42, 2.4), then G(5, 0.01)");
        System.out.println("Trip miles (expected: 225) was: " + monitor.getTripMiles());
        System.out.println("Lifetime miles (expected: 225) was: " + monitor.getLifetimeMiles());

        // We've added a net 2.64 gallons, so 10.003 + 2.64 = 12.643 gallons remain
        System.out.println("Fuel remaining (expected: 12.643) was: " + monitor.getFuelRemaining());

        // Trip and Lifetime MPG are 225 / (2.91 + 4.497) = 30.3767... truncated to 30.3
        System.out.println("Trip MPG (expected: 30.3) was: " + monitor.getTripMPG());
        System.out.println("Lifetime MPG (expected: 30.3) was: " + monitor.getLifetimeMPG());

        // Green MPG this trip is 160 / 3.273 = 48.8848...
        // Green miles remaining is 12.643 * 48.8848... = 618.0507... truncated to 610
        System.out.println(
            "Green miles remaining (expected: 610) was: " + monitor.getGreenMilesRemaining());

        // Sport MPG this trip is 65 / 4.134 = 15.7233...
        // Sport miles remaining is 12.643 * 15.7233... = 198.7893... truncated to 190
        System.out.println(
            "Sport miles remaining (expected: 190) was: " + monitor.getSportMilesRemaining());

        System.out.println();
        monitor.resetTrip();
        monitor.useInSportMode(20, 1.111);
        monitor.useInGreenMode(345, 10);
        System.out.println("-- After R(), S(20, 1.111), then G(345, 10)");
        System.out.println("Trip miles (expected: 365) was: " + monitor.getTripMiles());
        System.out.println("Lifetime miles (expected: 590) was: " + monitor.getLifetimeMiles());

        // We've used 11.111 gallons, so 12.643 - 11.111 = 1.532 gallons remain
        System.out.println("Fuel remaining (expected: 1.532) was: " + monitor.getFuelRemaining());

        // Trip MPG is 365 / 11.111 = 32.8503... truncated to 32.8
        System.out.println("Trip MPG (expected: 32.8) was: " + monitor.getTripMPG());

        // Lifetime MPG is 590 / (7.407 + 11.111) = 31.8609... truncated to 31.8
        System.out.println("Lifetime MPG (expected: 31.8) was: " + monitor.getLifetimeMPG());

        // Green MPG this trip is 345 / 10 = 34.5
        // Green miles remaining is 1.532 * 34.5 = 52.854 truncated to 50
        System.out.println(
            "Green miles remaining (expected: 50) was: " + monitor.getGreenMilesRemaining());

        // Sport MPG this trip is 20 / 1.111 = 18.0018...
        // Sport miles remaining is 1.532 * 18.0018... = 27.5788... truncated to 20
        System.out.println(
            "Sport miles remaining (expected: 20) was: " + monitor.getSportMilesRemaining());
        System.out.println();

        // create a new fuel monitor object: testMonitor1
        System.out.println("-- Constructing new FuelMonitor object FM(18.5)");
        FuelMonitor testMonitor1 = new FuelMonitor(18.5);
        System.out.println("Trip miles (expected: 0) was: " + testMonitor1.getTripMiles());
        System.out.println("Lifetime miles (expected: 0) was: " + testMonitor1.getLifetimeMiles());
        System.out
            .println("Fuel remaining (expected: 18.5) was: " + testMonitor1.getFuelRemaining());

        System.out.println();
        testMonitor1.useInSportMode(7, 0.45);
        System.out.println("-- After S(7, 0.45)");
        System.out.println("Trip miles (expected: 7) was: " + testMonitor1.getTripMiles());
        System.out.println("Lifetime miles (expected: 7) was: " + testMonitor1.getLifetimeMiles());

        // We've used 0.45 gallons, so 18.5 -0.45 = 18.05 gallons remain
        System.out
            .println("Fuel remaining (expected: 18.05) was: " + testMonitor1.getFuelRemaining());

        // Trip and Lifetime MPG are 7 / 0.45 = 15.555... truncated to 15.5
        System.out.println("Trip MPG (expected: 15.5) was: " + testMonitor1.getTripMPG());
        System.out.println("Lifetime MPG (expected: 15.5) was: " + testMonitor1.getLifetimeMPG());

        // Sport miles remaining is 15.5... * 18.05 = 280.77... truncated to 280
        System.out.println(
            "Sport miles remaining (expected: 280) was: " + testMonitor1.getSportMilesRemaining());

        System.out.println();
        testMonitor1.addFuel(8.5);
        testMonitor1.useInGreenMode(8, 0.25);
        testMonitor1.resetTrip();
        testMonitor1.useInSportMode(25, 1.15);
        testMonitor1.useInGreenMode(32, 1.32);
        System.out.println("-- After F(8.5),G(8, 0.25), R(), S(25, 1.15), then G(32, 1.32)");
        System.out.println("Trip miles (expected: 57) was: " + testMonitor1.getTripMiles());
        System.out.println("Lifetime miles (expected: 72) was: " + testMonitor1.getLifetimeMiles());

        // We've added a net 8.5 gallons, 18.5 + 8.5 - 3.17 = 23.83 gallons remain
        System.out
            .printf("Fuel remaining (expected: 23.83) was: %.2f", testMonitor1.getFuelRemaining());
        System.out.println();

        // Trip MPG is 57 / 2.4742 = 23.0377... truncated to 23.0
        System.out.println("Trip MPG (expected: 23.0) was: " + testMonitor1.getTripMPG());

        // Lifetime MPG is 72 / (0.7 + 2.47 ) = 22.7129... truncated to 22.6
        System.out.println("Lifetime MP (expected: 22.7) was: " + testMonitor1.getLifetimeMPG());

        // Green MPG this trip is 32 / 1.321 = 24.2240...
        // Green miles remaining is 23.83 * 24.2240... = 577.2596... truncated to 570
        System.out.println(
            "Green miles remaining (expected: 570) was: " + testMonitor1.getGreenMilesRemaining());

        // Sport MPG this trip is 25 / 1.15 = 21.6788...
        // Sport miles remaining is 23.83 * 21.6788... = 518.0434... truncated to 580
        System.out.println(
            "Sport miles remaining (expected: 510) was: " + testMonitor1.getSportMilesRemaining());
        System.out.println();

        // create a new fuel monitor object: testMonitor2
        System.out.println("-- Constructing new FuelMonitor object FM(10.4)");
        FuelMonitor testMonitor2 = new FuelMonitor(10.4);
        System.out.println("Trip miles (expected: 0) was: " + testMonitor2.getTripMiles());
        System.out.println("Lifetime miles (expected: 0) was: " + testMonitor2.getLifetimeMiles());
        System.out
            .println("Fuel remaining (expected: 10.4) was: " + testMonitor2.getFuelRemaining());

        System.out.println();
        testMonitor2.addFuel(4.2);
        testMonitor2.useInGreenMode(23, 1.2);
        testMonitor2.useInSportMode(13, 1.13);
        System.out.println("-- After F(4.2), G(23, 1.2), then S(13, 1.13)");
        System.out.println("Trip miles (expected: 36) was: " + testMonitor2.getTripMiles());
        System.out.println("Lifetime miles (expected: 36) was: " + testMonitor2.getLifetimeMiles());

        // We've added a net 4.2 gallons, 10.4 + 4.2 - 2.33 = 12.27 gallons remain
        System.out
            .printf("Fuel remaining (expected: 12.27) was: %.2f", testMonitor2.getFuelRemaining());
        System.out.println();

        // Trip MPG is 36 / 2.33 = 15.4506... truncated to 15.4
        System.out.println("Trip MPG (expected: 15.4) was: " + testMonitor2.getTripMPG());

        // Lifetime MPG is 36 / 2.33 = 15.4506... truncated to 15.4
        System.out.println("Lifetime MPG (expected: 15.4) was: " + testMonitor2.getLifetimeMPG());

        // Green MPG this trip is 23 / 1.2 = 19.1666...
        // Green miles remaining is 12.27 * 19.1666... = 235.175... truncated to 230
        System.out.println(
            "Green miles remaining (expected: 230) was: " + testMonitor2.getGreenMilesRemaining());

        // Sport MPG this trip is 13 / 1.13 = 11.5044...
        // Sport miles remaining is 12.27 * 11.5044... = 141.1592... truncated to 140
        System.out.println(
            "Sport miles remaining (expected: 140) was: " + testMonitor2.getSportMilesRemaining());

        System.out.println();
        testMonitor2.useInSportMode(30, 2.234);
        testMonitor2.resetTrip();
        testMonitor2.useInGreenMode(25, 1.421);

        // testMonitor2.useInGreenMode(32, 1.32);
        System.out.println("-- After S(30, 2.234), R(), then G(25, 1.421)");
        System.out.println("Trip miles (expected: 25) was: " + testMonitor2.getTripMiles());
        System.out.println("Lifetime miles (expected: 91) was: " + testMonitor2.getLifetimeMiles());

        // We've used a net 3.655 gallons, 12.27 - 3.655 = 8.615 gallons remain
        System.out
            .printf("Fuel remaining (expected: 8.615) was: %.3f", testMonitor2.getFuelRemaining());
        System.out.println();
        // Trip MPG is 25 / 1.421 = 17.5932... truncated to 17.5
        System.out.println("Trip MPG (expected: 17.5) was: " + testMonitor2.getTripMPG());

        // Lifetime MPG is 91 / 5.985 = 15.2046... truncated to 15.2
        System.out.println("Lifetime MPG (expected: 15.2) was: " + testMonitor2.getLifetimeMPG());

        // Green MPG this trip is 25 / 1.421 = 17.5932...
        // Green miles remaining is 8.615 * 17.5932... = 151.5657... truncated to 150
        System.out.println(
            "Green miles remaining (expected: 150) was: " + testMonitor2.getGreenMilesRemaining());

        // Sport MPG this trip is 0 / 0 = 0...
        // Sport miles remaining is 12.27 * 0 = 0 truncated to 0
        System.out.println(
            "Sport miles remaining (expected: 0) was: " + testMonitor2.getSportMilesRemaining());
        System.out.println();

        // create a new fuel monitor object: testMonitor3
        System.out.println("-- Constructing new FuelMonitor object FM(16.62)");
        FuelMonitor testMonitor3 = new FuelMonitor(16.62);
        System.out
            .println("Fuel remaining (expected: 16.62) was: " + testMonitor3.getFuelRemaining());

        System.out.println();
        testMonitor3.useInGreenMode(50, 1.52);
        testMonitor3.useInSportMode(65, 4.33);
        testMonitor3.addFuel(6.5);
        System.out.println("-- After G(50, 1.52), S(65, 4.33), then F(6.5)");
        System.out.println("Trip miles (expected: 115) was: " + testMonitor3.getTripMiles());
        System.out
            .println("Lifetime miles (expected: 115) was: " + testMonitor3.getLifetimeMiles());

        // We've added a net 6.5 gallons, 16.62 + 6.5 - 5.85 = 17.27 gallons remain
        System.out
            .printf("Fuel remaining (expected: 17.27) was: %.2f", testMonitor3.getFuelRemaining());
        System.out.println();

        // Trip MPG is 115 / 5.85 = 19.6581... truncated to 19.6
        System.out.println("Trip MPG (expected: 19.6) was: " + testMonitor3.getTripMPG());

        // Lifetime MPG is 115 / 5.85 = 19.6581... truncated to 15.4
        System.out.println("Lifetime MPG (expected: 19.6) was: " + testMonitor3.getLifetimeMPG());

        // Green MPG this trip is 50 / 1.52 = 32.8947...
        // Green miles remaining is 17.27 * 32.8947... = 568.0921... truncated to 560
        System.out.println(
            "Green miles remaining (expected: 560) was: " + testMonitor3.getGreenMilesRemaining());

        // Sport MPG this trip is 65 / 4.33 = 15.0115...
        // Sport miles remaining is 17.27 * 15.0115... = 259.2494... truncated to 250
        System.out.println(
            "Sport miles remaining (expected: 250) was: " + testMonitor3.getSportMilesRemaining());
        System.out.println();

        testMonitor3.useInSportMode(20, 0.89);
        testMonitor3.useInGreenMode(40, 1.35);
        testMonitor3.resetTrip();

        testMonitor3.addFuel(7.4);
        testMonitor3.useInGreenMode(26, 1.02);
        testMonitor3.useInSportMode(29, 2.04);
        System.out.println(
            "-- After S(20, 0.89), (40, 1.35), R(), F(7.4), G(26, 1.02), then S(29, 2.04)");
        System.out.println("Trip miles (expected: 55) was: " + testMonitor3.getTripMiles());
        System.out
            .println("Lifetime miles (expected: 230) was: " + testMonitor3.getLifetimeMiles());

        // We've added a net 7.4 gallons, 17.27 + 7.4 - 5.3 = 19.37 gallons remain
        System.out
            .printf("Fuel remaining (expected: 19.37) was: %.2f", testMonitor3.getFuelRemaining());
        System.out.println();

        // Trip MPG is 55 / 3.06 = 17.9738... truncated to 17.9
        System.out.println("Trip MPG (expected: 17.9) was: " + testMonitor3.getTripMPG());

        // Lifetime MPG is 230 / 11.15 = 20.6278... truncated to 20.6
        System.out.println("Lifetime MPG (expected: 20.6) was: " + testMonitor3.getLifetimeMPG());

        // Green MPG this trip is 26 / 1.02 = 25.4901......
        // Green miles remaining is 19.37 * 25.4901... = 493.7450... truncated to 490
        System.out.println(
            "Green miles remaining (expected: 490) was: " + testMonitor3.getGreenMilesRemaining());

        // Sport MPG this trip is 29 / 2.04 = 14.2156...
        // Sport miles remaining is 19.37 * 14.2156... = 275.3578... truncated to 270
        System.out.println(
            "Sport miles remaining (expected: 270) was: " + testMonitor3.getSportMilesRemaining());
        System.out.println();

    }

}
