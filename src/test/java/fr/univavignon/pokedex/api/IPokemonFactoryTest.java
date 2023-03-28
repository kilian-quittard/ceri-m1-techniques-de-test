package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;

    @Before
    public void init() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void exceptionMetadataTest(){
        Assert.assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(-1,613,64,4000,4));
    }

    @Test
    public void createBulbizarre() throws PokedexException {
        Pokemon bulbizarre = pokemonFactory.createPokemon(0,613,64,4000,4);

        Assert.assertEquals(0,bulbizarre.getIndex());
        Assert.assertEquals(613,bulbizarre.getCp());
        Assert.assertEquals(64,bulbizarre.getHp());
        Assert.assertEquals(4000,bulbizarre.getDust());
        Assert.assertEquals(4,bulbizarre.getCandy());

        int high = 100;
        int low = 0;
        Assert.assertEquals((high + low) / 2.0, bulbizarre.getIv(), (high - low) / 2.0);

    }

    @Test
    public void createAquali() throws PokedexException {
        Pokemon aquali = pokemonFactory.createPokemon(133,2729,202,5000,4);

        Assert.assertEquals(133,aquali.getIndex());
        Assert.assertEquals(2729,aquali.getCp());
        Assert.assertEquals(202,aquali.getHp());
        Assert.assertEquals(5000,aquali.getDust());
        Assert.assertEquals(4,aquali.getCandy());

        int high = 100;
        int low = 0;
        Assert.assertEquals((high + low) / 2.0, aquali.getIv(), (high - low) / 2.0);

    }

}
