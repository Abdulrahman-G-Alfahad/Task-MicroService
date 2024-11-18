package CodedBTA.order_stock.repository;


import CodedBTA.order_stock.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<StockEntity, Long> {

    Iterable<StockEntity> findByItem(String item);
}