package studyJPA.demo.repository;

import lombok.Getter;
import lombok.Setter;
import studyJPA.demo.domain.OrderStatus;

@Getter
@Setter
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;
}
