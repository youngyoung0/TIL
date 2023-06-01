package sample.cafekiosk.spring.api.service.order.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.domain.order.Order;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderCreateServiceRequest {
    private List<String> productNumbers;

    @Builder
    public OrderCreateServiceRequest(List<String> productNumbers) {
        this.productNumbers = productNumbers;
    }
}
