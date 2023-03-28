package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

    private List<PokemonMetadata> pokemonMetadataList;

    public PokemonMetadataProvider() {
        this.pokemonMetadataList = new ArrayList<>();
        pokemonMetadataList.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonMetadataList.add(new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        for(PokemonMetadata metadata : pokemonMetadataList){
            if(metadata.getIndex() == index){
                return metadata;
            }
        }

        throw new PokedexException("L'index du pokémon n'existe pas");
    }
}
