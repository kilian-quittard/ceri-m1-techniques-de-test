package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
    /**
     * The list which contains all the captured Pokemon.
     */
    private final List<Pokemon> pokemons;
    /**
     * The pokemon factory to create pokemon.
     */
    private final IPokemonFactory pokemonFactory;
    /**
     * The metadata provider.
     */
    private final IPokemonMetadataProvider pokemonMetadataProvider;

    /**
     * @param metadataProvider PokemonMetadataProvider to add to this pokedex.
     * @param factory PokemonFactory to add to this pokedex.
     */
    public Pokedex(final IPokemonMetadataProvider metadataProvider, final IPokemonFactory factory) {
        pokemons = new ArrayList<>();
        pokemonFactory = factory;
        pokemonMetadataProvider = metadataProvider;
    }

    /**
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon in the pokedex.
     */
    @Override
    public int addPokemon(final Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size();
    }

    /**
     * @param id Pokemon ID to add.
     * @return The pokemon.
     * @throws PokedexException If given <code>index</code> does not exist.
     */
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Le Pokémon n'est pas enregistré dans le pokédex");
        }
        return pokemons.get(id);
    }

    /**
     * @return The list of pokemons captured.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    /**
     * @param order Field to order the list.
     * @return The list of pokemons captured in order.
     */
    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> pokemonList = pokemons;
        pokemonList.sort(order);
        return Collections.unmodifiableList(pokemonList);
    }

    /**
     * Creates a pokemon instance computing it IVs.
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     * @throws PokedexException If given <code>index</code> is not valid.
     */
    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp, final int dust, final int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <code>index</code>.
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If given <code>index</code> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }

    /**
     * @return Factory for pokemon creation.
     */
    public IPokemonFactory getPokemonFactory() {
        return pokemonFactory;
    }

    /**
     * @return Metadata provier for pokemon.
     */
    public IPokemonMetadataProvider getPokemonMetadataProvider() {
        return pokemonMetadataProvider;
    }
}
