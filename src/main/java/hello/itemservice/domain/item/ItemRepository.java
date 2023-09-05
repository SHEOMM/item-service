package hello.itemservice.domain.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {
    // 실무에서는 hashMap을 적용해서는 안된다. singleton이기 때문에 사용하고 싶으면 ConcurrentHashMap을 사용해야 한다.
    // long도 마찬가지로 atomic Long 등을 사용해야 한다.
    private static final Map<Long, Item> store = new HashMap<>(); // static
    private static long sequence = 0L; // static

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }
    // 원래면 ItemDTO를 따로 만들어서 사용하는 것이 맞다.
    // 왜냐하면 id를 사용하지 않는 경우이기 때문이다.
    // 중복인 것 같아도 "명확성"을 따르는 것이 맞기 때문이다.
    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }
}
