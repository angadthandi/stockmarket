package client;

public class ClientBootstrap {

    public static void Run() {
        int totalTests = 0;
        int totalPassed = 0;
        int totalFailed = 0;

        TestMetric request = TestStockMarket.Run();
        totalTests += request.Total;
        totalPassed += request.Pass;
        totalFailed += request.Fail;

        System.out.printf(
            "\nTOTAL TESTS : %d; TOTAL PASSED : %d; TOTAL FAILED : %d",
            totalTests, totalPassed, totalFailed
        );
    }

}