package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;
    Pokemon bulbizarre;
    Pokemon aquali;

    @Before
    public void init() throws PokedexException {
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
        when(pokemonFactory.createPokemon(-1,613,64,4000,4)).thenThrow(new PokedexException("L'index du pokémon n'existe pas"));
    }

    @Test
    public void exceptionMetadataTest(){
        Assert.assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(-1,613,64,4000,4));
    }

    @Test
    public void createBulbizarre() throws PokedexException {
        when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(bulbizarre);
        Assert.assertEquals(pokemonFactory.createPokemon(0,613,64,4000,4),bulbizarre);
    }

    @Test
    public void createAquali() throws PokedexException {
        when(pokemonFactory.createPokemon(133,2729,202,5000,4)).thenReturn(aquali);
        Assert.assertEquals(pokemonFactory.createPokemon(133,2729,202,5000,4),aquali);
    }

}
