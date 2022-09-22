package by.it_academy.jd2.servlet_with_cookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApacheCommonsLang3CheckerTest {

    @Test
    public void allLowerCase(){
        ApacheCommonsLang3Checker checker = new ApacheCommonsLang3Checker();

        boolean result = checker.isAllLowerCase("ilya");

        Assertions.assertEquals(true,result);
    }

    @Test
    public void notAllLowerCase(){
        ApacheCommonsLang3Checker checker = new ApacheCommonsLang3Checker();

        boolean result = checker.isAllLowerCase("Ilya");

        Assertions.assertEquals(false,result);
    }
}
