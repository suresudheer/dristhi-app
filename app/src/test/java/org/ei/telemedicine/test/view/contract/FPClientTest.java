package org.ei.telemedicine.test.view.contract;

import org.ei.telemedicine.view.contract.AlertDTO;
import org.ei.telemedicine.view.contract.FPClient;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

//@RunWith(MockitoJUnitRunner.class)
public class FPClientTest {

    FPClient fpClient;

    @Before
    public void setUp() throws Exception {
        fpClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
    }

    @Test
    public void testShouldReturnTheReferralFollowUpAlert() throws Exception {

        fpClient.withAlerts(Arrays.asList(new AlertDTO("Male Sterilization Followup", "normal", "2013-02-02")

        )).withFPMethod("female_sterilization");

        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("Male Sterilization Followup", "normal", "2013-02-02")
               ))
                .withFPMethod("female_sterilization");
                //.withRefillFollowUps(new RefillFollowUps("FP Referral Followup", new AlertDTO("FP Referral Followup", "normal", "2013-02-02"), "referral"));

        assertEquals(expectedFPClient, fpClient);
    }

    @Test
    public void testShouldSetFPFollowupDataIfAFPFollowupExistsAndReferralAlertDoesNotExist() throws Exception {
        fpClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                ))
                .withFPMethod("female_sterilization");

        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                ))
                .withFPMethod("female_sterilization");
                //.withRefillFollowUps(new RefillFollowUps("FP Followup", new AlertDTO("FP Followup", "normal", "2013-02-02"), "follow-up"));

        assertEquals(expectedFPClient, fpClient);
    }

    @Test
    public void testShouldSetFemaleSterilizationFollowUpDataWhenAFemaleSterilizationAlertExitsAndReferralDataAndFPFollowUpIsNotSpecified() throws Exception {
        fpClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                ))
                .withFPMethod("female_sterilization");

        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                ))
                .withFPMethod("female_sterilization");
                //.withRefillFollowUps(new RefillFollowUps("Female sterilization Followup 1", new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02"), "follow-up"));

        assertEquals(expectedFPClient, fpClient);
    }

    @Test
    public void testShouldOnlySetFemaleSterilizationFollowUpDataWhenFPMethodIsAlsoFemaleSterilization() throws Exception {
        fpClient.withAlerts(Arrays.asList(new AlertDTO("Male Sterilization Followup", "urgent", "2013-02-02")
        ))
                .withFPMethod("female_sterilization");
                //.withRefillFollowUps(new RefillFollowUps("Female sterilization Followup 1", new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02"), "follow-up"));


        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("Male Sterilization Followup", "urgent", "2013-02-02")
                ))
                .withFPMethod("female_sterilization");
                //.withRefillFollowUps(new RefillFollowUps("Female sterilization Followup 1", new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02"), "follow-up"));

        assertEquals(expectedFPClient, fpClient);
    }

    @Test
    public void testShouldSetCondomRefillDataOnlyIfFPMethodIsAlsoCondom() throws Exception {
        fpClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                ))
                .withFPMethod("condom");

        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("OCP Refill", "urgent", "2013-02-02")
                ))
                .withFPMethod("condom");
                //.withRefillFollowUps(new RefillFollowUps("Condom Refill", new AlertDTO("Condom Refill", "urgent", "2013-02-02"), "refill"));

        assertEquals(expectedFPClient, fpClient);
    }

    @Test
    public void testShouldSetCondomRefillDataOverSterilisationDataIfFPMethodIsCondomAndNotAnyOfSterilizationMethods() throws Exception {
        fpClient.withAlerts(Arrays.asList(new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02")
                ))
                .withFPMethod("condom");

        fpClient.setRefillFollowUp();

        FPClient expectedFPClient = new FPClient("entity id 1", "woman name", "husband name", "village name", "ec no 1");
        expectedFPClient.withAlerts(Arrays.asList(new AlertDTO("Female sterilization Followup 1", "urgent", "2013-02-02")
                ))
                .withFPMethod("condom");
                //.withRefillFollowUps(new RefillFollowUps("Condom Refill", new AlertDTO("Condom Refill", "urgent", "2013-02-02"), "refill"));

        assertEquals(expectedFPClient, fpClient);
    }
}