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

    @Before
    public void init(){
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
    }

    @Test
    public void createPokemonTrainer(){
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("Kilian",Team.VALOR,new PokedexFactory());
        PokemonTrainer trainer = new PokemonTrainer("Kilian",Team.VALOR,new PokedexFactory().createPokedex(new PokemonMetadataProvider(),new PokemonFactory()));
        Assert.assertEquals(trainer.getName(),pokemonTrainer.getName());
        Assert.assertEquals(trainer.getTeam(),pokemonTrainer.getTeam());
        Assert.assertEquals(trainer.getPokedex().getPokemons(),pokemonTrainer.getPokedex().getPokemons());
    }


}
