package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data // -> DTO인 경우가 아니라면 그냥 사용 시 위험하다.
public class Item {
    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    private Long id;
    private String itemName;
    private Integer price; // price는 null이 될 수 없다.
    private Integer quantity; // quantity는 null이 될 수 없다.

    public Item() {
    }
}
