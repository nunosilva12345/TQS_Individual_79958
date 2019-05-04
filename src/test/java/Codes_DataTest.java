/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.airhacks.individual.tqs.Codes;
import com.airhacks.individual.tqs.GetData;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

/**
 *
 * @author nunos
 */
public class Codes_DataTest {
    
    public Codes_DataTest() {
    }
    
    GetData data = new GetData();
    Codes code = new Codes();
    
    @BeforeClass
    public static void setUpClass() throws IOException { 
    }
    
    //verificar se que recebe o codigo respetiva à cidade de aveiro e substituir na url, ficaria com o resultado esperado
    @Test
    public void checkUrlTest() throws IOException {
        data.setCity_Code("1010500");
        data.sendLiveRequest();  
        String testUrl = "http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/1010500.json";
        System.out.println(data.getUrl());
        assertEquals(data.getUrl(),testUrl);
    }
    
    /*
    //verificar se a resposta recebida tem o tamanho maior que diferente de 0 (ou seja, ter recebido algo)     
   @Test
    public void checkSize_JsonResponseTest() throws IOException {
        int sizeAnswer = data.GetJsonResponse().length(); 
         assertTrue( sizeAnswer > 0);      
    }
    */

    //verificar se os elementos de meteorologia que foram guardados na lista que no futuro irao servir para mostrar ao utlizador
    //verificar se nenhum elemento das lista é vazio, ou seja, se consegui ir buscar os dados corretamente
    @Test
    public void NullTest(){
        
        for(Integer item: data.get_weatherTtype()){
            assertTrue(null != item);
            assertNotNull("Elemento da lista é null" + item);
        };
        
        for(Integer item: data.get_windSpeed()){
            assertTrue(null != item);
            assertNotNull("Elemento da lista é null" + item);
        };
        
        for(String item: data.get_tMax()){
            assertTrue(null != item);
            assertNotNull("Elemento da lista é null" + item);
        };
        
        for(String item: data.get_prob_prec()){
            assertTrue(null != item);
            assertNotNull("Elemento da lista é null" + item);
        };
        
        for(String item: data.get_wind_Direction()){
            assertTrue(null != item);
            assertNotNull("Elemento da lista é null" + item);
        };
        
        for(String item: data.get_tMin()){
            assertTrue(null != item);
            assertNotNull("Elemento da lista é null" + item);
        };
    }
      
    @Test
    public void SizeTest(){
        assertEquals(5,data.get_prob_prec().size(),0);
        assertEquals(5,data.get_tMin().size(),0);
        assertEquals(5,data.get_wind_Direction().size(),0);
        assertEquals(5,data.get_tMax().size(),0);
        assertEquals(5,data.get_windSpeed().size(),0);
        assertEquals(5,data.get_weatherTtype().size(),0);
    }
    
    //verificar se o metodo de ver a "velocidade" do vento resulta eficazmente
    @Test
    public void WindSpeedTest(){
        assertEquals("Fraco",code.idWindSpeed(1));
        assertEquals("--",code.idWindSpeed(99));
    }
    
    //verificar se o metodo de ver o tempo resulta eficazmente
    @Test
    public void idWeatherTypeTest(){
        assertEquals("Sem informações",Codes.idWeatherType(0));
        assertEquals("Céu limpo",Codes.idWeatherType(1));
        assertEquals("--",Codes.idWeatherType(-99));
    }
    
    //verificar se que fornecer a cidade, o metodo ira retornar bem o int id da cidade, correspondente necessario para realizar a pesquisa
    @Test
    public void CityCodeTest(){
        assertEquals(1010500,Codes.returnCityCode("Aveiro"));
        assertEquals(1020500,Codes.returnCityCode("Beja"));
        assertEquals(0,Codes.returnCityCode("Cidade nao existente"));
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}