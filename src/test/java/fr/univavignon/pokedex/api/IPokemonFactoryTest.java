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
    public void init() {
        pokemonFactory = new PokemonFactory();
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    }

    @Test
    public void exceptionMetadataTest(){
        Assert.assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(-1,613,64,4000,4));
    }

    @Test
    public void createBulbizarre() throws PokedexException {
        Pokemon bulbizarre2 = pokemonFactory.createPokemon(0,613,64,4000,4);

        Assert.assertEquals(bulbizarre.getIndex(),bulbizarre2.getIndex());
        Assert.assertEquals(bulbizarre.getAttack(),bulbizarre2.getAttack());
        Assert.assertEquals(bulbizarre.getDefense(),bulbizarre2.getDefense());
        Assert.assertEquals(bulbizarre.getStamina(),bulbizarre2.getStamina());
        Assert.assertEquals(bulbizarre.getCp(),bulbizarre2.getCp());
        Assert.assertEquals(bulbizarre.getHp(),bulbizarre2.getHp());
        Assert.assertEquals(bulbizarre.getDust(),bulbizarre2.getDust());
        Assert.assertEquals(bulbizarre.getCandy(),bulbizarre2.getCandy());

        int high = 100;
        int low = 0;
        Assert.assertEquals((high + low) / 2.0, bulbizarre.getIv(), (high - low) / 2.0);

    }

    @Test
    public void createAquali() throws PokedexException {
        Pokemon aquali2 = pokemonFactory.createPokemon(133,2729,202,5000,4);

        Assert.assertEquals(aquali.getIndex(),aquali2.getIndex());
        Assert.assertEquals(aquali.getAttack(),aquali2.getAttack());
        Assert.assertEquals(aquali.getDefense(),aquali2.getDefense());
        Assert.assertEquals(aquali.getStamina(),aquali2.getStamina());
        Assert.assertEquals(aquali.getCp(),aquali2.getCp());
        Assert.assertEquals(aquali.getHp(),aquali2.getHp());
        Assert.assertEquals(aquali.getDust(),aquali2.getDust());
        Assert.assertEquals(aquali.getCandy(),aquali2.getCandy());

        int high = 100;
        int low = 0;
        Assert.assertEquals((high + low) / 2.0, aquali.getIv(), (high - low) / 2.0);


    }

}