package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/blood-donation-center")
    String getBloodDonationCenterPage() {
        return "basicPages/blood-donation-center";
    }

    @GetMapping("/blood-donors")
    String getBloodDonorsPage() {
        return "basicPages/blood-donors";
    }

    @GetMapping("/blood-groups")
    String getBloodGroupsPage() {
        return "basicPages/blood-groups";
    }

    @GetMapping("/blood-recipients")
    String getBloodRecipientsPage() {
        return "basicPages/blood-recipients";
    }

    @GetMapping("/blood-testing")
    String getBloodTestingPage() {
        return "basicPages/blood-testing";
    }

    @GetMapping("/blood-transfusion")
    String getBloodTransfusionPage() {
        return "basicPages/blood-transfusion";
    }

    @GetMapping("/")
    String getHomePage() {
        return "basicPages/home";
    }

}
