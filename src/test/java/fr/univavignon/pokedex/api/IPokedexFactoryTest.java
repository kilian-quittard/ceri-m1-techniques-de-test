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
    IPokedex pokedex;

    @Before
    public void init(){
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
    }

    @Test
    public void createPokedex(){
        when(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory)).thenReturn(pokedex);
        pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory),pokedex);
    }

}

