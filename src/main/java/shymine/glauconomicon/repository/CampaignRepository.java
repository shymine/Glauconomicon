package shymine.glauconomicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shymine.glauconomicon.campaign.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    public Campaign findByName(String name);
}
