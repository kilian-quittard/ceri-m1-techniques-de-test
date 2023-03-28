package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        if(index < 0){
            throw new PokedexException("Index inférieur à 0");
        }

        PokemonMetadata pokemonMetadata = new PokemonMetadataProvider().getPokemonMetadata(index);
        int iv = (int) ((Math.random() * (100 - 0)) + 0);
        return new Pokemon(index,pokemonMetadata.getName(),pokemonMetadata.getAttack(),pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp,hp,dust,candy,iv);
    }
}
