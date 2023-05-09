package stmallrecently.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmallrecently.config.kafka.KafkaProcessor;
import stmallrecently.domain.*;

@Service
public class ProductSearchViewHandler {

    @Autowired
    private ProductSearchRepository productSearchRepository;
}
