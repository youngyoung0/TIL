package sample.cafekiosk.spring.api.controller.order.request;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderCreateRequest {

    private List<String> productNumbers;

    @Builder
    private OrderCreateRequest(List<String> productNumbers) {
        this.productNumbers = productNumbers;
    }
}
