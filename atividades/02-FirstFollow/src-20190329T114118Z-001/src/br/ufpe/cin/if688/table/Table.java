package br.ufpe.cin.if688.table;


import br.ufpe.cin.if688.parsing.analysis.*;
import br.ufpe.cin.if688.parsing.grammar.*;

import java.util.*;
import java.util.Map.Entry;

import static br.ufpe.cin.if688.parsing.analysis.SpecialSymbol.EPSILON;


public final class Table {
    private Table() {    }

    public static Map<LL1Key, List<GeneralSymbol>> createTable(Grammar g) throws NotLL1Exception {
        if (g == null) throw new NullPointerException();

        Map<Nonterminal, Set<GeneralSymbol>> first =
                SetGenerator.getFirst(g);
        Map<Nonterminal, Set<GeneralSymbol>> follow =
                SetGenerator.getFollow(g, first);

        Map<LL1Key, List<GeneralSymbol>> parsingTable =
                new HashMap<LL1Key, List<GeneralSymbol>>();

        /*
            Implemente sua table aqui.
         */
		// Mapeamento auxiliando na identificação de células da tabela
		Map<Nonterminal, Map<GeneralSymbol, LL1Key>> mapping = new HashMap<Nonterminal, Map<GeneralSymbol, LL1Key>>();
		for (Nonterminal nonterminal : g.getNonterminals()) {
			mapping.put(nonterminal, new HashMap<GeneralSymbol, LL1Key>());

			for (Terminal terminal : g.getTerminals()) {
				LL1Key key = new LL1Key(nonterminal, terminal);

				Map<GeneralSymbol, LL1Key> row = mapping.get(nonterminal);
				row.put(terminal, key);
			}

			LL1Key key = new LL1Key(nonterminal, SpecialSymbol.EOF);

			Map<GeneralSymbol, LL1Key> row = mapping.get(nonterminal);
			row.put(SpecialSymbol.EOF, key);
		}

		// Verifica em quais células cada produção se encaixa
		for (Production production : g.getProductions()) {
			Nonterminal nonterminal = production.getNonterminal();

			Map<GeneralSymbol, LL1Key> row = mapping.get(nonterminal);
			Map<LL1Key, GeneralSymbol> cells = new HashMap<LL1Key, GeneralSymbol>(); // Guarda as células que serão preenchidas

			// Itera sobre os símbolos da produção
			List<GeneralSymbol> symbols = production.getProduction();
			for (int c = 0; c < symbols.size(); c++) {
				GeneralSymbol symbol = symbols.get(c);

				// A produção entra na célula de todos os símbolos presentes em seu FIRST
				if (symbol instanceof Terminal) {
					LL1Key cell = row.get(symbol);

					cells.put(cell, symbol);

					break; // Encerra a produção ao encontrar um terminal
				} else if (symbol instanceof Nonterminal) {
					// Em caso de não-terminal encontrado, adicionar a produção em todas as células presentes no FIRST do não-terminal
					for (GeneralSymbol symbolFirst : first.get(symbol)) {
						if (symbolFirst != SpecialSymbol.EPSILON) {
							LL1Key cell = row.get(symbolFirst);

							cells.put(cell, symbolFirst);
						} else if (c + 1 == symbols.size()) { // Caso EPSILON esteja presente, a produção é colocada em todas as células presentes no FOLLOW
							for (GeneralSymbol symbolFollow : follow.get(nonterminal)) {
								LL1Key cell = row.get(symbolFollow);

								cells.put(cell, symbolFollow);
							}
						}
					}

					if (!first.get(symbol).contains(SpecialSymbol.EPSILON)) {
						break; // Encerra a produção ao encontrar um não-terminal sem EPSILON em seu FIRST
					}
				} else { // EPSILON apenas. Coloca a produção em todas as células presentes no FOLLOW
					for (GeneralSymbol symbolFollow : follow.get(nonterminal)) {
						LL1Key cell = row.get(symbolFollow);

						cells.put(cell, symbolFollow);
					}
				}
			}
			
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println(sortTable(parsingTable));
			
			// Define as produções na parsing table
			for (Entry<LL1Key, GeneralSymbol> entry : cells.entrySet()) {
				LL1Key cell = entry.getKey();
				GeneralSymbol symbol = entry.getValue();

				if (parsingTable.containsKey(cell)) { // Caso a célula já tenha conteúdo, não será LL1
					Production production2 = new Production(nonterminal, parsingTable.get(cell));

					throw new NotLL1Exception(String.format("Table cell (%s,%s) has two productions. (%s) (%s)", nonterminal, symbol, production, production2));
				} else {
					parsingTable.put(row.get(symbol), symbols);
				}
			}
		}
        // ------------------------------ Aqui já tem os prints para voce ------------

        System.out.print(g);
        System.out.println(first);
        System.out.println(follow);
        System.out.println(sortTable(parsingTable));

        return sortTable(parsingTable);
    }


    static private Map<LL1Key, List<GeneralSymbol>> sortTable( Map<LL1Key, List<GeneralSymbol>> parsingTable) {
        // This sorts only the key, as the values in the set must be in the order of the rule
        Map<LL1Key, List<GeneralSymbol>> sortedMap = new TreeMap<LL1Key, List<GeneralSymbol>>(new Comparator<LL1Key>() {
            @Override
            public int compare(LL1Key t1, LL1Key t2) {
                return t1.toString().compareTo(t2.toString());
            }
        });

        parsingTable.forEach((k,v)->{
            sortedMap.put(k, v);
        });

        return sortedMap;
    }
}