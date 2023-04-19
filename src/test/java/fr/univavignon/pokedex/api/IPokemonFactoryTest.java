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
        pokemonFactory = new RocketPokemonFactory();//new PokemonFactory();
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    }

    @Test
    public void exceptionMetadataTest(){
        Assert.assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(-1,613,64,4000,4));
    }

    @Test
    public void createBulbizarre() throws PokedexException {
        Pokemon bulbizarre2 = pokemonFactory.createPokemon(-1,613,64,4000,4);

        Assert.assertEquals(-1,bulbizarre2.getIndex());
        Assert.assertEquals(1000,bulbizarre2.getAttack());
        Assert.assertEquals(1000,bulbizarre2.getDefense());
        Assert.assertEquals(1000,bulbizarre2.getStamina());
        Assert.assertEquals(bulbizarre.getCp(),bulbizarre2.getCp());
        Assert.assertEquals(bulbizarre.getHp(),bulbizarre2.getHp());
        Assert.assertEquals(bulbizarre.getDust(),bulbizarre2.getDust());
        Assert.assertEquals(bulbizarre.getCandy(),bulbizarre2.getCandy());
        Assert.assertEquals(0, 0,0.01);

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
        Assert.assertEquals(aquali.getIv(), aquali2.getIv(),0.01);


    }

}
