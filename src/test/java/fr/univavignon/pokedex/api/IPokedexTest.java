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
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;

    @Before
    public void init(){
        pokedex = new PokedexFactory().createPokedex(new PokemonMetadataProvider(),new PokemonFactory());
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void exceptionPokedexTest(){
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(12));
    }

    @Test
    public void shouldReturn1WhenGetSize(){
        pokedex.addPokemon(bulbizarre);
        Assert.assertEquals(pokedex.size(),1);
    }

    @Test
    public void shouldReturn0WhenBulbizarreIsAdded(){
        Assert.assertEquals(pokedex.addPokemon(bulbizarre),bulbizarre.getIndex());
    }

    @Test
    public void shouldReturn133WhenAqualiIsAdded(){
        Assert.assertEquals(pokedex.addPokemon(aquali),aquali.getIndex());
    }

    @Test
    public void shouldReturnBulbizarreWhenGetPokemonIndexIsO() throws PokedexException {
        pokedex.addPokemon(bulbizarre);
        Assert.assertEquals(pokedex.getPokemon(0),bulbizarre);
        Assert.assertEquals(pokedex.getPokemon(0).getIndex(),0);
        Assert.assertEquals(pokedex.getPokemon(0).getName(), "Bulbizarre");
    }

    @Test
    public void shouldReturnAqualiWhenGetPokemonIndexIs133() throws PokedexException {
        pokedex.addPokemon(aquali);
        Assert.assertEquals(pokedex.getPokemon(133),aquali);
        Assert.assertEquals(pokedex.getPokemon(133).getIndex(),133);
        Assert.assertEquals(pokedex.getPokemon(133).getName(), "Aquali");
    }

    @Test
    public void shouldReturnPokemonsWhenPokemonListIsGiven(){
        List pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);

        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);
        Assert.assertEquals(pokedex.getPokemons(),pokemons);
    }

    @Test
    public void shouldReturnPokemonsOrderedWhenPokemonListIsGiven(){
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);
        List test = Arrays.asList(aquali,bulbizarre);
        Assert.assertEquals(pokedex.getPokemons(PokemonComparators.NAME),test);
    }

    @Test
    public void shouldReturnPBulbizarre() throws PokedexException {
        Pokemon pokemon = pokedex.createPokemon(0,613,64,4000,4);
        Assert.assertEquals(pokemon.getIndex(),bulbizarre.getIndex());
        Assert.assertEquals(pokemon.getCp(),bulbizarre.getCp());
        Assert.assertEquals(pokemon.getHp(),bulbizarre.getHp());
        Assert.assertEquals(pokemon.getDust(),bulbizarre.getDust());
        Assert.assertEquals(pokemon.getCandy(),bulbizarre.getCandy());
    }

    @Test
    public void shouldReturnPBulbizarreMetadata() throws PokedexException {
        PokemonMetadata pokemonMetadata = pokedex.getPokemonMetadata(0);
        Assert.assertEquals(pokemonMetadata.getIndex(),bulbizarre.getIndex());
        Assert.assertEquals(pokemonMetadata.getName(),bulbizarre.getName());
        Assert.assertEquals(pokemonMetadata.getAttack(),bulbizarre.getAttack());
        Assert.assertEquals(pokemonMetadata.getDefense(),bulbizarre.getDefense());
        Assert.assertEquals(pokemonMetadata.getStamina(),bulbizarre.getStamina());
    }
}
