package CodedBTA.order_stock.controller;

import CodedBTA.order_stock.bo.CreateStockRequest;
import CodedBTA.order_stock.bo.UpdateStockResponse;
import CodedBTA.order_stock.service.StockService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final StockService stockService;

    public OrderController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/orders")
    public UpdateStockResponse doOrder(@RequestBody CreateStockRequest customerOrder) {

        UpdateStockResponse response = stockService.updateStock(customerOrder);

        return response;
    }
}