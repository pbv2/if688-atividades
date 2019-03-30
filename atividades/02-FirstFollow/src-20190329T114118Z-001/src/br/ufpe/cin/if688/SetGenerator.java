package br.ufpe.cin.if688.parsing.analysis;

import br.ufpe.cin.if688.parsing.grammar.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashMap;

import static br.ufpe.cin.if688.parsing.analysis.SpecialSymbol.EOF;
import static br.ufpe.cin.if688.parsing.analysis.SpecialSymbol.EPSILON;


public final class SetGenerator {

    public static Map<Nonterminal, Set<GeneralSymbol>> getFirst(Grammar g) {

        if (g == null) throw new NullPointerException("g nao pode ser nula.");

        Map<Nonterminal, Set<GeneralSymbol>> first = initializeNonterminalMapping(g);
        /*
         * Implemente aqui o método para retornar o conjunto first
         */
		// Mapa para auxiliar na iteração (Todos os tipos de símbolo precisam ter um conjunto FIRST, mesmo que unitário e próprio)
		Map<GeneralSymbol, Set<GeneralSymbol>> symbolFirst = new HashMap<GeneralSymbol, Set<GeneralSymbol>>();

		// Define todos os terminais e símbolos especiais como conjuntos unitários e próprios
		for (Terminal terminal : g.getTerminals()) {
			symbolFirst.put(terminal, Collections.singleton(terminal));
		}
		symbolFirst.put(SpecialSymbol.EOF, Collections.singleton(SpecialSymbol.EOF));
		symbolFirst.put(SpecialSymbol.EPSILON, Collections.singleton(SpecialSymbol.EPSILON));

		// Inicia todos os conjuntos dos não-terminais como vazios
		for (Nonterminal nonterminal : g.getNonterminals()) {
			symbolFirst.put(nonterminal, new HashSet<GeneralSymbol>());
		}

		// Auxilio na verificação de mudança dos conjuntos de FIRST
		Map<GeneralSymbol, Set<GeneralSymbol>> copy = null;

		// Auxiliares de verificação em cada produção
		Set<GeneralSymbol> rhs;
		int i, k;

		// Enquanto houver mudança nos conjuntos de FIRST
		while (!symbolFirst.equals(copy)) {
			// Copia o mapa de FIRST para o auxiliar
			copy = new HashMap<GeneralSymbol, Set<GeneralSymbol>>();
			for (Entry<GeneralSymbol, Set<GeneralSymbol>> entry : symbolFirst.entrySet()) {
				copy.put(entry.getKey(), new HashSet<GeneralSymbol>(entry.getValue()));
			}

			// Verifica se é possível atualizar algum conjunto, baseado em cada produção
			for (Production production : g.getProductions()) {
				Nonterminal nonterminal = production.getNonterminal();

				List<GeneralSymbol> symbols = production.getProduction(); // String de símbolos da produção
				GeneralSymbol firstSymbol = symbols.get(0);

				rhs = new HashSet<GeneralSymbol>();
				i = 0;
				k = symbols.size() - 1;

				// Terminais ou não-terminais
				if (firstSymbol != SpecialSymbol.EPSILON) {
					rhs.addAll(symbolFirst.get(firstSymbol));
					rhs.remove(SpecialSymbol.EPSILON);

					while (symbolFirst.get(symbols.get(i)).contains(SpecialSymbol.EPSILON) && i <= k - 1) {
						if (rhs.contains(SpecialSymbol.EPSILON)) { // Ja tinha EPSILON, então sem preocupação
							rhs.addAll(symbolFirst.get(symbols.get(i + 1)));
						} else { // Não tinha EPSILON, apenas remover para garantir
							rhs.addAll(symbolFirst.get(symbols.get(i + 1)));
							rhs.remove(SpecialSymbol.EPSILON);
						}

						i++;
					}
				}

				// Se o FIRST do último símbolo tiver EPSILON, o FIRST terá EPSILON
				if (i == k && symbolFirst.get(symbols.get(k)).contains(SpecialSymbol.EPSILON)) {
					rhs.add(SpecialSymbol.EPSILON);
				}

				// Adiciona ao mapeamento
				Set<GeneralSymbol> nonterminalFirst = symbolFirst.get(nonterminal);
				nonterminalFirst.addAll(rhs);
			}
		}

		// Põe os não-terminais e seus respectivos conjuntos FIRST no mapeamento final
		for (Entry<GeneralSymbol, Set<GeneralSymbol>> entry : symbolFirst.entrySet()) {
			GeneralSymbol symbol = entry.getKey();

			if (symbol instanceof Nonterminal) {
				first.put((Nonterminal) symbol, entry.getValue());
			}
		}

        return sortList(first);

    }
    
    public static Set <GeneralSymbol> getFirstSymbol (Set <GeneralSymbol> aux, Collection <Production> productions, GeneralSymbol symbol){
		Iterator<Production> it = productions.iterator(); 
		List <GeneralSymbol> prod_current = null;
		List<Production> prods_symbol = new ArrayList<Production>();
		while(it.hasNext()) {
			Production s = it.next();	
			if(s.getNonterminal() == symbol) {        //Pegando a lista de producoes para o Terminal
				prods_symbol.add(s);
			}
		}

		for (Production p : prods_symbol) {
			prod_current = p.getProduction();
			if (aux == null) { 
				aux = new HashSet<GeneralSymbol>();
			}
			for(int i = 0; i < prod_current.size(); i++) {

				if (prod_current.get(i) instanceof Terminal) {          //X eh um terminal / First(x) = {x}
					aux.add(prod_current.get(i));
					break;
				}
				if(prod_current.contains(SpecialSymbol.EPSILON)) {    // X -> Vazio
					aux.add(SpecialSymbol.EPSILON);
					break;
				}
				else if (prod_current.get(i) instanceof Nonterminal) {           //Se X eh um nao-terminal
					Set<GeneralSymbol> aux1 = getFirstSymbol(aux, productions, prod_current.get(i));
					if(i == prod_current.size() -1 && aux1.contains(SpecialSymbol.EPSILON) ) {   
						aux1.add(SpecialSymbol.EPSILON);
					}
					if(!aux1.remove(SpecialSymbol.EPSILON)) {    
						break;
					}
					aux.addAll(aux1);
				}

			}
		}


		return aux; 
		
	}

    public static Map<Nonterminal, Set<GeneralSymbol>> getFollow(Grammar g, Map<Nonterminal, Set<GeneralSymbol>> first) {

        if (g == null || first == null)
            throw new NullPointerException();

        Map<Nonterminal, Set<GeneralSymbol>> follow = initializeNonterminalMapping(g);
        Map<Nonterminal, Set<GeneralSymbol>> follow_aux;

        /*
         * implemente aqui o método para retornar o conjunto follow
         */
        Collection <Production> productions = g.getProductions();
		GeneralSymbol start = g.getStartSymbol();
		GeneralSymbol current = null;
		GeneralSymbol current_next = null;
		Set<GeneralSymbol> set_symb;
		Set<GeneralSymbol> bi;
		follow.get(start).add(SpecialSymbol.EOF);
		boolean change = true;
		
		while(change) {
			follow_aux = new HashMap<Nonterminal, Set<GeneralSymbol>>();
			for(Nonterminal nt:follow.keySet()) {
				set_symb = new HashSet<GeneralSymbol>();
				set_symb.addAll(follow.get(nt));
				follow_aux.put(nt, set_symb);
			}
			//baseado no algoritmo do livro  ENGINEERING A COMPILER 
			for (Production p : productions)  {
				set_symb = new HashSet<GeneralSymbol>();
				set_symb.addAll(follow.get(p.getNonterminal()));
				for(int i = p.getProduction().size()-1; i>=0;i-- ) {
					if(p.getProduction().get(i) instanceof Nonterminal) {
						follow.get(p.getProduction().get(i)).addAll(set_symb);
						if(first.get(p.getProduction().get(i)).contains(SpecialSymbol.EPSILON)) {
							bi = new HashSet<GeneralSymbol>();
							bi.addAll(first.get(p.getProduction().get(i)));
							bi.remove(SpecialSymbol.EPSILON);
							set_symb.addAll(bi);
						}else {
							set_symb = new HashSet<GeneralSymbol>();
							set_symb.addAll(first.get(p.getProduction().get(i)));
						}
					}else{
						set_symb = new HashSet<GeneralSymbol>();
						set_symb.add(p.getProduction().get(i));
						set_symb.addAll(set_symb);
					}
				
				}
				
				change = !follow.equals(follow_aux);
			
			}
			
		}
        return sortList(follow);
    }

    static private Map<Nonterminal, Set<GeneralSymbol>> sortList(Map<Nonterminal, Set<GeneralSymbol>> firstOrFollow){

        Map<Nonterminal, Set<GeneralSymbol>> sortedList = new TreeMap<Nonterminal, Set<GeneralSymbol>>(new Comparator<Nonterminal>() {
            @Override
            public int compare(Nonterminal o1, Nonterminal o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        firstOrFollow.forEach((k,v)->{
            List<GeneralSymbol> list = new ArrayList<>(v);
            Collections.sort(list, new Comparator<GeneralSymbol>() {
                @Override
                public int compare(GeneralSymbol t1, GeneralSymbol t2) {
                    return t1.toString().compareTo(t2.toString());
                }
            });
            Set<GeneralSymbol> sortedSet = new HashSet<>();
            for (GeneralSymbol gs : list){
                sortedSet.add(gs);
            }
            sortedList.put(k, sortedSet);
        });

        Map<Nonterminal, Set<GeneralSymbol>> sortedMap = new TreeMap<>(new Comparator<Nonterminal>() {
            @Override
            public int compare(Nonterminal t1, Nonterminal t2) {
                return t1.toString().compareTo(t2.toString());
            }
        });

        sortedMap = sortedList;

        return sortedMap;
    }

    //método para inicializar mapeamento nãoterminais -> conjunto de símbolos
    private static Map<Nonterminal, Set<GeneralSymbol>>
    initializeNonterminalMapping(Grammar g) {
        Map<Nonterminal, Set<GeneralSymbol>> result =
                new HashMap<Nonterminal, Set<GeneralSymbol>>();

        for (Nonterminal nt: g.getNonterminals())
            result.put(nt, new HashSet<GeneralSymbol>());

        return result;
    }

}