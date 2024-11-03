package test;

import data.DataHelper;
import data.SQLHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static data.SQLHelper.cleanDatabase;

public class BankLoginTest {
    @AfterAll
    static void clearUpData() {
        cleanDatabase();
    }

    @Test
    void shouldSuccessfulLogin() {
        open("http://localhost:9999", LoginPage.class);
        LoginPage loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfowithTestData();
        loginPage.login(authInfo);
        VerificationPage verificationPage = new VerificationPage();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.verify(verificationCode.getCode());
    }
}
