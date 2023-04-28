package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /**
     * The list which contains all pokemon metadata.
     */
    private List<PokemonMetadata> pokemonMetadataList;

    /**
     * Default constructor.
     */
    public PokemonMetadataProvider() {
        this.pokemonMetadataList = new ArrayList<>();
        pokemonMetadataList.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonMetadataList.add(new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <code>index</code>.
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If given <code>index</code> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        for (PokemonMetadata metadata : pokemonMetadataList) {
            if (metadata.getIndex() == index) {
                return metadata;
            }
        }
        throw new PokedexException("L'index du pokémon n'existe pas");
    }
}
