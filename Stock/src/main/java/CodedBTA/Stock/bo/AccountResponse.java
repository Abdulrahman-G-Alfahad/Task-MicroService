package CodedBTA.Stock.bo;

import CodedBTA.Stock.entity.StockEntity;

import java.util.List;

public class AccountResponse {

    private List<StockResponse> stocks;

    public List<StockResponse> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockResponse> stocks) {
        this.stocks = stocks;
    }
}
