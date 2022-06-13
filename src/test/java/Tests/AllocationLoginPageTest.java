package Tests;

import Pages.AllocationLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllocationLoginPageTest extends BaseTest {



    @Test(priority= 1)
    public  void verifyStatusPod() throws InterruptedException {
        log.info("logged into The Application");
        page.getInstance(AllocationLoginPage.class).doLogin();
       log.info("Verifying the Status of Pod");
       String status= page.getInstance(AllocationLoginPage.class).getStatusOfPod();
       log.info("Asserting the Status of the Pod");
       System.out.println("Status of Pod is:" +status);
       Assert.assertEquals(status,"ALLOCATION READY");

    }
    @Test(priority= 2)
    public void verifyNominateHaSher() {
        page.getInstance(AllocationLoginPage.class).doLogin();
        String Status = page.getInstance(AllocationLoginPage.class).NominateHaSher();
        System.out.println("Status After Nominating is:"+""+Status);
        Assert.assertEquals(Status,"IN PROGRESS");

    }
    @Test(priority= 3)
    public void verifyFilterOption() throws InterruptedException {
        page.getInstance(AllocationLoginPage.class).doLogin();
       String Skill= page.getInstance(AllocationLoginPage.class).FilterOptionSkill();
       String WebPageSkill = page.getInstance(AllocationLoginPage.class).WebPageSkill();
       System.out.println("Skill in Filter:"+Skill);
       System.out.println("Skill in Webpage:"+WebPageSkill);
       Assert.assertEquals(Skill,WebPageSkill);



    }

    @Test(priority= 4)
    public void VerifyAddingHasSher() {
        page.getInstance(AllocationLoginPage.class).doLogin();
        page.getInstance(AllocationLoginPage.class).AddingHaSher();


    }
    @Test
    public void verifyStatusAfterSaveConfiguration() throws InterruptedException {
        page.getInstance(AllocationLoginPage.class).doLogin();
       String status= page.getInstance(AllocationLoginPage.class).ClickOnUpcomingPod();
       System.out.println("status after configuring the POD :"+status);
       Assert.assertEquals(status,"UPCOMING");


    }


}
