package studyJPA.demo.api;

import lombok.RequiredArgsConstructor;
import org.hibernate.sql.ordering.antlr.OrderByAliasResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import studyJPA.demo.domain.Order;
import studyJPA.demo.domain.OrderItem;
import studyJPA.demo.repository.OrderRepository;
import studyJPA.demo.repository.OrderSearch;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderRepository orderRepository;

    @GetMapping("/api/v1/orders")
    public List<Order> orderV1(){
        List<Order> all= orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName();
            order.getDelivery().getAddress();
            order.getOrderItems();
            List<OrderItem> orderItems = order.getOrderItems();
            for(OrderItem orderItem : orderItems){
                orderItem.getItem().getName();
            }
        }
    }

}
