package stmallrecently.domain;

import java.util.*;
import lombok.*;
import stmallrecently.domain.*;
import stmallrecently.infra.AbstractEvent;

@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String productId;
    private Integer amount;
    private String productName;
    private Integer qty;
    private String status;
}
