package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/blood-donation-center")
    String getBloodDonationCenterPage() {
        return "pages/blood-donation-center";
    }

    @GetMapping("/blood-donors")
    String getBloodDonorsPage() {
        return "pages/blood-donors";
    }

    @GetMapping("/blood-groups")
    String getBloodGroupsPage() {
        return "pages/blood-groups";
    }

    @GetMapping("/blood-recipients")
    String getBloodRecipientsPage() {
        return "pages/blood-recipients";
    }

    @GetMapping("/blood-testing")
    String getBloodTestingPage() {
        return "pages/blood-testing";
    }

    @GetMapping("/blood-transfusion")
    String getBloodTransfusionPage() {
        return "pages/blood-transfusion";
    }

    @GetMapping("/")
    String getHomePage() {
        return "pages/home";
    }

}
