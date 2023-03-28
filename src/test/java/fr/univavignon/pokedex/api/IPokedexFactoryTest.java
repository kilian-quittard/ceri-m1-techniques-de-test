package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;

    @Before
    public void init(){
        pokedexFactory = new PokedexFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void createPokedex(){
        IPokedex poke = new Pokedex() {
            @Override
            public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
                return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
            }
            @Override
            public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                return pokemonMetadataProvider.getPokemonMetadata(index);
            }
        };

        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).size(),poke.size());
        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).getPokemons(),poke.getPokemons());
    }

}

