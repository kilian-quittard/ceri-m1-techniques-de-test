package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Pokedex implements IPokedex {

    public List<Pokemon> pokemons;

    public Pokedex(){
        pokemons = new ArrayList<>();
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

        Pokemon targetPokemon = null;
        for(Pokemon pokemon : pokemons){
            if(pokemon.getIndex() == id){
                targetPokemon = pokemon;
            }
        }
        if(targetPokemon == null){
            throw new PokedexException("Le Pokémon n'est pas enregistré dans le pokédex");
        }

        return targetPokemon;
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
}
