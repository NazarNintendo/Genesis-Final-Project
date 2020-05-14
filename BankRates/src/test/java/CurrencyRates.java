import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.BankInfo;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CurrencyRates extends TestManager{

    private static ArrayList<BankInfo> bankList = setUpBankList();

    private static ArrayList<BankInfo> setUpBankList() {
        ArrayList<BankInfo> bankList = new ArrayList<>();
        bankList.add(new BankInfo("PrivatBank"));
        bankList.add(new BankInfo("UkrsibBank"));
        bankList.add(new BankInfo("AvalBank"));
        bankList.add(new BankInfo("OshchadBank"));
        bankList.add(new BankInfo("NBU"));
        return bankList;
    }

    @Test
    public void ratesPrivatBank() {
        driver.get("https://www.privat24.ua");
        if (driver.getCurrentUrl().equals("https://next.privat24.ua/")) {
            driver.findElement(By.cssSelector("button.sc-bwzfXH.gjDPyc")).click();
        }
        String rates = driver.findElement(By.cssSelector("div.section-content.rate")).getText();
        String[] buysell = rates.split("/");


        bankList.get(0).setBuyRate(Double.parseDouble(buysell[0].trim()));
        bankList.get(0).setSellRate(Double.parseDouble(buysell[1].trim()));
    }

    @Test
    public void ratesUkrsibBank() {
        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");

        bankList.get(1).setBuyRate(Double.parseDouble(driver.findElement(By.cssSelector("table.currency__table>tbody>tr>td:nth-of-type(2)")).getText()));
        bankList.get(1).setSellRate(Double.parseDouble(driver.findElement(By.cssSelector("table.currency__table>tbody>tr>td:nth-of-type(3)")).getText()));
    }

    @Test
    public void openAvalBank(){
        driver.get("https://www.aval.ua/ru");

        bankList.get(2).setBuyRate(Double.parseDouble(driver.findElement(By.cssSelector("div.rate-numbers.rate-numbers-usd>span:first-of-type")).getText()));
        bankList.get(2).setSellRate(Double.parseDouble(driver.findElement(By.cssSelector("div.rate-numbers.rate-numbers-usd>span:nth-of-type(2)")).getText()));
    }

    @Test
    public void openOshchadBank(){
        driver.get("https://www.oschadbank.ua/ua");

        bankList.get(3).setBuyRate(Double.parseDouble(driver.findElement(By.cssSelector("strong.buy-USD")).getText()));
        bankList.get(3).setSellRate(Double.parseDouble(driver.findElement(By.cssSelector("strong.sell-USD")).getText()));
    }

    @Test
    public void openNBU(){
        driver.get("http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");
        String s = driver.findElement(By.cssSelector("table#exchangeRates>tbody>tr:nth-of-type(8)>td:nth-of-type(5)")).getText();
        s = s.replace(',','.');

        bankList.get(4).setBuyRate(Double.parseDouble(s));
        bankList.get(4).setSellRate(0.);
    }

    @AfterAll
    public static void Analysis() {
        for(BankInfo bank : bankList)
            System.out.println(bank.getBankName() + ":" +  " Buy Rate = " + bank.getBuyRate() + " Sell Rate = " + bank.getSellRate());

        System.out.println("RESULTS");

        double tempBuy = 0.;
        double tempSell = 0.;
        int realBuySize = 0;
        int realSellSize = 0;
        for(BankInfo bank : bankList) {
            tempBuy += bank.getBuyRate();
            tempSell += bank.getSellRate();

            if (bank.getBuyRate() != 0.)
                realBuySize++;
            if (bank.getSellRate() != 0.)
                realSellSize++;
        }

        double averageBuyRate = tempBuy / realBuySize;
        double averageSellRate = tempSell / realSellSize;

        System.out.println("Average buy rate = " + averageBuyRate);
        System.out.println("Average sell rate = " + averageSellRate);

        double minBuyRate = 10000;
        double maxSellRate = 0;
        int bankWithMin = 0;
        int bankWithMax = 0;

        for(BankInfo bank : bankList) {
            if (bank.getBuyRate() < minBuyRate) {
                minBuyRate = bank.getBuyRate();
                bankWithMin = bankList.indexOf(bank);
            }

            if (bank.getSellRate() > maxSellRate) {
                maxSellRate = bank.getSellRate();
                bankWithMax = bankList.indexOf(bank);
            }
        }

        System.out.println("The bank with the smallest buy rate is " + bankList.get(bankWithMin).getBankName());
        System.out.println("The bank with the biggest sell rate is " + bankList.get(bankWithMax).getBankName());
    }

}
