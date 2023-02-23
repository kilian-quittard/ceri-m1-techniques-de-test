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

    @Before
    public void init() throws PokedexException {
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("L'index du pokémon n'existe pas"));
    }

    @Test
    public void exceptionMetadataTest(){
        Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
    }

    @Test
    public void getMetadataOfBulbizarreWhenIndexIs0() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(0),bulbizarreMetadata);
    }

    @Test
    public void getMetadataOfAqualiWhenIndexIs133() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetadata);
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(133),aqualiMetadata);
    }
}
