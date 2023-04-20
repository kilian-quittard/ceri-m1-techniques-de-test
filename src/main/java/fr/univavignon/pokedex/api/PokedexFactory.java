package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {
    /**
     * Creates a new pokedex instance using the given
     * <code>metadataProvider</code> and <code>pokemonFactory</code>.
     * @param metadataProvider Metadata the pokedex will use.
     * @param pokemonFactory factory the pokedex will use.
     * @return Created pokedex instance.
     */
    @Override
    public IPokedex createPokedex(final IPokemonMetadataProvider metadataProvider, final IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }

}