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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    static Feline feline;

    private String sex;
    private String expected;

    public LionTest (Feline feline, String sex, String expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][] {
            { feline, "Самец", "true"},
            { feline, "Самка", "false"},
        };
    }

    @Test
    public void doesHaveMane () throws Exception {
            Lion lion = new Lion(feline, sex);
            String actual = String.valueOf(lion.doesHaveMane());
            assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void doesHaveManeExeption () throws Exception {
        Lion lion = new Lion(feline, "Оно");
    }

    @Test
    public void getFood() throws Exception {
        when(feline.eatMeat()).thenReturn(Collections.singletonList("Лев хищник"));
        Lion lion = new Lion(feline, sex);
        String actual = "[Лев хищник]";
        assertThat(actual, equalTo(String.valueOf(lion.getFood())));
    }

    @Test
    public void getKittens () throws Exception {
        Lion lion = new Lion(feline, sex);
        when(feline.getKittens()).thenReturn(5);
        int actual = 5;
        assertThat(actual, equalTo(lion.getKittens()));
    }
}
