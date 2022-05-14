import com.example.Feline;
import com.example.Lion;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Feline feline;

    private String sex;
    private String expected;

    public LionTest (String sex, String expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][] {
            { "Самец", "true"},
            { "Самка", "false"},
        };
    }

    @Test
    public void doesHaveMane () throws Exception {
            Lion lion = new Lion(sex);
            String actual = String.valueOf(lion.doesHaveMane());
            assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void doesHaveManeExeption () throws Exception {
        Lion lion = new Lion("Оно");
    }


    @Test
    public void getFood() throws Exception {
        when(feline.eatMeat()).thenReturn(Collections.singletonList("Лев хищник"));
        Lion lion = new Lion(feline);
        System.out.println(lion.getFood());
    }

    @Test
    public void getKittens () {
        Lion lion = new Lion(feline);
        when(feline.getKittens()).thenReturn(5);
        System.out.println(lion.getKittens());
    }
}
