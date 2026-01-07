package palabras;

public class FabricaCategoriaPalabras {
    public CategoriaDePalabras obtenerCategoria(CategoriasPalabras catEnum) {
        switch(catEnum) {
            case PAISES:
                return new PalabrasPaises();
            case JUGADORES:
                return new PalabrasJugadores();
            case IDIOMAS_PROGRAMACION:
                return new PalabrasIdiomasProgramacion();
            default:
                return null;
        }
    }

    public String obtenerPalabra(CategoriasPalabras catEnum) {
        CategoriaDePalabras cat = obtenerCategoria(catEnum);

        return cat.obtenerPalabraAleatoria();
    }
}
