package CodedBTA.Account.bo;

import java.util.ArrayList;
import java.util.List;

public class AccountResponse {
    private List<Stock> stocks = new ArrayList<>();

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
