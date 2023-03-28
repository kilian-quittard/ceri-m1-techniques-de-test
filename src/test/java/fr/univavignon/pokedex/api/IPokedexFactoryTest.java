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
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void createPokedex(){
        IPokedex poke = pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory);
        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).size(),poke.size());
        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).getPokemons(),poke.getPokemons());
    }

}

