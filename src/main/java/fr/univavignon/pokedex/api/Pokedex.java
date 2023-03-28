package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Pokedex implements IPokedex {

    public List<Pokemon> pokemons;
    public PokemonMetadataProvider pokemonMetadataProvider;
    public PokemonFactory pokemonFactory;

    public Pokedex(){
        pokemons = new ArrayList<>();
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for(Pokemon pokemon : pokemons){
            if(pokemon.getIndex() == id){
                return pokemon;
            }
        }

        throw new PokedexException("Le Pokémon n'est pas enregistré dans le pokédex");
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> pokemonList = pokemons;
        pokemonList.sort(order);

        return Collections.unmodifiableList(pokemonList);
    }

    public PokemonMetadataProvider getPokemonMetadataProvider() {
        return pokemonMetadataProvider;
    }
}
