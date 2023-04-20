package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {
    /**
     * Creates a pokemon instance computing it IVs.
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp, final int dust, final int candy)
            throws PokedexException {

        if(index < 0){
            throw new PokedexException("Index inférieur à 0");
        }

        PokemonMetadata pokemonMetadata = new PokemonMetadataProvider().getPokemonMetadata(index);
        int iv = (int) ((Math.random() * (100)) + 0);

        return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(),
                pokemonMetadata.getDefense(), pokemonMetadata.getStamina(),
                cp, hp, dust, candy, iv);
    }
}
