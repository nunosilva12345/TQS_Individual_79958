package com.airhacks.individual.tqs;


/**
 *
 * @author nunos
 */
public class Codes {

    private static String cidade;
    private static String tempo = "";
    private static String vento = "";

    public Codes() {
    }
    
    public String getCidade(){
        return cidade;
    }
    
    public String getTempo(){
        return tempo;
    }
    
    public String getVento(){
        return vento;
    }
    
    public static String idWindSpeed(int x) {
        switch (x) {
            case 99:
                vento ="--";
                break;
            case 1:
                vento = "Fraco";
                break;
            case 2:
                vento = "Moderado";
                break;
            case 3:
                vento = "Forte";
                break;
            case 4:
                vento = "Muito Forte";
                break;
            default:
                vento = "--";
                break;
        }
        return vento;
    }

    
    public static String idWeatherType(int x) {
        switch (x) {
            case 0:
                tempo = "Sem informações";
                break;
            case 1:
                tempo = "Céu limpo";
                break;
            case 2:
                tempo = "Pouco nublado";
                break;
            case 3:
                tempo = "Parcialmente Neblado";
                break;
            case 4:
                tempo = "Muito nublado/encoberto";
                break;
            case 5:
                tempo = "Céu nublado por nuvens altas";
                break;
            case 6:
                tempo = "Sem Aguaceiros";
                break;
            case 7:
                tempo = "Aguaceiros fracos";
                break;
            case 8:
                tempo = "Aguaceiros fortes";
                break;
            case 9:
                tempo = "Chuva";
                break;
            case 10:
                tempo = "Chuva fraca/chuvisco";
                break;
            case 11:
                tempo = "Chuva forte";
                break;
            case 12:
                tempo = "Periodos de chuva";
                break;
            case 13:
                tempo = "Periodos de chuva fraca";
                break;
            case 14:
                tempo = "Periodos de chuva forte";
                break;
            case 15:
                tempo = "Chuvisco";
                break;
            case 16:
                tempo = "Neblina";
                break;
            case 17:
                tempo = "Nuvens baixas";
                break;
            case 18:
                tempo = "Neve";
                break;
            case 19:
                tempo = "Trovoada";
                break;
            case 20:
                tempo = "Aguaceiros e trovoada";
                break;
            case 21:
                tempo = "Granizo";
                break;
            case 22:
                tempo = "Geada";
                break;
            case 23:
                tempo = "Chuva e trovoada";
                break;
            case 24:
                tempo = "Nebulosidade convectiva";
                break;
            case 25:
                tempo = "Ceu com periodos de muito nublado";
                break;
            case 26:
                tempo = "Nevoeiro";
                break;
            case 27:
                tempo = "Nublado";
                break;
            case -99:
                tempo = "--";
                break;
            default:
                tempo = "--";
                break;
        }
        return tempo;
    }

    public static int returnCityCode(String y) {
        String finaleCidade = y.toUpperCase(); //para ser mais facil
        cidade = y;
        int code = 0;

        switch (finaleCidade) {
            case "AVEIRO":
                code = 1010500;
                break;
            case "BEJA":
                code = 1020500;
                break;
            case "BRAGA":
                code = 1030300;
                break;
            case "BRAGANÇA":
                code = 1040200;
                break;
            case "CASTELO BRANCO":
                code = 1050200;
                break;
            case "COIMBRA":
                code = 1060300;
                break;
            case "ÉVORA":
                code = 1070500;
                break;
            case "FARO":
                code = 1080500;
                break;
            case "GUARDA":
                code = 1090700;
                break;
            case "LEIRIA":
                code = 1100900;
                break;
            case "LISBOA":
                code = 1110600;
                break;
            case "PORTALEGRE":
                code = 1121400;
                break;         
            case "PORTO":
                code = 1131200;
                break;
            case "SANTARÉM":
                code = 1080500;
                break;
            case "SETÚBAL":
                code = 1151200;
                break;
            case "VIANA DO CASTELO":
                code = 1160900;
                break;
            case "VILA REAL":
                code = 1171400;
                break;
            case "VISEU":
                code = 1182300;
                break;           
            case "FUNCHAL":
                code = 2310300;
                break;
            case "PORTO SANTO":
                code = 2320100;
                break;
            case "VILA DO PORTO":
                code = 3410100;
                break;
            case "PONTA DELGADA":
                code = 3420300;
                break;
            case "ANGRA DO HEROÍSMO":
                code = 3430100;
                break;     
            case "SANTA CRUZ DA GRACIOSA":
                code = 3440100;
                break;
            case "MADALENA":
                code = 3450200;
                break;
            case "VELAS":
                code = 3460200;
                break;
            case "HORTA":
                code = 3470100;
                break;
            case "SANTA CRUZ DAS FLORES":
                code = 3480200;
                break;
            case "VILA DO CORVO":
                code = 3490100;
                break;
            default:
                code = 0;
                break;
        }  
        return code;
    }

}

//quero o --> globalIdLocal


//http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/1010500.json


//http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/code.json