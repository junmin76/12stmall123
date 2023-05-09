package stmallrecently.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmallrecently.InventoryApplication;
import stmallrecently.domain.StockDecresed;
import stmallrecently.domain.StockIncresed;

@Entity
@Table(name = "Stock_table")
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private String stock;

    @PostUpdate
    public void onPostUpdate() {
        StockDecresed stockDecresed = new StockDecresed(this);
        stockDecresed.publishAfterCommit();

        StockIncresed stockIncresed = new StockIncresed(this);
        stockIncresed.publishAfterCommit();
    }

    public static StockRepository repository() {
        StockRepository stockRepository = InventoryApplication.applicationContext.getBean(
            StockRepository.class
        );
        return stockRepository;
    }

    public static void decresedStock(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        StockDecresed stockDecresed = new StockDecresed(stock);
        stockDecresed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);

            StockDecresed stockDecresed = new StockDecresed(stock);
            stockDecresed.publishAfterCommit();

         });
        */

    }

    public static void incresedStock(DeliveryCancelled deliveryCancelled) {
        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        StockIncresed stockIncresed = new StockIncresed(stock);
        stockIncresed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCancelled.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);

            StockIncresed stockIncresed = new StockIncresed(stock);
            stockIncresed.publishAfterCommit();

         });
        */

    }
}
