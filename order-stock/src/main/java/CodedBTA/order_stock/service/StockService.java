package CodedBTA.order_stock.service;

import CodedBTA.order_stock.bo.CreateStockRequest;
import CodedBTA.order_stock.bo.UpdateStockResponse;

public interface StockService {

    UpdateStockResponse updateStock(CreateStockRequest request);

    void addItems(CreateStockRequest stock);
}