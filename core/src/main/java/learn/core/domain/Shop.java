package learn.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Document
@Getter
@Setter
@Accessors(chain = true, fluent = true)
public class Shop {

    private String id;

    @Indexed(unique = true)
    private String identifier;

    private Status status;

    private LocalDate date;

    private List<ShopItem> items;

    public enum Status {
        PENDING, SUCCESS, ERROR;
    }

    public static Shop create() {
        return new Shop()
                .items(new LinkedList<>())
                .identifier(UUID.randomUUID().toString());
    }

    public void add(List<ShopItem> items) {
        this.items.addAll(items);
    }
}
