package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory pokemonTrainerFactory;
    IPokedexFactory pokedexFactory;
    IPokedex pokedex;

    PokemonTrainer pokemonTrainer;

    @Before
    public void init(){
        pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
        pokemonTrainer = new PokemonTrainer("Kilian", Team.VALOR, pokedex);
    }

    @Test
    public void createPokemonTrainer(){
        when(pokemonTrainerFactory.createTrainer("Kilian",Team.VALOR,pokedexFactory)).thenReturn(pokemonTrainer);
        Assert.assertEquals("Kilian",pokemonTrainer.getName());
        Assert.assertEquals(Team.VALOR,pokemonTrainer.getTeam());
        Assert.assertEquals(pokedex,pokemonTrainer.getPokedex());
    }


}
