package stmallrecently.domain;

import java.util.*;
import lombok.*;
import stmallrecently.domain.*;
import stmallrecently.infra.AbstractEvent;

@Data
@ToString
public class StockDecresed extends AbstractEvent {

    private Long id;
    private String productName;
    private String stock;

    public StockDecresed(Stock aggregate) {
        super(aggregate);
    }

    public StockDecresed() {
        super();
    }
}
