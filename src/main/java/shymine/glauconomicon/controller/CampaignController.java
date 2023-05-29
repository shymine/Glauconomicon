package shymine.glauconomicon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shymine.glauconomicon.LoadDatabase;
import shymine.glauconomicon.campaign.Campaign;
import shymine.glauconomicon.repository.CampaignRepository;

import java.util.List;

@RestController
public class CampaignController {

    @Autowired
    private CampaignRepository campaignRepository;

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @GetMapping("/campaign")
    public Campaign campaign(@RequestParam(value="name", defaultValue = "Test") String name) {
        Campaign res = this.campaignRepository.findByName(name);
        log.info("/campaign "+res);
        return res;
    }

    @GetMapping("/campaigns")
    public List<Campaign> campaigns() {
        List<Campaign> res = this.campaignRepository.findAll();
        log.info("/campaigns "+res);
        return res;
    }
}
