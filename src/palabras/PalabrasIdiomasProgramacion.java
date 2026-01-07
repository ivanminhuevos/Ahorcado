package palabras;

import java.util.Random;

public class PalabrasIdiomasProgramacion extends CategoriaDePalabras {
    private static final String[] palabrasIdiomas = {
        "C", "C++", "C#", "Java", "JavaScript", "Python", "Lua", "Rust", "Perl", "PHP", "Julia", "Fortran", "COBOL",
        "Kotlin", "Groovy", "Haxe", "Dart", "TypeScript", "Pascal", "Ruby", "SQL", "Swift", "Visual Basic",
    };

    private static final Random rnd = new Random();
    public String obtenerPalabraAleatoria() {
        return palabrasIdiomas[rnd.nextInt(palabrasIdiomas.length)];
    };
}
