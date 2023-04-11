package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 총합이 10000 넘게 입력해주세요.")
public class Item {
    @NotNull // 수정할때는 아이디가 있지만 추가할때는 아이디가 없어서 등록이 안되는 이슈 발생
    private Long id;

    @NotBlank(message = "공백X")
    private String itemName;

    @NotNull
    @Range(min=1000, max=100000)
    private Integer price;

    @NotNull
//    @Max(9999) // 수정 요구사항 추가
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
