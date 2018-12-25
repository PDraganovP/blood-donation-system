package controllers;

import app.BloodDonationApp;
import app.entities.Address;
import app.entities.BloodDonator;
import app.entities.User;
import app.repositories.BloodDonatorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BloodDonationApp.class)
@DataJpaTest
@ActiveProfiles("test")
public class BloodDonatorRepositoryTest {

    @Autowired
    private BloodDonatorRepository bloodDonatorRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    private void createBloodDonators(TestEntityManager testEntityManager) {
        BloodDonator bloodDonatorOne = new BloodDonator();
        bloodDonatorOne.setFirstName("Христо");
        bloodDonatorOne.setLastName("Христов");
        bloodDonatorOne.setActiveBloodDonator(true);
        bloodDonatorOne.setRhPositive(false);
        bloodDonatorOne.setAge(31);
        Address addressOne = new Address();
        addressOne.setRegion("В.Търново");
        addressOne.setCity("В.Търново");
        addressOne.setStreet("Царевец 85");
        testEntityManager.persistAndFlush(bloodDonatorOne);
        addressOne.setBloodDonator(bloodDonatorOne);
        bloodDonatorOne.setAddress(addressOne);
        testEntityManager.persistAndFlush(addressOne);
        User userOne = new User();
        userOne.setUsername("Hristov");
        userOne.setPassword("Hristov");
        userOne.setBloodDonator(bloodDonatorOne);
        bloodDonatorOne.setUser(userOne);
        testEntityManager.persistAndFlush(userOne);

        BloodDonator bloodDonatorTwo = new BloodDonator();
        bloodDonatorTwo.setFirstName("Димитър");
        bloodDonatorTwo.setLastName("Иванов");
        bloodDonatorTwo.setActiveBloodDonator(false);
        bloodDonatorTwo.setRhPositive(false);
        bloodDonatorTwo.setAge(38);
        Address addressTwo = new Address();
        addressTwo.setRegion("Cтара Загора");
        addressTwo.setCity("Стара Загора");
        addressTwo.setStreet("Гео Милев 95");
        testEntityManager.persistAndFlush(bloodDonatorTwo);
        bloodDonatorTwo.setAddress(addressTwo);
        addressTwo.setBloodDonator(bloodDonatorTwo);
        testEntityManager.persistAndFlush(addressTwo);
        User userTwo = new User();
        userTwo.setUsername("Ivanov");
        userTwo.setPassword("Ivanov");
        userTwo.setBloodDonator(bloodDonatorTwo);
        bloodDonatorTwo.setUser(userTwo);
        testEntityManager.persistAndFlush(userTwo);


        BloodDonator bloodDonatorThree = new BloodDonator();
        bloodDonatorThree.setFirstName("Добри");
        bloodDonatorThree.setLastName("Петков");
        bloodDonatorThree.setActiveBloodDonator(false);
        bloodDonatorThree.setRhPositive(false);
        bloodDonatorThree.setAge(23);
        Address addressThree = new Address();
        addressThree.setRegion("Видин");
        addressThree.setCity("Видин");
        addressThree.setStreet("Цар Иван Срацимир 96");
        testEntityManager.persistAndFlush(bloodDonatorThree);
        bloodDonatorThree.setAddress(addressThree);
        addressThree.setBloodDonator(bloodDonatorThree);
        testEntityManager.persistAndFlush(addressThree);
        User userThree = new User();
        userThree.setUsername("Petkov");
        userThree.setPassword("Petkov");
        userThree.setBloodDonator(bloodDonatorThree);
        bloodDonatorThree.setUser(userThree);
        testEntityManager.persistAndFlush(userThree);

        BloodDonator bloodDonatorFour = new BloodDonator();
        bloodDonatorFour.setFirstName("Нора");
        bloodDonatorFour.setLastName("Стоянова");
        bloodDonatorFour.setActiveBloodDonator(false);
        bloodDonatorFour.setRhPositive(true);
        bloodDonatorFour.setAge(20);
        Address addressFour = new Address();
        addressFour.setRegion("Сливен");
        addressFour.setCity("Сливен");
        addressFour.setStreet("Хаджи Димитър 37");
        testEntityManager.persistAndFlush(bloodDonatorFour);
        bloodDonatorFour.setAddress(addressFour);
        addressFour.setBloodDonator(bloodDonatorFour);
        testEntityManager.persistAndFlush(addressFour);
        User userFour = new User();
        userFour.setUsername("Stoyanova");
        userFour.setPassword("Stoyanova");
        userFour.setBloodDonator(bloodDonatorFour);
        bloodDonatorFour.setUser(userFour);
        testEntityManager.persistAndFlush(userFour);


        BloodDonator bloodDonatorFive = new BloodDonator();
        bloodDonatorFive.setFirstName("Елена");
        bloodDonatorFive.setLastName("Георгиева");
        bloodDonatorFive.setActiveBloodDonator(false);
        bloodDonatorFive.setRhPositive(true);
        bloodDonatorFive.setAge(39);
        Address addressFive = new Address();
        addressFive.setRegion("Плевен");
        addressFive.setCity("Плевен");
        addressFive.setStreet("ген. Тотлебен 77");
        testEntityManager.persistAndFlush(bloodDonatorFive);
        bloodDonatorFive.setAddress(addressFive);
        addressFive.setBloodDonator(bloodDonatorFive);
        testEntityManager.persistAndFlush(addressFive);
        User userFive = new User();
        userFive.setUsername("Georgieva");
        userFive.setPassword("Georgieva");
        userFive.setBloodDonator(bloodDonatorFive);
        bloodDonatorFive.setUser(userFive);
        testEntityManager.persistAndFlush(userFive);

        BloodDonator bloodDonatorSix = new BloodDonator();
        bloodDonatorSix.setFirstName("Иван");
        bloodDonatorSix.setLastName("Петров");
        bloodDonatorSix.setActiveBloodDonator(false);
        bloodDonatorSix.setRhPositive(true);
        bloodDonatorSix.setAge(21);
        Address addressSix = new Address();
        addressSix.setRegion("Благоевград");
        addressSix.setCity("Благоевград");
        addressSix.setStreet("цар Самуил 97");
        testEntityManager.persistAndFlush(bloodDonatorSix);
        bloodDonatorSix.setAddress(addressSix);
        addressSix.setBloodDonator(bloodDonatorSix);
        testEntityManager.persistAndFlush(addressSix);
        User userSix = new User();
        userSix.setUsername("Petrov");
        userSix.setPassword("Petrov");
        userSix.setBloodDonator(bloodDonatorSix);
        bloodDonatorSix.setUser(userSix);
        testEntityManager.persistAndFlush(userSix);
    }

    @Test
    public void testFindByFirstName() {
        this.createBloodDonators(this.testEntityManager);
        List<BloodDonator> bloodDonators = this.bloodDonatorRepository.findByFirstName("Нора");
        String firstName = bloodDonators.get(0).getFirstName();

        assertEquals("Нора", firstName);
    }

    @Test
    public void testFindByCityStartWith() {
        this.createBloodDonators(this.testEntityManager);
        List<BloodDonator> bloodDonators = this.bloodDonatorRepository.findByCityStartWith("С");
        char firstCharOne = bloodDonators.get(0).getAddress().getCity().charAt(0);
        char firstCharTwo = bloodDonators.get(1).getAddress().getCity().charAt(0);

        assertEquals("С,С", firstCharOne + "," + firstCharTwo);
    }

    @Test
    public void testFindByUsername() {
        this.createBloodDonators(this.testEntityManager);
        BloodDonator bloodDonator = this.bloodDonatorRepository.findByUsername("Stoyanova");
        String username = bloodDonator.getUser().getUsername();
        assertEquals("Stoyanova", username);
    }

    @Test
    public void testEditBloodDonator() {
        this.createBloodDonators(this.testEntityManager);
        BloodDonator bloodDonator = this.bloodDonatorRepository.findById(3);
        Address address = bloodDonator.getAddress();
        address.setRegion("Пловдив");
        address.setCity("Пловдив");
        address.setStreet("Съединение 85");

        this.testEntityManager.detach(bloodDonator);

        this.bloodDonatorRepository.editBloodDonatorById("Данаил", "Николаев", 28, true, address, 3);
        List<BloodDonator> bloodDonators = this.bloodDonatorRepository.findByFirstName("Данаил");
        String firstName = bloodDonators.get(0).getFirstName();

        assertEquals("Данаил", firstName);
    }
}
