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
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
        pokemonTrainer = new PokemonTrainer("Kilian", Team.VALOR, pokedex);
    }

    @Test
    public void createPokemonTrainer(){
        PokemonTrainer trainer = new PokemonTrainer("Kilian",Team.VALOR,pokedex);
        Assert.assertEquals(trainer.getName(),pokemonTrainer.getName());
        Assert.assertEquals(trainer.getTeam(),pokemonTrainer.getTeam());
        Assert.assertEquals(trainer.getPokedex(),pokemonTrainer.getPokedex());
    }


}
