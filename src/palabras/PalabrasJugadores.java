package palabras;

import java.util.Random;

public class PalabrasJugadores extends CategoriaDePalabras {
    // de https://github.com/campayoo/AhorcadoJugadores/blob/main/Palabras.java
    private static final String[] palabrasJugadores = {
            "PELE", "MARADONA", "MESSI", "CRISTIANO", "ZIDANE",
            "RONALDO", "RONALDINHO", "CRUYFF", "BECKENBAUER", "PLATINI",
            "GARRINCHA", "MALDINI", "XAVI", "INIESTA", "PUSKAS",
            "ROMARIO", "RIVALDO", "KAKA", "FIGO", "BATISTUTA",
            "BAGGIO", "VANBASTEN", "RIJKAARD", "GULLIT", "SHEVCHENKO",
            "HENRY", "MBAPPE", "HAALAND", "LEWANDOWSKI", "SUAREZ",
            "NEYMAR", "MODRIC", "KROOS", "CASEMIRO", "RAMOS",
            "BUFFON", "CASILLAS", "NEUER", "YASHIN", "SCHMEICHEL",
            "KAHN", "PIRLO", "SEEDORF", "ZICO", "SOCRATES",
            "RONALDOZ", "KEMPES", "DIDI", "CAFÚ", "CARLOS",
            "ALVES", "PUYOL", "VIDIC", "NESTA", "CANNAVARO",
            "LAUDRUP", "BERGKAMP", "STOICHKOV", "HAGI", "RAUL",
            "DELPIERO", "TOTTI", "GERRARD", "LAMPARD", "SCHOLES",
            "BEST", "CHARLTON", "MAGUIRE", "MATTHAUS", "NAVAS"
    };

    private static final Random rnd = new Random();
    public String obtenerPalabraAleatoria() {
        return palabrasJugadores[rnd.nextInt(palabrasJugadores.length)];
    };
}
