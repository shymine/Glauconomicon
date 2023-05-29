package shymine.glauconomicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shymine.glauconomicon.campaign.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
