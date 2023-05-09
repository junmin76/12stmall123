package stmallrecently.domain;

import java.util.*;
import lombok.*;
import stmallrecently.domain.*;
import stmallrecently.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String orderId;
    private String productId;
    private String userId;
    private String address;
    private String customerId;
    private Integer amount;
    private String productName;
    private Integer qty;
    private String status;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
