package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class IPokedexTest {

    IPokedex pokedex;
    Pokemon bulbizarre;
    Pokemon aquali;

    @Before
    public void init(){
        pokedex = Mockito.mock(IPokedex.class);
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    }

    @Test
    public void exceptionMetadataTest(){
    }

    @Test
    public void shouldReturn1WhenGetSize(){
        when(pokedex.size()).thenReturn(1);
        Assert.assertEquals(pokedex.size(),1);
    }

    @Test
    public void shouldReturn0WhenBulbizarreIsAdded(){
        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        Assert.assertEquals(pokedex.addPokemon(bulbizarre),bulbizarre.getIndex());
    }

    @Test
    public void shouldReturn133WhenAqualiIsAdded(){
        when(pokedex.addPokemon(aquali)).thenReturn(133);
        Assert.assertEquals(pokedex.addPokemon(aquali),aquali.getIndex());
    }

    @Test
    public void shouldReturnBulbizarreWhenGetPokemonIndexIsO() throws PokedexException {
        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        Assert.assertEquals(pokedex.getPokemon(0),bulbizarre);
    }

    @Test
    public void shouldReturnAqualiWhenGetPokemonIndexIs133() throws PokedexException {
        when(pokedex.getPokemon(133)).thenReturn(aquali);
        Assert.assertEquals(pokedex.getPokemon(133),aquali);
    }

    @Test
    public void shouldReturnPokemonsWhenPokemonListIsGiven(){
        List pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);

        when(pokedex.getPokemons()).thenReturn(pokemons);
        Assert.assertEquals(pokedex.getPokemons(),pokemons);
    }

    @Test
    public void shouldReturnPokemonsOrderedWhenPokemonListIsGiven(){
        List res = Arrays.asList(aquali,bulbizarre);

        when(pokedex.getPokemons(PokemonComparators.NAME)).thenReturn(res);
        Assert.assertEquals(pokedex.getPokemons(PokemonComparators.NAME),res);
    }
}
