package stmallrecently.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmallrecently.config.kafka.KafkaProcessor;
import stmallrecently.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StockIncresed'"
    )
    public void wheneverStockIncresed_NotifyToWatingUser(
        @Payload StockIncresed stockIncresed
    ) {
        StockIncresed event = stockIncresed;
        System.out.println(
            "\n\n##### listener NotifyToWatingUser : " + stockIncresed + "\n\n"
        );

        // Sample Logic //
        Order.notifyToWatingUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCancelled'"
    )
    public void wheneverDeliveryCancelled_NotifyToWatingUser(
        @Payload DeliveryCancelled deliveryCancelled
    ) {
        DeliveryCancelled event = deliveryCancelled;
        System.out.println(
            "\n\n##### listener NotifyToWatingUser : " +
            deliveryCancelled +
            "\n\n"
        );

        // Sample Logic //
        Order.notifyToWatingUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_NotifyToWatingUser(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener NotifyToWatingUser : " +
            deliveryStarted +
            "\n\n"
        );

        // Sample Logic //
        Order.notifyToWatingUser(event);
    }
}
