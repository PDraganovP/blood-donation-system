package controllers;

import app.BloodDonationApp;
import app.entities.Address;
import app.entities.BloodDonationCenter;
import app.entities.User;
import app.repositories.BloodDonationCenterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BloodDonationApp.class)
@DataJpaTest
@ActiveProfiles("test")
public class BloodDonationCenterRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private BloodDonationCenterRepository bloodDonationCenterRepository;

    private void createBloodDonationCenters(TestEntityManager testEntityManager) {
        BloodDonationCenter bloodDonationCenterOne = new BloodDonationCenter();
        bloodDonationCenterOne.setName("ЦТДХ-Пловдив");
        User userOne = new User();
        userOne.setUsername("BDC-Plovdiv");
        userOne.setPassword("BDC-Plovdiv");
        testEntityManager.persistAndFlush(bloodDonationCenterOne);
        bloodDonationCenterOne.setUser(userOne);
        userOne.setBloodDonationCenter(bloodDonationCenterOne);
        testEntityManager.persistAndFlush(userOne);
        Address addressOne = new Address();
        addressOne.setRegion("Пловдив");
        addressOne.setCity("Пловдив");
        addressOne.setStreet("Мир 15");
        bloodDonationCenterOne.setAddress(addressOne);
        addressOne.setBloodDonationCenter(bloodDonationCenterOne);
        testEntityManager.persistAndFlush(addressOne);

        BloodDonationCenter bloodDonationCenterTwo = new BloodDonationCenter();
        bloodDonationCenterTwo.setName("ЦТДХ-Стара Загора");
        User userTwo = new User();
        userTwo.setUsername("BDC-Stara Zagora");
        userTwo.setPassword("BDC-Stara Zagora");
        testEntityManager.persistAndFlush(bloodDonationCenterTwo);
        bloodDonationCenterTwo.setUser(userTwo);
        userTwo.setBloodDonationCenter(bloodDonationCenterTwo);
        testEntityManager.persistAndFlush(userTwo);
        Address addressTwo = new Address();
        addressTwo.setRegion("Стара Загора");
        addressTwo.setCity("Стара Загора");
        addressTwo.setStreet("Тракия 119");
        bloodDonationCenterTwo.setAddress(addressTwo);
        addressTwo.setBloodDonationCenter(bloodDonationCenterTwo);
        testEntityManager.persistAndFlush(addressTwo);

        BloodDonationCenter bloodDonationCenterThree = new BloodDonationCenter();
        bloodDonationCenterThree.setName("ЦТДХ-Русе");
        User userThree = new User();
        userThree.setUsername("BDC-Ruse");
        userThree.setPassword("BDC-Ruse");
        testEntityManager.persistAndFlush(bloodDonationCenterThree);
        bloodDonationCenterThree.setUser(userThree);
        userThree.setBloodDonationCenter(bloodDonationCenterThree);
        testEntityManager.persistAndFlush(userThree);
        Address addressThree = new Address();
        addressThree.setRegion("Русе");
        addressThree.setCity("Русе");
        addressThree.setStreet("Дунав 11");
        bloodDonationCenterThree.setAddress(addressThree);
        addressThree.setBloodDonationCenter(bloodDonationCenterThree);
        testEntityManager.persistAndFlush(addressThree);

        BloodDonationCenter bloodDonationCenterFour = new BloodDonationCenter();
        bloodDonationCenterFour.setName("ЦТДХ-Плевен");
        User userFour = new User();
        userFour.setUsername("BDC-Pleven");
        userFour.setPassword("BDC-Pleven");
        testEntityManager.persistAndFlush(bloodDonationCenterFour);
        bloodDonationCenterFour.setUser(userFour);
        userFour.setBloodDonationCenter(bloodDonationCenterFour);
        testEntityManager.persistAndFlush(userFour);
        Address addressFour = new Address();
        addressFour.setRegion("Плевен");
        addressFour.setCity("Плевен");
        addressFour.setStreet("Юли 16");
        bloodDonationCenterFour.setAddress(addressFour);
        addressFour.setBloodDonationCenter(bloodDonationCenterFour);
        testEntityManager.persistAndFlush(addressFour);

        BloodDonationCenter bloodDonationCenterFive = new BloodDonationCenter();
        bloodDonationCenterFive.setName("ЦТДХ-Бургас");
        User userFive = new User();
        userFive.setUsername("BDC-Bourgas");
        userFive.setPassword("BDC-Bourgas");
        testEntityManager.persistAndFlush(bloodDonationCenterFive);
        bloodDonationCenterFive.setUser(userFive);
        userFive.setBloodDonationCenter(bloodDonationCenterFive);
        testEntityManager.persistAndFlush(userFive);
        Address addressFive = new Address();
        addressFive.setRegion("Бургас");
        addressFive.setCity("Бургас");
        addressFive.setStreet("Чайка 13");
        bloodDonationCenterFive.setAddress(addressFive);
        addressFive.setBloodDonationCenter(bloodDonationCenterFive);
        testEntityManager.persistAndFlush(addressFive);

        BloodDonationCenter bloodDonationCenterSix = new BloodDonationCenter();
        bloodDonationCenterSix.setName("ЦТДХ-Силистра");
        User userSix = new User();
        userSix.setUsername("BDC-Silistra");
        userSix.setPassword("BDC-Silistra");
        testEntityManager.persistAndFlush(bloodDonationCenterSix);
        bloodDonationCenterSix.setUser(userSix);
        userSix.setBloodDonationCenter(bloodDonationCenterSix);
        testEntityManager.persistAndFlush(userSix);
        Address addressSix = new Address();
        addressSix.setRegion("Силистра");
        addressSix.setCity("Силистра");
        addressSix.setStreet("Панайот Волов 32");
        bloodDonationCenterSix.setAddress(addressSix);
        addressSix.setBloodDonationCenter(bloodDonationCenterSix);
        testEntityManager.persistAndFlush(addressSix);
    }

    @Test
    public void testFindByUsername() {
        this.createBloodDonationCenters(this.testEntityManager);
        BloodDonationCenter bloodDonationCenter = this.bloodDonationCenterRepository.findByUsername("BDC-Pleven");
        String name = bloodDonationCenter.getName();
        assertEquals("ЦТДХ-Плевен", name);
    }

    @Test
    public void testEditBloodDonationCenterById() {
        this.createBloodDonationCenters(this.testEntityManager);
        BloodDonationCenter bloodDonationCenter = this.bloodDonationCenterRepository.findById(5);
        Address address = bloodDonationCenter.getAddress();
        address.setRegion("Бургас");
        address.setCity("Бургас");
        address.setStreet("Приморски 27");

        this.testEntityManager.detach(bloodDonationCenter);
        this.bloodDonationCenterRepository.editBloodDonationCenterById("КЦ-Бургас", address, 5);
        BloodDonationCenter bdc = this.bloodDonationCenterRepository.findById(5);
        String name = bdc.getName();

        assertEquals("КЦ-Бургас", name);
    }
}
