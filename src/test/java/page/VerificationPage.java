package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class VerificationPage {

    private SelenideElement codeField;
    private SelenideElement verifyButton;

    public VerificationPage(){
        $("[data-test-id=code] input").should(appear);
        codeField = $("[data-test-id=code] input");
        verifyButton = $("[data-test-id=action-verify]");
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();

    }
}
