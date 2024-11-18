package CodedBTA.Stock.controller;


import CodedBTA.Stock.bo.AccountResponse;
import CodedBTA.Stock.bo.CreateStockRequest;
import CodedBTA.Stock.bo.StockResponse;
import CodedBTA.Stock.bo.UpdateStockResponse;
import CodedBTA.Stock.entity.StockEntity;
import CodedBTA.Stock.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/addItems")
    public void addItems(@RequestBody CreateStockRequest stock) {
        stockService.addItems(stock);
    }

    @PostMapping("/updateStock")
    public UpdateStockResponse updateStock(@RequestBody CreateStockRequest request) {
        return stockService.updateStock(request);
    }

    @GetMapping("/account")
    public AccountResponse getAccount() {
        AccountResponse response = new AccountResponse();

        List<StockResponse> stockList = stockService.getAll().stream().map(stockEntity -> {
                    StockResponse stock = new StockResponse();
                    stock.setId(stockEntity.getId());
                    stock.setQuantity((int) stockEntity.getQuantity());
                    stock.setItem(stockEntity.getItem());
                    return stock;
                }).toList();

        response.setStocks(stockList);
        return response;
    }

}