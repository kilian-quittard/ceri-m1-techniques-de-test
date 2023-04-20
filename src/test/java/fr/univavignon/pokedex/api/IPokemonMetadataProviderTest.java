package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider;
    PokemonMetadata bulbizarreMetadata;
    PokemonMetadata aqualiMetadata;

    IPokemonFactory pokemonFactory;
    Pokedex pokedex;
    IPokemonMetadataProvider pokemonMetadataProvider2;

    @Before
    public void init() throws PokedexException {
        pokemonMetadataProvider = new PokemonMetadataProvider();
        bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(pokemonMetadataProvider,pokemonFactory);
        pokemonMetadataProvider2 = pokedex.getPokemonMetadataProvider();
    }

    @Test
    public void exceptionMetadataTest(){
        Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
    }

    @Test
    public void getMetadataOfBulbizarreWhenIndexIs0() throws PokedexException {
        Assert.assertEquals(0,bulbizarreMetadata.getIndex());
        Assert.assertEquals("Bulbizarre",bulbizarreMetadata.getName());
        Assert.assertEquals(126,bulbizarreMetadata.getAttack());
        Assert.assertEquals(126,bulbizarreMetadata.getDefense());
        Assert.assertEquals(90,bulbizarreMetadata.getStamina());
    }

    @Test
    public void getMetadataOfAqualiWhenIndexIs133() throws PokedexException {
        Assert.assertEquals(133,aqualiMetadata.getIndex());
        Assert.assertEquals("Aquali",aqualiMetadata.getName());
        Assert.assertEquals(186,aqualiMetadata.getAttack());
        Assert.assertEquals(168,aqualiMetadata.getDefense());
        Assert.assertEquals(260,aqualiMetadata.getStamina());
    }

    @Test
    public void getPokemonMetadataProvider() throws PokedexException {
        Assert.assertEquals(pokemonMetadataProvider,pokemonMetadataProvider2);
    }
}
