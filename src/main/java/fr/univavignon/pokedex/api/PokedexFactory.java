package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex() {
            @Override
            public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
                return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
            }
            @Override
            public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                return metadataProvider.getPokemonMetadata(index);
            }
        };
    }

}