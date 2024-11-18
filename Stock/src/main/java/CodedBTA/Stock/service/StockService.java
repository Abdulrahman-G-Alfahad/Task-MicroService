package CodedBTA.Stock.service;

import CodedBTA.Stock.bo.CreateStockRequest;
import CodedBTA.Stock.bo.UpdateStockResponse;
import CodedBTA.Stock.entity.StockEntity;

import java.util.List;

public interface StockService {

    UpdateStockResponse updateStock(CreateStockRequest request);

    void addItems(CreateStockRequest stock);

    List<StockEntity> getAll();
}