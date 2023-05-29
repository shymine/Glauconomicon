package shymine.glauconomicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shymine.glauconomicon.campaign.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
