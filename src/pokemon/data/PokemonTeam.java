//Pokemon Team Class
package pokemon.data;

import serialization.srsf.Lazy;

import java.util.ArrayList;
import java.util.List;

public class PokemonTeam {
    private ArrayList<Lazy<Pokemon>> pokemon;

    public PokemonTeam() {
        this(new ArrayList<Lazy<Pokemon>>());
    }
    public PokemonTeam(ArrayList<Lazy<Pokemon>> pokemon) {
        this.pokemon = pokemon;
    }

    public void switchPosition(int pos1, int pos2) {
        Lazy<Pokemon> x = pokemon.get(pos1);
        Lazy<Pokemon> y = pokemon.get(pos2);
        pokemon.set(pos2, x);
        pokemon.set(pos1, y);
    }

    public List<Pokemon> getPokemon() {
        ArrayList<Pokemon> list = new ArrayList<Pokemon>();
        for (Lazy<Pokemon> p : pokemon) {
            //add p.getValue() to a new ArrayList
            list.add(p.getValue());
        }
        //return muh array list
        return list;
    }

    public Pokemon getActivePokemon() {
        return pokemon.get(0).getValue();
    }

    public void setActivePokemon(int pos) {
        Lazy<Pokemon> x = pokemon.get(pos);
        Lazy<Pokemon> y = pokemon.get(0);
        pokemon.set(0, x);
        pokemon.set(pos, y);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (i < this.getPokemon().size()) {
                Pokemon pokemon = this.getPokemon().get(i);
                sb.append("LVL: ");
                sb.append(pokemon.getLevel());
                sb.append(" " + pokemon.getSpecies().getName());
                sb.append(System.getProperty("line.separator"));
            } else {
                sb.append("EMPTY SLOT");
                sb.append(System.getProperty("line.separator"));
            }
        }
        return sb.toString();
    }
}