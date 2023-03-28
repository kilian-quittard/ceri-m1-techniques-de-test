package fr.univavignon.pokedex.api;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return new PokedexFactory().createPokedex(this,new PokemonFactory()).getPokemonMetadata(index);
    }
}
