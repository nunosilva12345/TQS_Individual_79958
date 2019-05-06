/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nunos
 */
import com.airhacks.individual.tqs.Codes;
import com.airhacks.individual.tqs.GetData;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author nunos
 */
//@RunWith(EasyMockRunner.class)

/*
@RunWith(MockitoJUnitRunner.class)


    /*
        Assertions.assertTrue(code.returnCityCode("Aveiro") == expected);
        EasyMock.verify(code);
        
        Assertions.assertEquals(expected, code.getTempo());
        */
        
        /*
        String expected = "Fraco";
        EasyMock.expect(Codes.idWindSpeed(1).matches(expected));
        EasyMock.replay(code);

        Assertions.assertEquals(expected, code.getTempo());
        */
/*
public class MockIT{

    //@Mock
    private Codes code;

    //@TestSubject
    //private GetData data = new GetData();

    //@BeforeEach
    //public void setUp() throws Exception {
        //data.setCity_Code("1010500");
        //data.sendLiveRequest();  
    //}
    //fazer o metodo setCity_code, ver se mudar o numero de aveiro
    //retornar a string aveiro

    //metodo getUrl, se ao dar o numero certo, url certa
    //json response
    @Test
    public void cityTest() {

        int expected = 1010500;
        //Mockito.when(Codes.returnCityCode("Aveiro")).thenReturn(expected);
        int x = Codes.returnCityCode("Aveiro");
        String city_expected = "Aveiro";
        String real_city = code.getCidade();
        Assertions.assertEquals(city_expected, real_city);
        Assertions.assertEquals(expected, x, 0);

    }
    
    @Test
    public void weatherTest() {

        String nada_expected = "Sem informações";
        String limpo = "Céu Limpo";
        String weather_nada = Codes.idWeatherType(0);
        String weather_limpo = Codes.idWeatherType(1);
        String weather = code.getTempo();
        Assertions.assertEquals(nada_expected, weather_nada);
        Assertions.assertEquals(weather_limpo, limpo);
        Assertions.assertEquals(weather_nada, weather);

    }
    
    @Test
    public void windTest() {

        String nada_expected = "--";
        String fraco = "Fraco";
        String weather_nada = Codes.idWindSpeed(99);
        String weather_fraco = Codes.idWindSpeed(1);
        String weather = code.getVento();
        Assertions.assertEquals(nada_expected, weather_nada);
        Assertions.assertEquals(weather_fraco, fraco);
        Assertions.assertEquals(weather_nada, weather);

    }
    
    
        
        /*
        ---------------------------------------------------------------------------------
        
        Stock ebayStock = new Stock("EBAY", 2);
        portfolio.addStock(ebayStock);

        Assertions.assertEquals(84.00, portfolio.getTotalValue(), 0.001);
        EasyMock.verify(market);
        */

//}
