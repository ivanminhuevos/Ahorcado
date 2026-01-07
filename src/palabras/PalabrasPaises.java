package palabras;

import java.util.Random;

public class PalabrasPaises extends CategoriaDePalabras {
    // de https://github.com/hug0lop23z/Ahorcado_paises/blob/main/Ahorcado.java
    private static final String[] palabrasPaises = {
            "Afganistan", "Albania", "Alemania", "Andorra", "Angola", "Argelia", "Argentina", "Armenia", "Australia",
            "Austria", "Azerbaiyan", "Bahamas", "Banglades", "Barbados", "Barein", "Belgica", "Belice", "Benin",
            "Bielorrusia", "Birmania", "Bolivia", "Botsuana", "Brasil", "Brunei", "Bulgaria", "Burundi", "Butan",
            "Camboya", "Camerun", "Canada", "Catar", "Chad", "Chile", "China", "Chipre", "Colombia", "Comoras",
            "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "Eritrea", "Eslovaquia", "Eslovenia",
            "Espana", "Estonia", "Etiopia", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabon", "Gambia", "Georgia",
            "Ghana", "Granada", "Grecia", "Guatemala", "Guyana", "Guinea", "Haiti", "Honduras", "Hungria", "India",
            "Indonesia", "Irak", "Iran", "Irlanda", "Islandia", "Israel", "Italia", "Jamaica", "Japon", "Jordania",
            "Kazajistan", "Kenia", "Kirguistan", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "Libano", "Liberia",
            "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Madagascar", "Malasia", "Malaui", "Maldivas", "Mali",
            "Malta", "Marruecos", "Mauricio", "Mauritania", "Mexico", "Micronesia", "Moldavia", "Monaco", "Mongolia",
            "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "Niger", "Nigeria", "Noruega", "Oman",
            "Pakistan", "Palaos", "Panama", "Paraguay", "Peru", "Polonia", "Portugal", "Ruanda", "Rumania", "Rusia",
            "Samoa", "Senegal", "Serbia", "Seychelles", "Singapur", "Siria", "Somalia", "Suazilandia", "Sudafrica",
            "Sudan", "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikistan", "Togo", "Tonga", "Tunez",
            "Turkmenistan", "Turquia", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela",
            "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue"
    };

    private static final Random rnd = new Random();
    public String obtenerPalabraAleatoria() {
        return palabrasPaises[rnd.nextInt(palabrasPaises.length)];
    };
}
